import java.nio.charset.StandardCharsets;
import java.util.*;

import com.google.common.hash.Hashing;

public class Practice {
    public static void main(String[] args) {
        // 1
        System.out.println("N1");
        System.out.println(encrypt("Hello"));
        System.out.println(decrypt(new Integer[]{72, 33, -73, 84, -12, -3, 13, -13, -68}));
        System.out.println(encrypt("Sunshine"));
        System.out.println("-".repeat(10));

        // 2
        System.out.println("N2");
        System.out.println(canMove("Rook", "A8", "H8"));
        System.out.println(canMove("Bishop", "A7", "G1"));
        System.out.println(canMove("Queen", "C4", "D6"));
        System.out.println(canMove("King", "C4", "B3"));
        System.out.println(canMove("Knight", "C4", "A3"));
        System.out.println(canMove("Pawn", "B7", "B5"));
        System.out.println("-".repeat(10));

        // 3
        System.out.println("N3");
        System.out.println(canComplete("butl", "beautiful"));
        System.out.println(canComplete("butlz", "beautiful"));
        System.out.println(canComplete("tulb", "beautiful"));
        System.out.println(canComplete("bbutl", "beautiful"));
        System.out.println("-".repeat(10));

        // 4
        System.out.println("N4");
        System.out.println(sumDigProd(16, 28));
        System.out.println(sumDigProd(0));
        System.out.println(sumDigProd(1, 2, 3, 4, 5, 6));
        System.out.println("-".repeat(10));

        // 5
        System.out.println("N5");
        System.out.println(sameVowelGroup(new String[]{"toe", "ocelot", "maniac"}));
        System.out.println(sameVowelGroup(new String[]{"many", "carriage", "emit", "apricot", "animal"}));
        System.out.println(sameVowelGroup(new String[]{"hoops", "chuff", "bot", "bottom"}));
        System.out.println("-".repeat(10));

        // 6
        System.out.println("N6");
        System.out.println(validateCard(1234567890123456L));
        System.out.println(validateCard(1234567890123452L));
        System.out.println("-".repeat(10));

        // 7
        System.out.println("N7");
        System.out.println(numToEng(0));
        System.out.println(numToEng(18));
        System.out.println(numToEng(126));
        System.out.println(numToEng(909));
        System.out.println(numToRus(0));
        System.out.println(numToRus(18));
        System.out.println(numToRus(126));
        System.out.println(numToRus(909));
        System.out.println("-".repeat(10));

        // 8
        System.out.println("N8");
        System.out.println(getSha256Hash("password123"));
        System.out.println(getSha256Hash("Fluffy@home"));
        System.out.println(getSha256Hash("Hey dude!"));
        System.out.println("-".repeat(10));

        // 9
        System.out.println("N9");
        System.out.println(correctTitle("jOn SnoW, kINg IN thE noRth."));
        System.out.println(correctTitle("sansa stark, lady of winterfell."));
        System.out.println(correctTitle("TYRION LANNISTER, HAND OF THE QUEEN."));
        System.out.println("-".repeat(10));

        // 10
        System.out.println("N10");
        System.out.println(hexLattice(1));
        System.out.println(hexLattice(7));
        System.out.println(hexLattice(19));
        System.out.println(hexLattice(21));
        System.out.println("-".repeat(10));
    }

    public static List<Integer> encrypt(String a) {
        List<Integer> result = new ArrayList<>();
        result.add((int) a.charAt(0));
        int temp = (int) a.charAt(0);
        for (int i = 1; i < a.length(); ++i) {
            result.add((int) a.charAt(i) - temp);
            temp = (int) a.charAt(i);
        }
        return result;
    }

    public static String decrypt(Integer[] a) {
        String result = "";
        int temp = 0;
        int res = 0;
        for (int i : a) {
            res = temp - i;
            result += String.valueOf((char) -res);
            temp = res;
        }
        return result;
    }

