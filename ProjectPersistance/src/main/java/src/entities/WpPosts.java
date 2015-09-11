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
@Table(name = "wp_posts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WpPosts.findAll", query = "SELECT w FROM WpPosts w"),
    @NamedQuery(name = "WpPosts.findById", query = "SELECT w FROM WpPosts w WHERE w.id = :id"),
    @NamedQuery(name = "WpPosts.findByPostAuthor", query = "SELECT w FROM WpPosts w WHERE w.postAuthor = :postAuthor"),
    @NamedQuery(name = "WpPosts.findByPostDate", query = "SELECT w FROM WpPosts w WHERE w.postDate = :postDate"),
    @NamedQuery(name = "WpPosts.findByPostDateGmt", query = "SELECT w FROM WpPosts w WHERE w.postDateGmt = :postDateGmt"),
    @NamedQuery(name = "WpPosts.findByPostStatus", query = "SELECT w FROM WpPosts w WHERE w.postStatus = :postStatus"),
    @NamedQuery(name = "WpPosts.findByCommentStatus", query = "SELECT w FROM WpPosts w WHERE w.commentStatus = :commentStatus"),
    @NamedQuery(name = "WpPosts.findByPingStatus", query = "SELECT w FROM WpPosts w WHERE w.pingStatus = :pingStatus"),
    @NamedQuery(name = "WpPosts.findByPostPassword", query = "SELECT w FROM WpPosts w WHERE w.postPassword = :postPassword"),
    @NamedQuery(name = "WpPosts.findByPostName", query = "SELECT w FROM WpPosts w WHERE w.postName = :postName"),
    @NamedQuery(name = "WpPosts.findByPostModified", query = "SELECT w FROM WpPosts w WHERE w.postModified = :postModified"),
    @NamedQuery(name = "WpPosts.findByPostModifiedGmt", query = "SELECT w FROM WpPosts w WHERE w.postModifiedGmt = :postModifiedGmt"),
    @NamedQuery(name = "WpPosts.findByPostParent", query = "SELECT w FROM WpPosts w WHERE w.postParent = :postParent"),
    @NamedQuery(name = "WpPosts.findByGuid", query = "SELECT w FROM WpPosts w WHERE w.guid = :guid"),
    @NamedQuery(name = "WpPosts.findByMenuOrder", query = "SELECT w FROM WpPosts w WHERE w.menuOrder = :menuOrder"),
    @NamedQuery(name = "WpPosts.findByPostType", query = "SELECT w FROM WpPosts w WHERE w.postType = :postType"),
    @NamedQuery(name = "WpPosts.findByPostMimeType", query = "SELECT w FROM WpPosts w WHERE w.postMimeType = :postMimeType"),
    @NamedQuery(name = "WpPosts.findByCommentCount", query = "SELECT w FROM WpPosts w WHERE w.commentCount = :commentCount")})
