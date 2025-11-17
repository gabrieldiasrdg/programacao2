package Lista4;

import java.util.Scanner;

public class EX3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int soma = somarDigitos(n);
        System.out.println("A soma dos dígitos de '"+n+"' é: "+soma);
    }
    public static int somarDigitos (int n) {
        if (n<10) {
            return n;
        }
        return (n%10) + somarDigitos(n/10);
    }
}
