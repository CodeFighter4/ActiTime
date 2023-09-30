package com.ActiTime.GenericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * this class is generic class which contains non static to read data from property and excel file
 * @author Prasad 
 *
 */
public class FileLibrary {
	/**
	 * 
	 * @param Key
	 * @return
	 * @throws IOException
	 */

public String readDataFromPropertyFile( String Key) throws IOException {
	FileInputStream fis =new FileInputStream("./Testdata/commondata.property");
	Properties p = new Properties();
	p.load(fis);
	String value = p.getProperty(Key);
	return value;
	
}
/**
 * this method is a non static method is used to read data from excel sheet
 * @param Sheet
 * @param row
 * @param cell
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public String readDataFromExcel(String Sheet,int row ,int cell) throws EncryptedDocumentException, IOException {
	FileInputStream fis = new FileInputStream("./Testdata/BankingInfo.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	String value = wb.getSheet(Sheet).getRow(row).getCell(cell).getStringCellValue();
	return value;
	
	
}

}
