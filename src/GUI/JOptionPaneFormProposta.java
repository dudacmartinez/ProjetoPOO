package GUI;

//import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.Scanner;

import javax.swing.*;

import EstruturaProposta.Proposta;

public class JOptionPaneFormProposta {

	private Proposta novaProposta = new Proposta();

	public void display(){

		JTextField campoNome = new JTextField("");
		JTextField campoCadastro = new JTextField("");
		JTextField campoRevisao = new JTextField("");
		JPanel panel = new JPanel(new GridLayout(0, 1));
		panel.add(new JLabel("Nome:"));
		panel.add(campoNome);
		panel.add(new JLabel("Cadastro:"));
		panel.add(campoCadastro);
		panel.add(new JLabel("Revisão:"));
		panel.add(campoRevisao);
		int result = JOptionPane.showConfirmDialog(null, panel, "Nova Proposta",
	            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {
			
			if (isInteger(campoRevisao.getText(),10)){
				this.novaProposta = new Proposta(campoNome.getText(),campoCadastro.getText(),
						Integer.parseInt(campoRevisao.getText()));
			}else System.out.println("Por favor insira um número inteiro para a Revisão!!");			
        
		}else System.out.println("Cancelled");
	}
	
	public Proposta getNovaProposta(){
		return this.novaProposta;
	}
	
	@SuppressWarnings("resource")
	public static boolean isInteger(String s, int radix) {
	    Scanner sc = new Scanner(s.trim());
	    if(!sc.hasNextInt(radix)){
	    	return false;
	    }
	    sc.nextInt(radix);
	    return !sc.hasNext();
	}
}
