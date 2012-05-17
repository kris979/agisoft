/* 
  * ============================================================================ 
  * Name      : RomanNumberII.java
  * ============================================================================
  */
package roman;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 *
 */
public class RomanNumberII {
    
    private static final Map<Character,Integer> numbers;
    
    static {
        numbers = new HashMap<Character, Integer>(3);
        numbers.put('I', 1);
        numbers.put('V', 5);
        numbers.put('X', 10);
    }

    /**
     * @param string
     * @return
     */
    public int convert(String string) {
        int decimalNumber = 0;
        char[] romanNumber = convertStringToListOfCharacters(string);
        for (int i = romanNumber.length-1; i >= 0; i--) {
            decimalNumber += convertSingleCharacter(romanNumber, i);
        }
        return decimalNumber;
    }

    /**
     * @param decimalNumber
     * @param number
     * @param i
     * @return
     */
    private int convertSingleCharacter(char[] number, int i) {
        Integer digit = numbers.get(number[i]);
        if (withingArrayBoundries(number, i) && currentDigitIsSmallerThanPrevious(number, i)) {
            return -digit;
        } else {
            return digit;
        }
    }

    /**
     * @param number
     * @param i
     * @return
     */
    private boolean currentDigitIsSmallerThanPrevious(char[] number, int i) {
        if (number[i] < number[i+1]) {
            if (number[i] != 'I') {
                throw new IllegalArgumentException(number[i] + " can't preceed " + number[i+1]);
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param number
     * @param i
     * @return
     */
    private boolean withingArrayBoundries(char[] number, int i) {
        return i+1 <= number.length-1;
    }

    /**
     * @param string
     */
    private char[] convertStringToListOfCharacters(String string) {
        return string.toCharArray();
    }

}
