/* 
 * ============================================================================ 
 * Name      : WordBuilder2.java
 * ============================================================================
 */
package kata.kataVIII;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 
 *
 */
public class WordBuilder2 {

    private File dictionary;
    private Set<String> referenceWords = new LinkedHashSet<String>();
    private Set<String> wordsWith5Letters = new LinkedHashSet<String>();
    private Set<String> wordsWith4Letters = new LinkedHashSet<String>();
    private Set<String> wordsWith3Letters = new LinkedHashSet<String>();
    private Set<String> wordsWith2Letters = new LinkedHashSet<String>();
    private Set<String> wordsWith1Letters = new LinkedHashSet<String>();
    private Set<String> validWords = new LinkedHashSet<String>();

    /**
     * @param dictionary
     * @throws IOException
     * @throws FileNotFoundException
     */
    public WordBuilder2(File dictionary) throws FileNotFoundException, IOException {
        super();
        long start = System.currentTimeMillis();
        this.dictionary = dictionary;
        parseDictionaryIntoSets();
        generateValidWords();
        long end = System.currentTimeMillis();
        System.out.println( getClass().getSimpleName() + " whole took " + (end-start) + "ms");
    }

    private void parseDictionaryIntoSets() throws FileNotFoundException, IOException {
        Reader in = new FileReader(dictionary);
        BufferedReader reader = new BufferedReader(in);
        String line = null;
        while ((line = reader.readLine()) != null) {
            if (line.length() == 6) {
                getReferenceWords().add(line);
            } else if (line.length() == 5) {
                wordsWith5Letters.add(line);
            } else if (line.length() == 4) {
                wordsWith4Letters.add(line);
            } else if (line.length() == 3) {
                wordsWith3Letters.add(line);
            } else if (line.length() == 2) {
                wordsWith2Letters.add(line);
            } else if (line.length() == 1) {
                wordsWith1Letters.add(line);
            }
        }
    }

    private void generateValidWords() {
        long start = System.currentTimeMillis();
        generateValidWordsForOneSet(wordsWith1Letters, wordsWith5Letters);
        generateValidWordsForOneSet(wordsWith5Letters, wordsWith1Letters);
        generateValidWordsForOneSet(wordsWith2Letters, wordsWith4Letters);
        generateValidWordsForOneSet(wordsWith4Letters, wordsWith2Letters);
        generateValidWordsForOneSet(wordsWith3Letters, wordsWith3Letters);
        long end = System.currentTimeMillis();
        System.out.println( getClass().getSimpleName() + " took " + (end-start) + "ms");
    }

    /**
     * @param set1
     * @param set2
     */
    private void generateValidWordsForOneSet(Set<String> set1, Set<String> set2) {
        for (String prefix : set1) {
            for (String suffix : set2) {
                final String newWord = prefix + suffix;
                if (getReferenceWords().contains(newWord)) {
                    // System.out.println(prefix + "-" + suffix);
                    validWords.add(newWord);
                }
            }
        }
    }

    /**
     * @return
     */
    public int getNumberOfWords() {
        return validWords.size();
    }

    /**
     * @return
     */
    public Set<String> getWords() {
        return validWords;
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
