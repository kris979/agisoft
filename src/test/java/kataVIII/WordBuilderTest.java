/* 
  * ============================================================================ 
  * Name      : WordBuilderTest.java
  * ============================================================================
  */
package kataVIII;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 *
 */
public class WordBuilderTest {
    
    private static final File dictionaryFile = new File("src/test/java/kataVIII/en-GB.dic");
    private static WordBuilder wb;
    private static WordBuilder2 wb2;
    
    @BeforeClass
    public static void setUp() throws IOException {
        wb = new WordBuilder(dictionaryFile);
        wb2 = new WordBuilder2(dictionaryFile);
    }
    
    @Test
    public void find6LetterWordsUsingWordBuilderTest() {
        int number1 = wb.getNumberOfWords();
        int number2 = wb2.getNumberOfWords();
        System.out.println(wb.getClass().getSimpleName() + " generated: " + number1 + " words");
        System.out.println(wb2.getClass().getSimpleName() + " generated: " + number2 + " words");
        assertEquals(wb.getWords(), wb2.getWords());
        System.out.println(wb.getReferenceWords().size());
    }
}
