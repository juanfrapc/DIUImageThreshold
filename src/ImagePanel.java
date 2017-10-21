
import boofcv.alg.filter.binary.GThresholdImageOps;
import boofcv.core.image.ConvertImage;
import boofcv.gui.binary.VisualizeBinaryData;
import boofcv.io.image.ConvertBufferedImage;
import boofcv.struct.image.GrayU8;
import boofcv.struct.image.Planar;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {

    private BufferedImage image;

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(File file) {
        try {
            this.image = ImageIO.read(file);
            this.setSize(image.getWidth(), image.getHeight());
        } catch (IOException ex) {
            System.out.println("NO existe la imagen");
        }
        this.repaint();
    }

    public void setImage(BufferedImage image) {
        this.image = image;
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
    }

    public void applyThreshold(int threshold) {
        // convierte la imagen en color BufferedImage en formato de la librería BoofCV
        Planar<GrayU8> imagenColor = ConvertBufferedImage.convertFromPlanar(image,
                null, true, GrayU8.class);

        // crea dos imágenes en niveles de grises
        GrayU8 imagenGris = new GrayU8(image.getWidth(), image.getHeight());
        GrayU8 imagenUmbralizada = new GrayU8(image.getWidth(), image.getHeight());

        // Convierte a niveles de gris la imagen de entrada
        ConvertImage.average(imagenColor, imagenGris);

        // umbraliza la imagen:  
        // - píxeles con nivel de gris > umbral se ponen a 1
        // - píxeles con nivel de gris <= umbra se ponen a 0
        GThresholdImageOps.threshold(imagenGris, imagenUmbralizada, threshold, false);

        image = VisualizeBinaryData.renderBinary(imagenUmbralizada, false, null);
        repaint();
    }

}
