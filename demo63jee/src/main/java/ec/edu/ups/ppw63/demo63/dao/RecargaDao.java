package ec.edu.ups.ppw63.demo63.dao;

import java.util.List;

import ec.edu.ups.ppw63.demo63.model.Recarga;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class RecargaDAO {

    @PersistenceContext
    private EntityManager em;
    
    public void insert(Recarga recarga) {
        em.persist(recarga);
    }
    
    public void update(Recarga recarga) {
        em.merge(recarga);
    }
    
    public Recarga read(int id) {
        return em.find(Recarga.class, id);
    }
    
    public void remove(int id) {
        Recarga recarga = em.find(Recarga.class, id);
        em.remove(recarga);
    }
    
    public List<Recarga> getAll(){
        String jpql = "SELECT r FROM Recarga r";
        Query q = em.createQuery(jpql, Recarga.class);
        return q.getResultList();
    }
    
   
    public List<Recarga> getRecargasPorNumeroTelefono(String numeroTelefono) {
        String jpql = "SELECT r FROM Recarga r WHERE r.numeroTelefono = :numeroTelefono";
        Query q = em.createQuery(jpql, Recarga.class);
        q.setParameter("numeroTelefono", numeroTelefono);
        return q.getResultList();
    }
    

}
