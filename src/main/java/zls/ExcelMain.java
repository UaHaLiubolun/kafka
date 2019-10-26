package zls;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class ExcelMain {

    private File file;

    /**
     * name address week
     */
    private Map<String, Map<String, Map<String, List<String>>>> result = new HashMap<>();

    private Pattern pattern = Pattern.compile("\\d+:\\d+");

    private SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");

    private String[] timeInterval = {"7:50-8:20", "08:35-08:40", "09:20-09:28", "10:08-10:46", "11:26-11:40", "12:15-13:00", "14:00-14:08", "14:48-15:00", "15:40-18:00"};

    public ExcelMain(File file) {
        this.file = file;
    }

    private void run() {
        Workbook workbook = getWorkBook();
        Sheet sheet = workbook.getSheetAt(0);
        int endRow = sheet.getLastRowNum() + 10;
        for (int i = 1; i < endRow; i++) {
            Row row = sheet.getRow(i);
            if (row == null) break;
            Cell addressCell = row.getCell(0);
            if (addressCell == null) {
                break;
            }
            String address = addressCell.getStringCellValue();
            String[] sssss = address.split("\n");
            address = sssss[0];
            for (int j = 1; j < 6; j++) {
                String card = row.getCell(j).getStringCellValue();
                if (!StringUtils.isBlank(card)) {
                    String[] cards = card.split("\n");
                    String currentName = "";
                    for (String s : cards) {
                        if (StringUtils.isBlank(s)) continue;
                        if (!pattern.matcher(s).find()) {
                            currentName = s;
                        } else {
                            Map<String, Map<String, List<String>>> nameMap = result.computeIfAbsent(currentName, o -> new HashMap<>());
                            Map<String, List<String>> weekMap = nameMap.computeIfAbsent(address, o -> new HashMap<>());
                            List<String> cardList = weekMap.computeIfAbsent(String.valueOf(j), o -> new LinkedList<>());
                            cardList.add(s);
                        }
                    }
                }
            }
        }
        System.out.println(endRow);
        create();
    }

    private void create() {
        HSSFWorkbook workbook = new HSSFWorkbook();
        Sheet nanSheel = workbook.createSheet("南区");
        Sheet beiSheet = workbook.createSheet("北区");
        createHead(beiSheet);
        createHead(nanSheel);
        int nanCount = 2;
        int beiCount = 2;
        for (Map.Entry<String, Map<String, Map<String, List<String>>>> nameEntry : result.entrySet()){
            for (Map.Entry<String, Map<String, List<String>>> addressEntry : nameEntry.getValue().entrySet()) {
                Row row;
                if (addressEntry.getKey().contains("北区")) {
                    row = beiSheet.createRow(beiCount);
                    beiCount ++;
                } else {
                    row = nanSheel.createRow(nanCount);
                    nanCount++;
                }
                Cell nameCell = row.createCell(0);
                nameCell.setCellValue(nameEntry.getKey());
                Cell addressCell = row.createCell(1);
                addressCell.setCellValue(addressEntry.getKey());

                for (Map.Entry<String, List<String>> weekList : addressEntry.getValue().entrySet()) {
                    int week = Integer.parseInt(weekList.getKey());
                    for (String s : weekList.getValue()) {
                        int cardC = isCard(s);
                        if (cardC == -1) {
                            continue;
                        }
                        Cell cell = row.createCell((week - 1) * 9 + cardC + 2);
                        cell.setCellValue(1);
                    }
                }
            }
        }
        write(workbook);
    }

    private void createHead(Sheet sheet) {
        sheet.setColumnWidth(1, 30*256);
        for (int i = 2; i < 60; i++) {
            sheet.setColumnWidth(i, 15*256);
        }
        Row rowWeek = sheet.createRow(0);
        Row rowTitle = sheet.createRow(1);
        rowTitle.createCell(0).setCellValue("值周老师");
        rowTitle.createCell(1).setCellValue("值周点位");
        for (int k = 0; k < 5; k++) {
            rowWeek.createCell(k * 9 + 2).setCellValue("星期");
            for (int j = 0; j < timeInterval.length; j++) {
                rowTitle.createCell(k * 9 + j + 2).setCellValue(timeInterval[j]);
            }
        }
    }

    private int isCard(String time) {
        try {
            int i = 0;
            for (String s : timeInterval) {
                String[] ts = s.split("-");
                if (dateFormat.parse(time).getTime() >= dateFormat.parse(ts[0]).getTime() &&
                        dateFormat.parse(time).getTime() <= dateFormat.parse(ts[1]).getTime()) {
                    return i;
                }
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    private void write(Workbook workbook) {
        try (FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Jhon\\Downloads\\test\\test1.xls")){
            workbook.write(outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Workbook getWorkBook() {
        //获得文件名
        String fileName = file.getName();
        //创建Workbook工作薄对象，表示整个excel
        Workbook workbook = null;
        try {
            //获取excel文件的io流
            InputStream is = new FileInputStream(file);
            //根据文件后缀名不同(xls和xlsx)获得不同的Workbook实现类对象
            if(fileName.endsWith("xls")){
                //2003
                workbook = new HSSFWorkbook(is);
            }else if(fileName.endsWith("xlxs")){
                //2007
                workbook = new XSSFWorkbook(is);
            }
        } catch (IOException e) {
           e.printStackTrace();
        }
        return workbook;
    }

    public static void main(String[] args) {
        ExcelMain excelMain = new ExcelMain(new File("C:\\Users\\Jhon\\Downloads\\第8周巡检记录.xls"));
        excelMain.run();
    }
}
