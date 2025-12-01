package Lista4;

import java.util.Scanner;

public class EX1recursivo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        System.out.println("Insira um valor: ");
        n = sc.nextInt();
        collatz(n);
    }

    private static int collatz (int n) {
        if (n == 1) {
            System.out.println("n= "+n);
            return n;
        } else if (n % 2 != 0) {
            System.out.println("n= "+n);
            return collatz(n*3+1);
        }
        System.out.println("n= "+n);
        return collatz(n/2);
    }
}
