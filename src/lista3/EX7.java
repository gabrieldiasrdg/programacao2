package lista3;

import java.util.Scanner;

public class EX7 {

    public static String removerDuplciadasConsecutivas (String frase){
        String[] vetor = frase.split(" ");
        String fraseSemDuplicatas="";

        for (int i = 0; i < vetor.length; i++){
            if (i != vetor.length - 1 ) {
                if (!vetor[i].equals(vetor[i+1])){
                    fraseSemDuplicatas += vetor[i] + " ";
                }
            } else {
                fraseSemDuplicatas += vetor[i];
            }
        }

        fraseSemDuplicatas = fraseSemDuplicatas.replaceAll("\\s+", " "); //tira as aspas extra

        return  fraseSemDuplicatas;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String frase="";

        System.out.println("Insira uma frase: ");
        frase = sc.nextLine().toUpperCase();

        System.out.println("Frase sem duplicatas: " + removerDuplciadasConsecutivas(frase));
    }
}
