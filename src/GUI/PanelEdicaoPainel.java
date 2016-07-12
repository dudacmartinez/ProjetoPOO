package GUI;

import java.util.LinkedList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import EstruturaProposta.*;
import Resultado.PropostaEditada;
import Sqlite.*;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;

public class PanelEdicaoPainel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel labelListaConjuntos;
	private JLabel labelListaItens;
	private LinkedList<Item> listaItens;
	
	private JButton btnAdicionarConjunto;
	private JButton btnCriarConjunto;
	private JButton btnEditarConjunto;
	private JButton btnVoltar;
	private JButton btnAdicionarItem;
	private JButton btnFinalizarPainel;
	
	private PanelItens panelItens;

	//private JComboBox<String> comboBoxItens;
	//private String[] comboBoxNomeItens = {"Disjuntor Motor ","Contator de Potência"};
	
	private JTextField textListFiltro;
	
	private JTable tblItens;
	private JScrollPane tblScrollPaneItens;
	private DefaultTableModel tblModelItens;
	private String[] tblColunasItens = {"Descrição","Modelo","Quantidade","Fabricante","Conjunto"};

	private JTable tblConjuntos;
	private JScrollPane tblScrollPaneConjuntos;
	private DefaultTableModel tblModelConjuntos;
	private String[] tblColunasConjuntos = {"ID","Nome"};
	
	//private JTextField textField;
	
	private Connection DBcon;
	
	private Painel painelSelecionado;
	
	public PanelEdicaoPainel(CardLayout cardLayout, JPanel panel) {

		DBcon = sqliteConnection.getConnection();
		
		painelSelecionado = PropostaEditada.getPainelSelecionado();
		
		setLayout(null);		
		
		tblModelItens = new DefaultTableModel(){
			
			private static final long serialVersionUID = 1L;
			
			@Override
			public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		};
		for(String nomeColunas : tblColunasItens){
			tblModelItens.addColumn(nomeColunas);
		}
		
		tblItens = new JTable(this.tblModelItens);
		tblItens.getColumnModel().getColumn(0).setPreferredWidth(100);
		tblItens.getColumnModel().getColumn(1).setPreferredWidth(20);
		tblItens.getColumnModel().getColumn(2).setPreferredWidth(10);
		tblItens.getColumnModel().getColumn(3).setPreferredWidth(30);
		tblItens.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tblScrollPaneItens = new JScrollPane(this.tblItens);
		tblScrollPaneItens.setBounds(310, 35, 432, 239);
		add(tblScrollPaneItens);
	
		
		tblModelConjuntos = new DefaultTableModel(){
			
			private static final long serialVersionUID = 1L;
			
			@Override
			public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		};
		for(String nomeColunas : tblColunasConjuntos){
			tblModelConjuntos.addColumn(nomeColunas);
		}

		tblConjuntos = new JTable(this.tblModelConjuntos);
		tblConjuntos.getColumnModel().getColumn(0).setPreferredWidth(10);
		tblConjuntos.getColumnModel().getColumn(1).setPreferredWidth(90);
		tblConjuntos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tblScrollPaneConjuntos = new JScrollPane(tblConjuntos);
		tblScrollPaneConjuntos.setBounds(10, 35, 232, 239);
		add(tblScrollPaneConjuntos);

		
		labelListaItens = new JLabel("Lista de itens do painel");
		labelListaItens.setBounds(310, 16, 200, 14);
		add(labelListaItens);
		
		labelListaConjuntos = new JLabel("Lista de conjuntos da proposta");
		labelListaConjuntos.setBounds(10, 16, 200, 14);
		add(labelListaConjuntos);
		
		btnAdicionarConjunto = new JButton("Adicionar >");
		btnAdicionarConjunto.setBounds(200, 150, 131, 23);
		add(btnAdicionarConjunto);
		
		btnCriarConjunto = new JButton("Criar novo conjunto");
		btnCriarConjunto.setBounds(10, 280, 169, 23);
		add(btnCriarConjunto);

		btnEditarConjunto = new JButton("Editar conjunto");
		btnEditarConjunto.setBounds(10, 310, 169, 23);
		add(btnEditarConjunto);
		
		btnAdicionarItem = new JButton("Adicionar item");
		btnAdicionarItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				int itemIndex = panelItens.tblDisjuntoresMotor.getSelectedRow();
				
				if (itemIndex == -1){
					JOptionPane.showMessageDialog(null,"Selecione item a ser adicionado!");
				}
				else {
					
					Item novoItem = new Item(listaItens.get(itemIndex).getDescrição(),
											listaItens.get(itemIndex).getModelo(),
											listaItens.get(itemIndex).getQuantidade(),
											listaItens.get(itemIndex).getFabricante(),
											listaItens.get(itemIndex).getTipo(),
											listaItens.get(itemIndex).getConjunto());
					
					try {
						EditarDBs.adicionarItem(DBcon, novoItem, painelSelecionado);
						atualizaListModelEdicaoPainel(listaItens);
					} catch (IOException | SQLException e) {
						e.printStackTrace();
					}

				}
				
			}
		});
		btnAdicionarItem.setBounds(631, 326, 169, 23);
		add(this.btnAdicionarItem);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(10, 477, 89, 23);
		add(this.btnVoltar);

		btnFinalizarPainel = new JButton("Finalizar Painel");
		btnFinalizarPainel.setBounds(693, 477, 131, 23);
		add(this.btnFinalizarPainel);
		
		this.textListFiltro = new JTextField();
		
		textListFiltro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String query = textListFiltro.getText();
				
				panelItens.filterDisjuntoresMotor(query);
			}
		});
		
		textListFiltro.setBounds(200, 311, 86, 20);
		add(this.textListFiltro);
		textListFiltro.setColumns(10);
		
		//comboBoxItens = new JComboBox(comboBoxNomeItens);
		//comboBoxItens.setBounds(349, 311, 131, 20);
		//add(comboBoxItens);
	
		panelItens = new PanelItens();
		add(panelItens);
		
		//----------------------------------------------------------------------------
		//--------------------Ações quando panel é carregado--------------------------
		//----------------------------------------------------------------------------
        
		addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent evt) {
            	atualizaPanelEdicaoPainel();
            }
        });
        
        //----------------------------------------------------------------------------
		//----------------------Ações Painel Edição Painéis---------------------------
		//----------------------------------------------------------------------------

		
		//------------------------------Botão Voltar----------------------------------
		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.previous(panel);
			}			
		});
		
		
	}
	
	public void atualizaPanelEdicaoPainel(){
		try {
			InfoDB.atualizaListaItens(painelSelecionado.getID());
			listaItens = InfoDB.getListaItens();
			atualizaListModelEdicaoPainel(listaItens);
			
			InfoDB.atualizaListaDisjuntoresMotor();
			//listaDisjuntoresMotor = infoDB.getListaDisjuntorMotor();
			//panelItens.atualizaListModelDisjuntoresMotor(listaDisjuntoresMotor);
		
		} catch (SQLException | IOException e1) {
			e1.printStackTrace();
		}
	}	
	
	public void atualizaListModelEdicaoPainel(LinkedList<Item> listaItens){
		this.tblModelItens.setRowCount(0);
		for(int i=0; i<listaItens.size();i++){
			Object[] linhaAdicionada = {listaItens.get(i).getDescrição(),
										listaItens.get(i).getModelo(),
										listaItens.get(i).getQuantidade(),
										listaItens.get(i).getFabricante(),
										listaItens.get(i).getConjunto()};
			this.tblModelItens.addRow(linhaAdicionada);
		}
	}
	
	public void limpaListModelPropostas(){
		this.tblModelItens.setRowCount(0);
	}
}
