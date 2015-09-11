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
import src.entities.WpWoocommerceTaxRates;

/**
 *
 * @author imranadmin
 */
public class WpWoocommerceTaxRatesJpaController implements Serializable {

    public WpWoocommerceTaxRatesJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(WpWoocommerceTaxRates wpWoocommerceTaxRates) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(wpWoocommerceTaxRates);
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

    public void edit(WpWoocommerceTaxRates wpWoocommerceTaxRates) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            wpWoocommerceTaxRates = em.merge(wpWoocommerceTaxRates);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = wpWoocommerceTaxRates.getTaxRateId();
                if (findWpWoocommerceTaxRates(id) == null) {
                    throw new NonexistentEntityException("The wpWoocommerceTaxRates with id " + id + " no longer exists.");
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
            WpWoocommerceTaxRates wpWoocommerceTaxRates;
            try {
                wpWoocommerceTaxRates = em.getReference(WpWoocommerceTaxRates.class, id);
                wpWoocommerceTaxRates.getTaxRateId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The wpWoocommerceTaxRates with id " + id + " no longer exists.", enfe);
            }
            em.remove(wpWoocommerceTaxRates);
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

    public List<WpWoocommerceTaxRates> findWpWoocommerceTaxRatesEntities() {
        return findWpWoocommerceTaxRatesEntities(true, -1, -1);
    }

    public List<WpWoocommerceTaxRates> findWpWoocommerceTaxRatesEntities(int maxResults, int firstResult) {
        return findWpWoocommerceTaxRatesEntities(false, maxResults, firstResult);
    }

    private List<WpWoocommerceTaxRates> findWpWoocommerceTaxRatesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(WpWoocommerceTaxRates.class));
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

    public WpWoocommerceTaxRates findWpWoocommerceTaxRates(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(WpWoocommerceTaxRates.class, id);
        } finally {
            em.close();
        }
    }

    public int getWpWoocommerceTaxRatesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<WpWoocommerceTaxRates> rt = cq.from(WpWoocommerceTaxRates.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
