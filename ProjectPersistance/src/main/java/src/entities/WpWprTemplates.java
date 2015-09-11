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
@Table(name = "wp_wpr_templates")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WpWprTemplates.findAll", query = "SELECT w FROM WpWprTemplates w"),
    @NamedQuery(name = "WpWprTemplates.findById", query = "SELECT w FROM WpWprTemplates w WHERE w.id = :id"),
    @NamedQuery(name = "WpWprTemplates.findByType", query = "SELECT w FROM WpWprTemplates w WHERE w.type = :type"),
    @NamedQuery(name = "WpWprTemplates.findByTypenum", query = "SELECT w FROM WpWprTemplates w WHERE w.typenum = :typenum"),
    @NamedQuery(name = "WpWprTemplates.findByCommentsAmazon", query = "SELECT w FROM WpWprTemplates w WHERE w.commentsAmazon = :commentsAmazon"),
    @NamedQuery(name = "WpWprTemplates.findByCommentsFlickr", query = "SELECT w FROM WpWprTemplates w WHERE w.commentsFlickr = :commentsFlickr"),
    @NamedQuery(name = "WpWprTemplates.findByCommentsYahoo", query = "SELECT w FROM WpWprTemplates w WHERE w.commentsYahoo = :commentsYahoo"),
    @NamedQuery(name = "WpWprTemplates.findByCommentsYoutube", query = "SELECT w FROM WpWprTemplates w WHERE w.commentsYoutube = :commentsYoutube"),
    @NamedQuery(name = "WpWprTemplates.findByName", query = "SELECT w FROM WpWprTemplates w WHERE w.name = :name")})
public class WpWprTemplates implements Serializable {
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
    private String type;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int typenum;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(nullable = false, length = 2147483647)
    private String content;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(nullable = false, length = 2147483647)
    private String title;
    @Basic(optional = false)
    @NotNull
    @Column(name = "comments_amazon", nullable = false)
    private int commentsAmazon;
    @Basic(optional = false)
    @NotNull
    @Column(name = "comments_flickr", nullable = false)
    private int commentsFlickr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "comments_yahoo", nullable = false)
    private int commentsYahoo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "comments_youtube", nullable = false)
    private int commentsYoutube;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(nullable = false, length = 255)
    private String name;

    public WpWprTemplates() {
    }

    public WpWprTemplates(Long id) {
        this.id = id;
    }

    public WpWprTemplates(Long id, String type, int typenum, String content, String title, int commentsAmazon, int commentsFlickr, int commentsYahoo, int commentsYoutube, String name) {
        this.id = id;
        this.type = type;
        this.typenum = typenum;
        this.content = content;
        this.title = title;
        this.commentsAmazon = commentsAmazon;
        this.commentsFlickr = commentsFlickr;
        this.commentsYahoo = commentsYahoo;
        this.commentsYoutube = commentsYoutube;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTypenum() {
        return typenum;
    }

    public void setTypenum(int typenum) {
        this.typenum = typenum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCommentsAmazon() {
        return commentsAmazon;
    }

    public void setCommentsAmazon(int commentsAmazon) {
        this.commentsAmazon = commentsAmazon;
    }

    public int getCommentsFlickr() {
        return commentsFlickr;
    }

    public void setCommentsFlickr(int commentsFlickr) {
        this.commentsFlickr = commentsFlickr;
    }

    public int getCommentsYahoo() {
        return commentsYahoo;
    }

    public void setCommentsYahoo(int commentsYahoo) {
        this.commentsYahoo = commentsYahoo;
    }

    public int getCommentsYoutube() {
        return commentsYoutube;
    }

    public void setCommentsYoutube(int commentsYoutube) {
        this.commentsYoutube = commentsYoutube;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        if (!(object instanceof WpWprTemplates)) {
            return false;
        }
        WpWprTemplates other = (WpWprTemplates) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "src.entities.WpWprTemplates[ id=" + id + " ]";
    }
    
}
