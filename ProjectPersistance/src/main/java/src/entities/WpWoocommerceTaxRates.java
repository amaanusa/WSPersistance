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
@Table(name = "wp_woocommerce_tax_rates")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WpWoocommerceTaxRates.findAll", query = "SELECT w FROM WpWoocommerceTaxRates w"),
    @NamedQuery(name = "WpWoocommerceTaxRates.findByTaxRateId", query = "SELECT w FROM WpWoocommerceTaxRates w WHERE w.taxRateId = :taxRateId"),
    @NamedQuery(name = "WpWoocommerceTaxRates.findByTaxRateCountry", query = "SELECT w FROM WpWoocommerceTaxRates w WHERE w.taxRateCountry = :taxRateCountry"),
    @NamedQuery(name = "WpWoocommerceTaxRates.findByTaxRateState", query = "SELECT w FROM WpWoocommerceTaxRates w WHERE w.taxRateState = :taxRateState"),
    @NamedQuery(name = "WpWoocommerceTaxRates.findByTaxRate", query = "SELECT w FROM WpWoocommerceTaxRates w WHERE w.taxRate = :taxRate"),
    @NamedQuery(name = "WpWoocommerceTaxRates.findByTaxRateName", query = "SELECT w FROM WpWoocommerceTaxRates w WHERE w.taxRateName = :taxRateName"),
    @NamedQuery(name = "WpWoocommerceTaxRates.findByTaxRatePriority", query = "SELECT w FROM WpWoocommerceTaxRates w WHERE w.taxRatePriority = :taxRatePriority"),
    @NamedQuery(name = "WpWoocommerceTaxRates.findByTaxRateCompound", query = "SELECT w FROM WpWoocommerceTaxRates w WHERE w.taxRateCompound = :taxRateCompound"),
    @NamedQuery(name = "WpWoocommerceTaxRates.findByTaxRateShipping", query = "SELECT w FROM WpWoocommerceTaxRates w WHERE w.taxRateShipping = :taxRateShipping"),
    @NamedQuery(name = "WpWoocommerceTaxRates.findByTaxRateOrder", query = "SELECT w FROM WpWoocommerceTaxRates w WHERE w.taxRateOrder = :taxRateOrder"),
    @NamedQuery(name = "WpWoocommerceTaxRates.findByTaxRateClass", query = "SELECT w FROM WpWoocommerceTaxRates w WHERE w.taxRateClass = :taxRateClass")})
public class WpWoocommerceTaxRates implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tax_rate_id", nullable = false)
    private Long taxRateId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "tax_rate_country", nullable = false, length = 200)
    private String taxRateCountry;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "tax_rate_state", nullable = false, length = 200)
    private String taxRateState;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "tax_rate", nullable = false, length = 200)
    private String taxRate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "tax_rate_name", nullable = false, length = 200)
    private String taxRateName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tax_rate_priority", nullable = false)
    private long taxRatePriority;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tax_rate_compound", nullable = false)
    private int taxRateCompound;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tax_rate_shipping", nullable = false)
    private int taxRateShipping;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tax_rate_order", nullable = false)
    private long taxRateOrder;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "tax_rate_class", nullable = false, length = 200)
    private String taxRateClass;

    public WpWoocommerceTaxRates() {
    }

    public WpWoocommerceTaxRates(Long taxRateId) {
        this.taxRateId = taxRateId;
    }

    public WpWoocommerceTaxRates(Long taxRateId, String taxRateCountry, String taxRateState, String taxRate, String taxRateName, long taxRatePriority, int taxRateCompound, int taxRateShipping, long taxRateOrder, String taxRateClass) {
        this.taxRateId = taxRateId;
        this.taxRateCountry = taxRateCountry;
        this.taxRateState = taxRateState;
        this.taxRate = taxRate;
        this.taxRateName = taxRateName;
        this.taxRatePriority = taxRatePriority;
        this.taxRateCompound = taxRateCompound;
        this.taxRateShipping = taxRateShipping;
        this.taxRateOrder = taxRateOrder;
        this.taxRateClass = taxRateClass;
    }

    public Long getTaxRateId() {
        return taxRateId;
    }

    public void setTaxRateId(Long taxRateId) {
        this.taxRateId = taxRateId;
    }

    public String getTaxRateCountry() {
        return taxRateCountry;
    }

    public void setTaxRateCountry(String taxRateCountry) {
        this.taxRateCountry = taxRateCountry;
    }

    public String getTaxRateState() {
        return taxRateState;
    }

    public void setTaxRateState(String taxRateState) {
        this.taxRateState = taxRateState;
    }

    public String getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(String taxRate) {
        this.taxRate = taxRate;
    }

    public String getTaxRateName() {
        return taxRateName;
    }

    public void setTaxRateName(String taxRateName) {
        this.taxRateName = taxRateName;
    }

    public long getTaxRatePriority() {
        return taxRatePriority;
    }

    public void setTaxRatePriority(long taxRatePriority) {
        this.taxRatePriority = taxRatePriority;
    }

    public int getTaxRateCompound() {
        return taxRateCompound;
    }

    public void setTaxRateCompound(int taxRateCompound) {
        this.taxRateCompound = taxRateCompound;
    }

    public int getTaxRateShipping() {
        return taxRateShipping;
    }

    public void setTaxRateShipping(int taxRateShipping) {
        this.taxRateShipping = taxRateShipping;
    }

    public long getTaxRateOrder() {
        return taxRateOrder;
    }

    public void setTaxRateOrder(long taxRateOrder) {
        this.taxRateOrder = taxRateOrder;
    }

    public String getTaxRateClass() {
        return taxRateClass;
    }

    public void setTaxRateClass(String taxRateClass) {
        this.taxRateClass = taxRateClass;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taxRateId != null ? taxRateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WpWoocommerceTaxRates)) {
            return false;
        }
        WpWoocommerceTaxRates other = (WpWoocommerceTaxRates) object;
        if ((this.taxRateId == null && other.taxRateId != null) || (this.taxRateId != null && !this.taxRateId.equals(other.taxRateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "src.entities.WpWoocommerceTaxRates[ taxRateId=" + taxRateId + " ]";
    }
    
}
