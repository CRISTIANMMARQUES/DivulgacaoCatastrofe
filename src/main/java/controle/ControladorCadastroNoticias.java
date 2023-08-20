package controle;

import entidade.Noticia;
import interfaces.JanelaCadastroNoticia;

public class ControladorCadastroNoticias {
    public ControladorCadastroNoticias() {
        new JanelaCadastroNoticia(this).setVisible(true);
    }
    public String inserirNoticia(Noticia noticia){
        if(!Noticia.existeNoticia(noticia.getAgenciaNoticia().getCnpj(), noticia.getCatastrofe().getSequencial())){
            return Noticia.inserirNoticia(noticia);
        }else return "Noticia já cadastrada";
    }
    public String alterarNoticia(Noticia noticia_informada){
        Noticia noticias_cadastradas = Noticia.buscarNoticias(noticia_informada.getSequencial());
        if((noticia_informada.getAgenciaNoticia().getCnpj().equals(noticias_cadastradas.getAgenciaNoticia().getCnpj())) 
                && (noticia_informada.getCatastrofe().getSequencial() == noticias_cadastradas.getCatastrofe().getSequencial())){
            return Noticia.alterarNoticia(noticia_informada);
        }else return "Alteração não permitida: CNPJ da Agencia de Noticia ou sequencial da Catastrofe foram alterados";
    }
    public String removerNoticia(int sequencial){
        if(Noticia.existeNoticia(sequencial)) return Noticia.removerNoticia(sequencial);
        else return "Sequencail não corresponde a nenhuma reserva cadasrada";
    }
}
