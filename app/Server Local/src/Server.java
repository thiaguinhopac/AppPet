import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.RenderedImage;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Scanner;

public class Server {

      public static void main(String[] args) throws Exception { Scanner input = new
      Scanner(System.in);

      while (true){


      System.out.print("Url Imagem : "); String url = input.nextLine();

     System.out.print("Tipo : "); String tipo = input.nextLine();

      System.out.print("Nome : "); String nome = input.nextLine();

      System.out.print("Descrição : "); String descricao = input.nextLine();

      System.out.print("Preço:"); System.out.print("R$"); String preco =
      input.nextLine();

      System.out.println(); System.out.println("Baixando imagem..."); BufferedImage
      bufferedImage = ImageIO.read(new URL(url));
      System.out.println("Convertendo imagem para string.."); final String
      base64String = imgToBase64String(bufferedImage,
      url.substring(url.lastIndexOf('.') + 1));

      String data = "\"product_data\" : { \"image\" : \"" + base64String +
      "\", \"type\" : \"" + tipo + "\", \"name\" : " + nome +
      ", \"description\" : \""+ descricao + "\", \"price\" : \"" + preco
      +"\" },\n";






      JFrame editorFrame = new JFrame("Image Demo");
      editorFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

      ImageIcon imageIcon = new ImageIcon(base64StringToImg(base64String)); JLabel
      jLabel = new JLabel(); jLabel.setIcon(imageIcon);
      editorFrame.getContentPane().add(jLabel, BorderLayout.CENTER);

      editorFrame.pack(); editorFrame.setLocationRelativeTo(null);
      editorFrame.setVisible(true);

      try{ System.out.println("Salvando..."); FileOutputStream fout=new
      FileOutputStream("DataServer.json", true);
      fout.write(data.getBytes(StandardCharsets.UTF_8)); fout.close();
      System.out.println("Salvo"); }catch(Exception e){System.out.println(e);}

      System.out.println(); System.out.println(); } }

    public static String imgToBase64String(final RenderedImage img, final String formatName) {
        final ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            ImageIO.write(img, formatName, Base64.getEncoder().wrap(os));
            return os.toString(StandardCharsets.ISO_8859_1.name());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ERROR";
    }

    public static BufferedImage base64StringToImg(final String base64String) {
        try {
            return ImageIO.read(new ByteArrayInputStream(Base64.getDecoder().decode(base64String)));
        } catch (final IOException ioe) {
            throw new UncheckedIOException(ioe);
        }
    }

}
