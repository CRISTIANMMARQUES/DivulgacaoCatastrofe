
package entidade;

public class Inundacao extends Catastrofe {
    
    public enum TipoInundacao{rio, mar, pluvial}
    
    private TipoInundacao tipo_inundacao;
    private String descricao;
    private boolean ativo;
    
    public Inundacao(Integer sequencial, String nome, String data, String localizacao,TipoInundacao tipo_inundacao, String descricao, boolean ativo) {
        super(sequencial, nome, data, localizacao);
        this.tipo_inundacao = tipo_inundacao;
        this.descricao = descricao;
        this.ativo = ativo;
    }
    
    public String toStringFull() {
        String str = super.toStringFull() + "\n        Tipo Catastrofe: " +tipo_inundacao;
        if(descricao != null) str += "\n        Descrição: " +descricao;
        if (ativo) str += "Inundação ATIVA";
        return str;
    }

    public TipoInundacao getTipoInundacao() {
        return tipo_inundacao;
    }

    public void setTipo(TipoInundacao tipo_inundacao) {
        this.tipo_inundacao = tipo_inundacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    public boolean isAtivo(){
        return ativo;
    }
}
