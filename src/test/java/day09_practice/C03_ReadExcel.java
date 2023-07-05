package day09_practice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C03_ReadExcel {

    @Test
    public void test01() throws IOException {
        //ulkeler dosyasindaki tum datalari

        Map<String, String> map = new HashMap<>();

        String path = "src/resourcess/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(path);
        Workbook wb = WorkbookFactory.create(fis);

        int sonStrNmr = wb.getSheet("Sayfa1").getLastRowNum();

        for (int i = 0; i < sonStrNmr; i++) {

            String key = wb.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            String value = wb.getSheet("Sayfa1").getRow(i).getCell(1).toString() + ","
                    + wb.getSheet("Sayfa1").getRow(i).getCell(2).toString() + ","
                    + wb.getSheet("Sayfa1").getRow(i).getCell(3).toString();

            map.put(key, value+"\n");
        }
        System.out.println(map);
    }
}
