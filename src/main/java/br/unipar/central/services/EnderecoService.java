package br.unipar.central.services;

import br.unipar.central.DAO.EnderecoDAO;
import br.unipar.central.exceptions.CampoEspecificoNaoInformadoException;
import br.unipar.central.exceptions.EntidadeOuClasseEmBrancoOuNaoInformadaException;
import br.unipar.central.exceptions.TamanhoMaximoDoCampoExcedidoException;
import br.unipar.central.exceptions.ValorInvalidoException;
import br.unipar.central.models.Endereco;
import java.sql.SQLException;
import java.util.List;

public class EnderecoService {

    public void validar(Endereco endereco) throws
            EntidadeOuClasseEmBrancoOuNaoInformadaException,
            CampoEspecificoNaoInformadoException,
            TamanhoMaximoDoCampoExcedidoException,
            ValorInvalidoException {

        String idStr = String.valueOf(endereco.getId());

        if (endereco == null) {
            throw new EntidadeOuClasseEmBrancoOuNaoInformadaException("pais");
        }

        if (endereco.getId() == 0) {
            throw new CampoEspecificoNaoInformadoException("id");
        }

        if (!idStr.matches("\\d+")) {
            throw new ValorInvalidoException("id");
        }

        if (endereco.getLogradouro() == null
                || endereco.getLogradouro().isEmpty()
                || endereco.getLogradouro().isBlank()) {
            throw new CampoEspecificoNaoInformadoException("nome da rua");
        }

        if ((endereco.getLogradouro().length() > 60)) {
            throw new TamanhoMaximoDoCampoExcedidoException("nome da rua", 60);
        }

        if (endereco.getNumero() == null
                || endereco.getNumero().isBlank()) {
            throw new CampoEspecificoNaoInformadoException("número da casa");
        }

        if ((endereco.getNumero().length() > 10)) {
            throw new TamanhoMaximoDoCampoExcedidoException("número da casa", 10);
        }

        if (endereco.getBairro() == null
                || endereco.getBairro().isEmpty()
                || endereco.getBairro().isBlank()) {
            throw new CampoEspecificoNaoInformadoException("nome do bairro");
        }

        if ((endereco.getBairro().length() == 30)) {
            throw new TamanhoMaximoDoCampoExcedidoException("nome do bairro", 30);
        }

        if (endereco.getCep() == null
                || endereco.getCep().isEmpty()
                || endereco.getCep().isBlank()) {
            throw new CampoEspecificoNaoInformadoException("número do cep");
        }

        if ((endereco.getCep().length() == 9)) {
            throw new TamanhoMaximoDoCampoExcedidoException("número do cep", 9);
        }

        if (endereco.getComplemento() == null
                || endereco.getComplemento().isBlank()) {
            throw new CampoEspecificoNaoInformadoException("complemento");
        }

        if ((endereco.getComplemento().length() == 255)) {
            throw new TamanhoMaximoDoCampoExcedidoException("complemento", 255);
        }

        if (endereco.getRa() == null
                || endereco.getRa().isEmpty()
                || endereco.getRa().isBlank()) {
            throw new CampoEspecificoNaoInformadoException("ra");
        }

        if ((endereco.getRa().length() > 8)) {
            throw new TamanhoMaximoDoCampoExcedidoException("ra", 8);
        }

        if (endereco.getPessoa() == null) {
            throw new EntidadeOuClasseEmBrancoOuNaoInformadaException("pessoa");
        }

        if (endereco.getCidade() == null) {
            throw new EntidadeOuClasseEmBrancoOuNaoInformadaException("cidade");
        }

    }

    public List<Endereco> findAll() throws SQLException {

        EnderecoDAO enderecoDAO = new EnderecoDAO();
        List<Endereco> resultado = enderecoDAO.findAll();

        return resultado;
    }

    public Endereco findById(int id) throws SQLException, TamanhoMaximoDoCampoExcedidoException, Exception {

        if (id <= 0) {
            throw new TamanhoMaximoDoCampoExcedidoException("id", 1);
        }

        EnderecoDAO enderecoDAO = new EnderecoDAO();
        Endereco retorno = enderecoDAO.findById(id);

        if (retorno == null) {
            throw new Exception("Não foi possível encontrar um país com o id: " + id + " informado");
        }

        return enderecoDAO.findById(id);
    }

    public void insert(Endereco endereco) throws SQLException, EntidadeOuClasseEmBrancoOuNaoInformadaException, CampoEspecificoNaoInformadoException, TamanhoMaximoDoCampoExcedidoException, ValorInvalidoException {
        validar(endereco);
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        enderecoDAO.insert(endereco);
    }

    public void update(Endereco endereco) throws SQLException, EntidadeOuClasseEmBrancoOuNaoInformadaException, CampoEspecificoNaoInformadoException, TamanhoMaximoDoCampoExcedidoException, ValorInvalidoException {
        validar(endereco);
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        enderecoDAO.update(endereco);
    }

    public void delete(int id) throws SQLException {
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        enderecoDAO.delete(id);

    }
}
