/* 
  * ============================================================================ 
  * Name      : BinaryHeap.java
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
package com.agisoft.collections.queue;

import java.util.Arrays;

/**
 * 
 *
 */
public class BinaryHeap {
    
    int[] heap;

    /**
     * @param heap
     */
    public BinaryHeap(int[] heap) {
        super();
        this.heap = heap;
    }
    
    public void create() {
//        int lastInternalNodeIndex = lastInternalNodeIndex();
//        for (int i = lastInternalNodeIndex; i >= 0; i--) {
//            Integer leftChildIdx = getLeftChildIdx(lastInternalNodeIndex);
//            Integer rightChildIdx = getRightChildIdx(lastInternalNodeIndex);
//            swapParentWithMininumChild(i, leftChildIdx, rightChildIdx);
//            print();
//        }
    }
    
    private void swapParentWithMininumChild(int parentIdx, int leftChildIdx, int rightChildIdx) {
        if (heap[parentIdx] < heap[leftChildIdx]&& heap[parentIdx] < heap[rightChildIdx]) {
            return;
        }
        if (heap[leftChildIdx] < heap[rightChildIdx]) {
            int tmp = heap[leftChildIdx];
            heap[leftChildIdx] = heap[parentIdx];
            heap[parentIdx] = tmp;
        } else {
            int tmp = heap[rightChildIdx];
            heap[rightChildIdx] = heap[parentIdx];
            heap[parentIdx] = tmp;
        }
    }
    
    public int lastInternalNodeIndex() {
        for (int i = heap.length; i > 0; i--) {
            if (2*i < heap.length && (2*i)+1 < heap.length) {
                return i;
            }
        }
        return 0;
    }

    private Integer getLeftChildIdx(int parentIndex) {
        if (2*parentIndex < heap.length) {
            return 2*parentIndex;
        } else {
            return null;
        }
    }
    
    private Integer getRightChildIdx(int parentIndex) {
        if ((2*parentIndex)+1 < heap.length) {
            return (2*parentIndex)+1;
        } else {
            return null;
        }
    }
    
    public void print() {
        System.out.println(Arrays.toString(heap));
//        for (int i = 1; i < heap.length; i++) {
//            System.out.println(heap[i]);
//            System.out.println(childrenRow(i));
//        }
    }

    /**
     * @param i
     */
    private String childrenRow(int i) {
        String leftChild = "";
        String rightChild = "";
        if (2*i < heap.length) {
            leftChild = Integer.toString(heap[2*i]);
        }
        if ((2*i)+1 < heap.length) {
            rightChild = " , " + Integer.toString(heap[(2*i)+1]);
        }
        String row = leftChild + rightChild;
        return row;
    }
    

    /**
     * @param args
     */
    public static void main(String[] args) {
//        int[] arr = {0,2,4,2,9,8,7,6};
        int[] arr = {0,2,5,3,9,6,11,4,17,10,8};
        BinaryHeap bh = new BinaryHeap(arr);
        bh.create();
        System.out.println(Arrays.toString(bh.heap));
        bh.insert(2);
        System.out.println(Arrays.toString(bh.heap));
    }

    /**
     * @param i
     */
    public void insert(int i) {
        int[] newHeap = new int[heap.length + 1];
        int j = 0;
        for (j = 0; j < heap.length; j++) {
            newHeap[j] = heap[j];
        }
        newHeap[heap.length] = i;
        heap = newHeap;
        
        int idxOfNewValue = heap.length;
        while (idxOfNewValue > 0) {
            int parentIdx = getParentIdx(idxOfNewValue);
            if (heap[idxOfNewValue] < heap[parentIdx]) {
                int tmp = heap[parentIdx];
                heap[parentIdx] = heap[idxOfNewValue];
                heap[idxOfNewValue] = tmp;
                idxOfNewValue = parentIdx;
            }
        }
    }

    /**
     * @param idx
     * @return
     */
    private int getParentIdx(int idx) {
        int parent = (int) Math.floor(idx/2);
        return parent;
    }

}
