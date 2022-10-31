package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import br.com.factory.ConnectionFactory;

public class Filme {

	public void salvaFilmes(String nome, String descricao, int ano) throws SQLException {

		Connection conn;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			PreparedStatement pstm = conn.prepareStatement("INSERT INTO filmes (nome, descricao, ano) VALUES (?,?,?)");

			pstm.setString(1, nome);
			pstm.setString(2, descricao);
			pstm.setInt(3, ano);

			pstm.execute();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void deletarFilmes() throws SQLException {

		Connection conn;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();

			PreparedStatement pstm = conn.prepareStatement("DELETE FROM filmes WHERE ID");

			pstm.execute();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void selecionarFilmes() throws SQLException {

		Connection conn;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();

			Scanner sc = new Scanner(System.in);

			System.out.print("Digite quantos filmes: ");
			int quantidade = sc.nextInt();
			System.out.print("Qual página deseja filtrar? Pág 1 a 2: ");
			int pagina = sc.nextInt();

			if (pagina == 1) {

				PreparedStatement pstm1 = conn.prepareStatement("select nome, descricao, ano FROM filmes");

				pstm1.setInt(1, quantidade);

				pstm1.execute();

				ResultSet rs1 = pstm1.getResultSet();

				while (rs1.next()) {
					String nome = rs1.getString("nome");
					System.out.print(nome + " ");
					String descricao = rs1.getString("descricao");
					System.out.print(descricao + " ");
					int ano = rs1.getInt("ano");
					System.out.print(ano + " ");

					System.out.println();

				}
			}

			else if (pagina == 2) {

				PreparedStatement pstm2 = conn.prepareStatement("select nome, descricao, ano FROM filmes");

				pstm2.setInt(1, quantidade);

				pstm2.execute();

				ResultSet rs2 = pstm2.getResultSet();

				while (rs2.next()) {
					String nome = rs2.getString("nome");
					System.out.print(nome + " ");
					String descricao = rs2.getString("descricao");
					System.out.print(descricao + " ");
					int ano = rs2.getInt("ano");
					System.out.print(ano + " ");

					System.out.println();

				}
				sc.close();

			}

			else {
				System.out.println("Nenhum filme encontrado nos parametros digitados!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
