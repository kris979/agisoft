/* 
  * ============================================================================ 
  * Name      : CSVData.java
  * ============================================================================
  */
package csv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 */
public class CSVData {
    /**
     * 
     */
    private List<String[]> entries;

    /**
     * 
     */
    public CSVData(List<String[]> entries) {
        this.entries = entries;
    }

    /**
     * @return
     */
    public List<String> getHeadlines() {
        List<String> asList = new ArrayList<String>(Arrays.asList(entries.get(0)));
        int lastElemIndex = asList.size() - 1;
        asList.remove(lastElemIndex);
        return asList;
    }
}