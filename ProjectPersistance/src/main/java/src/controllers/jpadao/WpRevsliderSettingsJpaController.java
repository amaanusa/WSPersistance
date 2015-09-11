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
import src.entities.WpRevsliderSettings;

/**
 *
 * @author imranadmin
 */
public class WpRevsliderSettingsJpaController implements Serializable {

    public WpRevsliderSettingsJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(WpRevsliderSettings wpRevsliderSettings) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(wpRevsliderSettings);
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

    public void edit(WpRevsliderSettings wpRevsliderSettings) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            wpRevsliderSettings = em.merge(wpRevsliderSettings);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = wpRevsliderSettings.getId();
                if (findWpRevsliderSettings(id) == null) {
                    throw new NonexistentEntityException("The wpRevsliderSettings with id " + id + " no longer exists.");
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
            WpRevsliderSettings wpRevsliderSettings;
            try {
                wpRevsliderSettings = em.getReference(WpRevsliderSettings.class, id);
                wpRevsliderSettings.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The wpRevsliderSettings with id " + id + " no longer exists.", enfe);
            }
            em.remove(wpRevsliderSettings);
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

    public List<WpRevsliderSettings> findWpRevsliderSettingsEntities() {
        return findWpRevsliderSettingsEntities(true, -1, -1);
    }

    public List<WpRevsliderSettings> findWpRevsliderSettingsEntities(int maxResults, int firstResult) {
        return findWpRevsliderSettingsEntities(false, maxResults, firstResult);
    }

    private List<WpRevsliderSettings> findWpRevsliderSettingsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(WpRevsliderSettings.class));
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

    public WpRevsliderSettings findWpRevsliderSettings(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(WpRevsliderSettings.class, id);
        } finally {
            em.close();
        }
    }

    public int getWpRevsliderSettingsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<WpRevsliderSettings> rt = cq.from(WpRevsliderSettings.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
