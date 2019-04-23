package com.hippsterhouse.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Lieferant.
 */
@Entity
@Table(name = "lieferant")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Lieferant implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "lname", nullable = false)
    private String lname;

    @OneToMany(mappedBy = "lieferant")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Artikel> lnames = new HashSet<>();
    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLname() {
        return lname;
    }

    public Lieferant lname(String lname) {
        this.lname = lname;
        return this;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Set<Artikel> getLnames() {
        return lnames;
    }

    public Lieferant lnames(Set<Artikel> artikels) {
        this.lnames = artikels;
        return this;
    }

    public Lieferant addLname(Artikel artikel) {
        this.lnames.add(artikel);
        artikel.setLieferant(this);
        return this;
    }

    public Lieferant removeLname(Artikel artikel) {
        this.lnames.remove(artikel);
        artikel.setLieferant(null);
        return this;
    }

    public void setLnames(Set<Artikel> artikels) {
        this.lnames = artikels;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lieferant lieferant = (Lieferant) o;
        if (lieferant.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), lieferant.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Lieferant{" +
            "id=" + getId() +
            ", lname='" + getLname() + "'" +
            "}";
    }
}
