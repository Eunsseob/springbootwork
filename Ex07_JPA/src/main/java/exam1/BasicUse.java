package exam1;

import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class BasicUse {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaEx01");
		EntityManager em = emf.createEntityManager(); 
		EntityTransaction ts = em.getTransaction();
		
		try {
			
		ts.begin();
		Member1 user = new Member1("tjoeun", LocalDate.now());
		
		// .persist : 영속성으로 객체에 데이터 입력(메모리에 insert해주는 부분)
		em.persist(user);
		
		ts.commit();
		} catch(Exception e) {
			e.printStackTrace();
			ts.rollback();
		}
		em.close();
		emf.close();
	} 

}
