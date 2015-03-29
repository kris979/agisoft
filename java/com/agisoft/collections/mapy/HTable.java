/* 
  * ============================================================================ 
  * Name      : HTable.java
  * Part of     :  NEON
  * 
  * Copyright (c) 2007-2011 Nokia.  All rights reserved.
  * This material, including documentation and any related computer
  * programs, is protected by copyright controlled by Nokia.  All
  * rights are reserved.  Copying, including reproducing, storing,
  * adapting or translating, any or all of this material requires the
  * prior written consent of Nokia.  This material also contains
  * confidential information which may not be disclosed to others
  * without the prior written consent of Nokia.
 * 
  * ============================================================================
  */
package com.agisoft.collections.mapy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

class HEntry {
    /**
     * @param key
     * @param value
     */
    public HEntry(String key, String value) {
        super();
        this.key = key;
        this.value = value;
    }
    String key;
    String value;
    /**
     * @return
     */
    public int getBucketNumber() {
        int bucket = ((127 * hashCode() + 13) % 16908799) % HTable.N;
        return bucket;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "[key=" + key + ", value=" + value + ", hashCode=" + hashCode() + ", bucket=" + getBucketNumber() + "]";
    }
}


/**
 * 
 *
 */
public class HTable {
    
    public static int LETTERS = 26;
    public static int N = 20;  //max number of buckets(N-1)
    public static int n = 26*26;  //max number of keys (in this case two-letter words)
    private List<LinkedList<HEntry>> dtable;
    
    public HTable() {
        dtable = new ArrayList<LinkedList<HEntry>>(N);
        for (int i = 0; i < N; i++) {
            LinkedList<HEntry> chain = new LinkedList<HEntry>();
            dtable.add(chain);
        }
    }
    
    public HEntry add(String key, String value) {
        HEntry entry = new HEntry(key, value);
        int bucket = entry.getBucketNumber();
        assert(entry.getBucketNumber()==bucket);
        System.out.println(entry);
        LinkedList<HEntry> chain = dtable.get(bucket);
        chain.addLast(entry);
        return entry;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("HTable [");
        int buckets = dtable.size();
        s.append("buckets: " + buckets + "\n"); 
        for (LinkedList<HEntry> chain : dtable) {
            s.append("[");
            s.append("size: " + chain.size() + " ");
            for (HEntry hEntry : chain) {
                s.append(hEntry.toString() + " ");
            }
            s.append("]\n");
        }
        s.append("]");
        return s.toString();
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        Random random = new Random();
        HTable ht = new HTable();
        for (int i = 0; i < 10; i++) {
            ht.add(String.valueOf((char)(random.nextInt(57)+65)) + String.valueOf((char)(random.nextInt(57)+65)), "-");
        }
        System.out.println(ht);
    }
}
