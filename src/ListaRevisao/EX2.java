package ListaRevisao;

import java.util.Scanner;

public class EX2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] comandos = {"ESCREVA", "LEIA", "PUXE", "PULE", "CALCULE", "TRANSFIRA", "SENAO", "ESCOLHA", "ENQUANTO", "FACA"};
        String[] expressoesLogicas = {"AND", "OR", "NOT"};
        String codigo = "";

        System.out.println("Insira o código: ");
        codigo = sc.nextLine().toUpperCase();
        String[] vetorCodigo = codigo.split("\\s+");

        for (int i = 0; i < vetorCodigo.length; i++) {
            if (vetorCodigo[i].equals(codigo)) {

            }
        }



    }
}
