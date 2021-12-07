package dados;
import java.lang.StringBuilder;

public class Trecho {
	private int cod_trecho;
	private int origem;
	private int destino;
	private int cod_assento;
	private int aero_origem;
	private int aero_destino;
	
	public int getCod_trecho() {
		return cod_trecho;
	}
	public int getOrigem() {
		return origem;
	}
	public int getDestino() {
		return destino;
	}
	public int getCod_assento() {
		return cod_assento;
	}
	public int getAero_origem() {
		return aero_origem;
	}
	public int getAero_destino() {
		return aero_destino;
	}
	
	public void setCod_trecho(int cod_trecho) {
		this.cod_trecho=cod_trecho;
	}
	public void setOrigem(int origem) {
		this.origem=origem;
	}
	public void setDestino(int destino) {
		this.destino=destino;
	}
	public void setCod_assento(int cod_assento) {
		this.cod_assento=cod_assento;
	}
	public void setAero_origem(int aero_origem) {
		this.aero_origem=aero_origem;
	}
	public void setAero_destino(int aero_destino) {
		this.aero_destino=aero_destino;
	}
	
	
	public String toString() {
		StringBuilder trecho=new StringBuilder();
		
		trecho.append("\tCódigo : "+this.cod_trecho+" \n");
		trecho.append("\tOrigem : "+this.origem+" \n");
		trecho.append("\tDestino : "+this.destino+" \n");
		trecho.append("\tCódigo do Assento : "+this.cod_assento+" \n");
		trecho.append("\tAeroporto de Origem : "+this.aero_origem+" \n");
		trecho.append("\tAeroporto de Destino : "+this.aero_destino+" \n");
		
		return trecho.toString();
	}
}
