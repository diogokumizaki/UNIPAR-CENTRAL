/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package br.unipar.central.executions;

import br.unipar.central.models.PessoaFisica;
import br.unipar.central.models.Pessoa;
import br.unipar.central.services.PessoaFisicaService;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class PessoaFisicaExecution {

    public String Insert() {
        try {
            PessoaFisica pessoaFisica = new PessoaFisica();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Informe o nome da pessoaFisica: ");
            pessoaFisica.setNome(scanner.nextLine());
            System.out.println("Informe o cpf de pessoaFisica: ");
            pessoaFisica.setCpf(scanner.nextLine());
            System.out.println("Informe a rg da pessoaFisica: ");
            pessoaFisica.setRg(scanner.nextLine());
            System.out.println("Informe a data de nascimenot da pessoaFisica: ");
            int year = scanner.nextInt();
            int month = scanner.nextInt();
            int day = scanner.nextInt();
            Date dataNascimento = new Date(year, month, day);
            pessoaFisica.setDataNascimento(dataNascimento);
            
            System.out.println("Informe o id da pessoa: ");
            Pessoa pessoaPOJO = new Pessoa();
            pessoaPOJO.setId(scanner.nextInt());
            pessoaFisica.setPessoa(pessoaPOJO);
            
            PessoaFisicaService pessoaFisicaService = new PessoaFisicaService();
            pessoaFisicaService.insert(pessoaFisica);
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
            PessoaFisicaService pessoaFisicaService = new PessoaFisicaService();
            List<PessoaFisica> procurarPorPessoaFisica = pessoaFisicaService.findAll();
            PessoaFisica pessoaFisicaPOJO = new PessoaFisica();
            pessoaFisicaPOJO.message();
            String msg = "Todos os itens encontrados " + procurarPorPessoaFisica.toString();
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
            PessoaFisicaService pessoaFisicaService = new PessoaFisicaService();
            PessoaFisica pessoaFisica = new PessoaFisica();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Informe o CPF de  : ");
            String cpf = scanner.nextLine();
            pessoaFisica.setCpf(cpf);
            PessoaFisica pessoaFisicaPOJO = new PessoaFisica();
            pessoaFisicaPOJO.message();
            String msg = "Item encontrado: " + pessoaFisicaService.findById(pessoaFisica.getCpf());
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

            PessoaFisicaService pessoaFisicaService = new PessoaFisicaService();
            PessoaFisica pessoaFisica = new PessoaFisica();

            System.out.println("Informe o ID de pessoaFisica: ");
            pessoaFisica.setCpf(scanner.nextLine());
            pessoaFisicaService.delete(pessoaFisica.getCpf());
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
            PessoaFisica pessoaFisica = new PessoaFisica();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Informe o nome da pessoaFisica: ");
            pessoaFisica.setNome(scanner.nextLine());
            System.out.println("Informe o cpf de pessoaFisica: ");
            pessoaFisica.setCpf(scanner.nextLine());
            System.out.println("Informe a rg da pessoaFisica: ");
            pessoaFisica.setRg(scanner.nextLine());
            System.out.println("Informe a data de nascimenot da pessoaFisica: ");
            int year = scanner.nextInt();
            int month = scanner.nextInt();
            int day = scanner.nextInt();
            Date dataNascimento = new Date(year, month, day);
            pessoaFisica.setDataNascimento(dataNascimento);
            
            System.out.println("Informe o id da pessoa: ");
            Pessoa pessoaPOJO = new Pessoa();
            pessoaPOJO.setId(scanner.nextInt());
            pessoaFisica.setPessoa(pessoaPOJO);
            PessoaFisicaService pessoaFisicaService = new PessoaFisicaService();
            pessoaFisicaService.update(pessoaFisica);
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
