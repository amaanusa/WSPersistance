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
@Table(name = "wp_layerslider")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WpLayerslider.findAll", query = "SELECT w FROM WpLayerslider w"),
    @NamedQuery(name = "WpLayerslider.findById", query = "SELECT w FROM WpLayerslider w WHERE w.id = :id"),
    @NamedQuery(name = "WpLayerslider.findByName", query = "SELECT w FROM WpLayerslider w WHERE w.name = :name"),
    @NamedQuery(name = "WpLayerslider.findByDateC", query = "SELECT w FROM WpLayerslider w WHERE w.dateC = :dateC"),
    @NamedQuery(name = "WpLayerslider.findByDateM", query = "SELECT w FROM WpLayerslider w WHERE w.dateM = :dateM"),
    @NamedQuery(name = "WpLayerslider.findByFlagHidden", query = "SELECT w FROM WpLayerslider w WHERE w.flagHidden = :flagHidden"),
    @NamedQuery(name = "WpLayerslider.findByFlagDeleted", query = "SELECT w FROM WpLayerslider w WHERE w.flagDeleted = :flagDeleted")})
public class WpLayerslider implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(nullable = false, length = 100)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 16777215)
    @Column(nullable = false, length = 16777215)
    private String data;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_c", nullable = false)
    private int dateC;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_m", nullable = false)
    private int dateM;
    @Basic(optional = false)
    @NotNull
    @Column(name = "flag_hidden", nullable = false)
    private boolean flagHidden;
    @Basic(optional = false)
    @NotNull
    @Column(name = "flag_deleted", nullable = false)
    private boolean flagDeleted;

    public WpLayerslider() {
    }

    public WpLayerslider(Integer id) {
        this.id = id;
    }

    public WpLayerslider(Integer id, String name, String data, int dateC, int dateM, boolean flagHidden, boolean flagDeleted) {
        this.id = id;
        this.name = name;
        this.data = data;
        this.dateC = dateC;
        this.dateM = dateM;
        this.flagHidden = flagHidden;
        this.flagDeleted = flagDeleted;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getDateC() {
        return dateC;
    }

    public void setDateC(int dateC) {
        this.dateC = dateC;
    }

    public int getDateM() {
        return dateM;
    }

    public void setDateM(int dateM) {
        this.dateM = dateM;
    }

    public boolean getFlagHidden() {
        return flagHidden;
    }

    public void setFlagHidden(boolean flagHidden) {
        this.flagHidden = flagHidden;
    }

    public boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
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
        if (!(object instanceof WpLayerslider)) {
            return false;
        }
        WpLayerslider other = (WpLayerslider) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "src.entities.WpLayerslider[ id=" + id + " ]";
    }
    
}
