/* 
 * ============================================================================ 
 * Name      : BinaryChop.java
 * ============================================================================
 */
package binarychop;


/**
 * 
 *
 */
public class BinaryChop {

    public int chop(int digitToFind, int[] arrayToSearch) {
        if (arrayToSearch.length == 0) {
            return -1;
        }
        return recursive(digitToFind, 0, arrayToSearch.length - 1, arrayToSearch);
    }

    private int recursive(int digitToFind, int beginIndex, int endIndex, int[] arrayToSearch) {
        if (endIndex - beginIndex == 0) {
            if (arrayToSearch[beginIndex] == digitToFind) {
                return beginIndex;
            } else {
                return -1;
            }
        }
        int middleIndex = beginIndex + (endIndex - beginIndex) / 2;
        if (digitToFind == arrayToSearch[middleIndex]) {
            return middleIndex;
        } else if (digitToFind <= arrayToSearch[middleIndex]) {
            return recursive(digitToFind, beginIndex, middleIndex, arrayToSearch);
        } else {
            return recursive(digitToFind, middleIndex+1, endIndex, arrayToSearch);
        }
    }

    
    
    
    public int iterativeChop(int digitToFind, int[] arrayToSearch) {
        int position = -1;
        if (arrayToSearch.length == 0) {
            return -1;
        }
        int beginIndex = 0;
        int endIndex = arrayToSearch.length - 1;
        
        while (endIndex - beginIndex > 0) {
            int middleIndex = beginIndex + (endIndex - beginIndex) / 2;
            if (digitToFind == arrayToSearch[middleIndex]) {
                return middleIndex;
            } else if (digitToFind <= arrayToSearch[middleIndex]) {
                    endIndex = middleIndex;
            } else {
                    beginIndex = middleIndex+1;
            }
        } 
        if (endIndex - beginIndex == 0) {
            if (arrayToSearch[beginIndex] == digitToFind) {
                return beginIndex;
            } else {
                return -1;
            }
        }
        return position;
    }
    
    private int iterative(int digitToFind, int beginIndex, int endIndex, int[] arrayToSearch) {
        return endIndex;
        
    }
}
