package Lista4;

import java.util.Scanner;

public class EX2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 2;
        if (ehPrimo(n, i)) {
            System.out.println("É Primo!");
        } else {
            System.out.println("Não é primo!");
        }
    }

    public static boolean ehPrimo(int n, int i) {
        if (n <= 1) {
            return false;
        }
        if (i * i > n) {
            return true;
        }
        if (n % i == 0) {
            return false;
        }
        return ehPrimo(n, i + 1);
    }
}
