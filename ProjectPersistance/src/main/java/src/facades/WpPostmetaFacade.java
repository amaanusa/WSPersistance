/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import src.entities.WpPostmeta;

/**
 *
 * @author imranadmin
 */
@Stateless
public class WpPostmetaFacade extends AbstractFacade<WpPostmeta> {
    @PersistenceContext(unitName = "com.wsdataPersistance.src_ProjectPersistance_ejb_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WpPostmetaFacade() {
        super(WpPostmeta.class);
    }
    
}
