package ehu.isad;

public class Bilduma {

  private String izena;
  private Integer id;

  public Bilduma(String izena, Integer id) {
    this.izena = izena;
    this.id = id;
  }

  public String getIzena() {
    return izena;
  }

  public Integer getId() {
    return id;
  }

  public Bilduma(String izena) {
    this.izena = izena;
  }

  @Override
  public String toString() {
    return "Bilduma{" +
        "izena='" + izena + '\'' +
        ", id=" + id +
        '}';
  }

  public static void main(String[] args) {

  }
}
