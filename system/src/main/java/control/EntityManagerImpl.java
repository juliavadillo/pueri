package control;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Paciente;

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
		entityManager.getTransaction().begin();			
		entityManager.merge(object);
		entityManager.getTransaction().commit();
		entityManager.close();
		factory.close();
	}
	public void remove (Object object) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE);
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();	
		Object toRemove = entityManager.merge(object);
		entityManager.remove(toRemove);
		entityManager.getTransaction().commit();
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
	
	public List find(String select){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE);
		EntityManager entityManager = factory.createEntityManager();
		Query query = entityManager.createQuery(select);
		return query.getResultList();
	}
	


}
