package lista3;

import java.util.Scanner;

public class EX12 {

    public static int[] prencherVetor(int c) {
        Scanner sc = new Scanner(System.in);
        int[] vetor = new int[c];
        for (int i = 0; i < vetor.length ; i++) {
            System.out.printf("Insira o %dº valor de C: \n", i+1);
            vetor[i] = sc.nextInt();
        }

        return vetor;
    }

    public static void imprimirVetor(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.println(i+1 + ": " + vetor[i]);
        }
    }

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
                System.out.print("[ "+matriz[i][j] + " ]");
            }
            System.out.println();
        }
    }

    public static char[][] telhadoHorizontal(int x1, int x2, int y1, int y2, char[][] sala) {

        if (x1 > x2) {
            int salva = x1;
            x1 = x2;
            x2 = salva;
        } else if (y1 > y2) {
            int salva = y1;
            y1 = y2;
            y2 = salva;
        }

        for (int j = x1; j <= x2; j++) {
            if (sala[(sala.length - 1) - y1][j] != ' ') {
                System.out.println("Erro! Telhados estão chocando!");
                System.exit(0);
            } else {
                sala[(sala.length - 1) - y1][j] = 'h';
            }
        }


        return sala;
    }

    public static char[][] telhadoDiagDirCima(int x1, int x2, int y1, int y2, char[][] sala) {

        do {
            if (x1 != x2 && y1 != y2 && sala[(sala.length - 1) - y1][x1] == ' ') {
                sala[(sala.length - 1) - y1][x1] = 'd';
                y1++;
                x1++;
            } else if (y1 == y2 && x1 != x2 && sala[(sala.length - 1) - y1][x1] == ' ') {
                sala[(sala.length - 1) - y1][x1] = 'd';
                x1++;
            } else if (x1 == x2 && y1 != y2 && sala[(sala.length - 1) - y1][x1] == ' ') {
                sala[(sala.length - 1) - y1][x1] = 'd';
                y1++;
            } else if (x1 == x2 && y1 == y2 && sala[(sala.length - 1) - y1][x1] == ' ') {
                sala[(sala.length - 1) - y1][x1] = 's';
                y1++;
                x1++;
            } else {
                System.out.println("Telhados Chocando!");
                System.exit(0);
            }
        } while (x1 != x2 + 1 || y1 != y2 + 1);


        return sala;
    }

    public static char[][] telhadoDiagEsqBaixo(int x1, int x2, int y1, int y2, char[][] sala) {
        int i = 0;
        do {
            if (x1 != x2 && y1 != y2 && sala[(sala.length - 1) - y1][x1] == ' ' && i != 0) {
                sala[(sala.length - 1) - y1][x1] = 'd';
                y1++;
                x1--;
            } else if (y1 == y2 && x1 != x2 && sala[(sala.length - 1) - y1][x1] == ' ') {
                sala[(sala.length - 1) - y1][x1] = 'd';
                x1--;
            } else if (x1 == x2 && y1 != y2 && sala[(sala.length - 1) - y1][x1] == ' ') {
                sala[(sala.length - 1) - y1][x1] = 'd';
                y1++;
            } else if (x1 == x2 && y1 == y2 && sala[(sala.length - 1) - y1][x1] == ' ') {
                sala[(sala.length - 1) - y1][x1] = 'd';
                y1++;
                x1++;
            } else if (i == 0) {
                sala[(sala.length - 1) - y1][x1] = 's';
                y1++;
                x1--;
                i++;
            } else {
                System.out.println("Telhados Chocando!");
                System.exit(0);
            }
        } while (x1 != x2 + 1 || y1 != y2 + 1);


        return sala;
    }

    public static char[][] telhadoDiagEsqCima(int x1, int x2, int y1, int y2, char[][] sala) {

        do {
            if (x1 != x2 && y1 != y2 && sala[(sala.length - 1) - y1][x1] == ' ') {
                sala[(sala.length - 1) - y1][x1] = 'e';
                y1++;
                x1--;
            } else if (y1 == y2 && x1 != x2 && sala[(sala.length - 1) - y1][x1] == ' ') {
                sala[(sala.length - 1) - y1][x1] = 'e';
                x1--;
            } else if (x1 == x2 && y1 != y2 && sala[(sala.length - 1) - y1][x1] == ' ') {
                sala[(sala.length - 1) - y1][x1] = 'e';
                y1++;
            } else if (x1 == x2 && y1 == y2 && sala[(sala.length - 1) - y1][x1] == ' ') {
                sala[(sala.length - 1) - y1][x1] = 's';
                y1++;
            } else {
                System.out.println("Telhados Chocando!");
                System.exit(0);
            }
        } while (x1 != x2 || y1 != y2 + 1);

        return sala;
    }

    public static char[][] telhadoDiagDirBaixo(int x1, int x2, int y1, int y2, char[][] sala) {
        int i = 0;
        do {
            if (x1 != x2 && y1 != y2 && sala[(sala.length - 1) - y1][x1] == ' ' && i != 0) {
                sala[(sala.length - 1) - y1][x1] = 'e';
                y1--;
                x1++;
            } else if (y1 == y2 && x1 != x2 && sala[(sala.length - 1) - y1][x1] == ' ') {
                sala[(sala.length - 1) - y1][x1] = 'e';
                x1++;
            } else if (x1 == x2 && y1 != y2 && sala[(sala.length - 1) - y1][x1] == ' ') {
                sala[(sala.length - 1) - y1][x1] = 'e';
                y1--;
            } else if (x1 == x2 && y1 == y2 && sala[(sala.length - 1) - y1][x1] == ' ') {
                sala[(sala.length - 1) - y1][x1] = 'e';
                x1++;
            } else if (i == 0){
                sala[(sala.length - 1) - y1][x1] = 's';
                y1--;
                x1++;
                i++;
            } else {
                System.out.println("Telhados Chocando!");
                System.exit(0);
            }
        } while (x1 != x2 + 1 || y1 != y2);

        return sala;
    }

    public static char[][] retornarTelhado(int n, int c) {
        Scanner sc = new Scanner(System.in);
        char[][] sala = new char[7][11];
        int x1 = 0, x2 = 0, y1 = 0, y2 = 0, maiorX = 0, maiorY = 0, i = 0;

        prencherVoid(sala); //PREENCHER MATRIZ COM ESPAÇOS

        do {
            do {
                //LEITURA DOS VALORES X e Y:
                System.out.printf("Insira o valor de X1, Y1, X2, Y2 (respectivamente) para o %dº valor de n: ", i + 1);
                x1 = sc.nextInt(); //X1 CORRESPONDE A COLUNA
                y1 = sc.nextInt(); //Y1 CORRESPONDE A LINHA
                x2 = sc.nextInt(); //X2 CORRESPONDE A COLUNA
                y2 = sc.nextInt(); //Y2 CORRESPONDE A LINHA
                if (x1 > 10 || x2 > 10 || y1 > 6 || y2 > 6) {
                    System.out.println("Posição inválida!");
                }
            } while (x1 > 10 || x2 > 10 || y1 > 6 || y2 > 6);

            if (y1 == y2) {//TELHADO HORIZONTAL
                sala = telhadoHorizontal(x1, x2, y1, y2, sala);
            } else if ((x1 < x2 && (sala.length - 1) - y1 > (sala.length - 1) - y2)) { //TELHADO DIAGONAL DIREITA CIMA
                telhadoDiagDirCima(x1, x2, y1, y2, sala);
            } else if ((x1 > x2 && (sala.length - 1) - y1 < (sala.length - 1) - y2)) { //TELHADO DIAGONAL ESQUERDA BAIXO
                sala = telhadoDiagEsqBaixo(x1, x2, y1, y2, sala);
            } else if ((x1 > x2 && (sala.length - 1) - y1 > (sala.length - 1) - y2)) { //TELHADO DIAGONAL ESQUERDA CIMA
                telhadoDiagEsqCima(x1, x2, y1, y2, sala);
            } else if ((x1 < x2 && (sala.length - 1) - y1 < (sala.length - 1) - y2)) { //TELHADO DIAGONAL DIREITA BAIXO
                telhadoDiagDirBaixo(x1, x2, y1, y2, sala);
            }

            i++;
        } while (i < n);

        return sala;
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
        int n = 0, c = 0;

        System.out.println("Insira o valor de N e C respectivamente: ");
        n = sc.nextInt();
        c = sc.nextInt();

        char[][] salaComTelhado = retornarTelhado(n, c);
        int[] saidaBalao = prencherVetor(c);

        System.out.println("Vetor C:");
        imprimirVetor(saidaBalao);
        System.out.println("Matriz: ");
        imprimirMatriz(salaComTelhado);


        for (int i = 0; i < c; i++) {
            int[] posicao = posicaoFinalBalao(salaComTelhado, saidaBalao[i]);
            for (int j = 0; j < posicao.length; j++) {
                System.out.print(posicao[j] + " ");
            }
            System.out.println();
        }
    }
}
