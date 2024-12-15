package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.CipherUtils;

/** All Caesar types of encryption or decryptions. */
public class AllCaesar {
  /**
   * The main method for processing encryption or decryption commands.
   *
   * @param args
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    if (args.length != 2) {
      System.err.println("Error: Incorrect number of parameters.");
      return;
    } else {
      if (!CipherUtils.isLowerCase(args[1].toCharArray())) {
        System.err.println("Error: String contains characters other than lowercase letters.");
        return;
      } else {
        if (args[0].equals("encode")) {
          for (char ch = 'a'; ch <= 'z'; ch++) {
            pen.printf("n = %c: %s\n", ch, CipherUtils.caesarEncrypt(args[1], ch));
          } // for
        } else if (args[0].equals("decode")) {
          for (char ch = 'a'; ch <= 'z'; ch++) {
            pen.printf("n = %c: %s\n", ch, CipherUtils.caesarDecrypt(args[1], ch));
          } // for
        } else {
          System.err.println(
              "Error: Invalid option:" + args[0] + "Valid options are \"encode\" or \"decode\".\n");
          return;
        } // if-else
      } // if-else
    } // if-else
    pen.close();
  } // main
} // AllCaesar Class
