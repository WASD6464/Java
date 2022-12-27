public class Palindrome {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < args.length; ++i){
            String s = args[i];
            System.out.println(String.format("%s - %b", reverseString(s),isPalindrome(s, reverseString(s))));
        }
    }

    public static String reverseString(String arg){
        String result = new String();
        for (int i = arg.length() - 1; i >= 0; --i)
            result += arg.charAt(i);
        return result;
    }

    public static boolean isPalindrome(String s, String k){
        return s.equals(k);
    }
}
