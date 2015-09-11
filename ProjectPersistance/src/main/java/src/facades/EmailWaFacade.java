/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import src.entities.EmailWa;

/**
 *
 * @author imranadmin
 */
@Stateless
public class EmailWaFacade extends AbstractFacade<EmailWa> {
    @PersistenceContext(unitName = "com.wsdataPersistance.src_ProjectPersistance_ejb_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmailWaFacade() {
        super(EmailWa.class);
    }
    
}
