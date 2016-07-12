package Sqlite;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import EstruturaProposta.DisjuntorMotor;
import EstruturaProposta.Item;
import EstruturaProposta.Painel;
import EstruturaProposta.Proposta;

public class LerDBs {
	
	
	public static LinkedList<Proposta> leListaPropostas(Connection c) throws SQLException, IOException{
		
		Statement stmt = null;
		LinkedList<Proposta> listaPropostas = new LinkedList<Proposta>();
		
		c.setAutoCommit(false);
		stmt = c.createStatement();  
		ResultSet rs = stmt.executeQuery( "SELECT * FROM PROPOSTAS;" );
		ResultSetMetaData rsmt = rs.getMetaData();
		
		while ( rs.next() ) {
			
			ArrayList<String> infoProposta = new ArrayList<String>();
			
			for (int i = 1; i <= rsmt.getColumnCount();i++){
				String info = rs.getString(i);
				infoProposta.add(info);
			}
			Proposta novaProposta = new Proposta(infoProposta);
			listaPropostas.add(novaProposta);
		}		
		stmt.close();
		c.commit();
		return listaPropostas;
	}
	
	public static LinkedList<Painel> leListaPaineis(Connection c, int propostaID) throws SQLException, IOException{
		
		Statement stmt = null;
		LinkedList<Painel> listaPaineis = new LinkedList<Painel>();
		
		c.setAutoCommit(false);
		stmt = c.createStatement();  
		ResultSet rs = stmt.executeQuery( "SELECT * FROM PAINEIS WHERE PROPOSTA_ID = "+ propostaID);
		ResultSetMetaData rsmt = rs.getMetaData();
		
		while ( rs.next() ) {
			ArrayList<String> infoPainel = new ArrayList<String>();
			
			for (int i = 1; i <= rsmt.getColumnCount();i++){
				String info = rs.getString(i);
				infoPainel.add(info);
			}
			Painel novoPainel = new Painel(infoPainel);
			listaPaineis.add(novoPainel);
		
			//for(int i = 0; i < listaPaineis.size(); i++){
			//	System.out.println(listaPaineis.get(i).getTAG());
			//}
		}		
		stmt.close();
		c.commit();
		
		return listaPaineis;
	}

	public static LinkedList<Item> leListaItens(Connection c, int painelID) throws SQLException, IOException{
		
		Statement stmt = null;
		LinkedList<Item> listaItens = new LinkedList<Item>();
		
		c.setAutoCommit(false);
		stmt = c.createStatement();  
		ResultSet rs = stmt.executeQuery( "SELECT * FROM ITENS_PAINEIS WHERE PAINEL_ID = "+ painelID);
		ResultSetMetaData rsmt = rs.getMetaData();
		
		while ( rs.next() ) {
			ArrayList<String> infoItem = new ArrayList<String>();
			
			for (int i = 1; i <= rsmt.getColumnCount();i++){
				String info = rs.getString(i);
				infoItem.add(info);
			}
			Item novoItem = new Item(infoItem);
			listaItens.add(novoItem);
		
			for(int i = 0; i < listaItens.size(); i++){
				System.out.println(listaItens.get(i).getModelo());
			}
		}		
		stmt.close();
		c.commit();
		
		return listaItens;
	}
	
public static LinkedList<DisjuntorMotor> leListaDisjuntoresMotor(Connection c) throws SQLException, IOException{
		
		Statement stmt = null;
		LinkedList<DisjuntorMotor> listaDisjutoresMotor = new LinkedList<DisjuntorMotor>();
		
		c.setAutoCommit(false);
		stmt = c.createStatement();  
		ResultSet rs = stmt.executeQuery( "SELECT * FROM DISJUNTOR_MOTOR_3RV10");
		ResultSetMetaData rsmt = rs.getMetaData();
		
		while ( rs.next() ) {
			ArrayList<String> infoDisjuntorMotor = new ArrayList<String>();
			
			for (int i = 1; i <= rsmt.getColumnCount();i++){
				String info = rs.getString(i);
				infoDisjuntorMotor.add(info);
			}
			DisjuntorMotor novoDisjuntorMotor = new DisjuntorMotor(infoDisjuntorMotor);
			listaDisjutoresMotor.add(novoDisjuntorMotor);
		
			for(int i = 0; i < listaDisjutoresMotor.size(); i++){
				System.out.println(listaDisjutoresMotor.get(i).getModelo());
			}
		}		
		stmt.close();
		c.commit();
		
		return listaDisjutoresMotor;
	}
	
	public static int contaNumPropostas(Connection c) throws SQLException, IOException{
		
		Statement stmt = null;
		int numPropostas = 0;
		
		c.setAutoCommit(false);
		stmt = c.createStatement();  
		
		ResultSet rs = stmt.executeQuery( "SELECT Count(*) FROM PROPOSTAS" );
		
		numPropostas = rs.getInt(1);
		
		stmt.close();
		c.commit();
		
		return numPropostas;
		
	}

}
