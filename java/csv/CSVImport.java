/* 
  * ============================================================================ 
  * Name      : CSVImport.java
  * ============================================================================
  */
package csv;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

/**
 * 
 *
 */
public class CSVImport {

    public CSVData read(File csvFile) throws IOException {
        CSVReader reader = new CSVReader(new FileReader(csvFile.toString()));
        List<String[]> entries = reader.readAll();
        return new CSVData(entries);
    }

}
