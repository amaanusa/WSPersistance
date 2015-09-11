/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author imranadmin
 */
@Entity
@Table(name = "wp_term_relationships")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WpTermRelationships.findAll", query = "SELECT w FROM WpTermRelationships w"),
    @NamedQuery(name = "WpTermRelationships.findByObjectId", query = "SELECT w FROM WpTermRelationships w WHERE w.wpTermRelationshipsPK.objectId = :objectId"),
    @NamedQuery(name = "WpTermRelationships.findByTermTaxonomyId", query = "SELECT w FROM WpTermRelationships w WHERE w.wpTermRelationshipsPK.termTaxonomyId = :termTaxonomyId"),
    @NamedQuery(name = "WpTermRelationships.findByTermOrder", query = "SELECT w FROM WpTermRelationships w WHERE w.termOrder = :termOrder")})
public class WpTermRelationships implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected WpTermRelationshipsPK wpTermRelationshipsPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "term_order", nullable = false)
    private int termOrder;

    public WpTermRelationships() {
    }

    public WpTermRelationships(WpTermRelationshipsPK wpTermRelationshipsPK) {
        this.wpTermRelationshipsPK = wpTermRelationshipsPK;
    }

    public WpTermRelationships(WpTermRelationshipsPK wpTermRelationshipsPK, int termOrder) {
        this.wpTermRelationshipsPK = wpTermRelationshipsPK;
        this.termOrder = termOrder;
    }

    public WpTermRelationships(long objectId, long termTaxonomyId) {
        this.wpTermRelationshipsPK = new WpTermRelationshipsPK(objectId, termTaxonomyId);
    }

    public WpTermRelationshipsPK getWpTermRelationshipsPK() {
        return wpTermRelationshipsPK;
    }

    public void setWpTermRelationshipsPK(WpTermRelationshipsPK wpTermRelationshipsPK) {
        this.wpTermRelationshipsPK = wpTermRelationshipsPK;
    }

    public int getTermOrder() {
        return termOrder;
    }

    public void setTermOrder(int termOrder) {
        this.termOrder = termOrder;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (wpTermRelationshipsPK != null ? wpTermRelationshipsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WpTermRelationships)) {
            return false;
        }
        WpTermRelationships other = (WpTermRelationships) object;
        if ((this.wpTermRelationshipsPK == null && other.wpTermRelationshipsPK != null) || (this.wpTermRelationshipsPK != null && !this.wpTermRelationshipsPK.equals(other.wpTermRelationshipsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "src.entities.WpTermRelationships[ wpTermRelationshipsPK=" + wpTermRelationshipsPK + " ]";
    }
    
}
