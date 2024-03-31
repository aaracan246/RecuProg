package org.example

import org.example.UtilidadesBiblioteca.Companion.generarIdentificadorUnico

open class GestorBiblioteca(private val registroPrestamos: RegistroPrestamos) {
    /**
     * Lista mutable que almacena el catálogo de libros.
     */
    private val catalogo: MutableList<Libro> = mutableListOf()


    /**
     * Busca un libro en el catálogo por su instancia y devuelve el libro encontrado, si existe.
     * @param libro El libro a buscar en el catálogo.
     * @return El libro encontrado o null si no se encuentra.
     */
    private fun buscarLibro(libro: Libro): Libro? {
        return catalogo.find { it.getId() == libro.getId() }
    }

    /**
     * Busca un libro en el catálogo por su ID y devuelve el libro encontrado, si existe.
     * @param id El ID del libro a buscar en el catálogo.
     * @return El libro encontrado o null si no se encuentra.
     */
    fun buscarLibro(id: Int): Libro? {
        return catalogo.find { it.getId() == id }
    }

    /**
     * Agrega un nuevo libro al catálogo, si no existe previamente.
     * @param libro El libro a agregar al catálogo.
     */
    fun agregarLibro(libro: Libro) {
        val idUnico = generarIdentificadorUnico()

        retornarTodosLibros()

        if (buscarLibro(libro) != null) {
            ConsoleSystem.escritor("Ese libro ya se encuentra en el catálogo.")
        } else {
            libro.setId(idUnico)
            catalogo.add(libro)
        }
    }

    /**
     * Elimina un libro del catálogo por su id, si existe.
     * @param id El id del libro.
     */
    fun eliminarLibro(id: Int) {
        val libroEncontrado = catalogo.find { it.getId() == id }

        retornarTodosLibros()

        if (libroEncontrado != null) {
            catalogo.remove(libroEncontrado)
            ConsoleSystem.escritor("Libro eliminado con éxito.")
        } else {
            ConsoleSystem.escritor("Ese libro no se encuentra en el catálogo.")
        }
    }


    /**
     * Muestra los libros del catálogo según la opción seleccionada por el usuario.
     */
    fun retornarLibrosPorEstado() {
        ConsoleSystem.menuRetornarLibro()

        val option = ConsoleSystem.lector().toIntOrNull()

        return when (option) {
            1 -> retornarTodosLibros()
            2 -> retornarLibrosDisponibles()
            3 -> retornarLibrosPrestados()
            else -> {
                ConsoleSystem.escritor("Esa opción no es correcta. Mostrando todos los libros.")
                retornarTodosLibros()
            }
        }
    }

    /**
     * Muestra todos los libros del catálogo.
     */
    private fun retornarTodosLibros() {
        catalogo.forEach{
            ConsoleSystem.escritor("ID: ${it.getId()}.")
            ConsoleSystem.escritor("Título: ${it.getTitulo()}.")
            ConsoleSystem.escritor("Autor: ${it.getAutor()}.")
            ConsoleSystem.escritor("Año publicación: ${it.getAnioPubli()}.")
            ConsoleSystem.escritor("Temática: ${it.getTematica()}.")
            ConsoleSystem.escritor("Estado: ${it.getEstado()}.")
            ConsoleSystem.escritor("________________")
        }
    }

    /**
     * Muestra los libros disponibles en el catálogo.
     */
    private fun retornarLibrosDisponibles() {
        val librosDisponibles = catalogo.filter { it.getEstado() == Estado.DISPONIBLE }

        if (librosDisponibles.isNotEmpty()){
            librosDisponibles.forEach{
                ConsoleSystem.escritor("ID: ${it.getId()}.")
                ConsoleSystem.escritor("Título: ${it.getTitulo()}.")
                ConsoleSystem.escritor("Autor: ${it.getAutor()}.")
                ConsoleSystem.escritor("Año publicación: ${it.getAnioPubli()}.")
                ConsoleSystem.escritor("Temática: ${it.getTematica()}.")
                ConsoleSystem.escritor("Estado: ${it.getEstado()}.")
                ConsoleSystem.escritor("________________")
            }
        }
    }

    /**
     * Muestra los libros prestados en el catálogo.
     */
    private fun retornarLibrosPrestados() {
        val librosPrestados = catalogo.filter { it.getEstado() == Estado.PRESTADO }

        if (librosPrestados.isNotEmpty()){
            librosPrestados.forEach{
                ConsoleSystem.escritor("ID: ${it.getId()}.")
                ConsoleSystem.escritor("Título: ${it.getTitulo()}.")
                ConsoleSystem.escritor("Autor: ${it.getAutor()}.")
                ConsoleSystem.escritor("Año publicación: ${it.getAnioPubli()}.")
                ConsoleSystem.escritor("Temática: ${it.getTematica()}.")
                ConsoleSystem.escritor("Estado: ${it.getEstado()}.")
                ConsoleSystem.escritor("________________")
            }
        }
    }

    /**
     * Obtiene el ID del libro ingresado por el usuario.
     * @return El ID del libro.
     */
    fun obtenerId(): Int {
        ConsoleSystem.escritor("Por favor, introduzca el ID del libro.")
        val idLibro = ConsoleSystem.lector().toInt()
        return idLibro
    }

    fun getCatalogo(): MutableList<Libro>{
        return catalogo
    }

    // Funciones que vienen de RegistroPrestamos:

    fun registrarPrestamo(idLibro: Int, idUsuario: Int){
        registroPrestamos.registrarPrestamo(idLibro, idUsuario, catalogo)
    }

    fun devolverLibro(idLibro: Int){
        registroPrestamos.devolverLibro(idLibro, catalogo)
    }

    fun retornarHistorialPrestamos(idLibro: Int){
        registroPrestamos.retornarHistorialPrestamos(idLibro)
    }

    fun retornarHistorialUsuario(idUsuario: Int){
        registroPrestamos.retornarHistorialUsuario(idUsuario)
    }
}