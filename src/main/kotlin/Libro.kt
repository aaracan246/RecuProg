package org.example

import org.example.UtilidadesBiblioteca.Companion.generarIdentificadorUnico

/**
 * Representa un libro con sus atributos básicos.
 *
 * @property obtenerId El identificador único del libro.
 * @property titulo El título del libro.
 * @property autor El autor del libro.
 * @property anioPubli El año de publicación del libro.
 * @property tematica La temática del libro.
 * @property estado El estado actual del libro.
 * @constructor Crea un nuevo libro con los atributos proporcionados.
 * @throws IllegalArgumentException Si alguno de los argumentos no cumple con las restricciones especificadas.
 */
class Libro(
    override var id: Int = generarIdentificadorUnico(),
    override val titulo: String,
    private var autor: String,
    private val anioPubli: Int,
    private val tematica: String,
    override var estado: Estado = Estado.DISPONIBLE
): ElementoBiblioteca(generarIdentificadorUnico(), titulo, estado), Prestable {
    init {
        require(id > 0) { "El ID del libro debe ser mayor que cero." }
        require(titulo.isNotEmpty()) { "El título del libro no puede estar vacío." }
        require(autor.isNotEmpty()) { "El autor del libro no puede estar vacío." }
        require(anioPubli > 1100) { "El año de publicación del libro debe ser posterior a 1100." }
        require(tematica.isNotEmpty()) { "La temática del libro no puede estar vacía." }
    }



    /**
     * Devuelve el autor del libro.
     *
     * @return El autor del libro.
     */
    fun obtenerAutor(): String {
        return autor
    }

    /**
     * Devuelve el año de publicación del libro.
     *
     * @return El año de publicación del libro.
     */
    fun obtenerAnioPubli(): Int {
        return anioPubli
    }

    /**
     * Devuelve la temática del libro.
     *
     * @return La temática del libro.
     */
    fun obtenerTematica(): String {
        return tematica
    }


    /**
     * Establece el estado del libro.
     *
     * @param nuevoEstado El nuevo estado para el libro.
     */
    private fun asignarEstado(nuevoEstado: Estado) {
        estado = nuevoEstado
    }

    /**
     * Marca el libro como prestado cambiando su estado a [Estado.PRESTADO].
     */
    override fun prestar() {
        asignarEstado(Estado.PRESTADO)
    }

    /**
     * Marca el libro como devuelto cambiando su estado a [Estado.DISPONIBLE].
     */
    override fun devolver() {
        asignarEstado(Estado.DISPONIBLE)
    }
}