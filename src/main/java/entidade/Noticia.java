
package entidade;

import entidade.Queimada.TipoQueimada;
import entidade.VazamentoNuclear.TipoVazamentoNuclear;
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
                        Catastrofe.buscarCatastrofe(lista_resultados.getInt("CatastrofeID")).getVisao()));
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
        String sql = "UPDATE Noticia SET Descricao = ?, AgenciaID = ?, CatastrofeID = ?, GrauUrgencia = ? WHERE Sequencial = ?";
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
        return "[" + sequencial + "]" +catastrofe_id.getNome()+ " -- " +agencia_id.getNome();
    }
    
    public String toStringFull(){
        String str = agencia_id.toStringFull() + catastrofe_id.toStringFull() + "\n          ";
        if(grau_urgencia == 'B'){
            str += "Grau Urgencia: Baixo";
        }else if(grau_urgencia == 'M'){
            str += "Grau Urgencia: Medio";
        }else if(grau_urgencia == 'U'){
            str += "Grau Urgencia: Urgente";
        }
        str += "\n       Horário Criação: "+formatarDataHora(data_hora.toString()) + "\n";
        return str;
    }
    
    public static ArrayList<Noticia> pesquisaNoticia(String chave_agencia_noticia, int chave_catastrofe, char grau_urgencia, 
                char inundacao_ativo, TipoQueimada tipo_queimada_enum, TipoVazamentoNuclear tipo_vazamento_nuclear, Timestamp data_minima){
        String sql = "SELECT A.Cnpj, C.Sequencial, N.Sequencial, N.GrauUrgencia "
                + " FROM Agencia A, Catastrofe C, Noticia N"
                + " WHERE N.AgenciaID = A.Cnpj AND N.CatastrofeID = C.Sequencial";
        
        if(chave_agencia_noticia != null) sql += " AND A.Cnpj = ?";
        if(chave_catastrofe > -1) sql += " AND C.Sequencial = ?";
        if(grau_urgencia != 'X') sql += " AND N.GrauUrgencia = ?";
        
        sql += " ORDER BY N.Sequencial";
        
        ResultSet lista_resultados = null;
        
        ArrayList<Noticia> noticias_selecionadas = new ArrayList();
        
        int index = 0;
        int sequencial_catastrofe = -1;
        
        try{
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            if(chave_agencia_noticia != null) comando.setString(++index, chave_agencia_noticia);
            if(chave_catastrofe > -1) comando.setInt(++index, chave_catastrofe);
            if(grau_urgencia != 'X') comando.setString(++index, grau_urgencia + "");
            
            lista_resultados = comando.executeQuery();
            
            while(lista_resultados.next()){
                Noticia noticias_pesquisadas = Noticia.buscarNoticias(lista_resultados.getInt(3));
                sequencial_catastrofe = lista_resultados.getInt(2);
                if(inundacao_ativo != 'X'){
                    if(isOkPesquisaInundacao(sequencial_catastrofe, inundacao_ativo))
                        noticias_selecionadas.add(noticias_pesquisadas);
                }else{
                    noticias_selecionadas.add(noticias_pesquisadas);
                }
                
            }
            lista_resultados.close();
            comando.close();
        }catch(SQLException excecao_sql){excecao_sql.printStackTrace();}
        
        return noticias_selecionadas;
    }
    
    private static boolean isOkPesquisaInundacao(int sequencial_catastrofe, char inundacao_ativo){
        boolean pesquisa_ok = false;
        String sql= "SELECT * FROM inundacao WHERE catastrofeID = ?";
        
        if(inundacao_ativo != 'X') sql += " AND ativo = ?";
        
        ResultSet lista_resultados = null;
        
        int index = 1;
        
        try{
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, sequencial_catastrofe);
            switch(inundacao_ativo){
                case 'T': comando.setBoolean(++index, true); break;
                case 'F': comando.setBoolean(++index, false);
            }
            lista_resultados = comando.executeQuery();
            while(lista_resultados.next()) pesquisa_ok = true;
            lista_resultados.close();
            comando.close();
        }catch(SQLException excecao_sql){excecao_sql.printStackTrace();}
        
        return pesquisa_ok;
    }
        
    
