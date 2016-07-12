package GUI;

import java.util.LinkedList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import EstruturaProposta.DisjuntorMotor;

public class PanelItens extends JTabbedPane {

	private static final long serialVersionUID = 1L;
	
	private JPanel primeiroTabPanel;
	private JPanel segundoTabPanel;
	private JPanel terceiroTabPanel;
	
	public JTable tblDisjuntoresMotor;
	private JScrollPane tblScrollDisjuntoresMotor;
	private DefaultTableModel tblModelDisjuntoresMotor;
	private String[] tblColunasDisjuntoresMotor = {"ID","Descrição","Corrente","Ajuste","Modelo","Tamanho","Icc 220Vca","Icc 380Vca","Icc 440/460Vca","Icc 500Vca"};
	
	private static final String nomeTabDisjuntoresMotor = "Disj. Motor";
	private static final String nomeTabContatores = "Cont. de Pot.";
	private static final String nomeTabMiniDisjuntores = "Mini Disjuntores";
	
	public PanelItens() {

		setBounds(10, 344, 814, 124);
		
		tblModelDisjuntoresMotor = new DefaultTableModel(){
			
			private static final long serialVersionUID = 1L;
			
			@Override
			public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		};
		
		for(String nomeColunas : tblColunasDisjuntoresMotor){
			tblModelDisjuntoresMotor.addColumn(nomeColunas);
		}
		
		tblDisjuntoresMotor = new JTable(tblModelDisjuntoresMotor);
	
		tblDisjuntoresMotor.getColumnModel().getColumn(0).setPreferredWidth(5);
		tblDisjuntoresMotor.getColumnModel().getColumn(1).setPreferredWidth(50);
		tblDisjuntoresMotor.getColumnModel().getColumn(2).setPreferredWidth(10);
		tblDisjuntoresMotor.getColumnModel().getColumn(3).setPreferredWidth(10);
		tblDisjuntoresMotor.getColumnModel().getColumn(4).setPreferredWidth(10);
		tblDisjuntoresMotor.getColumnModel().getColumn(5).setPreferredWidth(10);
		tblDisjuntoresMotor.getColumnModel().getColumn(6).setPreferredWidth(10);
		tblDisjuntoresMotor.getColumnModel().getColumn(7).setPreferredWidth(10);
		tblDisjuntoresMotor.getColumnModel().getColumn(8).setPreferredWidth(10);
		tblDisjuntoresMotor.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tblScrollDisjuntoresMotor = new JScrollPane(tblDisjuntoresMotor);
		tblScrollDisjuntoresMotor.setBounds(0, 0, 809, 96);
		
		primeiroTabPanel = new JPanel();
		primeiroTabPanel.setLayout(null);

		
		primeiroTabPanel.add(tblScrollDisjuntoresMotor);
		//primeiroTabPanel.setBackground(Color.RED);
		
		
		segundoTabPanel = new JPanel();
		terceiroTabPanel = new JPanel();
		
		
		
		//setBounds(10, 344, 814, 124);
		add(nomeTabDisjuntoresMotor,primeiroTabPanel);
		add(nomeTabContatores,segundoTabPanel);
		add(nomeTabMiniDisjuntores,terceiroTabPanel);

	}

	public void atualizaListModelDisjuntoresMotor(LinkedList<DisjuntorMotor> listaDisjuntoresMotor){
		
		tblModelDisjuntoresMotor.setRowCount(0);
		
		for(int i=0; i<listaDisjuntoresMotor.size();i++){
			Object[] linhaAdicionada = {listaDisjuntoresMotor.get(i).getID(),
										listaDisjuntoresMotor.get(i).getDescricao(),
										listaDisjuntoresMotor.get(i).getSobrecorrente(),
										listaDisjuntoresMotor.get(i).getSobrecorrenteMin()+" - "+listaDisjuntoresMotor.get(i).getSobrecorrente(),
										listaDisjuntoresMotor.get(i).getModelo(),
										listaDisjuntoresMotor.get(i).getTamanho(),
										listaDisjuntoresMotor.get(i).getIcc220(),
										listaDisjuntoresMotor.get(i).getIcc380(),
										listaDisjuntoresMotor.get(i).getIcc460(),
										listaDisjuntoresMotor.get(i).getIcc500()};
			tblModelDisjuntoresMotor.addRow(linhaAdicionada);
		}
	}
	
	public void limpaListModelDisjuntoresMotor(){
		this.tblModelDisjuntoresMotor.setRowCount(0);
	}
	
	public void filterDisjuntoresMotor(String query){
		
		TableRowSorter<DefaultTableModel> tblSorterDisjuntoresMotor = new TableRowSorter<DefaultTableModel>(tblModelDisjuntoresMotor);
		tblDisjuntoresMotor.setRowSorter(tblSorterDisjuntoresMotor);
		RowFilter<Object, Object> rowFilter = RowFilter.regexFilter("(?i)"+query,1);
		tblSorterDisjuntoresMotor.setRowFilter(rowFilter);
		
	}
	
}
