package lista3;

import java.util.Scanner;

public class EX11 {
    public static int calcularTempo(int t, int a, int b) {
        int c = 0, contA = 1, contB = 1, salvaA = a, salvaB = b, quantA, quantB;

        do {
            if (a>b && a!=0 && b!=0) {
                a -= b;
                b = 0;
                c = a;
            } else if (b>a && b!=0 && a!=0) {
                b -= a;
                a = 0;
                c = b;
            } else if (a==0) {
                contA++;
                a = salvaA;
            } else if (b==0) {
                contB++;
                b = salvaB;
            }
        } while (c != t);

        quantA = contA * salvaA;
        quantB = contB * salvaB;

        if (quantA > quantB) {
            return quantA;
        } else {
            return quantB;
        }

    }


    public static int lerAmpulhetas() {
        Scanner sc = new Scanner(System.in);

        int t=0,a=0,b=0;

        do {
            System.out.println("Insira o tempo necessário para o preparo do miojo, o tempo da primeira e o tempo da segunda ampulheta respectivamente: ");
            t=sc.nextInt();
            a=sc.nextInt();
            b=sc.nextInt();
            if (t < 0 || t > 10000) {
                System.out.println("Tempo do miojo inválido!");
            }
            if (a <= t || b > 40000) {
                System.out.println("Ampulheta 1 inválida!");
            }
            if (a <= t || b > 40000) {
                System.out.println("Ampulheta 2 inválida!");
            }
        } while (!(t >= 0 && t <= 10000 && a > t && b > t && a <= 40000 && b <= 40000));

        int tempo =  calcularTempo(t, a, b);
        return tempo;

    }

    public static void main(String[] args) {
        int tempo = lerAmpulhetas();
        System.out.println(tempo+ "");
    }
}
