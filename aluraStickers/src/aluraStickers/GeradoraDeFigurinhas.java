package aluraStickers;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {

	public void cria(InputStream inputStream, String nomeArquivo) throws Exception {

		// leitura da imagem
		
		// InputStream inputStream = new FileInputStream(new File("assets/filme1.jpg"));
		// InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BYzc5MTU4N2EtYTkyMi00NjdhLTg3NWEtMTY4OTEyMzJhZTAzXkEyXkFqcGdeQXVyNjc1NTYyMjg@._V1_UX128_CR0,3,128,176_AL_.jpg").openStream();
		
		BufferedImage imagemOriginal = ImageIO.read(inputStream);
		
		
		// cria nova imagem em memoria com transparencia e com tamanho novo
		
		int largura = imagemOriginal.getWidth();
		int altura = imagemOriginal.getHeight();
		int novaAltura = altura + 90;
		BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
		
		// copiar a imagem original para novo imagem (em mem�ria)
		
		Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
		graphics.drawImage(imagemOriginal, 0, 0, null);
		
		// configura fonte
		
		var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 20);
		graphics.setColor(Color.RED);
		graphics.setFont(fonte);
		
		// escrever uma frase na nova imagem
		
		graphics.drawString("TOPZERA", 18, novaAltura - 40);
		
		// escrever a nova imagem em um arquivo
		
		ImageIO.write(novaImagem, "png", new File(nomeArquivo));
		
	}
	
}
