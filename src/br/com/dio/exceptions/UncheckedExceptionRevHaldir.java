package br.com.dio.exceptions;

// Com edições de haldirleao 19/abr/2023

import javax.swing.*; // para saber mais: https://www.javatpoint.com/java-swing

//Fazer a divisão de 2 valores double
public class UncheckedExceptionRevHaldir {
    public static void main(String[] args) {

        boolean continueLooping = true;
        do {
            String a = JOptionPane.showInputDialog("Numerador da divisão: ");
            String b = JOptionPane.showInputDialog("Denominador da divisão: ");

            try {
                double resultado = dividir(Double.parseDouble(a), Double.parseDouble(b));
                // System.out.println("Resultado: " + resultado);
                JOptionPane.showMessageDialog(null, (a + " / " + b + " = " + resultado), "Resultado", 1);
                continueLooping = false;
            } catch (NumberFormatException e) {
                // e.printStackTrace(); // imprime a stacktrace para debug do dev.
                // JOptionPane.showMessageDialog(null,
                // "Entrada inválida, informe um número inteiro!" + "\nException: " +
                // e.getMessage());
                JOptionPane.showMessageDialog(null, "Entrada inválida (deve ser número)!",
                        "Exception: " + e.getMessage(), 2);

            } catch (NullPointerException e) {
                e.printStackTrace(); // imprime a stacktrace para debug do dev.
                JOptionPane.showMessageDialog(null, "Entrada inválida (deve ser número)!",
                        "Exception: " + e.getMessage(), 2);

            }
            // Com double não ocorre exceção, pois o resultado é "Infinity". Para saber
            // mais:
            // https://medium.com/@kalpa752mohotti/dividing-by-zero-in-java-93da5d4112bd
            catch (ArithmeticException e) {
                // e.printStackTrace(); // imprime a stacktrace para debug do dev.
                JOptionPane.showMessageDialog(null,
                        "Impossível dividir um número por 0." + "\nException: " + e.getMessage());
            } finally {
                System.out.println("Entrou no finally!");
            }
        } while (continueLooping);

        System.out.println("Print imediatamente antes de sair do main...");
    }

    public static double dividir(double a, double b) {
        return a / b;
    }
}
