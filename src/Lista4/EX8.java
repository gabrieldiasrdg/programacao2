package Lista4;

import java.util.Scanner;

public class EX8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira uma palavra: ");
        String p = sc.next();
        int i = 0;

        if (ehPalidromoImpar(p, i)) {
            System.out.printf("%s é um palíndromo", p);
        } else if (!ehPalidromoImpar(p, i)) {
            System.out.printf("%s NÃO é um palíndromo", p);
        }

    }
    private static boolean ehPalidromoImpar(String p, int i) {
        if ((p.length()+1)/2 == i) {
            return true;
        } else if (p.charAt(i) != p.charAt(p.length()-(i+1))) {
            return false;
        }
        return ehPalidromoImpar(p, i++);
    }
}
