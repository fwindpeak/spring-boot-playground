package com.fwindpeak.bootfirst;

import com.fwindpeak.bootfirst.controlller.GreetingController;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
class BootfirstApplicationTests {

    public static MockMvc mvc;

    @BeforeAll
    public static void setUp() throws Exception {
		System.out.println("setup");
		mvc = MockMvcBuilders.standaloneSetup(new GreetingController()).build();
	}

	@Test
	public void getHello() throws Exception{
		System.out.println("getHello");
		mvc.perform(MockMvcRequestBuilders.get("/greeting").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("content").value("Hello World!"));
//				.andExpect(content().string(equalTo("Hello World")));
	}

	@Test
	public void testWind() throws Exception{
		System.out.println("testWind");
        mvc.perform(MockMvcRequestBuilders.get("/greeting?name=wind").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("content").value("Hello wind!"));
//				.andExpect(content().string(equalTo("Hello World")));
	}

	@Test
	public void testHello() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/hello/world"))
				.andDo(print());
	}

	@Test
	public void testBook() throws Exception{
    	mvc.perform(MockMvcRequestBuilders.get("/book"))
				.andDo(print());
	}
}
