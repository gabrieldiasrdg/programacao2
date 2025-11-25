package Lista4;

import java.util.Locale;
import java.util.Scanner;

public class EX6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira uma String: ");
        String s = sc.nextLine().toUpperCase();
        int tamanhoString = s.length()-1;

        System.out.println("String invertida: "+inverterString(s,tamanhoString));
    }
    public static String inverterString(String s, int tamanhoString) {
        String novaString = "";
        novaString += s.charAt(tamanhoString);
        if (tamanhoString == 0) {
            return novaString;
        }

        return novaString += inverterString(s, tamanhoString - 1);
    }
}
