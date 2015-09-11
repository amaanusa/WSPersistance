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
@Table(name = "usadb_tablestructure")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsadbTablestructure.findAll", query = "SELECT u FROM UsadbTablestructure u"),
    @NamedQuery(name = "UsadbTablestructure.findByState", query = "SELECT u FROM UsadbTablestructure u WHERE u.state = :state")})
public class UsadbTablestructure implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(nullable = false, length = 2)
    private String state;
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String columns;

    public UsadbTablestructure() {
    }

    public UsadbTablestructure(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getColumns() {
        return columns;
    }

    public void setColumns(String columns) {
        this.columns = columns;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (state != null ? state.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsadbTablestructure)) {
            return false;
        }
        UsadbTablestructure other = (UsadbTablestructure) object;
        if ((this.state == null && other.state != null) || (this.state != null && !this.state.equals(other.state))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "src.entities.UsadbTablestructure[ state=" + state + " ]";
    }

}
