/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "wp_woocommerce_downloadable_product_permissions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WpWoocommerceDownloadableProductPermissions.findAll", query = "SELECT w FROM WpWoocommerceDownloadableProductPermissions w"),
    @NamedQuery(name = "WpWoocommerceDownloadableProductPermissions.findByDownloadId", query = "SELECT w FROM WpWoocommerceDownloadableProductPermissions w WHERE w.wpWoocommerceDownloadableProductPermissionsPK.downloadId = :downloadId"),
    @NamedQuery(name = "WpWoocommerceDownloadableProductPermissions.findByProductId", query = "SELECT w FROM WpWoocommerceDownloadableProductPermissions w WHERE w.wpWoocommerceDownloadableProductPermissionsPK.productId = :productId"),
    @NamedQuery(name = "WpWoocommerceDownloadableProductPermissions.findByOrderId", query = "SELECT w FROM WpWoocommerceDownloadableProductPermissions w WHERE w.wpWoocommerceDownloadableProductPermissionsPK.orderId = :orderId"),
    @NamedQuery(name = "WpWoocommerceDownloadableProductPermissions.findByOrderKey", query = "SELECT w FROM WpWoocommerceDownloadableProductPermissions w WHERE w.wpWoocommerceDownloadableProductPermissionsPK.orderKey = :orderKey"),
    @NamedQuery(name = "WpWoocommerceDownloadableProductPermissions.findByUserEmail", query = "SELECT w FROM WpWoocommerceDownloadableProductPermissions w WHERE w.userEmail = :userEmail"),
    @NamedQuery(name = "WpWoocommerceDownloadableProductPermissions.findByUserId", query = "SELECT w FROM WpWoocommerceDownloadableProductPermissions w WHERE w.userId = :userId"),
    @NamedQuery(name = "WpWoocommerceDownloadableProductPermissions.findByDownloadsRemaining", query = "SELECT w FROM WpWoocommerceDownloadableProductPermissions w WHERE w.downloadsRemaining = :downloadsRemaining"),
    @NamedQuery(name = "WpWoocommerceDownloadableProductPermissions.findByAccessGranted", query = "SELECT w FROM WpWoocommerceDownloadableProductPermissions w WHERE w.accessGranted = :accessGranted"),
    @NamedQuery(name = "WpWoocommerceDownloadableProductPermissions.findByAccessExpires", query = "SELECT w FROM WpWoocommerceDownloadableProductPermissions w WHERE w.accessExpires = :accessExpires"),
    @NamedQuery(name = "WpWoocommerceDownloadableProductPermissions.findByDownloadCount", query = "SELECT w FROM WpWoocommerceDownloadableProductPermissions w WHERE w.downloadCount = :downloadCount")})
public class WpWoocommerceDownloadableProductPermissions implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected WpWoocommerceDownloadableProductPermissionsPK wpWoocommerceDownloadableProductPermissionsPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "user_email", nullable = false, length = 200)
    private String userEmail;
    @Column(name = "user_id")
    private BigInteger userId;
    @Size(max = 9)
    @Column(name = "downloads_remaining", length = 9)
    private String downloadsRemaining;
    @Basic(optional = false)
    @NotNull
    @Column(name = "access_granted", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date accessGranted;
    @Column(name = "access_expires")
    @Temporal(TemporalType.TIMESTAMP)
    private Date accessExpires;
    @Basic(optional = false)
    @NotNull
    @Column(name = "download_count", nullable = false)
    private long downloadCount;

    public WpWoocommerceDownloadableProductPermissions() {
    }

    public WpWoocommerceDownloadableProductPermissions(WpWoocommerceDownloadableProductPermissionsPK wpWoocommerceDownloadableProductPermissionsPK) {
        this.wpWoocommerceDownloadableProductPermissionsPK = wpWoocommerceDownloadableProductPermissionsPK;
    }

    public WpWoocommerceDownloadableProductPermissions(WpWoocommerceDownloadableProductPermissionsPK wpWoocommerceDownloadableProductPermissionsPK, String userEmail, Date accessGranted, long downloadCount) {
        this.wpWoocommerceDownloadableProductPermissionsPK = wpWoocommerceDownloadableProductPermissionsPK;
        this.userEmail = userEmail;
        this.accessGranted = accessGranted;
        this.downloadCount = downloadCount;
    }

    public WpWoocommerceDownloadableProductPermissions(String downloadId, long productId, long orderId, String orderKey) {
        this.wpWoocommerceDownloadableProductPermissionsPK = new WpWoocommerceDownloadableProductPermissionsPK(downloadId, productId, orderId, orderKey);
    }

    public WpWoocommerceDownloadableProductPermissionsPK getWpWoocommerceDownloadableProductPermissionsPK() {
        return wpWoocommerceDownloadableProductPermissionsPK;
    }

    public void setWpWoocommerceDownloadableProductPermissionsPK(WpWoocommerceDownloadableProductPermissionsPK wpWoocommerceDownloadableProductPermissionsPK) {
        this.wpWoocommerceDownloadableProductPermissionsPK = wpWoocommerceDownloadableProductPermissionsPK;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    public String getDownloadsRemaining() {
        return downloadsRemaining;
    }

    public void setDownloadsRemaining(String downloadsRemaining) {
        this.downloadsRemaining = downloadsRemaining;
    }

    public Date getAccessGranted() {
        return accessGranted;
    }

    public void setAccessGranted(Date accessGranted) {
        this.accessGranted = accessGranted;
    }

    public Date getAccessExpires() {
        return accessExpires;
    }

    public void setAccessExpires(Date accessExpires) {
        this.accessExpires = accessExpires;
    }

    public long getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(long downloadCount) {
        this.downloadCount = downloadCount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (wpWoocommerceDownloadableProductPermissionsPK != null ? wpWoocommerceDownloadableProductPermissionsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WpWoocommerceDownloadableProductPermissions)) {
            return false;
        }
        WpWoocommerceDownloadableProductPermissions other = (WpWoocommerceDownloadableProductPermissions) object;
        if ((this.wpWoocommerceDownloadableProductPermissionsPK == null && other.wpWoocommerceDownloadableProductPermissionsPK != null) || (this.wpWoocommerceDownloadableProductPermissionsPK != null && !this.wpWoocommerceDownloadableProductPermissionsPK.equals(other.wpWoocommerceDownloadableProductPermissionsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "src.entities.WpWoocommerceDownloadableProductPermissions[ wpWoocommerceDownloadableProductPermissionsPK=" + wpWoocommerceDownloadableProductPermissionsPK + " ]";
    }
    
}
