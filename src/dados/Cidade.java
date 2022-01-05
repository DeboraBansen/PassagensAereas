package dados;
import java.lang.StringBuilder;


public class Cidade {
	private int cod_cid;
	private String cidade;
	private String estado;
	private String pais;
	
	public int getCod_cid() {
		return cod_cid;
	}
	public void setCod_cid(int cod_cid) {
		this.cod_cid=cod_cid;
	}
	
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade=cidade;
	}
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado=estado;
	}
	
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais=pais;
	}
	
	public String toString() {
		StringBuilder cidade=new StringBuilder();
		
		cidade.append("\tCódigo : "+this.cod_cid+" \n");
		cidade.append("\t Cidade : "+this.cidade+" \n");
		cidade.append("\t Estado : "+this.estado+" \n");
		cidade.append("\t País : "+this.pais+" \n");
		
		
		return cidade.toString();
	}
}
