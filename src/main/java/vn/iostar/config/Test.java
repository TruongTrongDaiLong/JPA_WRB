package vn.iostar.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.iostar.entity.Category;

public class Test {
	public static void main(String[] args) {
		EntityManager enma = JPAConfig.getEntityManager();	
		EntityTransaction trans = enma.getTransaction();
		Category category = new Category();
		category.setCategoryname("Iphone");
		category.setImages("abc.jpg");
		category.setStatus(1);
		try {
			trans.begin();
			enma.persist(category);
			trans.commit();
		} catch(Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		}
		finally {
			enma.close();
		}
	}
}
