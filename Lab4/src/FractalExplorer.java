import java.awt.geom.Rectangle2D;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.event.MouseInputListener;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.*;

public class FractalExplorer {

    private final double CLICK_NEW_SCALE = 0.5;
    private final String SCREEN_TITLE = "Множество мандельброта";
    private final String RESET_BUTTON_TEXT = "RESET";

    private JFrame frame;
    private JButton resetButton;
    private JImageDisplay image;
    private int screenSize;
    private FractalGenerator fractalGenerator;
    private Rectangle2D.Double currentRectangle;

    public FractalExplorer(int ScreenSize) {
        screenSize = ScreenSize;
        currentRectangle = new Rectangle2D.Double();
        fractalGenerator = new Mandelbrot();
        fractalGenerator.getInitialRange(currentRectangle);
    }

    public void createAndShowGUI() {

        frame = new JFrame();

        image = new JImageDisplay(screenSize, screenSize);

        resetButton = new JButton();
        resetButton.setText(RESET_BUTTON_TEXT);
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fractalGenerator.getInitialRange(currentRectangle);
                drawFractal();
            }
        });

        frame.add(image, BorderLayout.CENTER);
        frame.add(resetButton, BorderLayout.SOUTH);
        frame.setTitle(SCREEN_TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addMouseListener(new MouseInputListener() {

            @Override
            public void mouseClicked(MouseEvent e) {

                var xCoord = FractalGenerator.getCoord(
                        currentRectangle.x,
                        currentRectangle.x + currentRectangle.width,
                        screenSize, e.getX());
                var yCoord = FractalGenerator.getCoord(
                        currentRectangle.y,
                        currentRectangle.y + currentRectangle.width,
                        screenSize, e.getY());
                fractalGenerator.recenterAndZoomRange(currentRectangle, xCoord, yCoord, CLICK_NEW_SCALE);

                drawFractal();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseDragged(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                // TODO Auto-generated method stub

            }

        });

        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    public void drawFractal() {
        for (int x = 0; x < screenSize; x++) {
            for (int y = 0; y < screenSize; y++) {

                var xCoord = FractalGenerator.getCoord(
                        currentRectangle.x,
                        currentRectangle.x + currentRectangle.width,
                        screenSize, x);
                var yCoord = FractalGenerator.getCoord(
                        currentRectangle.y,
                        currentRectangle.y + currentRectangle.width,
                        screenSize, y);
                var iterations = fractalGenerator.numIterations(xCoord, yCoord);

                var color = iterations == -1 ? 0
                        : Color.HSBtoRGB(0.7f + (float) iterations / 200f, 1f, 1f);
                image.drawPixel(x, y, color);
            }
        }

        image.repaint();
    }
}
