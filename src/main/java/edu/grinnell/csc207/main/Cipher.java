package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.CipherUtils;

public class Cipher {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    for (int i = 0; i < args.length; i++) {
      pen.printf("args[%d] = \"%s\"\n", i, args[i]);
    }
    String instruction = "";
    String ciphertype = "";
    String message = "";
    String key = "";

    if(args.length != 4)
    {
      System.err.println("Error: Expected four parameters, received " + args.length);
    }//if
    else
    { for(String x : args)
      {
        if(x.equals("-encode"))
        {
          instruction = "encode";
        }
        else if(x.equals("-decode"))
        {
          instruction = "decode";
        }
    pen.close();
      } 
    }
  }
}

