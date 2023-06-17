/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.executions;


import br.unipar.central.enums.TipoOperadoraEnum;
import br.unipar.central.models.Agencia;
import br.unipar.central.models.Pessoa;
import br.unipar.central.models.Telefone;
import br.unipar.central.services.TelefoneService;
import java.util.List;
import java.util.Scanner;

public class TelefoneExecution {

    public String Insert() {
        try {
            Telefone telefone = new Telefone();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Informe o id de telefone: ");
            telefone.setId(scanner.nextInt());
            scanner.nextLine();

            System.out.println("Informe o numero da telefone: ");
            telefone.setNumero(scanner.nextLine());

            System.out.println("Informe a operadora: ");
            String tipoContaStr = scanner.next();
            TipoOperadoraEnum tipoOp;

            switch (tipoContaStr) {
                case "1":
                    tipoOp = TipoOperadoraEnum.TIM;
                    break;
                case "2":
                    tipoOp = TipoOperadoraEnum.CLARO;
                    break;
                case "3":
                    tipoOp = TipoOperadoraEnum.VIVO;
                    break;
                case "4":
                    tipoOp = TipoOperadoraEnum.OI;
                    break;
                case "5":
                    tipoOp = TipoOperadoraEnum.CORREIOS;
                    break;
                case "6":
                    tipoOp = TipoOperadoraEnum.LARICELL;
                    break;
                case "7":
                    tipoOp = TipoOperadoraEnum.TESLA;
                    break;
                case "8":
                    tipoOp = TipoOperadoraEnum.IPHONE;
                    break;
                case "9":
                    tipoOp = TipoOperadoraEnum.OUTROS;
                    break;
                default:

                    tipoOp = null;
                    break;
            }
            telefone.setOperadora(tipoOp);

            System.out.println("Informe o ra: ");
            telefone.setRa(scanner.nextLine());

            System.out.println("Informe o id de agencia: ");
            Agencia agenciaPOJO = new Agencia();
            agenciaPOJO.setId(scanner.nextInt());
            telefone.setAgencia(agenciaPOJO);

            System.out.println("Informe o id de pessoa: ");
            Pessoa pessoaPOJO = new Pessoa();
            pessoaPOJO.setId(scanner.nextInt());
            telefone.setPessoa(pessoaPOJO);

            TelefoneService telefoneService = new TelefoneService();
            telefoneService.insert(telefone);
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
            TelefoneService telefoneService = new TelefoneService();
            List<Telefone> procurarPorTelefone = telefoneService.findAll();
            Telefone telefonePOJO = new Telefone();
            telefonePOJO.message();
            String msg = "Todos os itens encontrados " + procurarPorTelefone.toString();
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
            TelefoneService telefoneService = new TelefoneService();
            Telefone telefone = new Telefone();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Informe o ID de  : ");
            int id = scanner.nextInt();
            telefone.setId(id);
            Telefone telefonePOJO = new Telefone();
            telefonePOJO.message();
            String msg = "Item encontrado: " + telefoneService.findById(telefone.getId());
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

            TelefoneService telefoneService = new TelefoneService();
            Telefone telefone = new Telefone();

            System.out.println("Informe o ID de telefone: ");
            telefone.setId(scanner.nextInt());
            telefoneService.delete(telefone.getId());
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
            Telefone telefone = new Telefone();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Informe o id de telefone: ");
            telefone.setId(scanner.nextInt());
            scanner.nextLine();

            System.out.println("Informe o numero da telefone: ");
            telefone.setNumero(scanner.nextLine());

            System.out.println("Informe a operadora: ");
            String tipoContaStr = scanner.next();
            TipoOperadoraEnum tipoOp;

            switch (tipoContaStr) {
                case "1":
                    tipoOp = TipoOperadoraEnum.TIM;
                    break;
                case "2":
                    tipoOp = TipoOperadoraEnum.CLARO;
                    break;
                case "3":
                    tipoOp = TipoOperadoraEnum.VIVO;
                    break;
                case "4":
                    tipoOp = TipoOperadoraEnum.OI;
                    break;
                case "5":
                    tipoOp = TipoOperadoraEnum.CORREIOS;
                    break;
                case "6":
                    tipoOp = TipoOperadoraEnum.LARICELL;
                    break;
                case "7":
                    tipoOp = TipoOperadoraEnum.TESLA;
                    break;
                case "8":
                    tipoOp = TipoOperadoraEnum.IPHONE;
                    break;
                case "9":
                    tipoOp = TipoOperadoraEnum.OUTROS;
                    break;
                default:

                    tipoOp = null;
                    break;
            }
            telefone.setOperadora(tipoOp);

            System.out.println("Informe o ra: ");
            telefone.setRa(scanner.nextLine());

            System.out.println("Informe o id de agencia: ");
            Agencia agenciaPOJO = new Agencia();
            agenciaPOJO.setId(scanner.nextInt());
            telefone.setAgencia(agenciaPOJO);

            System.out.println("Informe o id de pessoa: ");
            Pessoa pessoaPOJO = new Pessoa();
            pessoaPOJO.setId(scanner.nextInt());
            telefone.setPessoa(pessoaPOJO);

            TelefoneService telefoneService = new TelefoneService();
            telefoneService.update(telefone);
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
