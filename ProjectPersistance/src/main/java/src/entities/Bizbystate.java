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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author imranadmin
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bizbystate.findAll", query = "SELECT b FROM Bizbystate b"),
    @NamedQuery(name = "Bizbystate.findByCompanyName", query = "SELECT b FROM Bizbystate b WHERE b.companyName = :companyName"),
    @NamedQuery(name = "Bizbystate.findByMailingAddress", query = "SELECT b FROM Bizbystate b WHERE b.mailingAddress = :mailingAddress"),
    @NamedQuery(name = "Bizbystate.findByCity", query = "SELECT b FROM Bizbystate b WHERE b.city = :city"),
    @NamedQuery(name = "Bizbystate.findByState", query = "SELECT b FROM Bizbystate b WHERE b.state = :state"),
    @NamedQuery(name = "Bizbystate.findByZipCode", query = "SELECT b FROM Bizbystate b WHERE b.zipCode = :zipCode"),
    @NamedQuery(name = "Bizbystate.findByMailingCarrierRoute", query = "SELECT b FROM Bizbystate b WHERE b.mailingCarrierRoute = :mailingCarrierRoute"),
    @NamedQuery(name = "Bizbystate.findByMailingDeliveryPointBarCode", query = "SELECT b FROM Bizbystate b WHERE b.mailingDeliveryPointBarCode = :mailingDeliveryPointBarCode"),
    @NamedQuery(name = "Bizbystate.findByStreetAddressCity", query = "SELECT b FROM Bizbystate b WHERE b.streetAddressCity = :streetAddressCity"),
    @NamedQuery(name = "Bizbystate.findByStreetAddress", query = "SELECT b FROM Bizbystate b WHERE b.streetAddress = :streetAddress"),
    @NamedQuery(name = "Bizbystate.findByStreetAddressZip", query = "SELECT b FROM Bizbystate b WHERE b.streetAddressZip = :streetAddressZip"),
    @NamedQuery(name = "Bizbystate.findByStreetAddressZip4", query = "SELECT b FROM Bizbystate b WHERE b.streetAddressZip4 = :streetAddressZip4"),
    @NamedQuery(name = "Bizbystate.findByCounty", query = "SELECT b FROM Bizbystate b WHERE b.county = :county"),
    @NamedQuery(name = "Bizbystate.findByPhoneNumber", query = "SELECT b FROM Bizbystate b WHERE b.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "Bizbystate.findByFaxNumber", query = "SELECT b FROM Bizbystate b WHERE b.faxNumber = :faxNumber"),
    @NamedQuery(name = "Bizbystate.findByWebAddress", query = "SELECT b FROM Bizbystate b WHERE b.webAddress = :webAddress"),
    @NamedQuery(name = "Bizbystate.findByLastName", query = "SELECT b FROM Bizbystate b WHERE b.lastName = :lastName"),
    @NamedQuery(name = "Bizbystate.findByFirstName", query = "SELECT b FROM Bizbystate b WHERE b.firstName = :firstName"),
    @NamedQuery(name = "Bizbystate.findByContactTitle", query = "SELECT b FROM Bizbystate b WHERE b.contactTitle = :contactTitle"),
    @NamedQuery(name = "Bizbystate.findByContactGender", query = "SELECT b FROM Bizbystate b WHERE b.contactGender = :contactGender"),
    @NamedQuery(name = "Bizbystate.findByActualEmployeeSize", query = "SELECT b FROM Bizbystate b WHERE b.actualEmployeeSize = :actualEmployeeSize"),
    @NamedQuery(name = "Bizbystate.findByEmployeeSizeRange", query = "SELECT b FROM Bizbystate b WHERE b.employeeSizeRange = :employeeSizeRange"),
    @NamedQuery(name = "Bizbystate.findByActualSalesVolume", query = "SELECT b FROM Bizbystate b WHERE b.actualSalesVolume = :actualSalesVolume"),
    @NamedQuery(name = "Bizbystate.findBySalesVolumeRange", query = "SELECT b FROM Bizbystate b WHERE b.salesVolumeRange = :salesVolumeRange"),
    @NamedQuery(name = "Bizbystate.findByPrimarySic", query = "SELECT b FROM Bizbystate b WHERE b.primarySic = :primarySic"),
    @NamedQuery(name = "Bizbystate.findByPrimarySicDescription", query = "SELECT b FROM Bizbystate b WHERE b.primarySicDescription = :primarySicDescription"),
    @NamedQuery(name = "Bizbystate.findBySecondarySic1", query = "SELECT b FROM Bizbystate b WHERE b.secondarySic1 = :secondarySic1"),
    @NamedQuery(name = "Bizbystate.findBySecondarySic1Description", query = "SELECT b FROM Bizbystate b WHERE b.secondarySic1Description = :secondarySic1Description"),
    @NamedQuery(name = "Bizbystate.findBySecondarySic2", query = "SELECT b FROM Bizbystate b WHERE b.secondarySic2 = :secondarySic2"),
    @NamedQuery(name = "Bizbystate.findBySecondarySic2Description", query = "SELECT b FROM Bizbystate b WHERE b.secondarySic2Description = :secondarySic2Description"),
    @NamedQuery(name = "Bizbystate.findByCreditAlphaScore", query = "SELECT b FROM Bizbystate b WHERE b.creditAlphaScore = :creditAlphaScore"),
    @NamedQuery(name = "Bizbystate.findByCreditNumericScore", query = "SELECT b FROM Bizbystate b WHERE b.creditNumericScore = :creditNumericScore"),
    @NamedQuery(name = "Bizbystate.findByHeadquartersBranch", query = "SELECT b FROM Bizbystate b WHERE b.headquartersBranch = :headquartersBranch"),
    @NamedQuery(name = "Bizbystate.findByYear1stAppeared", query = "SELECT b FROM Bizbystate b WHERE b.year1stAppeared = :year1stAppeared"),
    @NamedQuery(name = "Bizbystate.findByOfficeSize", query = "SELECT b FROM Bizbystate b WHERE b.officeSize = :officeSize"),
    @NamedQuery(name = "Bizbystate.findBySquareFootage", query = "SELECT b FROM Bizbystate b WHERE b.squareFootage = :squareFootage"),
    @NamedQuery(name = "Bizbystate.findByFirmIndividual", query = "SELECT b FROM Bizbystate b WHERE b.firmIndividual = :firmIndividual"),
    @NamedQuery(name = "Bizbystate.findByPublicPrivateFlag", query = "SELECT b FROM Bizbystate b WHERE b.publicPrivateFlag = :publicPrivateFlag"),
    @NamedQuery(name = "Bizbystate.findByPcCode", query = "SELECT b FROM Bizbystate b WHERE b.pcCode = :pcCode"),
    @NamedQuery(name = "Bizbystate.findByFranchiseSpecialty1", query = "SELECT b FROM Bizbystate b WHERE b.franchiseSpecialty1 = :franchiseSpecialty1"),
    @NamedQuery(name = "Bizbystate.findByFranchiseSpecialty2", query = "SELECT b FROM Bizbystate b WHERE b.franchiseSpecialty2 = :franchiseSpecialty2"),
    @NamedQuery(name = "Bizbystate.findByIndustrySpecificCodes", query = "SELECT b FROM Bizbystate b WHERE b.industrySpecificCodes = :industrySpecificCodes"),
    @NamedQuery(name = "Bizbystate.findByAdsizeInYellowPages", query = "SELECT b FROM Bizbystate b WHERE b.adsizeInYellowPages = :adsizeInYellowPages"),
    @NamedQuery(name = "Bizbystate.findByMetroArea", query = "SELECT b FROM Bizbystate b WHERE b.metroArea = :metroArea"),
    @NamedQuery(name = "Bizbystate.findByDeliveryPointBarCode", query = "SELECT b FROM Bizbystate b WHERE b.deliveryPointBarCode = :deliveryPointBarCode"),
    @NamedQuery(name = "Bizbystate.findByCarrierRoute", query = "SELECT b FROM Bizbystate b WHERE b.carrierRoute = :carrierRoute"),
    @NamedQuery(name = "Bizbystate.findByRownum", query = "SELECT b FROM Bizbystate b WHERE b.rownum = :rownum")})
