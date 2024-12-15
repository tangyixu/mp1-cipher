package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.CipherUtils;

public class AllCaesar {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    // String str = "helloworld";
    // for (char ch = 'a'; ch <= 'z'; ch++) {
    //   pen.printf("n = %c: %s\n", ch, CipherUtils.caesarEncrypt(str, ch));
    // }//for

    if(args.length != 2)
    {
      System.err.println("Error: Incorrect number of parameters.");
    }//if
    else
    {
      if(!CipherUtils.isLowerCase(args[1].toCharArray()))
      {
       System.err.println("Error: String contains characters other than lowercase letters.");
      }
      else
      {
        if (args[0].equals("encode"))
        {
          for (char ch = 'a'; ch <= 'z'; ch++) 
          {

            pen.printf("n = %c: %s\n", ch, CipherUtils.caesarEncrypt(args[1],ch));

          }//for
        }//if
        else if (args[0].equals("decode"))
        {  
          for (char ch = 'a'; ch <= 'z'; ch++) 
          {
            
            pen.printf("n = %c: %s\n", ch, CipherUtils.caesarDecrypt(args[1],ch));

          }//for
        }//else-if
        else
        {
          System.err.println("Error: Invalid option:" + args[0] + "Valid options are \"encode\" or \"decode\".\n");
        }//else
      }//else
    }
    pen.close();
  }
}
