package com.fdmgroup.academyapi.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.fdmgroup.academyapi.models.AdminUser;
import com.fdmgroup.academyapi.models.Movie;
import com.fdmgroup.academyapi.repository.AdminUserDAO;


@ActiveProfiles({ "test" })
@DataJpaTest
public class AdminUserDAOtest {

	@Autowired
	private AdminUserDAO adminUserDAO;
	
	private AdminUser adminUser;

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
	
		JohnDoeWatchList.add(movie1);
	 	JohnDoeWatchList.add(movie2);
	
		adminUser.setWatchList(JohnDoeWatchList);

	}

	@Test
	@DisplayName("Test JPA save method")
	void whenExecuteSave_ReturnsTheCorrectNumberOfUsers() {
		// arrange - given

		// act 
		adminUserDAO.save(adminUser);

		// assert 
		assertThat(adminUserDAO.count()).isEqualTo(1);
	}
    
    
	@Test
	@DisplayName("Test JPA find username")
	void whenFindByUsername_thenReturnSavedUserObject() {
		// arrange
		adminUserDAO.save(adminUser);

		// act
		AdminUser actual = adminUserDAO.findByUsername("johnDoe245");

		// assert
		assertThat(actual).isNotNull();
		assertThat(adminUserDAO.count()).isEqualTo(1);
		assertThat(actual.getUsername()).isEqualTo("johnDoe245");

	}

	@Test
	@DisplayName("Delete")
	void whenDeleteById_thenDeleteTheuser() {
		// arrange
		adminUserDAO.save(adminUser);

		// act
		adminUserDAO.deleteById(adminUser.getId());

		// assert
		assertThat(adminUserDAO.count()).isEqualTo(1);
	}

 

	@AfterEach
		void tearDown() {
			adminUserDAO.deleteAll();
			adminUserDAO = null;
			adminUser= null;
 }
	

}
