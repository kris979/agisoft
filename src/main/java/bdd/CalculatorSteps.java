/* 
 * ============================================================================ 
 * Name      : CalculatorSteps.java
 * ============================================================================
 */
package bdd;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.junit.Assert.*;

/**
 * 
 *
 */
public class CalculatorSteps {

    Calculator calc;
    int result;

    @Given("calculator")
    public void calculator() {
        calc = new Calculator();
    }

    @When("I add 2 to 3")
    public void add(int firstNumber, int secondNumber) {
        result = calc.add(firstNumber, secondNumber);
    }
    
    @Then("I should get 5 back")
    public void checkResult() {
        assertEquals(result,5);
    }
}
