package br.unipar.central.services;

import br.unipar.central.DAO.PessoaDAO;
import br.unipar.central.exceptions.CampoEspecificoNaoInformadoException;
import br.unipar.central.exceptions.EntidadeOuClasseEmBrancoOuNaoInformadaException;
import br.unipar.central.exceptions.TamanhoMaximoDoCampoExcedidoException;
import br.unipar.central.exceptions.ValorInvalidoException;
import br.unipar.central.models.Pessoa;
import java.sql.SQLException;
import java.util.List;

public class PessoaService {

    public void validar(Pessoa PPJ) throws
            EntidadeOuClasseEmBrancoOuNaoInformadaException,
            CampoEspecificoNaoInformadoException,
            TamanhoMaximoDoCampoExcedidoException,
            ValorInvalidoException {

        String idStr = String.valueOf(PPJ.getId());

        if (PPJ == null) {
            throw new EntidadeOuClasseEmBrancoOuNaoInformadaException("pessoa");
        }

        if (PPJ.getId() == 0) {
            throw new CampoEspecificoNaoInformadoException("id");
        }

        if (!idStr.matches("\\d+")) {
            throw new ValorInvalidoException("id");
        }

        if (PPJ.getEmail() == null
                || PPJ.getEmail().isEmpty()
                || PPJ.getEmail().isBlank()) {
            throw new CampoEspecificoNaoInformadoException("email");
        }

        if ((PPJ.getEmail().length() > 100)) {
            throw new TamanhoMaximoDoCampoExcedidoException("email", 100);
        }

        if (PPJ.getRa() == null
                || PPJ.getRa().isEmpty()
                || PPJ.getRa().isBlank()) {
            throw new CampoEspecificoNaoInformadoException("ra");
        }

        if ((PPJ.getRa().length() > 8)) {
            throw new TamanhoMaximoDoCampoExcedidoException("ra", 8);
        }

    }

    public List<Pessoa> findAll() throws SQLException {

        PessoaDAO pessoaDAO = new PessoaDAO();
        List<Pessoa> resultado = pessoaDAO.findAll();

        return resultado;
    }

    public Pessoa findById(int id) throws SQLException, TamanhoMaximoDoCampoExcedidoException, Exception {

        if (id <= 0) {
            throw new TamanhoMaximoDoCampoExcedidoException("id", 1);
        }

        PessoaDAO pessoaDAO = new PessoaDAO();
        Pessoa retorno = pessoaDAO.findById(id);

        if (retorno == null) {
            throw new Exception("Não foi possível encontrar um país com o id: " + id + " informado");
        }

        return pessoaDAO.findById(id);
    }

    public void insert(Pessoa pessoa) throws SQLException, EntidadeOuClasseEmBrancoOuNaoInformadaException, CampoEspecificoNaoInformadoException, TamanhoMaximoDoCampoExcedidoException, ValorInvalidoException {
        validar(pessoa);
        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoaDAO.insert(pessoa);
    }

    public void update(Pessoa pessoa) throws SQLException, EntidadeOuClasseEmBrancoOuNaoInformadaException, CampoEspecificoNaoInformadoException, TamanhoMaximoDoCampoExcedidoException, ValorInvalidoException {
        validar(pessoa);
        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoaDAO.update(pessoa);
    }

    public void delete(int id) throws SQLException {
        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoaDAO.delete(id);

    }
}
