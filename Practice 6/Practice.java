import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Practice {
    public static void main(String[] args) {

        // 1
        System.out.println("N1");
        System.out.println(bell(1));
        System.out.println(bell(2));
        System.out.println(bell(3));
        System.out.println("-".repeat(10));

        // 2
        System.out.println("N2");
        System.out.println(translateWord("flag"));
        System.out.println(translateWord("Apple"));
        System.out.println(translateWord("button"));
        System.out.println(translateWord(""));
        System.out.println(translateSentence("I like to eat honey waffles."));
        System.out.println(translateSentence("Do you think it is going to rain today?"));
        System.out.println("-".repeat(10));

        // 3
        System.out.println("N3");
        System.out.println(validColor("rgb(0,0,0)"));
        System.out.println(validColor("rgb(0,,0)"));
        System.out.println(validColor("rgb(255,256,255)"));
        System.out.println(validColor("rgba(0,0,0,0.123456789)"));
        System.out.println("-".repeat(10));

        // 4
        System.out.println("N4");
        System.out.println(stripUrlParams("https://edabit.com?a=1&b=2&a=2"));
        System.out.println(stripUrlParams("https://edabit.com?a=1&b=2&a=2", new String[] { "b" }));
        System.out.println(stripUrlParams("https://edabit.com", new String[] { "b" }));
        System.out.println("-".repeat(10));

        // 5
        System.out.println("N5");
        System.out.println(getHashTags("How the Avocado Became the Fruit of the Global Trade"));
        System.out.println(getHashTags("Why You Will Probably Pay More for Your Christmas Tree This Year"));
        System.out.println(getHashTags("Hey Parents, Surprise, Fruit Juice Is Not Fruit"));
        System.out.println(getHashTags("Visualizing Science"));
        System.out.println("-".repeat(10));

        // 6
        System.out.println("N6");
        System.out.println(ulam(4));
        System.out.println(ulam(9));
        System.out.println(ulam(206));
        System.out.println("-".repeat(10));

        // 7
        System.out.println("N7");
        System.out.println(longestNonrepeatingSubstring("abcabcbb"));
        System.out.println(longestNonrepeatingSubstring("aaaaaa"));
        System.out.println(longestNonrepeatingSubstring("abcde"));
        System.out.println(longestNonrepeatingSubstring("abcda"));
        System.out.println("-".repeat(10));

        // 8
        System.out.println("N8");
        System.out.println(convertToRoman(2));
        System.out.println(convertToRoman(12));
        System.out.println(convertToRoman(16));
        System.out.println("-".repeat(10));

        // 9
        System.out.println("N9");
        System.out.println(formula("6 * 4 = 24"));
        System.out.println(formula("18 / 17 = 2"));
        System.out.println(formula("16 * 10 = 160 = 14 + 120"));
        System.out.println("-".repeat(10));

        // 10
        System.out.println("N10");
        System.out.println(palindromedescendant(11211230));
        System.out.println(palindromedescendant(13001120));
        System.out.println(palindromedescendant(23336014));
        System.out.println(palindromedescendant(11));
        System.out.println("-".repeat(10));

    }

    public static int bell(int n) {

        ArrayList<ArrayList<Integer>> resulted = new ArrayList<>(n);
        ArrayList<Integer> firstRow = new ArrayList<>(1);

        firstRow.add(1);
        resulted.add(firstRow);

        for (int i = 1; i < n; i++) {

            ArrayList<Integer> newArray = new ArrayList<>(i + 1);
            ArrayList<Integer> lastArray = resulted.get(resulted.size() - 1);

            newArray.add(lastArray.get(lastArray.size() - 1));
            for (int k = 0; k < i; k++) {
                newArray.add(lastArray.get(k) + newArray.get(k));
            }
            resulted.add(newArray);

        }

        ArrayList<Integer> lastRow = resulted.get(resulted.size() - 1);

        return lastRow.get(lastRow.size() - 1);

    }

    public static String translateWord(String a) {
        String result = "";
        if ("".equals(a)) {
            return result;
        }
        String[] dict = new String[] { "a", "e", "i", "o", "u", "y", "A", "E", "I", "O", "U", "Y" };
        if (List.of(dict).contains(String.valueOf(a.charAt(0)))) {
            return a + "yay";
        }
        int counter = 0;
        while (counter < a.length()) {
            if (List.of(dict).contains(String.valueOf(a.charAt(counter)))) {
                break;
            }
            ++counter;
        }
        String sub = a.substring(0, counter);
        result = a.substring(counter) + sub + "ay";
        if (Character.isUpperCase(a.charAt(0))) {
            return result.substring(0, 1).toUpperCase() + result.substring(1).toLowerCase();
        }
        return result;
    }

    public static String translateSentence(String a) {

        Matcher matcher = Pattern.compile("\\w+").matcher(a);

        return matcher.replaceAll(matchResult -> translateWord(matchResult.group()));

    }

    public static boolean validColor(String str) {

        Matcher matcher = Pattern.compile("\\d+\\.?\\d*").matcher(str);

        Integer r = null;
        Integer g = null;
        Integer b = null;
        Double a = null;
        while (matcher.find()) {
            try {
                if (r == null) r = Integer.parseInt(matcher.group());
                else if (g == null) {
                    g = Integer.parseInt(matcher.group());
                } else if (b == null) {
                    b = Integer.parseInt(matcher.group());
                } else if (a == null) {
                    a = Double.parseDouble(matcher.group());
                }
            } catch (Exception e) {
                return false;
            }
        }

        if (r == null || r > 255 || r < 0) return false;
        if (g == null || g > 255 || g < 0) return false;
        if (b == null || b > 255 || b < 0) return false;
        if (a != null && ((a > 1) || a < 0)) return false;

        return (a == null && str.contains("rgb")) || (a != null && str.contains("rgba"));

    }

    public static String stripUrlParams(String url, String[] paramsToStrip) {

        if (!url.contains("?")) {
            return url;
        }

        String[] params = url.substring(url.indexOf("?") + 1).split("&");

        Map<String, String> paramsMap = new HashMap<>();

        for (String param : params) {

            String[] keys = param.split("=");
            if (List.of(paramsToStrip).contains(keys[0])) {
                continue;
            }
            paramsMap.put(keys[0], keys[1]);

        }

        String res = url.substring(0, url.indexOf("?") + 1);
        for (Map.Entry<String, String> entry : paramsMap.entrySet()) {

            res += entry.getKey() + "=" + entry.getValue() + "&";

        }

        return res.substring(0, res.length() - 1);

    }

    public static String stripUrlParams(String url) {
        return stripUrlParams(url, new String[] {});
    }

    public static String[] getHashTags(String str) {

        ArrayList<String> words = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\w+").matcher(str);
        while (matcher.find()) {
            words.add(matcher.group());
        }

        String[] maxes = new String[3];

        for (String word : words) {

            if (maxes[0] == null || word.length() > maxes[0].length()) {
                maxes[2] = maxes[1];
                maxes[1] = maxes[0];
                maxes[0] = word;
            } else if (maxes[1] == null || word.length() > maxes[1].length()) {
                maxes[2] = maxes[1];
                maxes[1] = word;
            } else if (maxes[2] == null || word.length() > maxes[2].length()) {
                maxes[2] = word;
            }

        }
        ArrayList<String> res = new ArrayList<>();

        for (int i = 0; i < maxes.length; i++) {
            if (maxes[i] == null)
                break;
            res.add("#" + maxes[i].toLowerCase());
        }
        return res.toArray(new String[0]);

    }

    public static int ulam(int n) {

        Map<Integer, Integer> savedSums = new TreeMap<>();

        ArrayList<Integer> ulams = new ArrayList<>();
        ulams.add(1);
        ulams.add(2);
        ulams.add(3);

        for (int i = 2; i < n - 1; i++) {
            Integer newSum = null;

            for (int k = 0; k < i; k++) {
                int currentSum = ulams.get(ulams.size() - 1) + ulams.get(k);
                if (newSum == null && !savedSums.containsKey(currentSum)) {
                    newSum = currentSum;
                }
                savedSums.merge(currentSum, 1, Integer::sum);
            }

            for (Map.Entry<Integer, Integer> entry : savedSums.entrySet()) {
                if (newSum > entry.getKey() && entry.getValue() == 1) {
                    newSum = entry.getKey();
                    break;
                }
            }
            ulams.add(newSum);
            savedSums.remove(newSum);
        }

        return ulams.get(n - 1);

    }

    public static String longestNonrepeatingSubstring(String str) {

        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        String max = "";

        while (right < str.length()) {
            map.put(str.charAt(right), map.getOrDefault(str.charAt(right), 0) + 1);

            if (map.size() == right - left + 1) {
                if (max.length() < right - left + 1) {
                    max = str.substring(left, right - left + 1);
                }

                right++;
            } else if (map.size() < right - left + 1) {
                while (map.size() < right - left + 1) {
                    map.put(str.charAt(left), map.get(str.charAt(left)) - 1);
                    if (map.get(str.charAt(left)) == 0)
                        map.remove(str.charAt(left));
                    left++;
                }
                right++;
            }
        }
        return max;

    }

    public static String convertToRoman(int num) {

        int m = num / 1000;
        num -= m * 1000;

        int d = num / 500;
        num -= d * 500;

        int c = num / 100;
        num -= c * 100;

        int l = num / 50;
        num -= l * 50;

        int x = num / 10;
        num -= x * 10;

        String[] basic = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };

        String res = "";

        res += "M".repeat(m);

        if (c == 4) {
            if (d == 1) {
                res += "CM";
            } else {
                res += "CD";
            }
        } else {
            res += "D".repeat(d);
            res += "C".repeat(c);
        }

        if (x == 4) {
            if (l == 1) {
                res += "XC";
            } else {
                res += "XL";
            }
        } else {
            res += "L".repeat(d);
            res += "X".repeat(c);
        }

        res += basic[num];

        return res;

    }

    public static boolean formula(String formula) {

        String[] expressions = formula.split("=");

        Matcher matcherDigit = Pattern.compile("\\d+").matcher("");
        Matcher matcherOperators = Pattern.compile("[*/+-]").matcher("");

        Double last = null;

        for (String expression : expressions) {
            ArrayList<Integer> digits = new ArrayList<>();
            ArrayList<Character> operators = new ArrayList<>();

            matcherOperators.reset(expression);
            matcherDigit.reset(expression);

            while (matcherDigit.find()) {
                digits.add(Integer.parseInt(matcherDigit.group()));
            }
            while (matcherOperators.find()) {
                operators.add(matcherOperators.group().charAt(0));
            }

            if (digits.size() != operators.size() + 1) {
                return false;
            }

            double crnt = digits.get(0);

            for (int i = 0; i < operators.size(); i++) {
                int newInt = digits.get(i + 1);
                switch (operators.get(i)) {
                    case '*': {
                        crnt *= newInt;
                        break;
                    }
                    case '/': {
                        crnt /= newInt;
                        break;
                    }
                    case '+': {
                        crnt += newInt;
                        break;
                    }
                    default: {
                        crnt -= newInt;
                        break;
                    }
                }
            }

            if (last != null && crnt != last) {
                return false;
            }
            last = crnt;
        }
        return true;

    }

    public static boolean palindromedescendant(int num) {

        while (num > 10) {

            String str = "" + num;
            String reverse = new StringBuilder(str).reverse().toString();
            if (str.equals(reverse)) {
                return true;
            }

            String newStr = "";
            for (int i = 0; i < str.length() - 1; i += 2) {
                newStr += Integer.parseInt(str.substring(i, i + 1)) + Integer.parseInt(str.substring(i + 1, i + 2));

            }
            num = Integer.parseInt(newStr);
        }

        return false;

    }
}
