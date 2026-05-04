package com.gestionfuncionarios;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        System.out.println("=== CONECTANDO A LA BASE DE DATOS ===");
        ConexionBD.conectar();
        FuncionarioDAO dao = new FuncionarioDAO();

        List<Funcionario> lista = new ArrayList<>();

        lista.add(new Funcionario("Julián", 30, "Desarrollador"));
        lista.add(new Funcionario("Rocío", 25, "QA"));
        lista.add(new Funcionario("Leonel", 40, "Gerente"));

        System.out.println("=== LISTA DE FUNCIONARIOS ===");
        for (Funcionario f : lista) {
            f.mostrarInfo();
            System.out.println("------------");
        }

        String nombreBuscado = "Rocío";
        boolean encontrado = false;

        for (Funcionario f : lista) {
            if (f.getNombre().equals(nombreBuscado)) {
                System.out.println("\n=== FUNCIONARIO ENCONTRADO ===");
                f.mostrarInfo();
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("\nFuncionario no encontrado");
        }

        Funcionario nuevo = new Funcionario("Carolina", 28, "Analista");
        lista.add(nuevo);

        dao.guardar(nuevo);

        System.out.println("\n=== NUEVO FUNCIONARIO AGREGADO ===");
        nuevo.mostrarInfo();

        System.out.println("\n=== LISTA ACTUALIZADA ===");
        for (Funcionario f : lista) {
            f.mostrarInfo();
            System.out.println("------------");
        }

        // 🔥 AQUÍ VA LO NUEVO (DENTRO DEL MAIN)
        System.out.println("\n=== FUNCIONARIOS DESDE BD ===");

        List<Funcionario> desdeBD = dao.listar();

        for (Funcionario f : desdeBD) {
            f.mostrarInfo();
            System.out.println("------------");
        }
    }
}
