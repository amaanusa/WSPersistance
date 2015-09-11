/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author imranadmin
 */
@Entity
@Table(name = "wp_term_taxonomy", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"term_id", "taxonomy"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WpTermTaxonomy.findAll", query = "SELECT w FROM WpTermTaxonomy w"),
    @NamedQuery(name = "WpTermTaxonomy.findByTermTaxonomyId", query = "SELECT w FROM WpTermTaxonomy w WHERE w.termTaxonomyId = :termTaxonomyId"),
    @NamedQuery(name = "WpTermTaxonomy.findByTermId", query = "SELECT w FROM WpTermTaxonomy w WHERE w.termId = :termId"),
    @NamedQuery(name = "WpTermTaxonomy.findByTaxonomy", query = "SELECT w FROM WpTermTaxonomy w WHERE w.taxonomy = :taxonomy"),
    @NamedQuery(name = "WpTermTaxonomy.findByParent", query = "SELECT w FROM WpTermTaxonomy w WHERE w.parent = :parent"),
    @NamedQuery(name = "WpTermTaxonomy.findByCount", query = "SELECT w FROM WpTermTaxonomy w WHERE w.count = :count")})
public class WpTermTaxonomy implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "term_taxonomy_id", nullable = false)
    private Long termTaxonomyId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "term_id", nullable = false)
    private long termId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(nullable = false, length = 32)
    private String taxonomy;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(nullable = false, length = 2147483647)
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private long parent;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private long count;

    public WpTermTaxonomy() {
    }

    public WpTermTaxonomy(Long termTaxonomyId) {
        this.termTaxonomyId = termTaxonomyId;
    }

    public WpTermTaxonomy(Long termTaxonomyId, long termId, String taxonomy, String description, long parent, long count) {
        this.termTaxonomyId = termTaxonomyId;
        this.termId = termId;
        this.taxonomy = taxonomy;
        this.description = description;
        this.parent = parent;
        this.count = count;
    }

    public Long getTermTaxonomyId() {
        return termTaxonomyId;
    }

    public void setTermTaxonomyId(Long termTaxonomyId) {
        this.termTaxonomyId = termTaxonomyId;
    }

    public long getTermId() {
        return termId;
    }

    public void setTermId(long termId) {
        this.termId = termId;
    }

    public String getTaxonomy() {
        return taxonomy;
    }

    public void setTaxonomy(String taxonomy) {
        this.taxonomy = taxonomy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getParent() {
        return parent;
    }

    public void setParent(long parent) {
        this.parent = parent;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (termTaxonomyId != null ? termTaxonomyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WpTermTaxonomy)) {
            return false;
        }
        WpTermTaxonomy other = (WpTermTaxonomy) object;
        if ((this.termTaxonomyId == null && other.termTaxonomyId != null) || (this.termTaxonomyId != null && !this.termTaxonomyId.equals(other.termTaxonomyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "src.entities.WpTermTaxonomy[ termTaxonomyId=" + termTaxonomyId + " ]";
    }
    
}
