/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.executions;

import br.unipar.central.enums.TipoContaEnum;
import br.unipar.central.models.Agencia;
import br.unipar.central.models.Conta;  
import br.unipar.central.models.Pessoa;
import br.unipar.central.services.ContaService;
import java.util.List;
import java.util.Scanner;

public class ContaExecution {

    public String Insert() {
        try {
            Conta conta = new Conta();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Informe o id de conta: ");
            conta.setId(scanner.nextInt());
            scanner.nextLine();

            System.out.println("Informe o número da conta: ");
            conta.setNumero(scanner.nextLine());

            System.out.println("Informe o dígito de conta: ");
            conta.setDigito(scanner.nextLine());

            System.out.println("Informe o saldo da conta: ");
            conta.setSaldo(scanner.nextDouble());

            System.out.println("Informe o tipo da conta: ");
            String tipoContaStr = scanner.next();
            TipoContaEnum tipoConta;

            switch (tipoContaStr) {
                case "1":
                    tipoConta = TipoContaEnum.CORRENTE;
                    break;
                case "2":
                    tipoConta = TipoContaEnum.POUPANCA;
                    break;
                case "3":
                    tipoConta = TipoContaEnum.SALARIO;
                    break;
                default:

                    tipoConta = null;
                    break;
            }
            conta.setTipoConta(tipoConta);

            System.out.println("Informe o ra de conta: ");
            conta.setRa(scanner.nextLine());

            System.out.println("Informe o id da agencia: ");
            Agencia agenciaPOJO = new Agencia();
            agenciaPOJO.setId(scanner.nextInt());
            conta.setAgencia(agenciaPOJO);

            System.out.println("Informe o id de pessoa: ");
            Pessoa pessoaPOJO = new Pessoa();
            pessoaPOJO.setId(scanner.nextInt());
            conta.setPessoa(pessoaPOJO);
            ContaService contaService = new ContaService();
            contaService.insert(conta);
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
            ContaService contaService = new ContaService();
            List<Conta> procurarPorConta = contaService.findAll();
            Conta contaPOJO = new Conta();
            contaPOJO.message();
            String msg = "Todos os itens encontrados " + procurarPorConta.toString();
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
            ContaService contaService = new ContaService();
            Conta conta = new Conta();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Informe o ID de  : ");
            int id = scanner.nextInt();
            conta.setId(id);
            Conta contaPOJO = new Conta();
            contaPOJO.message();
            String msg = "Item encontrado: " + contaService.findById(conta.getId());
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

            ContaService contaService = new ContaService();
            Conta conta = new Conta();

            System.out.println("Informe o ID de conta: ");
            conta.setId(scanner.nextInt());
            contaService.delete(conta.getId());
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
            Conta conta = new Conta();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Informe o id de conta: ");
            conta.setId(scanner.nextInt());
            scanner.nextLine();

            System.out.println("Informe o número da conta: ");
            conta.setNumero(scanner.nextLine());

            System.out.println("Informe o dígito de conta: ");
            conta.setDigito(scanner.nextLine());

            System.out.println("Informe o saldo da conta: ");
            conta.setSaldo(scanner.nextDouble());

            System.out.println("Informe o tipo da conta: ");
            String tipoContaStr = scanner.next();
            TipoContaEnum tipoConta;

            switch (tipoContaStr) {
                case "1":
                    tipoConta = TipoContaEnum.CORRENTE;
                    break;
                case "2":
                    tipoConta = TipoContaEnum.POUPANCA;
                    break;
                case "3":
                    tipoConta = TipoContaEnum.SALARIO;
                    break;
                default:

                    tipoConta = null;
                    break;
            }

            System.out.println("Informe o ra de conta: ");
            conta.setRa(scanner.nextLine());

            System.out.println("Informe o id da agencia: ");
            Agencia agenciaPOJO = new Agencia();
            agenciaPOJO.setId(scanner.nextInt());
            conta.setAgencia(agenciaPOJO);

            System.out.println("Informe o id de pessoa: ");
            Pessoa pessoaPOJO = new Pessoa();
            pessoaPOJO.setId(scanner.nextInt());
            conta.setPessoa(pessoaPOJO);
            ContaService contaService = new ContaService();
            contaService.update(conta);
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
