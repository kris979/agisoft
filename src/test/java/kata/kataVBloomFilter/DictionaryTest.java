/* 
  * ============================================================================ 
  * Name      : BloomFilterTest.java
  * ============================================================================
  */
package kata.kataVBloomFilter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.junit.BeforeClass;
import org.junit.Test;


/**
 * 
 *
 */
public class DictionaryTest {
    
    private static final File dictionaryFile = new File("src/test/java/kata.kataVBloomFilter/en-GB.dic");
//    private static final File dictionaryFile = new File("src/test/java/kata.kataVBloomFilter/small.txt");
    private static Dictionary dict;
    
    
    @BeforeClass
    public static void setUp() throws NoSuchAlgorithmException, IOException {
        dict = new Dictionary(dictionaryFile);
    }
    
    
    @Test
    public void isAmazonInDictionary() throws NoSuchAlgorithmException {
        assertThat(dict.has("ambers"), is(true));
    }

    @Test
    public void isHeartInDictionary() throws NoSuchAlgorithmException {
        assertThat(dict.has("heart"), is(true));
    }

    @Test
    public void isKrzysztofInDictionary() throws NoSuchAlgorithmException {
        assertThat(dict.has("krzysztof"), is(false));
    }
    
}
