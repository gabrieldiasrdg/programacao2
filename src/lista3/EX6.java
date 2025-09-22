package lista3;

import java.util.Scanner;

public class EX6 {

    public static String preencherNumCartao () {
        Scanner sc = new Scanner(System.in);
        String numeroCartao = "", nCartaoComEspaco = "";

        do {
            System.out.println("Escreva o número do seu cartão(sem espaços): ");
            numeroCartao = sc.nextLine();
            if (numeroCartao.length() != 16) {
                System.out.println("Cartão inválido!");
            }
        } while(numeroCartao.length() != 16);

        for (int i = 0; i < 16; i++) {
            if (i % 4 == 0 && i != 0) {
                nCartaoComEspaco += " ";
                nCartaoComEspaco += numeroCartao.charAt(i);
            } else if(i % 4 != 0 || i == 0) {
                nCartaoComEspaco += numeroCartao.charAt(i);
            }
        }

        return nCartaoComEspaco;
    }

    public static String numeroCartaoSensurado(String numeroCartao) {
        String numeroSensurado = "**** **** ****" + numeroCartao.substring(numeroCartao.length() - 5, numeroCartao.length());

        return numeroSensurado;
    }

    public static void main(String[] args) {

        String numeroCartao = preencherNumCartao();
        System.out.println("Número do cartão: "+numeroCartao);
        System.out.println("Número do cartão sensurado: "+numeroCartaoSensurado(numeroCartao));
    }
}
