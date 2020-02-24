/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connexion;

import java.util.Arrays;

/**
 *
 * @author HP
 */
class JavaUtil {
  public static byte[] truncateArray(byte[] array, int maxSize) {
 
    int newArraySize = Math.min(array.length, maxSize);
    byte[] newArray = new byte[newArraySize];
    System.arraycopy(array, 0, newArray, 0, maxSize);
 
    return newArray;
}
 
/**
 * Merge les deux tableaux en arguments.
 * 
 * @param first Premier tableau
 * @param second Second tableau
 * @return
 */
public static byte[] mergeArray(byte[] first, byte[] second) {
 
    byte[] result = Arrays.copyOf(first, first.length + second.length);
    System.arraycopy(second, 0, result, first.length, second.length);
 
    return result;
}  
}
