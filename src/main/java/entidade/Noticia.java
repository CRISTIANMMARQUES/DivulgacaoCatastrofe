
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
    private char grau_urgencia;
    private Timestamp data_hora;
    
    public Noticia(int sequencial, AgenciaNoticia agencia_id, Catastrofe catastrofe_id) {
        this.sequencial = sequencial;
        this.agencia_id = agencia_id;
        this.catastrofe_id = catastrofe_id;
    }
        
    public Noticia(int sequencial, String descricao, AgenciaNoticia agencia_id, Catastrofe catastrofe_id, char grau_urgencia, Timestamp data_hora){
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
    
    public static Noticia buscarNoticias(int sequencial) {
        String sql = "SELECT * FROM Noticia WHERE Sequencial = ?";
        ResultSet lista_resultados = null;
        Noticia noticia = null;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, sequencial);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
//                GrauUrgencia grau_urgencia = null;
//                if (lista_resultados.getInt("GrauUrgencia") > -1) {
//                    grau_urgencia = GrauUrgencia.values()[lista_resultados.getInt("GrauUrgencia")];
//                }
                noticia = new Noticia(sequencial, 
                          lista_resultados.getString("Descricao"),
                         AgenciaNoticia.buscarAgenciaNoticia(lista_resultados.getString("AgenciaID")),
                       Catastrofe.buscarCatastrofe(lista_resultados.getInt("CatastrofeID")),
                                  lista_resultados.getString("GrauUrgencia").toCharArray()[0],
                          lista_resultados.getTimestamp("DataHora"));
            }
            lista_resultados.close();
            comando.close();
        }catch(SQLException exceção_sql){
            exceção_sql.printStackTrace();
            noticia = null;
        }
        return noticia;
    }
    
    public static boolean existeNoticia(String chave_agencia_noticia, int chave_catastrofe){
        String sql = "SELECT Sequencial FROM Noticia WHERE AgenciaID = ? AND CatastrofeID = ?";
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
            comando.setString(4, (noticia.getGrauUrgencia()+""));
//            int indice_grau_urgencia = -1;
//            if(noticia.getGrauUrgencia() != null){
//                indice_grau_urgencia = noticia.getGrauUrgencia().ordinal();
//            }
//            comando.setInt(4, indice_grau_urgencia);
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
            comando.setString(2,noticia.getAgenciaNoticia().getCnpj());
            comando.setInt(3, noticia.getCatastrofe().getSequencial());
            comando.setString(4, (noticia.getGrauUrgencia()+""));
//            int indice_grau_urgencia = -1;
//            if(noticia.getGrauUrgencia() != null) indice_grau_urgencia = noticia.getGrauUrgencia().ordinal();
//            comando.setInt(4, indice_grau_urgencia);
            comando.setInt(5, noticia.getSequencial());
            comando.executeUpdate();
            comando.close();
            return null;
        }catch (SQLException excecao_sql){
            excecao_sql.printStackTrace();
            return "Erro na alteração da Noticia no BD";
        }
    }
    
    public static boolean existeNoticia(int sequencial){
        String sql = "SELECT COUNT(sequencial) FROM Noticia WHERE Sequencial = ?";
        ResultSet lista_resultados = null;
        boolean existe = false;
        try{
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, sequencial);
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
    
    public static String removerNoticia(int Sequencial) {
        String sql = "DELETE FROM noticia WHERE sequencial = ?";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, Sequencial);
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            return "Erro na remoção da Noticia no BD";
        }
    }
    
    public static String formatarDataHora(String data_hora_bd) {
        String[] data_hora = data_hora_bd.split(" ");
        String[] ano_mes_dia = data_hora[0].split("-");
        String[] hora_minuto_resto = data_hora[1].split(":");
        String data_hora_formatada = ano_mes_dia[2] + "/" + ano_mes_dia[1] + "/" + ano_mes_dia[0] + " "
                + hora_minuto_resto[0] + ":" + hora_minuto_resto[1] + "hs";
        return data_hora_formatada;
    }
    
    public static int ultimoSequencial() {
        String sql = "SELECT MAX(sequencial) FROM noticia";
        ResultSet lista_resultados = null;
        int sequencial = 0;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                sequencial = lista_resultados.getInt(1);
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }
        return sequencial;
    }
    
    public String toString() {
//        AgenciaNoticia agencia_cadastrada = AgenciaNoticia.getVisoes();
//        Catastrofe catastrofe_cadastrada = Catastrofe.getVisoes();
        return "[" + sequencial + "]" +catastrofe_id.getNome()+ " -- " +agencia_id.getNome();
    }
    
    public Noticia getVisao() {
        return new Noticia(sequencial, agencia_id, catastrofe_id);
    }

    public int getSequencial() {
        return sequencial;
    }

    public void setSequencial(int sequencial) {
        this.sequencial = sequencial;
    }

    public AgenciaNoticia getAgenciaNoticia() {
        return agencia_id;
    }

    public void setAgenciaNoticia(AgenciaNoticia agencia_noticia) {
        this.agencia_id = agencia_id;
    }

    public Catastrofe getCatastrofe() {
        return catastrofe_id;
    }

    public void setCatastrofe(Catastrofe catastrofe_id) {
        this.catastrofe_id = catastrofe_id;
    }

    public char getGrauUrgencia() {
        return grau_urgencia;
    }

    public void setGrauUrgencia(char grau_urgencia) {
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
    