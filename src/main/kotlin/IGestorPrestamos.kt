package org.example

/**
 * Interfaz que define los métodos necesarios para gestionar los préstamos de libros.
 */
interface IGestorPrestamos {
    /**
     * Registra un préstamo de libro.
     * @param idLibro El ID del libro que se va a prestar.
     * @param idUsuario El ID del usuario que está tomando en préstamo el libro.
     * @param catalogo La lista mutable del catálogo de libros.
     */
    fun registrarPrestamo(idLibro: Int, idUsuario: Int, catalogo: MutableList<ElementoBiblioteca>)

    /**
     * Registra la devolución de un libro.
     * @param idLibro El ID del libro que se va a devolver.
     * @param catalogo La lista mutable del catálogo de libros.
     */
    fun devolverLibro(idLibro: Int, catalogo: MutableList<ElementoBiblioteca>)

    /**
     * Retorna el historial de préstamos de un libro específico.
     * @param idLibro El ID del libro del cual se desea obtener el historial de préstamos.
     */
    fun retornarHistorialPrestamos(idLibro: Int)

    /**
     * Retorna el historial de préstamos de un usuario específico.
     * @param idUsuario El ID del usuario del cual se desea obtener el historial de préstamos.
     */
    fun retornarHistorialUsuario(idUsuario: Int)
}