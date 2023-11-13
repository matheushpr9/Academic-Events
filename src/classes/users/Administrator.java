package classes.users;

public class Administrator extends BaseUser{
    private String cpf;

    public Administrator(String name, String email, String password, String cpf) {
        super(name, email, password);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}