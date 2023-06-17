package br.unipar.central.services;

import br.unipar.central.DAO.ContaDAO;
import br.unipar.central.exceptions.CampoEspecificoNaoInformadoException;
import br.unipar.central.exceptions.EntidadeOuClasseEmBrancoOuNaoInformadaException;
import br.unipar.central.exceptions.TamanhoMaximoDoCampoExcedidoException;
import br.unipar.central.exceptions.ValorInvalidoException;
import br.unipar.central.models.Conta;
import java.sql.SQLException;
import java.util.List;

public class ContaService {

    public void validar(Conta conta) throws
            EntidadeOuClasseEmBrancoOuNaoInformadaException,
            CampoEspecificoNaoInformadoException,
            TamanhoMaximoDoCampoExcedidoException,
            ValorInvalidoException {

        String idStr = String.valueOf(conta.getId());
        String idStrdouble = String.valueOf(conta.getSaldo());

        if (conta == null) {
            throw new EntidadeOuClasseEmBrancoOuNaoInformadaException("pais");
        }

        if (conta.getId() == 0) {
            throw new CampoEspecificoNaoInformadoException("código do país");
        }

        if (!idStr.matches("\\d+")) {
            throw new ValorInvalidoException("código do país");
        }

        if (conta.getNumero() == null
                || conta.getNumero().isEmpty()
                || conta.getNumero().isBlank()) {
            throw new CampoEspecificoNaoInformadoException("numero da conta");
        }

        if ((conta.getNumero().length() > 10)) {
            throw new TamanhoMaximoDoCampoExcedidoException("numero da conta", 10);
        }

        if (conta.getDigito() == null
                || conta.getDigito().isEmpty()
                || conta.getDigito().isBlank()) {
            throw new CampoEspecificoNaoInformadoException("dígito da conta");
        }

        if ((conta.getDigito().length() > 1)) {
            throw new TamanhoMaximoDoCampoExcedidoException("dígito da conta", 1);
        }

        if (conta.getSaldo() == 0) {
            throw new CampoEspecificoNaoInformadoException("saldo em conta");
        }

        if (!idStrdouble.matches("\\d+")) {
            throw new ValorInvalidoException("saldo em conta");
        }

        if (conta.getTipoConta() == null) {
            throw new CampoEspecificoNaoInformadoException("tipo da conta");
        }

        if (conta.getRa() == null
                || conta.getRa().isEmpty()
                || conta.getRa().isBlank()) {
            throw new CampoEspecificoNaoInformadoException("ra");
        }

        if ((conta.getRa().length() > 8)) {
            throw new TamanhoMaximoDoCampoExcedidoException("ra", 8);
        }

        if (conta.getAgencia() == null) {
            throw new EntidadeOuClasseEmBrancoOuNaoInformadaException("agência");
        }

        if (conta.getPessoa() == null) {
            throw new EntidadeOuClasseEmBrancoOuNaoInformadaException("pessoa");
        }

    }

    public List<Conta> findAll() throws SQLException {

        ContaDAO contaDAO = new ContaDAO();
        List<Conta> resultado = contaDAO.findAll();

        return resultado;
    }

    public Conta findById(int id) throws SQLException, TamanhoMaximoDoCampoExcedidoException, Exception {

        if (id <= 0) {
            throw new TamanhoMaximoDoCampoExcedidoException("id", 1);
        }

        ContaDAO contaDAO = new ContaDAO();
        Conta retorno = contaDAO.findById(id);

        if (retorno == null) {
            throw new Exception("Não foi possível encontrar um país com o id: " + id + " informado");
        }

        return contaDAO.findById(id);
    }

    public void insert(Conta conta) throws SQLException, EntidadeOuClasseEmBrancoOuNaoInformadaException, CampoEspecificoNaoInformadoException, TamanhoMaximoDoCampoExcedidoException, ValorInvalidoException {
        validar(conta);
        ContaDAO contaDAO = new ContaDAO();
        contaDAO.insert(conta);
    }

    public void update(Conta conta) throws SQLException, EntidadeOuClasseEmBrancoOuNaoInformadaException, CampoEspecificoNaoInformadoException, TamanhoMaximoDoCampoExcedidoException, ValorInvalidoException {
        validar(conta);
        ContaDAO contaDAO = new ContaDAO();
        contaDAO.update(conta);
    }

    public void delete(int id) throws SQLException {
        ContaDAO contaDAO = new ContaDAO();
        contaDAO.delete(id);

    }
}
