package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ReusableMethods {

    WebDriver driver ;

    public ReusableMethods(WebDriver driver){
        this.driver = driver ;
    }
    public static String currentDir = System.getProperty("user.dir");

    public Cell dataFetching(int row, int column)  {
        String excelFilePath=currentDir+"\\src\\test\\java\\DataPackage\\Data.xlsx";
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(excelFilePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Workbook workbook= null;
        try {
            workbook = WorkbookFactory.create(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return workbook.getSheet("data").getRow(row).getCell(column);
    }

    public void writeTestResults(List<String> results) {
        String excelFilePath=currentDir+"\\src\\test\\java\\DataPackage\\VatanComputer.xlsx";
        String sheetName = "Test Status";

        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet(sheetName);

            int rowNumber = 0;
            for (String result : results) {
                Row row = sheet.createRow(rowNumber++);
                Cell cell = row.createCell(0);
                cell.setCellValue(result);
            }

            FileOutputStream outputStream = new FileOutputStream(excelFilePath);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public WebElement waitTheElement(WebElement element){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public  void writeOnTheTxtFile(String text) {
        try {
            BufferedWriter writer=new BufferedWriter(new FileWriter(currentDir+"\\src\\test\\java\\DataPackage\\testStatus.txt",true));
            writer.newLine();
            writer.write(text);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public List<String> readingTxtFile() {
        File file1=new File(currentDir+"\\src\\test\\java\\DataPackage\\testStatus.txt");
        List<String> lines=new ArrayList<>();
        try {
            Scanner reader=new Scanner(file1);
            while (reader.hasNextLine())
            {
                String line=reader.nextLine();
                lines.add(line);

            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }

    public void jsClick(WebElement element){
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));
        WebElement clickElement1=wait.until(ExpectedConditions.visibilityOf(element));
        JavascriptExecutor jse=(JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click();",element);

    }

    public void hardWait(int time){
        try {
            Thread.sleep(time* 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void explicitlyWaiting(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }


}
