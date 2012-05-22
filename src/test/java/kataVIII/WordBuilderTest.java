/* 
  * ============================================================================ 
  * Name      : WordBuilderTest.java
  * ============================================================================
  */
package kataVIII;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 *
 */
public class WordBuilderTest {
    
    private static final File dictionaryFile = new File("src/test/java/kataVIII/en-GB.dic");
    private static WordBuilder wb;
    
    @BeforeClass
    public static void setUp() throws IOException {
        wb = new WordBuilder(dictionaryFile);
    }
    
    @Test
    public void find6LetterWordsTest() {
        int wordsNumber = wb.getNumberOfWords();
        System.out.println("Valid words: " + wordsNumber);
    }
}
