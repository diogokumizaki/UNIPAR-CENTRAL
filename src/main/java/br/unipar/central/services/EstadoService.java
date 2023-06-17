package br.unipar.central.services;

import br.unipar.central.DAO.EstadoDAO;
import br.unipar.central.DAO.PaisDAO;
import br.unipar.central.exceptions.CampoEspecificoNaoInformadoException;
import br.unipar.central.exceptions.EntidadeOuClasseEmBrancoOuNaoInformadaException;
import br.unipar.central.exceptions.TamanhoMaximoDoCampoExcedidoException;
import br.unipar.central.exceptions.ValorInvalidoException;
import br.unipar.central.models.Estado;
import java.sql.SQLException;
import java.util.List;

public class EstadoService {

    public void validar(Estado estado) throws
            EntidadeOuClasseEmBrancoOuNaoInformadaException,
            CampoEspecificoNaoInformadoException,
            TamanhoMaximoDoCampoExcedidoException,
            ValorInvalidoException {

        String idStr = String.valueOf(estado.getId());

        if (estado == null) {
            throw new EntidadeOuClasseEmBrancoOuNaoInformadaException("estado");
        }

        if (estado.getId() == 0) {
            throw new CampoEspecificoNaoInformadoException("id");
        }

        if (!idStr.matches("\\d+")) {
            throw new ValorInvalidoException("id");
        }

        if (estado.getNome() == null
                || estado.getNome().isEmpty()
                || estado.getNome().isBlank()) {
            throw new CampoEspecificoNaoInformadoException("nome do estado");
        }

        if ((estado.getNome().length() > 30)) {
            throw new TamanhoMaximoDoCampoExcedidoException("nome do estado", 30);
        }

        if (estado.getSigla() == null
                || estado.getSigla().isEmpty()
                || estado.getSigla().isBlank()) {
            throw new CampoEspecificoNaoInformadoException("sigla do estado");
        }

        if ((estado.getSigla().length() == 2)) {
            throw new TamanhoMaximoDoCampoExcedidoException("sigla do estado", 2);
        }

        if (estado.getRa() == null
                || estado.getRa().isEmpty()
                || estado.getRa().isBlank()) {
            throw new CampoEspecificoNaoInformadoException("ra");
        }

        if (!(estado.getRa().length() > 8)) {
            throw new TamanhoMaximoDoCampoExcedidoException("ra", 8);
        }

        if (estado.getPais() == null) {
            throw new EntidadeOuClasseEmBrancoOuNaoInformadaException("pais");
        }

    }

    public List<Estado> findAll() throws SQLException {

        EstadoDAO estadoDAO = new EstadoDAO();
        List<Estado> resultado = estadoDAO.findAll();

        return resultado;
    }

    public Estado findById(int id) throws SQLException, TamanhoMaximoDoCampoExcedidoException, Exception {

        if (id <= 0) {
            throw new TamanhoMaximoDoCampoExcedidoException("id", 1);
        }

        EstadoDAO estadoDAO = new EstadoDAO();
        Estado retorno = estadoDAO.findById(id);

        if (retorno == null) {
            throw new Exception("Não foi possível encontrar um país com o id: " + id + " informado");
        }

        return estadoDAO.findById(id);
    }

    public void insert(Estado estado) throws SQLException, EntidadeOuClasseEmBrancoOuNaoInformadaException, CampoEspecificoNaoInformadoException, TamanhoMaximoDoCampoExcedidoException, ValorInvalidoException {
        validar(estado);
        EstadoDAO estadoDAO = new EstadoDAO();
        estadoDAO.insert(estado);
    }

    public void update(Estado estado) throws SQLException, EntidadeOuClasseEmBrancoOuNaoInformadaException, CampoEspecificoNaoInformadoException, TamanhoMaximoDoCampoExcedidoException, ValorInvalidoException {
        validar(estado);
        EstadoDAO estadoDAO = new EstadoDAO();
        estadoDAO.update(estado);
    }

    public void delete(int id) throws SQLException {
        EstadoDAO estadoDAO = new EstadoDAO();
        estadoDAO.delete(id);

    }
}
