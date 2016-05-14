package br.ufg.inf.es.processadordefaltosos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Netsteller
 */
public class ProcessadorJson {

    public void converteCsvParaJson(File arquivoCsv) {

        JSONObject objetoJson;
        JSONArray arrayJson = new JSONArray();
        List<ArrayList<String>> listaAlunos = new ArrayList<>(40);
        ReadCSV readCSV = new ReadCSV();
        listaAlunos = readCSV.resgataAtributos(arquivoCsv);
        String matriculaAluno;
        String nomeAluno;
        String nomeMae;
        String rua;
        String quadra;
        String lote;
        String bairro;
        String telefone;
        
        for (int i = 0; i < listaAlunos.size(); i++) {
            objetoJson = new JSONObject();
            
            matriculaAluno = listaAlunos.get(i).get(0).trim();
            nomeAluno = listaAlunos.get(i).get(1).trim();
            System.out.println(nomeAluno);
            nomeMae = listaAlunos.get(i).get(2).trim();
            rua = listaAlunos.get(i).get(3).trim();
            quadra = listaAlunos.get(i).get(4).trim();
            lote = listaAlunos.get(i).get(5).trim();
            bairro = listaAlunos.get(i).get(6).trim();
            telefone = "";
            
            objetoJson.put("Matricula", matriculaAluno);
            objetoJson.put("Nome", nomeAluno);
            objetoJson.put("Mae", nomeMae);
            objetoJson.put("Rua", rua);
            objetoJson.put("Quadra", quadra);
            objetoJson.put("Lote", lote);
            objetoJson.put("Bairro", bairro);
            objetoJson.put("Telefone", telefone);
            
            arrayJson.add(objetoJson);            
        }

        try {
            FileOutputStream fos = new FileOutputStream(new File("C:\\Prototypes\\alunos_dados_completo.json"));
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            osw.write(arrayJson.toJSONString());
            osw.flush();
            osw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }    
}
