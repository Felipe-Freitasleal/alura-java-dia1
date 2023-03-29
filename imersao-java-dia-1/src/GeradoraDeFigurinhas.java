import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
    
    public void criar(InputStream inputStream, String nomeArquivo) throws Exception {
        // InputStream inputStream = new FileInputStream(new File("../entrada/filme.jpg"));
        // InputStream inputStream = new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_2.jpg").openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 220;

        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        Font fonte = new Font(Font.SANS_SERIF, Font.BOLD, 100);  
        graphics.setColor(Color.GREEN);
        graphics.setFont(fonte);

        graphics.drawString("O FODAO", 0, novaAltura - 50);

        ImageIO.write(novaImagem, "png", new File(nomeArquivo));
    }
    // public static void main(String[] args) throws Exception {
    //     var geradora = new GeradoraDeFigurinhas();
    //     geradora.criar();
    // }
}
