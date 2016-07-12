package GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Scanner;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import EstruturaProposta.Painel;

public class JOptionPaneFormPainel {
	
	private Painel novoPainel = new Painel();

	public void display(){
		
		String[] aplicações = {"QGBT","CCM","BC","QD","UPS","QTA","QDF"};
		String[] tensõesAlimentaçãoFaseFase = {"220","380","440","460","500"};
		String[] numFases = {"1","2","3"};
		
		JLabel label;
		JComboBox<String> comboBoxTensoesAlimentação;
		JComboBox<String> comboBoxAplicacoes;
		JComboBox<String> comboBoxNumeroDeFases;
		JTextField textFieldCorrenteBarramento;
		JTextField textFieldCorrenteCurtoCircuito;
		JTextField textFieldTAG;
		JCheckBox checkBoxTTA;
		JCheckBox checkBoxCompartimentado;
		JCheckBox checkBoxTemDPS;
		JCheckBox checkBoxTemMedicao;
		
		
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		label = new JLabel("TAG:");
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(label, c);
		
		textFieldTAG = new JTextField();
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 2;
		c.gridx = 1;
		c.gridy = 0;
		panel.add(textFieldTAG, c);
		
		label = new JLabel("Aplicação:");
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(label, c);
		
		comboBoxAplicacoes = new JComboBox<String>(aplicações);
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		panel.add(comboBoxAplicacoes, c);
		
		///////////////////////
		label = new JLabel("Tensão Alimentação Fase-Fase:");
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		panel.add(label, c);
		
		comboBoxTensoesAlimentação = new JComboBox<String>(tensõesAlimentaçãoFaseFase);
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		panel.add(comboBoxTensoesAlimentação, c);
		
		label = new JLabel("Número de Fases: ");
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 3;
		panel.add(label, c);
		
		comboBoxNumeroDeFases = new JComboBox<String>(numFases);
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 3;
		panel.add(comboBoxNumeroDeFases, c);
		////////////////////////////
		checkBoxTTA = new JCheckBox("TTA");
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 4;
		panel.add(checkBoxTTA, c);
		
		checkBoxCompartimentado = new JCheckBox("Compartimentado");
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 4;
		panel.add(checkBoxCompartimentado, c);
		
		checkBoxTemDPS = new JCheckBox("Tem DPS");
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 5;
		panel.add(checkBoxTemDPS, c);
		
		checkBoxTemMedicao = new JCheckBox("Tem Medição");
		c.weightx = 0.5;
		//c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 5;
		panel.add(checkBoxTemMedicao, c);
		
		label = new JLabel("Corrente de Barramento:");
		c.weightx = 0.5;
		//c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 6;
		panel.add(label, c);
		
		textFieldCorrenteBarramento = new JTextField();
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 2;
		c.gridx = 1;
		c.gridy = 6;
		panel.add(textFieldCorrenteBarramento, c);
		
		label = new JLabel("Corrente de Curto-Circuito:");
		c.weightx = 0.5;
		//c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 7;
		panel.add(label, c);
		
		textFieldCorrenteCurtoCircuito = new JTextField();
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 2;
		c.gridx = 1;
		c.gridy = 7;
		panel.add(textFieldCorrenteCurtoCircuito, c);
		
		int result = JOptionPane.showConfirmDialog(null, panel, "Novo Painel",
	            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		
		if (result == JOptionPane.OK_OPTION) {

			if (isInteger(textFieldCorrenteBarramento.getText(),10) && 
					textFieldTAG.getText() != null &&
					isInteger(textFieldCorrenteCurtoCircuito.getText(),10)){
				this.novoPainel = new Painel(textFieldTAG.getText(),aplicações[comboBoxAplicacoes.getSelectedIndex()],
												Integer.parseInt(tensõesAlimentaçãoFaseFase[comboBoxTensoesAlimentação.getSelectedIndex()]),
												Integer.parseInt(numFases[comboBoxNumeroDeFases.getSelectedIndex()]),
												checkBoxTTA.isSelected(), checkBoxTemMedicao.isSelected(),
												checkBoxTemDPS.isSelected(),checkBoxCompartimentado.isSelected(),
												Integer.parseInt(textFieldCorrenteBarramento.getText()),
												Integer.parseInt(textFieldCorrenteBarramento.getText()));
			}else{
				System.out.println("Por favor, insira um número inteiro para a Corrente de Barramento, "
						+ "Corrente de Curto Circuito e dê um TAG ao painel!");
			}
        } else {
            System.out.println("Cancelled");
        }
		
	}
	
	public Painel getNovoPainel(){
		return this.novoPainel;
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