package net.funsys.demo;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import net.funsys.demo.controller.FavoriteController;
import net.funsys.demo.controller.MovieController;
import net.funsys.demo.service.MovieService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	private MockMvc mockMvc;

	@MockBean
	MovieService movieService;

	@Autowired
	private MovieController movieController;

	@Autowired
	private FavoriteController favoriteController;

//	@Before
//	public void setup() {
//		mockMvc = MockMvcBuilders.standaloneSetup(movieController).build();
//	}

	@Test
	public void contextLoads() throws Exception {
		assertThat(movieController).isNotNull();
		assertThat(favoriteController).isNotNull();
	}

//	@Test
//	public void shouldReturnDefaultMessage() throws Exception {
//		this.mockMvc.perform(get("/movies")).andDo(print()).andExpect(status().isOk())
//				.andExpect(content().string(containsString("千と千尋の神隠し")));
//	}

}
