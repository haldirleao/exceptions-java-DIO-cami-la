package br.com.dio.exceptions;

import javax.swing.*;
import java.io.*;

//Imprimir um arquivo no console.
public class CheckedExceptionRevHaldir {
    public static void main(String[] args) {
        // NOTA: arquivo na pasta raiz do projeto "exceptions-java-DIO-cami-la"
        // logo não é necessário indicar o caminho
        String nomeDoArquivo = "romance-blake-crouch.txt"; // correto: "romances-blake-crouch.txt"

        try {
            imprimirArquivoNoConsole(nomeDoArquivo);

        } catch (FileNotFoundException e) { // NOTA: as classes de exceção filhas devem ser declaradas
                                            // antes de suas classes mães. IOException é classe mãe da
                                            // FileNotFoundException.
            JOptionPane.showMessageDialog(null,
                    "Revise o nome do arquivo que você deseja imprimir! " + "\nExceção: " + e.getMessage());
            // e.printStackTrace();

        } catch (IOException e) {
            // e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    // como não sabemos especificamente como/quando a exceção pode ocorrer,
                    // o jeito é correr atrás do suporte!!! :-/
                    "Ocorreu um erro inesperado! Entre em contato com o suporte! " + e.getMessage());
        } finally {
            System.out.println("Entrou no finally!");
        }

        System.out.println("Independentemente da exception ou não, o programa continua...");
        System.out.println("Print imediatamente antes de sair do main.");

    }

    public static void imprimirArquivoNoConsole(String nomeDoArquivo) throws IOException {
        File file = new File(nomeDoArquivo);

        BufferedReader br = new BufferedReader(new FileReader(file.getName()));
        String line = br.readLine();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        do {
            bw.write(line);
            bw.newLine();
            line = br.readLine();
        } while (line != null);
        bw.flush();
        br.close();
    }
}
