package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ManejoArchivos {

	String strNombreArchivo;
	String strNombreHoja;
	Workbook libroExcel;

	public void setNombreArchivo(String strNombreArchivo) {
		this.strNombreArchivo = strNombreArchivo;
	}

	public void setNombreHoja(String strNombreHoja) {
		this.strNombreHoja = strNombreHoja;
	}

	public void setValorCelda(int intFila, int intColumna, String strValor) {
		Sheet hojaExcel = libroExcel.getSheetAt(0);
		Row row = hojaExcel.getRow(intFila);
		Cell cell = row.createCell(intColumna);
		cell.setCellValue(strValor);
		
	}
	public void setColorCelda(int intFila, int intColumna, String strValor) {
		CellStyle style = libroExcel.createCellStyle();
	    style = libroExcel.createCellStyle();
	    style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
	    style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	    style.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
	    Sheet hojaExcel = libroExcel.getSheetAt(0);
		Row row = hojaExcel.getRow(intFila);
		Cell cell = row.createCell(intColumna);
	    cell.setCellValue(strValor);
	    cell.setCellStyle(style);
	}

	
	
//	public void colorCelda() {
//		CellStyle style = libroExcel.createCellStyle();
//	    style.setFillBackgroundColor(IndexedColors.AQUA.getIndex());
//	    style.setFillPattern(FillPatternType.BIG_SPOTS);
//	    //Cell cell = row.createCell(0);
//	    cell.setCellValue("X");
//	    cell.setCellStyle(style);
//		
//	    // Orange "foreground", foreground being the fill foreground not the font color.
//
//		
//	}

	public void fnvCrearLibroExcel() {
		libroExcel = new HSSFWorkbook();
		Sheet hojaExcel = libroExcel.createSheet(strNombreHoja);
		Row row = rowFntCrearFila(hojaExcel, 0);
		Cell cell = row.createCell(0);
		// cell.setCellValue("Título");
		row = rowFntCrearFila(hojaExcel, 1);
		cell = row.createCell(0);
		// cell.setCellValue("Valor1");
		

		
		
	}
	

	public void fnvGuardarArchivoExcel() {
		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(strNombreArchivo);
			libroExcel.write(fileOut);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileOut.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void leerArchivo() {
		try {
			FileInputStream archivoExcel = new FileInputStream(new File(strNombreArchivo));
			libroExcel = new HSSFWorkbook(archivoExcel);
		} catch (FileNotFoundException e) {
			fnvCrearLibroExcel();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static Row rowFntCrearFila(Sheet sheet, int intFila) {
		Row row = sheet.createRow((int) intFila);
		return row;
	}

}