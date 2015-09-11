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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author imranadmin
 */
@Entity
@Table(name = "email_ky")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmailKy.findAll", query = "SELECT e FROM EmailKy e"),
    @NamedQuery(name = "EmailKy.findByCompanyName", query = "SELECT e FROM EmailKy e WHERE e.companyName = :companyName"),
    @NamedQuery(name = "EmailKy.findByEmail", query = "SELECT e FROM EmailKy e WHERE e.email = :email"),
    @NamedQuery(name = "EmailKy.findByAddress", query = "SELECT e FROM EmailKy e WHERE e.address = :address"),
    @NamedQuery(name = "EmailKy.findByCity", query = "SELECT e FROM EmailKy e WHERE e.city = :city"),
    @NamedQuery(name = "EmailKy.findByState", query = "SELECT e FROM EmailKy e WHERE e.state = :state"),
    @NamedQuery(name = "EmailKy.findByZipcode", query = "SELECT e FROM EmailKy e WHERE e.zipcode = :zipcode"),
    @NamedQuery(name = "EmailKy.findByPhoneNumber", query = "SELECT e FROM EmailKy e WHERE e.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "EmailKy.findByFaxNumber", query = "SELECT e FROM EmailKy e WHERE e.faxNumber = :faxNumber"),
    @NamedQuery(name = "EmailKy.findBySicCode", query = "SELECT e FROM EmailKy e WHERE e.sicCode = :sicCode"),
    @NamedQuery(name = "EmailKy.findBySicDescription", query = "SELECT e FROM EmailKy e WHERE e.sicDescription = :sicDescription"),
    @NamedQuery(name = "EmailKy.findByWebAddress", query = "SELECT e FROM EmailKy e WHERE e.webAddress = :webAddress"),
    @NamedQuery(name = "EmailKy.findByRownum", query = "SELECT e FROM EmailKy e WHERE e.rownum = :rownum")})
public class EmailKy implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 100)
    @Column(name = "company_name", length = 100)
    private String companyName;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(length = 50)
    private String email;
    @Size(max = 255)
    @Column(length = 255)
    private String address;
    @Size(max = 75)
    @Column(length = 75)
    private String city;
    @Size(max = 5)
    @Column(length = 5)
    private String state;
    @Size(max = 20)
    @Column(length = 20)
    private String zipcode;
    @Size(max = 12)
    @Column(name = "phone_number", length = 12)
    private String phoneNumber;
    @Size(max = 15)
    @Column(name = "fax_number", length = 15)
    private String faxNumber;
    @Column(name = "sic_code")
    private BigInteger sicCode;
    @Size(max = 95)
    @Column(name = "sic_description", length = 95)
    private String sicDescription;
    @Size(max = 95)
    @Column(name = "web_address", length = 95)
    private String webAddress;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long rownum;

    public EmailKy() {
    }

    public EmailKy(Long rownum) {
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
        if (!(object instanceof EmailKy)) {
            return false;
        }
        EmailKy other = (EmailKy) object;
        if ((this.rownum == null && other.rownum != null) || (this.rownum != null && !this.rownum.equals(other.rownum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "src.entities.EmailKy[ rownum=" + rownum + " ]";
    }
    
}
