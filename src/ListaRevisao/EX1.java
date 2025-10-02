package ListaRevisao;
import java.util.Scanner;
public class EX1 {

    public static double[][] cadastrarAlterar (double[][] planilha) { //CADASTRAR/ALTERAR
        Scanner sc = new Scanner(System.in);
        int mes = 0, semana = 0;

        do { //SELECIONA O MES
            System.out.println("SELECIONE O MÊS: ");
            mes = sc.nextInt();
            if (mes < 1 || mes > 12) {
                System.out.println("Opção inválida!");
            }
        }   while(mes < 1 || mes > 12);
        mes--; //ARRUMAR INDICE DO MES

        do { //SELECIONA A SEMANA
            System.out.println("SELECIONE A SEMANA: ");
            semana = sc.nextInt();
            if (semana < 1 || semana > 4) {
                System.out.println("Opção inválida!");
            }
        }   while(semana < 1 || semana > 4);
        semana--; //ARRUMAR INDICE DA SEMANA

        //INSERIR O VALOR
        System.out.println("INSIRA O VALOR: ");
        double valor = sc.nextDouble();
        if (valor<0) {
            valor *= -1;
        }

        planilha[mes][semana] = valor;

        printarAcao(planilha, mes, semana);

        return planilha;
    }

    public static double[][] excluir (double[][] planilha) { //EXCLUIR
        Scanner sc = new Scanner(System.in);
        int mes = 0, semana = 0;

        do { //SELECIONA O MES
            System.out.println("SELECIONE O MÊS: ");
            mes = sc.nextInt();
            if (mes < 1 || mes > 12) {
                System.out.println("Opção inválida!");
            }
        }   while(mes < 1 || mes > 12);
        mes--; //ARRUMAR INDICE DO MES

        do { //SELECIONA A SEMANA
            System.out.println("SELECIONE A SEMANA: ");
            semana = sc.nextInt();
            if (semana < 1 || semana > 4) {
                System.out.println("Opção inválida!");
            }
        }   while(semana < 1 || semana > 4);
        semana--; //ARRUMAR INDICE DA SEMANA

        //EXCLUINDO O VALOR

        planilha[mes][semana] = 0;

        printarAcao(planilha, mes, semana);

        return planilha;
    }

    //PARTE DAS DESPESAS
    public static double[][] despesas(double[][] planilha) {
        Scanner sc = new Scanner(System.in);
        int op = 0;
        boolean sair = false;

        do { //VERIFICA A OPERAÇÃO
            System.out.println("1 - Cadastrar/Alterar despesa");
            System.out.println("2 - Excluir despesa");
            System.out.println("3 - Voltar");
            op = sc.nextInt();
            if (op < 1 || op > 3) {
                System.out.println("Opção inválida!");
            }
        }   while(op < 1 || op > 3);

        if (op == 1) {
            cadastrarAlterar(planilha);
        } else if (op == 2) {
            excluir(planilha);
        } else {
            sair = true;
        }

        if (!sair) {
            despesas(planilha);
        }

        return planilha;
    }


    //PARTE DAS RECEITAS

    public static double[][] receitas(double[][] planilha) {
        Scanner sc = new Scanner(System.in);
        int op = 0;
        boolean sair = false;

        do { //VERIFICA A OPERAÇÃO
            System.out.println("1 - Cadastrar/Alterar receita");
            System.out.println("2 - Excluir receita");
            System.out.println("3 - Voltar");
            op = sc.nextInt();
            if (op < 1 || op > 3) {
                System.out.println("Opção inválida!");
            }
        }   while(op < 1 || op > 3);

        if (op == 1) {
            cadastrarAlterar(planilha);
        } else if (op == 2) {
            excluir(planilha);
        } else {
            sair = true;
        }

        if (!sair) {
            despesas(planilha);
        }

        return planilha;
    }

