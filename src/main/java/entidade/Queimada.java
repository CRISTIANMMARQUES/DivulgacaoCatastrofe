
package entidade;

public class Queimada extends Catastrofe {
    
    public enum TipoQueimada{floresta, urbana, canavial}
    
    private TipoQueimada tipo_queimada;
    private String descricao;
    private boolean ativo;
    
    public Queimada(Integer sequencial, String nome, String data, String localizacao,TipoQueimada tipo_queimada, String descricao, boolean ativo) {
        super(sequencial, nome, data, localizacao);
        this.tipo_queimada = tipo_queimada;
        this.descricao = descricao;
        this.ativo = ativo;
    }
    
    public String toStringFull() {
        String str = super.toStringFull() + " --Tipo Catastrofe: Queimada -- " +tipo_queimada;
        if(descricao != null) str += " --Descrição: " +descricao;
        if (ativo) str += "Queimada ATIVA";
        return str;
    }
        
    public TipoQueimada getTipoQueimada() {
        return tipo_queimada;
    }
    public void setTipoQueimada(TipoQueimada tipo_queimada) {
        this.tipo_queimada = tipo_queimada;
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
    public boolean isAtivo() {
        return ativo;
    }
}