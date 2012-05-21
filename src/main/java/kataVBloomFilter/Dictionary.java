/* 
 * ============================================================================ 
 * Name      : Dictionary.java
 * ============================================================================
 */
package kataVBloomFilter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.BitSet;

/**
 * 
 *
 */
public class Dictionary {

    /**
     * 
     */
    private static final int numberOfHashes = 2;
    private static final int[] primes = {1046527, 16769023}; 
    private static final int nbits = (int) (Math.pow(2, 30)-1);
    private BitSet bits = new BitSet(nbits);
    private MessageDigest md5;

    /**
     * @param dictionaryFile
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    public Dictionary(File dictionaryFile) throws IOException, NoSuchAlgorithmException {
        md5 = MessageDigest.getInstance("MD5");
        int wordsNumber = parse(dictionaryFile);
        System.out.println("number of words: " + wordsNumber + ",hashes per word: " + numberOfHashes);
        System.out.println("bits set:" + bits.cardinality() +"/" + nbits + " filled in " + bits.cardinality()*100/nbits + "%");
    }

    /**
     * @return
     * @throws NoSuchAlgorithmException 
     */
    public Boolean has(String word) throws NoSuchAlgorithmException {
        int[] hashes = calculateHashes(word);
        for (int i = 0; i < hashes.length; i++) {
            boolean isThere = bits.get(hashes[i]);
            if ( ! isThere) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param dictionaryFile
     * @return 
     * @throws FileNotFoundException
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    private int parse(File dictionaryFile) throws FileNotFoundException, IOException, NoSuchAlgorithmException {
        Reader in = new FileReader(dictionaryFile);
        BufferedReader reader = new BufferedReader(in);
        String line = null;
        int lineCount = 0;
        while ((line = reader.readLine()) != null) {
            lineCount++;
            int[] hashes = calculateHashes(line);
            for (int i = 0; i < hashes.length; i++) {
                bits.set(hashes[i]);
            }
            System.out.println(line + "=" + Arrays.toString(hashes));
        }
        return lineCount;
    }

    /**
     * @param line
     * @return
     * @throws NoSuchAlgorithmException
     */
    public int[] calculateHashes(String line) throws NoSuchAlgorithmException {
        int[] hashes = new int[numberOfHashes];
        for (int i = 0; i < numberOfHashes; i++) {
            hashes[i] = hash(line,primes[i]);
        }
        return hashes;
//        int[] hashes = new int[numberOfHashes];
//        byte[] digest = calculateHash(line);
//        String str = Arrays.toString(digest);
//        int len = str.length()/numberOfHashes;
//        int start = 0;
//        for (int i = 0; i < hashes.length; i++) {
//            BigInteger hash = new BigInteger(str.substring(start,start+len-1).getBytes());
//            hashes[i] = Math.abs(hash.intValue()); 
//            start+=len;
//        }
//        return hashes;
    }

    /**
     * @param line
     * @return
     */
    public byte[] calculateHash(String line) {
        md5.reset();
        return md5.digest(line.getBytes());
    }

    /**
     * @param line
     * @return
     */
    public int hash(String line, int prime) {
        int result = 1;
        result = prime * result + line.hashCode();
        return Math.abs(result) % prime;
    }

}
