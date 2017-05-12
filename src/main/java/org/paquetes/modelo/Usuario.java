package org.paquetes.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="idusuario")
	int idUsuario;
	@Column(name="apellidopaterno")
	String apellidoPaterno;
	@Column(name="apellidomaterno")
	String apellidoMaterno;
	String nombre;
	String correo;
	
	public Usuario(){
		
	}
	public Usuario(int idUsuario, String apellidoPaterno, String apellidoMaterno, String nombre, String correo) {
		this.idUsuario = idUsuario;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.nombre = nombre;
		this.correo = correo;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	@Override
	public String toString() {
		System.out.println("Usuario [idUsuario=" + idUsuario + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno="
				+ apellidoMaterno + ", nombre=" + nombre + ", correo=" + correo + "]");
		
		return "Usuario [idUsuario=" + idUsuario + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno="
				+ apellidoMaterno + ", nombre=" + nombre + ", correo=" + correo + "]";
	}
	
	
}
