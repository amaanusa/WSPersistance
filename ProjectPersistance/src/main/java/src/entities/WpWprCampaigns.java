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
@Table(name = "wp_wpr_campaigns")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WpWprCampaigns.findAll", query = "SELECT w FROM WpWprCampaigns w"),
    @NamedQuery(name = "WpWprCampaigns.findById", query = "SELECT w FROM WpWprCampaigns w WHERE w.id = :id"),
    @NamedQuery(name = "WpWprCampaigns.findByName", query = "SELECT w FROM WpWprCampaigns w WHERE w.name = :name"),
    @NamedQuery(name = "WpWprCampaigns.findByCtype", query = "SELECT w FROM WpWprCampaigns w WHERE w.ctype = :ctype"),
    @NamedQuery(name = "WpWprCampaigns.findByCinterval", query = "SELECT w FROM WpWprCampaigns w WHERE w.cinterval = :cinterval"),
    @NamedQuery(name = "WpWprCampaigns.findByPeriod", query = "SELECT w FROM WpWprCampaigns w WHERE w.period = :period"),
    @NamedQuery(name = "WpWprCampaigns.findByPostspan", query = "SELECT w FROM WpWprCampaigns w WHERE w.postspan = :postspan"),
    @NamedQuery(name = "WpWprCampaigns.findByAmazonDepartment", query = "SELECT w FROM WpWprCampaigns w WHERE w.amazonDepartment = :amazonDepartment"),
    @NamedQuery(name = "WpWprCampaigns.findByEbayCat", query = "SELECT w FROM WpWprCampaigns w WHERE w.ebayCat = :ebayCat"),
    @NamedQuery(name = "WpWprCampaigns.findByYahooCat", query = "SELECT w FROM WpWprCampaigns w WHERE w.yahooCat = :yahooCat"),
    @NamedQuery(name = "WpWprCampaigns.findByTranslation", query = "SELECT w FROM WpWprCampaigns w WHERE w.translation = :translation"),
    @NamedQuery(name = "WpWprCampaigns.findByPostsCreated", query = "SELECT w FROM WpWprCampaigns w WHERE w.postsCreated = :postsCreated"),
    @NamedQuery(name = "WpWprCampaigns.findByPause", query = "SELECT w FROM WpWprCampaigns w WHERE w.pause = :pause")})
public class WpWprCampaigns implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(nullable = false, length = 255)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(nullable = false, length = 255)
    private String ctype;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(nullable = false, length = 2147483647)
    private String keywords;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(nullable = false, length = 2147483647)
    private String categories;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(nullable = false, length = 2147483647)
    private String templates;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private long cinterval;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(nullable = false, length = 255)
    private String period;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(nullable = false, length = 255)
    private String postspan;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(nullable = false, length = 2147483647)
    private String replacekws;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(nullable = false, length = 2147483647)
    private String excludekws;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "amazon_department", nullable = false, length = 255)
    private String amazonDepartment;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ebay_cat", nullable = false, length = 255)
    private String ebayCat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "yahoo_cat", nullable = false, length = 255)
    private String yahooCat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(nullable = false, length = 255)
    private String translation;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(nullable = false, length = 2147483647)
    private String customfield;
    @Basic(optional = false)
    @NotNull
    @Column(name = "posts_created", nullable = false)
    private long postsCreated;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int pause;

    public WpWprCampaigns() {
    }

    public WpWprCampaigns(Long id) {
        this.id = id;
    }

    public WpWprCampaigns(Long id, String name, String ctype, String keywords, String categories, String templates, long cinterval, String period, String postspan, String replacekws, String excludekws, String amazonDepartment, String ebayCat, String yahooCat, String translation, String customfield, long postsCreated, int pause) {
        this.id = id;
        this.name = name;
        this.ctype = ctype;
        this.keywords = keywords;
        this.categories = categories;
        this.templates = templates;
        this.cinterval = cinterval;
        this.period = period;
        this.postspan = postspan;
        this.replacekws = replacekws;
        this.excludekws = excludekws;
        this.amazonDepartment = amazonDepartment;
        this.ebayCat = ebayCat;
        this.yahooCat = yahooCat;
        this.translation = translation;
        this.customfield = customfield;
        this.postsCreated = postsCreated;
        this.pause = pause;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getTemplates() {
        return templates;
    }

    public void setTemplates(String templates) {
        this.templates = templates;
    }

    public long getCinterval() {
        return cinterval;
    }

    public void setCinterval(long cinterval) {
        this.cinterval = cinterval;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getPostspan() {
        return postspan;
    }

    public void setPostspan(String postspan) {
        this.postspan = postspan;
    }

    public String getReplacekws() {
        return replacekws;
    }

    public void setReplacekws(String replacekws) {
        this.replacekws = replacekws;
    }

    public String getExcludekws() {
        return excludekws;
    }

    public void setExcludekws(String excludekws) {
        this.excludekws = excludekws;
    }

    public String getAmazonDepartment() {
        return amazonDepartment;
    }

    public void setAmazonDepartment(String amazonDepartment) {
        this.amazonDepartment = amazonDepartment;
    }

    public String getEbayCat() {
        return ebayCat;
    }

    public void setEbayCat(String ebayCat) {
        this.ebayCat = ebayCat;
    }

    public String getYahooCat() {
        return yahooCat;
    }

    public void setYahooCat(String yahooCat) {
        this.yahooCat = yahooCat;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getCustomfield() {
        return customfield;
    }

    public void setCustomfield(String customfield) {
        this.customfield = customfield;
    }

    public long getPostsCreated() {
        return postsCreated;
    }

    public void setPostsCreated(long postsCreated) {
        this.postsCreated = postsCreated;
    }

    public int getPause() {
        return pause;
    }

    public void setPause(int pause) {
        this.pause = pause;
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
        if (!(object instanceof WpWprCampaigns)) {
            return false;
        }
        WpWprCampaigns other = (WpWprCampaigns) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "src.entities.WpWprCampaigns[ id=" + id + " ]";
    }
    
}
