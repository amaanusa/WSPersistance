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
@Table(name = "state_ri")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StateRi.findAll", query = "SELECT s FROM StateRi s"),
    @NamedQuery(name = "StateRi.findByCompanyName", query = "SELECT s FROM StateRi s WHERE s.companyName = :companyName"),
    @NamedQuery(name = "StateRi.findByMailingAddress", query = "SELECT s FROM StateRi s WHERE s.mailingAddress = :mailingAddress"),
    @NamedQuery(name = "StateRi.findByCity", query = "SELECT s FROM StateRi s WHERE s.city = :city"),
    @NamedQuery(name = "StateRi.findByState", query = "SELECT s FROM StateRi s WHERE s.state = :state"),
    @NamedQuery(name = "StateRi.findByZipCode", query = "SELECT s FROM StateRi s WHERE s.zipCode = :zipCode"),
    @NamedQuery(name = "StateRi.findByMailingCarrierRoute", query = "SELECT s FROM StateRi s WHERE s.mailingCarrierRoute = :mailingCarrierRoute"),
    @NamedQuery(name = "StateRi.findByMailingDeliveryPointBarCode", query = "SELECT s FROM StateRi s WHERE s.mailingDeliveryPointBarCode = :mailingDeliveryPointBarCode"),
    @NamedQuery(name = "StateRi.findByStreetAddressCity", query = "SELECT s FROM StateRi s WHERE s.streetAddressCity = :streetAddressCity"),
    @NamedQuery(name = "StateRi.findByStreetAddress", query = "SELECT s FROM StateRi s WHERE s.streetAddress = :streetAddress"),
    @NamedQuery(name = "StateRi.findByStreetAddressZip", query = "SELECT s FROM StateRi s WHERE s.streetAddressZip = :streetAddressZip"),
    @NamedQuery(name = "StateRi.findByStreetAddressZip4", query = "SELECT s FROM StateRi s WHERE s.streetAddressZip4 = :streetAddressZip4"),
    @NamedQuery(name = "StateRi.findByCounty", query = "SELECT s FROM StateRi s WHERE s.county = :county"),
    @NamedQuery(name = "StateRi.findByPhoneNumber", query = "SELECT s FROM StateRi s WHERE s.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "StateRi.findByFaxNumber", query = "SELECT s FROM StateRi s WHERE s.faxNumber = :faxNumber"),
    @NamedQuery(name = "StateRi.findByWebAddress", query = "SELECT s FROM StateRi s WHERE s.webAddress = :webAddress"),
    @NamedQuery(name = "StateRi.findByLastName", query = "SELECT s FROM StateRi s WHERE s.lastName = :lastName"),
    @NamedQuery(name = "StateRi.findByFirstName", query = "SELECT s FROM StateRi s WHERE s.firstName = :firstName"),
    @NamedQuery(name = "StateRi.findByContactTitle", query = "SELECT s FROM StateRi s WHERE s.contactTitle = :contactTitle"),
    @NamedQuery(name = "StateRi.findByContactGender", query = "SELECT s FROM StateRi s WHERE s.contactGender = :contactGender"),
    @NamedQuery(name = "StateRi.findByActualEmployeeSize", query = "SELECT s FROM StateRi s WHERE s.actualEmployeeSize = :actualEmployeeSize"),
    @NamedQuery(name = "StateRi.findByEmployeeSizeRange", query = "SELECT s FROM StateRi s WHERE s.employeeSizeRange = :employeeSizeRange"),
    @NamedQuery(name = "StateRi.findByActualSalesVolume", query = "SELECT s FROM StateRi s WHERE s.actualSalesVolume = :actualSalesVolume"),
    @NamedQuery(name = "StateRi.findBySalesVolumeRange", query = "SELECT s FROM StateRi s WHERE s.salesVolumeRange = :salesVolumeRange"),
    @NamedQuery(name = "StateRi.findByPrimarySic", query = "SELECT s FROM StateRi s WHERE s.primarySic = :primarySic"),
    @NamedQuery(name = "StateRi.findByPrimarySicDescription", query = "SELECT s FROM StateRi s WHERE s.primarySicDescription = :primarySicDescription"),
    @NamedQuery(name = "StateRi.findBySecondarySic1", query = "SELECT s FROM StateRi s WHERE s.secondarySic1 = :secondarySic1"),
    @NamedQuery(name = "StateRi.findBySecondarySicDescription1", query = "SELECT s FROM StateRi s WHERE s.secondarySicDescription1 = :secondarySicDescription1"),
    @NamedQuery(name = "StateRi.findBySecondarySic2", query = "SELECT s FROM StateRi s WHERE s.secondarySic2 = :secondarySic2"),
    @NamedQuery(name = "StateRi.findBySecondarySicDescription2", query = "SELECT s FROM StateRi s WHERE s.secondarySicDescription2 = :secondarySicDescription2"),
    @NamedQuery(name = "StateRi.findByCreditAlphaScore", query = "SELECT s FROM StateRi s WHERE s.creditAlphaScore = :creditAlphaScore"),
    @NamedQuery(name = "StateRi.findByCreditNumericScore", query = "SELECT s FROM StateRi s WHERE s.creditNumericScore = :creditNumericScore"),
    @NamedQuery(name = "StateRi.findByHeadquartersbranch", query = "SELECT s FROM StateRi s WHERE s.headquartersbranch = :headquartersbranch"),
    @NamedQuery(name = "StateRi.findByOfficeSize", query = "SELECT s FROM StateRi s WHERE s.officeSize = :officeSize"),
    @NamedQuery(name = "StateRi.findBySquareFootage", query = "SELECT s FROM StateRi s WHERE s.squareFootage = :squareFootage"),
    @NamedQuery(name = "StateRi.findByFirmindividual", query = "SELECT s FROM StateRi s WHERE s.firmindividual = :firmindividual"),
    @NamedQuery(name = "StateRi.findByPublicprivateFlag", query = "SELECT s FROM StateRi s WHERE s.publicprivateFlag = :publicprivateFlag"),
    @NamedQuery(name = "StateRi.findByPcCode", query = "SELECT s FROM StateRi s WHERE s.pcCode = :pcCode"),
    @NamedQuery(name = "StateRi.findByFranchisespecialty1", query = "SELECT s FROM StateRi s WHERE s.franchisespecialty1 = :franchisespecialty1"),
    @NamedQuery(name = "StateRi.findByFranchisespecialty2", query = "SELECT s FROM StateRi s WHERE s.franchisespecialty2 = :franchisespecialty2"),
    @NamedQuery(name = "StateRi.findByIndustrySpecificCodes", query = "SELECT s FROM StateRi s WHERE s.industrySpecificCodes = :industrySpecificCodes"),
    @NamedQuery(name = "StateRi.findByAdsizeInYellowPages", query = "SELECT s FROM StateRi s WHERE s.adsizeInYellowPages = :adsizeInYellowPages"),
    @NamedQuery(name = "StateRi.findByMetroArea", query = "SELECT s FROM StateRi s WHERE s.metroArea = :metroArea"),
    @NamedQuery(name = "StateRi.findByStreetAddressDeliveryPointBarCode", query = "SELECT s FROM StateRi s WHERE s.streetAddressDeliveryPointBarCode = :streetAddressDeliveryPointBarCode"),
    @NamedQuery(name = "StateRi.findByStreetAddressCarrierRoute", query = "SELECT s FROM StateRi s WHERE s.streetAddressCarrierRoute = :streetAddressCarrierRoute"),
    @NamedQuery(name = "StateRi.findByRownum", query = "SELECT s FROM StateRi s WHERE s.rownum = :rownum")})
