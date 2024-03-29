package org.example


import org.example.ConsoleSystem.userMenuMenu

object MenuUsuario {

    /**
     * Gestor de biblioteca asociado al menú de usuario.
     */
    val gestorBiblioteca = GestorBiblioteca()

    /**
     * Función que muestra el menú de usuario y gestiona las opciones seleccionadas por el usuario.
     * @param gestorBiblioteca El gestor de biblioteca utilizado para realizar operaciones de gestión de libros.
     */
    fun userMenu(gestorBiblioteca: GestorBiblioteca) {
        do {
            userMenuMenu()
            val option = readln().toIntOrNull()
            when (option) {
                1 -> crearLibro()
                2 -> {
                    val libro = gestorBiblioteca.obtenerId()
                    gestorBiblioteca.eliminarLibro(libro)
                }
                3 -> {
                    val libro = gestorBiblioteca.obtenerId()
                    gestorBiblioteca.registrarPrestamo(libro)
                }
                4 -> {
                    val libro = gestorBiblioteca.obtenerId()
                    gestorBiblioteca.devolverLibro(libro)
                }
                5 -> gestorBiblioteca.retornarLibrosPorEstado()
            }
        } while (option != null)
    }

    /**
     * Función interna para crear un nuevo libro ingresando los detalles por consola.
     */
    private fun crearLibro() {
        ConsoleSystem.escritor("Ingrese los detalles del libro: ")
        ConsoleSystem.escritor("Id: ")
        val id = ConsoleSystem.lector().toInt()

        ConsoleSystem.escritor("Título: ")
        val titulo = ConsoleSystem.lector()

        ConsoleSystem.escritor("Autor: ")
        val autor = ConsoleSystem.lector()

        ConsoleSystem.escritor("Año de publicación: ")
        val anioPubli = ConsoleSystem.lector().toInt()

        ConsoleSystem.escritor("Temática: ")
        val tematica = ConsoleSystem.lector()

        val nuevoLibro = Libro(id = id, titulo = titulo, autor = autor, aniopubli = anioPubli, tematica = tematica)

        gestorBiblioteca.agregarLibro(nuevoLibro)

        ConsoleSystem.escritor("Libro añadido con éxito.")
    }
}