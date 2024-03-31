package org.example


import org.example.ConsoleSystem.userMenuMenu
import org.example.UtilidadesBiblioteca.Companion.generarIdentificadorUnico

object MenuUsuario {

    /**
     * Función que muestra el menú de usuario y gestiona las opciones seleccionadas por el usuario.
     * @param gestorBiblioteca El gestor de biblioteca utilizado para realizar operaciones de gestión de libros.
     */
    fun userMenu(usuario: Usuario, gestorBiblioteca: GestorBiblioteca, registroPrestamos: RegistroPrestamos) {
        do {
            userMenuMenu()
            val option = readln().toIntOrNull()
            when (option) {
                1 -> crearLibro(gestorBiblioteca)
                2 -> {
                    val libro = gestorBiblioteca.obtenerId()
                    gestorBiblioteca.eliminarLibro(libro)
                }
                3 -> {
                    val libro = gestorBiblioteca.obtenerId()
                    val catalogo = gestorBiblioteca.getCatalogo()
                    registroPrestamos.registrarPrestamo(libro, usuario.getId(), catalogo)
                }
                4 -> {
                    val libro = gestorBiblioteca.obtenerId()
                    val catalogo = gestorBiblioteca.getCatalogo()
                    registroPrestamos.devolverLibro(libro, catalogo)
                }
                5 -> gestorBiblioteca.retornarLibrosPorEstado()

                6 -> {val libro = gestorBiblioteca.obtenerId()
                    registroPrestamos.retornarHistorialPrestamos(libro)}

                7 -> {val user = usuario.getId()
                    registroPrestamos.retornarHistorialUsuario(user)}
            }
        } while (option != null)
    }

    /**
     * Función interna para crear un nuevo libro ingresando los detalles por consola.
     */
    private fun crearLibro(gestorBiblioteca: GestorBiblioteca) {
        ConsoleSystem.escritor("Ingrese los detalles del libro: ")
        val id = generarIdentificadorUnico()

        ConsoleSystem.escritor("Título: ")
        val titulo = ConsoleSystem.lector()

        ConsoleSystem.escritor("Autor: ")
        val autor = ConsoleSystem.lector()

        ConsoleSystem.escritor("Año de publicación: ")
        val anioPubli = ConsoleSystem.lector().toInt()

        ConsoleSystem.escritor("Temática: ")
        val tematica = ConsoleSystem.lector()

        val nuevoLibro = Libro(id = id, titulo = titulo, autor = autor, anioPubli = anioPubli, tematica = tematica)

        gestorBiblioteca.agregarElemento(nuevoLibro)

        ConsoleSystem.escritor("Libro añadido con éxito.")
    }
}