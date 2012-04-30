/* 
  * ============================================================================ 
  * Name      : CSVImportTest.java
  * ============================================================================
  */
package csv;


import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 
 *
 */
public class CSVImportTest {
    
    private File sampleCSVFile = new File("sample.csv");

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void ImporterShouldBeAbleToReadSampleCSV() throws IOException {
        CSVImport importer = new CSVImport();
        CSVData entries = importer.read(sampleCSVFile);
        assertNotNull(entries);
    }
}
