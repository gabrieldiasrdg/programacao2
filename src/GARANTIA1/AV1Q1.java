package GARANTIA1;

import java.util.Scanner;

public class AV1Q1 {
    public static void cadastrarProblemas (int[][] turmas, int qtdTurma) {
        Scanner sc = new Scanner(System.in);
        int op = 0, turmaAluno = 0;

        System.out.println("------------------------------");

        System.out.println("INSIRA O NOME DO ALUNO:");
        String nome = sc.nextLine();

        do {
            System.out.println("INSIRA O NÚMERO DA TURMA CORRESPONDENTE AO ALUNO: ");
            turmaAluno = sc.nextInt();
            if (turmaAluno<=0 || turmaAluno>qtdTurma) {
                System.out.println("Opção inválida!");
            }
        } while(turmaAluno<=0 || turmaAluno>qtdTurma);

        do {
            System.out.println("INFORME O NÚMERO CORRESPONDENTE AO PROBLEMA: ");
            System.out.println("1 - DISCIPLINAR");
            System.out.println("2 - BAIXO RENDIMENTO");
            System.out.println("3 - FALTAS EXCESSIVAS");
            System.out.println("4 - CONVERSAS PARALELAS");
            System.out.println("R= ");
            op = sc.nextInt();
            if (op<1 || op>4) {
                System.out.println("Opção inválida!");
            }
        } while(op<1 || op>4);

        turmas[turmaAluno-1][op-1]++;

        System.out.println("------------------------------");

    }

    public static void estatisticas (int[][] turma) {
        String[] problemas = {"DISCIPLINAR","BAIXO RENDIMENTO","FALTAS EXCESSIVAS","CONVERSAS PARALELAS"};

        System.out.println("------------------------------");

        //PERCENTUAL DE CADA UM DOS PROBLEMAS LISTADOS
        double percentual = 0;
        System.out.println("PERCENTUAL DE CADA UM DOS PROBLEMAS LISTADOS(POR TURMA): ");
        for (int i = 0; i < turma.length; i++) {
            int totalProblemas = 0;
            System.out.println("Turma "+ (i+1) + ":");
            for (int j = 0; j < turma[0].length; j++) {
                totalProblemas += turma[i][j];
            }
            for (int k = 0; k < problemas.length; k++) {
                percentual = (double) (turma[i][k] * 100) /totalProblemas;
                System.out.printf("%s: %.2f%%%n", problemas[k], percentual);
            }
        }

        System.out.println();

        //percentual de cada um dos problemas listados (global)
        System.out.println("PERCENTUAL DE CADA UM DOS PROBLEMAS LISTADOS (GLOBAL):");
        int[] totalProblemasGlobal = new int[4];
        int total = 0;
        double[] percentualGlobal = new double[4];
        for (int i = 0; i < turma.length; i++) {
            for (int j = 0; j < turma[0].length; j++) {
                totalProblemasGlobal[j] += turma[i][j];
                total += turma[i][j];
            }
        }
        for(int i = 0; i < totalProblemasGlobal.length; i++) {
            percentualGlobal[i] = (double) (totalProblemasGlobal[i]*100)/total;
            System.out.printf("%s: %.2f%%%n", problemas[i], percentualGlobal[i]);
        }

        System.out.println();

        //turma com maiores problemas.
        int maiorValor = 0;
        int turmaMaiorProblema = 0;
        int[] problemasTotais = new int[turma.length];
        for (int i = 0; i < turma.length; i++) {
            for (int j = 0; j < turma[0].length; j++) {
                problemasTotais[i] += turma[i][j];
            }
        }
        for(int i = 0; i < problemasTotais.length; i++) {
            if(maiorValor<problemasTotais[i]) {
                maiorValor =  problemasTotais[i];
                turmaMaiorProblema = i+1;
            }
        }
        System.out.println("Turma com maiores problemas: "+turmaMaiorProblema);

        System.out.println("------------------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Insira a quantidade de turmas: ");
        int qtdTurma = sc.nextInt();
        int op = 0;
        int[][] turmas = new int[qtdTurma][4];

        do {
            do {
                System.out.println("OPÇÕES: ");
                System.out.println("1 - CADASTRAR ALUNO E PROBLEMA");
                System.out.println("2 - ESTATÍSTICAS");
                System.out.println("3 - SAIR");
                System.out.println("R= ");
                op = sc.nextInt();
                if (op < 1 || op > 3) {
                    System.out.println("Opção inválida!");
                }
            } while (op < 1 || op >3);
            if (op == 1) {
                cadastrarProblemas(turmas, qtdTurma);
            } else if (op == 2) {
                estatisticas(turmas);
            }
        }while (op!=3);

        System.out.println("Você saiu!");



    }
}
