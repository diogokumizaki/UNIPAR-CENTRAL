/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.executions;

import br.unipar.central.models.PessoaJuridica;
import br.unipar.central.models.Pessoa;
import br.unipar.central.services.PessoaJuridicaService;
import java.util.List;
import java.util.Scanner;

public class PessoaJuridicaExecution {

    public String Insert() {
        try {
            PessoaJuridica pessoaJuridica = new PessoaJuridica();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Informe a razão social da pessoaJuridica: ");
            pessoaJuridica.setRazaoSocial(scanner.nextLine());
            System.out.println("Informe o cnpj de pessoaJuridica: ");
            pessoaJuridica.setCNPJ(scanner.nextLine());
            System.out.println("Informe o cnae da pessoaJuridica: ");
            pessoaJuridica.setCnaePrincipal(scanner.nextLine());
            System.out.println("Informe o nome fantasia da pessoaJuridica: ");
            pessoaJuridica.setNomeFantasia(scanner.nextLine());
            System.out.println("Informe o id da pessoa: ");
            Pessoa pessoaPOJO = new Pessoa();
            pessoaPOJO.setId(scanner.nextInt());
            pessoaJuridica.setPessoa(pessoaPOJO);

            PessoaJuridicaService pessoaJuridicaService = new PessoaJuridicaService();
            pessoaJuridicaService.insert(pessoaJuridica);
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
            PessoaJuridicaService pessoaJuridicaService = new PessoaJuridicaService();
            List<PessoaJuridica> procurarPorPessoaJuridica = pessoaJuridicaService.findAll();
            PessoaJuridica pessoaJuridicaPOJO = new PessoaJuridica();
            pessoaJuridicaPOJO.message();
            String msg = "Todos os itens encontrados " + procurarPorPessoaJuridica.toString();
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
            PessoaJuridicaService pessoaJuridicaService = new PessoaJuridicaService();
            PessoaJuridica pessoaJuridica = new PessoaJuridica();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Informe o CPF de  : ");
            String cpf = scanner.nextLine();
            pessoaJuridica.setCNPJ(cpf);
            PessoaJuridica pessoaJuridicaPOJO = new PessoaJuridica();
            pessoaJuridicaPOJO.message();
            String msg = "Item encontrado: " + pessoaJuridicaService.findById(pessoaJuridica.getCNPJ());
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

            PessoaJuridicaService pessoaJuridicaService = new PessoaJuridicaService();
            PessoaJuridica pessoaJuridica = new PessoaJuridica();

            System.out.println("Informe o ID de pessoaJuridica: ");
            pessoaJuridica.setCNPJ(scanner.nextLine());
            pessoaJuridicaService.delete(pessoaJuridica.getCNPJ());
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
            PessoaJuridica pessoaJuridica = new PessoaJuridica();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Informe a razão social da pessoaJuridica: ");
            pessoaJuridica.setRazaoSocial(scanner.nextLine());
            System.out.println("Informe o cnpj de pessoaJuridica: ");
            pessoaJuridica.setCNPJ(scanner.nextLine());
            System.out.println("Informe o cnae da pessoaJuridica: ");
            pessoaJuridica.setCnaePrincipal(scanner.nextLine());
            System.out.println("Informe o nome fantasia da pessoaJuridica: ");
            pessoaJuridica.setNomeFantasia(scanner.nextLine());
            System.out.println("Informe o id da pessoa: ");
            Pessoa pessoaPOJO = new Pessoa();
            pessoaPOJO.setId(scanner.nextInt());
            pessoaJuridica.setPessoa(pessoaPOJO);
            PessoaJuridicaService pessoaJuridicaService = new PessoaJuridicaService();
            pessoaJuridicaService.update(pessoaJuridica);
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
