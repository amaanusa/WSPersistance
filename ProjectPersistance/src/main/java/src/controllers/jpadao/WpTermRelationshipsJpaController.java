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
import src.entities.WpTermRelationships;
import src.entities.WpTermRelationshipsPK;

/**
 *
 * @author imranadmin
 */
public class WpTermRelationshipsJpaController implements Serializable {

    public WpTermRelationshipsJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(WpTermRelationships wpTermRelationships) throws PreexistingEntityException, RollbackFailureException, Exception {
        if (wpTermRelationships.getWpTermRelationshipsPK() == null) {
            wpTermRelationships.setWpTermRelationshipsPK(new WpTermRelationshipsPK());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(wpTermRelationships);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findWpTermRelationships(wpTermRelationships.getWpTermRelationshipsPK()) != null) {
                throw new PreexistingEntityException("WpTermRelationships " + wpTermRelationships + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(WpTermRelationships wpTermRelationships) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            wpTermRelationships = em.merge(wpTermRelationships);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                WpTermRelationshipsPK id = wpTermRelationships.getWpTermRelationshipsPK();
                if (findWpTermRelationships(id) == null) {
                    throw new NonexistentEntityException("The wpTermRelationships with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(WpTermRelationshipsPK id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            WpTermRelationships wpTermRelationships;
            try {
                wpTermRelationships = em.getReference(WpTermRelationships.class, id);
                wpTermRelationships.getWpTermRelationshipsPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The wpTermRelationships with id " + id + " no longer exists.", enfe);
            }
            em.remove(wpTermRelationships);
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

    public List<WpTermRelationships> findWpTermRelationshipsEntities() {
        return findWpTermRelationshipsEntities(true, -1, -1);
    }

    public List<WpTermRelationships> findWpTermRelationshipsEntities(int maxResults, int firstResult) {
        return findWpTermRelationshipsEntities(false, maxResults, firstResult);
    }

    private List<WpTermRelationships> findWpTermRelationshipsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(WpTermRelationships.class));
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

    public WpTermRelationships findWpTermRelationships(WpTermRelationshipsPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(WpTermRelationships.class, id);
        } finally {
            em.close();
        }
    }

    public int getWpTermRelationshipsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<WpTermRelationships> rt = cq.from(WpTermRelationships.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
