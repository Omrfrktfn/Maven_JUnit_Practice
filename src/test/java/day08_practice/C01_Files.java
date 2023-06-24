package day08_practice;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_Files {

    @Test
    public void test01() {

        //Masaustunde bir text dosya olusturun
        //Masaustune text dosyasinin olup olmadigni test ediniz.

       // "C:\Users\Omer \OneDrive\Masaüstü\text.txt"

      //  Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\Omer\\OneDrive\\Masaüstü\\text.txt")));

        String farkli = System.getProperty("user.home");
        String ayni = "\\OneDrive\\Masaüstü\\text.txt";

        String text = farkli+ayni;

        Assert.assertTrue(Files.exists(Paths.get(text)));

    }
}
