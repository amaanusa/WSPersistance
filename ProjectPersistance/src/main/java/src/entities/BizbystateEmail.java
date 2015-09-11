/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "bizbystate_email", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"rownum"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BizbystateEmail.findAll", query = "SELECT b FROM BizbystateEmail b"),
    @NamedQuery(name = "BizbystateEmail.findByCompanyName", query = "SELECT b FROM BizbystateEmail b WHERE b.companyName = :companyName"),
    @NamedQuery(name = "BizbystateEmail.findByEmail", query = "SELECT b FROM BizbystateEmail b WHERE b.email = :email"),
    @NamedQuery(name = "BizbystateEmail.findByAddress", query = "SELECT b FROM BizbystateEmail b WHERE b.address = :address"),
    @NamedQuery(name = "BizbystateEmail.findByCity", query = "SELECT b FROM BizbystateEmail b WHERE b.city = :city"),
    @NamedQuery(name = "BizbystateEmail.findByState", query = "SELECT b FROM BizbystateEmail b WHERE b.state = :state"),
    @NamedQuery(name = "BizbystateEmail.findByZipcode", query = "SELECT b FROM BizbystateEmail b WHERE b.zipcode = :zipcode"),
    @NamedQuery(name = "BizbystateEmail.findByPhoneNumber", query = "SELECT b FROM BizbystateEmail b WHERE b.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "BizbystateEmail.findByFaxNumber", query = "SELECT b FROM BizbystateEmail b WHERE b.faxNumber = :faxNumber"),
    @NamedQuery(name = "BizbystateEmail.findBySicCode", query = "SELECT b FROM BizbystateEmail b WHERE b.sicCode = :sicCode"),
    @NamedQuery(name = "BizbystateEmail.findBySicDescription", query = "SELECT b FROM BizbystateEmail b WHERE b.sicDescription = :sicDescription"),
    @NamedQuery(name = "BizbystateEmail.findByWebAddress", query = "SELECT b FROM BizbystateEmail b WHERE b.webAddress = :webAddress"),
    @NamedQuery(name = "BizbystateEmail.findByPostId", query = "SELECT b FROM BizbystateEmail b WHERE b.postId = :postId"),
    @NamedQuery(name = "BizbystateEmail.findByRownum", query = "SELECT b FROM BizbystateEmail b WHERE b.rownum = :rownum")})
public class BizbystateEmail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 100)
    @Column(name = "COMPANY_NAME", length = 100)
    private String companyName;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 65)
    @Column(length = 65)
    private String email;
    @Size(max = 155)
    @Column(length = 155)
    private String address;
    @Size(max = 45)
    @Column(length = 45)
    private String city;
    @Size(max = 4)
    @Column(length = 4)
    private String state;
    @Size(max = 15)
    @Column(length = 15)
    private String zipcode;
    @Size(max = 15)
    @Column(name = "PHONE_NUMBER", length = 15)
    private String phoneNumber;
    @Size(max = 15)
    @Column(name = "FAX_NUMBER", length = 15)
    private String faxNumber;
    @Column(name = "SIC_CODE")
    private BigInteger sicCode;
    @Size(max = 95)
    @Column(name = "SIC_DESCRIPTION", length = 95)
    private String sicDescription;
    @Size(max = 45)
    @Column(name = "WEB_ADDRESS", length = 45)
    private String webAddress;
    @Column(name = "post_id")
    private BigInteger postId;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Long rownum;

    public BizbystateEmail() {
    }

    public BizbystateEmail(Long rownum) {
        this.rownum = rownum;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public BigInteger getSicCode() {
        return sicCode;
    }

    public void setSicCode(BigInteger sicCode) {
        this.sicCode = sicCode;
    }

    public String getSicDescription() {
        return sicDescription;
    }

    public void setSicDescription(String sicDescription) {
        this.sicDescription = sicDescription;
    }

    public String getWebAddress() {
        return webAddress;
    }

    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }

    public BigInteger getPostId() {
        return postId;
    }

    public void setPostId(BigInteger postId) {
        this.postId = postId;
    }

    public Long getRownum() {
        return rownum;
    }

    public void setRownum(Long rownum) {
        this.rownum = rownum;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rownum != null ? rownum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BizbystateEmail)) {
            return false;
        }
        BizbystateEmail other = (BizbystateEmail) object;
        if ((this.rownum == null && other.rownum != null) || (this.rownum != null && !this.rownum.equals(other.rownum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "src.entities.BizbystateEmail[ rownum=" + rownum + " ]";
    }
    
}
