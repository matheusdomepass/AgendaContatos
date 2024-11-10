package agendacontatos;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<Contato> contatos;

    public Agenda(){
        this.contatos = new ArrayList<>();
    }
    
    public void adicionarContato(Contato contato){
        contatos.add(contato);
    }
    
    public void removerContato(String nome){
        contatos.removeIf(contato -> contato.getNome().equalsIgnoreCase(nome));
    }
    
    public List<Contato> consultarContato(){
        return contatos;
    }
    
    public Contato buscarContato(String nome){
        for(Contato contato : contatos){
            if(contato.getNome().equalsIgnoreCase(nome)){
            return contato;
        }
        }
        return null;
    }
    
}
