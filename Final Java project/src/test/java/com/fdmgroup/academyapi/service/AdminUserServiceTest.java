package com.fdmgroup.academyapi.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fdmgroup.academyapi.repository.AdminUserDAO;
import com.fdmgroup.academyapi.models.AdminUser;
import com.fdmgroup.academyapi.models.Movie;


@ExtendWith(MockitoExtension.class)
public class AdminUserServiceTest {

	@InjectMocks
	AdminUserService AdminUserService;

	@Mock
	AdminUserDAO AdminUserDAO;

	AdminUser AdminUser;


    @BeforeEach
	void setup() {
		AdminUser = new AdminUser();
		AdminUser.setUsername("johnDoe245");
		AdminUser.setPassword("johnHatesCapitalism");

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
	
		 AdminUser.setWatchList(JohnDoeWatchList);
	}

	@Test
	@DisplayName("Create Admin")
	void givenAdminUser_whenSave_thenReturnSavedAdminUserFromDatabase() {
		// arrange
		when(AdminUserDAO.save(AdminUser)).thenReturn(AdminUser);

		// act
		AdminUser actual = AdminUserService.createAdminUser(AdminUser);

		// assert
		assertThat(actual).isNotNull();
		assertThat(actual.getUsername()).isEqualTo("johnDoe245");
		assertThat(actual.getPassword()).isEqualTo("johnHatesCapitalism");
		verify(AdminUserDAO, times(1)).save(AdminUser);
	}

	@Test
	@DisplayName("Find user by username")
	void givenUserUsername_whenFindUserByUsername_thenReturnDBUser() {
		// arrange
		String username= "johnDoe245";
		when(AdminUserDAO.findByUsername(username)).thenReturn(AdminUser);

		// act
		AdminUser actual = AdminUserService.getAdminUserByUsername(username);

		// assert
		assertThat(actual).isNotNull();
		assertThat(actual.getUsername()).isEqualTo("johnDoe245");
		assertThat(actual.getPassword()).isEqualTo("johnHatesCapitalism");
		verify(AdminUserDAO, times(1)).findByUsername(username);
	}

	   @Test
		@DisplayName("Delete test")
		void testDeleteMethod_DeletesAdminUser(){
			//arrange
		   	AdminUser AdminUser2 =  new AdminUser ();
			AdminUser2 .setUsername("JaneDoe987");
			AdminUser2 .setPassword("null");

	        when(AdminUserDAO.existsById(1)).thenReturn(true);

			// act
	        AdminUserDAO.save(AdminUser2);
	        AdminUserDAO.deleteById(1);

			// assert
	        assertThat(AdminUserDAO.existsById(1)).isEqualTo(true);
			assertThat(AdminUserDAO.count()).isEqualTo(0);
			verify(AdminUserDAO, times(1)).deleteById(1);
		} 


	@Test
	@DisplayName("list Admin Users calls findAll")
	void whenListUsersCalled_findAllIsTriggered(){
		//arrange
		AdminUser AdminUser2 =  new AdminUser ();
		AdminUser2 .setUsername("JaneDoe987");
		AdminUser2 .setPassword("null");

		List<AdminUser> users = new ArrayList<AdminUser>();
		users.add(AdminUser);
		users.add(AdminUser2);

		when(AdminUserDAO.findAll()).thenReturn(users);

		//act
		Iterable<AdminUser> actual = AdminUserService.getAllAdminUsers();
		//assert
		assertThat(StreamSupport.stream(actual.spliterator(), false).count()).isEqualTo(2);
		verify(AdminUserDAO, times(1)).findAll();
	}
	

	@AfterEach
	void tearDown() {
		AdminUserService = null;
		AdminUserDAO = null;
		AdminUser = null;
	}
}


