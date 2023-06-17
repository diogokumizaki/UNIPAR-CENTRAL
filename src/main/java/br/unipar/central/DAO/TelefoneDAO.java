package br.unipar.central.DAO;


import br.unipar.central.enums.TipoOperadoraEnum;
import br.unipar.central.models.Telefone;
import br.unipar.central.util.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TelefoneDAO {

    private static final String INSERT = "INSERT INTO telefone(id, numero, operadora, ra, agencia_id, pessoa_id) VALUES(?, ?, ?, ?, ?, ?)";

    private static final String FIND_ALL = "SELECT id, numero, operadora, ra, agencia_id, pessoa_id FROM telefone ";

    private static final String FIND_BY_ID = "SELECT id, numero, operadora, ra, agencia_id, pessoa_id FROM telefone WHERE id = ? ";

    private static final String DELETE_BY_ID = "DELETE FROM telefone WHERE id = ?";

    private static final String UPDATE = "UPDATE telefone SET  numero = ?, operadora = ?, ra = ? agencia_id = ?, pessoa_id = ? WHERE id = ?";

    public List<Telefone> findAll() throws SQLException {
        ArrayList<Telefone> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            conn = new DataBase().getConnection();

            pstmt = conn.prepareStatement(FIND_ALL);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                Telefone telefone = new Telefone();
                telefone.setId(rs.getInt("id"));
                telefone.setNumero(rs.getString("numero"));
                telefone.setOperadora(TipoOperadoraEnum.valueOf(rs.getString("operadora")));
                telefone.setRa(rs.getString("ra"));
                telefone.setAgencia(new AgenciaDAO().findById(rs.getInt("agencia_id")));
                telefone.setPessoa(new PessoaDAO().findById(rs.getInt("pessoa_id")));
//id, numero, operadora, ra, agencia_id, pessoa_id
                retorno.add(telefone);
            }
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

    public Telefone findById(int id) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Telefone retorno = null;

        try {
            conn = new DataBase().getConnection();

            pstmt = conn.prepareStatement(FIND_BY_ID);

            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                retorno = new Telefone();
                retorno.setId(rs.getInt("id"));
                retorno.setNumero(rs.getString("numero"));
                retorno.setOperadora(TipoOperadoraEnum.valueOf(rs.getString("operadora")));
                retorno.setRa(rs.getString("ra"));
                retorno.setAgencia(new AgenciaDAO().findById(rs.getInt("agencia_id")));
                retorno.setPessoa(new PessoaDAO().findById(rs.getInt("pessoa_id")));

                //id, numero, operadora, ra, agencia_id, pessoa_id
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

    public void insert(Telefone telefone) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(INSERT);

            pstmt.setInt(1, telefone.getId());
            pstmt.setString(2, telefone.getNumero());
            pstmt.setString(3, telefone.getOperadora().name());
            pstmt.setString(4, telefone.getRa());
            pstmt.setInt(5, telefone.getAgencia().getId());
            pstmt.setInt(6, telefone.getPessoa().getId());

            pstmt.executeUpdate();
//id, numero, operadora, ra, agencia_id, pessoa_id
        } finally {

            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

    }

    public void update(Telefone telefone) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(UPDATE);

            pstmt.setInt(1, telefone.getId());
            pstmt.setString(2, telefone.getNumero());
            pstmt.setString(3, telefone.getOperadora().name());
            pstmt.setString(4, telefone.getRa());
            pstmt.setInt(5, telefone.getAgencia().getId());
            pstmt.setInt(6, telefone.getPessoa().getId());
//id, numero, operadora, ra, agencia_id, pessoa_id
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
