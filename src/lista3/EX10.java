package lista3;

import java.util.Scanner;

public class EX10 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        final int CAPACIDADE=10;
        int[]trilho=new int[CAPACIDADE];
        int tamanhoTrilho=0;
        int[]estacionamentoTemp=new int[CAPACIDADE];
        int tamanhoEst=0;
        while(true){
            System.out.println("1 - Chegada de trem");
            System.out.println("2 - Saída de trem");
            System.out.println("3 - Mostrar estado");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            int opcao=sc.nextInt();
            if(opcao==0)break;
            switch(opcao){
                case 1:
                    System.out.print("Número do trem: ");
                    int tremChegada=sc.nextInt();
                    boolean existe=false;
                    for(int i=0;i<tamanhoTrilho;i++){
                        if(trilho[i]==tremChegada){
                            existe=true;
                            break;
                        }
                    }
                    if(existe){
                        System.out.println("Esse trem já está no trilho!");
                        break;
                    }
                    if(tamanhoTrilho<CAPACIDADE){
                        trilho[tamanhoTrilho++]=tremChegada;
                        System.out.println("Trem "+tremChegada+" entrou no trilho.");
                    }else{
                        System.out.println("Trilho cheio! Não é possível adicionar mais trens.");
                    }
                    break;
                case 2:
                    if(tamanhoTrilho==0){
                        System.out.println("Trilho vazio, nenhum trem para sair.");
                        break;
                    }
                    System.out.print("Número do trem a sair: ");
                    int tremSaida=sc.nextInt();
                    int indice=-1;
                    for(int i=0;i<tamanhoTrilho;i++){
                        if(trilho[i]==tremSaida){
                            indice=i;
                            break;
                        }
                    }
                    if(indice==-1){
                        System.out.println("Trem não encontrado!");
                        break;
                    }
                    tamanhoEst=0;
                    for(int i=tamanhoTrilho-1;i>indice;i--){
                        estacionamentoTemp[tamanhoEst++]=trilho[i];
                    }
                    tamanhoTrilho=indice;
                    System.out.println("Trem "+tremSaida+" saiu do trilho.");
                    for(int i=tamanhoEst-1;i>=0;i--){
                        trilho[tamanhoTrilho++]=estacionamentoTemp[i];
                    }
                    break;
                case 3:
                    System.out.print("Trilho: ");
                    if(tamanhoTrilho==0)System.out.print("[vazio]");
                    for(int i=0;i<tamanhoTrilho;i++){
                        System.out.print(trilho[i]+" ");
                    }
                    System.out.println();
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
        sc.close();
    }
}