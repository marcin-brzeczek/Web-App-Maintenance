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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marcin
 */
@Entity
@Table(name = "maszyna")
@NamedQueries({
    @NamedQuery(name = "Maszyna.findAll", query = "SELECT m FROM Maszyna m"),
    @NamedQuery(name = "Maszyna.findById", query = "SELECT m FROM Maszyna m WHERE m.id = :id"),
    @NamedQuery(name = "Maszyna.findByNazwaLinii", query = "SELECT m FROM Maszyna m WHERE m.nazwaLinii = :nazwaLinii"),
    @NamedQuery(name = "Maszyna.findByNazwaMaszyny", query = "SELECT m FROM Maszyna m WHERE m.nazwaMaszyny = :nazwaMaszyny"),
    @NamedQuery(name = "Maszyna.findByDostepnosc", query = "SELECT m FROM Maszyna m WHERE m.dostepnosc = :dostepnosc"),
    @NamedQuery(name = "Maszyna.findByDokumentacja", query = "SELECT m FROM Maszyna m WHERE m.dokumentacja = :dokumentacja")})

public class Maszyna implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nazwa_linii", nullable = false, length = 50)
    private String nazwaLinii;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nazwa_maszyny", nullable = false, length = 50)
    private String nazwaMaszyny;
    @Lob
  
    @Size(max = 64)
    @Column(name = "dostepnosc", length = 64)
    private String dostepnosc;
    
    @Column(name = "dokumentacja")
    private byte[] dokumentacja;
    
    @OneToMany(mappedBy = "maszynaID", fetch = FetchType.EAGER)
    private Set<Operator> operatorSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maszyna", fetch = FetchType.EAGER)
    private Set<Awaria> awariaSet;
    
    

    public Maszyna() {
    }

    public Maszyna(Integer id) {
        this.id = id;
    }

    public Maszyna(Integer id, String nazwaLinii, String nazwaMaszyny) {
        this.id = id;
        this.nazwaLinii = nazwaLinii;
        this.nazwaMaszyny = nazwaMaszyny;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazwaLinii() {
        return nazwaLinii;
    }

    public void setNazwaLinii(String nazwaLinii) {
        this.nazwaLinii = nazwaLinii;
    }

    public String getNazwaMaszyny() {
        return nazwaMaszyny;
    }

    public void setNazwaMaszyny(String nazwaMaszyny) {
        this.nazwaMaszyny = nazwaMaszyny;
    }

//  
//
    public byte[] getDokumentacja() {
        return dokumentacja;
    }

    public void setDokumentacja(byte[] dokumentacja) {
        this.dokumentacja = dokumentacja;
    }

    public String getDostepnosc() {
        return dostepnosc;
    }

    public void setDostepnosc(String dostepnosc) {
        this.dostepnosc = dostepnosc;
    }

    @XmlTransient
    public Set<Operator> getOperatorSet() {
        return operatorSet;
    }

    public void setOperatorSet(Set<Operator> operatorSet) {
        this.operatorSet = operatorSet;
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
        if (!(object instanceof Maszyna)) {
            return false;
        }
        Maszyna other = (Maszyna) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Maszyna[ id=" + id + " ]";
    }
    
}
