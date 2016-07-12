package Sqlite;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

import EstruturaProposta.DisjuntorMotor;
import EstruturaProposta.Item;
import EstruturaProposta.Painel;
import EstruturaProposta.Proposta;

public class InfoDB {

	private static LinkedList<Proposta> listaPropostas = new LinkedList<Proposta>();
	private static LinkedList<Painel> listaPaineis = new LinkedList<Painel>();
	private static LinkedList<Item> listaItens = new LinkedList<Item>();
	private static LinkedList<DisjuntorMotor> listaDisjuntorMotor = new LinkedList<DisjuntorMotor>();
	private static Connection con = sqliteConnection.getConnection();
	
	public static void atualizaListaPropostas() throws SQLException, IOException{
		listaPropostas = LerDBs.leListaPropostas(con);		
	}
	
	public static  LinkedList<Proposta> getListaPropostas() throws SQLException, IOException{
		InfoDB.atualizaListaPropostas();
		return listaPropostas;
	}
	
	public static void atualizaListaPaineis(int propostaID) throws SQLException, IOException{
		listaPaineis = LerDBs.leListaPaineis(con, propostaID);		
	}
	
	public static LinkedList<Painel> getListaPaineis(int propostaID) throws SQLException, IOException{
		atualizaListaPaineis(propostaID);
		System.out.println(propostaID);
		for(int i=0;i<listaPaineis.size();i++){
			System.out.println(listaPaineis.get(i).getID());
		}
		return listaPaineis;
	}

	public static void atualizaListaItens(int painelID) throws SQLException, IOException{
		listaItens = LerDBs.leListaItens(con, painelID);		
	}
	
	public static LinkedList<Item> getListaItens(){
		return listaItens;
	}
	public static void atualizaListaDisjuntoresMotor() throws SQLException, IOException{
		listaDisjuntorMotor = LerDBs.leListaDisjuntoresMotor(con);		
	}
	
	public static LinkedList<DisjuntorMotor> getListaDisjuntorMotor(){
		return listaDisjuntorMotor;
	}
}
