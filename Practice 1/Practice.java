public class Practice {
    public static void main(String[] args) {
        // 1
        System.out.println("№1");
        System.out.println(remainder(1, 3));
        System.out.println(remainder(3, 4));
        System.out.println(remainder(-9, 45));
        System.out.println(remainder(5, 5));
        System.out.println("-".repeat(10));

        // 2
        System.out.println("№2");
        System.out.println(triArea(3, 2));
        System.out.println(triArea(7, 4));
        System.out.println(triArea(10, 10));
        System.out.println("-".repeat(10));

        // 3
        System.out.println("№3");
        System.out.println(animals(2, 3, 5));
        System.out.println(animals(1, 2, 3));
        System.out.println(animals(5, 2, 8));
        System.out.println("-".repeat(10));

        // 4
        System.out.println("№4");
        System.out.println(profitableGamble(0.2, 50, 9));
        System.out.println(profitableGamble(0.9, 1, 2));
        System.out.println(profitableGamble(0.9, 3, 2));
        System.out.println("-".repeat(10));

        // 5
        System.out.println("№5");
        System.out.println(operation(24, 15, 9));
        System.out.println(operation(24, 26, 2));
        System.out.println(operation(15, 11, 11));
        System.out.println("-".repeat(10));

        // 6
        System.out.println("№6");
        System.out.println(ctoa('A'));
        System.out.println(ctoa('m'));
        System.out.println(ctoa('['));
        System.out.println(ctoa('\\'));
        System.out.println("-".repeat(10));

        // 7
        System.out.println("№7");
        System.out.println(addUpTo(3));
        System.out.println(addUpTo(10));
        System.out.println(addUpTo(7));
        System.out.println("-".repeat(10));

        // 8
        System.out.println("№8");
        System.out.println(nextEdge(8, 10));
        System.out.println(nextEdge(5, 7));
        System.out.println(nextEdge(9, 2));
        System.out.println("-".repeat(10));

        // 9
        System.out.println("№9");
        System.out.println(sumOfCubes(new int[] { 1, 5, 9 }));
        System.out.println(sumOfCubes(new int[] { 3, 4, 5 }));
        System.out.println(sumOfCubes(new int[] { 2 }));
        System.out.println(sumOfCubes(new int[] {}));
        System.out.println("-".repeat(10));

        // 10
        System.out.println("№10");
        System.out.println(abcmath(42, 5, 10));
        System.out.println(abcmath(5, 2, 1));
        System.out.println(abcmath(1, 2, 3));
        System.out.println("-".repeat(10));
    }

    // Вспомогательная функция, выводит остаток от деления №1
    public static int remainder(int firstNum, int secondNum) {
        int result;
        result = firstNum % secondNum;
        return result;
    }

    // Вычисление площади по формуле и возврат результата №2
    public static int triArea(int side, int heigh) {
        int result;
        result = (side * heigh) / 2;
        return result;
    }

    // Вспомогательная функция, вычисляет результат и возвращает его №3
    public static int animals(int chickens, int cows, int pigs) {
        int legsChicken = 2;
        int legsCows = 4;
        int legsPigs = 4;
        int result;
        result = chickens * legsChicken + cows * legsCows + pigs * legsPigs;
        return result;
    }

    // Вспомогательная функция, проверяет условие и возвращает логическое значение
    // №4
    public static boolean profitableGamble(double prob, double prize, double pay) {
        boolean result;
        result = prob * prize > pay;
        return result;
    }

    // Вспомогательная функиция, возвращает строку в соотвествии с условиями №5
    public static String operation(int N, int a, int b) {
        String result = "none";
        if (a + b == N) {
            result = "added";
            return result;
        } else if (a - b == N) {
            result = "subtracted";
            return result;
        } else if (a * b == N) {
            result = "multiplied";
            return result;
        } else if (a / b == N) {
            result = "divisied";
            return result;
        }
        return result;
    }

    // Возврат целого числа кода нашего символа №6
    public static int ctoa(char a) {
        int result;
        result = a;
        return result;
    }

    // Возврат суммы от 1 до нашего числа циклом №7
    public static int addUpTo(int a) {
        int result = 0;
        for (int i = 1; i <= a; ++i) {
            result += i;
        }
        return result;
    }

    /*
     * Возврат стороны треугольника по правилу:
     * сумма двух сторон больше третьей №8
     */
    public static int nextEdge(int a, int b) {
        int result = a + b - 1;
        return result;
    }

    // Вычисление результата №9
    public static int sumOfCubes(int[] a) {
        int len = a.length;
        int result = 0;
        for (int i = 0; i < len; ++i)
            result += Math.pow(a[i], 3);
        return result;
    }

    // Функция вычисления результата и возврат логической переменной №10
    public static boolean abcmath(int first, int second, int third) {
        boolean result = false;
        int a = first;
        int b = second;
        int c = third;
        for (int i = 0; i < b; ++i)
            a += a;
        if (a % c == 0) {
            result = true;
            return result;
        }
        return result;
    }
}
