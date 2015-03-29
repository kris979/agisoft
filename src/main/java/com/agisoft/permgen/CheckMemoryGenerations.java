/* 
 * ============================================================================ 
 * Name      : CheckMemoryGenerations.java
 * ============================================================================
 */
package com.agisoft.permgen;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryPoolMXBean;
import java.lang.management.MemoryUsage;
import java.util.Iterator;

/**
 * 
 *
 */
public class CheckMemoryGenerations {

    /**
     * 
     */
    public void checkMemory() {
        printMemoryPoolsStats();
        printHeapMemoryUsage();
        printNonHeapMemoryUsage();
    }

    /**
     * 
     */
    private void printMemoryPoolsStats() {
        Iterator<MemoryPoolMXBean> iter = ManagementFactory.getMemoryPoolMXBeans().iterator();
        while (iter.hasNext()) {
            MemoryPoolMXBean pool = (MemoryPoolMXBean) iter.next();
            System.out.println("Memory pool: " + pool.getName() + "," + pool.getType() + "," + pool.getPeakUsage());
        }
    }

    /**
     * 
     */
    private void printHeapMemoryUsage() {
        MemoryMXBean mem = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapMemoryUsage = mem.getHeapMemoryUsage();
        System.out.println("Heap Memory Usage:");
        System.out.println(heapMemoryUsage);
    }

    private void printNonHeapMemoryUsage() {
        MemoryMXBean mem = ManagementFactory.getMemoryMXBean();
        MemoryUsage nonHeapMemoryUsage = mem.getNonHeapMemoryUsage();
        System.out.println("Non-Heap Memory Usage:");
        System.out.println(nonHeapMemoryUsage);
    }

    
    public static void main(String[] args) {
        new CheckMemoryGenerations().checkMemory();
    }
}
