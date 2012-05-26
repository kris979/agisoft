/* 
 * ============================================================================ 
 * Name      : AbstractParser.java
 * ============================================================================
 */
package kata.kataIV;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 *
 */
public abstract class AbstractParser {

    protected List<AbstractParsedItem> items = new ArrayList<AbstractParsedItem>();

    /**
     * 
     */
    public AbstractParser() {
        super();
    }

    /**
     * @param footballFile
     */
    public void parse(File footballFile) {
        String regex = getRegex();
        Pattern pattern = Pattern.compile(regex);
        Reader in = null;
        try {
            in = new FileReader(footballFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(in);
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                boolean matches = matcher.find();
                if (matches) {
                    createItem(matcher);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected AbstractParsedItem getItemWithMinDifference() {
        AbstractParsedItem t = items.get(0);
        for (AbstractParsedItem item : items) {
            if (item.getDifference() < t.getDifference()) {
                t = item;
            }
        }
        return t;
    }
    /**
     * @param matcher
     */
    protected abstract void createItem(Matcher matcher);

    /**
     * @return
     */
    protected abstract String getRegex();

}