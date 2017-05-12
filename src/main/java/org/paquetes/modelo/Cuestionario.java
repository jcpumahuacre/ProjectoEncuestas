
package org.paquetes.modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "cuestionario")
@NamedQueries({
    @NamedQuery(name = "Cuestionario.findAll", query = "SELECT c FROM Cuestionario c")
    , @NamedQuery(name = "Cuestionario.findByIdCuestionario", query = "SELECT c FROM Cuestionario c WHERE c.idCuestionario = :idCuestionario")
    , @NamedQuery(name = "Cuestionario.findByTitulo", query = "SELECT c FROM Cuestionario c WHERE c.titulo = :titulo")
    , @NamedQuery(name = "Cuestionario.findByFechaCreacion", query = "SELECT c FROM Cuestionario c WHERE c.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "Cuestionario.findByEstado", query = "SELECT c FROM Cuestionario c WHERE c.estado = :estado")
    , @NamedQuery(name = "Cuestionario.findByFechaInicio", query = "SELECT c FROM Cuestionario c WHERE c.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Cuestionario.findByFechaFin", query = "SELECT c FROM Cuestionario c WHERE c.fechaFin = :fechaFin")})
public class Cuestionario implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcuestionario")
    private Integer idCuestionario;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "titulo")
    private String titulo;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechacreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "estado")
    private String estado;
    
    @Column(name = "fechainicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    
    @Column(name = "fechafin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    
    @JoinColumn(name = "categoria_idcategoria", referencedColumnName = "idcategoria")
    @ManyToOne(optional = false)
    private Categoria categoriaidCategoria;
    
    @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario usuarioidUsuario;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuestionarioidCuestionario1")
    private Collection<Pregunta> preguntaCollection;

    public Cuestionario() {
    }

    public Cuestionario(Integer idCuestionario) {
        this.idCuestionario = idCuestionario;
    }

    public Cuestionario(Integer idCuestionario, String titulo, Date fechaCreacion, String estado) {
        this.idCuestionario = idCuestionario;
        this.titulo = titulo;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
    }

    public Integer getIdCuestionario() {
        return idCuestionario;
    }

    public void setIdCuestionario(Integer idCuestionario) {
        this.idCuestionario = idCuestionario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Categoria getCategoriaidCategoria() {
        return categoriaidCategoria;
    }

    public void setCategoriaidCategoria(Categoria categoriaidCategoria) {
        this.categoriaidCategoria = categoriaidCategoria;
    }

    public Usuario getUsuarioidUsuario() {
        return usuarioidUsuario;
    }

    public void setUsuarioidUsuario(Usuario usuarioidUsuario) {
        this.usuarioidUsuario = usuarioidUsuario;
    }

    public Collection<Pregunta> getPreguntaCollection() {
        return preguntaCollection;
    }

    public void setPreguntaCollection(Collection<Pregunta> preguntaCollection) {
        this.preguntaCollection = preguntaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCuestionario != null ? idCuestionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuestionario)) {
            return false;
        }
        Cuestionario other = (Cuestionario) object;
        if ((this.idCuestionario == null && other.idCuestionario != null) || (this.idCuestionario != null && !this.idCuestionario.equals(other.idCuestionario))) {
            return false;
        }
        return true;
    }

    
    
	@Override
	public String toString() {
		return "Cuestionario [idCuestionario=" + idCuestionario + ", titulo=" + titulo + ", fechaCreacion="
				+ fechaCreacion + ", estado=" + estado + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin
				+ ", categoriaidCategoria=" + categoriaidCategoria + ", usuarioidUsuario=" + usuarioidUsuario + "]";
	}

    
    
    /*
    @Override
    public String toString() {
        return "com.mycompany.eliminarlo.Cuestionario[ idCuestionario=" + idCuestionario + " ]";
    }
    */
    
}
