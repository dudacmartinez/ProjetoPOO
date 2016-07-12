package Sqlite;
import EstruturaProposta.Item;
import EstruturaProposta.Painel;
import EstruturaProposta.Proposta;

import java.io.IOException;
import java.sql.*;

public class EditarDBs {

	public static void CadastrarProposta(Connection c, Proposta novaProposta) throws IOException, SQLException{
		
		Statement stmt = null;
		c.setAutoCommit(false);
		stmt = c.createStatement();
		
		stmt.execute("UPDATE SQLITE_SEQUENCE SET SEQ=0 WHERE NAME='PROPOSTAS'");
			
		String sql = "INSERT INTO 'main'.'PROPOSTAS'"+
					"('NOME','CADASTRO','REVISAO') VALUES "+
					"('"+novaProposta.getNome()+"','"+novaProposta.getCadastro()+"','"+novaProposta.getRevisao()+"')";
		System.out.println("cmd executado: "+ sql);
		stmt.executeUpdate(sql);

		stmt.close();
		c.commit();
	}
	
	public static void CadastrarPainel(Connection c, Painel novoPainel, Proposta propostaAlvo) throws IOException, SQLException{
		
		Statement stmt = null;
		c.setAutoCommit(false);
		stmt = c.createStatement();
		stmt.execute("UPDATE SQLITE_SEQUENCE SET SEQ=0 WHERE NAME='PAINEIS'");
			
		String sql = "INSERT INTO 'main'.'PAINEIS'"+
					"('PROPOSTA_ID','TAG','APLICACAO','TENSAO_ALIMENTACAO_FASE_FASE',"+
					"'NUMERO_FASES','TTA','MEDICAO','DPS','COMPARTIMENTADO',"+
					"'CORRENTE_DE_BARRAMENTO','CORRENTE_DE_CURTO_CIRCUITO') VALUES "+
					"('"+propostaAlvo.getID()+"','"+
					novoPainel.getTAG()+"','"+
					novoPainel.getAplicação()+"','"+
					novoPainel.getTensãoAlimentaçãoFaseFase()+"','"+
					novoPainel.getNumFases()+"','"+
					novoPainel.getÉTTA()+"','"+
					novoPainel.getTemMedição()+"','"+
					novoPainel.getTemDPS()+"','"+
					novoPainel.getÉCompartimentado()+"','"+
					novoPainel.getCorrenteBarramento()+"','"+
					novoPainel.getCorrenteCurtoCircuito()+"')";
		System.out.println("cmd executado: "+ sql);
		
		stmt.executeUpdate(sql);

		stmt.close();
		c.commit();
	}
	
	public static void adicionarItem(Connection c, Item novoItem, Painel painelAlvo) throws IOException, SQLException{
		
		Statement stmt = null;
		c.setAutoCommit(false);
		stmt = c.createStatement();
		stmt.execute("UPDATE SQLITE_SEQUENCE SET SEQ=0 WHERE NAME='ITENS_PAINEIS'");
			
		String sql = "INSERT INTO 'main'.'ITENS_PAINEIS' ('PAINEL_ID','CONJUNTO_ID'"
					+ ",'DESCRICAO','MODELO','QUANTIDADE','FABRICANTE','TIPO','CONJUNTO')"
					+ " VALUES ("+painelAlvo.getID()+"','"+
					"-','"+
					novoItem.getDescrição()+"','"+
					novoItem.getModelo()+"','"+
					novoItem.getQuantidade()+"','"+
					novoItem.getFabricante()+"','"+
					novoItem.getTipo()+"','"+
					novoItem.getConjunto()+"')";

		System.out.println("cmd executado: "+ sql);
		
		stmt.executeUpdate(sql);

		stmt.close();
		c.commit();
	}
	
}
