package lista3;

import java.util.Scanner;

public class EX12 {
    public static int telhadoHorizontal() {
        return 0;
    }

    public static Object retornarTelhado (int n, int c) {
        Scanner sc = new Scanner(System.in);
        char[][] sala = new char[7][11];
        int x1=0, x2=0, y1=0, y2=0, maiorX=0, maiorY=0, i=0;
        boolean caminhoLivre = true;

        do {
            //LEITURA DOS VALORES X e Y:
            System.out.printf("Insira o valor de X1 para o %dº valor de n: ", i+1);
            x1 = sc.nextInt();
            System.out.printf("Insira o valor de Y1 para o %dº valor de n: ", i+1);
            y1 = sc.nextInt();
            System.out.printf("Insira o valor de X1 para o %dº valor de n: ", i+1);
            x2 = sc.nextInt();
            System.out.printf("Insira o valor de Y1 para o %dº valor de n: ", i+1);
            y2 = sc.nextInt();

            //TESTES DE TELHADOS:
            if(y1 == y2) { //É HORIZONTAL
                do {
                    for (int j = y1; j <= x1; j++) {
                        if (sala[x1][j] != ' '){
                            caminhoLivre = false;
                            return "Erro! Telhados estão chocando!";
                        }
                    }
                } while (caminhoLivre);
            }

            i++;
        } while (i < n);

        return sala;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0, c = 0;

        System.out.println("Insira o valor de N: ");
        n = sc.nextInt();
        System.out.println("Insira o valor de C: ");
        c = sc.nextInt();
    }
}
