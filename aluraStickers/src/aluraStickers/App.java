package aluraStickers;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {

	public static void main(String[] args) throws Exception, IOException {
		
		// fazer a conexão HTTP e buscar os top 250 filmes
		
		// Busca Lista API IMDb
		//String url = "https://alura-filmes.herokuapp.com/conteudos";
		//ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();
		
		// Busca Lista API Nasa
		//String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/NASA-APOD.json";
		// ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();
		
		// Busca Lista API LocalHost
		String url = "https://linguagem-api-tiagoalmeida.herokuapp.com/linguagens";
		ExtratorDeConteudo extrator = new ExtratorDeConteudoDeLinguagem();
		
		var http = new ClienteHttp();
		String json = http.buscaDados(url);
		
		// exibir e manipular os dados
		List<Conteudo> conteudos = extrator.extraiConteudos(json);
				
		var geradora = new GeradoraDeFigurinhas();
		
		for(int i = 0; i < 5; i++) {
			
			Conteudo conteudo = conteudos.get(i);
						
			InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
			String nomeArquivo = "saida/" + conteudo.getTitulo() + ".png";
				
			geradora.cria(inputStream, nomeArquivo);		
			
			System.out.println(conteudo.getTitulo());
			System.out.println();
		}
	}
} 
