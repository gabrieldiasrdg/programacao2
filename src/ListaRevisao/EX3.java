package ListaRevisao;

import java.util.Scanner;

public class EX3 {

    public static int somaDosQuadrados(int n){
        int soma = 0, valorAtual = 0;
        String valor = ""+n;

        if(n<10) {
            return n*n;
        } else {
            for(int i=0; i<valor.length() ;i++) {
                valorAtual = Integer.parseInt(valor.charAt(i)+"");
                soma += valorAtual*valorAtual;
            }
            return soma;
        }
    }

    public static boolean testFelizOrInfeliz(int n){
        int[] numerosAnteriores = new int[100];
        boolean ehFeliz = false, repetido = false;
        int repeticoes = 0;

        do {
            n = somaDosQuadrados(n);
            for(int i = 0 ; i<1 ; i++) {
                for (int j = 0; j < repeticoes; j++) {
                    if (n == numerosAnteriores[j]) {
                        repetido = true;
                        break;
                    } else if (n == 1){
                        ehFeliz = true;
                    }
                }
            }
            numerosAnteriores[repeticoes] = n;
            if(repeticoes != 99) {
                repeticoes++;
            }
        } while (!ehFeliz && !repetido);

        return ehFeliz;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 0;

        do {
            System.out.println("Insira um valor der até 8 dígitos: ");
            n = sc.nextInt();
            if(n > 99999999) {
                System.out.println("O número tem que ter no máximo 8 dígitos");
            }
        } while (n > 99999999);

        if(testFelizOrInfeliz(n)) {
            System.out.println(n+" é um número feliz!");
        } else {
            System.out.println(n+" NÃO é um número feliz!!");
        }

    }
}

