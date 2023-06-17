package br.unipar.central.DAO;


import br.unipar.central.enums.TipoTransacaoEnum;
import br.unipar.central.models.Transacao;
import br.unipar.central.util.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransacaoDAO {

    private static final String INSERT = "INSERT INTO transacao(id, valor, tipo, ra, conta_origem, conta_destino) VALUES(?, ?, ?, ?, ?, ?)";

    private static final String FIND_ALL = "SELECT id, valor, tipo, ra, conta_origem, conta_destino FROM transacao ";

    private static final String FIND_BY_ID = "SELECT id, valor, tipo, ra, conta_origem, conta_destino FROM transacao WHERE id = ? ";

    private static final String DELETE_BY_ID = "DELETE FROM transacao WHERE id = ?";

    private static final String UPDATE = "UPDATE transacao SET  id = ?, valor = ?, tipo = ? ra = ?, conta_origem = ?, conta_destino = ? WHERE id = ?";

    public List<Transacao> findAll() throws SQLException {
        ArrayList<Transacao> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            conn = new DataBase().getConnection();

            pstmt = conn.prepareStatement(FIND_ALL);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                Transacao transacao = new Transacao();
                transacao.setId(rs.getInt("id"));
                transacao.setValor(Double.parseDouble(rs.getString("valor")));
                transacao.setTipo(TipoTransacaoEnum.valueOf(rs.getString("tipo")));
                transacao.setRa(rs.getString("ra"));
                transacao.setConta_origem(rs.getInt("conta_origem"));
                transacao.setConta_destino(rs.getInt("conta_destino"));

                retorno.add(transacao);
            }
            //id, valor, tipo, ra, conta_origem, conta_destino
        } finally {

            if (conn != null) {
                conn.close();
            }

            if (conn != null) {
                pstmt.close();
            }
        }

        return retorno;
    }

    public Transacao findById(int id) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Transacao retorno = null;

        try {
            conn = new DataBase().getConnection();

            pstmt = conn.prepareStatement(FIND_BY_ID);

            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                retorno = new Transacao();
                retorno.setId(rs.getInt("id"));
                retorno.setValor(Double.parseDouble(rs.getString("valor")));
                retorno.setTipo(TipoTransacaoEnum.valueOf(rs.getString("tipo")));
                retorno.setRa(rs.getString("ra"));
                retorno.setConta_origem(rs.getInt("conta_origem"));
                retorno.setConta_destino(rs.getInt("conta_destino"));

            }
        } finally {

            if (rs != null) {
                rs.close();
            }

            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return retorno;
    }

    public void insert(Transacao transacao) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(INSERT);

            pstmt.setInt(1, transacao.getId());
            pstmt.setDouble(2, transacao.getValor());
            pstmt.setString(3, transacao.getTipo().name());
            pstmt.setString(4, transacao.getRa());
            pstmt.setInt(5, transacao.getConta_origem());
            pstmt.setInt(6, transacao.getConta_destino());
//id, valor, tipo, ra, conta_origem, conta_destino
            pstmt.executeUpdate();
//numero, digito, saldo, tipo, ra, agencia_id, pessoa_id
        } finally {

            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

    }

    public void update(Transacao transacao) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(UPDATE);

            pstmt.setDouble(1, transacao.getValor());
            pstmt.setString(2, transacao.getTipo().name());
            pstmt.setString(3, transacao.getRa());
            pstmt.setInt(4, transacao.getConta_origem());
            pstmt.setInt(5, transacao.getConta_destino());
            pstmt.setInt(6, transacao.getId());

            pstmt.executeUpdate();

        } finally {

            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

    }

    public void delete(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(DELETE_BY_ID);

            pstmt.setInt(1, id);

            pstmt.executeUpdate();

        } finally {

            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
}
