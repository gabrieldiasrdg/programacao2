package lista3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EX9 {

    public static void criarArquivo (String caminho) {
        File arquivo = new File(caminho);

        try {
            if(arquivo.createNewFile()) {
                System.out.println("Arquivo criado com sucesso!");
            } else {
                System.out.println("Arquivo já existe!");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void escreverAqruivo(String caminho) {
        try (FileWriter fw = new FileWriter(caminho)) {
            fw.write("Chama na bota!");
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    public static void tratamnentoDivisaoPor0(int x, int y) {
        Scanner sc = new Scanner(System.in);
        int divisao = 0;

        try {
            divisao = x/y;
            System.out.println("x/y: "+divisao);
        } catch (ArithmeticException e) {
            criarArquivo("arquivo.txt");
            escreverAqruivo("arquivo.txt");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = 0, y = 0;

        System.out.println("Insira o valor de X e de Y: ");
        x = sc.nextInt();
        y = sc.nextInt();

        tratamnentoDivisaoPor0(x, y);

    }
}
