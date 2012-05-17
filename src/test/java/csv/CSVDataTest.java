/* 
  * ============================================================================ 
  * Name      : CSVDataTest.java
  * ============================================================================
  */
package csv;


import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
//import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

/**
 * 
 *
 */
public class CSVDataTest {
    
    private File sampleCSVFile = new File("sample.csv");
    private CSVData entries;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        CSVImport importer = new CSVImport();
        entries = importer.read(sampleCSVFile);
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void shouldGetHeadlines() {
        String[] exp = {"Transaction Date", "Transaction Type", "Sort Code", "Account Number", "Transaction Description", "Debit Amount", "Credit Amount", "Balance"};
        List<String> expected = Arrays.asList(exp);
        List<String> headlines = entries.getHeadlines();
//        assertEquals(expected,headlines);
        assertThat(headlines, is(expected));
    }
}
