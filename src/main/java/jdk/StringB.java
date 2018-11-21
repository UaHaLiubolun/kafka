package jdk;

public class StringB {

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append("ab");
        String s = sb.toString();
        sb.append("cds");
        System.out.println(s);
    }
}
