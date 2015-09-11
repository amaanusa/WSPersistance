/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author imranadmin
 */
@Embeddable
public class WpWoocommerceDownloadableProductPermissionsPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "download_id", nullable = false, length = 32)
    private String downloadId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "product_id", nullable = false)
    private long productId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "order_id", nullable = false)
    private long orderId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "order_key", nullable = false, length = 200)
    private String orderKey;

    public WpWoocommerceDownloadableProductPermissionsPK() {
    }

    public WpWoocommerceDownloadableProductPermissionsPK(String downloadId, long productId, long orderId, String orderKey) {
        this.downloadId = downloadId;
        this.productId = productId;
        this.orderId = orderId;
        this.orderKey = orderKey;
    }

    public String getDownloadId() {
        return downloadId;
    }

    public void setDownloadId(String downloadId) {
        this.downloadId = downloadId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getOrderKey() {
        return orderKey;
    }

    public void setOrderKey(String orderKey) {
        this.orderKey = orderKey;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (downloadId != null ? downloadId.hashCode() : 0);
        hash += (int) productId;
        hash += (int) orderId;
        hash += (orderKey != null ? orderKey.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WpWoocommerceDownloadableProductPermissionsPK)) {
            return false;
        }
        WpWoocommerceDownloadableProductPermissionsPK other = (WpWoocommerceDownloadableProductPermissionsPK) object;
        if ((this.downloadId == null && other.downloadId != null) || (this.downloadId != null && !this.downloadId.equals(other.downloadId))) {
            return false;
        }
        if (this.productId != other.productId) {
            return false;
        }
        if (this.orderId != other.orderId) {
            return false;
        }
        if ((this.orderKey == null && other.orderKey != null) || (this.orderKey != null && !this.orderKey.equals(other.orderKey))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "src.entities.WpWoocommerceDownloadableProductPermissionsPK[ downloadId=" + downloadId + ", productId=" + productId + ", orderId=" + orderId + ", orderKey=" + orderKey + " ]";
    }
    
}
