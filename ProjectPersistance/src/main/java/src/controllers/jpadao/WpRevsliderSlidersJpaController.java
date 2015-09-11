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
import src.controllers.jpadao.exceptions.RollbackFailureException;
import src.entities.WpRevsliderSliders;

/**
 *
 * @author imranadmin
 */
public class WpRevsliderSlidersJpaController implements Serializable {

    public WpRevsliderSlidersJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(WpRevsliderSliders wpRevsliderSliders) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(wpRevsliderSliders);
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

    public void edit(WpRevsliderSliders wpRevsliderSliders) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            wpRevsliderSliders = em.merge(wpRevsliderSliders);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = wpRevsliderSliders.getId();
                if (findWpRevsliderSliders(id) == null) {
                    throw new NonexistentEntityException("The wpRevsliderSliders with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            WpRevsliderSliders wpRevsliderSliders;
            try {
                wpRevsliderSliders = em.getReference(WpRevsliderSliders.class, id);
                wpRevsliderSliders.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The wpRevsliderSliders with id " + id + " no longer exists.", enfe);
            }
            em.remove(wpRevsliderSliders);
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

    public List<WpRevsliderSliders> findWpRevsliderSlidersEntities() {
        return findWpRevsliderSlidersEntities(true, -1, -1);
    }

    public List<WpRevsliderSliders> findWpRevsliderSlidersEntities(int maxResults, int firstResult) {
        return findWpRevsliderSlidersEntities(false, maxResults, firstResult);
    }

    private List<WpRevsliderSliders> findWpRevsliderSlidersEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(WpRevsliderSliders.class));
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

    public WpRevsliderSliders findWpRevsliderSliders(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(WpRevsliderSliders.class, id);
        } finally {
            em.close();
        }
    }

    public int getWpRevsliderSlidersCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<WpRevsliderSliders> rt = cq.from(WpRevsliderSliders.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
