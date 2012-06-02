/* 
 * ============================================================================ 
 * Name      : FutureTest.java
 * ============================================================================
 */
package concurrency;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import concurrency.FutureTest.Chunk;

/**
 * 
 *
 */
public class FutureTest {
    
    static private Map<Chunk,Long> chunks = new ConcurrentSkipListMap<Chunk,Long>(); 
    
    /**
     * @param chunks
     */
    private FutureTest() {
        super();
    }


    static class Chunk implements Callable<Long> {

        private final int chunkStart;
        private final int chunkEnd;

        /**
         * @param chuckStart
         * @param chunkEnd
         */
        private Chunk(int chuckStart, int chunkEnd) {
            super();
            this.chunkStart = chuckStart;
            this.chunkEnd = chunkEnd;
        }

        /*
         * (non-Javadoc)
         * 
         * @see java.util.concurrent.Callable#call()
         */
        @Override
        public Long call() throws Exception {
            long result = chunkStart;
            StringBuilder sb = new StringBuilder();
            sb.append(Thread.currentThread().getName() + ": " + chunkStart + "*");
            for (int i = chunkStart + 1; i <= chunkEnd; i++) {
                sb.append(i);
                if (i != chunkEnd) {
                    sb.append("*");
                }
                result *= i;
            }
            sb.append(" = ").append(result);
            System.out.println(sb);
            return result;
        }

        /* (non-Javadoc)
         * @see java.lang.Object#hashCode()
         */
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + chunkEnd;
            result = prime * result + chunkStart;
            return result;
        }

        /* (non-Javadoc)
         * @see java.lang.Object#equals(java.lang.Object)
         */
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (!(obj instanceof Chunk)) {
                return false;
            }
            Chunk other = (Chunk) obj;
            if (chunkEnd != other.chunkEnd) {
                return false;
            }
            if (chunkStart != other.chunkStart) {
                return false;
            }
            return true;
        }

    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        long start = System.currentTimeMillis();
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        Chunk chunk1 = new Chunk(1, 5);
        Chunk chunk2 = new Chunk(6, 10);
        Chunk chunk3 = new Chunk(7, 15);
        ScheduledFuture<Long> chunk1Result = executor.schedule(chunk1,1,TimeUnit.SECONDS);
        System.out.println("Is chunk1 done: " + chunk1Result.isDone());
        ScheduledFuture<Long> chunk2Result = executor.schedule(chunk2,1,TimeUnit.SECONDS);
        ScheduledFuture<Long> chunk3Result = executor.schedule(chunk3,1,TimeUnit.SECONDS);
        System.out.println("....");
        System.out.println(chunk1Result.get().toString() + "*" + chunk2Result.get().toString() + "*"
                + chunk3Result.get().toString() + "=" + chunk1Result.get() * chunk2Result.get() * chunk3Result.get());

        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");
    }
}
