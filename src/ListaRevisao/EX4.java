package ListaRevisao;

import java.util.Scanner;

public class EX4 {
    public static void preencherMatriz(char[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = ' ';
            }
        }
    }

    public static void imprimirMatriz(char[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print("[" + matriz[i][j] + "]" + " ");
            }
            System.out.println();
        }
    }

    public static void telhadoDiagonalEsquerda (char[][] matriz, int x1, int x2, int y1, int y2) {
        if(x1<x2) {
            int salva = x1;
            x1 = x2;
            x2 = salva;
        }
        if (y1>y2) {
            int salva = y1;
            y1 = y2;
            y2 = salva;
        }

        do {
            if(matriz[6-y1][x1] == ' ') {
                matriz[6-y1][x1] = 'e';
            }
            matriz[6-y1][x1] = 'e';
            if(x1 != x2) {
                x1--;;
            }
            if (y1 != y2) {
                y1++;
            }

            if (x1 == x2 && y1 == y2 && matriz[6-y1][x1] == ' ') {
                if(x1 == 0) {
                    matriz[6-y1][x1] = 'h';
                } else {
                    matriz[6-y1][x1] = 's';
                }

            }

        } while (x1 != x2 || y1 != y2);

    }

    public static void telhadoDiagonalDireita (char[][] matriz, int x1, int x2, int y1, int y2) {
        if(x1>x2) {
            int salva = y1;
            y1 = y2;
            y2 = salva;
            salva = x1;
            x1 = x2;
            x2 = salva;
        }

        do {
            if(matriz[6-y1][x1] == ' ') {
                matriz[6-y1][x1] = 'd';
            }
            if(x1 != x2) {
                x1++;;
            }
            if (y1 != y2) {
                y1++;
            }

            if (x1 == x2 && y1 == y2 && matriz[6-y1][x1] == ' ') {
                if(x1 == 10) {
                    matriz[6-y1][x1] = 'h';
                } else {
                    matriz[6-y1][x1] = 's';
                }

            }

        } while (x1 != x2 || y1 != y2);

    }

    public static void telhadoHorizontal (char[][] matriz, int x1, int x2, int y1) {

        //FAZER A LINHA EM UM SENTIDO
        if(x1 > x2) {
            int salva = x1;
            x1 = x2;
            x2 = salva;
        }

        for (int i = x1; i <= x2; i++) {
            if (matriz[6-y1][i] == ' ') {
                matriz[6-y1][i] = 'h';
            }
        }

    }

    public static void telhadoMatriz (char[][] matriz, int x1, int x2, int y1, int y2) {

        if(y1 == y2) { //TELHADO HORIZONTAL
            telhadoHorizontal(matriz, x1, x2, y1);
        } else if ((x1 < x2 && y1 < y2) || (x1 > x2 && y1 > y2)) { //TELHADO DIAGONAL DIREITA
            telhadoDiagonalDireita(matriz, x1, x2, y1, y2);
        } else if ((x1 > x2 && y1 < y2) || (x1 < x2 && y1 > y2)) { //TELHADO DIAGONAL ESQUERDA
            telhadoDiagonalEsquerda(matriz, x1, x2, y1, y2);
        }

    }

    public static int[] prencherVetor(int c) {
        Scanner sc = new Scanner(System.in);
        int[] vetor = new int[c];
        for (int i = 0; i < vetor.length ; i++) {
            vetor[i] = sc.nextInt();
        }
        return vetor;
    }

    public static int[] posicaoFinalBalao(char[][] matriz, int c) {
        int y = 6;

        do {
            char caracterAtual = matriz[y][c];
            if (caracterAtual == ' ' && y != 0 || caracterAtual == 's') {
                y--;
            } else if (caracterAtual == 'd') {
                c++;
            } else if (caracterAtual == 'e') {
                c--;
            } else if (caracterAtual == 'h') {
                int[] posicao = new int[2];
                posicao[0] = c;
                posicao[1] = 6-y;
                return posicao;
            } else if (caracterAtual == ' ') {
                int[] posicao = new int[1];
                posicao[0] = c;
                return posicao;
            }

        } while(true);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1 = 0,  x2 = 0, y1 = 0, y2 = 0;
        char[][] matriz = new char[7][11];
        preencherMatriz(matriz);

        // LER QUANTIDADE DE TETOS E BALÃOS
        int n = sc.nextInt();
        int c = sc.nextInt();

        for (int i = 0; i < n; i++) {
            do {
                x1 = sc.nextInt();
                y1 = sc.nextInt();
                x2 = sc.nextInt();
                y2 = sc.nextInt();
                if(x1 > 10 || x2 > 10 || y1 > 6 || y2 > 6) {
                    System.out.println("VALORES ULTRAPASSAM O LIMITE DA MATRIZ! INSIRA NOVAMENTE!");
                }
            }while (x1 > 10 || x2 > 10 || y1 > 6 || y2 > 6);
            telhadoMatriz(matriz, x1, x2, y1, y2);
        }

        int[] saidaBalao = prencherVetor(c);

        for (int i = 0; i < c; i++) {
            int[] posicao = posicaoFinalBalao(matriz, saidaBalao[i]);
            for (int j = 0; j < posicao.length; j++) {
                System.out.print(posicao[j] + " ");
            }
            System.out.println();
        }

    }
}
