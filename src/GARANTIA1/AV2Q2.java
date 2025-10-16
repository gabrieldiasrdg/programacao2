package GARANTIA1;

import java.util.Scanner;

public class AV2Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double valor = 0.0;
        boolean ehPrimo = true;

        System.out.println("Insira um valor PAR: ");
        do {
            valor = sc.nextInt();
            if (valor%2 != 0) {
                System.out.println("Você inseriu um número ÍMPAR, você deve inserir um número PAR!");
            }
        } while (valor%2 != 0);

        double numero = valor/2;

        for (int i = 2; i < numero; i++) {
            if (numero%i == 0){
                ehPrimo = false;
            }
        }

        if (ehPrimo) {
            System.out.printf("Para o número %.1f, a conjectura é VERDADEIRA!", valor);
        } else {
            System.out.printf("Para o número %.1f, a conjectura é FALSA!", valor);
        }



    }
}
