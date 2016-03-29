package edu.khnahu.mvc;

import edu.khnahu.domain.Account;
import edu.khnahu.repository.AccountRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import edu.khnahu.controller.*;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/rest-servlet.xml")
public class AppTests {
    private MockMvc mockMvc;

    //@SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;

    private AccountManagerController accountManagerController;

    @Autowired
    private AccountRepository accountRepository;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
        accountManagerController = new AccountManagerController(accountRepository);
    }

    @Test
    public void simple() throws Exception {

       List<Account> accounts = accountManagerController.getAllAccounts();

        Assert.assertFalse(accounts.size() == 0);
        /*mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("hello"));*/
    }
}
