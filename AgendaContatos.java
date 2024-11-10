package agendacontatos;

import java.util.Scanner;

public class AgendaContatos {

    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Scanner scanner = new Scanner(System.in);
        int selecionar;
        
        do{
            System.out.println("1 - Adicionar Contato");
            System.out.println("2 - Remover Contato");
            System.out.println("3 - Consultar Contato(s)");
            System.out.println("4 - Procurar Contato");
            System.out.println("0 - Sair");
            System.out.println("Selecione uma opção: ");
            selecionar = scanner.nextInt();
            scanner.nextLine();
            
            switch (selecionar){
                case 1:
                    System.out.println("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.println("Email: ");
                    String email = scanner.nextLine();
                    System.out.println("Telefone: ");
                    String telefone = scanner.nextLine();
                    
                    agenda.adicionarContato(new Contato(nome, email, telefone));
                    System.out.println("Contato adicionado com sucesso!");
                    break;
                case 2: 
                    System.out.println("Nome: ");
                    String removeNome = scanner.nextLine();
                    agenda.removerContato(removeNome);
                    System.out.println("Contato removido com sucesso!");
                    break;
                case 3:
                    System.out.println("Lista de contatos:");
                    for(Contato contato : agenda.consultarContato()){
                        System.out.println(contato);                        
                    }
                    break;
                case 4: 
                    System.out.println("Digite o nome do contato: ");
                    String buscarContato = scanner.nextLine();
                    Contato contato = agenda.buscarContato(buscarContato);
                    if (contato != null) {
                        System.out.println("Contato encontrado: " + contato);
                    }
                    else{
                        System.out.println("Contato não encontrado.");
                    }
                    break;
                case 0:
                    System.out.println("Desconectado.");
                    break;
                    
                default:
                    System.out.println("Opção inválida.");
            }
        }
        while(selecionar != 0);
        
        scanner.close();
    }
    
}
