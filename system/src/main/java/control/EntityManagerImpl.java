package control;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

public class EntityManagerImpl {

	private static final String PERSISTENCE = "persistence";
	public void insert(Object object) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE);
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(object);
		entityManager.getTransaction().commit();
		entityManager.close();
		factory.close();

	}

	
	public Object insertObject(Object object) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE);
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(object);
		entityManager.getTransaction().commit();
		Object obj = object;
		entityManager.close();
		factory.close();
		return obj;

	}
	
	public void update(Object object) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE);
		EntityManager entityManager = factory.createEntityManager();
		entityManager.refresh(object);
		entityManager.close();
		factory.close();
	}
	public void remove (Object object) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE);
		EntityManager entityManager = factory.createEntityManager();
		entityManager.remove(object);
		entityManager.close();
		factory.close();
	}
	public <T> Object findById (Class<T> clas, Long id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE);
		EntityManager entityManager = factory.createEntityManager();
		Object obj = entityManager.find(clas, id);
		factory.close();
		return obj;
	}
	


}
