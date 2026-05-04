package com.gestionfuncionarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    public void guardar(Funcionario f) {

        Connection con = ConexionBD.conectar();

        String sql = "INSERT INTO funcionario (nombre, apellido, documento, id_cargo, id_dependencia) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, f.getNombre());
            ps.setString(2, "Perez");
            ps.setString(3, "DOC" + System.currentTimeMillis());
            ps.setInt(4, 1);
            ps.setInt(5, 1);

            ps.executeUpdate();

            System.out.println("✔ Funcionario guardado en BD");

        } catch (SQLException e) {
            System.out.println("❌ Error al guardar funcionario");
            e.printStackTrace();
        }
    }

    // MÉTODO listar
    public List<Funcionario> listar() {

        List<Funcionario> lista = new ArrayList<>();

        Connection con = ConexionBD.conectar();

        String sql = "SELECT nombre, apellido FROM funcionario";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");

                Funcionario f = new Funcionario(nombre + " " + apellido, 0, "BD");
            }

        } catch (SQLException e) {
            System.out.println("Error al listar funcionarios");
            e.printStackTrace();
        }

        return lista;
    }
}