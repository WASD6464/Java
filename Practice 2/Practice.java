import java.util.Arrays;

public class Practice {
    public static void main(String[] args) {
        // 1
        System.out.println("N1");
        System.out.println(repeat("mice", 5));
        System.out.println(repeat("hello", 3));
        System.out.println(repeat("stop", 1));
        System.out.println("-".repeat(10));

        // 2
        System.out.println("N2");
        System.out.println(differenceMaxMin(new int[] { 10, 4, 1, 4, -10, -50, 32, 21 }));
        System.out.println(differenceMaxMin(new int[] { 44, 32, 86, 19 }));
        System.out.println("-".repeat(10));

        // 3
        System.out.println("N3");
        System.out.println(isAvgWhole(new int[] { 1, 3 }));
        System.out.println(isAvgWhole(new int[] { 1, 2, 3, 4 }));
        System.out.println(isAvgWhole(new int[] { 1, 5, 6 }));
        System.out.println(isAvgWhole(new int[] { 1, 1, 1 }));
        System.out.println(isAvgWhole(new int[] { 9, 2, 2, 5 }));
        System.out.println("-".repeat(10));

        // 4
        System.out.println("N4");
        System.out.println(Arrays.toString(cumulativeSum(new int[] { 1, 2, 3 })));
        System.out.println(Arrays.toString(cumulativeSum(new int[] { 1, -2, 3 })));
        System.out.println(Arrays.toString(cumulativeSum(new int[] { 3, 3, -2, 408, 3, 3 })));
        System.out.println("-".repeat(10));

        // 5
        System.out.println("N5");
        System.out.println(getDecimalPlaces("43.20"));
        System.out.println(getDecimalPlaces("400"));
        System.out.println(getDecimalPlaces("3.1"));
        System.out.println("-".repeat(10));

        // 6
        System.out.println("N6");
        System.out.println(Fibonacci(3));
        System.out.println(Fibonacci(7));
        System.out.println(Fibonacci(12));
        System.out.println("-".repeat(10));

        // 7
        System.out.println("N7");
        System.out.println(isValid("59001"));
        System.out.println(isValid("853a7"));
        System.out.println(isValid("732 32"));
        System.out.println(isValid("393939"));
        System.out.println("-".repeat(10));

        // 8
        System.out.println("N8");
        System.out.println(isStrangePair("ratio", "orator"));
        System.out.println(isStrangePair("sparkling", "groups"));
        System.out.println(isStrangePair("bush", "hubris"));
        System.out.println(isStrangePair("", ""));
        System.out.println("-".repeat(10));

        // 9
        System.out.println("N9");
        System.out.println(isPrefix("automation", "auto-"));
        System.out.println(isSuffix("arachnophobia", "-phobia"));
        System.out.println(isPrefix("retrospect", "sub-"));
        System.out.println(isSuffix("vocation", "-logy"));
        System.out.println("-".repeat(10));

        // 10
        System.out.println("N10");
        System.out.println(boxSeq(0));
        System.out.println(boxSeq(1));
        System.out.println(boxSeq(2));
        System.out.println("-".repeat(10));
    }

    public static String repeat(String a, int n) {
        String result = "";
        for (int i = 0; i < a.length(); ++i) {
            for (int b = 0; b < n; ++b) {
                result += a.charAt(i);
            }
        }
        return result;
    }

    public static int differenceMaxMin(int[] a) {
        int min = a[0];
        int max = a[0];
        for (int i = 0; i < a.length; ++i) {
            if (a[i] > max) {
                max = a[i];
            }
            if (a[i] < min) {
                min = a[i];
            }
        }
        return max - min;
    }

    public static boolean isAvgWhole(int[] a) {
        int result = 0;
        for (int i : a) {
            result += i;
        }
        return ((result % a.length) == 0);
    }

    public static int[] cumulativeSum(int[] a) {
        int[] mass = a;
        for (int i = 1; i < a.length; ++i) {
            mass[i] += mass[i - 1];
        }
        return mass;
    }

    public static int getDecimalPlaces(String a) {
        int result = 0;
        int i = a.length() - 1;
        if (a.indexOf(".") != -1) {
            while (i >= 0 && (a.charAt(i) != '.')) {
                result += 1;
                i -= 1;
            }
        } else {
            return result;
        }
        return result;

    }

    public static int Fibonacci(int a) {
        int result = 0;
        int temp = 1;
        if (a > 0) {
            for (int i = 0; i <= a; ++i) {
                result += temp;
                temp = result - temp;
            }
        } else
            return result;
        return result;
    }

    public static boolean isValid(String a) {
        if (a.length() == 5) {
            try {
                Integer.parseInt(a);
                return true;
            } catch (Exception ignore) {
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean isStrangePair(String a, String b) {
        if (a.toCharArray().length == 0 && b.toCharArray().length == 0) {
            return true;
        } else if (a.toCharArray().length == 0 || b.toCharArray().length == 0) {
            return false;
        }
        if (b.toCharArray()[b.length() - 1] == a.toCharArray()[0]
                && a.toCharArray()[a.length() - 1] == b.toCharArray()[0]) {
            return true;
        }
        return false;
    }

    public static boolean isPrefix(String a, String b) {

        return a.startsWith(b.replace("-", ""));
    }

    public static boolean isSuffix(String a, String b) {
        return a.endsWith(b.replace("-", ""));
    }

    public static int boxSeq(int a) {
        int result = 0;
        for (int i = 1; i <= a; ++i) {
            if (i % 2 != 0) {
                result += 3;
            } else {
                result -= 1;
            }
        }
        return result;
    }
}
