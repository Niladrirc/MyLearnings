//package src.hard;
//
//public class MinimumSteps {
//    public static void main(String[] args) {
//        int N = 10;
//        int L = 2;
//        int[] mines = new int[]{6};
//        System.out.println(moveSteps(N, mines, L));
//    }
//    public static long moveSteps(int n, int[] mines, int l) {
//        int i=1, count=0, numPrimeBeforeCurrent = 0;
//        int nextMove = i;
//        while (i<=n) {
//            if (isPrime(i)) {
//                numPrimeBeforeCurrent++;
//                nextMove = ifNotMine(i+getNextPrime(i))
//            }
//            // nextPossibleSet can be either special move (if we don't land in mine) or
//            // i+2 (if we don't land in mine) or
//            // i+1 (if we don't land in mine)
//            //  -> which ever is greater
//            i = getNextMove(i, mines, numPrimeBeforeCurrent);
//        }
//    }
//
//    private static int getNextMove(int i, int[] mines, int numPrimeBeforeCurrent) {
//        if ()
//    }
//
//    private static boolean isPrime(int n) {
//        if (n <= 1) return false;
//        if (n <= 3) return true;
//        if (n % 2 == 0 || n % 3 == 0) return false;
//        for (int i = 5; i * i <= n; i = i + 6)
//            if (n % i == 0 || n % (i + 2) == 0)
//                return false;
//
//        return true;
//    }
//
//    private static int getNextPrime(int n)
//    {
//        if (n <= 1)
//            return 2;
//
//        int prime = n;
//        boolean found = false;
//        while (!found) {
//            prime++;
//            if (isPrime(prime))
//                found = true;
//        }
//        return prime;
//    }
//}
