package edu.grinnell.csc207.util;

/** CipherUtils methods. */
public class CipherUtils {

  /** The number of lowercase letters. */
  private static final int NUM_LETTERS = 26;

  /** The int value of 'a'. */
  private static final int INT_OF_A = 97;

  /**
   * Convert letter to int.
   *
   * @param letter
   * @return a converted int value of the letter.
   */
  private static int letter2int(char letter) {
    return ((int) (letter - INT_OF_A));
  } // letter2int (char)

  /**
   * Convert int to letter.
   *
   * @param i
   * @return a converted int value of the letter.
   */
  private static char int2letter(int i) {
    return (char) (i + INT_OF_A);
  } // int2letter(int)

  /**
   * Encrypt a string using Caesar encryption.
   *
   * @param str
   * @param letter
   * @return a string after caesar encryption.
   */
  public static String caesarEncrypt(String str, char letter) {
    char[] arr = str.toCharArray();
    for (int n = 0; n < str.length(); n++) {
      char hold = int2letter((letter2int(arr[n]) + letter2int(letter)) % NUM_LETTERS);
      arr[n] = hold;
    } // for
    return new String(arr);
  } // caesarEncrypt

  /**
   * Decrypt a string using Caesar encryption.
   *
   * @param str
   * @param letter
   * @return a string after caesar decryption.
   */
  public static String caesarDecrypt(String str, char letter) {
    char[] arr = str.toCharArray();
    for (int n = 0; n < str.length(); n++) {
      int result = (letter2int(arr[n]) - letter2int(letter));
      if (result < 0) {
        result += NUM_LETTERS;
        result %= NUM_LETTERS;
      } else {
        result %= NUM_LETTERS;
      } // if-else
      arr[n] = int2letter(result);
    } // for
    return new String(arr);
  } // caesarDecrypt

  /**
   * Encrypt a string with a vigenere style.
   *
   * @param str
   * @param key
   * @return a encoded string of str.
   */
  public static String vigenereEncrypt(String str, String key) {
    char[] arr = str.toCharArray();
    char[] arrkey = key.toCharArray();
    for (int n = 0; n < str.length(); n++) {
      arr[n] =
          int2letter((letter2int(arr[n]) + letter2int(arrkey[n % arrkey.length])) % NUM_LETTERS);
    } // for
    return new String(arr);
  } // vigenereEncrypt

  /**
   * Decrypt a string with a vigenere style.
   *
   * @param str
   * @param key
   * @return a decoded string of str.
   */
  public static String vigenereDecrypt(String str, String key) {
    char[] arr = str.toCharArray();
    char[] arrkey = key.toCharArray();
    for (int n = 0; n < str.length(); n++) {
      int index = letter2int(arr[n]) - letter2int(arrkey[n % arrkey.length]);
      if (index < 0) {
        index += NUM_LETTERS;
      } // if
      arr[n] = int2letter(index);
    } // for
    return new String(arr);
  } // vigenereDecrypt

  /**
   * Check if every char in an array is a lowercase, return true if it is, otherwise return false.
   *
   * @param arr
   * @return a boolean, true if it is all lower cases, otherwise return false.
   */
  public static boolean isLowerCase(char[] arr) {
    for (char x : arr) {
      if (!Character.isLowerCase(x)) {
        return false;
      } // if
    } // for
    return true;
  } // isLowerCase
} // CipherUtils Class
