package dados;
import java.lang.StringBuilder;

public class Voos {
	private int cod_voo;
	private String classe;
	private int cod_dtHora;
	private int cod_trecho;
	
	public int getCodVoo() {
		return cod_voo;
	}
	public String getClasse() {
		return classe;
	}
	public int getCod_dtHora() {
		return cod_dtHora;
	}
	public int getCod_trecho() {
		return cod_trecho;
	}
	
	public void setCodVoo(int cod_voo) {
		this.cod_voo=cod_voo;
	}
	public void setClasse(String classe) {
		this.classe=classe;
	}
	public void setCod_dtHora(int cod_dtHora) {
		this.cod_dtHora=cod_dtHora;
	}
	public void setCod_trecho(int cod_trecho) {
		this.cod_trecho=cod_trecho;
	}
	
	public String toString() {
		StringBuilder voos=new StringBuilder();
		
		voos.append("\tCódigo : "+this.cod_voo+" \n");
		voos.append("\tClasse : "+this.classe+" \n");
		voos.append("\tCódigo data/Hora : "+this.cod_dtHora+" \n");
		voos.append("\tCódigo do Trecho : "+this.cod_trecho+" \n");
		
		return voos.toString();
	}
}
