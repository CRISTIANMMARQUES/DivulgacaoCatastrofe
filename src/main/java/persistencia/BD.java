
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BD {
    static final String URL_BD = "jdbc:mysql://localhost:3306/divulgacaocatastrofes?zeroDateTimeBehavior=CONVERT_TO_NULL";
    static final String USUÁRIO = "root";
    static final String SENHA = "admin";
    public static Connection conexão = null;
    public static Statement comando = null;
    
    public static void criarConexão() {
        try {
            conexão = DriverManager.getConnection(URL_BD, USUÁRIO, SENHA);
            comando = conexão.createStatement();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }
    }
    
    public static void fechaConexão() {
        try {
            comando.close();
            conexão.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }
    }
}