public class Bizbystate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 100)
    @Column(name = "COMPANY_NAME", length = 100)
    private String companyName;
    @Size(max = 155)
    @Column(name = "MAILING_ADDRESS", length = 155)
    private String mailingAddress;
    @Size(max = 75)
    @Column(length = 75)
    private String city;
    @Size(max = 5)
    @Column(length = 5)
    private String state;
    @Size(max = 20)
    @Column(name = "ZIP_CODE", length = 20)
    private String zipCode;
    @Size(max = 10)
    @Column(name = "MAILING_CARRIER_ROUTE", length = 10)
    private String mailingCarrierRoute;
    @Size(max = 15)
    @Column(name = "MAILING_DELIVERY_POINT_BAR_CODE", length = 15)
    private String mailingDeliveryPointBarCode;
    @Size(max = 75)
    @Column(name = "STREET_ADDRESS_CITY", length = 75)
    private String streetAddressCity;
    @Size(max = 255)
    @Column(name = "STREET_ADDRESS", length = 255)
    private String streetAddress;
    @Size(max = 20)
    @Column(name = "STREET_ADDRESS_ZIP", length = 20)
    private String streetAddressZip;
    @Size(max = 10)
    @Column(name = "STREET_ADDRESS_ZIP_4", length = 10)
    private String streetAddressZip4;
    @Size(max = 25)
    @Column(length = 25)
    private String county;
    @Size(max = 12)
    @Column(name = "PHONE_NUMBER", length = 12)
    private String phoneNumber;
    @Size(max = 15)
    @Column(name = "FAX_NUMBER", length = 15)
    private String faxNumber;
    @Size(max = 95)
    @Column(name = "WEB_ADDRESS", length = 95)
    private String webAddress;
    @Size(max = 65)
    @Column(name = "LAST_NAME", length = 65)
    private String lastName;
    @Size(max = 65)
    @Column(name = "FIRST_NAME", length = 65)
    private String firstName;
    @Size(max = 65)
    @Column(name = "CONTACT_TITLE", length = 65)
    private String contactTitle;
    @Size(max = 20)
    @Column(name = "CONTACT_GENDER", length = 20)
    private String contactGender;
    @Column(name = "ACTUAL_EMPLOYEE_SIZE")
    private BigInteger actualEmployeeSize;
    @Size(max = 65)
    @Column(name = "EMPLOYEE_SIZE_RANGE", length = 65)
    private String employeeSizeRange;
    @Column(name = "ACTUAL_SALES_VOLUME")
    private BigInteger actualSalesVolume;
    @Size(max = 65)
    @Column(name = "SALES_VOLUME_RANGE", length = 65)
    private String salesVolumeRange;
    @Column(name = "PRIMARY_SIC")
    private BigInteger primarySic;
    @Size(max = 95)
    @Column(name = "PRIMARY_SIC_DESCRIPTION", length = 95)
    private String primarySicDescription;
    @Column(name = "SECONDARY_SIC_1")
    private BigInteger secondarySic1;
    @Size(max = 95)
    @Column(name = "SECONDARY_SIC_1_DESCRIPTION", length = 95)
    private String secondarySic1Description;
    @Column(name = "SECONDARY_SIC_2")
    private BigInteger secondarySic2;
    @Size(max = 95)
    @Column(name = "SECONDARY_SIC_2_DESCRIPTION", length = 95)
    private String secondarySic2Description;
    @Size(max = 5)
    @Column(name = "CREDIT_ALPHA_SCORE", length = 5)
    private String creditAlphaScore;
    @Column(name = "CREDIT_NUMERIC_SCORE")
    private BigInteger creditNumericScore;
    @Size(max = 45)
    @Column(name = "HEADQUARTERS_BRANCH", length = 45)
    private String headquartersBranch;
    @Column(name = "YEAR_1ST_APPEARED")
    private BigInteger year1stAppeared;
    @Size(max = 45)
    @Column(name = "OFFICE_SIZE", length = 45)
    private String officeSize;
    @Size(max = 45)
    @Column(name = "SQUARE_FOOTAGE", length = 45)
    private String squareFootage;
    @Size(max = 45)
    @Column(name = "FIRM_INDIVIDUAL", length = 45)
    private String firmIndividual;
    @Size(max = 5)
    @Column(name = "PUBLIC_PRIVATE_FLAG", length = 5)
    private String publicPrivateFlag;
    @Size(max = 45)
    @Column(name = "PC_CODE", length = 45)
    private String pcCode;
    @Size(max = 95)
    @Column(name = "FRANCHISE_SPECIALTY_1", length = 95)
    private String franchiseSpecialty1;
    @Size(max = 95)
    @Column(name = "FRANCHISE_SPECIALTY_2", length = 95)
    private String franchiseSpecialty2;
    @Size(max = 45)
    @Column(name = "INDUSTRY_SPECIFIC_CODES", length = 45)
    private String industrySpecificCodes;
    @Size(max = 15)
    @Column(name = "ADSIZE_IN_YELLOW_PAGES", length = 15)
    private String adsizeInYellowPages;
    @Size(max = 45)
    @Column(name = "METRO_AREA", length = 45)
    private String metroArea;
    @Column(name = "DELIVERY_POINT_BAR_CODE")
    private BigInteger deliveryPointBarCode;
    @Size(max = 45)
    @Column(name = "CARRIER_ROUTE", length = 45)
    private String carrierRoute;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long rownum;

    public Bizbystate() {
    }

    public Bizbystate(Long rownum) {
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

    public String getSecondarySic1Description() {
        return secondarySic1Description;
    }

    public void setSecondarySic1Description(String secondarySic1Description) {
        this.secondarySic1Description = secondarySic1Description;
    }

    public BigInteger getSecondarySic2() {
        return secondarySic2;
    }

    public void setSecondarySic2(BigInteger secondarySic2) {
        this.secondarySic2 = secondarySic2;
    }

    public String getSecondarySic2Description() {
        return secondarySic2Description;
    }

    public void setSecondarySic2Description(String secondarySic2Description) {
        this.secondarySic2Description = secondarySic2Description;
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

    public String getHeadquartersBranch() {
        return headquartersBranch;
    }

    public void setHeadquartersBranch(String headquartersBranch) {
        this.headquartersBranch = headquartersBranch;
    }

    public BigInteger getYear1stAppeared() {
        return year1stAppeared;
    }

    public void setYear1stAppeared(BigInteger year1stAppeared) {
        this.year1stAppeared = year1stAppeared;
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

    public String getFirmIndividual() {
        return firmIndividual;
    }

    public void setFirmIndividual(String firmIndividual) {
        this.firmIndividual = firmIndividual;
    }

    public String getPublicPrivateFlag() {
        return publicPrivateFlag;
    }

    public void setPublicPrivateFlag(String publicPrivateFlag) {
        this.publicPrivateFlag = publicPrivateFlag;
    }

    public String getPcCode() {
        return pcCode;
    }

    public void setPcCode(String pcCode) {
        this.pcCode = pcCode;
    }

    public String getFranchiseSpecialty1() {
        return franchiseSpecialty1;
    }

    public void setFranchiseSpecialty1(String franchiseSpecialty1) {
        this.franchiseSpecialty1 = franchiseSpecialty1;
    }

    public String getFranchiseSpecialty2() {
        return franchiseSpecialty2;
    }

    public void setFranchiseSpecialty2(String franchiseSpecialty2) {
        this.franchiseSpecialty2 = franchiseSpecialty2;
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

    public BigInteger getDeliveryPointBarCode() {
        return deliveryPointBarCode;
    }

    public void setDeliveryPointBarCode(BigInteger deliveryPointBarCode) {
        this.deliveryPointBarCode = deliveryPointBarCode;
    }

    public String getCarrierRoute() {
        return carrierRoute;
    }

    public void setCarrierRoute(String carrierRoute) {
        this.carrierRoute = carrierRoute;
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
        if (!(object instanceof Bizbystate)) {
            return false;
        }
        Bizbystate other = (Bizbystate) object;
        if ((this.rownum == null && other.rownum != null) || (this.rownum != null && !this.rownum.equals(other.rownum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "src.entities.Bizbystate[ rownum=" + rownum + " ]";
    }
    
}
