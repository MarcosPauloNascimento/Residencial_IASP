package residencial.db.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

//import com.mysql.jdbc.Statement;

public class Conexao {
	
	private Connection con;
        public Statement statement;
        public ResultSet result;;
		
	public Conexao()
	{
		
	}
	
	public Connection abrir(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/residencial_iasp";
			con = DriverManager.getConnection(url,"root","adm");
                        
                        return con;
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"Não foi possivel efetuar a conexão " + e);
			e.printStackTrace();
			return null;
		}
	}
        public void fechar()
        {
              try
              {
                  if (con != null && !con.isClosed()){
                      con.close();
      
                  }
              }catch(Exception e)
              {
                      JOptionPane.showMessageDialog(null,"Erro ao fechar a conexão com o banco" + e);
                      e.printStackTrace();
              }
        }

        public void executeSQL (String sql)
        {
            try
            {
                statement = (Statement) con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                result = statement.executeQuery(sql);
            }
            catch(SQLException erro)
            {
                JOptionPane.showMessageDialog(null,"Não foi possivel executar o comando, "+ sql + ",\n "+ erro);


            }
        }
	
	
}
