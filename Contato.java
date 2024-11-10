package agendacontatos;

public class Contato {
    private String Nome;
    private String Email;
    private String Telefone;

    public Contato(String Nome, String Email, String Telefone) {
        this.Nome = Nome;
        this.Email = Email;
        this.Telefone = Telefone;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    @Override
    public String toString() {
        return "Contato{" + "Nome=" + Nome + ", Email=" + Email + ", Telefone=" + Telefone + '}';
    }
    
}