public class WpPosts implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "post_author", nullable = false)
    private long postAuthor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "post_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date postDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "post_date_gmt", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date postDateGmt;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "post_content", nullable = false, length = 2147483647)
    private String postContent;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "post_title", nullable = false, length = 65535)
    private String postTitle;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "post_excerpt", nullable = false, length = 65535)
    private String postExcerpt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "post_status", nullable = false, length = 20)
    private String postStatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "comment_status", nullable = false, length = 20)
    private String commentStatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ping_status", nullable = false, length = 20)
    private String pingStatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "post_password", nullable = false, length = 20)
    private String postPassword;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "post_name", nullable = false, length = 200)
    private String postName;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "to_ping", nullable = false, length = 65535)
    private String toPing;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(nullable = false, length = 65535)
    private String pinged;
    @Basic(optional = false)
    @NotNull
    @Column(name = "post_modified", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date postModified;
    @Basic(optional = false)
    @NotNull
    @Column(name = "post_modified_gmt", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date postModifiedGmt;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "post_content_filtered", nullable = false, length = 2147483647)
    private String postContentFiltered;
    @Basic(optional = false)
    @NotNull
    @Column(name = "post_parent", nullable = false)
    private long postParent;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(nullable = false, length = 255)
    private String guid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "menu_order", nullable = false)
    private int menuOrder;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "post_type", nullable = false, length = 20)
    private String postType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "post_mime_type", nullable = false, length = 100)
    private String postMimeType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "comment_count", nullable = false)
    private long commentCount;

    public WpPosts() {
    }

    public WpPosts(Long id) {
        this.id = id;
    }

    public WpPosts(Long id, long postAuthor, Date postDate, Date postDateGmt, String postContent, String postTitle, String postExcerpt, String postStatus, String commentStatus, String pingStatus, String postPassword, String postName, String toPing, String pinged, Date postModified, Date postModifiedGmt, String postContentFiltered, long postParent, String guid, int menuOrder, String postType, String postMimeType, long commentCount) {
        this.id = id;
        this.postAuthor = postAuthor;
        this.postDate = postDate;
        this.postDateGmt = postDateGmt;
        this.postContent = postContent;
        this.postTitle = postTitle;
        this.postExcerpt = postExcerpt;
        this.postStatus = postStatus;
        this.commentStatus = commentStatus;
        this.pingStatus = pingStatus;
        this.postPassword = postPassword;
        this.postName = postName;
        this.toPing = toPing;
        this.pinged = pinged;
        this.postModified = postModified;
        this.postModifiedGmt = postModifiedGmt;
        this.postContentFiltered = postContentFiltered;
        this.postParent = postParent;
        this.guid = guid;
        this.menuOrder = menuOrder;
        this.postType = postType;
        this.postMimeType = postMimeType;
        this.commentCount = commentCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getPostAuthor() {
        return postAuthor;
    }

    public void setPostAuthor(long postAuthor) {
        this.postAuthor = postAuthor;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public Date getPostDateGmt() {
        return postDateGmt;
    }

    public void setPostDateGmt(Date postDateGmt) {
        this.postDateGmt = postDateGmt;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostExcerpt() {
        return postExcerpt;
    }

    public void setPostExcerpt(String postExcerpt) {
        this.postExcerpt = postExcerpt;
    }

    public String getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(String postStatus) {
        this.postStatus = postStatus;
    }

    public String getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(String commentStatus) {
        this.commentStatus = commentStatus;
    }

    public String getPingStatus() {
        return pingStatus;
    }

    public void setPingStatus(String pingStatus) {
        this.pingStatus = pingStatus;
    }

    public String getPostPassword() {
        return postPassword;
    }

    public void setPostPassword(String postPassword) {
        this.postPassword = postPassword;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getToPing() {
        return toPing;
    }

    public void setToPing(String toPing) {
        this.toPing = toPing;
    }

    public String getPinged() {
        return pinged;
    }

    public void setPinged(String pinged) {
        this.pinged = pinged;
    }

    public Date getPostModified() {
        return postModified;
    }

    public void setPostModified(Date postModified) {
        this.postModified = postModified;
    }

    public Date getPostModifiedGmt() {
        return postModifiedGmt;
    }

    public void setPostModifiedGmt(Date postModifiedGmt) {
        this.postModifiedGmt = postModifiedGmt;
    }

    public String getPostContentFiltered() {
        return postContentFiltered;
    }

    public void setPostContentFiltered(String postContentFiltered) {
        this.postContentFiltered = postContentFiltered;
    }

    public long getPostParent() {
        return postParent;
    }

    public void setPostParent(long postParent) {
        this.postParent = postParent;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public int getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(int menuOrder) {
        this.menuOrder = menuOrder;
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public String getPostMimeType() {
        return postMimeType;
    }

    public void setPostMimeType(String postMimeType) {
        this.postMimeType = postMimeType;
    }

    public long getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(long commentCount) {
        this.commentCount = commentCount;
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
        if (!(object instanceof WpPosts)) {
            return false;
        }
        WpPosts other = (WpPosts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "src.entities.WpPosts[ id=" + id + " ]";
    }
    
}
