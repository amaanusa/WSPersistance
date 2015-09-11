/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.controllers.jpadao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;
import src.controllers.jpadao.exceptions.NonexistentEntityException;
import src.controllers.jpadao.exceptions.PreexistingEntityException;
import src.controllers.jpadao.exceptions.RollbackFailureException;
import src.entities.BizbystateEmail;

/**
 *
 * @author imranadmin
 */
public class BizbystateEmailJpaController implements Serializable {

    public BizbystateEmailJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(BizbystateEmail bizbystateEmail) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(bizbystateEmail);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findBizbystateEmail(bizbystateEmail.getRownum()) != null) {
                throw new PreexistingEntityException("BizbystateEmail " + bizbystateEmail + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(BizbystateEmail bizbystateEmail) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            bizbystateEmail = em.merge(bizbystateEmail);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = bizbystateEmail.getRownum();
                if (findBizbystateEmail(id) == null) {
                    throw new NonexistentEntityException("The bizbystateEmail with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            BizbystateEmail bizbystateEmail;
            try {
                bizbystateEmail = em.getReference(BizbystateEmail.class, id);
                bizbystateEmail.getRownum();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bizbystateEmail with id " + id + " no longer exists.", enfe);
            }
            em.remove(bizbystateEmail);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<BizbystateEmail> findBizbystateEmailEntities() {
        return findBizbystateEmailEntities(true, -1, -1);
    }

    public List<BizbystateEmail> findBizbystateEmailEntities(int maxResults, int firstResult) {
        return findBizbystateEmailEntities(false, maxResults, firstResult);
    }

    private List<BizbystateEmail> findBizbystateEmailEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(BizbystateEmail.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public BizbystateEmail findBizbystateEmail(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(BizbystateEmail.class, id);
        } finally {
            em.close();
        }
    }

    public int getBizbystateEmailCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<BizbystateEmail> rt = cq.from(BizbystateEmail.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
