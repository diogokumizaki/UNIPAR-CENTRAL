package br.unipar.central.services;

import br.unipar.central.DAO.AgenciaDAO;
import br.unipar.central.exceptions.CampoEspecificoNaoInformadoException;
import br.unipar.central.exceptions.EntidadeOuClasseEmBrancoOuNaoInformadaException;
import br.unipar.central.exceptions.TamanhoMaximoDoCampoExcedidoException;
import br.unipar.central.exceptions.ValorInvalidoException;
import br.unipar.central.models.Agencia;
import java.sql.SQLException;
import java.util.List;

public class AgenciaService {

    public void validar(Agencia agencia) throws EntidadeOuClasseEmBrancoOuNaoInformadaException,
            CampoEspecificoNaoInformadoException,
            TamanhoMaximoDoCampoExcedidoException,
            ValorInvalidoException {

        String codStr = String.valueOf(agencia.getCodigo());

        String digitoStr = String.valueOf(agencia.getDigito());

        if (agencia == null) {
            throw new EntidadeOuClasseEmBrancoOuNaoInformadaException("agência");
        }

        if (agencia.getCodigo() == null
                || agencia.getCodigo().isBlank()) {
            throw new CampoEspecificoNaoInformadoException("códFigo");
        }

        if (!codStr.matches("\\d+")) {
            throw new ValorInvalidoException("código");
        }

        if (agencia.getRazaoSocial() == null
                || agencia.getRazaoSocial().isEmpty()
                || agencia.getRazaoSocial().isBlank()) {
            throw new CampoEspecificoNaoInformadoException("razão social da agência");
        }

        if ((agencia.getRazaoSocial().length() > 60)) {
            throw new TamanhoMaximoDoCampoExcedidoException("razão social da agência", 60);
        }

        if (agencia.getDigito() == null
                || agencia.getDigito().isEmpty()
                || agencia.getDigito().isBlank()) {
            throw new CampoEspecificoNaoInformadoException("dígito");
        }

        if ((agencia.getDigito().length() == 3)) {
            throw new TamanhoMaximoDoCampoExcedidoException("dígito", 3);
        }

        if (!digitoStr.matches("\\d+")) {
            throw new ValorInvalidoException("dígito");
        }

        if (agencia.getRa() == null
                || agencia.getRa().isEmpty()
                || agencia.getRa().isBlank()) {
            throw new CampoEspecificoNaoInformadoException("ra");
        }

        if ((agencia.getRa().length() == 8)) {
            throw new TamanhoMaximoDoCampoExcedidoException("ra", 8);
        }

        if (agencia.getCnpj() == null
                || agencia.getRa().isEmpty()
                || agencia.getRa().isBlank()) {
            throw new CampoEspecificoNaoInformadoException("cnpj");
        }

        if ((agencia.getCnpj().length() == 14)) {
            throw new TamanhoMaximoDoCampoExcedidoException("cnpj", 14);
        }

        if (agencia.getBanco() == null) {
            throw new EntidadeOuClasseEmBrancoOuNaoInformadaException("agência");
        }

        if (agencia.getBanco() == null) {
            throw new EntidadeOuClasseEmBrancoOuNaoInformadaException("banco");
        }

    }

    public List<Agencia> findAll() throws SQLException {

        AgenciaDAO agenciaDAO = new AgenciaDAO();
        List<Agencia> resultado = agenciaDAO.findAll();

        return resultado;
    }

    public Agencia findById(int id) throws SQLException, TamanhoMaximoDoCampoExcedidoException, Exception {

        if (id <= 0) {
            throw new TamanhoMaximoDoCampoExcedidoException("id", 1);
        }

        AgenciaDAO agenciaDAO = new AgenciaDAO();
        Agencia retorno = agenciaDAO.findById(id);

        if (retorno == null) {
            throw new Exception("Não foi possível encontrar um país com o id: " + id + " informado");
        }

        return agenciaDAO.findById(id);
    }

    public void insert(Agencia agencia) throws SQLException, EntidadeOuClasseEmBrancoOuNaoInformadaException, CampoEspecificoNaoInformadoException, TamanhoMaximoDoCampoExcedidoException, ValorInvalidoException {
        validar(agencia);
        AgenciaDAO agenciaDAO = new AgenciaDAO();
        agenciaDAO.insert(agencia);
    }

    public void update(Agencia agencia) throws SQLException, EntidadeOuClasseEmBrancoOuNaoInformadaException, CampoEspecificoNaoInformadoException, TamanhoMaximoDoCampoExcedidoException, ValorInvalidoException {
        validar(agencia);
        AgenciaDAO agenciaDAO = new AgenciaDAO();
        agenciaDAO.update(agencia);
    }

    public void delete(int id) throws SQLException {
        AgenciaDAO agenciaDAO = new AgenciaDAO();
        agenciaDAO.delete(id);

    }
}
