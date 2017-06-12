/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bajudistro;

import bajudistro.distro;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author tiara fransiska
 */
public class Querydistro {
    
  public void Add(Object object) {
        
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("BajuDistroPU");
        EntityManager em = emf.createEntityManager();   
        em.getTransaction().begin();
        try {
                em.persist(object);
                em.getTransaction().commit();
        } catch (Exception e) {
                e.printStackTrace();
                em.getTransaction().rollback();
        } finally {
                em.close();
        }
        
        }
    public void Show(){
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("BajuDistroPU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT e FROM distro e");
        List<distro> result = query.getResultList();
        for (distro e : result) {
        System.out.println("__________________________________________________________________________________________________");
        System.out.println("No." +e.getId() 
                + " | Nama :"  +e.getNama() 
                + " | Alamat :"  +e.getAlamat() 
                + " | No.Telpon :"  +e.getNoTelpon() 
                + " | Merk Distro :"  +e.getMerkdistro()
                + " | ID User :"  +e.getIduser()
                + " | ");
        System.out.println("__________________________________________________________________________________________________");    
        }
    }
     public void update(long id,String a,String b,String c,String d,String e){
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("BajuDistroPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("UPDATE distro e SET e.nama=?1,e.alamat=?2,e.NoTelpon=?3,e.Merkdistro=?4 WHERE e.Iduser?5",distro.class)
                .setParameter(1, b)
                .setParameter(2, c)
                .setParameter(3, d)
                .setParameter(4, e)
                .setParameter(5, a)
                .executeUpdate();
        em.getTransaction().commit();
    }
     public void Delete(String a){
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("distroshopPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        String hapus = a;
        em.createQuery("DELETE FROM distro e WHERE e.Iduser=:par").setParameter("par", hapus).executeUpdate();
        em.getTransaction().commit();
    }
}
