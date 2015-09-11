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
@Table(name = "usa_population")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsaPopulation.findAll", query = "SELECT u FROM UsaPopulation u"),
    @NamedQuery(name = "UsaPopulation.findBySumlev", query = "SELECT u FROM UsaPopulation u WHERE u.sumlev = :sumlev"),
    @NamedQuery(name = "UsaPopulation.findByState", query = "SELECT u FROM UsaPopulation u WHERE u.state = :state"),
    @NamedQuery(name = "UsaPopulation.findByCounty", query = "SELECT u FROM UsaPopulation u WHERE u.county = :county"),
    @NamedQuery(name = "UsaPopulation.findByPlace", query = "SELECT u FROM UsaPopulation u WHERE u.place = :place"),
    @NamedQuery(name = "UsaPopulation.findByCousub", query = "SELECT u FROM UsaPopulation u WHERE u.cousub = :cousub"),
    @NamedQuery(name = "UsaPopulation.findByConcit", query = "SELECT u FROM UsaPopulation u WHERE u.concit = :concit"),
    @NamedQuery(name = "UsaPopulation.findByName", query = "SELECT u FROM UsaPopulation u WHERE u.name = :name"),
    @NamedQuery(name = "UsaPopulation.findByStname", query = "SELECT u FROM UsaPopulation u WHERE u.stname = :stname"),
    @NamedQuery(name = "UsaPopulation.findByCensus2010pop", query = "SELECT u FROM UsaPopulation u WHERE u.census2010pop = :census2010pop"),
    @NamedQuery(name = "UsaPopulation.findByEstimatesbase2010", query = "SELECT u FROM UsaPopulation u WHERE u.estimatesbase2010 = :estimatesbase2010"),
    @NamedQuery(name = "UsaPopulation.findByPopestimate2010", query = "SELECT u FROM UsaPopulation u WHERE u.popestimate2010 = :popestimate2010"),
    @NamedQuery(name = "UsaPopulation.findByPopestimate2011", query = "SELECT u FROM UsaPopulation u WHERE u.popestimate2011 = :popestimate2011"),
    @NamedQuery(name = "UsaPopulation.findByRownum", query = "SELECT u FROM UsaPopulation u WHERE u.rownum = :rownum")})
public class UsaPopulation implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer sumlev;
    private Integer state;
    private Integer county;
    private Integer place;
    private Integer cousub;
    private Integer concit;
    @Size(max = 255)
    @Column(length = 255)
    private String name;
    @Size(max = 55)
    @Column(length = 55)
    private String stname;
    private BigInteger census2010pop;
    private BigInteger estimatesbase2010;
    private BigInteger popestimate2010;
    private BigInteger popestimate2011;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer rownum;

    public UsaPopulation() {
    }

    public UsaPopulation(Integer rownum) {
        this.rownum = rownum;
    }

    public Integer getSumlev() {
        return sumlev;
    }

    public void setSumlev(Integer sumlev) {
        this.sumlev = sumlev;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getCounty() {
        return county;
    }

    public void setCounty(Integer county) {
        this.county = county;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    public Integer getCousub() {
        return cousub;
    }

    public void setCousub(Integer cousub) {
        this.cousub = cousub;
    }

    public Integer getConcit() {
        return concit;
    }

    public void setConcit(Integer concit) {
        this.concit = concit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStname() {
        return stname;
    }

    public void setStname(String stname) {
        this.stname = stname;
    }

    public BigInteger getCensus2010pop() {
        return census2010pop;
    }

    public void setCensus2010pop(BigInteger census2010pop) {
        this.census2010pop = census2010pop;
    }

    public BigInteger getEstimatesbase2010() {
        return estimatesbase2010;
    }

    public void setEstimatesbase2010(BigInteger estimatesbase2010) {
        this.estimatesbase2010 = estimatesbase2010;
    }

    public BigInteger getPopestimate2010() {
        return popestimate2010;
    }

    public void setPopestimate2010(BigInteger popestimate2010) {
        this.popestimate2010 = popestimate2010;
    }

    public BigInteger getPopestimate2011() {
        return popestimate2011;
    }

    public void setPopestimate2011(BigInteger popestimate2011) {
        this.popestimate2011 = popestimate2011;
    }

    public Integer getRownum() {
        return rownum;
    }

    public void setRownum(Integer rownum) {
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
        if (!(object instanceof UsaPopulation)) {
            return false;
        }
        UsaPopulation other = (UsaPopulation) object;
        if ((this.rownum == null && other.rownum != null) || (this.rownum != null && !this.rownum.equals(other.rownum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "src.entities.UsaPopulation[ rownum=" + rownum + " ]";
    }
    
}
