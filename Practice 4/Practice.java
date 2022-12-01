import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Practice {
    public static void main(String[] args) {
        // 1
        System.out.println("N1");
        Bessie(10, 7, "hello my name is Bessie and this is my essay");
        System.out.println("-".repeat(10));

        // 2
        System.out.println("N2");
        System.out.println(split("()()()"));
        System.out.println(split("((()))"));
        System.out.println(split("((()))(())()()(()())"));
        System.out.println(split("((())())(()(()()))"));
        System.out.println("-".repeat(10));

        // 3
        System.out.println("N3");
        System.out.println(toCamelCase("hello_edabit"));
        System.out.println(toSnakeCase("helloEdabit"));
        System.out.println(toCamelCase("is_modal_open"));
        System.out.println(toSnakeCase("getColor"));
        System.out.println("-".repeat(10));

        // 4
        System.out.println("N4");
        System.out.println(overTime(new double[] { 9, 17, 30, 1.5 }));
        System.out.println(overTime(new double[] { 16, 18, 30, 1.8 }));
        System.out.println(overTime(new double[] { 13.25, 15, 30, 1.5 }));
        System.out.println("-".repeat(10));

        // 5
        System.out.println("N5");
        System.out.println(BMI("205 pounds", "73 inches"));
        System.out.println(BMI("55 kilos", "1.65 meters"));
        System.out.println(BMI("154 pounds", "2 meters"));
        System.out.println("-".repeat(10));

        // 6
        System.out.println("N6");
        System.out.println(bugger(39));
        System.out.println(bugger(999));
        System.out.println(bugger(4));
        System.out.println("-".repeat(10));

        // 7
        System.out.println("N7");
        System.out.println(toStarShorthand("abbccc"));
        System.out.println(toStarShorthand("77777geff"));
        System.out.println(toStarShorthand("abc"));
        System.out.println(toStarShorthand(""));
        System.out.println("-".repeat(10));

        // 8
        System.out.println("N8");
        System.out.println(doesRhyme("Sam I am!", "Green eggs and ham."));
        System.out.println(doesRhyme("Sam I am!", "Green eggs and HAM."));
        System.out.println(doesRhyme("You are off to the races", "a splendid day."));
        System.out.println(doesRhyme("and frequently do?", "you gotta move."));
        System.out.println("-".repeat(10));

        // 9
        System.out.println("N9");
        System.out.println(trouble(451999277, 41177722899L));
        System.out.println(trouble(1222345, 12345));
        System.out.println(trouble(666789, 12345667));
        System.out.println(trouble(33789, 12345337));
        System.out.println("-".repeat(10));

        // 10
        System.out.println("N10");
        System.out.println(countUniqueBooks("AZYWABBCATTTA", 'A'));
        System.out.println(countUniqueBooks("$AA$BBCATT$C$$B$", '$'));
        System.out.println(countUniqueBooks("ZZABCDEF", 'Z'));
        System.out.println("-".repeat(10));
    }

    public static void Bessie(int n, int k, String a) {
        String[] str = a.split(" ");
        String word = str[0];
        int len = word.length();
        for (int i = 1; i < n; ++i) {
            if ((len += str[i].length()) <= k) {
                word += " " + str[i];
            } else {
                System.out.println(word);
                word = str[i];
                len = word.length();
            }
        }

        if (len < k) {
            System.out.println(word);
        }
    }

    public static List<String> split(String a) {
        List<String> result = new ArrayList<>();
        String buffer = new String();
        int counter = 0;
        for (int i = 0; i < a.length(); ++i) {
            if (counter == 0 && i != 0) {
                result.add(buffer);
                buffer = "";
            }
            if (a.charAt(i) == '(') {
                buffer += a.charAt(i);
                counter++;
            }
            if (a.charAt(i) == ')') {
                buffer += a.charAt(i);
                counter--;
            }
        }
        result.add(buffer);
        return result;
    }

    public static String toCamelCase(String a) {
        String result = "";
        for (int i = 0; i < a.length(); ++i) {
            if (a.charAt(i) != '_') {
                result += a.charAt(i);
            } else {
                result += String.valueOf(a.charAt(i + 1)).toUpperCase();
                ++i;
            }
        }
        return result;
    }

    public static String toSnakeCase(String a) {
        String result = "";
        int iterator = 0;
        while (iterator < a.length()) {
            String temp = String.valueOf(a.charAt(iterator));
            if (temp == temp.toUpperCase()) {
                result += "_" + temp.toLowerCase();
            } else {
                result += temp;
            }
            iterator++;
        }
        return result;
    }

    public static String overTime(double[] a) {
        double result = 0;
        if (a[1] < 17)
            result = (a[1] - a[0]) * a[2];
        else
            result = (17 - a[0]) * a[2] + (a[1] - 17) * a[2] * a[3];
        return "$" + result + "0";
    }

    public static String BMI(String w, String h) {
        double weight = Double.parseDouble(w.substring(0, w.lastIndexOf(" ")));
        if (w.endsWith("pounds"))
            weight = weight * 0.453592;
        double height = Double.parseDouble(h.substring(0, h.lastIndexOf(" ")));
        if (h.endsWith("inches"))
            height = height * 0.0254;
        double bmi = weight / (height * height);
        if (bmi < 18.5)
            return String.format("%.1f", bmi) + " Underweight";
        else if (bmi >= 25)
            return String.format("%.1f", bmi) + " Overweight";
        return String.format("%.1f", bmi) + " Normal weight";
    }

    public static int bugger(int a) {
        String number = String.valueOf(a);
        int count = 0;
        while (a / 10 != 0) {
            a = 1;
            for (int i = 0; i < number.length(); ++i) {
                a *= Integer.parseInt(String.valueOf(number.charAt(i)));
            }
            number = String.valueOf(a);
            ++count;
        }
        return count;
    }

    public static String toStarShorthand(String a) {
        if (a.length() == 0)
            return "";
        String result = "";
        int counter = 1;
        char[] iterator = a.toCharArray();
        char last = iterator[0];
        for (int i = 1; i < a.length(); ++i) {
            if (iterator[i] == last) {
                counter++;
            } else {
                if (counter > 1) {
                    result += last + "*" + String.valueOf(counter);
                    counter = 1;
                } else
                    result += last;
                counter = 1;
            }
            last = iterator[i];
        }
        if (counter != 1)
            result += last + "*" + String.valueOf(counter);
        else
            result += last;
        return result;
    }

    public static boolean doesRhyme(String a, String b) {
        String first = a.split(" ")[a.split(" ").length - 1].toLowerCase();
        String second = b.split(" ")[b.split(" ").length - 1].toLowerCase();
        char[] dict = { 'a', 'e', 'i', 'o', 'u', 'y' };
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        for (int i = 0; i < first.length(); ++i) {
            for (int j = 0; j < dict.length; ++j) {
                if (first.charAt(i) == dict[j]) {
                    list1.add((int) dict[j]);
                }
            }
        }

        for (int i = 0; i < second.length(); ++i) {
            for (int j = 0; j < dict.length; ++j) {
                if (second.charAt(i) == dict[j]) {
                    list2.add((int) dict[j]);
                }
            }
        }
        return list1.equals(list2);
    }

    public static boolean trouble(long a, long b) {
        String first = String.valueOf(a);
        String second = String.valueOf(b);
        for (int i = 0; i < 10; ++i) {
            String num = String.valueOf(i);
            int firstNum = 0;
            int secondNum = 0;
            for (char ch : first.toCharArray()) {
                if (num.equals(String.valueOf(ch)))
                    firstNum++;
            }
            for (char ch : second.toCharArray()) {
                if (num.equals(String.valueOf(ch)))
                    secondNum++;
            }
            if (firstNum == 3 && secondNum == 2)
                return true;
        }
        return false;
    }

    public static int countUniqueBooks(String stringSequence, char bookEnd) {
        List<Integer> setOfEnds = new ArrayList<>();
        Set<Character> set = new HashSet<Character>();

        int i = 0;
        while (true) {
            if (!(setOfEnds.contains(stringSequence.indexOf(bookEnd, i)))) {
                setOfEnds.add(i = stringSequence.indexOf(bookEnd, i));
                if (i == -1) {
                    break;
                }
                ++i;
            }
        }
        setOfEnds.remove(setOfEnds.size() - 1);

        for (int j = 0; j < setOfEnds.size() - 1; j += 2) {
            for (int k = setOfEnds.get(j) + 1; k < setOfEnds.get(j + 1); ++k) {
                set.add(stringSequence.charAt(k));
            }
        }
        return set.size();
    }
}
