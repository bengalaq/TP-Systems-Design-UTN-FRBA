package entrega1;

import java.time.LocalDate;
import java.time.LocalTime;
import entrega2.Usuario;

public class Busqueda {

	//ATRIBUTOS
	public Usuario usuario;
	String tagBuscado;
	int resultadosDevueltos;
	long duracionDeConsulta;
	LocalDate fechaDeLaBusqueda;



	//GETTERS Y SETTERS


	public String getTagBuscado() {
		return tagBuscado;
	}
	public void setTagBuscado(String tagBuscado) {
		this.tagBuscado = tagBuscado;
	}
	public int getResultadosDevueltos() {
		return resultadosDevueltos;
	}
	public void setResultadosDevueltos(int resultadosDevueltos) {
		this.resultadosDevueltos = resultadosDevueltos;
	}
	public long getDuracionDeConsulta() {
		return duracionDeConsulta;
	}
	public void setDuracionDeConsulta(long duracionDeConsulta) {
		this.duracionDeConsulta = duracionDeConsulta;
	}
	public LocalDate getFechaDeLaBusqueda() {
		return fechaDeLaBusqueda;
	}
	public void setFechaDeLaBusqueda(LocalDate fechaDeLaBusqueda) {
		this.fechaDeLaBusqueda = fechaDeLaBusqueda;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario u) {
		this.usuario = u;
	}
	
	


}
