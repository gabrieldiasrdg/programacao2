package Lista4;

import java.util.Scanner;

public class EX4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o numero: ");
        int n = sc.nextInt();
        System.out.println("Digite a potencia: ");
        int potencia = sc.nextInt();

        System.out.printf("%d^%d= %d", n, potencia, calcularPotencia(n, potencia));
    }

    public static int calcularPotencia(int n, int potencia) {
        if (potencia == 0) {
            return 1;
        } else if (potencia < 0 ) {
            return -1;
        }

        return n = n * calcularPotencia(n, potencia-1);
    }
}
