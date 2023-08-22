/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import interfaces.JanelaCadastroCatastrofes;
import entidade.Catastrofe;

public class ControladorCadastroCatastrofes {
    public ControladorCadastroCatastrofes() {
        new JanelaCadastroCatastrofes(this).setVisible(true);
    }
    public String inserirCatastrofe(Catastrofe catastrofe) {
        if(!Catastrofe.existeCatastrofeMesmosAtributos(catastrofe)) return Catastrofe.inserirCatastrofe(catastrofe);
        else return "Já existe CATASTROFE com estes atributos";
    }
    public String alterarCatastrofe(Catastrofe catastrofe) {
        Catastrofe catastrofe1 = Catastrofe.buscarCatastrofe(catastrofe.getSequencial());
        if(catastrofe1 != null) return Catastrofe.alterarCatastrofe(catastrofe);
        else return "Queimada não encontrado";
    }
    public String removerCatastrofe(int sequencial) {
        Catastrofe catastrofe1 = Catastrofe.buscarCatastrofe(sequencial);
        if (catastrofe1 != null) {
            return Catastrofe.removerCatastrofe(catastrofe1);
        } else {
            return "Nome da queimada não cadastrado";
        }
    }
}


