/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package br.unipar.central.executions;


import br.unipar.central.enums.TipoTransacaoEnum;
import br.unipar.central.models.Transacao;
import br.unipar.central.services.TransacaoService;
import java.util.List;
import java.util.Scanner;

public class TransacaoExecution {

    public String Insert() {
        try {
            Transacao transacao = new Transacao();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Informe o id de transacao: ");
            transacao.setId(scanner.nextInt());
            System.out.println("Informe o valor da transacao: ");
            transacao.setValor(scanner.nextDouble());
            
            System.out.println("Informe o tipo da conta: ");
            String tipoTransaStr;
            tipoTransaStr = scanner.nextLine();
            TipoTransacaoEnum tipoTransacao;

            switch (tipoTransaStr) {
                case "1":
                    tipoTransacao = TipoTransacaoEnum.CREDITO;
                    break;
                case "2":
                    tipoTransacao = TipoTransacaoEnum.DEBITO;
                    break;
                case "3":
                    tipoTransacao = TipoTransacaoEnum.PIX;
                    break;
                default:

                    tipoTransacao = null;
                    break;
            }
            transacao.setTipo(tipoTransacao);
            
            System.out.println("Informe o ra de transacao: ");
            transacao.setRa(scanner.nextLine());
            
            System.out.println("Informe a conta de origem: ");
            transacao.setConta_origem(scanner.nextInt());
            
            System.out.println("Informe a conta de destino: ");
            transacao.setConta_destino(scanner.nextInt());
            
            TransacaoService transacaoService = new TransacaoService();
            transacaoService.insert(transacao);
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
            TransacaoService transacaoService = new TransacaoService();
            List<Transacao> procurarPorTransacao = transacaoService.findAll();
            Transacao transacaoPOJO = new Transacao();
            transacaoPOJO.message();
            String msg = "Todos os itens encontrados " + procurarPorTransacao.toString();
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
            TransacaoService transacaoService = new TransacaoService();
            Transacao transacao = new Transacao();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Informe o ID de  : ");
            int id = scanner.nextInt();
            transacao.setId(id);
            Transacao transacaoPOJO = new Transacao();
            transacaoPOJO.message();
            String msg = "Item encontrado: " + transacaoService.findById(transacao.getId());
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

            TransacaoService transacaoService = new TransacaoService();
            Transacao transacao = new Transacao();

            System.out.println("Informe o ID de transacao: ");
            transacao.setId(scanner.nextInt());
            transacaoService.delete(transacao.getId());
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
            Transacao transacao = new Transacao();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Informe o id de transacao: ");
            transacao.setId(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Informe o valor da transacao: ");
            transacao.setValor(scanner.nextDouble());
            
            System.out.println("Informe o tipo da conta: ");
            String tipoTransaStr = scanner.next();
            TipoTransacaoEnum tipoTransacao;

            switch (tipoTransaStr) {
                case "1":
                    tipoTransacao = TipoTransacaoEnum.CREDITO;
                    break;
                case "2":
                    tipoTransacao = TipoTransacaoEnum.DEBITO;
                    break;
                case "3":
                    tipoTransacao = TipoTransacaoEnum.PIX;
                    break;
                default:

                    tipoTransacao = null;
                    break;
            }
            transacao.setTipo(tipoTransacao);
            
            System.out.println("Informe o ra de transacao: ");
            transacao.setRa(scanner.nextLine());
            
            System.out.println("Informe a conta de origem: ");
            transacao.setRa(scanner.nextLine());
            
            System.out.println("Informe a conta de destino: ");
            transacao.setRa(scanner.nextLine());
            
            TransacaoService transacaoService = new TransacaoService();
            transacaoService.update(transacao);
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
