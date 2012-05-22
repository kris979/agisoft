/* 
  * ============================================================================ 
  * Name      : WordBuilder.java
  * ============================================================================
  */
package kataVIII;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Timer;

/**
 * 
 *
 */
public class WordBuilder {
    
    private File dictionary;
    private Set<String> referenceWords = new LinkedHashSet<String>();
    private Set<String> wordsWithLessThan6Letters = new LinkedHashSet<String>();
    private Set<String> validWords = new LinkedHashSet<String>();
    

    /**
     * @param dictionaryfile
     * @throws IOException 
     */
    public WordBuilder(File dictionaryfile) throws IOException {
        super();
        long start = System.currentTimeMillis();
        dictionary = dictionaryfile;
        parseDictionaryIntoSets();
        generateValidWords();
        long end = System.currentTimeMillis();
        System.out.println( getClass().getSimpleName() + " whole took " + (end-start) + "ms");
    }

    /**
     * @throws FileNotFoundException
     * @throws IOException
     */
    private void parseDictionaryIntoSets() throws FileNotFoundException, IOException {
        Reader in = new FileReader(dictionary);
        BufferedReader reader = new BufferedReader(in );
        String line = null;
        while ((line = reader.readLine()) != null) {
            if (line.length() == 6) {
                getReferenceWords().add(line);
            } else if (line.length() < 6) {
                wordsWithLessThan6Letters.add(line);
            }
        }
    }
    
    /**
     * 
     */
    private void generateValidWords() {
        long start = System.currentTimeMillis();
        for (String prefix : wordsWithLessThan6Letters) {
            int prefixLength = prefix.length();
            for (String suffix : wordsWithLessThan6Letters) {
                int suffixLength = suffix.length();
                if (prefixLength + suffixLength <= 6) {
                    final String newWord = prefix+suffix;
                    if (getReferenceWords().contains(newWord)) {
//                        System.out.println(prefix + "-" + suffix);
                        validWords.add(newWord);
                    }
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println( getClass().getSimpleName() + " took " + (end-start) + "ms");
    }
    
    /**
     * @return
     */
    public Set<String> getWords() {
        return validWords;
    }

    /**
     * @return
     */
    public int getNumberOfWords() {
        return validWords.size();
    }

    /**
     * @param referenceWords the referenceWords to set
     */
    public void setReferenceWords(Set<String> referenceWords) {
        this.referenceWords = referenceWords;
    }

    /**
     * @return the referenceWords
     */
    public Set<String> getReferenceWords() {
        return referenceWords;
    }

}
