package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");//xml파일의 이름


        EntityManager em = emf.createEntityManager();
        //code
        em.close();

        //
        emf.close();

    }
}
