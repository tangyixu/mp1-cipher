package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.CipherUtils;

public class Cipher {
  public static void main(String[] args) {

    PrintWriter pen = new PrintWriter(System.out, true);
    Boolean isEncode = false;
    Boolean isDecode = false;
    Boolean isCaesar = false;
    Boolean isVigenere = false;
    String str = "";
    String key = "";
    boolean strStored = false;
    String result = "";

    if(args.length != 4) {
      System.err.println("Error: Expected four parameters, received " + args.length);
      return;
    } //if
    for(int n = 0; n < args.length; n++) {
      String arg = args[n];

      if(arg.equals("-encode")) {
        isEncode = true;
      } //if
      else if(arg.equals("-decode")) {
        isDecode = true;
      } //if
      else if (arg.equals("-caesar")) {
        isCaesar = true;
      } //else-if
      else if (arg.equals("-vigenere")) {
        isVigenere = true;
      } //else-if
      else if (!CipherUtils.isLowerCase(arg.toCharArray())) {
        System.err.println("Error: strings must be only lowercase letters");
        return;
      } //else-if
      else if(!strStored) {
        str += arg;
        strStored = true;
      } //else-if
      else {
        key += arg;
      } //else
    } //for

    if(isCaesar&&key.length()!=1) {
      System.err.println("Error: Caesar ciphers require a one-character key");
      return;
    } //if
    if (!isCaesar&&!isVigenere) {
      System.err.println("Error: No valid action specified."
                         + "Legal values are '-encode' and '-decode'");
      return;
    } //if
    if (key.equals("")) {
      System.err.println("Error: Empty keys are not permitted");
      return;
    } //if

    if(isCaesar) {
      if(isEncode) {
        result += CipherUtils.caesarEncrypt(str,key.charAt(0));
      } else {
        result += CipherUtils.caesarDecrypt(str,key.charAt(0));
      } //if-else
    } //if

    if(isVigenere) {
      if(isEncode) {
        result += CipherUtils.vigenereEncrypt(str,key);
      } else {
        result += CipherUtils.vigenereDecrypt(str,key);
      } //if-else
    } //if
    pen.println(result);
    pen.close();
  } //main 
} //Cipher class

