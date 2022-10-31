package br.com.aplicacao;

import java.sql.SQLException;
import java.util.Scanner;
import DAO.Filme;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		Scanner sc = new Scanner(System .in);		
		
		Filme filmes = new Filme();
		
		
		filmes.salvaFilmes("A VIAGEM DE CHIHIRO","desenho",2001);
		filmes.salvaFilmes("CIDADE DE DEUS","nacional",2002);
		filmes.salvaFilmes("BRILHO ETERNO DE UMA MENTE SEM LEMBRANÇAS","fabula",2004);
		filmes.salvaFilmes("O DIABO VESTE PRADA","comedia dramatica", 2006);
		filmes.salvaFilmes("PEQUENA MISS SUNSHINE", "drama", 2006);
		filmes.salvaFilmes("O CAVALEIRO DAS TREVAS", "acao", 2008);
		filmes.salvaFilmes("A ORIGEM" ,"acao", 2010);
		filmes.salvaFilmes("A REDE SOCIAL" ,"documentario", 2010);
		filmes.salvaFilmes("CISNE NEGRO" ,"drama", 2010);
		filmes.salvaFilmes("ELA ","acao", 0);
		filmes.salvaFilmes("MAD MAX: ESTRADA DA FÚRIA","acao", 2015);
		filmes.salvaFilmes("DIVERTIDA MENTE","desenho", 2015);
		filmes.salvaFilmes("QUE HORAS ELA VOLTA?", "nacional", 2015);
		filmes.salvaFilmes("A CHEGADA ","cientifico", 2016);
		filmes.salvaFilmes("LA LA LAND","romantico", 2016);
		filmes.salvaFilmes("MOONLIGHT", "drama", 2016);
		filmes.salvaFilmes("CORRA!", "documentario", 2017);
		filmes.salvaFilmes("HOMEM-ARANHA NO ARANHAVERSO", "desenho", 2018);
		filmes.salvaFilmes("BACURAU", "faroeste", 2019);
		filmes.salvaFilmes("PARASITA", "drama", 2019);
		
		
		filmes.selecionarFilmes();
		filmes.deletarFilmes();
		
		sc.close();
	}

}







