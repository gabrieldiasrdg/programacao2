package ListaRevisao;

import javax.xml.transform.Source;
import java.util.Scanner;

public class EX2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] comandos = {"ESCREVA", "LEIA", "PUXE", "PULE", "CALCULE", "TRANSFIRA", "SENAO", "ESCOLHA", "ENQUANTO", "FACA"};
        String[] expressoesLogicas = {"AND", "OR", "NOT"};
        String codigo = "";
        int comandosCertos = 0, qtdCaracteres = 0;

        System.out.println("Insira o código: ");
        codigo = sc.nextLine().toUpperCase();
        qtdCaracteres = codigo.length(); //QUANTIDADE DE CARACTERES
        String[] vetorCodigo = codigo.replaceAll("[()]", " ").split("\\s+");

        //COMANDOS CORRETOS
        for (int i = 0; i < vetorCodigo.length; i++) {
            for (int j = 0; j < comandos.length; j++) {
                if(vetorCodigo[i].equals(comandos[j])) {
                    comandosCertos++;
                }
            }
        }

        //PARÊNTESES
        boolean parentesesCorretos = true;
        boolean parentesesAberto = true;
        boolean temParentese = false;
        for (int i = 0; i < codigo.length(); i++) {
            if (codigo.charAt(i) == ')' && parentesesAberto) {
                parentesesCorretos = false;
                break;
            } else if (codigo.charAt(i) == '(') {
                temParentese = true;
                parentesesAberto = false;
                if (i == codigo.length()-1) {
                    parentesesCorretos = false;
                    break;
                } else {
                    for (int j = i + 1; j < comandos.length; j++) {
                        if (codigo.charAt(j) == ')') {
                            break;
                        } else if (codigo.charAt(j) == '(') {
                            parentesesCorretos = false;
                            break;
                        }
                    }
                }
            }
            if (!parentesesCorretos) {
                break;
            }
        }

        //VALOR LÓGICO
        boolean operadoresCorretos = true;
        boolean temOperadores = false;
        for (int i = 0; i < vetorCodigo.length; i++) {
            for (int j = 0; j < expressoesLogicas.length; j++) {
                if (vetorCodigo[i].equals(expressoesLogicas[j])) {
                    temOperadores = true;
                    if (i == vetorCodigo.length-1) {
                        operadoresCorretos = false;
                        break;
                    } else {
                        for (int k = 0; k < expressoesLogicas.length; k++) {
                            if (expressoesLogicas[k].equals(vetorCodigo[i + 1])) {
                                operadoresCorretos = false;
                                break;
                            }
                        }
                    }
                }
            }
        }


        //ESCREVER NA TELA
        System.out.println("Quantidade de caracteres digitados: "+qtdCaracteres);
        System.out.println("Quantidade de comandos certos: "+comandosCertos);
        if (parentesesCorretos && temParentese) {
            System.out.println("Parenteses corretos");
        } else if (!parentesesCorretos && temParentese){
            System.out.println("Parenteses incorretos");
        } else if (!temParentese) {
            System.out.println("Não há parênteses");
        }
        if (operadoresCorretos && temOperadores) {
            System.out.println("Operadores Corretos!");
        } else if(!operadoresCorretos && temOperadores){
            System.out.println("Operadores Incorretos!");
        } else if (!temOperadores) {
            System.out.println("Não há Operadores");
        }



    }
}
