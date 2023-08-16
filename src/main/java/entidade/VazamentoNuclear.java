
package entidade;

public class VazamentoNuclear extends Catastrofe{
    
    public enum TipoVazamentoNuclear{reator_nuclear, laboratorio_pesquisa, rejeitos_radioativo}
    
    private TipoVazamentoNuclear tipo_vazamento_nuclear;
    private String descricao;
    private boolean ativo;
    
    public VazamentoNuclear(Integer sequencial, String nome, String data, String localizacao,TipoVazamentoNuclear tipo_vazamento_nuclear, String descricao, boolean ativo) {
        super(sequencial, nome, data, localizacao);
        this.tipo_vazamento_nuclear = tipo_vazamento_nuclear;
        this.descricao = descricao;
        this.ativo = ativo;
    }

    public TipoVazamentoNuclear getTipoVazamentoNuclear() {
        return tipo_vazamento_nuclear;
    }

    public void setTipoVazamentoNuclear(TipoVazamentoNuclear tipo_vazamento_nuclear) {
        this.tipo_vazamento_nuclear = tipo_vazamento_nuclear;
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
