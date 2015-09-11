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
import src.entities.WpWoocommerceTermmeta;

/**
 *
 * @author imranadmin
 */
public class WpWoocommerceTermmetaJpaController implements Serializable {

    public WpWoocommerceTermmetaJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(WpWoocommerceTermmeta wpWoocommerceTermmeta) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(wpWoocommerceTermmeta);
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

    public void edit(WpWoocommerceTermmeta wpWoocommerceTermmeta) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            wpWoocommerceTermmeta = em.merge(wpWoocommerceTermmeta);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = wpWoocommerceTermmeta.getMetaId();
                if (findWpWoocommerceTermmeta(id) == null) {
                    throw new NonexistentEntityException("The wpWoocommerceTermmeta with id " + id + " no longer exists.");
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
            WpWoocommerceTermmeta wpWoocommerceTermmeta;
            try {
                wpWoocommerceTermmeta = em.getReference(WpWoocommerceTermmeta.class, id);
                wpWoocommerceTermmeta.getMetaId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The wpWoocommerceTermmeta with id " + id + " no longer exists.", enfe);
            }
            em.remove(wpWoocommerceTermmeta);
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

    public List<WpWoocommerceTermmeta> findWpWoocommerceTermmetaEntities() {
        return findWpWoocommerceTermmetaEntities(true, -1, -1);
    }

    public List<WpWoocommerceTermmeta> findWpWoocommerceTermmetaEntities(int maxResults, int firstResult) {
        return findWpWoocommerceTermmetaEntities(false, maxResults, firstResult);
    }

    private List<WpWoocommerceTermmeta> findWpWoocommerceTermmetaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(WpWoocommerceTermmeta.class));
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

    public WpWoocommerceTermmeta findWpWoocommerceTermmeta(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(WpWoocommerceTermmeta.class, id);
        } finally {
            em.close();
        }
    }

    public int getWpWoocommerceTermmetaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<WpWoocommerceTermmeta> rt = cq.from(WpWoocommerceTermmeta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
