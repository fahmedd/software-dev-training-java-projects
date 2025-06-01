package comfdmgroupjpaexercise2;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class RunnerExercise2 {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jparelationship");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		List<Module> modules = new ArrayList<Module>();
		List<Module> modulelist = new ArrayList<Module>();
		Stream stream1= new Stream("Software Development", modules);
		Stream stream2= new Stream("BABI", modulelist);
	
		Module module1= new Module("SQL");
		Module module2= new Module("OOD");
		
		modules.add(module2);
		modules.add(module1);
		modulelist.add(module1);
		
		Trainee trainee1 = new Trainee("John", "Doe", stream1);
		Trainee trainee2 = new Trainee("James", "Smith", stream2);
		Trainee trainee3 = new Trainee("Jane","Doe", stream1);
		
		entityTransaction.begin();
		
		entityManager.persist(stream1);
		entityManager.persist(stream2);
		entityManager.persist(trainee1);
		entityManager.persist(trainee2);
		entityManager.persist(trainee3);
		
		
		entityTransaction.commit();
		
		
		//search - Note the use of getSingleResult() instead of getResultList - this works because the stream name is unique
		System.out.println("Find by name");
		Stream namedSelectQuery1= entityManager.createNamedQuery("Stream.findByStreamName", Stream.class).setParameter("stName","BABI").getSingleResult();
		namedSelectQuery1.getModules().forEach(module -> System.out.println(module.getName()));
		// find stream and get the modules then print each modulename  in the list
				
		//search
		System.out.println("Find by stream");
		TypedQuery<Trainee>namedSelectQuery2= entityManager.createNamedQuery("Trainee.findByStream", Trainee.class);
		namedSelectQuery2.setParameter("trstream",stream1);
		List<Trainee>listTheTrainees= namedSelectQuery2.getResultList();
		for (Trainee eachTrainee: listTheTrainees) {
			System.out.println(eachTrainee.getFirstName() + " " + eachTrainee.getLastName());
		}
		// or can write
		//Stream softwareDevelopmentStream = entityManager.find(Stream.class, 1);
		//List<Trainee> softwareDevelopmentTrainees = entityManager.createNamedQuery("Trainee.findByStream", Trainee.class).setParameter("stream", softwareDevelopmentStream).getResultList();
		//System.out.println("Software development trainees:");
		//softwareDevelopmentTrainees.forEach(trainee -> System.out.println(trainee.getFirstName()+" "+trainee.getLastName()));
		
		
		
		entityManager.close();
		entityManagerFactory.close();
		
		
		
		
		
	}

}
