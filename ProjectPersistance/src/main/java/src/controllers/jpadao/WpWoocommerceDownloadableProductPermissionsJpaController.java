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
import src.entities.WpWoocommerceDownloadableProductPermissions;
import src.entities.WpWoocommerceDownloadableProductPermissionsPK;

/**
 *
 * @author imranadmin
 */
public class WpWoocommerceDownloadableProductPermissionsJpaController implements Serializable {

    public WpWoocommerceDownloadableProductPermissionsJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(WpWoocommerceDownloadableProductPermissions wpWoocommerceDownloadableProductPermissions) throws PreexistingEntityException, RollbackFailureException, Exception {
        if (wpWoocommerceDownloadableProductPermissions.getWpWoocommerceDownloadableProductPermissionsPK() == null) {
            wpWoocommerceDownloadableProductPermissions.setWpWoocommerceDownloadableProductPermissionsPK(new WpWoocommerceDownloadableProductPermissionsPK());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(wpWoocommerceDownloadableProductPermissions);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findWpWoocommerceDownloadableProductPermissions(wpWoocommerceDownloadableProductPermissions.getWpWoocommerceDownloadableProductPermissionsPK()) != null) {
                throw new PreexistingEntityException("WpWoocommerceDownloadableProductPermissions " + wpWoocommerceDownloadableProductPermissions + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(WpWoocommerceDownloadableProductPermissions wpWoocommerceDownloadableProductPermissions) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            wpWoocommerceDownloadableProductPermissions = em.merge(wpWoocommerceDownloadableProductPermissions);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                WpWoocommerceDownloadableProductPermissionsPK id = wpWoocommerceDownloadableProductPermissions.getWpWoocommerceDownloadableProductPermissionsPK();
                if (findWpWoocommerceDownloadableProductPermissions(id) == null) {
                    throw new NonexistentEntityException("The wpWoocommerceDownloadableProductPermissions with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(WpWoocommerceDownloadableProductPermissionsPK id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            WpWoocommerceDownloadableProductPermissions wpWoocommerceDownloadableProductPermissions;
            try {
                wpWoocommerceDownloadableProductPermissions = em.getReference(WpWoocommerceDownloadableProductPermissions.class, id);
                wpWoocommerceDownloadableProductPermissions.getWpWoocommerceDownloadableProductPermissionsPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The wpWoocommerceDownloadableProductPermissions with id " + id + " no longer exists.", enfe);
            }
            em.remove(wpWoocommerceDownloadableProductPermissions);
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

    public List<WpWoocommerceDownloadableProductPermissions> findWpWoocommerceDownloadableProductPermissionsEntities() {
        return findWpWoocommerceDownloadableProductPermissionsEntities(true, -1, -1);
    }

    public List<WpWoocommerceDownloadableProductPermissions> findWpWoocommerceDownloadableProductPermissionsEntities(int maxResults, int firstResult) {
        return findWpWoocommerceDownloadableProductPermissionsEntities(false, maxResults, firstResult);
    }

    private List<WpWoocommerceDownloadableProductPermissions> findWpWoocommerceDownloadableProductPermissionsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(WpWoocommerceDownloadableProductPermissions.class));
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

    public WpWoocommerceDownloadableProductPermissions findWpWoocommerceDownloadableProductPermissions(WpWoocommerceDownloadableProductPermissionsPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(WpWoocommerceDownloadableProductPermissions.class, id);
        } finally {
            em.close();
        }
    }

    public int getWpWoocommerceDownloadableProductPermissionsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<WpWoocommerceDownloadableProductPermissions> rt = cq.from(WpWoocommerceDownloadableProductPermissions.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
