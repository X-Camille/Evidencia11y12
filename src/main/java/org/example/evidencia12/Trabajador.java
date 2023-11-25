package org.example.evidencia12;

public class Trabajador extends Persona implements IArchivo {

	private String isapre;
	private String afp;

	public Trabajador(String nombre, String apellido, String rut, String isapre, String afp) {
		super(nombre, apellido, rut);
		this.isapre = isapre;
		this.afp = afp;
	}
	public String getIsapre() {
		return this.isapre;
	}
	public void setIsapre(String isapre) {
		this.isapre = isapre;
	}

	public String getAfp() {
		return this.afp;
	}
	public void setAfp(String afp) {
		this.afp = afp;
	}

	@Override
	public void leer() {
	}

	@Override
	public void editar() {

	}

	@Override
	public void agregar() {

	}

	public String toString(){
		return getNombre() + ", " + getApellido() + ", " + getRut() + ", " + getIsapre() + ", " + getAfp();
	}
}