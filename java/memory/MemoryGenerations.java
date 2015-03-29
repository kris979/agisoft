/* 
 * ============================================================================ 
 * Name      : MemoryGenerations.java
 * ============================================================================
 */
package memory;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryPoolMXBean;
import java.lang.management.MemoryUsage;
import java.util.Iterator;

public class MemoryGenerations {

    private void printMemoryPoolsStats() {
        Iterator<MemoryPoolMXBean> iter = ManagementFactory.getMemoryPoolMXBeans().iterator();
        while (iter.hasNext()) {
            MemoryPoolMXBean pool = (MemoryPoolMXBean) iter.next();
            System.out.println("Memory pool: " + pool.getName() + "," + pool.getType() + "," + pool.getPeakUsage());
        }
    }

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
        MemoryGenerations r = new MemoryGenerations();
        r.printMemoryPoolsStats();
        r.printHeapMemoryUsage();
        r.printNonHeapMemoryUsage();
    }
}
