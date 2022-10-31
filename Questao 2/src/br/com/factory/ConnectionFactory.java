package br.com.factory;
//package br.com.loja.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	// nome usuario mysql
	private static final String USERNAME = "root";
	// senha banco
	private static final String PASSWORD = " ";
	// url banco
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/lista_filmes";

	// conexao
	public static Connection createConnectionToMySQL() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

		return connection;
	}

	public static void main(String[] args) throws Exception {
		// faz com que a classe seja carregada pela jvm
		Connection con = createConnectionToMySQL();
		// testar conexao e nula
		if (con != null) {
			System.out.println("Conexao obtida com sucesso!");
			con.close();
		}
	}

}

