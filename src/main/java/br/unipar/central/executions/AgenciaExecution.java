package br.unipar.central.executions;

import br.unipar.central.models.Agencia;
import br.unipar.central.models.Banco;
import br.unipar.central.services.AgenciaService;
import java.util.List;
import java.util.Scanner;

public class AgenciaExecution {

    public String Insert() {
        try {
            Agencia agencia = new Agencia();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Informe o id de agencia: ");
            agencia.setId(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Informe o código da agencia: ");
            agencia.setCodigo(scanner.nextLine());
            System.out.println("Informe o dígito de agencia: ");
            agencia.setDigito(scanner.nextLine());
            System.out.println("Informe a razão social da agencia: ");
            agencia.setRazaoSocial(scanner.nextLine());
            System.out.println("Informe o cnpj da agencia: ");
            agencia.setCnpj(scanner.nextLine());
            System.out.println("Informe o ra de agencia: ");
            agencia.setRa(scanner.nextLine());
            System.out.println("Informe o id do banco: ");
            Banco bancoPOJO = new Banco();
            bancoPOJO.setId(scanner.nextInt());
            agencia.setBanco(bancoPOJO);
            AgenciaService agenciaService = new AgenciaService();
            agenciaService.insert(agencia);
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
            AgenciaService agenciaService = new AgenciaService();
            List<Agencia> procurarPorAgencia = agenciaService.findAll();
            Agencia agenciaPOJO = new Agencia();
            agenciaPOJO.message();
            String msg = "Todos os itens encontrados " + procurarPorAgencia.toString();
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
            AgenciaService agenciaService = new AgenciaService();
            Agencia agencia = new Agencia();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Informe o ID de  : ");
            int id = scanner.nextInt();
            agencia.setId(id);
            Agencia agenciaPOJO = new Agencia();
            agenciaPOJO.message();
            String msg = "Item encontrado: " + agenciaService.findById(agencia.getId());
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

            AgenciaService agenciaService = new AgenciaService();
            Agencia agencia = new Agencia();

            System.out.println("Informe o ID de agencia: ");
            agencia.setId(scanner.nextInt());
            agenciaService.delete(agencia.getId());
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
            Agencia agencia = new Agencia();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Informe o id de agencia: ");
            agencia.setId(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Informe o código da agencia: ");
            agencia.setCodigo(scanner.nextLine());
            System.out.println("Informe o dígito de agencia: ");
            agencia.setDigito(scanner.nextLine());
            System.out.println("Informe a razão social da agencia: ");
            agencia.setRazaoSocial(scanner.nextLine());
            System.out.println("Informe o cnpj da agencia: ");
            agencia.setCnpj(scanner.nextLine());
            System.out.println("Informe o ra de agencia: ");
            agencia.setRa(scanner.nextLine());
            System.out.println("Informe o id do banco: ");
            Banco bancoPOJO = new Banco();
            bancoPOJO.setId(scanner.nextInt());
            agencia.setBanco(bancoPOJO);
            AgenciaService agenciaService = new AgenciaService();
            agenciaService.update(agencia);
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

//        try {
//            
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
