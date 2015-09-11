/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author imranadmin
 */
@Entity
@Table(name = "wp_links")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WpLinks.findAll", query = "SELECT w FROM WpLinks w"),
    @NamedQuery(name = "WpLinks.findByLinkId", query = "SELECT w FROM WpLinks w WHERE w.linkId = :linkId"),
    @NamedQuery(name = "WpLinks.findByLinkUrl", query = "SELECT w FROM WpLinks w WHERE w.linkUrl = :linkUrl"),
    @NamedQuery(name = "WpLinks.findByLinkName", query = "SELECT w FROM WpLinks w WHERE w.linkName = :linkName"),
    @NamedQuery(name = "WpLinks.findByLinkImage", query = "SELECT w FROM WpLinks w WHERE w.linkImage = :linkImage"),
    @NamedQuery(name = "WpLinks.findByLinkTarget", query = "SELECT w FROM WpLinks w WHERE w.linkTarget = :linkTarget"),
    @NamedQuery(name = "WpLinks.findByLinkDescription", query = "SELECT w FROM WpLinks w WHERE w.linkDescription = :linkDescription"),
    @NamedQuery(name = "WpLinks.findByLinkVisible", query = "SELECT w FROM WpLinks w WHERE w.linkVisible = :linkVisible"),
    @NamedQuery(name = "WpLinks.findByLinkOwner", query = "SELECT w FROM WpLinks w WHERE w.linkOwner = :linkOwner"),
    @NamedQuery(name = "WpLinks.findByLinkRating", query = "SELECT w FROM WpLinks w WHERE w.linkRating = :linkRating"),
    @NamedQuery(name = "WpLinks.findByLinkUpdated", query = "SELECT w FROM WpLinks w WHERE w.linkUpdated = :linkUpdated"),
    @NamedQuery(name = "WpLinks.findByLinkRel", query = "SELECT w FROM WpLinks w WHERE w.linkRel = :linkRel"),
    @NamedQuery(name = "WpLinks.findByLinkRss", query = "SELECT w FROM WpLinks w WHERE w.linkRss = :linkRss")})
public class WpLinks implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "link_id", nullable = false)
    private Long linkId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "link_url", nullable = false, length = 255)
    private String linkUrl;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "link_name", nullable = false, length = 255)
    private String linkName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "link_image", nullable = false, length = 255)
    private String linkImage;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "link_target", nullable = false, length = 25)
    private String linkTarget;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "link_description", nullable = false, length = 255)
    private String linkDescription;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "link_visible", nullable = false, length = 20)
    private String linkVisible;
    @Basic(optional = false)
    @NotNull
    @Column(name = "link_owner", nullable = false)
    private long linkOwner;
    @Basic(optional = false)
    @NotNull
    @Column(name = "link_rating", nullable = false)
    private int linkRating;
    @Basic(optional = false)
    @NotNull
    @Column(name = "link_updated", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date linkUpdated;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "link_rel", nullable = false, length = 255)
    private String linkRel;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 16777215)
    @Column(name = "link_notes", nullable = false, length = 16777215)
    private String linkNotes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "link_rss", nullable = false, length = 255)
    private String linkRss;

    public WpLinks() {
    }

    public WpLinks(Long linkId) {
        this.linkId = linkId;
    }

    public WpLinks(Long linkId, String linkUrl, String linkName, String linkImage, String linkTarget, String linkDescription, String linkVisible, long linkOwner, int linkRating, Date linkUpdated, String linkRel, String linkNotes, String linkRss) {
        this.linkId = linkId;
        this.linkUrl = linkUrl;
        this.linkName = linkName;
        this.linkImage = linkImage;
        this.linkTarget = linkTarget;
        this.linkDescription = linkDescription;
        this.linkVisible = linkVisible;
        this.linkOwner = linkOwner;
        this.linkRating = linkRating;
        this.linkUpdated = linkUpdated;
        this.linkRel = linkRel;
        this.linkNotes = linkNotes;
        this.linkRss = linkRss;
    }

    public Long getLinkId() {
        return linkId;
    }

    public void setLinkId(Long linkId) {
        this.linkId = linkId;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(String linkImage) {
        this.linkImage = linkImage;
    }

    public String getLinkTarget() {
        return linkTarget;
    }

    public void setLinkTarget(String linkTarget) {
        this.linkTarget = linkTarget;
    }

    public String getLinkDescription() {
        return linkDescription;
    }

    public void setLinkDescription(String linkDescription) {
        this.linkDescription = linkDescription;
    }

    public String getLinkVisible() {
        return linkVisible;
    }

    public void setLinkVisible(String linkVisible) {
        this.linkVisible = linkVisible;
    }

    public long getLinkOwner() {
        return linkOwner;
    }

    public void setLinkOwner(long linkOwner) {
        this.linkOwner = linkOwner;
    }

    public int getLinkRating() {
        return linkRating;
    }

    public void setLinkRating(int linkRating) {
        this.linkRating = linkRating;
    }

    public Date getLinkUpdated() {
        return linkUpdated;
    }

    public void setLinkUpdated(Date linkUpdated) {
        this.linkUpdated = linkUpdated;
    }

    public String getLinkRel() {
        return linkRel;
    }

    public void setLinkRel(String linkRel) {
        this.linkRel = linkRel;
    }

    public String getLinkNotes() {
        return linkNotes;
    }

    public void setLinkNotes(String linkNotes) {
        this.linkNotes = linkNotes;
    }

    public String getLinkRss() {
        return linkRss;
    }

    public void setLinkRss(String linkRss) {
        this.linkRss = linkRss;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (linkId != null ? linkId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WpLinks)) {
            return false;
        }
        WpLinks other = (WpLinks) object;
        if ((this.linkId == null && other.linkId != null) || (this.linkId != null && !this.linkId.equals(other.linkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "src.entities.WpLinks[ linkId=" + linkId + " ]";
    }
    
}
