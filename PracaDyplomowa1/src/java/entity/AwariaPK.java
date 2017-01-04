/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Marcin
 */
@Embeddable
public class AwariaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "pracownik_ur", nullable = false)
    private int pracownikUr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "operator", nullable = false)
    private int operator;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    public AwariaPK() {
    }

    public AwariaPK(int pracownikUr, int operator, Date data) {
        this.pracownikUr = pracownikUr;
        this.operator = operator;
        this.data = data;
    }

    public int getPracownikUr() {
        return pracownikUr;
    }

    public void setPracownikUr(int pracownikUr) {
        this.pracownikUr = pracownikUr;
    }

    public int getOperator() {
        return operator;
    }

    public void setOperator(int operator) {
        this.operator = operator;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) pracownikUr;
        hash += (int) operator;
        hash += (data != null ? data.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AwariaPK)) {
            return false;
        }
        AwariaPK other = (AwariaPK) object;
        if (this.pracownikUr != other.pracownikUr) {
            return false;
        }
        if (this.operator != other.operator) {
            return false;
        }
        if ((this.data == null && other.data != null) || (this.data != null && !this.data.equals(other.data))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AwariaPK[ pracownikUr=" + pracownikUr + ", operator=" + operator + ", data=" + data + " ]";
    }
    
}
