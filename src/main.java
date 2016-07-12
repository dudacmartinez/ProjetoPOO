//import EdicaoExcel.LeInfoExcel;
//import EstruturaProposta.Painel;
//import EstruturaProposta.Proposta;

//import java.io.IOException;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {

		//Proposta proposta1 = new Proposta((String)"Evonik");
		//Painel novoPainel = new Painel("QGBT");
		//System.out.println(novoPainel.getTAG());
		//proposta1.adicionaPainel(novoPainel);
		//System.out.println(proposta1.getPainelByIndex(0).getTAG());
		Scanner scanner = new Scanner(System.in);
		String nome;
		System.out.println("Escreva seu nome: ");
		nome = scanner.nextLine(); 
		System.out.println("Seu nome é: " + nome);
		//System.out.println("Eduardo");
		
		/**int row, col;
		String filename = "Propostas.xlsx";
		
		for (row=0; row<3; row++){
			for (col=0; col<3;col++){
				LeCelulaExcel proposta1 = new LeCelulaExcel(filename, row, col);
				System.out.println(proposta1.getValorString());
			}
		}
		
		**/

	}

}
