package ru.neoflex.vacation_pay_calculator;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
public class VacationPayCalculationMockMvcTest extends VacationPayCalculatorConfigurationTest {

    public final static String VACATION_PAY_API = "/calculate";

    @Autowired
    protected MockMvc mockMvc;

    @Test
    @ApiOperation(value = "Test for calculating vacation pay by average salary and number of vacation days")
    void calculationOfVacationPayForEmployeeUsingSimpleQueryTest() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get(VACATION_PAY_API)
                .param("averageSalary", String.valueOf(50000.00))
                .param("vacationDays", String.valueOf(30))
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("44539.40"))
                .andReturn();

        log.info(result.getResponse().getContentAsString());
    }

    @Test
    @ApiOperation(value = "Test for calculating vacation pay by average salary, number of vacation days and date of vacation")
    void calculationOfVacationPayForEmployeeUsingQueryWithDateTest() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get(VACATION_PAY_API)
                .param("averageSalary", String.valueOf(50000.00))
                .param("vacationDays", String.valueOf(30))
                .param("startVacationDate", "2025-03-19")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("32661.56"))
                .andReturn();

        log.info(result.getResponse().getContentAsString());
    }
}
