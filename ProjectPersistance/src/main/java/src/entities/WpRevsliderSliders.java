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
@Table(name = "wp_revslider_sliders")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WpRevsliderSliders.findAll", query = "SELECT w FROM WpRevsliderSliders w"),
    @NamedQuery(name = "WpRevsliderSliders.findById", query = "SELECT w FROM WpRevsliderSliders w WHERE w.id = :id"),
    @NamedQuery(name = "WpRevsliderSliders.findByTitle", query = "SELECT w FROM WpRevsliderSliders w WHERE w.title = :title"),
    @NamedQuery(name = "WpRevsliderSliders.findByAlias", query = "SELECT w FROM WpRevsliderSliders w WHERE w.alias = :alias")})
public class WpRevsliderSliders implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(nullable = false, length = 255)
    private String title;
    @Size(max = 255)
    @Column(length = 255)
    private String alias;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(nullable = false, length = 65535)
    private String params;

    public WpRevsliderSliders() {
    }

    public WpRevsliderSliders(Integer id) {
        this.id = id;
    }

    public WpRevsliderSliders(Integer id, String title, String params) {
        this.id = id;
        this.title = title;
        this.params = params;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
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
        if (!(object instanceof WpRevsliderSliders)) {
            return false;
        }
        WpRevsliderSliders other = (WpRevsliderSliders) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "src.entities.WpRevsliderSliders[ id=" + id + " ]";
    }
    
}
