package br.unipar.central.services;


import br.unipar.central.DAO.BancoDAO;
import br.unipar.central.exceptions.CampoEspecificoNaoInformadoException;
import br.unipar.central.exceptions.EntidadeOuClasseEmBrancoOuNaoInformadaException;
import br.unipar.central.exceptions.TamanhoMaximoDoCampoExcedidoException;
import br.unipar.central.exceptions.ValorInvalidoException;
import br.unipar.central.models.Banco;
import java.sql.SQLException;
import java.util.List;

public class BancoService {

    public void validar(Banco banco) throws EntidadeOuClasseEmBrancoOuNaoInformadaException,
            CampoEspecificoNaoInformadoException,
            TamanhoMaximoDoCampoExcedidoException,
            ValorInvalidoException {

        String codStr = String.valueOf(banco.getId());

        if (banco == null) {
            throw new EntidadeOuClasseEmBrancoOuNaoInformadaException("banco");
        }

        if (banco.getId() == 0) {
            throw new CampoEspecificoNaoInformadoException("códFigo");
        }

        if (!codStr.matches("\\d+")) {
            throw new ValorInvalidoException("código");
        }

        if (banco.getNome() == null
                || banco.getNome().isEmpty()
                || banco.getNome().isBlank()) {
            throw new CampoEspecificoNaoInformadoException("nome do banco");
        }

        if ((banco.getNome().length() > 60)) {
            throw new TamanhoMaximoDoCampoExcedidoException("nome do banco", 60);
        }

        if (banco.getRa() == null
                || banco.getRa().isEmpty()
                || banco.getRa().isBlank()) {
            throw new CampoEspecificoNaoInformadoException("ra");
        }

        if ((banco.getRa().length() > 8)) {
            throw new TamanhoMaximoDoCampoExcedidoException("ra", 8);
        }
    }

    public List<Banco> findAll() throws SQLException {

        BancoDAO bancoDAO = new BancoDAO();
        List<Banco> resultado = bancoDAO.findAll();

        return resultado;
    }

    public Banco findById(int id) throws SQLException, TamanhoMaximoDoCampoExcedidoException, Exception {

        if (id <= 0) {
            throw new TamanhoMaximoDoCampoExcedidoException("id", 1);
        }

        BancoDAO bancoDAO = new BancoDAO();
        Banco retorno = bancoDAO.findById(id);

        if (retorno == null) {
            throw new Exception("Não foi possível encontrar um país com o id: " + id + " informado");
        }

        return bancoDAO.findById(id);
    }

    public void insert(Banco banco) throws SQLException, EntidadeOuClasseEmBrancoOuNaoInformadaException, CampoEspecificoNaoInformadoException, TamanhoMaximoDoCampoExcedidoException, ValorInvalidoException {
        validar(banco);
        BancoDAO bancoDAO = new BancoDAO();
        bancoDAO.insert(banco);
    }

    public void update(Banco banco) throws SQLException, EntidadeOuClasseEmBrancoOuNaoInformadaException, CampoEspecificoNaoInformadoException, TamanhoMaximoDoCampoExcedidoException, ValorInvalidoException {
        validar(banco);
        BancoDAO bancoDAO = new BancoDAO();
        bancoDAO.update(banco);
    }

    public void delete(int id) throws SQLException {
        BancoDAO bancoDAO = new BancoDAO();
        bancoDAO.delete(id);

    }
}
