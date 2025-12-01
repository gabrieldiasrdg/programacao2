package Lista4;

import java.util.Scanner;

public class EX8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira uma palavra: ");
        String p = sc.next().toUpperCase();
        int i = 0;

        if (ehPalidromo(p, i)) {
            System.out.printf("%s é um palíndromo", p);
        } else if (!ehPalidromo(p, i)) {
            System.out.printf("%s NÃO é um palíndromo", p);
        }

    }
    private static boolean ehPalidromo(String p, int i) {
        if ((p.length()+1)/2 == i) {
            return true;
        } else if (i == p.length()-1) {
            return true;
        } else if (p.charAt(i) != p.charAt(p.length()-(i+1))) {
            return false;
        }
        return ehPalidromo(p, i+1);
    }
}
