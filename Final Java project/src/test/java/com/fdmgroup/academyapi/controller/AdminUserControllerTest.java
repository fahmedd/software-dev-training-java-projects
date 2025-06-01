package com.fdmgroup.academyapi.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.BDDMockito.willReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fdmgroup.academyapi.models.AdminUser;
import com.fdmgroup.academyapi.models.Movie;
import com.fdmgroup.academyapi.service.AdminUserService;

@WebMvcTest
public class AdminUserControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	AdminUserService adminUserService;

	@Autowired
	ObjectMapper objectMapper;

	AdminUser adminUser;

	@BeforeEach
	void setup() {
		adminUser = new AdminUser();
		adminUser.setUsername("johnDoe245");
		adminUser.setPassword("johnHatesCapitalism");

		List<Movie> JohnDoeWatchList= new ArrayList<Movie>();

		LocalDate localDate = LocalDate.of(2012, 05, 05);
		LocalDate localDate2 = LocalDate.of(2013, 06, 05);
	
		Movie movie1 = new Movie();
		movie1.setName("Avengers");
		movie1.setDirector("Joss Whedon");
		movie1.setRating(5.0);
		movie1.setReleaseDate(localDate);
		movie1.setGenre("superHero");
		movie1.setImage("img");

		Movie movie2 = new Movie();
		movie2.setName("Age of ultron");
		movie2.setDirector("Joss Whedon");
		movie2.setRating(5.0);
		movie2.setReleaseDate(localDate2);
		movie2.setGenre("superHero");
		movie2.setImage("img");
		
		JohnDoeWatchList.add(movie1);
	 	JohnDoeWatchList.add(movie2);
	
		adminUser.setWatchList(JohnDoeWatchList);
	}


    @Test
	@DisplayName("save User")
	void givenUser_whenCreateUser_thenReturnSavedUser() throws Exception {
		// arrange
		adminUser.setId(1);

		given(adminUserService.createAdminUser(ArgumentMatchers.any(AdminUser.class)))
				.willAnswer(invocation -> invocation.getArgument(0));

		// assert
		//@formatter:off
		mockMvc.perform(post("/api/v1/user")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(adminUser)))
				.andDo(print())
				.andExpect(status().isCreated())
                .andExpect(jsonPath("$.username", is(adminUser.getUsername())))
				.andExpect(jsonPath("$.password", is(adminUser.getPassword())))
                ;
		//@formatter:off
	}

    
    @Test
	@DisplayName("Find user by username")
	void givenUserUsername_whenFindByUsername_thenReturnSavedUserInDB() throws Exception{
		//Give
		willReturn(adminUser).given(adminUserService.getAdminUserByUsername(("johnDoe245")));

		//then
		mockMvc.perform(get("/api/v1/users/1"))
				.andDo(print())
				.andExpect(jsonPath("$.password", is(adminUser.getPassword())));
	} 

	@Test
	@DisplayName("Delete user by id")
	void testDeleteById() throws Exception{
		//given
		willDoNothing().given(adminUserService).removeAdminUser(1);

		//then
		mockMvc.perform(delete("/api/v1/users/1"))
				.andDo(print())
				.andExpect(status().isOk());
	}

	
	@Test
	@DisplayName("Find All users")
	void givenNothing_whenFindAll_thenReturnsAllUsers() throws Exception {
		// arrange
		AdminUser adminUser2 = new AdminUser();
		adminUser2.setUsername("JaneDoe789");
		adminUser2.setPassword("Password123");
		
		List<AdminUser> dbAdminUsers = new ArrayList<AdminUser>();
		dbAdminUsers.add(adminUser);
		dbAdminUsers.add(adminUser2);
		given(adminUserService.getAllAdminUsers()).willReturn(dbAdminUsers);

		// assert
		//@formatter:off
		mockMvc.perform(get("/api/v1/users"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$", Matchers.hasSize(1)))
			.andExpect(jsonPath("$[0].username", is("johnDoe245")));
		// @formatter:on
	}

	@AfterEach
	void tearDown() {
		mockMvc = null;
		objectMapper = null;
		adminUserService = null;
		adminUser = null;
	}


}