    //ÁREA DAS ESTATÍSTICAS
    public static void estatisticas(double[][] planilhaDespesa, double[][] planilhaReceita) {
        Scanner sc = new Scanner(System.in);
        double[] receitasMes =  new double[12];
        double[] despesasMes =  new double[12];
        double totalReceitas = 0, totalDespesas = 0, totalAno = 0, maiorValorReceita = 0, maiorValorDespesa = 0;
        int mesMaiorDespesa = 0, semanaMaiorDespesa = 0, mesMaiorReceita = 0, semanaMaiorReceita = 0;

        //REGISTRANDO RECEITAS NO TOTAL
        for (int i = 0; i < receitasMes.length ; i++) {
            for(int j = 0 ; j <planilhaReceita.length ; j++ ){
                for(int k = 0 ; k <planilhaReceita[0].length ; k++ ){
                    receitasMes[i] += planilhaReceita[j][k];
                    totalReceitas = receitasMes[i];
                }
            }
        }
        //REGISTRANDO DESPESAS NO TOTAL
        for (int i = 0; i < despesasMes.length ; i++) {
            for(int j = 0 ; j <planilhaDespesa.length ; j++ ){
                for(int k = 0 ; k <planilhaDespesa[0].length ; k++ ){
                    despesasMes[i] -= planilhaDespesa[j][k];
                    totalDespesas = despesasMes[i];
                }
            }
        }

        //TOTAL ANUAL
        totalAno = totalReceitas - totalDespesas;

        //MES E SEMANA COM MAIOR RECEITA REGISTRADO
        for (int i = 0; i < planilhaReceita.length ; i++) {
            for (int j = 0; j < planilhaReceita[0].length ; j++) {
                if(i == 0 && j == 0) {
                    maiorValorReceita = planilhaReceita[i][j];
                    mesMaiorReceita = i;
                    semanaMaiorReceita = j;
                } else {
                    if (planilhaReceita[i][j] > maiorValorReceita) {
                        maiorValorReceita = planilhaReceita[i][j];
                        mesMaiorReceita = i;
                        semanaMaiorReceita = j;
                    }
                }
            }
        }
        //MES E SEMANA COM DESPESA MAIOR REGISTRADO
        for (int i = 0; i < planilhaDespesa.length ; i++) {
            for (int j = 0; j < planilhaDespesa[0].length ; j++) {
                if(i == 0 && j == 0) {
                    maiorValorDespesa = planilhaDespesa[i][j];
                    mesMaiorDespesa = i;
                    semanaMaiorDespesa = j;
                } else {
                    if (planilhaReceita[i][j] > maiorValorReceita) {
                        maiorValorDespesa = planilhaDespesa[i][j];
                        mesMaiorDespesa = i;
                        semanaMaiorDespesa = j;
                    }
                }
            }
        }
        //MÉDIA MENSAL DE DESPESAS
        double somaReceitaMensal = 0;
        double mediaReceitaMensal = 0;
        for (int i = 0; i < planilhaReceita.length ; i++) {
            for (int j = 0; j < planilhaReceita[0].length ; j++) {
                somaReceitaMensal += planilhaReceita[i][j];
            }
        }
        mediaReceitaMensal = somaReceitaMensal / 12;
        //MÉDIA MENSAL DE RECEITAS
        double somaDespesaMensal = 0;
        double mediaDespesaMensal = 0;
        for (int i = 0; i < planilhaDespesa.length ; i++) {
            for (int j = 0; j < planilhaDespesa[0].length ; j++) {
                somaDespesaMensal += planilhaDespesa[i][j];
            }
        }
        mediaReceitaMensal = somaReceitaMensal / 12;

        //EXIBIR ESTATÍSTICAS
        System.out.printf("TOTAL DE DESPESAS(ANO): %.2f\n", totalDespesas);
        System.out.printf("TOTAL DE RECEITAS(ANO): %.2f\n", totalReceitas);
        System.out.printf("SALDO: %.2f\n", totalAno);

        System.out.println("------------------------------------");

        System.out.println("Maiores valores registrados: ");
        System.out.printf("MAIOR despesa: %.2f. Mês %d, semana %d\n", maiorValorDespesa, mesMaiorDespesa, semanaMaiorDespesa);
        System.out.printf("MAIOR receita: %.2f. Mês %d, semana %d\n", maiorValorReceita, mesMaiorReceita, semanaMaiorReceita);

        System.out.println("------------------------------------");

        System.out.printf("Média mensal de despesas: %.2f\n", mediaDespesaMensal);
        System.out.printf("Média mensal de receitas: %.2f\n", mediaReceitaMensal);

        System.out.println();

    }


    //MAIN

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op = 0;
        double[][] planilhaDespesa = new double[12][4];
        double[][] planilhaReceitas = new double[12][4];
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

            System.out.println();

            if (op == 1) {
                System.out.println("ABRINDO MENU DE cadastrar/alterar/excluir despesas...\n");
                despesas(planilhaDespesa);
            } else if (op == 2) {
                System.out.println("ABRINDO MENU DE cadastrar/alterar/excluir receitas...\n");
                receitas(planilhaReceitas);
            } else if (op == 3) {
                System.out.println("ABRINDO MENU DE ver estatísticas...\n");
                estatisticas(planilhaDespesa, planilhaDespesa);
            } else if (op == 4) {
                System.out.println("LISTANDO MESES...\n");
            } else if (op == 5){
                sair = true;
            }
        } while (!sair);

        System.out.println("Você saiu");

    }

    public static void printarAcao(double[][]  planilha, int mes, int semana) {
        for (int i = mes; i < mes+1; i++) {
            for (int j = 0; j < planilha[mes].length; j++) {
                System.out.printf("Mês %d, Semana %d: R$%.2f", i+1, semana+1, planilha[i][j]);
            }
            System.out.println();
        }
    }
}
