package Lista4;

import java.util.Scanner;

public class EX1Interativo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        System.out.println("Insira um valor: ");
        n = sc.nextInt();
        collatz(n);
    }

    private static void collatz (int n) {
        do {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n *= 3;
                n++;
            }
            System.out.println("n= "+ n);
        } while (n != 1);
    }
}
