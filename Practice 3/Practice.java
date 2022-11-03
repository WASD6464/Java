import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Practice {
    public static void main(String[] args) {

        // 1
        // System.out.println("N1");
        // System.out.println(solutions(1, 0, -1));
        // System.out.println(solutions(1, 0, 0));
        // System.out.println(solutions(1, 0, 1));
        // System.out.println("-".repeat(10));

        // 2
        // System.out.println("N2");
        // System.out.println(findZip("all zip files are zipped"));
        // System.out.println(findZip("all zip files are compressed"));
        // System.out.println("-".repeat(10));
        // System.out.println("-".repeat(10));

        // 3
        // System.out.println("N3");
        // System.out.println(checkPerfect(6));
        // System.out.println(checkPerfect(28));
        // System.out.println(checkPerfect(496));
        // System.out.println(checkPerfect(12));
        // System.out.println(checkPerfect(97));
        // System.out.println("-".repeat(10));

        // 4
        // System.out.println("N4");
        // System.out.println(flipEndChars("Cat, dog, and mouse."));
        // System.out.println(flipEndChars("ada"));
        // System.out.println(flipEndChars("Ada"));
        // System.out.println(flipEndChars("z"));
        // System.out.println("-".repeat(10));

        // 5
        // System.out.println("N5");
        // System.out.println(isValidHexCode("#CD5C5C"));
        // System.out.println(isValidHexCode("#EAECEE"));
        // System.out.println(isValidHexCode("#eaecee"));
        // System.out.println(isValidHexCode("#CD5C58C"));
        // System.out.println(isValidHexCode("#CD5C5Z"));
        // System.out.println(isValidHexCode("#CD5C&C"));
        // System.out.println(isValidHexCode("CD5C5C"));
        // System.out.println("-".repeat(10));

        // 6
        // System.out.println("N6);
        // System.out.println(same(new Integer[] { 1, 3, 4, 4, 4 }, new Integer[] { 2,
        // 5, 7 }));
        // System.out.println(same(new Integer[] { 9, 8, 7, 6 }, new Integer[] { 4, 4,
        // 3, 1 }));
        // System.out.println(same(new Integer[] { 2 }, new Integer[] { 3, 3, 3, 3, 3
        // }));
        // System.out.println("-".repeat(10));

        // 7
        // System.out.println("N7);
        // System.out.println(isKaprekar(3));
        // System.out.println(isKaprekar(5));
        // System.out.println(isKaprekar(297));
        // System.out.println("-".repeat(10));

        // 8
        // System.out.println("N8);
        // System.out.println(longestZero("01100001011000"));
        // System.out.println(longestZero("100100100"));
        // System.out.println(longestZero("11111"));
        // System.out.println("-".repeat(10));

        // 9
        // System.out.println("N9);
        // System.out.println(nextPrime(12));
        // System.out.println(nextPrime(24));
        // System.out.println(nextPrime(11));
        // System.out.println("-".repeat(10));

        // 10
        // System.out.println("N9);
        // System.out.println(rightTriangle(3, 4, 5));
        // System.out.println(rightTriangle(145, 105, 100));
        // System.out.println(rightTriangle(70, 130, 110));
        // System.out.println("-".repeat(10));
    }

    public static int solutions(int a, int b, int c) {
        if (a != 0 && b != 0 && c != 0) {
            double D = Math.sqrt(b * b - 4 * a * c);
            if (D > 0) {
                return 2;
            } else if (D == 0) {
                return 1;
            } else
                return 0;
        } else {
            if (a == 0) {
                return 1;
            } else if (b == 0) {
                if (c > 0) {
                    return 0;
                } else if (c < 0) {
                    return 2;
                } else if (c == 0)
                    return 1;
            }
        }
        return 0;
    }

    public static int findZip(String a) {
        int c = a.split("zip").length - 1;
        if (c == 2) {
            return a.lastIndexOf("zip");
        }
        return -1;
    }

    public static boolean checkPerfect(int a) {
        int result = -a;
        for (int i = 1; i <= Math.sqrt(a); ++i) {
            if (a % i == 0) {
                result += i;
                result += a / i;
            }
        }
        if (result == a) {
            return true;
        }
        return false;
    }

    public static String flipEndChars(String a) {
        if (a.length() < 2) {
            return "Incompatible.";
        } else {
            char first = a.charAt(0);
            char last = a.charAt(a.length() - 1);
            if (first == last) {
                return "Two's a pair.";
            } else {
                String temp = a.substring(1, a.length() - 1);
                return last + temp + first;
            }
        }
    }

    public static boolean isValidHexCode(String a) {
        a = a.toLowerCase();
        if (a.startsWith("#") && a.length() == 7) {
            for (int i = 1; i < a.length(); ++i) {
                int indexM = "0123456789abcdef".indexOf(a.charAt(i));
                if (indexM != -1) {
                    continue;
                } else
                    return false;
            }
        } else
            return false;
        return true;
    }

    public static boolean same(Integer[] a, Integer[] b) {
        Set<Integer> setA = new HashSet<Integer>();
        Collections.addAll(setA, a);
        Set<Integer> setB = new HashSet<Integer>();
        Collections.addAll(setB, b);
        if (setA.size() == setB.size()) {
            return true;
        } else
            return false;
    }

    public static boolean isKaprekar(int a) {
        int n2 = a * a;
        String str = Integer.toString(n2);
        if (str.length() % 2 == 0) {
            return ((n2 / Math.pow(10, str.length() / 2)) + (n2 % Math.pow(10, str.length() / 2)) == a);
        } else {
            return ((int) (n2 / Math.pow(10, (str.length() / 2) + 1))
                    + (n2 % Math.pow(10, (str.length() / 2) + 1)) == a);
        }
    }

    public static String longestZero(String a) {
        int counter = 0;
        int maxCount = counter;
        for (char i : a.toCharArray()) {
            if (i == '0') {
                counter += 1;
            } else {
                if (maxCount < counter) {
                    maxCount = counter;
                }
                counter = 0;
            }
        }
        return "0".repeat(maxCount);
    }

    public static int nextPrime(int a) {
        int counter = a;
        while (true) {
            int localCount = 0;
            for (int i = 2; i < counter; ++i) {
                if (counter % i == 0) {
                    localCount += 1;
                }
                if (localCount >= 1) {
                    counter += 1;
                    break;
                }
            }
            if (localCount == 0) {
                return counter;
            } else
                return nextPrime(counter);
        }
    }

    public static boolean rightTriangle(int a, int b, int c) {
        int summ = a + b + c;
        int add = a * b * c;
        int gipo = Math.max(Math.max(a, b), c);
        summ -= gipo;
        add = add / gipo;
        return (Math.pow(gipo, 2) == (Math.pow(summ, 2) - 2 * add));

    }
}
