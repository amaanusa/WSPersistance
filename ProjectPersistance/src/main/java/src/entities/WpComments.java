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
@Table(name = "wp_comments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WpComments.findAll", query = "SELECT w FROM WpComments w"),
    @NamedQuery(name = "WpComments.findByCommentID", query = "SELECT w FROM WpComments w WHERE w.commentID = :commentID"),
    @NamedQuery(name = "WpComments.findByCommentpostID", query = "SELECT w FROM WpComments w WHERE w.commentpostID = :commentpostID"),
    @NamedQuery(name = "WpComments.findByCommentAuthor", query = "SELECT w FROM WpComments w WHERE w.commentAuthor = :commentAuthor"),
    @NamedQuery(name = "WpComments.findByCommentAuthorEmail", query = "SELECT w FROM WpComments w WHERE w.commentAuthorEmail = :commentAuthorEmail"),
    @NamedQuery(name = "WpComments.findByCommentAuthorUrl", query = "SELECT w FROM WpComments w WHERE w.commentAuthorUrl = :commentAuthorUrl"),
    @NamedQuery(name = "WpComments.findByCommentauthorIP", query = "SELECT w FROM WpComments w WHERE w.commentauthorIP = :commentauthorIP"),
    @NamedQuery(name = "WpComments.findByCommentDate", query = "SELECT w FROM WpComments w WHERE w.commentDate = :commentDate"),
    @NamedQuery(name = "WpComments.findByCommentDateGmt", query = "SELECT w FROM WpComments w WHERE w.commentDateGmt = :commentDateGmt"),
    @NamedQuery(name = "WpComments.findByCommentKarma", query = "SELECT w FROM WpComments w WHERE w.commentKarma = :commentKarma"),
    @NamedQuery(name = "WpComments.findByCommentApproved", query = "SELECT w FROM WpComments w WHERE w.commentApproved = :commentApproved"),
    @NamedQuery(name = "WpComments.findByCommentAgent", query = "SELECT w FROM WpComments w WHERE w.commentAgent = :commentAgent"),
    @NamedQuery(name = "WpComments.findByCommentType", query = "SELECT w FROM WpComments w WHERE w.commentType = :commentType"),
    @NamedQuery(name = "WpComments.findByCommentParent", query = "SELECT w FROM WpComments w WHERE w.commentParent = :commentParent"),
    @NamedQuery(name = "WpComments.findByUserId", query = "SELECT w FROM WpComments w WHERE w.userId = :userId")})
public class WpComments implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "comment_ID", nullable = false)
    private Long commentID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "comment_post_ID", nullable = false)
    private long commentpostID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "comment_author", nullable = false, length = 255)
    private String commentAuthor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "comment_author_email", nullable = false, length = 100)
    private String commentAuthorEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "comment_author_url", nullable = false, length = 200)
    private String commentAuthorUrl;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "comment_author_IP", nullable = false, length = 100)
    private String commentauthorIP;
    @Basic(optional = false)
    @NotNull
    @Column(name = "comment_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date commentDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "comment_date_gmt", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date commentDateGmt;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "comment_content", nullable = false, length = 65535)
    private String commentContent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "comment_karma", nullable = false)
    private int commentKarma;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "comment_approved", nullable = false, length = 20)
    private String commentApproved;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "comment_agent", nullable = false, length = 255)
    private String commentAgent;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "comment_type", nullable = false, length = 20)
    private String commentType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "comment_parent", nullable = false)
    private long commentParent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id", nullable = false)
    private long userId;

    public WpComments() {
    }

    public WpComments(Long commentID) {
        this.commentID = commentID;
    }

    public WpComments(Long commentID, long commentpostID, String commentAuthor, String commentAuthorEmail, String commentAuthorUrl, String commentauthorIP, Date commentDate, Date commentDateGmt, String commentContent, int commentKarma, String commentApproved, String commentAgent, String commentType, long commentParent, long userId) {
        this.commentID = commentID;
        this.commentpostID = commentpostID;
        this.commentAuthor = commentAuthor;
        this.commentAuthorEmail = commentAuthorEmail;
        this.commentAuthorUrl = commentAuthorUrl;
        this.commentauthorIP = commentauthorIP;
        this.commentDate = commentDate;
        this.commentDateGmt = commentDateGmt;
        this.commentContent = commentContent;
        this.commentKarma = commentKarma;
        this.commentApproved = commentApproved;
        this.commentAgent = commentAgent;
        this.commentType = commentType;
        this.commentParent = commentParent;
        this.userId = userId;
    }

    public Long getCommentID() {
        return commentID;
    }

    public void setCommentID(Long commentID) {
        this.commentID = commentID;
    }

    public long getCommentpostID() {
        return commentpostID;
    }

    public void setCommentpostID(long commentpostID) {
        this.commentpostID = commentpostID;
    }

    public String getCommentAuthor() {
        return commentAuthor;
    }

    public void setCommentAuthor(String commentAuthor) {
        this.commentAuthor = commentAuthor;
    }

    public String getCommentAuthorEmail() {
        return commentAuthorEmail;
    }

    public void setCommentAuthorEmail(String commentAuthorEmail) {
        this.commentAuthorEmail = commentAuthorEmail;
    }

    public String getCommentAuthorUrl() {
        return commentAuthorUrl;
    }

    public void setCommentAuthorUrl(String commentAuthorUrl) {
        this.commentAuthorUrl = commentAuthorUrl;
    }

    public String getCommentauthorIP() {
        return commentauthorIP;
    }

    public void setCommentauthorIP(String commentauthorIP) {
        this.commentauthorIP = commentauthorIP;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public Date getCommentDateGmt() {
        return commentDateGmt;
    }

    public void setCommentDateGmt(Date commentDateGmt) {
        this.commentDateGmt = commentDateGmt;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public int getCommentKarma() {
        return commentKarma;
    }

    public void setCommentKarma(int commentKarma) {
        this.commentKarma = commentKarma;
    }

    public String getCommentApproved() {
        return commentApproved;
    }

    public void setCommentApproved(String commentApproved) {
        this.commentApproved = commentApproved;
    }

    public String getCommentAgent() {
        return commentAgent;
    }

    public void setCommentAgent(String commentAgent) {
        this.commentAgent = commentAgent;
    }

    public String getCommentType() {
        return commentType;
    }

    public void setCommentType(String commentType) {
        this.commentType = commentType;
    }

    public long getCommentParent() {
        return commentParent;
    }

    public void setCommentParent(long commentParent) {
        this.commentParent = commentParent;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (commentID != null ? commentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WpComments)) {
            return false;
        }
        WpComments other = (WpComments) object;
        if ((this.commentID == null && other.commentID != null) || (this.commentID != null && !this.commentID.equals(other.commentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "src.entities.WpComments[ commentID=" + commentID + " ]";
    }
    
}
