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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author imranadmin
 */
@Entity
@Table(name = "wp_woocommerce_termmeta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WpWoocommerceTermmeta.findAll", query = "SELECT w FROM WpWoocommerceTermmeta w"),
    @NamedQuery(name = "WpWoocommerceTermmeta.findByMetaId", query = "SELECT w FROM WpWoocommerceTermmeta w WHERE w.metaId = :metaId"),
    @NamedQuery(name = "WpWoocommerceTermmeta.findByWoocommerceTermId", query = "SELECT w FROM WpWoocommerceTermmeta w WHERE w.woocommerceTermId = :woocommerceTermId"),
    @NamedQuery(name = "WpWoocommerceTermmeta.findByMetaKey", query = "SELECT w FROM WpWoocommerceTermmeta w WHERE w.metaKey = :metaKey")})
public class WpWoocommerceTermmeta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "meta_id", nullable = false)
    private Long metaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "woocommerce_term_id", nullable = false)
    private long woocommerceTermId;
    @Size(max = 255)
    @Column(name = "meta_key", length = 255)
    private String metaKey;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "meta_value", length = 2147483647)
    private String metaValue;

    public WpWoocommerceTermmeta() {
    }

    public WpWoocommerceTermmeta(Long metaId) {
        this.metaId = metaId;
    }

    public WpWoocommerceTermmeta(Long metaId, long woocommerceTermId) {
        this.metaId = metaId;
        this.woocommerceTermId = woocommerceTermId;
    }

    public Long getMetaId() {
        return metaId;
    }

    public void setMetaId(Long metaId) {
        this.metaId = metaId;
    }

    public long getWoocommerceTermId() {
        return woocommerceTermId;
    }

    public void setWoocommerceTermId(long woocommerceTermId) {
        this.woocommerceTermId = woocommerceTermId;
    }

    public String getMetaKey() {
        return metaKey;
    }

    public void setMetaKey(String metaKey) {
        this.metaKey = metaKey;
    }

    public String getMetaValue() {
        return metaValue;
    }

    public void setMetaValue(String metaValue) {
        this.metaValue = metaValue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (metaId != null ? metaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WpWoocommerceTermmeta)) {
            return false;
        }
        WpWoocommerceTermmeta other = (WpWoocommerceTermmeta) object;
        if ((this.metaId == null && other.metaId != null) || (this.metaId != null && !this.metaId.equals(other.metaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "src.entities.WpWoocommerceTermmeta[ metaId=" + metaId + " ]";
    }
    
}
