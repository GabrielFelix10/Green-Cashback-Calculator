package behavior;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.green.cashback.greenCashbackCalculator.GreenCashbackCalculatorApplication;
import com.green.cashback.greenCashbackCalculator.model.Bottle;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.CoreMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author gfaraujo
 */
@TestPropertySource(locations = {"classpath:application.properties"})
@WebAppConfiguration
@ContextConfiguration(classes = GreenCashbackCalculatorApplication.class)
public class CashBackCalculatorStepDefs {

    private int bottles;

    @Autowired
    protected WebApplicationContext context;

    private ResultActions resultActions;

    @Autowired
    protected ObjectMapper objectMapper;

    private MockMvc mockMvc;

    @PostConstruct
    private void initMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Given("I have {int} plastic bottles")
    public void i_have_plastic_bottles(Integer bottles) {
        this.bottles = bottles;
    }

    @When("I finish to put all they in  machine")
    public void i_finish_to_put_all_they_in_machine() throws Exception {

        var bottle = new Bottle(2);

        final RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/cash-back")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(bottle));

        resultActions = mockMvc.perform(requestBuilder);
    }


    @Then("the machine must give {double} in cashback")
    public void the_machine_must_give_in_cashback(Double expetedCashBack) throws Exception {
        resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cashBackValue", is(expetedCashBack.doubleValue())));
    }


}
