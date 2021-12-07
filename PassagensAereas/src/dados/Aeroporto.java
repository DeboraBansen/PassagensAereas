package dados;
import java.lang.StringBuilder;

public class Aeroporto {
	private int cod;
	private String nome;
	private int cod_cid;
	
	public int getCod() {
		return cod;
	}
	public String getNome() {
		return nome;
	}
	public int getCod_cid() {
		return cod_cid;
	}
	public void setCod(int cod) {
		this.cod=cod;
	}
	public void setNome(String nome) {
		this.nome=nome;
	}
	public void setCod_cid(int cod_cid) {
		this.cod_cid=cod_cid;
	}
	
	public String toString() {
		StringBuilder aeroporto=new StringBuilder();
		
		aeroporto.append("\tCódigo : "+this.cod+" \n");
		aeroporto.append("\t Nome : "+this.nome+" \n");
		aeroporto.append("\t Código Cidade : "+this.cod_cid+" \n");
		
		return aeroporto.toString();
	}
	
}
