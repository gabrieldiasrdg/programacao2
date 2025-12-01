package Lista4;

public class EX10 {
    public static void main(String[] args) {
        int discos = 5;
        hanoi(discos, 'A', 'B', 'C');
    }

    private static void hanoi(int discos, char origem, char auxiliar, char destino) {
        if (discos > 0) {
            hanoi(discos - 1, origem, destino, auxiliar); //origem to auxiliar
            System.out.printf("Mover de %s para %s%n", origem, destino);
            hanoi(discos - 1, auxiliar, origem, destino); //auxiliar to auxiliar
        }
    }
}

//EU RECORRI A UM VÍDEO NO YOUTUBE, POIS NÃO ESTAVA ENTENDENDO MUITO BEM...