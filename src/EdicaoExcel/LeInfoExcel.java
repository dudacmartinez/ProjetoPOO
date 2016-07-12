package EdicaoExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 * AINDA NÃO LÊ VALOR RESULTADO DE FÓRMULA!!!!
 * LEU NÚMERO E STRING DE BOA.
**/


public class LeInfoExcel {

	private Workbook workbook = new XSSFWorkbook();
	private Sheet sheet;
	
	private String valorCell;
	
	private int númeroDePropostas; 
	private List<String> listaPropostas = new ArrayList<String>();
	
	
	public LeInfoExcel(String fileURL) throws IOException{
	
		//declaração: objeto que interpreta o arquivo xls, workbook e Sheet
		FileInputStream inputStream = new FileInputStream(new File(fileURL));
		//Workbook workbook = new XSSFWorkbook(inputStream);
		workbook = new XSSFWorkbook(inputStream);
		//Sheet sheet = workbook.getSheetAt(0);
		sheet = workbook.getSheetAt(0);
				
		//workbook.close();
		
	}
	
	public void leListaPropostas(){
		
		int contadorCelulasNãoVazias = 0;
		
		int numeroColPropostas = 0;
		int startRow = 1;
		
		while(sheet.getRow(startRow + contadorCelulasNãoVazias) != null && 
				sheet.getRow(startRow + contadorCelulasNãoVazias).getCell(numeroColPropostas) != null){
			listaPropostas.add(sheet.getRow(startRow + contadorCelulasNãoVazias).getCell(numeroColPropostas).toString());
			contadorCelulasNãoVazias++;
		}
		
	}
	
	public void leCelula(int row, int cell){
		
		//Row rowLida = sheet.getRow(row);
		//System.out.println(rowLida.getLastCellNum());
		Cell cellLida = null;
			
		if(sheet.getRow(row) != null && sheet.getRow(row).getCell(cell) != null){
			cellLida = sheet.getRow(row).getCell(cell);
			valorCell = interpretaCell(cellLida,cellLida.getCellType()); //interpreta valor da celula e armazena na variavel resultado
			System.out.println(valorCell);
		}
		else{
			System.out.println("Vazio");
			valorCell = "Vazio";
		}
		
	}

	private String interpretaCell(Cell cell, int cellType) {
		
		if (Cell.CELL_TYPE_NUMERIC == cellType){   
			cell.setCellType(Cell.CELL_TYPE_STRING);
			System.out.println("Numerico");
			return cell.getStringCellValue();
		}
        else if (Cell.CELL_TYPE_STRING == cellType){
        	System.out.println("String");
        	return cell.getStringCellValue();
        }
        else if (Cell.CELL_TYPE_BOOLEAN == cellType){
        	System.out.println("Bollean");
        	return cell.getStringCellValue();
        }       
        else if (Cell.CELL_TYPE_BLANK == cellType){
        	System.out.println("Blank");
        	return "Brank";
        }        
        else if (Cell.CELL_TYPE_FORMULA == cellType){
            interpretaCell(cell, cell.getCachedFormulaResultType());
        }
        else return "Unknown cell type ";
		
		return null;	
	}
	
	public int getNúmeroDePropostas(){
		return númeroDePropostas;
	}
		
	public String getValorString() {
		return valorCell;
	}
	
	public List<String> getListaProposta(){
		return listaPropostas;
	}
}