//    public static ArrayList<Noticia> pesquisarNoticia(String chave_agencia_noticia, int chave_catastrofe, char grau_urgencia, int inundacao_ativa, 
//            TipoQueimada tipo_queimada_enum, TipoVazamentoNuclear tipo_vazamento_nuclear, Timestamp data_minima){
//        
//        String sql = "SELECT A.Cnpj, C.Sequencial, N.GrauUrgencia, I.Ativo, Q.tipo_queimada, V.tipo_vazamento_nuclear, N.Sequencial, N.DataHora\n" +
//                "FROM Agencia A, Catastrofe C, Noticia N, Inundacao I, Queimada Q, Vazamento_nuclear V\n" +
//                "WHERE N.AgenciaID = A.Cnpj AND N.CatastrofeID = C.Sequencial";
//        
//        if(chave_agencia_noticia != null) sql += " AND A.Cnpj = ?";
//        if(chave_catastrofe > -1) sql += " AND C.Sequencial = ?";
//        //if(grau_urgencia != 'X') sql += " AND N.GrauUrgencia = ?";
//        if(inundacao_ativa > -1) sql += " AND I.Ativo = ?";
//        if(tipo_vazamento_nuclear != null) sql += " AND V.tipo_vazamento_nuclear = ?";
//        if(data_minima != null) sql += " AND N.DataHora >= ?";
//        sql += " ORDER BY N.Sequencial";
//        
//        ResultSet lista_resultados= null;
//        ArrayList<Noticia> noticias_selecionadas = new ArrayList<>();
//        
//        int index = 0;
//        int sequencial_catastrofe = -1;
//        int sequencial_noticia = -1;
//        
//        try {
//            
//            PreparedStatement comando = BD.conexão.prepareStatement(sql);
//            if (chave_agencia_noticia != null) comando.setString(++index, chave_agencia_noticia);
//            if (chave_catastrofe > -1) comando.setInt(++index, chave_catastrofe);
//            //if (grau_urgencia != 'X') comando.setString(++index, grau_urgencia + "");
//            if (inundacao_ativa > -1) comando.setInt(++index, inundacao_ativa);
//            if (tipo_vazamento_nuclear != null) comando.setInt(++index, tipo_vazamento_nuclear.ordinal());
//            if (data_minima != null) comando.setTimestamp(++index, data_minima);
//            
//            lista_resultados = comando.executeQuery();
//            
//            while(lista_resultados.next()){
//                //System.out.println("ESTÁ FUNCIONANDO");
//                Noticia noticias_pesquisadas = Noticia.buscarNoticias(lista_resultados.getInt(7));
//                sequencial_catastrofe = lista_resultados.getInt(2);
//                
//                if(grau_urgencia != 'X'){                    
//                    if(isOkPesquisaEmNoticia(sequencial_noticia, grau_urgencia)){
//                        noticias_selecionadas.add
//                        (noticias_pesquisadas);
//                    }
//                }
//                if(tipo_queimada_enum != null){
//                    if(isOkPesquisaEmQueimada(sequencial_catastrofe, tipo_queimada_enum)) noticias_selecionadas.add
//                        (noticias_pesquisadas);
//                }else{
//                    noticias_selecionadas.add(noticias_pesquisadas);
//                }
//            }
//            
//            lista_resultados.close();
//            comando.close();
//        }catch(SQLException excecao_sql){excecao_sql.printStackTrace();}
//        
//        //System.out.println(noticias_selecionadas);
//        
//        return noticias_selecionadas;
//    }
    
//    private static boolean isOkPesquisaEmNoticia(int sequencial_noticia, char grau_urgencia){
//        boolean pesquisa_ok = false;
//        String sql = "SELECT *FROM noticia WHERE sequencial = ?";
//        if(grau_urgencia != 'X') sql += " AND GrauUrgencia = ?";
//        ResultSet lista_resultados = null;
//        int index = 1;
//        try{
//            PreparedStatement comando = BD.conexão.prepareStatement(sql);
//            comando.setInt(1, sequencial_noticia);
//            switch(grau_urgencia){
//                case 'B': comando.setBoolean(++index, true); break;
//                case 'M': comando.setBoolean(++index, true); break;
//                case 'U': comando.setBoolean(++index, true); break;
//            }
//            lista_resultados = comando.executeQuery();
//            while(lista_resultados.next()) pesquisa_ok = true;
//            lista_resultados.close();
//        }catch (SQLException excecao_sql){excecao_sql.printStackTrace();}
//        return pesquisa_ok;
//    }
    
    private static boolean isOkPesquisaEmQueimada(int sequencial_catastrofe, TipoQueimada tipo_queimada_enum){
        boolean pesquisa_ok = false;
        String sql = "SELECT * FROM queimada WHERE catastrofeId = ?";
        
        if(tipo_queimada_enum != null) sql += " AND tipo_queimada";
        
        ResultSet lista_resultados = null;
        int index = 1;
        
        try{
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, sequencial_catastrofe);
            if(tipo_queimada_enum != null)comando.setInt(++index, tipo_queimada_enum.ordinal());
            lista_resultados = comando.executeQuery();
            while(lista_resultados.next()) pesquisa_ok = true;
            lista_resultados.close();
            comando.close();
        }catch(SQLException excecao_sql){excecao_sql.printStackTrace();}
        
        return pesquisa_ok;
        
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
    