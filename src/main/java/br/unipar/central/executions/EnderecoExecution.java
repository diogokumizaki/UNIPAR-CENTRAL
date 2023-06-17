/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package br.unipar.central.executions;


import br.unipar.central.models.Cidade;
import br.unipar.central.models.Endereco;
import br.unipar.central.models.Pessoa;
import br.unipar.central.services.EnderecoService;
import java.util.List;
import java.util.Scanner;

public class EnderecoExecution {

    public String Insert() {
        try {
            Endereco endereco = new Endereco();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Informe o id de endereco: ");
            endereco.setId(scanner.nextInt());
            scanner.nextLine();

            System.out.println("Informe o nome da rua: ");
            endereco.setLogradouro(scanner.nextLine());

            System.out.println("Informe o número da casa: ");
            endereco.setNumero(scanner.nextLine());

            System.out.println("Informe o bairro: ");
            endereco.setBairro(scanner.nextLine());

            System.out.println("Informe o cep: ");
            endereco.setCep(scanner.nextLine());
            
            System.out.println("Informe o complemento: ");
            endereco.setComplemento(scanner.nextLine());

            System.out.println("Informe o ra: ");
            endereco.setRa(scanner.nextLine());
            
            System.out.println("Informe o id de pessoa: ");
            Pessoa pessoaPOJO = new Pessoa();
            pessoaPOJO.setId(scanner.nextInt());
            endereco.setPessoa(pessoaPOJO);
            
            System.out.println("Informe o id da agencia: ");
            Cidade cidadePOJO = new Cidade();
            cidadePOJO.setId(scanner.nextInt());
            endereco.setCidade(cidadePOJO);

            EnderecoService enderecoService = new EnderecoService();
            enderecoService.insert(endereco);
            String msg = "Inserido com sucesso";
            System.out.println(msg);
            return msg;
        } catch (Exception ex) {
            String msg = "Erro ao inserir " + ex.getMessage();
            System.out.println(msg);
            return msg;
        }
    }

    public String FindAll() {
        try {
            EnderecoService enderecoService = new EnderecoService();
            List<Endereco> procurarPorEndereco = enderecoService.findAll();
            Endereco enderecoPOJO = new Endereco();
            enderecoPOJO.message();
            String msg = "Todos os itens encontrados " + procurarPorEndereco.toString();
            System.out.println(msg);
            return msg;
        } catch (Exception ex) {
            String msg = "Erro ao buscar todos os itens: " + ex.getMessage();
            System.out.println(msg);
            return msg;
        }
    }

    public String FindById() {
        try {
            EnderecoService enderecoService = new EnderecoService();
            Endereco endereco = new Endereco();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Informe o ID de  : ");
            int id = scanner.nextInt();
            endereco.setId(id);
            Endereco enderecoPOJO = new Endereco();
            enderecoPOJO.message();
            String msg = "Item encontrado: " + enderecoService.findById(endereco.getId());
            System.out.println(msg);
            return msg;
        } catch (Exception ex) {
            String msg = "Erro ao buscar o item por ID: " + ex.getMessage();
            System.out.println(msg);
            return msg;
        }
    }

    public String DeleteById() {
        try {
            Scanner scanner = new Scanner(System.in);

            EnderecoService enderecoService = new EnderecoService();
            Endereco endereco = new Endereco();

            System.out.println("Informe o ID de endereco: ");
            endereco.setId(scanner.nextInt());
            enderecoService.delete(endereco.getId());
            String msg = "Item deletado com sucesso";
            System.out.println(msg);
            return msg;
        } catch (Exception ex) {
            String msg = "Erro ao deletar o item por ID: " + ex.getMessage();
            System.out.println(msg);
            return msg;
        }
    }

    public String Update() {
        try {
            Endereco endereco = new Endereco();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Informe o id de endereco: ");
            endereco.setId(scanner.nextInt());
            scanner.nextLine();

            System.out.println("Informe o nome da rua: ");
            endereco.setLogradouro(scanner.nextLine());

            System.out.println("Informe o número da casa: ");
            endereco.setNumero(scanner.nextLine());

            System.out.println("Informe o bairro: ");
            endereco.setBairro(scanner.nextLine());

            System.out.println("Informe o cep: ");
            endereco.setCep(scanner.nextLine());
            
            System.out.println("Informe o complemento: ");
            endereco.setComplemento(scanner.nextLine());

            System.out.println("Informe o ra: ");
            endereco.setRa(scanner.nextLine());
            
            System.out.println("Informe o id de pessoa: ");
            Pessoa pessoaPOJO = new Pessoa();
            pessoaPOJO.setId(scanner.nextInt());
            endereco.setPessoa(pessoaPOJO);
            
            System.out.println("Informe o id da agencia: ");
            Cidade cidadePOJO = new Cidade();
            cidadePOJO.setId(scanner.nextInt());
            endereco.setCidade(cidadePOJO);
            
            EnderecoService enderecoService = new EnderecoService();
            enderecoService.update(endereco);
            String msg = "Update realizado com sucesso";
            System.out.println(msg);
            return msg;
        } catch (Exception ex) {
            String msg = "Erro ao dar update: " + ex.getMessage();
            System.out.println(msg);
            return msg;
        }
    }
}
