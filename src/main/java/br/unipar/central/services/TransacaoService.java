/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.services;

import br.unipar.central.DAO.TransacaoDAO;
import br.unipar.central.exceptions.CampoEspecificoNaoInformadoException;
import br.unipar.central.exceptions.EntidadeOuClasseEmBrancoOuNaoInformadaException;
import br.unipar.central.exceptions.TamanhoMaximoDoCampoExcedidoException;
import br.unipar.central.exceptions.ValorInvalidoException;
import br.unipar.central.models.Transacao;
import java.sql.SQLException;
import java.util.List;

public class TransacaoService {

    public void validar(Transacao transacao) throws
            EntidadeOuClasseEmBrancoOuNaoInformadaException,
            CampoEspecificoNaoInformadoException,
            TamanhoMaximoDoCampoExcedidoException,
            ValorInvalidoException {

        String idStr = String.valueOf(transacao.getId());

        String idContaOrigem = String.valueOf(transacao.getConta_origem());

        String idContaDestino = String.valueOf(transacao.getConta_destino());

        if (transacao == null) {
            throw new EntidadeOuClasseEmBrancoOuNaoInformadaException("transacao");
        }

        if (transacao.getId() == 0) {
            throw new CampoEspecificoNaoInformadoException("id");
        }

        if (!idStr.matches("\\d+")) {
            throw new ValorInvalidoException("id");
        }

        if (transacao.getValor() == 0) {
            throw new CampoEspecificoNaoInformadoException("saldo em conta");
        }

        if ((transacao.getRa().length() > 8)) {
            throw new TamanhoMaximoDoCampoExcedidoException("ra", 8);
        }

        if (transacao.getTipo() == null) {
            throw new CampoEspecificoNaoInformadoException("tipo da transação");
        }

        if (transacao.getRa() == null
                || transacao.getRa().isEmpty()
                || transacao.getRa().isBlank()) {
            throw new CampoEspecificoNaoInformadoException("ra");
        }

        if ((transacao.getRa().length() > 8)) {
            throw new TamanhoMaximoDoCampoExcedidoException("ra", 8);
        }

        if (transacao.getConta_destino() == 0) {
            throw new EntidadeOuClasseEmBrancoOuNaoInformadaException("agencia");
        }

        if (idContaDestino.matches("\\d+")) {
            throw new ValorInvalidoException("id");
        }

        if (transacao.getConta_origem() == 0) {
            throw new EntidadeOuClasseEmBrancoOuNaoInformadaException("pessoa");
        }

        if (!idContaOrigem.matches("\\d+")) {
            throw new ValorInvalidoException("id");
        }
    }

    public List<Transacao> findAll() throws SQLException {

        TransacaoDAO transacaoDAO = new TransacaoDAO();
        List<Transacao> resultado = transacaoDAO.findAll();

        return resultado;
    }

    public Transacao findById(int id) throws SQLException, TamanhoMaximoDoCampoExcedidoException, Exception {

        if (id <= 0) {
            throw new TamanhoMaximoDoCampoExcedidoException("id", 1);
        }

        TransacaoDAO transacaoDAO = new TransacaoDAO();
        Transacao retorno = transacaoDAO.findById(id);

        if (retorno == null) {
            throw new Exception("Não foi possível encontrar um país com o id: " + id + " informado");
        }

        return transacaoDAO.findById(id);
    }

    public void insert(Transacao transacao) throws SQLException, EntidadeOuClasseEmBrancoOuNaoInformadaException, CampoEspecificoNaoInformadoException, TamanhoMaximoDoCampoExcedidoException, ValorInvalidoException {
        validar(transacao);
        TransacaoDAO transacaoDAO = new TransacaoDAO();
        transacaoDAO.insert(transacao);
    }

    public void update(Transacao transacao) throws SQLException, EntidadeOuClasseEmBrancoOuNaoInformadaException, CampoEspecificoNaoInformadoException, TamanhoMaximoDoCampoExcedidoException, ValorInvalidoException {
        validar(transacao);
        TransacaoDAO transacaoDAO = new TransacaoDAO();
        transacaoDAO.update(transacao);
    }

    public void delete(int id) throws SQLException {
        TransacaoDAO transacaoDAO = new TransacaoDAO();
        transacaoDAO.delete(id);

    }
}
