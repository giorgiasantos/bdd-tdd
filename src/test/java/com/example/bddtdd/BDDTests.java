package com.example.bddtdd;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BDDTests {
    private Calculator calculator;
    private int result;

    @Given("^I have entered (\\d+) into the calculator$")
    public void i_have_entered_into_the_calculator(int number) {
        calculator = new Calculator();
        calculator.enter(number);
    }

    @When("^I press add$")
    public void i_press_add() {
        result = calculator.add();
    }

    @Then("^the result should be (\\d+) on the screen$")
    public void the_result_should_be_on_the_screen(int expectedResult) {
        assertEquals(expectedResult, result);
    }
}



