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
@Table(name = "statenj_usadb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StatenjUsadb.findAll", query = "SELECT s FROM StatenjUsadb s"),
    @NamedQuery(name = "StatenjUsadb.findByName", query = "SELECT s FROM StatenjUsadb s WHERE s.name = :name"),
    @NamedQuery(name = "StatenjUsadb.findByAddress", query = "SELECT s FROM StatenjUsadb s WHERE s.address = :address"),
    @NamedQuery(name = "StatenjUsadb.findByCity", query = "SELECT s FROM StatenjUsadb s WHERE s.city = :city"),
    @NamedQuery(name = "StatenjUsadb.findByState", query = "SELECT s FROM StatenjUsadb s WHERE s.state = :state"),
    @NamedQuery(name = "StatenjUsadb.findByZipcode", query = "SELECT s FROM StatenjUsadb s WHERE s.zipcode = :zipcode"),
    @NamedQuery(name = "StatenjUsadb.findByCounty", query = "SELECT s FROM StatenjUsadb s WHERE s.county = :county"),
    @NamedQuery(name = "StatenjUsadb.findByWebsite", query = "SELECT s FROM StatenjUsadb s WHERE s.website = :website"),
    @NamedQuery(name = "StatenjUsadb.findByPhone", query = "SELECT s FROM StatenjUsadb s WHERE s.phone = :phone"),
    @NamedQuery(name = "StatenjUsadb.findByFax", query = "SELECT s FROM StatenjUsadb s WHERE s.fax = :fax"),
    @NamedQuery(name = "StatenjUsadb.findByContactname", query = "SELECT s FROM StatenjUsadb s WHERE s.contactname = :contactname"),
    @NamedQuery(name = "StatenjUsadb.findByTitle", query = "SELECT s FROM StatenjUsadb s WHERE s.title = :title"),
    @NamedQuery(name = "StatenjUsadb.findByGender", query = "SELECT s FROM StatenjUsadb s WHERE s.gender = :gender"),
    @NamedQuery(name = "StatenjUsadb.findByEmployees", query = "SELECT s FROM StatenjUsadb s WHERE s.employees = :employees"),
    @NamedQuery(name = "StatenjUsadb.findByAnnualsales", query = "SELECT s FROM StatenjUsadb s WHERE s.annualsales = :annualsales"),
    @NamedQuery(name = "StatenjUsadb.findBySicCodeDesc", query = "SELECT s FROM StatenjUsadb s WHERE s.sicCodeDesc = :sicCodeDesc"),
    @NamedQuery(name = "StatenjUsadb.findBySicCode", query = "SELECT s FROM StatenjUsadb s WHERE s.sicCode = :sicCode"),
    @NamedQuery(name = "StatenjUsadb.findBySicDesc", query = "SELECT s FROM StatenjUsadb s WHERE s.sicDesc = :sicDesc"),
    @NamedQuery(name = "StatenjUsadb.findByRownum", query = "SELECT s FROM StatenjUsadb s WHERE s.rownum = :rownum")})
public class StatenjUsadb implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(length = 255)
    private String name;
    @Size(max = 100)
    @Column(length = 100)
    private String address;
    @Size(max = 55)
    @Column(length = 55)
    private String city;
    @Size(max = 2)
    @Column(length = 2)
    private String state;
    @Size(max = 15)
    @Column(length = 15)
    private String zipcode;
    @Size(max = 45)
    @Column(length = 45)
    private String county;
    @Size(max = 120)
    @Column(length = 120)
    private String website;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(length = 45)
    private String phone;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(length = 45)
    private String fax;
    @Size(max = 100)
    @Column(length = 100)
    private String contactname;
    @Size(max = 55)
    @Column(length = 55)
    private String title;
    @Size(max = 10)
    @Column(length = 10)
    private String gender;
    @Size(max = 45)
    @Column(length = 45)
    private String employees;
    @Size(max = 45)
    @Column(length = 45)
    private String annualsales;
    @Size(max = 255)
    @Column(name = "sic_code_desc", length = 255)
    private String sicCodeDesc;
    @Column(name = "sic_code")
    private BigInteger sicCode;
    @Size(max = 100)
    @Column(name = "sic_desc", length = 100)
    private String sicDesc;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long rownum;

    public StatenjUsadb() {
    }

    public StatenjUsadb(Long rownum) {
        this.rownum = rownum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getContactname() {
        return contactname;
    }

    public void setContactname(String contactname) {
        this.contactname = contactname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmployees() {
        return employees;
    }

    public void setEmployees(String employees) {
        this.employees = employees;
    }

    public String getAnnualsales() {
        return annualsales;
    }

    public void setAnnualsales(String annualsales) {
        this.annualsales = annualsales;
    }

    public String getSicCodeDesc() {
        return sicCodeDesc;
    }

    public void setSicCodeDesc(String sicCodeDesc) {
        this.sicCodeDesc = sicCodeDesc;
    }

    public BigInteger getSicCode() {
        return sicCode;
    }

    public void setSicCode(BigInteger sicCode) {
        this.sicCode = sicCode;
    }

    public String getSicDesc() {
        return sicDesc;
    }

    public void setSicDesc(String sicDesc) {
        this.sicDesc = sicDesc;
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
        if (!(object instanceof StatenjUsadb)) {
            return false;
        }
        StatenjUsadb other = (StatenjUsadb) object;
        if ((this.rownum == null && other.rownum != null) || (this.rownum != null && !this.rownum.equals(other.rownum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "src.entities.StatenjUsadb[ rownum=" + rownum + " ]";
    }
    
}
