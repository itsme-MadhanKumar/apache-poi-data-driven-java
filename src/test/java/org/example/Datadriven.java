package org.example;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
public class Datadriven
{
    public static void main(String[] args) throws IOException
    {
        //1 .Get Access to XL Sheet
        FileInputStream fileInputStream = new FileInputStream("C://Users//madha//OneDrive//Desktop//Book1.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        //2 .Get Access to sheet no :
        int sheets = workbook.getNumberOfSheets();
        for(int i = 0;i<sheets;i++)
        {
            String name  = workbook.getSheetName(i);
            if(name.equalsIgnoreCase("testdata"))
            {
               XSSFSheet sheet =  workbook.getSheetAt(i);
            }
        }
    }
}
