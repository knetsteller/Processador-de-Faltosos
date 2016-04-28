package br.ufg.inf.es.processadordefaltosos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Netsteller
 */
public class ReadCSV {

    static File csvFile = null;

    public static void main(String[] args) {
    }

    public static ArrayList<String> readCsv(File file) {
        ArrayList<String> listaNomes = new ArrayList<>(40);
        BufferedReader br = null;
        String line = "";
        String csvSplitBy = ";";

        try {
            //br = new BufferedReader(new FileReader(file));
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            while ((line = br.readLine()) != null) {
                String[] nomes = line.split(csvSplitBy);
                listaNomes.add(nomes[1]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return listaNomes;
    }

    public static StringBuilder readDataFromStudent(String student) {
        ArrayList<String> listaNomes = new ArrayList<>(40);
        BufferedReader br = null;
        String line = "";
        String csvSplitBy = ";";
        StringBuilder dadosAluno = new StringBuilder();

        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(csvFile), "UTF-8"));
            while ((line = br.readLine()) != null) {
                String[] nomes = line.split(csvSplitBy);
                if (nomes[1].equals(student)) {

                    System.out.println("Nome: " + nomes[1]);
                    System.out.println("Mãe: " + nomes[3]);
                    System.out.println("Endereço: " + nomes[5] + ", " + "QUADRA " + nomes[6] + " LOTE " + nomes[7] + ", " + nomes[10]);
                    System.out.println("Telefone: " + nomes[12]);
                    System.out.print("\n");

                    dadosAluno.append("Nome: " + nomes[1] + "\n");
                    dadosAluno.append("Mãe: " + nomes[3] + "\n");
                    dadosAluno.append("Endereço: " + nomes[5] + ", " + "QUADRA " + nomes[6] + " LOTE " + nomes[7] + ", " + nomes[10] + "\n");
                    dadosAluno.append("Telefone: " + nomes[12] + "\n");
                    dadosAluno.append("\n");

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return dadosAluno;
    }

}
