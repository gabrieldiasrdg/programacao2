package lista3;

public class EX8 {

    public static void imprimirMusica () {
        String letra = "eu te amo muito mas agora é tarde eu vou dormir", fraseAtual = "";
        String[] vetor = letra.split(" ");


        for (int i = 0; i < vetor.length ; i++) {
            for(int j = 0; j <= i ; j++){
                fraseAtual += vetor[j] + " ";
            }
            System.out.println("Yeah " + fraseAtual);
            fraseAtual = "";
        }

        for(int i = vetor.length - 2; i >= 0 ; i--){
            for(int j = 0; j <= i ; j++){
                fraseAtual += vetor[j] + " ";
            }
            System.out.println("Yeah " + fraseAtual);
            fraseAtual = "";
        }
    }

    public static void main(String[] args) {
        System.out.println("Música Mame D’Agua de Walter Franco: ");
        imprimirMusica();
    }
}
