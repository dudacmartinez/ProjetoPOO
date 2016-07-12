package GUI;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import EstruturaProposta.Painel;
import Resultado.PropostaEditada;
import Sqlite.EditarDBs;
import Sqlite.InfoDB;
import Sqlite.sqliteConnection;

public class PanelPaineis extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	//private JLabel labelPropostaSelecionada;
	//private JLabel labelCabeçalhoProposta;
	private JLabel labelListaPropostas;
	
	private JButton btnVoltar;
	private JButton btnSelecionarPainel;
	private JButton btnAdicionarPainel;
	
	private JTable tblPaineis;
	private JScrollPane tblScrollPane;;
	private DefaultTableModel tblModel;
	private String[] tblColunas = {"ID","TAG","Aplicação"};
	
	private LinkedList<Painel> listaPaineis = new LinkedList<Painel>();

	private Connection DBcon;
	
	public PanelPaineis(CardLayout cardLayout, Container container) {
		
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
		
		tblPaineis = new JTable(tblModel);
		tblPaineis.getColumnModel().getColumn(0).setPreferredWidth(10);
		tblPaineis.getColumnModel().getColumn(1).setPreferredWidth(80);
		tblPaineis.getColumnModel().getColumn(2).setPreferredWidth(80);
		tblPaineis.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tblScrollPane = new JScrollPane(tblPaineis);
		tblScrollPane.setBounds(10, 35, 232, 239);
		add(tblScrollPane);
		
		labelListaPropostas = new JLabel("Lista painéis da proposta");
		labelListaPropostas.setBounds(10, 16, 200, 14);
		add(labelListaPropostas);
		
		btnSelecionarPainel = new JButton("Selecionar Painel");
		btnSelecionarPainel.setBounds(643, 427, 131, 23);
		add(btnSelecionarPainel);
		
		btnAdicionarPainel = new JButton("Criar novo painel");
		btnAdicionarPainel.setBounds(10, 280, 169, 23);
		add(this.btnAdicionarPainel);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(10, 427, 89, 23);
		add(btnVoltar);
		
		//----------------------------------------------------------------------------
		//--------------------Ações quando panel é carregado--------------------------
		//----------------------------------------------------------------------------
        
		addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent evt) {
            	atualizaPanelPaineis();
            	System.out.println("Atualizou paineis");
            }
        });
		
		//----------------------------------------------------------------------------
		//------------------------Ações Painel Painéis--------------------------------
		//----------------------------------------------------------------------------

				
		//------------------------------Botão Voltar----------------------------------
		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.previous(container);
			}			
		});
				
		//------------------------Botão Adicionar Painel------------------------------
		btnAdicionarPainel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				JOptionPaneFormPainel formPainel = new JOptionPaneFormPainel();
				formPainel.display();
				
				Painel novoPainel = new Painel();
				novoPainel = formPainel.getNovoPainel();
				
				if (novoPainel.getTAG() != null){
					try {
						EditarDBs.CadastrarPainel(DBcon, novoPainel, PropostaEditada.getPropostaSelecionada());
						atualizaPanelPaineis();
						PropostaEditada.getPropostaSelecionada().adicionaPainel(novoPainel);
					} catch (SQLException | IOException e1) {
						e1.printStackTrace();
					} 						
				}else System.out.println("A Proposta apresenta valor nulo!");
			}	
		});

		//------------------------Botão Selecionar Painel------------------------------
		btnSelecionarPainel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				int linhaSelecionada = tblPaineis.getSelectedRow();
				
				if(linhaSelecionada == -1){
					JOptionPane.showMessageDialog(null, "Selecione painel a ser alterado.");
				}else{
					PropostaEditada.setPainelSelecionado(listaPaineis.get(linhaSelecionada));;
					cardLayout.next(container);
				}
			}	
		});

		
	}
	
	public void atualizaPanelPaineis(){
		try {
			listaPaineis = InfoDB.getListaPaineis(PropostaEditada.getPropostaSelecionada().getID());
			atualizaListModelPropostas(listaPaineis);
		    if (tblPaineis.getRowCount() > 0){
		    	tblPaineis.setRowSelectionInterval(0,0);
		    }
		} catch (SQLException | IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public void atualizaListModelPropostas(LinkedList<Painel> listaPaineis){
		this.tblModel.setRowCount(0);
		for(int i=0; i<listaPaineis.size();i++){
			Object[] linhaAdicionada = {listaPaineis.get(i).getID(),
										listaPaineis.get(i).getTAG(),
										listaPaineis.get(i).getAplicação()};
			this.tblModel.addRow(linhaAdicionada);
		}
	}
	
	public void limpaListModelPropostas(){
		this.tblModel.setRowCount(0);
	}

}
