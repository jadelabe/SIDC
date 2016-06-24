package database.classes;

import java.sql.Date;

public class Antropometricas {

	private Date fecha;
	private float talla, peso, cintura, cadera, pecho, pliegue_escapular, pliegue_bicipital, pliegue_tricipital,
			pligue_abdominal, imc, igc, tmb;
	private int Paciente_ID;

	public Antropometricas(Date fecha, float talla, float peso, float cintura, float cadera, float pecho,
			float pliegue_escapular, float pliegue_bicipital, float pliegue_tricipital, float pligue_abdominal,
			float imc, float igc, float tmb, int paciente_ID) {
		super();
		this.fecha = fecha;
		this.talla = talla;
		this.peso = peso;
		this.cintura = cintura;
		this.cadera = cadera;
		this.pecho = pecho;
		this.pliegue_escapular = pliegue_escapular;
		this.pliegue_bicipital = pliegue_bicipital;
		this.pliegue_tricipital = pliegue_tricipital;
		this.pligue_abdominal = pligue_abdominal;
		this.imc = imc;
		this.igc = igc;
		this.tmb = tmb;
		Paciente_ID = paciente_ID;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public float getTalla() {
		return talla;
	}

	public void setTalla(float talla) {
		this.talla = talla;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getCintura() {
		return cintura;
	}

	public void setCintura(float cintura) {
		this.cintura = cintura;
	}

	public float getCadera() {
		return cadera;
	}

	public void setCadera(float cadera) {
		this.cadera = cadera;
	}

	public float getPecho() {
		return pecho;
	}

	public void setPecho(float pecho) {
		this.pecho = pecho;
	}

	public float getPliegue_escapular() {
		return pliegue_escapular;
	}

	public void setPliegue_escapular(float pliegue_escapular) {
		this.pliegue_escapular = pliegue_escapular;
	}

	public float getPliegue_bicipital() {
		return pliegue_bicipital;
	}

	public void setPliegue_bicipital(float pliegue_bicipital) {
		this.pliegue_bicipital = pliegue_bicipital;
	}

	public float getPliegue_tricipital() {
		return pliegue_tricipital;
	}

	public void setPliegue_tricipital(float pliegue_tricipital) {
		this.pliegue_tricipital = pliegue_tricipital;
	}

	public float getPligue_abdominal() {
		return pligue_abdominal;
	}

	public void setPligue_abdominal(float pligue_abdominal) {
		this.pligue_abdominal = pligue_abdominal;
	}

	public float getImc() {
		return imc;
	}

	public void setImc(float imc) {
		this.imc = imc;
	}

	public float getIgc() {
		return igc;
	}

	public void setIgc(float igc) {
		this.igc = igc;
	}

	public float getTmb() {
		return tmb;
	}

	public void setTmb(float tmb) {
		this.tmb = tmb;
	}

	public int getPaciente_ID() {
		return Paciente_ID;
	}

	public void setPaciente_ID(int paciente_ID) {
		Paciente_ID = paciente_ID;
	}

}
