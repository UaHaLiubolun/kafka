package common.pool;

import org.apache.commons.pool2.ObjectPool;

import java.io.IOException;
import java.io.Reader;

public class ReaderUtil {

    private ObjectPool<StringBuffer> pool;

    public ReaderUtil(ObjectPool<StringBuffer> pool) {
        this.pool = pool;
    }

    public String readToString(Reader in) throws IOException {
        StringBuffer buffer = null;
        try {
            buffer = pool.borrowObject();
            for (int c = in.read(); c != -1; c = in.read()) {
                buffer.append((char) c);
            }
            return buffer.toString();
        } catch (IOException e) {
            throw e;
        } catch (Exception e) {
            throw  new RuntimeException("Unable to borrow from pool " + e.toString());
        } finally {
            try {
                in.close();
            } catch (Exception e) {

            }

            try {
                if (null != buffer) {
                    pool.returnObject(buffer);
                }
            } catch (Exception e) {

            }
        }
    }
}
