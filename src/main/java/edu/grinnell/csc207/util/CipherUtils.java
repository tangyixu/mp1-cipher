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

  /**
   * Encrypt a string with a vigenere style.
   * @param str
   * @param key
   * @return a encoded string of str.
   */
  public static String vigenereEncrypt(String str, String key) {
    char[] arr = str.toCharArray();
    char[] arrkey = key.toCharArray();
    for(int n = 0; n < str.length(); n++) {
      arr[n] = int2letter ((letter2int(arr[n]) 
                           + letter2int(arrkey[n % arrkey.length])) % 26);
    } //for
    return new String(arr);
  } //vigenereEncrypt

  /**
   * Decrypt a string with a vigenere style.
   * @param str
   * @param key
   * @return a decoded string of str.
   */
  public static String vigenereDecrypt(String str, String key) {
    char[] arr = str.toCharArray();
    char[] arrkey = key.toCharArray();
    for(int n = 0; n < str.length(); n++) {
      int index = letter2int(arr[n])
                  - letter2int(arrkey[n % arrkey.length]);
      if(index < 0) {
        index += 26;
      } //if
      arr[n] = int2letter (index);
    } //for
    return new String(arr);
  } //vigenereDecrypt
  
  /*
   * Check if every char in an array is a lowercase, return true if it is, otherwise return false
   * @param char a
   */
  public static boolean isLowerCase(char[] arr)
  {
    for (char x : arr) {
      if (!Character.isLowerCase(x))
      {
        return false;
      }//if
    }//for
    return true;
  }//isLowerCase
}
