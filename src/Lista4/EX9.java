package Lista4;

import java.util.Random;
import java.util.Scanner;

public class EX9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira o tamanho dos vetores: ");
        int n = sc.nextInt();
        int i = 0;

        int[] vet1 = new int[n];
        int[] vet2 = new int[n];
        int[] vetSoma = new int[n];

        preencherVetor(vet1, i);
        preencherVetor(vet2, i);

        somaVetores(vet1, vet2, vetSoma, i);

        System.out.println("Vetor 1:");
        imprimirVetor(vet1, i);
        System.out.println("\nVetor 2:");
        imprimirVetor(vet2, i);
        System.out.println("\nSoma dos vetores: ");
        imprimirVetor(vetSoma, i);
    }

    public static int somaVetores(int[] vet1, int[] vet2,  int[] vetSoma, int i) {
        if (i == vetSoma.length-1) {
            vetSoma[i] = vet1[i]+vet2[i];
            return vetSoma[i];
        }
        vetSoma[i] = vet1[i]+vet2[i];
        return somaVetores(vet1, vet2, vetSoma, i+1);
    }

    public static int[] preencherVetor(int[] vet, int i) {
        Random rand = new Random();
        if(i==vet.length){
            return vet;
        }

        vet[i] = rand.nextInt(vet.length, 100);

        return preencherVetor(vet, i + 1);
    }
    public static int[] imprimirVetor(int[] vet, int i) {
        if(i==vet.length){
            return vet;
        }

        System.out.printf("|%d|", vet[i]);

        return imprimirVetor(vet, i + 1);
    }
}
