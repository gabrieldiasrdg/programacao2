package Lista4;

import java.util.Scanner;

public class EX5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o primeiro numero: ");
        int n1 = sc.nextInt();
        System.out.println("Digite o segundo numero: ");
        int n2 = sc.nextInt();

        if (n1 < n2){
            int temp = n1;
            n1 = n2;
            n2 = temp;
        }

        System.out.println("MDC= "+mdc(n1, n2));

    }
    public static int mdc(int n1, int n2){
        if(n1 % n2 == 0){
            return n2;
        }
        return mdc(n2, n1%n2);
    }
}
