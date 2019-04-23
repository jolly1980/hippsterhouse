package com.hippsterhouse.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Artikel.
 */
@Entity
@Table(name = "artikel")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Artikel implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3)
    @Column(name = "artikelbezeichnung", nullable = false)
    private String artikelbezeichnung;

    @NotNull
    @Column(name = "preis", nullable = false)
    private Double preis;

    @ManyToOne
    @JsonIgnoreProperties("lnames")
    private Lieferant lieferant;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArtikelbezeichnung() {
        return artikelbezeichnung;
    }

    public Artikel artikelbezeichnung(String artikelbezeichnung) {
        this.artikelbezeichnung = artikelbezeichnung;
        return this;
    }

    public void setArtikelbezeichnung(String artikelbezeichnung) {
        this.artikelbezeichnung = artikelbezeichnung;
    }

    public Double getPreis() {
        return preis;
    }

    public Artikel preis(Double preis) {
        this.preis = preis;
        return this;
    }

    public void setPreis(Double preis) {
        this.preis = preis;
    }

    public Lieferant getLieferant() {
        return lieferant;
    }

    public Artikel lieferant(Lieferant lieferant) {
        this.lieferant = lieferant;
        return this;
    }

    public void setLieferant(Lieferant lieferant) {
        this.lieferant = lieferant;
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
        Artikel artikel = (Artikel) o;
        if (artikel.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), artikel.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Artikel{" +
            "id=" + getId() +
            ", artikelbezeichnung='" + getArtikelbezeichnung() + "'" +
            ", preis=" + getPreis() +
            "}";
    }
}
