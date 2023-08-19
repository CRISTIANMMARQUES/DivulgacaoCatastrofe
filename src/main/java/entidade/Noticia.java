
package entidade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import persistencia.BD;
import interfaces.JanelaCadastroNoticia;

public class Noticia {
    
    public enum GrauUrgencia {URGENTE, MEDIA, BAIXA}

    private int sequencial;
    private String descricao;
    private AgenciaNoticia agencia_id;
    private Catastrofe catastrofe_id;
    private GrauUrgencia grau_urgencia;
    private Timestamp data_hora;
    
    public Noticia(int sequencial, AgenciaNoticia agencia_id, Catastrofe catastrofe_id) {
        this.sequencial = sequencial;
        this.agencia_id = agencia_id;
        this.catastrofe_id = catastrofe_id;
    }
        
    public Noticia(int sequencial, String descricao, AgenciaNoticia agencia_id, Catastrofe catastrofe_id, GrauUrgencia grau_urgencia, Timestamp data_hora){
        this.sequencial = sequencial;
        this.descricao = descricao;
        this.agencia_id = agencia_id;
        this.catastrofe_id = catastrofe_id;
        this.grau_urgencia = grau_urgencia;
        this.data_hora = data_hora;
    }
    
    public static Noticia[] getVisoes() {
        String sql = "SELECT Sequencial, AgenciaID, CatastrofeID FROM Noticia";
        ResultSet lista_resultados = null;
        ArrayList<Noticia> visoes = new ArrayList();
        try{
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            while(lista_resultados.next()){
                visoes.add(new Noticia(lista_resultados.getInt("Sequencial"), 
                        AgenciaNoticia.buscarAgenciaNoticia(lista_resultados.getString("AgenciaID")).getVisao(),
                        Catastrofe.buscarCatastrofe(lista_resultados.getInt("Sequencial")).getVisao()));
            }
            lista_resultados.close();
            comando.close();
        }catch(SQLException exceção_sql) {exceção_sql.printStackTrace();}
        return visoes.toArray(new Noticia[visoes.size()]);
    }
    
    public static Noticia buscarNoticias(Int sequencial) {
        String sql = "SELECT * FROM Noticia WHERE sequencial = ?";
        ResultSet lista_resultados = null;
        Noticia noticia = null;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, sequencial);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                noticia = new Noticia(sequencial,
                        lista_resultados.getString("Sequencial"),
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
    
    public static boolean existeNoticia(String chave_agencia_noticia, int chave_catastrofe){
        String sql = "SELECT sequencial FROM noticia WHRE AgenciaID = ? AND CatastrofeID = ?";
        ResultSet lista_resultados = null;
        boolean existe = false;
        try{
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, chave_agencia_noticia);
            comando.setInt(2, chave_catastrofe);
            lista_resultados = comando.executeQuery();
            while(lista_resultados.next()){
                existe = true;
            }
            lista_resultados.close();
            comando.close();
        }catch(SQLException excecao_sql){
            excecao_sql.printStackTrace();
        }
        return existe;
    }
    
    public static String inserirNoticia(Noticia noticia){
        String sql = "INSERT INTO Noticia(Descricao, AgenciaID, CatastrofeID, GrauUrgencia, DataHora) VALUES(?,?,?,?,?)";
        try{
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, noticia.getDescricao());
            comando.setString(2, noticia.getAgenciaNoticia().getCnpj());
            comando.setInt(3, noticia.getCatastrofe().getSequencial());
            int indice_grau_urgencia = -1;
            if(noticia.getGrauUrgencia() != null){
                indice_grau_urgencia = noticia.getGrauUrgencia().ordinal();
            }
            comando.setInt(4, indice_grau_urgencia);
            comando.setTimestamp(5, noticia.getDataHora());
            comando.executeUpdate();
            comando.close();
            return null;
        }catch(SQLException excecao_sql){
            excecao_sql.printStackTrace();
            return "Erro na inserção da Noticia no BD";
        }
    }
    
    public static String alterarNoticia(Noticia noticia){
        String sql = "UPDATE Noticia SET Descricao = ?, AgenciaID = ?, CatastrofeID = ?, GrauUrgencia = ? WHERE Sequencia = ?";
        try{
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, noticia.getDescricao());
            comando.setString(2,);
        }
    }

    public int getSequencial() {
        return sequencial;
    }

    public void setSequencial(int sequencial) {
        this.sequencial = sequencial;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public AgenciaNoticia getAgenciaNoticia() {
        return agencia_noticia;
    }

    public void setAgenciaNoticia(AgenciaNoticia agencia_noticia) {
        this.agencia_noticia = agencia_noticia;
    }

    public Catastrofe getCatastrofe() {
        return catastrofe_id;
    }

    public void setCatastrofe(Catastrofe catastrofe_id) {
        this.catastrofe_id = catastrofe_id;
    }

    public GrauUrgencia getGrauUrgencia() {
        return grau_urgencia;
    }

    public void setGrauUrgencia(GrauUrgencia grau_urgencia) {
        this.grau_urgencia = grau_urgencia;
    }

    public Timestamp getDataHora() {
        return data_hora;
    }

    public void setDataHora(Timestamp data_hora) {
        this.data_hora = data_hora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
    