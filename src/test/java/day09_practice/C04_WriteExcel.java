package day09_practice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C04_WriteExcel {

    @Test
    public void test01() throws IOException {
        //ulkeler dosyasindaki 0.satir index'in , 4.index'ine yeni bir cell olusturalim
        //olusturdugumuz hucreye "Nufus" yazdiralim

        String path = "src/resourcess/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(path);
        Workbook wb = WorkbookFactory.create(fis);

        wb.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("Nufus");
        wb.getSheet("Sayfa1").getRow(1).createCell(4).setCellValue("15000");
        wb.getSheet("Sayfa1").getRow(2).createCell(4).setCellValue("16000");
        wb.getSheet("Sayfa1").getRow(3).createCell(4).setCellValue("17000");
        wb.getSheet("Sayfa1").getRow(4).createCell(4).setCellValue("18000");


        FileOutputStream fos = new FileOutputStream(path);
        wb.write(fos);




    }
}
