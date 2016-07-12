package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import Sqlite.sqliteConnection;

import java.awt.CardLayout;
import javax.swing.JPanel;
import java.io.IOException;
import java.sql.SQLException;

public class FrameElaboracaoPropostas {
	
	//----------------------------------------------------------------------------
	//--------------------------Elementos Gr�ficos--------------------------------
	//----------------------------------------------------------------------------

	private JFrame frame;
	private JPanel panel;
	private PanelInicial panelInicial;
	private PanelPropostas panelPropostas;
	private PanelPaineis panelPaineis;
	private PanelEdicaoPainel panelEdicaoPainel;
	private CardLayout cardLayout;
	
	private static final String nomePanelInicial = "panelInicial";
	private static final String nomePanelPropostas = "panelPropostas";
	private static final String nomePanelPaineis = "panelPaineis";
	private static final String nomePanelEdicaoPaineis = "panelEdicaoPaineis";	
	
	//----------------------------------------------------------------------------
	//-----------------------Elementos de L�gica/Controle-------------------------
	//----------------------------------------------------------------------------
	
	/***
	private Connection DBcon;
	private LinkedList<Item> listaItens = new LinkedList<Item>();
	private LinkedList<DisjuntorMotor> listaDisjuntoresMotor = new LinkedList<DisjuntorMotor>();
	private InfoDB infoDB;
	private Painel painelSelecionado;
	***/
	
	//----------------------------------------------------------------------------
	//-----------------------Main tempor�rio para testes--------------------------
	//----------------------------------------------------------------------------
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					FrameElaboracaoPropostas window = new FrameElaboracaoPropostas();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//----------------------------------------------------------------------------
	//-------------------------------Construtor-----------------------------------
	//----------------------------------------------------------------------------
	
	public FrameElaboracaoPropostas() throws ClassNotFoundException, SQLException, IOException {
		
		//----------------------------------------------------------------------------
		//---------------------------Conex�o com SQLite-------------------------------
		//----------------------------------------------------------------------------
		
		sqliteConnection.setConnection();
		//DBcon = sqliteConnection.getConnection();
		
		//----------------------------------------------------------------------------
		//------------------------Inicializa��o Gr�fica-------------------------------
		//----------------------------------------------------------------------------
		
		inicializaGr�fico();
		
	}

	private void inicializaGr�fico() {
			
		//----------------------------------------------------------------------------
		//--------------------Declara��o do JFrame principal--------------------------
		//----------------------------------------------------------------------------

		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(new CardLayout(0, 0));

		//----------------------------------------------------------------------------
		//--------------------Defini��o de elementos gr�ficos-------------------------
		//----------------------------------------------------------------------------
		
		cardLayout = (CardLayout)panel.getLayout();
		
		frame.add(panel);
		
		//----------------------------------------------------------------------------
		//----------------Declara��o dos Panels do Card Layout------------------------
		//----------------------------------------------------------------------------
		
		panelInicial = new PanelInicial(cardLayout, frame, panel);
		panel.add(panelInicial, nomePanelInicial);	
		
		panelPropostas = new PanelPropostas(cardLayout, frame, panel);	
		panel.add(panelPropostas, nomePanelPropostas);
		
		panelPaineis = new PanelPaineis(cardLayout, panel);
		panel.add(panelPaineis, nomePanelPaineis);

		panelEdicaoPainel = new PanelEdicaoPainel(cardLayout, panel);
		panel.add(panelEdicaoPainel, nomePanelEdicaoPaineis);
	    
		//----------------------------------------------------------------------------
		//----------------------------------------------------------------------------
		//----------------------------------------------------------------------------
	}
}