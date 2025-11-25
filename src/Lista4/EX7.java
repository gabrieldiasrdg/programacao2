package Lista4;

import java.util.Random;
import java.util.Scanner;

public class EX7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira o tamanho do vetor: ");
        int n = sc.nextInt();
        int i = 0;
        int[] vet = new int[n];

        preencherVetor(vet, i);
        imprimirVetor(vet, i);
        System.out.println();
        System.out.println("O menor valor do vetor é: "+menorValor(vet, i));

    }
    public static int menorValor(int[] vet, int i) {
        if (i == vet.length-1) {
            return vet[i];
        } else{
            int min = menorValor(vet, i+1);
            if (vet[i] <= min) {
                return vet[i];
            } else  {
                return min;
            }
        }
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
