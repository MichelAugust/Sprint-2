package br.com.loja.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.loja.factory.ConnectionFactory;
import br.com.loja.model.Produto;

public class ProdutoDAO {

	public static void salvar(String nome, String descricao, int quantidade, float preco) throws SQLException {

		try {
			Connection conn = ConnectionFactory.createConnectionToMySQL();
			PreparedStatement pstm = conn
					.prepareStatement("INSERT INTO produtos(nome, descricao, quantidade, preco) VALUES (? , ? ,?, ?)");

			pstm.setString(1, nome);
			pstm.setString(2, descricao);
			pstm.setInt(3, quantidade);
			pstm.setFloat(4, preco);

			pstm.execute();

			System.out.println("Produto salvo com sucesso!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	public static void atualizar(String nome, String descricao, int quantidade, float preco) throws SQLException {

		try {
			Connection conn = ConnectionFactory.createConnectionToMySQL();

			PreparedStatement pstm = conn.prepareStatement(
					"UPDATE PRODUTO SET (nome = ?, descricao = ?, quantidade = ?, preco = ?  WHERE id =  1)");
			pstm.setString(1, nome);
			pstm.setString(2, descricao);
			pstm.setInt(3, quantidade);
			pstm.setFloat(4, preco);

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static List<Produto> listar(String nome, String descricao, int quantidade, float preco) throws SQLException {

		List<Produto> produtos = new ArrayList<Produto>();

		try {
			Connection conn = ConnectionFactory.createConnectionToMySQL();
			PreparedStatement pstm = conn.prepareStatement("SELECT * FROM produtos");

			ResultSet rst = null;

			rst = pstm.executeQuery();

			while (rst.next()) {

				pstm.setString(1, nome);
				pstm.setString(2, descricao);
				pstm.setInt(3, quantidade);
				pstm.setFloat(4, preco);


				produtos.addAll(produtos);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return produtos;

	}

	public static void apagar() throws SQLException {

		try {
			Connection conn = ConnectionFactory.createConnectionToMySQL();
			PreparedStatement pstm = conn.prepareStatement("DELETE FROM PRODUTO WHERE id = ?");

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

		}
	}

	
	}


