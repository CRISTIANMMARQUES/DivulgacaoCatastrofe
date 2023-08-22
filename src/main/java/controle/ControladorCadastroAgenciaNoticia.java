
package controle;

import interfaces.JanelaCadastroAgenciasNoticia;
import entidade.AgenciaNoticia;


public class ControladorCadastroAgenciaNoticia {
    public ControladorCadastroAgenciaNoticia() {
        new JanelaCadastroAgenciasNoticia(this).setVisible(true);
    }
    public String inserirAgenciaNoticia(AgenciaNoticia agenciaNoticia){
        AgenciaNoticia agenciaNoticia1 = AgenciaNoticia.buscarAgenciaNoticia(agenciaNoticia.getCnpj());
        if (agenciaNoticia1 == null){
            return AgenciaNoticia.inserirAgenciaNoticia(agenciaNoticia);
        }
        else
            return "Já existe uma Agencia de Notícia com este CNPJ";       
    }
    
    public String alterarAgenciaNoticia(AgenciaNoticia agencia_noticia) {
        AgenciaNoticia agencia_noticia1 = AgenciaNoticia.buscarAgenciaNoticia(agencia_noticia.getCnpj());
        if (agencia_noticia1 != null) {
            return AgenciaNoticia.alterarAgenciaNoticia(agencia_noticia);
        } else {
            return "CNPJ da Agencia de Noticia não encontrado";
        }
    }
    public String removerAgenciaNoticia(String cnpj) {
        AgenciaNoticia agenciaNoticia1 = AgenciaNoticia.buscarAgenciaNoticia(cnpj);
        if (agenciaNoticia1 != null) {
            return AgenciaNoticia.removerAgenciaNoticia(cnpj);
        } else {
            return "Agencia de Noticícia não cadastrada";
        }
    }
}