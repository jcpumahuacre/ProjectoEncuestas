/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.paquetes.modelo;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "alternativa")
@NamedQueries({
    @NamedQuery(name = "Alternativa.findAll", query = "SELECT a FROM Alternativa a")
    , @NamedQuery(name = "Alternativa.findByIdAlternativa", query = "SELECT a FROM Alternativa a WHERE a.idAlternativa = :idAlternativa")
    , @NamedQuery(name = "Alternativa.findByDescripcion", query = "SELECT a FROM Alternativa a WHERE a.descripcion = :descripcion")
    , @NamedQuery(name = "Alternativa.findByValor", query = "SELECT a FROM Alternativa a WHERE a.valor = :valor")})
public class Alternativa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idalternativa")
    private Integer idAlternativa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "valor")
    private Boolean valor;
    @JoinColumn(name = "pregunta_idpregunta", referencedColumnName = "idpregunta")
    @ManyToOne(optional = false)
    private Pregunta preguntaidPregunta;
    @JoinColumn(name = "tipoalternativa_idtipoalternativa", referencedColumnName = "idtipoalternativa")
    @ManyToOne(optional = false)
    private Tipoalternativa tipoAlternativaidTipoAlternativa;

    public Alternativa() {
    }

    public Alternativa(Integer idAlternativa) {
        this.idAlternativa = idAlternativa;
    }

    public Alternativa(Integer idAlternativa, String descripcion) {
        this.idAlternativa = idAlternativa;
        this.descripcion = descripcion;
    }

    public Integer getIdAlternativa() {
        return idAlternativa;
    }

    public void setIdAlternativa(Integer idAlternativa) {
        this.idAlternativa = idAlternativa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getValor() {
        return valor;
    }

    public void setValor(Boolean valor) {
        this.valor = valor;
    }

    public Pregunta getPreguntaidPregunta() {
        return preguntaidPregunta;
    }

    public void setPreguntaidPregunta(Pregunta preguntaidPregunta) {
        this.preguntaidPregunta = preguntaidPregunta;
    }

    public Tipoalternativa getTipoAlternativaidTipoAlternativa() {
        return tipoAlternativaidTipoAlternativa;
    }

    public void setTipoAlternativaidTipoAlternativa(Tipoalternativa tipoAlternativaidTipoAlternativa) {
        this.tipoAlternativaidTipoAlternativa = tipoAlternativaidTipoAlternativa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlternativa != null ? idAlternativa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alternativa)) {
            return false;
        }
        Alternativa other = (Alternativa) object;
        if ((this.idAlternativa == null && other.idAlternativa != null) || (this.idAlternativa != null && !this.idAlternativa.equals(other.idAlternativa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.eliminarlo.Alternativa[ idAlternativa=" + idAlternativa + " ]";
    }
    
}
