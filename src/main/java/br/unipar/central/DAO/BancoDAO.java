/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.DAO;


import br.unipar.central.models.Banco;
import br.unipar.central.util.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BancoDAO {

    private static final String INSERT = "INSERT INTO banco(id, nome, ra) VALUES(?, ?, ?)";

    private static final String FIND_ALL = "SELECT id, nome, ra FROM banco ";

    private static final String FIND_BY_ID = "SELECT id, nome, ra FROM banco WHERE id = ? ";

    private static final String DELETE_BY_ID = "DELETE FROM banco WHERE id = ?";

    private static final String UPDATE = "UPDATE banco SET  nome = ?, ra = ? WHERE ID = ?";

    public List<Banco> findAll() throws SQLException {
        ArrayList<Banco> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            conn = new DataBase().getConnection();

            pstmt = conn.prepareStatement(FIND_ALL);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                Banco banco = new Banco();
                banco.setId(rs.getInt("id"));
                banco.setNome(rs.getString("nome"));
                banco.setRa(rs.getString("ra"));
                retorno.add(banco);
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

    public Banco findById(int id) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Banco retorno = null;

        try {
            conn = new DataBase().getConnection();

            pstmt = conn.prepareStatement(FIND_BY_ID);

            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                retorno = new Banco();
                retorno.setId(rs.getInt("ID"));
                retorno.setNome(rs.getString("NOME"));
                retorno.setRa(rs.getString("RA"));
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

    public void insert(Banco banco) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(INSERT);

            pstmt.setInt(1, banco.getId());
            pstmt.setString(2, banco.getNome());
            pstmt.setString(3, banco.getRa());

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
//id, nome, ra

    public void update(Banco banco) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(UPDATE);

            pstmt.setString(1, banco.getNome());
            pstmt.setString(2, banco.getRa());
            pstmt.setInt(3, banco.getId());

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
