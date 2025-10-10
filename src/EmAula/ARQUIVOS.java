package EmAula;
import java.io.File;

public class ARQUIVOS {
    public static void main(String[] args) {
        String raiz = "C:\\Users\\2025101202010009\\programacao\\loja\\";
        File dir = new File(raiz);
        if(!dir.exists()) {
            dir.mkdir();
        }
        dir = new File (raiz+"/site");
        if (!dir.exists()) {
            dir.mkdir();
        }
        dir = new File (raiz+"/site/imagens");if (!dir.exists()) {
            dir.mkdir();
        }
        dir = new File (raiz+"/site/videos");if (!dir.exists()) {
            dir.mkdir();
        }
        dir = new File (raiz+"/site/sons");if (!dir.exists()) {
            dir.mkdir();
        }
        System.out.println("Final do processo de criação");
    }
}