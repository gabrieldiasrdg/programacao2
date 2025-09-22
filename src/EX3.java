package lista3;

import java.util.Scanner;

public class EX3 {
    public static int subStringOcorrencia (String frase, String subString) {
        int cont = 0;
        boolean ehSubPalavra = true;

        for (int i = 0; i < frase.length() || subString.length() + i < frase.length(); i++) {
            if (frase.charAt(i) == subString.charAt(0)) {
                for (int j = 0; j < subString.length(); j++) {
                    if(frase.charAt(i+j) != subString.charAt(j)) {
                        ehSubPalavra = false;
                        break;
                    } else {
                        ehSubPalavra = true;
                    }
                }
                if (ehSubPalavra) {
                    cont++;
                    ehSubPalavra = false;
                }
            }
        }

        return cont;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String frase="", subString="";

        do {
            System.out.println("Escreva a frase: ");
            frase = sc.nextLine().toUpperCase();
            System.out.println("Escreva a subString: ");
            subString = sc.nextLine().toUpperCase();
            if (frase.length() < subString.length()) {
                System.out.println("A frase precisa ser maior que a subString!");
            }
        } while (frase.length() < subString.length());

        System.out.printf("A quantidade de vezes que a subString '%s' aparece na frase é: %d vezes!", subString, subStringOcorrencia(frase, subString));

    }
}