    public static boolean canMove(String a, String b, String c) {
        Map<Character, Integer> dict = new HashMap<Character, Integer>();
        dict.put('A', 1);
        dict.put('B', 2);
        dict.put('C', 3);
        dict.put('D', 4);
        dict.put('E', 5);
        dict.put('F', 6);
        dict.put('G', 7);
        dict.put('H', 8);
        Integer[] f = new Integer[2];
        f[0] = (dict.get(b.charAt(0)));
        f[1] = Character.getNumericValue(b.charAt(1));
        Integer[] s = new Integer[2];
        s[0] = (dict.get(c.charAt(0)));
        s[1] = Character.getNumericValue(c.charAt(1));
        boolean RookEq = f[0].equals(s[0]) || f[1].equals(s[1]);
        boolean BishopEq = Math.abs(f[0] - s[0]) == Math.abs(f[1] - s[1]);
        boolean KingEq = ((Math.abs(f[0] - s[0]) <= 1) && (Math.abs(f[1] - s[1]) <= 1));
        boolean KnightEq = ((Math.abs(s[0] - f[0]) == 1 && Math.abs(s[1] - f[1]) == 2) || (Math.abs(s[0] - f[0]) == 2 && Math.abs(s[1] - f[1]) == 1));
        boolean PawnEq = f[1] - s[1] == 1 && f[0] == s[0];
        if (a.equals("Rook")) {
            if (RookEq) return true;
            else return false;
        }
        if (a.equals("Bishop")) {
            if (BishopEq) return true;
            else return false;
        }
        if (a.equals("Queen")) {
            if (KingEq || BishopEq || RookEq) return true;
            else return false;
        }
        if (a.equals("King")) {
            if (KingEq) return true;
            else return false;
        }
        if (a.equals("Knight")) {
            if (KnightEq) return true;
            else return false;
        }
        if (a.equals("Pawn")) {
            if (f[1] == 2) {
                if (s[1] - f[1] <= 2 && s[1] - f[1] >= 1 && f[0] == s[0]) return true;
                else return false;

            } else if (f[1] == 7) {
                if (f[1] - s[1] <= 2 && f[1] - s[1] >= 1 && f[0] == s[0]) return true;
                else return false;
            } else if (PawnEq) return true;
            else return false;
        }
        return false;
    }

    public static boolean canComplete(String a, String b) {
        Stack<Integer> first = new Stack<>();
        new StringBuilder(a).reverse().chars().forEach(first::push);
        b.chars().forEach(c -> {
            if (c == first.peek()) {
                first.pop();
            }
        });
        return first.empty();
    }

    public static int sumDigProd(int... numbers) {
        int num = Arrays.stream(numbers).sum();
        while (num / 10 != 0) {
            num = String.valueOf(num).chars().map(x -> x - '0').reduce(1, (x, y) -> x * y);
        }
        return num;
    }

    public static List<String> sameVowelGroup(String[] a) {
        List<String> result = new ArrayList<>();
        result.add(a[0]);
        Map<Character, Boolean> Vowels = new HashMap<>();
        Vowels.put('a', true);
        Vowels.put('e', true);
        Vowels.put('i', true);
        Vowels.put('o', true);
        Vowels.put('u', true);
        Vowels.put('y', true);
        String VowelsString = new String();
        String temp = a[0];
        for (int i = 0; i < temp.length(); ++i) {
            try {
                if (Vowels.get(temp.charAt(i))) {
                    VowelsString += String.valueOf(temp.charAt(i));
                }
            } catch (NullPointerException e) {
                continue;
            }
        }
        for (int i = 1; i < a.length; ++i) {
            int flag = 0;
            for (char c : VowelsString.toCharArray()) {
                if (a[i].indexOf(String.valueOf(c)) == -1)
                    flag += 1;
            }
            if (flag == 0)
                result.add(a[i]);
        }
        return result;
    }

    public static boolean validateCard(long a) {
        long checkNum = a % 10;
        long cardToProcess = a / 10;
        StringBuilder temp = new StringBuilder();
        temp.append(cardToProcess).reverse();
        char[] toProcess = temp.toString().toCharArray();
        List<Integer> summ = new ArrayList<>();
        for (int i = 0; i < temp.length(); ++i) {
            int multi = Character.getNumericValue(toProcess[i]);
            if (i % 2 == 0) {
                multi *= 2;
                if (multi >= 10) {
                    multi = Integer.valueOf(Character.getNumericValue(String.valueOf(multi).charAt(0))) + Integer.valueOf(Character.getNumericValue(String.valueOf(multi).charAt(1)));
                }
            }
            summ.add(multi);
        }
        Integer sum = summ.stream()
                .reduce(0, Integer::sum);
        String lastSum = String.valueOf(String.valueOf(sum).charAt(String.valueOf(sum).length() - 1));
        return ((10L - Integer.valueOf(lastSum)) == (checkNum));
    }

