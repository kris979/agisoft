/* 
  * ============================================================================ 
  * Name      : BinaryChop.java
  * ============================================================================
  */
package binarychop;

import java.util.Arrays;

/**
 * 
 *
 */
public class BinaryChop {
    
    public int chop(int digitToFind, int[] arrayToSearch) {
        if (arrayToSearch.length == 0) {
            return -1;
        }
        if (arrayToSearch.length == 1) {
            if (arrayToSearch[0] == digitToFind) {
                return 0;
            } else {
                return -1;
            }
        }
        
        int middleIndex = arrayToSearch.length/2;
        
        if (digitToFind == arrayToSearch[middleIndex]) {
            return middleIndex;
        } else if (digitToFind < arrayToSearch[middleIndex]) {
            return chop(digitToFind, Arrays.copyOfRange(arrayToSearch, 0, middleIndex));
        } else {
            return middleIndex + chop(digitToFind, Arrays.copyOfRange(arrayToSearch, middleIndex, arrayToSearch.length));
        }
    }

}
