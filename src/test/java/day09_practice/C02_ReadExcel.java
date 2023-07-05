package day09_practice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class C02_ReadExcel {

    @Test
    public void test01() throws IOException {
        //ulkeler dosyasindaki baskent ingilizce sutununu yazdiriniz.

        //   String path = "src/resourcess/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream("src/resourcess/ulkeler.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);

        int sonSatirNo = workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println(sonSatirNo);

        List<String> baskentler = new ArrayList<>();
        for (int i = 0; i <= sonSatirNo; i++) {
            String ingBaskent = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString();
            System.out.println(ingBaskent);
        }

/*
        //C01_ReadExcel class'indaki methodu baska classlarda kullanabilmek icin static yapmak zorundayiz.
        //Boylece method'u class ismi ile cagirabiliriz.

        for (int i = 0; i <= sonSatirNo; i++) {
            String satirdakiData = C01_ReadExcel.banaDataGetir(i, 1);
            System.out.println(satirdakiData);
        }

 */
    }
}
