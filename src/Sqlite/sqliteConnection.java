package Sqlite;

import java.io.IOException;
import java.sql.*;
import javax.swing.*;

public class sqliteConnection {

	private static Connection connection = null;
	
	public static void setConnection() throws ClassNotFoundException, SQLException, IOException{
		
		//Class.forName("org.sqlite.JDBC");
		connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/VK/Workspace/ElaboracaoPropostas/SQLite/Propostas.sqlite");
		JOptionPane.showMessageDialog(null,"Conectado à base de dados.");
	}

	public static Connection getConnection(){
		return connection;
	}
	
}
