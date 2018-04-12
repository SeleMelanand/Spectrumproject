package spectrum.endtoendflow.loancreation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Excelreadwrite {

	@Test
	public void excelreadandwrite() throws IOException {

		String nameoffile, reqfilename;
		File folder;
		try {
			folder = new File("D:\\testfolder1");
			File[] listoffiles = folder.listFiles();
			int filecount = listoffiles.length;
			ArrayList<String> filenames = new ArrayList<String>();
			
			System.out.println("# of files present: "+filecount);
			for (File file : listoffiles) {
				if (file.isFile()) {
					nameoffile = file.getName();
					int namelength = nameoffile.length();
					String textvalue = nameoffile.substring(namelength -4);
					if (textvalue.equalsIgnoreCase(".txt")) {
						SimpleDateFormat sdf = new SimpleDateFormat();
						String datetime = sdf.format(file.lastModified());
						reqfilename =nameoffile +":   "+ datetime;
						filenames.add(reqfilename);		
						
					}
				}
			}
			
			for(int i=0;i<filenames.size();i++){
				System.out.println(filenames.get(i));
			}
			
		} 
		

		catch (Exception e) {

			System.out.println("File not available");
		}
		finally{
			System.out.println("Fnally block is executed");
		}

		int i=10;
		int j=0;
		try {
			int k=i/j;
			System.out.println(k);
		} 
		
		catch (ArithmeticException ae) {
			System.out.println("Exception occured - "+ae);
		}

		catch (Exception e) {
			System.out.println("Exception occured - "+e);
		}
		
		
		/*
		 * for(int i=0;i<filecount;i++ ){ if(listoffiles[i].isFile()){
		 * System.out.println(listoffiles[i].getName()); } else{
		 * System.out.println(listoffiles[i].getName()); } }
		 */
		/*
		 * FileInputStream fis = new
		 * FileInputStream("./testdata/loandetails.xlsx"); XSSFWorkbook workbook
		 * = new XSSFWorkbook(fis); XSSFSheet worksheet =
		 * workbook.getSheet("Sheet1"); XSSFRow row = worksheet.getRow(0); int
		 * columncount = row.getLastCellNum(); System.out.println(
		 * "total number of column is :" + columncount);
		 * 
		 * int rowcount = worksheet.getLastRowNum(); System.out.println(
		 * "Total number of rows:" + (rowcount + 1));
		 * 
		 * String value = row.getCell(0).getStringCellValue();
		 * System.out.println(value);
		 * 
		 * for (int i = 0; i < rowcount; i++) { for (int j = 0; j < columncount;
		 * j++) {
		 * 
		 * if(worksheet.getRow(i).getCell(j).getCellTypeEnum().equals("String"))
		 * { String value1 = row.getCell(j).getStringCellValue();
		 * System.out.println(value1); }else{ double value2 =
		 * row.getCell(j).getNumericCellValue(); System.out.println(value2); }
		 * 
		 * 
		 * 
		 * }
		 * 
		 * }
		 * 
		 * }
		 */

	}
}
