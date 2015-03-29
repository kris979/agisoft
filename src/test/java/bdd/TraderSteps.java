/* 
 * ============================================================================ 
 * Name      : CalculatorSteps.java
 * ============================================================================
 */
package bdd;

import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.agisoft.bdd.Stock;

/**
 * 
 *
 */
public class TraderSteps {

    private Stock stock;
    
    @Given("a stock of symbol <symbol> and a threshold of <threshold>")
    public void aStock(@Named("symbol") String symbol, @Named("threshold") double threshold) {
        stock = new Stock(symbol, threshold);
    }
 
    @When("the stock is traded at <price>")
    public void theStockIsTradedAt(@Named("price") double price) {
        stock.tradeAt(price);
    }
 
    @Then("the alert status should be <status>")
    public void theAlertStatusShouldBe(@Named("status") String status) {
        assertEquals(status,stock.getStatus());
    }
}
