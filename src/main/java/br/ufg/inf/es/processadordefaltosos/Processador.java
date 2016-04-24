package br.ufg.inf.es.processadordefaltosos;

import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


public class Processador extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Processador de Faltosos");
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 900, 250, Color.WHITE);
        
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(15));
        gridPane.setHgap(10);
        ColumnConstraints column1 = new ColumnConstraints(250,150, Double.MAX_VALUE);
        gridPane.getColumnConstraints().add(column1);
        Label alunosDaTurma = new Label("Alunos na Turma");
        TextArea textArea = new TextArea();
        Button botaoAdiciona = new Button("Adiciona");
        botaoAdiciona.setPadding(new Insets(15));
        Button botaoClipBoard = new Button("Copia");
        botaoClipBoard.setPadding(new Insets(15));
        VBox painelBotoes = new VBox(3);
        botaoAdiciona.setMaxWidth(Double.MAX_EXPONENT);
        botaoClipBoard.setMaxWidth(Double.MAX_EXPONENT);
        painelBotoes.getChildren().addAll(botaoAdiciona, botaoClipBoard);
        
        GridPane.setHalignment(alunosDaTurma, HPos.CENTER);
        
        
        gridPane.add(alunosDaTurma, 0, 0);
        gridPane.add(textArea, 2, 1);
        gridPane.add(painelBotoes, 3, 1);
        //gridPane.add(botaoAdiciona, 3, 1);
        //gridPane.add(botaoClipBoard, 3, 2);
        
        final ObservableList<String> turmaDeAlunos = FXCollections.observableArrayList();
        final ListView<String> alunosFaltosos = new ListView<>(turmaDeAlunos);
        gridPane.add(alunosFaltosos, 0, 1);
        
        root.setCenter(gridPane);
        
        stage.setScene(scene);
        stage.show();
    }

}
