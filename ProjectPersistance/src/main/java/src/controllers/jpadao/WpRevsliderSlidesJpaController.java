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
import src.entities.WpRevsliderSlides;

/**
 *
 * @author imranadmin
 */
public class WpRevsliderSlidesJpaController implements Serializable {

    public WpRevsliderSlidesJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(WpRevsliderSlides wpRevsliderSlides) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(wpRevsliderSlides);
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

    public void edit(WpRevsliderSlides wpRevsliderSlides) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            wpRevsliderSlides = em.merge(wpRevsliderSlides);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = wpRevsliderSlides.getId();
                if (findWpRevsliderSlides(id) == null) {
                    throw new NonexistentEntityException("The wpRevsliderSlides with id " + id + " no longer exists.");
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
            WpRevsliderSlides wpRevsliderSlides;
            try {
                wpRevsliderSlides = em.getReference(WpRevsliderSlides.class, id);
                wpRevsliderSlides.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The wpRevsliderSlides with id " + id + " no longer exists.", enfe);
            }
            em.remove(wpRevsliderSlides);
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

    public List<WpRevsliderSlides> findWpRevsliderSlidesEntities() {
        return findWpRevsliderSlidesEntities(true, -1, -1);
    }

    public List<WpRevsliderSlides> findWpRevsliderSlidesEntities(int maxResults, int firstResult) {
        return findWpRevsliderSlidesEntities(false, maxResults, firstResult);
    }

    private List<WpRevsliderSlides> findWpRevsliderSlidesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(WpRevsliderSlides.class));
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

    public WpRevsliderSlides findWpRevsliderSlides(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(WpRevsliderSlides.class, id);
        } finally {
            em.close();
        }
    }

    public int getWpRevsliderSlidesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<WpRevsliderSlides> rt = cq.from(WpRevsliderSlides.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
