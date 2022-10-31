package br.com.loja.aplicacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import br.com.loja.dao.ProdutoDAO;
import br.com.loja.factory.ConnectionFactory;

public class Main {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int opcao;

		do {

			System.out.println("1 - Salvar produtos na base");
			System.out.println("2 - Atualizar produto");
			System.out.println("3 - Excluir produto");
			System.out.println("4 - listar produto");
			System.out.println("0 - Encerrar aplicação");
			System.out.print("Escolha uma opção: ");
			opcao = sc.nextInt();

			switch (opcao) {
			case 1:

				ProdutoDAO.salvar("tv ", "preta ", 1, 1500);
				ProdutoDAO.salvar("ps4 ", "preto ", 1, 1800);
				ProdutoDAO.salvar("celular ", "preto ", 1, 1000);
				System.out.println("Os produtos foram inseridos.");
				break;

			case 2:

				ProdutoDAO.atualizar("geladeira", "preta", 1, 5000);
				System.out.println("Produto 1 atualizado.");
				break;

			case 3:

				ProdutoDAO.apagar();
				System.out.println("Produto 2 removido.");
				break;

			case 4:

				ProdutoDAO.listar();
				System.out.println("Produto 2 removido.");
				break;
				
			default:
				System.out.println("Opção inválida. Por favor escolha uma opção do menu.");
				break;
			}

		} while (opcao != 0);

		Connection conn1 = ConnectionFactory.createConnectionToMySQL();
		PreparedStatement pstm1 = conn1.prepareStatement("SELECT * FROM produtos");
		ResultSet rst = pstm1.executeQuery();

		System.out.println("Produtos cadastrados:");

		while (rst.next()) {
			int id = rst.getInt("id");
			System.out.print(id + " ");
			String nome = rst.getString("nome");
			System.out.print(nome + " ");
			String descricao = rst.getString("descricao");
			System.out.print(descricao + " ");
			int quantidade = rst.getInt("quantidade");
			System.out.print(quantidade + " ");
			float preco = rst.getFloat("preco");
			System.out.print("R$ " + preco);

			System.out.println();

		}

		sc.close();
	}

}
