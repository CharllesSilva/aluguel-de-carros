package view;

import domain.Aluguel;
import domain.Carro;
import domain.Pessoa;
import domain.dao.AluguelDAO;
import domain.dao.CarroDAO;
import domain.dao.PessoaDAO;

import java.sql.SQLException;
import java.util.Scanner;

public class View {
    Scanner sc = new Scanner(System.in);

    public void startProgram() throws SQLException {
        System.out.println("-Bem vindo, ao alugueis de carros-");
        System.out.println("1-MANIPULAR PESSOAS");
        System.out.println("2-MANIPULAR CARROS");
        System.out.println("3-MANIPULAR ALUGUEIS");
        Scanner scan = new Scanner(System.in);
        int user = scan.nextInt();

        switch (user) {
            case 1:
                manipularPessoas();
                break;
            case 2:
                manipularCarros();
                break;
            case 3:
                manipularAluguel();
                break;
        }
    }


    private void manipularPessoas() throws SQLException {


        System.out.println("Digite 1 para criar nova pessoa");
        System.out.println("Digite 2 para deletar nova pessoa");

        switch (sc.nextInt()) {

            case 1: {
                Pessoa pessoa = new Pessoa();
                System.out.println("digite nome da pessoa: ");
                pessoa.setNome(sc.next());
                PessoaDAO.criar(pessoa);
            }
            break;
            case 2:
                Pessoa pessoa = new Pessoa();
                System.out.println("digite o ID da pessoa que queira deletar");
                pessoa.setId(sc.nextInt());
                PessoaDAO.deletar(pessoa);
                break;
        }
    }

    private void manipularCarros() throws SQLException {


        System.out.println("Digite 1 para criar novo carro");
        System.out.println("Digite 2 para deletar carro");

        switch (sc.nextInt()) {

            case 1: {
                Carro carro = new Carro();
                System.out.println("digite nome do carro: ");
                carro.setNome(sc.next());
                System.out.println("digite a quantidade de carros: ");
                carro.setQuantidade(sc.nextInt());
                CarroDAO.criar(carro);
            }
            break;
            case 2:
                Carro carro = new Carro();
                System.out.println("digite o ID do carro que queira deletar");
                carro.setId(sc.nextInt());
                CarroDAO.deletar(carro);
                break;
        }
    }

    private void manipularAluguel() throws SQLException {


        System.out.println("Digite 1 para criar novo aluguel");

        switch (sc.nextInt()) {

            case 1: {
                Pessoa pessoa = new Pessoa();
                Carro carro = new Carro();
                System.out.println("digite id da pessoa: ");
                pessoa.setId(sc.nextInt());
                System.out.println("digite o id do carro: ");
                carro.setId(sc.nextInt());
                AluguelDAO.gerarAluguel(pessoa, carro);
            }
            break;
        }
    }
}
