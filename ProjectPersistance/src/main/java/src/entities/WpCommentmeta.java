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
@Table(name = "wp_commentmeta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WpCommentmeta.findAll", query = "SELECT w FROM WpCommentmeta w"),
    @NamedQuery(name = "WpCommentmeta.findByMetaId", query = "SELECT w FROM WpCommentmeta w WHERE w.metaId = :metaId"),
    @NamedQuery(name = "WpCommentmeta.findByCommentId", query = "SELECT w FROM WpCommentmeta w WHERE w.commentId = :commentId"),
    @NamedQuery(name = "WpCommentmeta.findByMetaKey", query = "SELECT w FROM WpCommentmeta w WHERE w.metaKey = :metaKey")})
public class WpCommentmeta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "meta_id", nullable = false)
    private Long metaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "comment_id", nullable = false)
    private long commentId;
    @Size(max = 255)
    @Column(name = "meta_key", length = 255)
    private String metaKey;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "meta_value", length = 2147483647)
    private String metaValue;

    public WpCommentmeta() {
    }

    public WpCommentmeta(Long metaId) {
        this.metaId = metaId;
    }

    public WpCommentmeta(Long metaId, long commentId) {
        this.metaId = metaId;
        this.commentId = commentId;
    }

    public Long getMetaId() {
        return metaId;
    }

    public void setMetaId(Long metaId) {
        this.metaId = metaId;
    }

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
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
        if (!(object instanceof WpCommentmeta)) {
            return false;
        }
        WpCommentmeta other = (WpCommentmeta) object;
        if ((this.metaId == null && other.metaId != null) || (this.metaId != null && !this.metaId.equals(other.metaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "src.entities.WpCommentmeta[ metaId=" + metaId + " ]";
    }
    
}
