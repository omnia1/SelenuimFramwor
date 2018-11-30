package Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelReader {

	static FileInputStream stream=null;

	public FileInputStream getFile()
	{
		String filePath= "E:\\Testing\\cit material\\taf\\src\\test\\java\\Data\\userData.xlsx";
		//String filePath= System.getProperty("user.dir"+"/src/test/java/Data//userData.xlsx");
		File srcFile=new File(filePath);
		try {
			stream=new FileInputStream(srcFile);
		} catch (FileNotFoundException e) {
			System.out.println("Wrong Pathe for file please terminate ");
			System.exit(0);
		}
		return stream;

	}

	public Object [][] getData() throws IOException
	{
		stream = getFile();
		XSSFWorkbook wb=new XSSFWorkbook(stream);
		XSSFSheet sheet=wb.getSheetAt(0);


		int totalnumOfRows=(sheet.getLastRowNum()+1);
		int totalNumOfColum= 5 ;
		String[][] arrayexcelData=new String[totalnumOfRows][totalNumOfColum];
		for (int i = 0; i <totalnumOfRows ; i++) {
			for (int j = 0; j <totalNumOfColum; j++) {
				XSSFRow row=sheet.getRow(i);
				arrayexcelData [i][j]=row.getCell(j).toString();

			}

		}
		wb.close();
		return arrayexcelData;
	}
}
