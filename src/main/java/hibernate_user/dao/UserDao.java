package hibernate_user.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hibernate_user.dto.User;

public class UserDao {

	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("pramod").createEntityManager();

	}

	public void signUp(User user) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
	}

	public User login(User user) {
		// TODO Auto-generated method
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.email=?1");
		query.setParameter(1, user.getEmail());

		try {

			User dbUser = (User) query.getSingleResult();

			return dbUser;

		} catch (Exception e) {
			return null;
		}

	}

	public User displayPassword(String email) {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.email=?1");
		query.setParameter(1, email);
		User user = (User) query.getSingleResult();

		return user;
	}

	public void upadtePassword(User user) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.email=?1");
		query.setParameter(1, user.getEmail());

		User dbUser = (User) query.getSingleResult();

		entityTransaction.begin();

		user.setId(dbUser.getId());
		user.setName(dbUser.getName());
		user.setPhone(dbUser.getPhone());
		entityManager.merge(user);
		entityTransaction.commit();
	}

}
