package dados;
import java.lang.StringBuilder;

public class Passageiro {
	private int cod_p;
	private String nome;
	
	public int getCod_p() {
		return cod_p;
	}
	public void setCod_p(int cod_p) {
		this.cod_p=cod_p;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome=nome;
	}
	
	public String toString() {
		StringBuilder passageiro=new StringBuilder();
		
		passageiro.append("\tCódigo : "+this.cod_p+" \n");
		passageiro.append("\t Nome : "+this.nome+" \n");
		
		return passageiro.toString();
	}
}
