/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.DAO;


import br.unipar.central.models.Endereco;
import br.unipar.central.util.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDAO {

    private static final String INSERT = "INSERT INTO endereco(id, logradouro, numero, bairro, cep, complemento, ra, pessoa_id, cidade_id) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String FIND_ALL = "SELECT id, logradouro, numero, bairro, cep, complemento, ra, pessoa_id, cidade_id FROM endereco ";

    private static final String FIND_BY_ID = "SELECT id, logradouro, numero, bairro, cep, complemento, ra, pessoa_id, cidade_id FROM endereco WHERE id = ? ";

    private static final String DELETE_BY_ID = "DELETE FROM endereco WHERE id = ?";

    private static final String UPDATE = "UPDATE endereco SET logradouro = ?, numero = ?, bairro = ? cep = ?, complemento = ?, ra = ?, pessoa_id = ?, cidade_id = ? WHERE id = ?";

    public List<Endereco> findAll() throws SQLException {
        ArrayList<Endereco> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            conn = new DataBase().getConnection();

            pstmt = conn.prepareStatement(FIND_ALL);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                Endereco endereco = new Endereco();
                endereco.setId(rs.getInt("id"));
                endereco.setLogradouro(rs.getString("logradouro"));
                endereco.setNumero(rs.getString("numero"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setCep(rs.getString("cep"));
                endereco.setRa(rs.getString("ra"));
                endereco.setComplemento(rs.getString("complemento"));
                endereco.setRa(rs.getString("ra"));
                endereco.setCidade(new CidadeDAO().findById(rs.getInt("cidade_id")));
                endereco.setPessoa(new PessoaDAO().findById(rs.getInt("pessoa_id")));

                retorno.add(endereco);
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

    public Endereco findById(int id) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Endereco retorno = null;

        try {
            conn = new DataBase().getConnection();

            pstmt = conn.prepareStatement(FIND_BY_ID);

            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                retorno = new Endereco();
                retorno.setId(rs.getInt("id"));
                retorno.setLogradouro(rs.getString("logradouro"));
                retorno.setNumero(rs.getString("numero"));
                retorno.setBairro(rs.getString("bairro"));
                retorno.setCep(rs.getString("cep"));
                retorno.setRa(rs.getString("ra"));
                retorno.setComplemento(rs.getString("complemento"));
                retorno.setRa(rs.getString("ra"));
                retorno.setCidade(new CidadeDAO().findById(rs.getInt("cidade_id")));
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

    public void insert(Endereco endereco) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(INSERT);

            pstmt.setInt(1, endereco.getId());
            pstmt.setString(2, endereco.getLogradouro());
            pstmt.setString(3, endereco.getNumero());
            pstmt.setString(4, endereco.getBairro());
            pstmt.setString(5, endereco.getCep());
            pstmt.setString(6, endereco.getComplemento());
            pstmt.setString(7, endereco.getRa());
            pstmt.setInt(8, endereco.getPessoa().getId());
            pstmt.setInt(9, endereco.getCidade().getId());
//id, logradouro, numero, bairro, cep, complemento, ra, pessoa_id, cidade_id
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

    public void update(Endereco endereco) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(UPDATE);

            pstmt.setString(1, endereco.getLogradouro());
            pstmt.setString(2, endereco.getNumero());
            pstmt.setString(3, endereco.getBairro());
            pstmt.setString(4, endereco.getCep());
            pstmt.setString(5, endereco.getComplemento());
            pstmt.setString(6, endereco.getRa());
            pstmt.setInt(7, endereco.getPessoa().getId());
            pstmt.setInt(8, endereco.getCidade().getId());
            pstmt.setInt(9, endereco.getId());
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
