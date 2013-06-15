/* 
  * ============================================================================ 
  * Name      : FootballTest.java
  * ============================================================================
  */
package kata.parser;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import java.io.File;

import kata.kataIV.FootballParser;
import kata.kataIV.Team;

import org.junit.Before;
import org.junit.Test;


/**
 * 
 *
 */
public class FootballParserTest {
    
    private File footballFile = new File("src/test/java/kata.kataIV/football.dat");
    private FootballParser footballParser;

    @Before
    public void prepareWeather() {
        footballParser = new FootballParser();
        footballParser.parse(footballFile);
        assertThat(footballParser.getNumberOfTeams(), is(20));
    }
    
    @Test
    public void getTeamWithMinGoalDifference() {
        Team team = footballParser.getTeamWithMinGoalDifference();
        assertThat(team, is(notNullValue()));
        assertThat(team.getName(), is("Aston_Villa"));
        assertThat(team.getForGoals(), is(46));
        assertThat(team.getAgainstGoals(), is(47));
        assertThat(team.getGoalDifference(), is(1));
    }
}
