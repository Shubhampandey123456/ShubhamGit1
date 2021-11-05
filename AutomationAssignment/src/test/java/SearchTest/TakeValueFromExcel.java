package SearchTest;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TakeValueFromExcel {
	
	
	static XSSFWorkbook work;
	static XSSFSheet sheet;

	public static void main(String[] args) {
		

	}
	
	public TakeValueFromExcel(String excelPath,String Sheetname)
	{
		try
		{
			
			work=new XSSFWorkbook(excelPath);
			sheet=work.getSheet(Sheetname);
		}
		catch(Exception exp)
		{
			exp.getStackTrace();
		}	
	}
	
	public static Object getData(int rowNum,int colNum)
	{
		String searchValue = "";
		try {
			searchValue=sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			
		}
		catch(Exception ex)
		{
			ex.getMessage();
		}
		return searchValue;	
	}

}
