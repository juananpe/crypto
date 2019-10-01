package ehu.isad;

import com.google.common.primitives.Chars;

public class Cesar {

  private char[] alfabetoa = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
  private int a_ascii = (int) 'A';

  public Cesar() {
  }

  public String zifratu(String mezua, int offset) {

    String emaitza = "";
    mezua = mezua.toUpperCase();

    for (int i = 0; i < mezua.length(); i++) {
      char karakterea = mezua.charAt(i);
      if (!alfabetoan(karakterea)) {
        emaitza += karakterea;
      } else {
        int pos = ((int) karakterea) - a_ascii + offset;
        emaitza += alfabetoa[ pos % 26];
      }
    }

    return emaitza;
  }

  private boolean alfabetoan(char karakterea) {
    return Chars.contains(alfabetoa, karakterea);
  }

  public void brute(String kripto) {

    for (int delta = 0; delta < alfabetoa.length; delta++) {
      System.out.print(delta + ":");
      for (int i = 0; i < kripto.length(); i++) {
        int ascii = (int) kripto.charAt(i);
        Character text = ' ';
        if (' ' != kripto.charAt(i)) {
          // mod, including negatives. See: https://stackoverflow.com/a/31140209/243532
          text = alfabetoa[Math.floorMod(ascii - a_ascii - delta, 26)];
        }
        System.out.print(text);
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {

    // String kripto = "KNXMNSL KWJXMBFYJW GJSIX FSI XFQYBFYJW HTFXYX WJBFWIX FSDTSJ KJJQNSL XYWJXXJI. WJXTZWHJKZQ FSLQJWX ZXZFQQD KNSI RFXYJWKZQ QJFUJWX KZS FSI FIRNY XBTWIKNXM WFSP TAJWBMJQRNSL FSDIFD.";
    // new Cesar().brute(kripto);

    String mezua = "The Data Encryption Standard is a symmetric-key algorithm for the encryption of electronic data. Although its short key length of 56 bits, criticized from the beginning, makes it too insecure for most current applications, it was highly influential in the advancement of modern cryptography.\n" +
        "Developed in the early 1970s at IBM and based on an earlier design by Horst Feistel, the algorithm was submitted to the National Bureau of Standards (NBS) following the agency's invitation to propose a candidate for the protection of sensitive, unclassified electronic government data. In 1976, after consultation with the National Security Agency (NSA), the NBS eventually selected a slightly modified version (strengthened against differential cryptanalysis, but weakened against brute-force attacks), which was published as an official Federal Information Processing Standard (FIPS) for the United States in 1977.\n" +
        "The publication of an NSA-approved encryption standard simultaneously resulted in its quick international adoption and widespread academic scrutiny. Controversies arose out of classified design elements, a relatively short key length of the symmetric-key block cipher design, and the involvement of the NSA, nourishing suspicions about a backdoor. Today it is known that the S-boxes that had raised those suspicions were in fact designed by the NSA to actually remove a backdoor they secretly knew (differential cryptanalysis). However, the NSA also ensured that the key size was drastically reduced such that they could break it by brute force attack (the computing power to brute force DES however did not exist in 1975).[2] The intense academic scrutiny the algorithm received over time led to the modern understanding of block ciphers and their cryptanalysis.\n" +
        "DES, as stated above, is insecure. This is mainly due to the 56-bit key size being too small. In January 1999, distributed.net and the Electronic Frontier Foundation collaborated to publicly break a DES key in 22 hours and 15 minutes (see chronology). There are also some analytical results which demonstrate theoretical weaknesses in the cipher, although they are infeasible to mount in practice. The algorithm is believed to be practically secure in the form of Triple DES, although there are theoretical attacks. This cipher has been superseded by the Advanced Encryption Standard (AES). Furthermore, DES has been withdrawn as a standard by the National Institute of Standards and Technology.\n" +
        "Some documentation makes a distinction between DES  as a standard and as an algorithm, referring to the algorithm as the DEA (Data Encryption Algorithm).";

    System.out.println(new Cesar().zifratu(mezua, 3));
  }
}
