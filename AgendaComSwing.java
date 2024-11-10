package agendacontatos;

import agendacontatos.Contato;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgendaComSwing {
    private Agenda agendaService;

    public AgendaComSwing() {
        this.agendaService = new Agenda();
        JFrame frame = new JFrame("Agenda de Contatos");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        // Campo e label para Nome
        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(10, 20, 80, 25);
        panel.add(nomeLabel);

        JTextField nomeText = new JTextField(20);
        nomeText.setBounds(100, 20, 165, 25);
        panel.add(nomeText);

        // Campo e label para Telefone
        JLabel telefoneLabel = new JLabel("Telefone:");
        telefoneLabel.setBounds(10, 50, 80, 25);
        panel.add(telefoneLabel);

        JTextField telefoneText = new JTextField(20);
        telefoneText.setBounds(100, 50, 165, 25);
        panel.add(telefoneText);

        // Campo e label para Email
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(10, 80, 80, 25);
        panel.add(emailLabel);

        JTextField emailText = new JTextField(20);
        emailText.setBounds(100, 80, 165, 25);
        panel.add(emailText);

        // Área de exibição de mensagens e resultados
        JTextArea textArea = new JTextArea();
        textArea.setBounds(10, 160, 460, 180);
        textArea.setEditable(false);
        panel.add(textArea);

        // Botão para adicionar contato
        JButton addButton = new JButton("Adicionar Contato");
        addButton.setBounds(300, 20, 150, 25);
        panel.add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeText.getText();
                String telefone = telefoneText.getText();
                String email = emailText.getText();
                agendaService.adicionarContato(new Contato(nome, telefone, email));
                textArea.append("Contato adicionado: " + nome + "\n");
                limparCampos(nomeText, telefoneText, emailText);
            }
        });

        // Botão para remover contato
        JButton removeButton = new JButton("Remover Contato");
        removeButton.setBounds(300, 50, 150, 25);
        panel.add(removeButton);
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeText.getText();
                if (agendaService.buscarContato(nome) != null) {
                    agendaService.removerContato(nome);
                    textArea.append("Contato removido: " + nome + "\n");
                } else {
                    textArea.append("Contato não encontrado: " + nome + "\n");
                }
                limparCampos(nomeText, telefoneText, emailText);
            }
        });

        // Botão para listar todos os contatos
        JButton listButton = new JButton("Listar Contatos");
        listButton.setBounds(300, 80, 150, 25);
        panel.add(listButton);
        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("Lista de Contatos:\n");
                for (Contato c : agendaService.consultarContato()) {
                    textArea.append(c.toString() + "\n");
                }
            }
        });

        // Botão para procurar contato
        JButton searchButton = new JButton("Procurar Contato");
        searchButton.setBounds(300, 110, 150, 25);
        panel.add(searchButton);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeText.getText();
                Contato contato = agendaService.buscarContato(nome);
                if (contato != null) {
                    textArea.append("Contato encontrado: " + contato + "\n");
                } else {
                    textArea.append("Contato não encontrado: " + nome + "\n");
                }
                limparCampos(nomeText, telefoneText, emailText);
            }
        });
    }

    // Método auxiliar para limpar campos de entrada
    private void limparCampos(JTextField nomeText, JTextField telefoneText, JTextField emailText) {
        nomeText.setText("");
        telefoneText.setText("");
        emailText.setText("");
    }

    public static void main(String[] args) {
        new AgendaComSwing();
    }
}
