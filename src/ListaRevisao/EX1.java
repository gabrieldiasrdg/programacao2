package ListaRevisao;

import java.util.Scanner;

public class EX1 {

    public static void CAEdespesas () {

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op = 0;
        double[][] planilha = new double[12][4];
        boolean sair = false;

        do {
            System.out.println("MENU DE OPÇÕES");
            System.out.println("1 - cadastrar/alterar/excluir despesas");
            System.out.println("2 - cadastrar/alterar/excluir receitas");
            System.out.println("3 - ver estatísticas");
            System.out.println("4 - listar meses");
            System.out.println("5 - sair");
            do {
                op = sc.nextInt();
                if (op<0 || op>5) {
                    System.out.println("Opção inválida!");
                }
            } while (op<0 || op>5);

            if (op == 1) {
                System.out.println("ABRINDO MENU DE cadastrar/alterar/excluir despesas...");

            } else if (op == 2) {
                System.out.println("ABRINDO MENU DE cadastrar/alterar/excluir receitas...");
            } else if (op == 3) {
                System.out.println("ABRINDO MENU DE ver estatísticas...");
            } else if (op == 4) {
                System.out.println("LISTANDO MESES...");
            } else if (op == 5){
                sair = true;
            }
        } while (sair);

        System.out.println("Você saiu");

    }
}
