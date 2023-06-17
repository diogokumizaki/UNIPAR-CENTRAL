package br.unipar.central.services;


import br.unipar.central.DAO.PessoaJuridicaDAO;
import br.unipar.central.exceptions.CampoEspecificoNaoInformadoException;
import br.unipar.central.exceptions.EntidadeOuClasseEmBrancoOuNaoInformadaException;
import br.unipar.central.exceptions.TamanhoMaximoDoCampoExcedidoException;
import br.unipar.central.exceptions.ValorInvalidoException;
import br.unipar.central.models.PessoaJuridica;
import java.sql.SQLException;
import java.util.List;

public class PessoaJuridicaService {

    public void validar(PessoaJuridica PJPJ) throws
            EntidadeOuClasseEmBrancoOuNaoInformadaException,
            CampoEspecificoNaoInformadoException,
            TamanhoMaximoDoCampoExcedidoException,
            ValorInvalidoException {

        if (PJPJ == null) {
            throw new EntidadeOuClasseEmBrancoOuNaoInformadaException("pais");
        }

        if (PJPJ.getRazaoSocial() == null
                || PJPJ.getRazaoSocial().isEmpty()
                || PJPJ.getRazaoSocial().isBlank()) {
            throw new CampoEspecificoNaoInformadoException("razão social");
        }

        if ((PJPJ.getRazaoSocial().length() > 60)) {
            throw new TamanhoMaximoDoCampoExcedidoException("razão social", 60);
        }

        if (PJPJ.getNomeFantasia() == null
                || PJPJ.getNomeFantasia().isEmpty()
                || PJPJ.getNomeFantasia().isBlank()) {
            throw new CampoEspecificoNaoInformadoException("nome fantasia");
        }

        if ((PJPJ.getNomeFantasia().length() > 60)) {
            throw new TamanhoMaximoDoCampoExcedidoException("nome fantasia", 60);
        }

        if (PJPJ.getCnaePrincipal() == null
                || PJPJ.getCnaePrincipal().isEmpty()
                || PJPJ.getCnaePrincipal().isBlank()) {
            throw new CampoEspecificoNaoInformadoException("cnae");
        }

        if (!(PJPJ.getCnaePrincipal().length() > 100)) {
            throw new TamanhoMaximoDoCampoExcedidoException("cnae", 100);
        }

        if (PJPJ.getPessoa() == null) {
            throw new EntidadeOuClasseEmBrancoOuNaoInformadaException("pessoa");
        }

    }

    public List<PessoaJuridica> findAll() throws SQLException {

        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
        List<PessoaJuridica> resultado = pessoaJuridicaDAO.findAll();

        return resultado;
    }

    public PessoaJuridica findById(String cnpj) throws SQLException, TamanhoMaximoDoCampoExcedidoException, Exception {

        if (cnpj.length() <= 0) {
            throw new TamanhoMaximoDoCampoExcedidoException("cpf", 1);
        }

        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
        PessoaJuridica retorno = pessoaJuridicaDAO.findById(cnpj);

        if (retorno == null) {
            throw new Exception("Não foi possível encontrar um país com o id: " + cnpj + " informado");
        }

        return pessoaJuridicaDAO.findById(cnpj);
    }

    public void insert(PessoaJuridica pessoaJuridica) throws SQLException, EntidadeOuClasseEmBrancoOuNaoInformadaException, CampoEspecificoNaoInformadoException, TamanhoMaximoDoCampoExcedidoException, ValorInvalidoException {
        validar(pessoaJuridica);
        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
        pessoaJuridicaDAO.insert(pessoaJuridica);
    }

    public void update(PessoaJuridica pessoaJuridica) throws SQLException, EntidadeOuClasseEmBrancoOuNaoInformadaException, CampoEspecificoNaoInformadoException, TamanhoMaximoDoCampoExcedidoException, ValorInvalidoException {
        validar(pessoaJuridica);
        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
        pessoaJuridicaDAO.update(pessoaJuridica);
    }

    public void delete(String cnpj) throws SQLException {
        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
        pessoaJuridicaDAO.delete(cnpj);

    }
}
