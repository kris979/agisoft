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
        return check(digitToFind, 0, arrayToSearch.length - 1, arrayToSearch);
    }

    private int check(int digitToFind, int beginIndex, int endIndex, int[] arrayToSearch) {
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
            return check(digitToFind, beginIndex, middleIndex, arrayToSearch);
        } else {
            return check(digitToFind, middleIndex+1, endIndex, arrayToSearch);
        }
    }

}
