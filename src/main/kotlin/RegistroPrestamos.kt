package org.example

/**
 * Clase para gestionar los préstamos de libros.
 */
open class RegistroPrestamos {
    /**
     * Mapa mutable que almacena los préstamos actuales. La clave es el ID del libro y el valor es el ID del usuario.
     */
    private val prestamosActuales: MutableMap<Int, Int> = mutableMapOf()

    /**
     * Mapa mutable que almacena el historial de préstamos. La clave es el ID del libro y el valor es una lista de IDs de usuarios.
     */
    private val historialPrestamos: MutableMap<Int, MutableList<Int>> = mutableMapOf()

    /**
     * Registra un préstamo de libro.
     * @param idLibro El ID del libro que se va a prestar.
     * @param idUsuario El ID del usuario que está tomando en préstamo el libro.
     * @param catalogo La lista mutable del catálogo de libros.
     */
    fun registrarPrestamo(idLibro: Int, idUsuario: Int, catalogo: MutableList<Libro>) {
        val libro = catalogo.find { it.getId() == idLibro }

        if (libro != null && libro.getEstado() == Estado.DISPONIBLE) {
            libro.setEstado(Estado.PRESTADO)
            prestamosActuales[idLibro] = idUsuario
            historialPrestamos.getOrPut(idLibro) { mutableListOf() }.add(idUsuario)
            ConsoleSystem.escritor("Préstamo registrado con éxito.")
        } else {
            ConsoleSystem.escritor("Ese libro ya ha sido prestado.")
            return
        }
    }

    /**
     * Registra la devolución de un libro.
     * @param idLibro El ID del libro que se va a devolver.
     * @param catalogo La lista mutable del catálogo de libros.
     */
    fun devolverLibro(idLibro: Int, catalogo: MutableList<Libro>) {
        val libro = catalogo.find { it.getId() == idLibro }

        if (libro != null && libro.getEstado() == Estado.PRESTADO) {
            libro.setEstado(Estado.DISPONIBLE)
            prestamosActuales.remove(idLibro)
            ConsoleSystem.escritor("Libro devuelto con éxito.")
        } else {
            ConsoleSystem.escritor("Ese libro no se encuentra prestado.")
        }
    }

    /**
     * Retorna el historial de préstamos de un libro específico.
     * @param idLibro El ID del libro del cual se desea obtener el historial de préstamos.
     */
    fun retornarHistorialPrestamos(idLibro: Int) {
        ConsoleSystem.escritor("Se ha prestado este libro a los siguientes usuarios: ${historialPrestamos[idLibro]}")
    }

    /**
     * Retorna el historial de préstamos de un usuario específico.
     * @param idUsuario El ID del usuario del cual se desea obtener el historial de préstamos.
     */
    fun retornarHistorialUsuario(idUsuario: Int) {
        val historialUsuario = mutableListOf<Int>()

        historialPrestamos.forEach { (idLibro, usuarios) ->
            if (usuarios.contains(idUsuario)) {
                historialUsuario.add(idLibro)
            }
        }

        ConsoleSystem.escritor("$historialUsuario")
    }
}