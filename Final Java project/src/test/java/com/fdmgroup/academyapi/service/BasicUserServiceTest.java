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

import com.fdmgroup.academyapi.repository.BasicUserDAO;
import com.fdmgroup.academyapi.models.BasicUser;
import com.fdmgroup.academyapi.models.Movie;
import com.fdmgroup.academyapi.service.BasicUserService;


@ExtendWith(MockitoExtension.class)
public class BasicUserServiceTest {
	
	@InjectMocks
	BasicUserService BasicUserService;

	@Mock
	BasicUserDAO BasicUserDAO;

	BasicUser BasicUser;


    @BeforeEach
	void setup() {
    	BasicUser = new BasicUser();
    	BasicUser.setUsername("johnDoe245");
    	BasicUser.setPassword("johnHatesCapitalism");

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
	
	 	BasicUser.setWatchList(JohnDoeWatchList);
	}

	@Test
	@DisplayName("Create Basic user")
	void givenBasicUser_whenSave_thenReturnSavedBasicUserFromDatabase() {
		// arrange
		when(BasicUserDAO.save(BasicUser)).thenReturn(BasicUser);

		// act
		BasicUser actual = BasicUserService.createBasicUser(BasicUser);

		// assert
		assertThat(actual).isNotNull();
		assertThat(actual.getUsername()).isEqualTo("johnDoe245");
		assertThat(actual.getPassword()).isEqualTo("johnHatesCapitalism");
		verify(BasicUserDAO, times(1)).save(BasicUser);
	}

	@Test
	@DisplayName("Find user by username")
	void givenUserUsername_whenFindUserByUsername_thenReturnDBUser() {
		// arrange
		String username= "johnDoe245";
		when(BasicUserDAO.findByUsername(username)).thenReturn(BasicUser);

		// act
		BasicUser actual = BasicUserService.getBasicUserByUsername(username);

		// assert
		assertThat(actual).isNotNull();
		assertThat(actual.getUsername()).isEqualTo("johnDoe245");
		assertThat(actual.getPassword()).isEqualTo("johnHatesCapitalism");
		verify(BasicUserDAO, times(1)).findByUsername(username);
	}

	   @Test
		@DisplayName("Delete test")
		void testDeleteMethod_DeletesBasicUser(){
			//arrange
		   	BasicUser BasicUser2 =  new BasicUser ();
		   	BasicUser2.setUsername("JaneDoe987");
		   	BasicUser2.setPassword("null");

	        when(BasicUserDAO.existsById(1)).thenReturn(true);

			// act
	        BasicUserDAO.save(BasicUser2);
	        BasicUserDAO.deleteById(1);

			// assert
	        assertThat(BasicUserDAO.existsById(1)).isEqualTo(true);
			assertThat(BasicUserDAO.count()).isEqualTo(0);
			verify(BasicUserDAO, times(1)).deleteById(1);
		} 


	@Test
	@DisplayName("list Basic Users calls findAll")
	void whenListUsersCalled_findAllIsTriggered(){
		//arrange
		BasicUser BasicUser2 =  new BasicUser ();
		BasicUser2 .setUsername("JaneDoe987");
		BasicUser2 .setPassword("null");

		List<BasicUser> users = new ArrayList<BasicUser>();
		users.add(BasicUser);
		users.add(BasicUser2);

		when(BasicUserDAO.findAll()).thenReturn(users);

		//act
		Iterable<BasicUser> actual = BasicUserService.getAllBasicUsers();
		//assert
		assertThat(StreamSupport.stream(actual.spliterator(), false).count()).isEqualTo(2);
		verify(BasicUserDAO, times(1)).findAll();
	}
	

	@AfterEach
	void tearDown() {
		BasicUserService = null;
		BasicUserDAO = null;
		BasicUser = null;
	}
}


	

