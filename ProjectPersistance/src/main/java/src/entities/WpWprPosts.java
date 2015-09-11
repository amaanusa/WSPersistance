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
@Table(name = "wp_wpr_posts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WpWprPosts.findAll", query = "SELECT w FROM WpWprPosts w"),
    @NamedQuery(name = "WpWprPosts.findById", query = "SELECT w FROM WpWprPosts w WHERE w.id = :id"),
    @NamedQuery(name = "WpWprPosts.findByCampaign", query = "SELECT w FROM WpWprPosts w WHERE w.campaign = :campaign"),
    @NamedQuery(name = "WpWprPosts.findByKeyword", query = "SELECT w FROM WpWprPosts w WHERE w.keyword = :keyword"),
    @NamedQuery(name = "WpWprPosts.findByModule", query = "SELECT w FROM WpWprPosts w WHERE w.module = :module"),
    @NamedQuery(name = "WpWprPosts.findByTime", query = "SELECT w FROM WpWprPosts w WHERE w.time = :time")})
public class WpWprPosts implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private long campaign;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(nullable = false, length = 255)
    private String keyword;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(nullable = false, length = 255)
    private String module;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "unique_id", nullable = false, length = 2147483647)
    private String uniqueId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(nullable = false, length = 255)
    private String time;

    public WpWprPosts() {
    }

    public WpWprPosts(Long id) {
        this.id = id;
    }

    public WpWprPosts(Long id, long campaign, String keyword, String module, String uniqueId, String time) {
        this.id = id;
        this.campaign = campaign;
        this.keyword = keyword;
        this.module = module;
        this.uniqueId = uniqueId;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getCampaign() {
        return campaign;
    }

    public void setCampaign(long campaign) {
        this.campaign = campaign;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WpWprPosts)) {
            return false;
        }
        WpWprPosts other = (WpWprPosts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "src.entities.WpWprPosts[ id=" + id + " ]";
    }
    
}
