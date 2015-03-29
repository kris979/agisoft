/* 
  * ============================================================================ 
  * Name      : WeatherParser.java
  * ============================================================================
  */
package kata.kataIV;

import java.util.regex.Matcher;


/**
 * 
 *
 */
public class WeatherParser extends AbstractParser {

    private static final String regex = "\\s+(\\d{1,2})\\s{2}(\\d{2}).{4}(\\d{2}).*";
    
    /**
     * 
     */
    public WeatherParser() {
        super();
    }
    
    /**
     * @return
     */
    public Integer getNumberOfDays() {
        return items.size();
    }
    
    /**
     * @return
     */
    public Day getDayNumberWithMinTempSpread() {
        return (Day) getItemWithMinDifference();
    }



    /* (non-Javadoc)
     * @see kata.kataIV.AbstractParser#getRegex()
     */
    @Override
    protected String getRegex() {
        return regex;
    }


    /**
     * @param matcher
     * @throws NumberFormatException
     */
    @Override
    protected void createItem(Matcher matcher) throws NumberFormatException {
        String name = matcher.group(1);
        int maxGoals = Integer.parseInt(matcher.group(2));
        int minGoals = Integer.parseInt(matcher.group(3));
        Day team = new Day(name, maxGoals, minGoals);
        items.add(team);
    }

}
