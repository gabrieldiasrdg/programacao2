package lista3;

import java.util.Scanner;

public class EX12 {

    public static void prencherVoid(char[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = ' ';
            }
        }
    }

    public static void imprimirMatriz(char[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int telhadoHorizontal() {
        return 0;
    }

    public static char[][] retornarTelhado (int n, int c) {
        Scanner sc = new Scanner(System.in);
        char[][] sala = new char[7][11];
        int x1=0, x2=0, y1=0, y2=0, maiorX=0, maiorY=0, i=0;
        boolean caminhoLivre = true;

        prencherVoid(sala); //PREENCHER MATRIZ COM ESPAÇOS

        do {
            do {
                //LEITURA DOS VALORES X e Y:
                System.out.printf("Insira o valor de X1, Y1, X2, Y2 (respectivamente) para o %dº valor de n: ", i + 1);
                x1 = sc.nextInt(); //X1 CORRESPONDE A COLUNA
                y1 = sc.nextInt(); //Y1 CORRESPONDE A LINHA
                x2 = sc.nextInt(); //X2 CORRESPONDE A COLUNA
                y2 = sc.nextInt(); //Y2 CORRESPONDE A LINHA
                if (x1 > 11 || y1 > 7 ||  x2 > 11 || y2 > 7) {
                    System.out.println("Posição inválida!");
                }
            } while (x1 > 11 || y1 > 7 ||  x2 > 11 || y2 > 7);

            //TESTES DE TELHADOS:
            if(y1 == y2) { //É HORIZONTAL
                if (x1<x2) {
                    for (int j = x1; j <= x2; j++) {
                        if (sala[(sala.length - 1) - y1][j] != ' ') {
                            System.out.println("Erro! Telhados estão chocando!");
                        } else {
                            sala[(sala.length - 1) - y1][j] = 'h';
                        }
                    }
                } else {
                    for (int j = x1; j >= x2; j--) {
                        if (sala[(sala.length - 1) - y1][j] != ' ') {
                            System.out.println("Erro! Telhados estão chocando!");
                        } else {
                            sala[(sala.length - 1) - y1][j] = 'h';
                        }
                    }
                }
            } //FIM DO HORIZONTAL




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

        imprimirMatriz(retornarTelhado(n, c));
    }
}
