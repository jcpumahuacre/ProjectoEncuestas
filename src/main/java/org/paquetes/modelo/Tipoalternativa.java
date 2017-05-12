/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.paquetes.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Julio Puma
 */
@Entity
@Table(name = "tipoalternativa")
@NamedQueries({
    @NamedQuery(name = "Tipoalternativa.findAll", query = "SELECT t FROM Tipoalternativa t")
    , @NamedQuery(name = "Tipoalternativa.findByIdTipoAlternativa", query = "SELECT t FROM Tipoalternativa t WHERE t.idTipoAlternativa = :idTipoAlternativa")
    , @NamedQuery(name = "Tipoalternativa.findByDescripcion", query = "SELECT t FROM Tipoalternativa t WHERE t.descripcion = :descripcion")})
public class Tipoalternativa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtipoalternativa")
    private Integer idTipoAlternativa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoAlternativaidTipoAlternativa")
    private Collection<Alternativa> alternativaCollection;

    public Tipoalternativa() {
    }

    public Tipoalternativa(Integer idTipoAlternativa) {
        this.idTipoAlternativa = idTipoAlternativa;
    }

    public Tipoalternativa(Integer idTipoAlternativa, String descripcion) {
        this.idTipoAlternativa = idTipoAlternativa;
        this.descripcion = descripcion;
    }

    public Integer getIdTipoAlternativa() {
        return idTipoAlternativa;
    }

    public void setIdTipoAlternativa(Integer idTipoAlternativa) {
        this.idTipoAlternativa = idTipoAlternativa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Collection<Alternativa> getAlternativaCollection() {
        return alternativaCollection;
    }

    public void setAlternativaCollection(Collection<Alternativa> alternativaCollection) {
        this.alternativaCollection = alternativaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoAlternativa != null ? idTipoAlternativa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoalternativa)) {
            return false;
        }
        Tipoalternativa other = (Tipoalternativa) object;
        if ((this.idTipoAlternativa == null && other.idTipoAlternativa != null) || (this.idTipoAlternativa != null && !this.idTipoAlternativa.equals(other.idTipoAlternativa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.eliminarlo.Tipoalternativa[ idTipoAlternativa=" + idTipoAlternativa + " ]";
    }
    
}
