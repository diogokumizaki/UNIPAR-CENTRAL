package br.unipar.central.DAO;


import br.unipar.central.models.PessoaJuridica;
import br.unipar.central.util.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaJuridicaDAO {

    private static final String INSERT = "INSERT INTO pessoajuridica(razaosocial, cnpj, cnaeprincipal, fantasia, pessoa_id) VALUES(?, ?, ?, ?, ?)";

    private static final String FIND_ALL = "SELECT razaosocial, cnpj, cnaeprincipal, fantasia, pessoa_id FROM pessoajuridica ";

    private static final String FIND_BY_ID = "SELECT razaosocial, cnpj, cnaeprincipal, fantasia, pessoa_id FROM pessoajuridica WHERE cnpj = ? ";

    private static final String DELETE_BY_ID = "DELETE FROM pessoajuridica WHERE cnpj = ?";

    private static final String UPDATE = "UPDATE pessoajuridica SET razaosocial = ?, cnaeprincipal = ?, fantasia = ?, pessoa_id = ? WHERE cnpj = ?";

    public List<PessoaJuridica> findAll() throws SQLException {
        ArrayList<PessoaJuridica> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            conn = new DataBase().getConnection();

            pstmt = conn.prepareStatement(FIND_ALL);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                PessoaJuridica pessoaJuridica = new PessoaJuridica();
                pessoaJuridica.setRazaoSocial(rs.getString("razaosocial"));
                pessoaJuridica.setNomeFantasia(rs.getString("nomefantasia"));
                pessoaJuridica.setCNPJ(rs.getString("cnpj"));
                pessoaJuridica.setCnaePrincipal(rs.getString("cnaeprincipal"));
                pessoaJuridica.setPessoa(new PessoaDAO().findById(rs.getInt("pessoa_id")));
                retorno.add(pessoaJuridica);
            }
        } finally {

            if (rs != null) {
                rs.close();
            }

            if (conn != null) {
                conn.close();
            }

            if (conn != null) {
                pstmt.close();
            }
        }

        return retorno;
    }

//  private String razaoSocial;
//    private String nomeFantasia;
//    private String CNPJ;
//    private String cnaePrincipal;
//    private PessoaPOJO pessoa;
    public PessoaJuridica findById(String cnpj) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        PessoaJuridica retorno = null;

        try {
            conn = new DataBase().getConnection();

            pstmt = conn.prepareStatement(FIND_BY_ID);

            pstmt.setString(3, cnpj);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                retorno = new PessoaJuridica();
                retorno.setRazaoSocial(rs.getString("razaosocial"));
                retorno.setNomeFantasia(rs.getString("nomefantasia"));
                retorno.setCNPJ(rs.getString("cnpj"));
                retorno.setCnaePrincipal(rs.getString("cnaeprincipal"));
                retorno.setPessoa(new PessoaDAO().findById(rs.getInt("pessoa_id")));
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

    public void insert(PessoaJuridica pessoaJuridica) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(INSERT);

            pstmt.setString(1, pessoaJuridica.getRazaoSocial());
            pstmt.setString(2, pessoaJuridica.getCNPJ());
            pstmt.setString(3, pessoaJuridica.getCnaePrincipal());
            pstmt.setString(4, pessoaJuridica.getNomeFantasia());
            pstmt.setInt(5, pessoaJuridica.getPessoa().getId());

            pstmt.executeUpdate();
//razaosocial, cnpj, cnaeprincipal, fantasia, pessoa_id
        } finally {

            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

    }

    public void update(PessoaJuridica pessoaJuridica) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(UPDATE);

            pstmt.setString(1, pessoaJuridica.getRazaoSocial());
            pstmt.setString(2, pessoaJuridica.getCNPJ());
            pstmt.setString(3, pessoaJuridica.getCnaePrincipal());
            pstmt.setString(4, pessoaJuridica.getNomeFantasia());
            pstmt.setInt(5, pessoaJuridica.getPessoa().getId());

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

    public void delete(String cnpj) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(DELETE_BY_ID);

            pstmt.setString(1, cnpj);

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
