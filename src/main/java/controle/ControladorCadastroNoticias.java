

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
}