    public static String numToEng(int number) {
        HashMap<Integer, String> numToWord = new HashMap<>() {{
            put(0, "zero");
            put(1, "one");
            put(2, "two");
            put(3, "three");
            put(4, "four");
            put(5, "five");
            put(6, "six");
            put(7, "seven");
            put(8, "eight");
            put(9, "nine");
            put(10, "ten");
            put(11, "eleven");
            put(12, "twelve");
            put(13, "thirteen");
            put(14, "fourteen");
            put(15, "fifteen");
            put(16, "sixteen");
            put(17, "seventeen");
            put(18, "eighteen");
            put(19, "nineteen");
            put(20, "twenty");
            put(30, "thirty");
            put(40, "forty");
            put(50, "fifty");
            put(60, "sixty");
            put(70, "seventy");
            put(80, "eighty");
            put(90, "ninety");
            put(100, "one hundred");
            put(200, "two hundreds");
            put(300, "three hundreds");
            put(400, "four hundreds");
            put(500, "five hundreds");
            put(600, "six hundreds");
            put(700, "seven hundreds");
            put(800, "eight hundreds");
            put(900, "nine hundreds");
        }};

        if (numToWord.containsKey(number)) {
            return numToWord.get(number);
        } else {
            if (number > 100) {
                return String.format("%s %s", numToWord.get(number / 100 * 100), numToEng(number % 100));
            } else {
                return String.format("%s %s", numToWord.get(number / 10 * 10), numToEng(number % 10));
            }
        }
    }

    public static String numToRus(int number) {
        HashMap<Integer, String> numToWord = new HashMap<>() {{
            put(0, "ноль");
            put(1, "один");
            put(2, "два");
            put(3, "три");
            put(4, "четыре");
            put(5, "пять");
            put(6, "шесть");
            put(7, "семь");
            put(8, "восемь");
            put(9, "девять");
            put(10, "десять");
            put(11, "одинадцать");
            put(12, "двенадцать");
            put(13, "тренадцать");
            put(14, "четырнадцать");
            put(15, "пятнадцать");
            put(16, "шестнадцать");
            put(17, "семнадцать");
            put(18, "восемнадцать");
            put(19, "девятнацать");
            put(20, "двадцать");
            put(30, "тридцать");
            put(40, "сорок");
            put(50, "пятдесят");
            put(60, "шестьдесят");
            put(70, "семьдесят");
            put(80, "восемьдесят");
            put(90, "девятьдесят");
            put(100, "сто");
            put(200, "двести");
            put(300, "триста");
            put(400, "четыреста");
            put(500, "пятьсот");
            put(600, "шестьсот");
            put(700, "семьсот");
            put(800, "восемьсот");
            put(900, "девятьсот");
        }};

        if (numToWord.containsKey(number)) {
            return numToWord.get(number);
        } else {
            if (number > 100) {
                return String.format("%s %s", numToWord.get(number / 100 * 100), numToRus(number % 100));
            } else {
                return String.format("%s %s", numToWord.get(number / 10 * 10), numToRus(number % 10));
            }
        }
    }

    public static String getSha256Hash(String message) {
        return Hashing.sha256().hashString(message, StandardCharsets.UTF_8).toString();
    }

    public static String correctTitle(String str) {

        String[] words = str.toLowerCase().split(" ");
        String res = "";

        for (String word : words) {

            if (!word.equals("of") && !word.equals("in") && !word.equals("and") && !word.equals("the"))
                res += word.substring(0, 1).toUpperCase() + word.substring(1) + " ";
            else
                res += word.toLowerCase() + " ";

        }

        return res;

    }

    public static String hexLattice(int n) {
        int numIters = 1;
        int correct = 1;

        while (correct < n) {
            correct += 6 * numIters;
            numIters++;
        }
        if (correct != n)
            return "недопустимое";
        int sizeHeight = numIters * 2 - 1;
        int sizeWithSpaces = sizeHeight * 2 - 1;
        String[] hex = new String[sizeHeight];

        for (int i = numIters - 1; i >= 0; i--) {

            int rowSizeWithSpaces = (numIters + i) * 2 - 1;
            int space = (sizeWithSpaces - rowSizeWithSpaces) / 2;

            hex[i] = " ".repeat(space) + "o ".repeat(numIters + i);

            if (i != numIters) {
                hex[sizeHeight - i - 1] = hex[i];
            }

        }

        String res = "";
        for (String s : hex) {

            res += s + "\n";

        }

        return res;

    }
}