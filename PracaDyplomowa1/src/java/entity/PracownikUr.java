/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marcin
 */
@Entity
@Table(name = "pracownik_ur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PracownikUr.findAll", query = "SELECT p FROM PracownikUr p"),
    @NamedQuery(name = "PracownikUr.findById", query = "SELECT p FROM PracownikUr p WHERE p.id = :id"),
    @NamedQuery(name = "PracownikUr.findByImie", query = "SELECT p FROM PracownikUr p WHERE p.imie = :imie"),
    @NamedQuery(name = "PracownikUr.findByNazwisko", query = "SELECT p FROM PracownikUr p WHERE p.nazwisko = :nazwisko"),
    @NamedQuery(name = "PracownikUr.findByStanowisko", query = "SELECT p FROM PracownikUr p WHERE p.stanowisko = :stanowisko")})
public class PracownikUr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "imie", nullable = false, length = 50)
    private String imie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nazwisko", nullable = false, length = 50)
    private String nazwisko;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "stanowisko", nullable = false, length = 50)
    private String stanowisko;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pracownikUr1", fetch = FetchType.EAGER)
    private Set<Awaria> awariaSet;

    public PracownikUr() {
    }

    public PracownikUr(Integer id) {
        this.id = id;
    }

    public PracownikUr(Integer id, String imie, String nazwisko, String stanowisko) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.stanowisko = stanowisko;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    @XmlTransient
    public Set<Awaria> getAwariaSet() {
        return awariaSet;
    }

    public void setAwariaSet(Set<Awaria> awariaSet) {
        this.awariaSet = awariaSet;
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
        if (!(object instanceof PracownikUr)) {
            return false;
        }
        PracownikUr other = (PracownikUr) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PracownikUr[ id=" + id + " ]";
    }
    
}
