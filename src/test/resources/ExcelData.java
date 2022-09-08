import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;

public class ExcelData {

	public static String getExcelData(String sheetName,int row,int cell)
	{
		DataFormatter format = new DataFormatter();
		FileInputStream fis = new FileInputStream("D:\Test Data\Test Data.xlsx");
		Workbook book = new WorkbookFactory.create(fis);
		Sheet sh = new Sheet(sheetName);
		String s = format.formatCellValue(sh.getRow(row).getCell(cell));
		return s;
		
	}
}
