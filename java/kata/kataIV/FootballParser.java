/* 
 * ============================================================================ 
 * Name      : FootballParser.java
 * ============================================================================
 */
package kata.kataIV;

import java.util.regex.Matcher;


/**
 * 
 *
 */
public class FootballParser extends AbstractParser {

    /**
     * 
     */
    static final String regex = "\\s+\\d{1,2}\\.\\s(\\w+)\\s+\\d{2}\\s+\\d{1,2}\\s+\\d{1,2}\\s+\\d{1,2}\\s+(\\d{2})\\s{2}-\\s{2}(\\d{2})\\s+\\d{2}";
    
    /**
     * 
     */
    public FootballParser() {
        super();
    }

    /**
     * @return
     */
    public int getNumberOfTeams() {
        return items.size();
    }

    /**
     * @return
     */
    public Team getTeamWithMinGoalDifference() {
        return (Team) getItemWithMinDifference();
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
        int forGoals = Integer.parseInt(matcher.group(2));
        int againstGoals = Integer.parseInt(matcher.group(3));
        AbstractParsedItem team = new Team(name, forGoals, againstGoals);
        items.add(team);
    }
}
