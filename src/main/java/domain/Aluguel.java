package domain;

public class Aluguel {

    private int id;
    private Pessoa pessoa;
    private Carro carro;


    public Aluguel() {
    }

    public Aluguel(int id, Pessoa pessoa, Carro carro) {
        this.id = id;
        this.pessoa = pessoa;
        this.carro = carro;
    }

    public void gerearAluguel() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }
}
