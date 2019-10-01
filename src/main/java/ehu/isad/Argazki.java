package ehu.isad;

public class Argazki {


  private String izena;
  private Integer id;
  private String fitx;

  public Integer getId() {
    return id;
  }

  public String getFitx(){return fitx;}
  public String getIzena() {
    return izena;
  }

  private static Integer autoinc = 0;

  public Argazki(String izena, Integer id) {
    this.izena = izena;
    this.id = id;
  }

  public Argazki(String izena, String fitx) {
    this.izena = izena;
    this.fitx = fitx;
    this.id = autoinc++;
  }

  @Override
  public String toString() {
    return this.izena;
  }
}
