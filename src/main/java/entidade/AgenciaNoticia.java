
package entidade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.BD;

public class AgenciaNoticia {
    private String cnpj;
    private String nome;
    private String endereco;
    private String estado;
    private String país;
    private char tipo_agencia_noticia;
    
    public AgenciaNoticia(String cnpj, String nome) {
        this.cnpj = cnpj;
        this.nome = nome;
    }
    
    public AgenciaNoticia(String cnpj, String nome, String endereco, String estado, String país, char tipo_agencia) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.endereco = endereco;
        this.estado = estado;
        this.país = país;
        this.tipo_agencia_noticia = tipo_agencia;
    }
    
    public static String inserirAgenciaNoticia(AgenciaNoticia agenciaNoticia) {
        String sql = "INSERT INTO agencia (cnpj, nome, endereco, estado, país, tipo)" + "VALUES(?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, agenciaNoticia.getCnpj());
            comando.setString(2, agenciaNoticia.getNome());
            comando.setString(3, agenciaNoticia.getEndereco());
            comando.setString(4, agenciaNoticia.getEstado());
            comando.setString(5, agenciaNoticia.getPais());
            comando.setString(6, (agenciaNoticia.getTipo_agencia_noticia()+""));
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            return "Erro na inserção da Agencia de Noticía no BD";
        }
    }
    
    public static String alterarAgenciaNoticia(AgenciaNoticia agenciaNoticia) {
        String sql = "UPDATE agencia SET nome = ?, endereco = ?, estado = ?, país = ?, tipo = ? WHERE cnpj = ?";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            //a ordem dos parametros é de acordo com a ordem os ?(interrogações)
            comando.setString(1, agenciaNoticia.getNome());
            comando.setString(2, agenciaNoticia.getEndereco());
            comando.setString(3, agenciaNoticia.getEstado());
            comando.setString(4, agenciaNoticia.getPais());
            comando.setString(5, (agenciaNoticia.getTipo_agencia_noticia()+""));
            comando.setString(6, agenciaNoticia.getCnpj());
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            return "Erro na alteração da Agencia de Noticia no BD";
        }
    }
    
    public static String removerAgenciaNoticia(String cnpj) {
        String sql = "DELETE FROM agencia WHERE cnpj = ?";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, cnpj);
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            return "Erro na remoção da Agencia de Noticía no BD";
        }
    }
    
    public static AgenciaNoticia buscarAgenciaNoticia(String cnpj) {
        String sql = "SELECT * FROM Agencia WHERE cnpj = ?";
        ResultSet lista_resultados = null;
        AgenciaNoticia agencia_noticia = null;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, cnpj);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                agencia_noticia = new AgenciaNoticia(cnpj,
                                                    lista_resultados.getString("Nome"),
                                                    lista_resultados.getString("Endereco"), 
                                                    lista_resultados.getString("Estado"),
                                                    lista_resultados.getString("País"),
                                                    lista_resultados.getString("tipo").toCharArray()[0]);
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            agencia_noticia = null;
        }
        return agencia_noticia;
    }
    
    public String toString() {
        return "CNPJ: " + cnpj + "    --------    " + nome;
    }
    public static AgenciaNoticia[] getVisoes() {
        String sql = "SELECT cnpj, nome FROM agencia";
        ResultSet lista_resultados = null;
        ArrayList<AgenciaNoticia> visoes = new ArrayList();
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                String cnpj = lista_resultados.getString("cnpj");
                String nome = lista_resultados.getString("Nome");
                visoes.add(new AgenciaNoticia(cnpj, nome));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {exceção_sql.printStackTrace();}
        return visoes.toArray(new AgenciaNoticia[visoes.size()]);
    }
    
    public String toStringFull(){
        return cnpj+ " - " +nome+ " - " +endereco+ " - " +país+ " - " +tipo_agencia_noticia+ " - ";
    }
    
    public AgenciaNoticia getVisao() {
        return new AgenciaNoticia(cnpj, nome);
    }
    
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String Nome) {
        this.nome = Nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String Endereco) {
        this.endereco = Endereco;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String Estado) {
        this.estado = Estado;
    }

    public String getPais() {
        return país;
    }

    public void setPais(String País) {
        this.país = País;
    }
    
    public char getTipo_agencia_noticia() {
        return tipo_agencia_noticia;
    }

    public void setTipo_agencia_noticia(char tipo_agencia_noticia) {
        this.tipo_agencia_noticia = tipo_agencia_noticia;
    }
    
}
