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
@Table(name = "wp_woocommerce_order_items")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WpWoocommerceOrderItems.findAll", query = "SELECT w FROM WpWoocommerceOrderItems w"),
    @NamedQuery(name = "WpWoocommerceOrderItems.findByOrderItemId", query = "SELECT w FROM WpWoocommerceOrderItems w WHERE w.orderItemId = :orderItemId"),
    @NamedQuery(name = "WpWoocommerceOrderItems.findByOrderItemType", query = "SELECT w FROM WpWoocommerceOrderItems w WHERE w.orderItemType = :orderItemType"),
    @NamedQuery(name = "WpWoocommerceOrderItems.findByOrderId", query = "SELECT w FROM WpWoocommerceOrderItems w WHERE w.orderId = :orderId")})
public class WpWoocommerceOrderItems implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "order_item_id", nullable = false)
    private Long orderItemId;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "order_item_name", nullable = false, length = 2147483647)
    private String orderItemName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "order_item_type", nullable = false, length = 200)
    private String orderItemType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "order_id", nullable = false)
    private long orderId;

    public WpWoocommerceOrderItems() {
    }

    public WpWoocommerceOrderItems(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public WpWoocommerceOrderItems(Long orderItemId, String orderItemName, String orderItemType, long orderId) {
        this.orderItemId = orderItemId;
        this.orderItemName = orderItemName;
        this.orderItemType = orderItemType;
        this.orderId = orderId;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public String getOrderItemName() {
        return orderItemName;
    }

    public void setOrderItemName(String orderItemName) {
        this.orderItemName = orderItemName;
    }

    public String getOrderItemType() {
        return orderItemType;
    }

    public void setOrderItemType(String orderItemType) {
        this.orderItemType = orderItemType;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderItemId != null ? orderItemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WpWoocommerceOrderItems)) {
            return false;
        }
        WpWoocommerceOrderItems other = (WpWoocommerceOrderItems) object;
        if ((this.orderItemId == null && other.orderItemId != null) || (this.orderItemId != null && !this.orderItemId.equals(other.orderItemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "src.entities.WpWoocommerceOrderItems[ orderItemId=" + orderItemId + " ]";
    }
    
}
