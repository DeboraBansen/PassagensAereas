package dados;
import java.lang.StringBuilder;

public class Aeronave {
	private int cod;
	private String nome;
	private int qtd_poltrona;
	
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod=cod;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome=nome;
	}
	
	public int getQtd_poltrona() {
		return qtd_poltrona;
	}
	public void setQtd_poltrona(int qtd_poltrona) {
		this.qtd_poltrona=qtd_poltrona;
	}
	
	public String toString() {
		StringBuilder aeronave=new StringBuilder();
		
		aeronave.append("\tCódigo : "+this.cod+" \n");
		aeronave.append("\t Nome : "+this.nome+" \n");
		aeronave.append("\t Quantidade de Poltrona : "+this.qtd_poltrona+" \n");
		
		
		return aeronave.toString();
	}
}
