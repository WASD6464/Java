import java.awt.image.BufferedImage;
import java.awt.*;

public class JImageDisplay extends javax.swing.JComponent {

    private BufferedImage image;

    public JImageDisplay(int x, int y) {
        this.image = new BufferedImage(x, y, BufferedImage.TYPE_INT_RGB);
        this.setPreferredSize(new Dimension(x, y));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
    }

    public void clearImage() {
        for (int i = 0; i < this.image.getWidth(); ++i) {
            for (int j = 0; j < this.image.getHeight(); ++j) {
                this.image.setRGB(i, j, 0);
            }
        }
    }

    public void drawPixel(int x, int y, int rgbColor) {
        this.image.setRGB(x, y, rgbColor);
    }
}