package entidade;

import entidade.Queimada.TipoQueimada;
import java.sql.ResultSet;//O Resultset é uma classe da API JAVA que permite percorrermos um DataTable de alguma consulta em um banco de dados.
import java.sql.PreparedStatement;//Método prepareStatement.É usado para criar um objeto que representa a instrução SQL que será executada, sendo que é invocado através do objeto Connetion.
import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.BD;
import entidade.Queimada;
import entidade.Inundacao;
import entidade.Inundacao.TipoInundacao;
import entidade.VazamentoNuclear.TipoVazamentoNuclear;

public class Catastrofe {
    
    private Integer sequencial;
    private String nome;
    private String data;
    private String localizacao;
    
    public Catastrofe(Integer sequencial, String nome) {
        this.sequencial = sequencial;
        this.nome = nome;
    }
    
    public Catastrofe(Integer sequencial, String nome, String data, String localizacao){
        this.sequencial = sequencial;
        this.nome = nome;
        this.data = data;
        this.localizacao = localizacao;
    }

    public static Catastrofe buscarCatastrofe(int sequencial) {
        String sql = "SELECT nome, data, localizacao FROM catastrofe WHERE sequencial = ?";
        ResultSet lista_resultados = null;
        String nome = null;
        String data = null;
        String localizacao = null;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, sequencial);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                nome = lista_resultados.getString("nome");
                data = lista_resultados.getString("data");
                localizacao = lista_resultados.getString("localizacao");
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }
        if (nome == null) return null;

        sql = "SELECT tipo_inundacao, descricao, ativo FROM inundacao WHERE catastrofeId = ?";
        lista_resultados = null;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, sequencial);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                return new Inundacao(sequencial, nome, data, localizacao,
                        TipoInundacao.values()[lista_resultados.getInt("tipo_inundacao")],
                        lista_resultados.getString("descricao"),
                        lista_resultados.getBoolean("ativo"));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }

        sql = "SELECT tipo_queimada, descricao, ativo FROM queimada WHERE catastrofeId = ?";
        lista_resultados = null;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, sequencial);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                return new Queimada(sequencial, nome, data, localizacao,
                        TipoQueimada.values()[lista_resultados.getInt("tipo_queimada")],
                        lista_resultados.getString("descricao"),
                        lista_resultados.getBoolean("ativo"));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }

        sql = "SELECT tipo_vazamento_nuclear, descricao, ativo FROM vazamento_nuclear WHERE catastrofeId = ?";
        lista_resultados = null;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, sequencial);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                return new VazamentoNuclear(sequencial, nome, data, localizacao,
                        TipoVazamentoNuclear.values()[lista_resultados.getInt("Tipo_Vazamento_Nuclear")],
                        lista_resultados.getString("descricao"),
                        lista_resultados.getBoolean("ativo"));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {exceção_sql.printStackTrace();}
        return null;
    }
    
    public static String inserirCatastrofe(Catastrofe catastrofe){
        String sql = "INSERT INTO Catastrofe(Nome, data, localizacao) VALUES (?, ?, ?)";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, catastrofe.getNome());
            comando.setString(2, catastrofe.getData());
            comando.setString(3, catastrofe.getLocalizacao());
            comando.executeUpdate();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            return "Erro na inserção da catastrofe no BD";
        }

        int sequencial = ultimoSequencial();

        if (catastrofe instanceof Inundacao) {
            Inundacao inundacao = (Inundacao) catastrofe;
            sql = "INSERT INTO inundacao (catastrofeId, tipo_inundacao, descricao, ativo) VALUES (?, ?, ?, ?)";
            try {
                PreparedStatement comando = BD.conexão.prepareStatement(sql);
                comando.setInt(1, sequencial);
                comando.setInt(2, inundacao.getTipoInundacao().ordinal());
                comando.setString(3, inundacao.getDescricao());
                comando.setBoolean(4, inundacao.getAtivo());
                comando.executeUpdate();
                comando.close();
            } catch (SQLException exceção_sql) {
                exceção_sql.printStackTrace();
                return "Erro na inserção de Inundacao no BD";
            }
        } else if (catastrofe instanceof Queimada) {
            Queimada queimada = (Queimada) catastrofe;
            sql = "INSERT INTO queimada (catastrofeId, tipo_queimada, descricao, ativo) VALUES (?, ?, ?, ?)";
            try {
                PreparedStatement comando = BD.conexão.prepareStatement(sql);
                comando.setInt(1, sequencial);
                comando.setInt(2, queimada.getTipoQueimada().ordinal());
                comando.setString(3, queimada.getDescricao());
                comando.setBoolean(4, queimada.getAtivo());
                comando.executeUpdate();
                comando.close();
            } catch (SQLException exceção_sql) {
                exceção_sql.printStackTrace();
                return "Erro na inserção de Queimada no BD ";
            }
        } else if (catastrofe instanceof VazamentoNuclear) {
            VazamentoNuclear vazamento_nuclear = (VazamentoNuclear) catastrofe;
            sql = "INSERT INTO vazamento_Nuclear (catastrofeId, tipo_vazamento_nuclear, descricao, ativo) VALUES (?, ?, ?, ?)";
            try {
                PreparedStatement comando = BD.conexão.prepareStatement(sql);
                comando.setInt(1, sequencial);
                comando.setInt(2, vazamento_nuclear.getTipoVazamentoNuclear().ordinal());
                comando.setString(3, vazamento_nuclear.getDescricao());
                comando.setBoolean(4, vazamento_nuclear.getAtivo());
                comando.executeUpdate();
                comando.close();
            } catch (SQLException exceção_sql) {
                exceção_sql.printStackTrace();
                return "Erro na inserção de Vazamento Nuclear no BD";
            }
        }
        return null;
    }
    
    public static String removerCatastrofe(Catastrofe catastrofe){
        int sequencial = catastrofe.getSequencial();
        if(catastrofe instanceof Inundacao){
            String sql = "DELETE FROM Inundacao WHERE CatastrofeId = ?";
            try{
                PreparedStatement comando = BD.conexão.prepareStatement(sql);
                comando.setInt(1, sequencial);
                comando.execute();
                comando.close();
            }catch(SQLException exceção_sql){
                exceção_sql.printStackTrace();
                return "Erro na remoção da Inundacao do BD";
            }
        }else if (catastrofe instanceof Queimada) {
            String sql = "DELETE FROM Queimada WHERE CatastrofeId = ?";
            try {
                PreparedStatement comando = BD.conexão.prepareStatement(sql);
                comando.setInt(1, sequencial);
                comando.execute();
                comando.close();
            } catch (SQLException exceção_sql) {
                exceção_sql.printStackTrace();
                return "Erro na remoção da Queimada do BD";
            }
        }else if (catastrofe instanceof VazamentoNuclear) {
            String sql = "DELETE FROM Vazamento_Nuclear WHERE CatastrofeId = ?";
            try {
                PreparedStatement comando = BD.conexão.prepareStatement(sql);
                comando.setInt(1, sequencial);
                comando.execute();
                comando.close();
            } catch (SQLException exceção_sql) {
                exceção_sql.printStackTrace();
                return "Erro na remoção da VazamentoNuclear do BD";
            }
        }
        String sql = "DELETE FROM Catastrofe WHERE Sequencial = ?";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, sequencial);
            comando.execute();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            return "Erro na remoção da VazamentoNuclear do BD";
        }
        return null;
    }
    
    public static String alterarCatastrofe(Catastrofe catastrofe){
        String sql = "UPDATE Catastrofe SET Nome = ?, Data = ?, Localizacao = ? WHERE Sequencial = ?";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, catastrofe.getNome());
            comando.setString(2, catastrofe.getData());
            comando.setString(3, catastrofe.getLocalizacao());
            comando.setInt(4, catastrofe.getSequencial());
            comando.executeUpdate();
            comando.close();
        } catch (SQLException excecao_sql) {
            excecao_sql.printStackTrace();
            return "Erro na alteração do Produto no BD";
        }
        if (catastrofe instanceof Inundacao) {
            Inundacao inundacao = (Inundacao) catastrofe;
            sql = "UPDATE Inundacao SET tipo_inundacao = ?, Descricao = ?, Ativo = ?" + " WHERE CatastrofeId = ?";
            try{
                PreparedStatement comando = BD.conexão.prepareStatement(sql);
                comando.setInt(1, inundacao.getTipoInundacao().ordinal());
                comando.setString(2, inundacao.getDescricao());
                comando.setBoolean(3, inundacao.isAtivo());
                comando.setInt(4, inundacao.getSequencial());
                comando.executeUpdate();
                comando.close();
            }catch(SQLException excecao_sql){
                excecao_sql.printStackTrace();
                return "Erro de inserção da Inundação";
            }
        }else if (catastrofe instanceof Queimada) {
            Queimada queimada = (Queimada) catastrofe;
            sql = "UPDATE Queimada SET tipo_queimada = ?, Descricao = ?, Ativo = ?" + " WHERE CatastrofeId = ?";
            try{
                PreparedStatement comando = BD.conexão.prepareStatement(sql);
                comando.setInt(1, queimada.getTipoQueimada().ordinal());
                comando.setString(2, queimada.getDescricao());
                comando.setBoolean(3, queimada.isAtivo());
                comando.setInt(4, queimada.getSequencial());
                comando.executeUpdate();
                comando.close();
            }catch(SQLException excecao_sql){
                excecao_sql.printStackTrace();
                return "Erro de inserção da Queimada";
            }
        }else if (catastrofe instanceof VazamentoNuclear) {
            VazamentoNuclear vazamento_nuclear = (VazamentoNuclear) catastrofe;
            sql = "UPDATE vazamento_nuclear SET tipo_vazamento_nuclear = ?, Descricao = ?, Ativo = ?" + " WHERE CatastrofeId = ?";
            try{
                PreparedStatement comando = BD.conexão.prepareStatement(sql);
                comando.setInt(1, vazamento_nuclear.getTipoVazamentoNuclear().ordinal());
                comando.setString(2, vazamento_nuclear.getDescricao());
                comando.setBoolean(3, vazamento_nuclear.isAtivo());
                comando.setInt(4, vazamento_nuclear.getSequencial());
                comando.executeUpdate();
                comando.close();
            }catch(SQLException excecao_sql){
                excecao_sql.printStackTrace();
                return "Erro de inserção Vazamento Nuclear";
            }
        }
        return null;
    }
    
    public static int ultimoSequencial() {
        String sql = "SELECT MAX(sequencial) FROM catastrofe";
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
    
    public static boolean existeCatastrofeMesmosAtributos(Catastrofe catastrofe) {
        String sql = "SELECT COUNT(sequencial) FROM catastrofe WHERE nome = ? AND data = ? AND localizacao = ?";
        ResultSet lista_resultados = null;
        int n_catastrofe_mesmos_atributos = 0;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, catastrofe.getNome());
            comando.setString(2, catastrofe.getData());
            comando.setString(3, catastrofe.getLocalizacao());
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()){
                n_catastrofe_mesmos_atributos = lista_resultados.getInt(1);
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException excecao_sql) {
            excecao_sql.printStackTrace();
        }
        if (n_catastrofe_mesmos_atributos > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public static Catastrofe[] getVisoes() {
        String sql = "SELECT sequencial, nome FROM catastrofe";
        ResultSet lista_resultados = null;
        ArrayList<Catastrofe> visoes = new ArrayList();
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                int sequencial = lista_resultados.getInt("sequencial");
                visoes.add(buscarCatastrofe(lista_resultados.getInt("sequencial")));
                //buscarCatastrofe(lista_resultados.getInt("Sequencial")).getVisao()
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }
        return visoes.toArray(new Catastrofe[visoes.size()]);
    }
    
    public String toStringFull(){
        String str = nome;
        if(localizacao != null) str += " [" +localizacao+ "] ";
        if(data != null) str += " [" +data+ "] ";
        return str;
    }
    
    public Catastrofe getVisao() {
        return new Catastrofe(sequencial, nome);
    }
    
    public Integer getSequencial() {
        return sequencial;
    }
    public void setSequencial(Integer sequencial) {
        this.sequencial = sequencial;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getData(){
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getLocalizacao() {
        return localizacao;
    }
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
    
    public String toString() {
        return "[" + sequencial + "]" + nome;
    }
}
