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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "pregunta")
@NamedQueries({
    @NamedQuery(name = "Pregunta.findAll", query = "SELECT p FROM Pregunta p")
    , @NamedQuery(name = "Pregunta.findByIdPregunta", query = "SELECT p FROM Pregunta p WHERE p.idPregunta = :idPregunta")
    , @NamedQuery(name = "Pregunta.findByDescripcion", query = "SELECT p FROM Pregunta p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "Pregunta.findByCuestionarioidCuestionario", query = "SELECT p FROM Pregunta p WHERE p.cuestionarioidCuestionario = :cuestionarioidCuestionario")
    , @NamedQuery(name = "Pregunta.findByCuestionarioUsuarioidUsuario", query = "SELECT p FROM Pregunta p WHERE p.cuestionarioUsuarioidUsuario = :cuestionarioUsuarioidUsuario")})
public class Pregunta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idpregunta")
    private Integer idPregunta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cuestionario_idcuestionario")
    private int cuestionarioidCuestionario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cuestionario_usuario_idusuario")
    private int cuestionarioUsuarioidUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "preguntaidPregunta")
    private Collection<Alternativa> alternativaCollection;
    @JoinColumn(name = "cuestionario_idcuestionario1", referencedColumnName = "idcuestionario")
    @ManyToOne(optional = false)
    private Cuestionario cuestionarioidCuestionario1;

    public Pregunta() {
    }

    public Pregunta(Integer idPregunta) {
        this.idPregunta = idPregunta;
    }

    public Pregunta(Integer idPregunta, String descripcion, int cuestionarioidCuestionario, int cuestionarioUsuarioidUsuario) {
        this.idPregunta = idPregunta;
        this.descripcion = descripcion;
        this.cuestionarioidCuestionario = cuestionarioidCuestionario;
        this.cuestionarioUsuarioidUsuario = cuestionarioUsuarioidUsuario;
    }

    public Integer getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(Integer idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCuestionarioidCuestionario() {
        return cuestionarioidCuestionario;
    }

    public void setCuestionarioidCuestionario(int cuestionarioidCuestionario) {
        this.cuestionarioidCuestionario = cuestionarioidCuestionario;
    }

    public int getCuestionarioUsuarioidUsuario() {
        return cuestionarioUsuarioidUsuario;
    }

    public void setCuestionarioUsuarioidUsuario(int cuestionarioUsuarioidUsuario) {
        this.cuestionarioUsuarioidUsuario = cuestionarioUsuarioidUsuario;
    }

    public Collection<Alternativa> getAlternativaCollection() {
        return alternativaCollection;
    }

    public void setAlternativaCollection(Collection<Alternativa> alternativaCollection) {
        this.alternativaCollection = alternativaCollection;
    }

    public Cuestionario getCuestionarioidCuestionario1() {
        return cuestionarioidCuestionario1;
    }

    public void setCuestionarioidCuestionario1(Cuestionario cuestionarioidCuestionario1) {
        this.cuestionarioidCuestionario1 = cuestionarioidCuestionario1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPregunta != null ? idPregunta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pregunta)) {
            return false;
        }
        Pregunta other = (Pregunta) object;
        if ((this.idPregunta == null && other.idPregunta != null) || (this.idPregunta != null && !this.idPregunta.equals(other.idPregunta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.eliminarlo.Pregunta[ idPregunta=" + idPregunta + " ]";
    }
    
}
