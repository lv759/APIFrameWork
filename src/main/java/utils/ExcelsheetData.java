package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelsheetData {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet st;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int RowCount(String xlpath,String sheetname) throws IOException {
		fi=new FileInputStream(xlpath);
		wb=new XSSFWorkbook(fi);
		st=wb.getSheet(sheetname);
		int rowt=st.getLastRowNum();
		wb.close();
		fi.close();
		return rowt;
	}
	public static int CellCount(String xlpath,String sheetname,int rownum) throws IOException {
		fi=new FileInputStream(xlpath);
		wb=new XSSFWorkbook(fi);
		st=wb.getSheet(sheetname);
		row=st.getRow(rownum);
		int cellcount=row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
	}
	public static String getcellData(String xlpath,String sheetname,int rownum,int cellnum) throws IOException {
		fi=new FileInputStream(xlpath);
		wb=new XSSFWorkbook(fi);
		st=wb.getSheet(sheetname);
		row=st.getRow(rownum);
		cell=row.getCell(cellnum);
		String data;
		try {
			DataFormatter format=new DataFormatter();
			String celldata=format.formatCellValue(cell);
			return celldata;
		}catch(Exception e){
			data="";
		}
		wb.close();
		fi.close();
		return data;
	}
	
	public static void givecelldata(String xlpath,String sheetname,int rownum,int cellnum,String data) throws IOException {
		fi=new FileInputStream(xlpath);
		wb=new XSSFWorkbook(fi);
		st=wb.getSheet(sheetname);
		row=st.getRow(rownum);
		cell=row.createCell(cellnum);
		cell.setCellValue(data);
		fo=new FileOutputStream(xlpath); 
		wb.write(fo);
		wb.close();
		fo.close();
		fi.close();

	}
}
