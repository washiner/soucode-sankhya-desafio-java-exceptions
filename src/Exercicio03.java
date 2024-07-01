import java.util.ArrayList;
import java.util.List;

public class Exercicio03 {

    public static void main(String[] args) {
        List<String> listaStrings = new ArrayList<String>();
        listaStrings.add("20");
        listaStrings.add("30");
        listaStrings.add("40");
        listaStrings.add("50");
        listaStrings.add("sessenta"); //tipo errado pra ver o erro

        try {
            List<Integer> listaInteiros = converterParaInteiros(listaStrings);
            System.out.println("inteiros da lista convertido " + listaInteiros);
        } catch (InvalidTypeConversionException e) {
            System.err.println(e.getMessage());
        }
    }

    public static List<Integer> converterParaInteiros(List<String> listaStrings) throws InvalidTypeConversionException {
        List<Integer> listaInteiros = new ArrayList<Integer>();

        for (String str : listaStrings) {
            try {
                int numero = Integer.parseInt(str);
                listaInteiros.add(numero);
            } catch (NumberFormatException e) {
                throw new InvalidTypeConversionException("Erro para converter a string '" + str + "' em inteiro.");
            }
        }

        return listaInteiros;
    }

    public static class InvalidTypeConversionException extends Exception {
        public InvalidTypeConversionException(String message) {
            super(message);
        }
    }
}