public class StateRi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 100)
    @Column(name = "company_name", length = 100)
    private String companyName;
    @Size(max = 155)
    @Column(name = "mailing_address", length = 155)
    private String mailingAddress;
    @Size(max = 75)
    @Column(length = 75)
    private String city;
    @Size(max = 5)
    @Column(length = 5)
    private String state;
    @Size(max = 20)
    @Column(name = "zip_code", length = 20)
    private String zipCode;
    @Size(max = 10)
    @Column(name = "mailing_carrier_route", length = 10)
    private String mailingCarrierRoute;
    @Size(max = 15)
    @Column(name = "mailing_delivery_point_bar_code", length = 15)
    private String mailingDeliveryPointBarCode;
    @Size(max = 75)
    @Column(name = "street_address_city", length = 75)
    private String streetAddressCity;
    @Size(max = 255)
    @Column(name = "street_address", length = 255)
    private String streetAddress;
    @Size(max = 20)
    @Column(name = "street_address_zip", length = 20)
    private String streetAddressZip;
    @Size(max = 10)
    @Column(name = "street_address_zip_4", length = 10)
    private String streetAddressZip4;
    @Size(max = 25)
    @Column(length = 25)
    private String county;
    @Size(max = 12)
    @Column(name = "phone_number", length = 12)
    private String phoneNumber;
    @Size(max = 15)
    @Column(name = "fax_number", length = 15)
    private String faxNumber;
    @Size(max = 95)
    @Column(name = "web_address", length = 95)
    private String webAddress;
    @Size(max = 65)
    @Column(name = "last_name", length = 65)
    private String lastName;
    @Size(max = 65)
    @Column(name = "first_name", length = 65)
    private String firstName;
    @Size(max = 65)
    @Column(name = "contact_title", length = 65)
    private String contactTitle;
    @Size(max = 20)
    @Column(name = "contact_gender", length = 20)
    private String contactGender;
    @Column(name = "actual_employee_size")
    private BigInteger actualEmployeeSize;
    @Size(max = 65)
    @Column(name = "employee_size_range", length = 65)
    private String employeeSizeRange;
    @Column(name = "actual_sales_volume")
    private BigInteger actualSalesVolume;
    @Size(max = 65)
    @Column(name = "sales_volume_range", length = 65)
    private String salesVolumeRange;
    @Column(name = "primary_sic")
    private BigInteger primarySic;
    @Size(max = 95)
    @Column(name = "primary_sic_description", length = 95)
    private String primarySicDescription;
    @Column(name = "secondary_sic_1")
    private BigInteger secondarySic1;
    @Size(max = 95)
    @Column(name = "secondary_sic_description_1", length = 95)
    private String secondarySicDescription1;
    @Column(name = "secondary_sic_2")
    private BigInteger secondarySic2;
    @Size(max = 95)
    @Column(name = "secondary_sic_description_2", length = 95)
    private String secondarySicDescription2;
    @Size(max = 5)
    @Column(name = "credit_alpha_score", length = 5)
    private String creditAlphaScore;
    @Column(name = "credit_numeric_score")
    private BigInteger creditNumericScore;
    @Size(max = 45)
    @Column(length = 45)
    private String headquartersbranch;
    @Size(max = 45)
    @Column(name = "office_size", length = 45)
    private String officeSize;
    @Size(max = 45)
    @Column(name = "square_footage", length = 45)
    private String squareFootage;
    @Size(max = 45)
    @Column(length = 45)
    private String firmindividual;
    @Size(max = 5)
    @Column(name = "publicprivate_flag", length = 5)
    private String publicprivateFlag;
    @Size(max = 45)
    @Column(name = "pc_code", length = 45)
    private String pcCode;
    @Size(max = 95)
    @Column(name = "franchisespecialty_1", length = 95)
    private String franchisespecialty1;
    @Size(max = 95)
    @Column(name = "franchisespecialty_2", length = 95)
    private String franchisespecialty2;
    @Size(max = 45)
    @Column(name = "industry_specific_codes", length = 45)
    private String industrySpecificCodes;
    @Size(max = 15)
    @Column(name = "adsize_in_yellow_pages", length = 15)
    private String adsizeInYellowPages;
    @Size(max = 45)
    @Column(name = "metro_area", length = 45)
    private String metroArea;
    @Column(name = "street_address_delivery_point_bar_code")
    private BigInteger streetAddressDeliveryPointBarCode;
    @Size(max = 20)
    @Column(name = "street_address_carrier_route", length = 20)
    private String streetAddressCarrierRoute;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long rownum;

    public StateRi() {
    }

    public StateRi(Long rownum) {
        this.rownum = rownum;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getMailingCarrierRoute() {
        return mailingCarrierRoute;
    }

    public void setMailingCarrierRoute(String mailingCarrierRoute) {
        this.mailingCarrierRoute = mailingCarrierRoute;
    }

    public String getMailingDeliveryPointBarCode() {
        return mailingDeliveryPointBarCode;
    }

    public void setMailingDeliveryPointBarCode(String mailingDeliveryPointBarCode) {
        this.mailingDeliveryPointBarCode = mailingDeliveryPointBarCode;
    }

    public String getStreetAddressCity() {
        return streetAddressCity;
    }

    public void setStreetAddressCity(String streetAddressCity) {
        this.streetAddressCity = streetAddressCity;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getStreetAddressZip() {
        return streetAddressZip;
    }

    public void setStreetAddressZip(String streetAddressZip) {
        this.streetAddressZip = streetAddressZip;
    }

    public String getStreetAddressZip4() {
        return streetAddressZip4;
    }

    public void setStreetAddressZip4(String streetAddressZip4) {
        this.streetAddressZip4 = streetAddressZip4;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
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

    public String getWebAddress() {
        return webAddress;
    }

    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getContactTitle() {
        return contactTitle;
    }

    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
    }

    public String getContactGender() {
        return contactGender;
    }

    public void setContactGender(String contactGender) {
        this.contactGender = contactGender;
    }

    public BigInteger getActualEmployeeSize() {
        return actualEmployeeSize;
    }

    public void setActualEmployeeSize(BigInteger actualEmployeeSize) {
        this.actualEmployeeSize = actualEmployeeSize;
    }

    public String getEmployeeSizeRange() {
        return employeeSizeRange;
    }

    public void setEmployeeSizeRange(String employeeSizeRange) {
        this.employeeSizeRange = employeeSizeRange;
    }

    public BigInteger getActualSalesVolume() {
        return actualSalesVolume;
    }

    public void setActualSalesVolume(BigInteger actualSalesVolume) {
        this.actualSalesVolume = actualSalesVolume;
    }

    public String getSalesVolumeRange() {
        return salesVolumeRange;
    }

    public void setSalesVolumeRange(String salesVolumeRange) {
        this.salesVolumeRange = salesVolumeRange;
    }

    public BigInteger getPrimarySic() {
        return primarySic;
    }

    public void setPrimarySic(BigInteger primarySic) {
        this.primarySic = primarySic;
    }

    public String getPrimarySicDescription() {
        return primarySicDescription;
    }

    public void setPrimarySicDescription(String primarySicDescription) {
        this.primarySicDescription = primarySicDescription;
    }

    public BigInteger getSecondarySic1() {
        return secondarySic1;
    }

    public void setSecondarySic1(BigInteger secondarySic1) {
        this.secondarySic1 = secondarySic1;
    }

    public String getSecondarySicDescription1() {
        return secondarySicDescription1;
    }

    public void setSecondarySicDescription1(String secondarySicDescription1) {
        this.secondarySicDescription1 = secondarySicDescription1;
    }

    public BigInteger getSecondarySic2() {
        return secondarySic2;
    }

    public void setSecondarySic2(BigInteger secondarySic2) {
        this.secondarySic2 = secondarySic2;
    }

    public String getSecondarySicDescription2() {
        return secondarySicDescription2;
    }

    public void setSecondarySicDescription2(String secondarySicDescription2) {
        this.secondarySicDescription2 = secondarySicDescription2;
    }

    public String getCreditAlphaScore() {
        return creditAlphaScore;
    }

    public void setCreditAlphaScore(String creditAlphaScore) {
        this.creditAlphaScore = creditAlphaScore;
    }

    public BigInteger getCreditNumericScore() {
        return creditNumericScore;
    }

    public void setCreditNumericScore(BigInteger creditNumericScore) {
        this.creditNumericScore = creditNumericScore;
    }

    public String getHeadquartersbranch() {
        return headquartersbranch;
    }

    public void setHeadquartersbranch(String headquartersbranch) {
        this.headquartersbranch = headquartersbranch;
    }

    public String getOfficeSize() {
        return officeSize;
    }

    public void setOfficeSize(String officeSize) {
        this.officeSize = officeSize;
    }

    public String getSquareFootage() {
        return squareFootage;
    }

    public void setSquareFootage(String squareFootage) {
        this.squareFootage = squareFootage;
    }

    public String getFirmindividual() {
        return firmindividual;
    }

    public void setFirmindividual(String firmindividual) {
        this.firmindividual = firmindividual;
    }

    public String getPublicprivateFlag() {
        return publicprivateFlag;
    }

    public void setPublicprivateFlag(String publicprivateFlag) {
        this.publicprivateFlag = publicprivateFlag;
    }

    public String getPcCode() {
        return pcCode;
    }

    public void setPcCode(String pcCode) {
        this.pcCode = pcCode;
    }

    public String getFranchisespecialty1() {
        return franchisespecialty1;
    }

    public void setFranchisespecialty1(String franchisespecialty1) {
        this.franchisespecialty1 = franchisespecialty1;
    }

    public String getFranchisespecialty2() {
        return franchisespecialty2;
    }

    public void setFranchisespecialty2(String franchisespecialty2) {
        this.franchisespecialty2 = franchisespecialty2;
    }

    public String getIndustrySpecificCodes() {
        return industrySpecificCodes;
    }

    public void setIndustrySpecificCodes(String industrySpecificCodes) {
        this.industrySpecificCodes = industrySpecificCodes;
    }

    public String getAdsizeInYellowPages() {
        return adsizeInYellowPages;
    }

    public void setAdsizeInYellowPages(String adsizeInYellowPages) {
        this.adsizeInYellowPages = adsizeInYellowPages;
    }

    public String getMetroArea() {
        return metroArea;
    }

    public void setMetroArea(String metroArea) {
        this.metroArea = metroArea;
    }

    public BigInteger getStreetAddressDeliveryPointBarCode() {
        return streetAddressDeliveryPointBarCode;
    }

    public void setStreetAddressDeliveryPointBarCode(BigInteger streetAddressDeliveryPointBarCode) {
        this.streetAddressDeliveryPointBarCode = streetAddressDeliveryPointBarCode;
    }

    public String getStreetAddressCarrierRoute() {
        return streetAddressCarrierRoute;
    }

    public void setStreetAddressCarrierRoute(String streetAddressCarrierRoute) {
        this.streetAddressCarrierRoute = streetAddressCarrierRoute;
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
        if (!(object instanceof StateRi)) {
            return false;
        }
        StateRi other = (StateRi) object;
        if ((this.rownum == null && other.rownum != null) || (this.rownum != null && !this.rownum.equals(other.rownum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "src.entities.StateRi[ rownum=" + rownum + " ]";
    }
    
}
