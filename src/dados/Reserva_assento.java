package dados;
import java.lang.StringBuilder;
import java.sql.Date;

public class Reserva_assento {
	private int cod_assento;
	private Date data_reserva;
	private int num_poltrona;
	private int cod;
	
	public int getCod_assento() {
		return cod_assento;
	}
	@SuppressWarnings("exports")
	public Date getData_reserva() {
		return data_reserva;
	}
	public int getNum_poltrona() {
		return num_poltrona;
	}
	public int getCod() {
		return cod;
	}
	
	public void setCod_assento(int cod_assento) {
		this.cod_assento=cod_assento;
	}
	public void setData_reserva(@SuppressWarnings("exports") Date data_reserva) {
		this.data_reserva=data_reserva;
	}
	public void setNum_poltrona(int num_poltrona) {
		this.num_poltrona=num_poltrona;
	}
	public void setCod(int cod) {
		this.cod=cod;
	}
	
	public String toString() {
		StringBuilder reserva_assento=new StringBuilder();
		
		reserva_assento.append("\tCódigo : "+this.cod_assento+" \n");
		reserva_assento.append("\tData Reserva : "+this.data_reserva+" \n");
		reserva_assento.append("\tNúmero de Poltronas : "+this.num_poltrona+" \n");
		reserva_assento.append("\tCódigo da Aeronave : "+this.cod+" \n");
		
		return reserva_assento.toString();
	}
}
