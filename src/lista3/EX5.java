package lista3;

import javax.sound.midi.Soundbank;
import java.util.Locale;
import java.util.Scanner;

public class EX5 {

    public static void preencherVetor(String[] palavras) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < palavras.length; i++) {
            System.out.printf("Escreva a %dª palavra proibida: ", i+1);
            palavras[i] = sc.nextLine().toUpperCase();
        }
    }

    public static String removerPalavrasProibidas(String frase, String[] palavras) {
        String novaFrase = "", palavra = "";
        boolean ehIgual = false;

        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) != ' ' && frase.charAt(i) != ',' && i !=  frase.length() - 1) {
                palavra += frase.charAt(i);
            } else if (frase.charAt(i) == ' ' || frase.charAt(i) == ',' || i ==  frase.length() - 1) {
                if (i == frase.length() - 1 && frase.charAt(i) != ' ' && frase.charAt(i) != ',') {
                    palavra += frase.charAt(i);
                }
                ehIgual = false;
                for (int j = 0; j < palavras.length; j++) {
                    if(palavra.equals(palavras[j])) {
                        ehIgual = true;
                        break;
                    }
                }

                if (ehIgual == false) {
                    if (i == frase.length() - 1) {
                        novaFrase += palavra;
                    } else {
                        novaFrase += palavra + frase.charAt(i);
                        palavra = "";
                    }
                } else {
                    palavra = "";
                    ehIgual = false;
                    if (frase.charAt(i) == ',') {
                        novaFrase += frase.charAt(i);
                    }
                }
            }
        }

        return novaFrase;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String frase = "";
        String[] palavrasProibidas = new String[3];

        System.out.println("Palavra proibidas: ");
        preencherVetor(palavrasProibidas);

        System.out.println("Digite uma frase: ");
        frase = sc.nextLine().toUpperCase();

        System.out.printf("Frase sem as palavras proibidas: %s", removerPalavrasProibidas(frase, palavrasProibidas));
    }
}
