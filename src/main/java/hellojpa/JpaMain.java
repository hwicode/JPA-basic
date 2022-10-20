package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        try {

//            Member member = new Member();
//            member.setUserName("wqewqe");
//
//            entityManager.persist(member);
            Member member = entityManager.find(Member.class, 1L);
            System.out.println("====================================");
            entityManager.remove(member);
            System.out.println("=============================");
            Member member1 = entityManager.find(Member.class, 1L);
            System.out.println("member1 = " + member1);
            System.out.println("member1.getUserName() = " + member1.getUserName());
            System.out.println("member1.getClass() = " + member1.getClass());

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }
}
