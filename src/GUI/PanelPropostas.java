package GUI;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import EstruturaProposta.Proposta;
import Resultado.PropostaEditada;
import Sqlite.EditarDBs;
import Sqlite.InfoDB;
import Sqlite.sqliteConnection;

public class PanelPropostas extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JLabel labelProposta;
	
	private JButton btnAdicionarProposta;
	private JButton btnCancelar;
	private JButton btnSelecionarProposta;
	private JButton btnAtulizaPropostas;
	
	private JTable tblPropostas;
	private JScrollPane tblScrollPane;;
	private DefaultTableModel tblModel;
	private String[] tblColunas = {"ID","Nome","Cadastro"};

	private LinkedList<Proposta> listaPropostas= new LinkedList<Proposta>();
	
	private Connection DBcon;
	
	public PanelPropostas(CardLayout cardLayout,JFrame frame, Container container) {
		
		DBcon = sqliteConnection.getConnection();
		
		setLayout(null);
		
		tblModel = new DefaultTableModel(){

			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		};
		for(String nomeColunas : tblColunas){
			tblModel.addColumn(nomeColunas);
		}
		
		
		tblPropostas = new JTable(tblModel);
		tblPropostas.getColumnModel().getColumn(0).setPreferredWidth(10);
		tblPropostas.getColumnModel().getColumn(1).setPreferredWidth(80);
		tblPropostas.getColumnModel().getColumn(2).setPreferredWidth(80);
		tblPropostas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tblScrollPane = new JScrollPane(tblPropostas);
		tblScrollPane.setBounds(10, 35, 232, 239);
		add(tblScrollPane);
		
		labelProposta = new JLabel("Lista de propostas cadastradas");
		labelProposta.setBounds(10, 16, 200, 14);
		add(labelProposta);
		
		btnSelecionarProposta = new JButton("Selecionar Proposta");
		btnSelecionarProposta.setBounds(600, 427, 170, 23);
		add(btnSelecionarProposta);
	
		btnAdicionarProposta = new JButton("Criar nova proposta");
		btnAdicionarProposta.setBounds(10, 280, 169, 23);
		add(btnAdicionarProposta);
		
		btnAtulizaPropostas = new JButton("Atualizar Lista");
		btnAtulizaPropostas.setBounds(10, 310, 169, 23);
		add(btnAtulizaPropostas);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(10, 427, 89, 23);
		add(btnCancelar);
		
		DBcon = sqliteConnection.getConnection();
		
		//----------------------------------------------------------------------------
		//--------------------Ações quando panel é carregado--------------------------
		//----------------------------------------------------------------------------
		
		addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent evt) {
            	atualizaPanelPropostas();
            }
        });
        
		//----------------------------------------------------------------------------
		//------------------------Ações Painel Propostas------------------------------
		//----------------------------------------------------------------------------
			
		//------------------------Botão Adicionar Proposta----------------------------
		btnAdicionarProposta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPaneFormProposta formProposta = new JOptionPaneFormProposta();
				formProposta.display();
				
				Proposta novaProposta = new Proposta();
				novaProposta = formProposta.getNovaProposta();
						
				if (novaProposta.getNome() == null && novaProposta.getCadastro() == null){
					System.out.println("A Proposta apresenta valor nulo!");
				}else {
					try {
						EditarDBs.CadastrarProposta(DBcon, novaProposta);
						atualizaPanelPropostas();
						} catch (SQLException | IOException e1) {
						e1.printStackTrace();
						} 
				}
			}	
		});
				
		//------------------------Botão Selecionar Proposta---------------------------
		btnSelecionarProposta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				int linhaSelecionada = tblPropostas.getSelectedRow();
				
				
				if(linhaSelecionada == -1){
					JOptionPane.showMessageDialog(null, "Selecione proposta a ser alterada.");
				}else{
					PropostaEditada.setPropostaSelecionada(listaPropostas.get(linhaSelecionada));
					//System.out.println(listaPropostas.get(linhaSelecionada).getID());
					cardLayout.next(container);
				}
			}	
		});
				
		//------------------------Botão Atualizar Proposta---------------------------
		btnAtulizaPropostas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				atualizaPanelPropostas();
			}	
		});		
				
		//------------------------------Botão Cancelar--------------------------------
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}			
		});
	}
	
	public void atualizaPanelPropostas(){
		try {
			listaPropostas = InfoDB.getListaPropostas();
			atualizaListModelPropostas(listaPropostas);
		    tblPropostas.setRowSelectionInterval(0,0);
		} catch (SQLException | IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public void atualizaListModelPropostas(LinkedList<Proposta> listaPropostas){
		this.tblModel.setRowCount(0);
		for(int i=0; i<listaPropostas.size();i++){
			Object[] linhaAdicionada = {listaPropostas.get(i).getID(),
										listaPropostas.get(i).getNome(),
										listaPropostas.get(i).getCadastro()};
			this.tblModel.addRow(linhaAdicionada);
		}
	}
	
	public void limpaListModelPropostas(){
		this.tblModel.setRowCount(0);
	}
}
