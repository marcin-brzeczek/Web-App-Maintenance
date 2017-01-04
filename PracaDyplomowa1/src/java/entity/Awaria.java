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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull; 
import javax.validation.constraints.Size;

/**
 *
 * @author Marcin
 */
@Entity
@Table(name = "awaria", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"maszyna", "data"}),
    @UniqueConstraint(columnNames = {"pracownik_ur", "data"}),
    @UniqueConstraint(columnNames = {"operator", "data"})})
@NamedQueries({
    @NamedQuery(name = "Awaria.findAll", query = "SELECT a FROM Awaria a"),
    @NamedQuery(name = "Awaria.findByPracownikUr", query = "SELECT a FROM Awaria a WHERE a.awariaPK.pracownikUr = :pracownikUr"),
    @NamedQuery(name = "Awaria.findByOperator", query = "SELECT a FROM Awaria a WHERE a.awariaPK.operator = :operator"),
    @NamedQuery(name = "Awaria.findByData", query = "SELECT a FROM Awaria a WHERE a.awariaPK.data = :data"),
    @NamedQuery(name = "Awaria.findByCzyPracuje", query = "SELECT a FROM Awaria a WHERE a.czyPracuje = :czyPracuje")})
public class Awaria implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AwariaPK awariaPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "czy_pracuje", nullable = false, length = 50)
    private String czyPracuje;
    @JoinColumn(name = "maszyna", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Maszyna maszyna;
    @JoinColumn(name = "operator", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Operator operator1;
    @JoinColumn(name = "pracownik_ur", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private PracownikUr pracownikUr1;

    public Awaria() {
    }

    public Awaria(AwariaPK awariaPK) {
        this.awariaPK = awariaPK;
    }

    public Awaria(AwariaPK awariaPK, String czyPracuje) {
        this.awariaPK = awariaPK;
        this.czyPracuje = czyPracuje;
    }

    public Awaria(int pracownikUr, int operator, Date data) {
        this.awariaPK = new AwariaPK(pracownikUr, operator, data);
    }

    public AwariaPK getAwariaPK() {
        return awariaPK;
    }

    public void setAwariaPK(AwariaPK awariaPK) {
        this.awariaPK = awariaPK;
    }

    public String getCzyPracuje() {
        return czyPracuje;
    }

    public void setCzyPracuje(String czyPracuje) {
        this.czyPracuje = czyPracuje;
    }

    public Maszyna getMaszyna() {
        return maszyna;
    }

    public void setMaszyna(Maszyna maszyna) {
        this.maszyna = maszyna;
    }

    public Operator getOperator1() {
        return operator1;
    }

    public void setOperator1(Operator operator1) {
        this.operator1 = operator1;
    }

    public PracownikUr getPracownikUr1() {
        return pracownikUr1;
    }

    public void setPracownikUr1(PracownikUr pracownikUr1) {
        this.pracownikUr1 = pracownikUr1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (awariaPK != null ? awariaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Awaria)) {
            return false;
        }
        Awaria other = (Awaria) object;
        if ((this.awariaPK == null && other.awariaPK != null) || (this.awariaPK != null && !this.awariaPK.equals(other.awariaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Awaria[ awariaPK=" + awariaPK + " ]";
    }
    
}
