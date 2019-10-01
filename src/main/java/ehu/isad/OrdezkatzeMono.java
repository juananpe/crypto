package ehu.isad;

import java.util.Arrays;

public class OrdezkatzeMono {

  private String gako;
  private final int a_ascii = (int) 'A';

  public OrdezkatzeMono(String gako) {
    this.gako = gako;
  }

  public String zifratu(String text){

    String kripto = "";

    for (int i=0; i<text.length(); i++) {
      if (text.charAt(i) == ' ') {
        kripto += " ";
        continue;
      }
      int ascii = (int) text.charAt(i);
      int pos = ascii - a_ascii;
      kripto += gako.charAt(pos);
    }

    return kripto;
  }

  public static void main(String[] args) {
    OrdezkatzeMono om = new OrdezkatzeMono("ZXCVBNMASDFGHJKLQWERTYUIOP");
    System.out.println(om.zifratu("EZ GAUDE GERRAREN ALDE"));
    System.out.println(om.deszifratu("BP MZTVB MBWWZWBJ ZGVB"));
  }

  public String deszifratu(String kripto) {
    String testua = "";
    for (int i = 0; i< kripto.length(); i++) {
      Character k_i = kripto.charAt(i);
      if (k_i == ' '){
        testua += " ";
        continue;
      }
      int pos = bilatu(gako, k_i);
      testua += (char)(a_ascii + pos);
    }

    return testua;
  }

  private int bilatu(String gako, Character k_i) {
    for (int i = 0; i < gako.length(); i++) {
      if (gako.charAt(i)==k_i) {
        return i;
      }
    }
    return -1;
  }
}
