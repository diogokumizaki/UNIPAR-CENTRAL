package br.unipar.central.services;

import br.unipar.central.DAO.PaisDAO;
import br.unipar.central.exceptions.CampoEspecificoNaoInformadoException;
import br.unipar.central.exceptions.EntidadeOuClasseEmBrancoOuNaoInformadaException;
import br.unipar.central.exceptions.TamanhoMaximoDoCampoExcedidoException;
import br.unipar.central.exceptions.ValorInvalidoException;
import br.unipar.central.models.Pais;
import java.sql.SQLException;
import java.util.List;
  
public class PaisService {

    public void validar(Pais pais) throws
            EntidadeOuClasseEmBrancoOuNaoInformadaException,
            CampoEspecificoNaoInformadoException,
            TamanhoMaximoDoCampoExcedidoException,
            ValorInvalidoException {

        String idStr = String.valueOf(pais.getId());

        if (pais == null) {
            throw new EntidadeOuClasseEmBrancoOuNaoInformadaException("pais");
        }

        if (pais.getId() == 0) {
            throw new CampoEspecificoNaoInformadoException("id");
        }

        if (!idStr.matches("\\d+")) {
            throw new ValorInvalidoException("id");
        }

        if (pais.getNome() == null
                || pais.getNome().isEmpty()
                || pais.getNome().isBlank()) {
            throw new CampoEspecificoNaoInformadoException("nome do pais");
        }

        if ((pais.getNome().length() > 60)) {
            throw new TamanhoMaximoDoCampoExcedidoException("nome do pais", 60);
        }

        if (pais.getSigla() == null
                || pais.getSigla().isEmpty()
                || pais.getSigla().isBlank()) {
            throw new CampoEspecificoNaoInformadoException("sigla");
        }

        if ((pais.getSigla().length() == 3)) {
            throw new TamanhoMaximoDoCampoExcedidoException("sigla", 3);
        }

        if (pais.getRa() == null
                || pais.getRa().isEmpty()
                || pais.getRa().isBlank()) {
            throw new CampoEspecificoNaoInformadoException("ra");
        }

        if ((pais.getRa().length() > 8)) {
            throw new TamanhoMaximoDoCampoExcedidoException("ra", 8);
        }

    }

    public List<Pais> findAll() throws SQLException {

        PaisDAO paisDAO = new PaisDAO();
        List<Pais> resultado = paisDAO.findAll();

        return resultado;
    }

    public Pais findById(int id) throws SQLException, TamanhoMaximoDoCampoExcedidoException, Exception {

        if (id <= 0) {
            throw new TamanhoMaximoDoCampoExcedidoException("id", 1);
        }

        PaisDAO paisDAO = new PaisDAO();
        Pais retorno = paisDAO.findById(id);

        if (retorno == null) {
            throw new Exception("Não foi possível encontrar um país com o id: " + id + " informado");
        }

        return paisDAO.findById(id);
    }

    public void insert(Pais pais) throws SQLException, EntidadeOuClasseEmBrancoOuNaoInformadaException, CampoEspecificoNaoInformadoException, TamanhoMaximoDoCampoExcedidoException, ValorInvalidoException {
        validar(pais);
        PaisDAO paisDAO = new PaisDAO();
        paisDAO.insert(pais);
    }

    public void update(Pais pais) throws SQLException, EntidadeOuClasseEmBrancoOuNaoInformadaException, CampoEspecificoNaoInformadoException, TamanhoMaximoDoCampoExcedidoException, ValorInvalidoException {
        validar(pais);
        PaisDAO paisDAO = new PaisDAO();
        paisDAO.update(pais);
    }

    public void delete(int id) throws SQLException {
        PaisDAO paisDAO = new PaisDAO();
        paisDAO.delete(id);

    }
}
