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
import src.entities.WpWprCampaigns;

/**
 *
 * @author imranadmin
 */
public class WpWprCampaignsJpaController implements Serializable {

    public WpWprCampaignsJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(WpWprCampaigns wpWprCampaigns) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(wpWprCampaigns);
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

    public void edit(WpWprCampaigns wpWprCampaigns) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            wpWprCampaigns = em.merge(wpWprCampaigns);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = wpWprCampaigns.getId();
                if (findWpWprCampaigns(id) == null) {
                    throw new NonexistentEntityException("The wpWprCampaigns with id " + id + " no longer exists.");
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
            WpWprCampaigns wpWprCampaigns;
            try {
                wpWprCampaigns = em.getReference(WpWprCampaigns.class, id);
                wpWprCampaigns.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The wpWprCampaigns with id " + id + " no longer exists.", enfe);
            }
            em.remove(wpWprCampaigns);
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

    public List<WpWprCampaigns> findWpWprCampaignsEntities() {
        return findWpWprCampaignsEntities(true, -1, -1);
    }

    public List<WpWprCampaigns> findWpWprCampaignsEntities(int maxResults, int firstResult) {
        return findWpWprCampaignsEntities(false, maxResults, firstResult);
    }

    private List<WpWprCampaigns> findWpWprCampaignsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(WpWprCampaigns.class));
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

    public WpWprCampaigns findWpWprCampaigns(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(WpWprCampaigns.class, id);
        } finally {
            em.close();
        }
    }

    public int getWpWprCampaignsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<WpWprCampaigns> rt = cq.from(WpWprCampaigns.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
