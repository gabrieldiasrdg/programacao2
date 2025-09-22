package lista3;

import java.util.Scanner;

public class EX1e2 {

    public static boolean testarFormaEmail(String email) {
        boolean ehEmail = true, temArroba = false, temPonto = false;;
        String letrasAposArroba = "", letrasAposPonto = "";

        for(int i = 0 ; i<email.length() ; i++ ) {
            char caracter = email.charAt(i);
            if (caracter == '@' ) { //Verifica se tem @
                temArroba = true;
            } else if(i == email.length()-1 && !temArroba) { //Se não tiver @ até o ultimo caracter n é email
                ehEmail = false;
            } else if (temPonto) { //guarda caracteres após o ponto
                letrasAposPonto += caracter;
            } else if(letrasAposPonto.length() < 2 && i == email.length()-1) { //Se tiver mais que 1 caracter e tiver ponto
                ehEmail = false;
            } else { // senão, é falso
                ehEmail = true;
            } if (temArroba && caracter == '.'){ //verifica se tem ponto após o arroba
                temPonto = true;
            } else if(i == email.length()-1 && !temPonto) { //Se não tiver ponto do @ ao último char n é email
                ehEmail = false;
            } else if (temArroba && !temPonto) { //conta quantas letras após o arroba e até o ponto tem
                letrasAposArroba += caracter;
            } else if (letrasAposArroba.length() < 2 && i == email.length()-1) { //Verifica se letras após o arroba é maior 1
                ehEmail = false;
            } else { //Se não for é falso
                ehEmail = true;
            }
        }

        return ehEmail;
    }

    public static String dominioEmail(String email) {
        String dominio = "";
        boolean ehArroba = false;
        for (int i = 0; i < email.length(); i++) {
            char caracter = email.charAt(i);
            if (caracter == '@') {
                ehArroba = true;
            } else if (ehArroba) {
                dominio = email.substring(i, email.length());
                break;
            }
        }
        return dominio;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String email = "";
        String dominio = "";

        System.out.println("Insira o Email: ");
        email =sc.nextLine();

        if(testarFormaEmail(email)) {
            dominio = dominioEmail(email);
            System.out.println("Dominio Email: " + dominio);
        } else if (!testarFormaEmail(email)) {
            System.out.println("Forma do enderço de Email inválido!");
        }
    }

}
