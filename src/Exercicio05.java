import java.util.Scanner;

public class Exercicio05 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Digite o primeiro numero inteiro ");
            double numero1 = Double.parseDouble(scanner.nextLine());

            System.out.print("Digite a operacao matematica (+, -, *, /): ");
            String operacao = scanner.nextLine();

            System.out.print("Digite o segundo numero inteiro ");
            double numero2 = Double.parseDouble(scanner.nextLine());

            double resultado = realizarOperacao(numero1, numero2, operacao);
            System.out.println("Resultado  " + resultado);

        } catch (NumberFormatException e) {
            System.err.println("Erro: numero inteiro invalodo. Digite um numero inteiro.");
        } catch (InvalidOperationException e) {
            System.err.println(e.getMessage());
        } catch (ArithmeticException e) {
            System.err.println("Erro: nao e possivel divisao por zero");
        } finally {
            scanner.close();
            System.out.println("Programa finalizado");
        }
    }

    public static double realizarOperacao(double numero1, double numero2, String operacao) throws InvalidOperationException, ArithmeticException {
        switch (operacao) {
            case "+":
                return numero1 + numero2;
            case "-":
                return numero1 - numero2;
            case "*":
                return numero1 * numero2;
            case "/":
                if (numero2 == 0) {
                    throw new ArithmeticException("Divisão por zero não permitida.");
                }
                return numero1 / numero2;
            default:
                throw new InvalidOperationException("operacao matematica nao existe -> Utilize +, -, *, ou /.");
        }
    }

    public static class InvalidOperationException extends Exception {
        public InvalidOperationException(String message) {
            super(message);
        }
    }
}
