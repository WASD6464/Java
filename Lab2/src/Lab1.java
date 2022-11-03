import java.util.Scanner;

public class Lab1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Point3d firstPoint = new Point3d(input.nextDouble(), input.nextDouble(), input.nextDouble());
        Point3d secondPoint = new Point3d(input.nextDouble(), input.nextDouble(), input.nextDouble());
        Point3d thirdPoint = new Point3d(input.nextDouble(), input.nextDouble(), input.nextDouble());
        input.close();
        if (firstPoint.equals(secondPoint) | firstPoint.equals(thirdPoint) | secondPoint.equals(thirdPoint)) {
            System.out.println("Некоторые ваши точки одинаковые");
        } else {
            System.out.println(computeArea(firstPoint, secondPoint, thirdPoint));
        }
    }

    public static double computeArea(Point3d firstPoint, Point3d secondPoint, Point3d thirdPoint) {
        double P = (firstPoint.distanceTo(secondPoint) + secondPoint.distanceTo(thirdPoint)
                + thirdPoint.distanceTo(firstPoint)) / 2;
        return Math.sqrt(P * (P - firstPoint.distanceTo(secondPoint)) * (P - secondPoint.distanceTo(thirdPoint))
                * (P - thirdPoint.distanceTo(firstPoint)));
    }
}