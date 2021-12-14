package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private static String senha;
	private static Connection conexao=null;
	
	private Conexao() {
		
	}
	
	public static void setSenha(String umaSenha) {
		senha=umaSenha;
	}
	@SuppressWarnings("exports")
	public static Connection getConexao()throws ClassNotFoundException,SQLException{
		if(conexao==null) {
			String url="jdbc:postgresql://localhost:5432/reserva";
			String username="postgres";
			
			try {
				Class.forName("org.postgresql.Driver");
				conexao =DriverManager.getConnection(url, username, senha);
			}
			catch(SQLException e){
				System.out.print("erro ao acessar o banco");
				e.printStackTrace();
			}
			catch(ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			
		}
		return conexao;
	}
}
