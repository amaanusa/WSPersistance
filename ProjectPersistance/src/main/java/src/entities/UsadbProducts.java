/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author imranadmin
 */
@Entity
@Table(name = "usadb_products", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"codeabbr"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsadbProducts.findAll", query = "SELECT u FROM UsadbProducts u"),
    @NamedQuery(name = "UsadbProducts.findById", query = "SELECT u FROM UsadbProducts u WHERE u.id = :id"),
    @NamedQuery(name = "UsadbProducts.findByPostId", query = "SELECT u FROM UsadbProducts u WHERE u.postId = :postId"),
    @NamedQuery(name = "UsadbProducts.findByCodes", query = "SELECT u FROM UsadbProducts u WHERE u.codes = :codes"),
    @NamedQuery(name = "UsadbProducts.findByCodeabbr", query = "SELECT u FROM UsadbProducts u WHERE u.codeabbr = :codeabbr"),
    @NamedQuery(name = "UsadbProducts.findByCodedescription", query = "SELECT u FROM UsadbProducts u WHERE u.codedescription = :codedescription"),
    @NamedQuery(name = "UsadbProducts.findByPrice", query = "SELECT u FROM UsadbProducts u WHERE u.price = :price"),
    @NamedQuery(name = "UsadbProducts.findByProductcode", query = "SELECT u FROM UsadbProducts u WHERE u.productcode = :productcode"),
    @NamedQuery(name = "UsadbProducts.findByTotalrecords", query = "SELECT u FROM UsadbProducts u WHERE u.totalrecords = :totalrecords"),
    @NamedQuery(name = "UsadbProducts.findByTotaladdress", query = "SELECT u FROM UsadbProducts u WHERE u.totaladdress = :totaladdress"),
    @NamedQuery(name = "UsadbProducts.findByTotalemails", query = "SELECT u FROM UsadbProducts u WHERE u.totalemails = :totalemails"),
    @NamedQuery(name = "UsadbProducts.findByTotalfax", query = "SELECT u FROM UsadbProducts u WHERE u.totalfax = :totalfax"),
    @NamedQuery(name = "UsadbProducts.findByTotalphones", query = "SELECT u FROM UsadbProducts u WHERE u.totalphones = :totalphones")})
public class UsadbProducts implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Column(name = "post_id")
    private BigInteger postId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(nullable = false, length = 10)
    private String codes;
    @Size(max = 15)
    @Column(length = 15)
    private String codeabbr;
    @Size(max = 255)
    @Column(length = 255)
    private String codedescription;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 10, scale = 2)
    private BigDecimal price;
    @Size(max = 45)
    @Column(length = 45)
    private String productcode;
    private BigInteger totalrecords;
    private BigInteger totaladdress;
    private BigInteger totalemails;
    private BigInteger totalfax;
    private BigInteger totalphones;

    public UsadbProducts() {
    }

    public UsadbProducts(Integer id) {
        this.id = id;
    }

    public UsadbProducts(Integer id, String codes) {
        this.id = id;
        this.codes = codes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigInteger getPostId() {
        return postId;
    }

    public void setPostId(BigInteger postId) {
        this.postId = postId;
    }

    public String getCodes() {
        return codes;
    }

    public void setCodes(String codes) {
        this.codes = codes;
    }

    public String getCodeabbr() {
        return codeabbr;
    }

    public void setCodeabbr(String codeabbr) {
        this.codeabbr = codeabbr;
    }

    public String getCodedescription() {
        return codedescription;
    }

    public void setCodedescription(String codedescription) {
        this.codedescription = codedescription;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getProductcode() {
        return productcode;
    }

    public void setProductcode(String productcode) {
        this.productcode = productcode;
    }

    public BigInteger getTotalrecords() {
        return totalrecords;
    }

    public void setTotalrecords(BigInteger totalrecords) {
        this.totalrecords = totalrecords;
    }

    public BigInteger getTotaladdress() {
        return totaladdress;
    }

    public void setTotaladdress(BigInteger totaladdress) {
        this.totaladdress = totaladdress;
    }

    public BigInteger getTotalemails() {
        return totalemails;
    }

    public void setTotalemails(BigInteger totalemails) {
        this.totalemails = totalemails;
    }

    public BigInteger getTotalfax() {
        return totalfax;
    }

    public void setTotalfax(BigInteger totalfax) {
        this.totalfax = totalfax;
    }

    public BigInteger getTotalphones() {
        return totalphones;
    }

    public void setTotalphones(BigInteger totalphones) {
        this.totalphones = totalphones;
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
        if (!(object instanceof UsadbProducts)) {
            return false;
        }
        UsadbProducts other = (UsadbProducts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "src.entities.UsadbProducts[ id=" + id + " ]";
    }
    
}
