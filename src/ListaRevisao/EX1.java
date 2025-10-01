package ListaRevisao;

import java.util.Scanner;

public class EX1 {
    public static String[][] preencherMatriz(String[][] tipo) {
        for (int i = 0; i < tipo.length; i++) {
            for (int j = 0; j < tipo[i].length; j++) {
                tipo[i][j] = "(Vazio)";
            }
        }
        return tipo;
    }

    public static void listarMatriz(double[][] valor, String[][] tipo, int mes) {
        for (int i = mes; i < mes+1; i++) {
            for (int j = 0; j < valor[i].length; j++) {
                System.out.printf("%s: %.2f\t", tipo[i][j], valor[i][j]);
            }
            System.out.println(); // pula linha a cada "linha" da matriz
        }
    }

    public static double[][] CAEdespesas (double[][] planilha) {
        Scanner sc = new Scanner(System.in);
        double[][] despesasValor = new double[12][4];
        String[][] despesasTipo = new String[12][4];
        int op = 0, mes = 0, semana = 0;

        do { //VERIFICA A OPERAÇÃO
            System.out.println("1 - Cadastrar despesa");
            System.out.println("2 - Alterar despesa");
            System.out.println("3 - Excluir despesa");
            System.out.println("4 - Voltar");
            op = sc.nextInt();
            if (op < 1 || op > 4) {
                System.out.println("Opção inválida!");
            }
        }   while(op < 1 || op > 4);

        //PREENCHER VAZIOS NA STRING
        preencherMatriz(despesasTipo);

        //CADASTRAR DESPESA
        do { //SELECIONA O MES
            System.out.println("SELECIONE O MÊS QUE VOCÊ DESEJA CADASTRAR A DESPESA: ");
            mes = sc.nextInt();
            if (mes < 1 || mes > 12) {
                System.out.println("Opção inválida!");
            }
        }   while(mes < 1 || mes > 12);
        mes -= 1; //ARRUMAR INDICE DO MES

        do { //SELECIONA A SEMANA
            System.out.println("SELECIONE A SEMANA DO MÊS ESCOLHIDO QUE VOCÊ DESEJA CADASTRAR A DESPESA: ");
            semana = sc.nextInt();
            if (semana < 1 || semana > 4) {
                System.out.println("Opção inválida!");
            } else if (!despesasTipo[mes][semana].equals("(Vazio)")) { //LUGAR OCUPADO
                System.out.println("Erro! A opção selecionada já está ocupada!");
            }
        }   while(semana < 1 || semana > 4);
        semana -= 1; //ARRUMAR INDICE DA SEMANA

        listarMatriz(despesasValor, despesasTipo, mes);

        sc.nextLine(); //JOGAR PRO VENTO

        //DEFINIR ONDE E QUANTO VAI INSERIR
        System.out.println("Insira o tipo de despesa: ");
        despesasTipo[mes][semana] = sc.nextLine();
        System.out.println("Insira o valor da despesa: ");
        despesasValor[mes][semana] = sc.nextDouble();
        if(despesasValor[mes][semana] < 0) { // CASO INSIRA UM NÚMERO NEGATIVO
            despesasValor[mes][semana] *= -1;
        }

        //JOGA O VALOR PARA O TOTAL
        planilha[mes][semana] -= despesasValor[mes][semana];

        return planilha;

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
            System.out.println("R: ");
            do {
                op = sc.nextInt();
                if (op<0 || op>5) {
                    System.out.println("Opção inválida!");
                }
            } while (op<0 || op>5);

            if (op == 1) {
                System.out.println("ABRINDO MENU DE cadastrar/alterar/excluir despesas...");
                CAEdespesas(planilha);
            } else if (op == 2) {
                System.out.println("ABRINDO MENU DE cadastrar/alterar/excluir receitas...");
            } else if (op == 3) {
                System.out.println("ABRINDO MENU DE ver estatísticas...");
            } else if (op == 4) {
                System.out.println("LISTANDO MESES...");
            } else if (op == 5){
                sair = true;
            }
        } while (!sair);

        System.out.println("Você saiu");

    }
}
