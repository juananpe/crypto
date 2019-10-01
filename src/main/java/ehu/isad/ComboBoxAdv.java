package ehu.isad;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.List;


public class ComboBoxAdv extends Application  {

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("ComboBox Experiment 1");

        ComboBox comboBox = new ComboBox();

        ObservableList<Argazki> argazkiList = FXCollections.observableArrayList();


        comboBox.getItems().addAll(List.of(
            new Argazki("Elefantea", "elefantea.jpeg"),
            new Argazki("Txakurra", "txakurra.jpeg"),
            new Argazki("Untxia", "untxia.png")
        ));

        comboBox.setEditable(false);

        comboBox.setOnAction( e -> {
            Argazki a = (Argazki)comboBox.getValue();
            System.out.println(a.getFitx());
            System.out.println(a.getIzena());
        });

        HBox hbox = new HBox(comboBox);

        Scene scene = new Scene(hbox, 200, 120);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

//    public static void main(String[] args) {
//        Application.launch(args);
//    }
}
