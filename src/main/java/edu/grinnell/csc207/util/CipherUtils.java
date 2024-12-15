package edu.grinnell.csc207.util;

public class CipherUtils {
  private static int letter2int(char letter) {
    return ((int) (letter - 97));
  }

  private static char int2letter(int i) {
    return (char) (i + 97);
  }

  public static String caesarEncrypt(String str, char letter) {
    char[] arr = str.toCharArray();
    for(int n = 0; n < str.length(); n++)
    {
      char hold = int2letter ((letter2int(arr[n]) + letter2int(letter)) % 26);
      arr[n] = hold;
    }//for
    return new String(arr);
  }//caesarEncrypt

  public static String caesarDecrypt(String str, char letter) {
    char[] arr = str.toCharArray();
    for(int n = 0; n < str.length(); n++)
    {
      int a = (letter2int(arr[n]) - letter2int(letter));
      if (a < 0)
      {
        a += 26;
        a %= 26;
      }//if
      else
      {
        a %= 26;
      }
      arr[n] = int2letter(a);
    }//for
    return new String(arr);
  }//caesarDecrypt

  public static String vigenereEncrypt(String str, String key) {
    char[] arr = str.toCharArray();
    char[] arrkey = str.toCharArray();
    for(int n = 0; n < str.length(); n++)
    {
      char a = int2letter ((letter2int(arr[n]) + letter2int(arrkey[n])) % 26);
      arr[n] = a;
    }//for
    return new String(arr);
  }//vigenereEncrypt

  public static String vigenereDecrypt(String str, String key) {
    char[] arr = str.toCharArray();
    char[] arrkey = str.toCharArray();
    for(int n = 0; n < str.length(); n++)
    {
      char a = int2letter ((letter2int(arr[n]) - letter2int(arrkey[n])) % 26);
      arr[n] = a;
    }//for
    return new String(arr);
  }//vigenereDecrypt
  
  /*
   * Check if every char in an array is a lowercase, return true if it is, otherwise return false
   * @param char a
   */
  public static boolean isLowerCase(char[] arr)
  {
    for (char x : arr)
    {
      int val = (int) x;
      if (val < 97 || val > 122)
      {
        return false;
      }//if
    }//for
    return true;

  }//isLowerCase
}
