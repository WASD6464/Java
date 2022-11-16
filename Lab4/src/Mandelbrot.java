import java.awt.geom.Rectangle2D;

public class Mandelbrot extends FractalGenerator {
    public static final int MAX_ITERATIONS = 2000;

    public void getInitialRange(Rectangle2D.Double range) {
        range.x = -2;
        range.y = -1.5;
        range.width = 3;
        range.height = 3;
    }

    @Override
    public int numIterations(double x, double y) {
        Complex Z = new Complex(0, 0);
        Complex C = new Complex(x, y);

        for (int i = 0; i < MAX_ITERATIONS; ++i) {
            if (Z.compareModulePow2(4) >= 0) {
                return i;
            }
            Z.InSquare();
            Z.Add(C);
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Mandelbrot";
    }
}