package ehu.isad;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CrackMono extends Application {

  private String kripto = "KNXMNSL KWJXMBFYJW GJSIX FSI XFQYBFYJW HTFXYX WJBFWIX FSDTSJ KJJQNSL XYWJXXJI. WJXTZWHJKZQ FSLQJWX ZXZFQQD KNSI RFXYJWKZQ QJFUJWX KZS FSI FIRNY XBTWIKNXM WFSP TAJWBMJQRNSL FSDIFD.";
  private TextArea kriptograma = new TextArea(kripto);
  private TextArea testua = new TextArea();
  private String mezuArgia = "";
  private VBox vboxAlfabetoa = new VBox();

  private Character[] alfabetoa = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {

    HBox nagusia = hasieratu();

    Scene scene = new Scene(new StackPane(nagusia), 500, 700);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Crack Monoalfabetikoa");
    primaryStage.show();

  }

  private HBox hasieratu() {
    sortuAlfabetoa();

    kriptograma.setWrapText(true);
    kriptograma.setMaxWidth(300);

    kriptograma.selectedTextProperty().addListener((obs, old, niu) -> {
      int caret = kriptograma.getCaretPosition();
      int anchor = kriptograma.getAnchor();

      testua.selectRange(anchor, caret);
    });


    testua.setWrapText(true);
    testua.setMaxWidth(300);

    testua.selectedTextProperty().addListener((obs, old, niu) -> {
      int caret = testua.getCaretPosition();
      int anchor = testua.getAnchor();

      kriptograma.selectRange(anchor, caret);
    });



    hasieratuMezuArgia();
    testua.setText(mezuArgia);

    Text mezuaLabel = new Text("Mezu argia:");
    Text kriptoLabel = new Text("Kriptograma:");


    TextArea etaoin = new TextArea("Ingelesan gehien errepikatzen diren hizkiak: ETAOIN SHRDLU");
    etaoin.setWrapText(true);
    etaoin.setMaxWidth(300);
    String frequency = maiztasuna();
    etaoin.setText(etaoin.getText() + "\n" + frequency);

    VBox testuak = new VBox();
    testuak.getChildren().addAll(kriptoLabel, kriptograma, mezuaLabel, testua, etaoin);

    HBox nagusia = new HBox();
    nagusia.setSpacing(30);
    nagusia.getChildren().addAll(vboxAlfabetoa, testuak);

    return nagusia;

  }

  private String maiztasuna() {
    HashMap<Character, Integer> emaitza = new HashMap<>();

    for (int i = 0; i < kripto.length(); i++) {
      if (kripto.charAt(i) == ' ') continue;
      Integer zenbat = emaitza.get(kripto.charAt(i));
      zenbat = zenbat == null ? 0 : zenbat;
      emaitza.put(kripto.charAt(i), ++zenbat);
    }

    return emaitza.entrySet()
        .stream()
        .sorted(Map.Entry.comparingByValue())
        .collect(Collectors.toList()).toString();

  }

  private void hasieratuMezuArgia() {
    for (int i = 0; i < kripto.length(); i++) {
      char c = '_';
      if (kripto.charAt(i) == ' ') c = ' ';
      mezuArgia += c;
    }
  }

  private void sortuAlfabetoa() {

    for (Character c : alfabetoa) {

      Text t = new Text("" + c);
      TextField tf = new TextField(" ");
      tf.setMaxWidth(30);
      tf.setOnAction(e -> {
        char hizki = ((TextField) e.getSource()).getText().charAt(0);
        aldatuMezuArgian(c, hizki);
        testua.setText(mezuArgia);
      });

      HBox hBox = new HBox();
      hBox.setSpacing(20);
      hBox.getChildren().addAll(t, tf);

      vboxAlfabetoa.getChildren().add(hBox);

    }
  }

  private void aldatuMezuArgian(char zer, char ordezkoa) {
    char[] mezuKaraktereak = mezuArgia.toCharArray();

    for (int i = 0; i < kripto.length(); i++) {
      if (kripto.charAt(i) == zer) {
        mezuKaraktereak[i] = ordezkoa;
      }
    }

    mezuArgia = String.valueOf(mezuKaraktereak);

  }
}
