package lista3;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    // Configuração básica
    private static final int MESES = 12;
    private static final int SEMANAS = 5; // 1..5 por simplicidade
    private static final String[] NOMES_MESES = {
            "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
            "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"
    };

    // Matrizes: linhas = meses (0..11), colunas = semanas (0..4)
    private static final double[][] despesas = new double[MESES][SEMANAS];
    private static final double[][] receitas = new double[MESES][SEMANAS];

    public static void main(String[] args) {
        Locale.setDefault(Locale.forLanguageTag("pt-BR"));
        Scanner sc = new Scanner(System.in);

        while (true) {
            imprimirMenuPrincipal();
            int opcao = lerIntNoIntervalo(sc, "Escolha uma opção: ", 1, 5);

            switch (opcao) {
                case 1:
                    submenuMovimentacao(sc, true);  // despesas
                    break;
                case 2:
                    submenuMovimentacao(sc, false); // receitas
                    break;
                case 3:
                    verEstatisticas(sc);
                    break;
                case 4:
                    listarMeses();
                    break;
                case 5:
                    System.out.println("Encerrando. Que seu saldo não chore no fim do mês.");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void imprimirMenuPrincipal() {
        System.out.println("\n=== GERENCIADOR FINANCEIRO (matriz 12 x 5) ===");
        System.out.println("1 - Cadastrar/Alterar/Excluir DESPESAS");
        System.out.println("2 - Cadastrar/Alterar/Excluir RECEITAS");
        System.out.println("3 - Ver estatísticas");
        System.out.println("4 - Listar meses");
        System.out.println("5 - Sair");
    }

    private static void submenuMovimentacao(Scanner sc, boolean ehDespesa) {
        String tipo = ehDespesa ? "DESPESA" : "RECEITA";
        while (true) {
            System.out.println("\n--- " + tipo + " ---");
            System.out.println("1 - Cadastrar/Alterar valor");
            System.out.println("2 - Excluir valor (zerar)");
            System.out.println("3 - Ver valores de um mês");
            System.out.println("4 - Voltar");
            int op = lerIntNoIntervalo(sc, "Escolha: ", 1, 4);

            if (op == 4) return;

            int mes = lerIntNoIntervalo(sc, "Mês (1-12): ", 1, 12) - 1;
            if (op == 3) {
                imprimirMesCompleto(mes, ehDespesa);
                continue;
            }
            int semana = lerIntNoIntervalo(sc, "Semana (1-5): ", 1, 5) - 1;

            if (op == 1) {
                double valor = lerDoubleNaoNegativo(sc, "Valor " + (ehDespesa ? "(despesa ≥ 0)" : "(receita ≥ 0)") + ": ");
                setValor(mes, semana, ehDespesa, valor);
                System.out.printf("%s definida: %s, semana %d => R$ %.2f%n",
                        tipo, NOMES_MESES[mes], (semana + 1), valor);
            } else if (op == 2) {
                setValor(mes, semana, ehDespesa, 0.0);
                System.out.printf("Valor de %s em %s, semana %d removido (zerado).%n",
                        tipo, NOMES_MESES[mes], (semana + 1));
            }
        }
    }

    private static void setValor(int mes, int semana, boolean ehDespesa, double valor) {
        if (ehDespesa) despesas[mes][semana] = valor;
        else receitas[mes][semana] = valor;
    }

    private static void imprimirMesCompleto(int mes, boolean ehDespesa) {
        double[][] base = ehDespesa ? despesas : receitas;
        String tipo = ehDespesa ? "Despesas" : "Receitas";
        System.out.println("\n" + tipo + " de " + NOMES_MESES[mes] + ":");
        double soma = 0;
        for (int s = 0; s < SEMANAS; s++) {
            System.out.printf("  Semana %d: R$ %.2f%n", (s + 1), base[mes][s]);
            soma += base[mes][s];
        }
        System.out.printf("  Total do mês: R$ %.2f%n", soma);
    }

    private static void verEstatisticas(Scanner sc) {
        System.out.println("\n=== ESTATÍSTICAS ===");

        double totalDespesasAno = somaTotal(despesas);
        double totalReceitasAno = somaTotal(receitas);
        double saldoAno = totalReceitasAno - totalDespesasAno;
        System.out.printf("Total DESPESAS (ano): R$ %.2f%n", totalDespesasAno);
        System.out.printf("Total RECEITAS (ano): R$ %.2f%n", totalReceitasAno);
        System.out.printf("SALDO (ano): R$ %.2f%n", saldoAno);

        // Por mês
        System.out.println("\nTotais por mês:");
        for (int m = 0; m < MESES; m++) {
            double dMes = somaLinha(despesas, m);
            double rMes = somaLinha(receitas, m);
            double sMes = rMes - dMes;
            System.out.printf("  %s -> Despesas: R$ %.2f | Receitas: R$ %.2f | Saldo: R$ %.2f%n",
                    NOMES_MESES[m], dMes, rMes, sMes);
        }

        // Maiores valores
        Ponto maxDesp = maxValor(despesas);
        Ponto maxRec = maxValor(receitas);
        System.out.println("\nMaiores valores registrados:");
        if (maxDesp != null)
            System.out.printf("  Maior DESPESA: R$ %.2f em %s (semana %d)%n",
                    maxDesp.valor, NOMES_MESES[maxDesp.mes], (maxDesp.semana + 1));
        if (maxRec != null)
            System.out.printf("  Maior RECEITA: R$ %.2f em %s (semana %d)%n",
                    maxRec.valor, NOMES_MESES[maxRec.mes], (maxRec.semana + 1));

        // Médias
        double mediaDespMes = totalDespesasAno / MESES;
        double mediaRecMes = totalReceitasAno / MESES;
        System.out.printf("%nMédia mensal de DESPESAS: R$ %.2f%n", mediaDespMes);
        System.out.printf("Média mensal de RECEITAS: R$ %.2f%n", mediaRecMes);

        // Semana mais cara por mês (opcional e útil)
        System.out.println("\nSemana mais cara por mês (despesas):");
        for (int m = 0; m < MESES; m++) {
            int semanaMax = indiceMaxColuna(despesas[m]);
            System.out.printf("  %s -> semana %d (R$ %.2f)%n",
                    NOMES_MESES[m], (semanaMax + 1), despesas[m][semanaMax]);
        }
    }

    private static void listarMeses() {
        System.out.println("\n=== LISTA DE MESES ===");
        for (int m = 0; m < MESES; m++) {
            double dMes = somaLinha(despesas, m);
            double rMes = somaLinha(receitas, m);
            double sMes = rMes - dMes;
            System.out.printf("%2d - %-10s | Despesas: R$ %.2f | Receitas: R$ %.2f | Saldo: R$ %.2f%n",
                    (m + 1), NOMES_MESES[m], dMes, rMes, sMes);
        }
    }

    // Utilitários numéricos e de leitura
    private static double somaTotal(double[][] mat) {
        double soma = 0;
        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j < mat[i].length; j++)
                soma += mat[i][j];
        return soma;
    }

    private static double somaLinha(double[][] mat, int linha) {
        double soma = 0;
        for (int j = 0; j < mat[linha].length; j++)
            soma += mat[linha][j];
        return soma;
    }

    private static int indiceMaxColuna(double[] vetor) {
        int idx = 0;
        for (int i = 1; i < vetor.length; i++) {
            if (vetor[i] > vetor[idx]) idx = i;
        }
        return idx;
    }

    private static int lerIntNoIntervalo(Scanner sc, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            try {
                int v = Integer.parseInt(s);
                if (v < min || v > max) {
                    System.out.printf("Digite um inteiro entre %d e %d.%n", min, max);
                    continue;
                }
                return v;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Tente de novo.");
            }
        }
    }

    private static double lerDoubleNaoNegativo(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().replace(',', '.').trim();
            try {
                double v = Double.parseDouble(s);
                if (v < 0) {
                    System.out.println("Valor não pode ser negativo.");
                    continue;
                }
                return v;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Use números, por favor.");
            }
        }
    }

    // Estrutura para manter posição de um valor máximo
    private static class Ponto {
        int mes;
        int semana;
        double valor;

        Ponto(int mes, int semana, double valor) {
            this.mes = mes;
            this.semana = semana;
            this.valor = valor;
        }
    }

    private static Ponto maxValor(double[][] mat) {
        int mm = -1, ss = -1;
        double max = -1;
        for (int m = 0; m < mat.length; m++) {
            for (int s = 0; s < mat[m].length; s++) {
                if (mat[m][s] > max) {
                    max = mat[m][s];
                    mm = m;
                    ss = s;
                }
            }
        }
        if (mm == -1) return null;
        return new Ponto(mm, ss, max);
    }
}
