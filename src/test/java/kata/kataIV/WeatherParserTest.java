/* 
  * ============================================================================ 
  * Name      : WeatherTest.java
  * ============================================================================
  */
package kata.kataIV;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.io.File;

import kata.kataIV.Day;
import kata.kataIV.WeatherParser;

import org.junit.Before;
import org.junit.Test;


/**
 * 
 *
 */
public class WeatherParserTest {
    
    private File weatherFile = new File("src/test/java/kata.kataIV/weather.dat");
    private WeatherParser weatherParser;

    
    @Before
    public void prepareWeather() {
        weatherParser = new WeatherParser();
        weatherParser.parse(weatherFile);
        assertThat(weatherParser.getNumberOfDays(), is(30));
    }
    
    @Test
    public void getDayNumberWithMinTempSpread() {
        Day expected = new Day("14",61,59);
        Day dayWithMinTempSpread = weatherParser.getDayNumberWithMinTempSpread();
        assertThat(dayWithMinTempSpread, is(equalTo(expected)));
        assertThat(dayWithMinTempSpread.getSpread(), is(2));
    }

    
}
