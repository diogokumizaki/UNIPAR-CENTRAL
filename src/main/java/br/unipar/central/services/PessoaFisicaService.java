package br.unipar.central.services;


import br.unipar.central.DAO.PessoaFisicaDAO;
import br.unipar.central.exceptions.CampoEspecificoNaoInformadoException;
import br.unipar.central.exceptions.EntidadeOuClasseEmBrancoOuNaoInformadaException;
import br.unipar.central.exceptions.TamanhoMaximoDoCampoExcedidoException;
import br.unipar.central.exceptions.ValorInvalidoException;
import br.unipar.central.models.PessoaFisica;
import java.sql.SQLException;
import java.util.List;

public class PessoaFisicaService {

    public void validar(PessoaFisica pessoaFP) throws
            EntidadeOuClasseEmBrancoOuNaoInformadaException,
            CampoEspecificoNaoInformadoException,
            TamanhoMaximoDoCampoExcedidoException,
            ValorInvalidoException {

        if (pessoaFP == null) {
            throw new EntidadeOuClasseEmBrancoOuNaoInformadaException("pais");
        }

        if (pessoaFP.getNome() == null
                || pessoaFP.getNome().isEmpty()
                || pessoaFP.getNome().isBlank()) {
            throw new CampoEspecificoNaoInformadoException("nome");
        }

        if ((pessoaFP.getNome().length() > 60)) {
            throw new TamanhoMaximoDoCampoExcedidoException("nome", 60);
        }

        if (pessoaFP.getCpf() == null
                || pessoaFP.getCpf().isEmpty()
                || pessoaFP.getCpf().isBlank()) {
            throw new CampoEspecificoNaoInformadoException("cpf");
        }

        if ((pessoaFP.getCpf().length() > 11)) {
            throw new TamanhoMaximoDoCampoExcedidoException("cpf", 11);
        }

        if (pessoaFP.getRg() == null
                || pessoaFP.getRg().isEmpty()
                || pessoaFP.getRg().isBlank()) {
            throw new CampoEspecificoNaoInformadoException("rg");
        }

        if ((pessoaFP.getRg().length() == 15)) {
            throw new TamanhoMaximoDoCampoExcedidoException("rg", 15);
        }

        if (pessoaFP.getDataNascimento() == null) {
            throw new CampoEspecificoNaoInformadoException("data de nascimento");
        }

        if (pessoaFP.getPessoa() == null) {
            throw new EntidadeOuClasseEmBrancoOuNaoInformadaException("pessoa");
        }
    }

    public List<PessoaFisica> findAll() throws SQLException {

        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        List<PessoaFisica> resultado = pessoaFisicaDAO.findAll();

        return resultado;
    }

    public PessoaFisica findById(String cpf) throws SQLException, TamanhoMaximoDoCampoExcedidoException, Exception {

        if (cpf.length() <= 0) {
            throw new TamanhoMaximoDoCampoExcedidoException("cpf", 1);
        }

        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        PessoaFisica retorno = pessoaFisicaDAO.findById(cpf);

        if (retorno == null) {
            throw new Exception("Não foi possível encontrar um país com o id: " + cpf + " informado");
        }

        return pessoaFisicaDAO.findById(cpf);
    }

    public void insert(PessoaFisica pessoaFisica) throws SQLException, EntidadeOuClasseEmBrancoOuNaoInformadaException, CampoEspecificoNaoInformadoException, TamanhoMaximoDoCampoExcedidoException, ValorInvalidoException {
        validar(pessoaFisica);
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        pessoaFisicaDAO.insert(pessoaFisica);
    }

    public void update(PessoaFisica pessoaFisica) throws SQLException, EntidadeOuClasseEmBrancoOuNaoInformadaException, CampoEspecificoNaoInformadoException, TamanhoMaximoDoCampoExcedidoException, ValorInvalidoException {
        validar(pessoaFisica);
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        pessoaFisicaDAO.update(pessoaFisica);
    }

    public void delete(String cpf) throws SQLException {
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        pessoaFisicaDAO.delete(cpf);

    }
}
