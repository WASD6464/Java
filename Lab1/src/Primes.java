public class Primes {
    public static void main(String[] args) throws Exception {
        for (int x = 2; x <= 100; ++x){
            if (isPrime(x)) System.out.println(x);
        }
    }

    public static boolean isPrime(int n){
        boolean flag = true;
        for (int i = 2; i < n; ++i)
            if (n % i == 0) flag = false;
        return flag;
    }
}
