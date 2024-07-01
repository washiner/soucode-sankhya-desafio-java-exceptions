import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio04 {

    public static void main(String[] args) {
        List<String> listaStrings = new ArrayList<String>();
        listaStrings.add("Apple");
        listaStrings.add("Sansung");
        listaStrings.add("Sony");
        listaStrings.add("CCE");

        try (Scanner sc = new Scanner(System.in)) {
            int indice;

            do {
                try {
                    System.out.print("Digite o indice para ser removido : "); // digite um indice que nao existe para ver a exception
                    indice = Integer.parseInt(sc.nextLine());

                    removerElemento(listaStrings, indice);
                    break;

                } catch (NumberFormatException e) {
                    System.err.println("Erro ao digitar inteiro.");
                } catch (IndexOutOfBoundsException e) {
                    System.err.println("Erro: indice precisa ser valido na lista. Digite novamente");
                }
            } while (true);
        }
        System.out.println("Lista Atual " + listaStrings);
    }

    public static void removerElemento(List<String> lista, int indice) throws IndexOutOfBoundsException {
        if (indice < 0 || indice >= lista.size()) {
            throw new IndexOutOfBoundsException("Esse indice nao existe na lista");
        }

        lista.remove(indice);
    }
}
