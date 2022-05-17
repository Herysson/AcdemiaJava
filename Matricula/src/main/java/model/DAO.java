package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


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
	
	//CRUD - READ recupera os valores contidos no Banco de dados - Tabela alunos
	public ArrayList<JavaBeans> listarAlunos(){
		
		ArrayList<JavaBeans> alunos = new ArrayList();
		
		String read = "select * from alunos order by nome;";
		
		try {
			//abrindo a conexão
			Connection con = conectar();
			//epparara a query
			PreparedStatement pst = con.prepareStatement(read);
			//Executa a query e armazena na variavel rs
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				String id = rs.getString(1);
				String nome = rs.getString(2);
				String email = rs.getString(3);
				String fone = rs.getString(4);
				//armazenar os valores no ArrayList
				alunos.add(new JavaBeans(id,nome,email,fone));
			}
			con.close();
			return alunos;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	//CRUDE - DELETE - remove um registro do banco de dados
	public void deletarAluno(JavaBeans aluno) {
		String delete = "delete from alunos where id = ?;";
		try {
			//abrindo a conexão
			Connection con = conectar();
			//epparara a query
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, aluno.getId());
			pst.executeUpdate();
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
