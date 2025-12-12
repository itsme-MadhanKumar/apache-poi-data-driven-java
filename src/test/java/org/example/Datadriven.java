package org.example;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
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
               XSSFSheet sheet =  workbook.getSheetAt(i); // setting sheet to work book
               Iterator<Row> rows = sheet.iterator(); // getting all rows using iterator
               Row row = rows.next(); // moving to 1st row
                Iterator<Cell> cell =  row.cellIterator(); // in that 1st row getting all cells
                int k = 0;
                int coloum = 0;
                while (cell.hasNext())
                {
                    Cell value = cell.next(); // moving to 1st cell
                    String coloumname = value.getStringCellValue(); // getting current cell name
                    if(coloumname.equalsIgnoreCase("Testcases"))
                    {
                        //get data
                        coloum = k;
                    }
                    k++;
                }
                System.out.println(coloum);

//                =============================
                while (rows.hasNext())
                {
                   Row r = rows.next();
                   if(r.getCell(coloum).getStringCellValue().equalsIgnoreCase("Purchase"))
                   {
                       Iterator<Cell> cv = r.cellIterator();
                       while (cv.hasNext())
                       {
                           System.out.println(cv.next().getStringCellValue());
                       }
                   }
                }

            }

        }
    }
}
