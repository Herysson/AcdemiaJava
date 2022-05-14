package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DAO {
	
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	private String url = "jdbc:mysql://127.0.0.1:3306/matricula?useTimezone=true&serverTimezone=UTC";
	
	private String user = "root";
	
	private String password = "Herysson07";
	
	//conctar
	private Connection conectar() {
		Connection con = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
			
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}	
	}
	
	public void inserirAluno(JavaBeans aluno) {
		//insert into alunos (id, nome, email, fone)
		//values ("765478", "Herysson R. Figueiredo", "heryssonf@gmail.com", "55 999918877");
		String create = "insert into alunos (id, nome, email, fone) values (?,?,?,?)";
		
		try {
			//abrindo a conexão
			Connection con = conectar();
			//epparara a query
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, aluno.getId());
			pst.setString(2, aluno.getNome());
			pst.setString(3, aluno.getEmail());
			pst.setString(4, aluno.getFone());
			//excutar a query
			pst.executeUpdate();
			//Encerar conexão
			con.close();
		}catch(Exception e) {
			System.out.println(e);
		}	
	}

}
