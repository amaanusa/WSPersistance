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
@Table(name = "wp_revslider_slides")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WpRevsliderSlides.findAll", query = "SELECT w FROM WpRevsliderSlides w"),
    @NamedQuery(name = "WpRevsliderSlides.findById", query = "SELECT w FROM WpRevsliderSlides w WHERE w.id = :id"),
    @NamedQuery(name = "WpRevsliderSlides.findBySliderId", query = "SELECT w FROM WpRevsliderSlides w WHERE w.sliderId = :sliderId"),
    @NamedQuery(name = "WpRevsliderSlides.findBySlideOrder", query = "SELECT w FROM WpRevsliderSlides w WHERE w.slideOrder = :slideOrder")})
public class WpRevsliderSlides implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "slider_id", nullable = false)
    private int sliderId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "slide_order", nullable = false)
    private int slideOrder;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(nullable = false, length = 65535)
    private String params;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(nullable = false, length = 65535)
    private String layers;

    public WpRevsliderSlides() {
    }

    public WpRevsliderSlides(Integer id) {
        this.id = id;
    }

    public WpRevsliderSlides(Integer id, int sliderId, int slideOrder, String params, String layers) {
        this.id = id;
        this.sliderId = sliderId;
        this.slideOrder = slideOrder;
        this.params = params;
        this.layers = layers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSliderId() {
        return sliderId;
    }

    public void setSliderId(int sliderId) {
        this.sliderId = sliderId;
    }

    public int getSlideOrder() {
        return slideOrder;
    }

    public void setSlideOrder(int slideOrder) {
        this.slideOrder = slideOrder;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getLayers() {
        return layers;
    }

    public void setLayers(String layers) {
        this.layers = layers;
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
        if (!(object instanceof WpRevsliderSlides)) {
            return false;
        }
        WpRevsliderSlides other = (WpRevsliderSlides) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "src.entities.WpRevsliderSlides[ id=" + id + " ]";
    }
    
}
