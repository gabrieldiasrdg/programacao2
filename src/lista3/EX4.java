package lista3;

import java.util.Scanner;

public class EX4 {

    public static String maiorPalavraDaFrase(String frase) {
        String maiorPalavraDaFrase = "", palavraAtual = "";
        boolean temEspaco = false;
        int maiorPalavra = 0, contPalavra = 0;

        for (int i = 0; i < frase.length(); i++) {
            char caracterAtual = frase.charAt(i);
            if(caracterAtual == ' ') {
                temEspaco = true;
            } if (temEspaco && caracterAtual == ' ') {
                for (int j = i + 1; j < frase.length(); j++) {
                    if(frase.charAt(j) != ' ') {
                        contPalavra++;
                        palavraAtual += frase.charAt(j);
                    } else if (frase.charAt(j) == ' ') {
                        break;
                    }
                }
            } else if(!temEspaco) {
                maiorPalavra++;
                maiorPalavraDaFrase += caracterAtual;
            }
            if (contPalavra > maiorPalavra) {
                maiorPalavraDaFrase = palavraAtual;
            }
            contPalavra = 0;
            palavraAtual = "";
        }


        return maiorPalavraDaFrase;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String frase = "";

        System.out.println("Digite sua frase: ");
        frase = input.nextLine();

        System.out.printf("A maior palavra da frase é: %s", maiorPalavraDaFrase(frase));
    }
}
