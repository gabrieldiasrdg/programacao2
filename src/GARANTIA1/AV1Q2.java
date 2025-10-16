package GARANTIA1;

import java.util.Scanner;

public class AV1Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int valor = 0, i = 1, j = 1, soma = 0;
        boolean ehEducado = false;


        System.out.println("Insira um valor: ");
        valor = sc.nextInt();

        do {
            do {
                soma += j;
                j++;
            } while (soma < valor);
            if (valor == soma) {
                ehEducado = true;
                break;
            }
            i++;
            j = i;
            soma = 0;
        } while (i < valor);

        if(ehEducado){
            System.out.println(valor+" é um número educado!");
        } else {
            System.out.println(valor+" é um número mal-educado!");
        }
    }
}
