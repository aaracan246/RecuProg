package org.example

/**
 * Representa un libro con sus atributos básicos.
 *
 * @property id El identificador único del libro.
 * @property titulo El título del libro.
 * @property autor El autor del libro.
 * @property anioPubli El año de publicación del libro.
 * @property tematica La temática del libro.
 * @property estado El estado actual del libro.
 * @constructor Crea un nuevo libro con los atributos proporcionados.
 * @throws IllegalArgumentException Si alguno de los argumentos no cumple con las restricciones especificadas.
 */
data class Libro(
    private var id: Int,
    private val titulo: String,
    private var autor: String,
    private val anioPubli: Int,
    private val tematica: String,
    private var estado: Estado = Estado.DISPONIBLE
) {
    init {
        require(id > 0) { "El ID del libro debe ser mayor que cero." }
        require(titulo.isNotEmpty()) { "El título del libro no puede estar vacío." }
        require(autor.isNotEmpty()) { "El autor del libro no puede estar vacío." }
        require(anioPubli > 1100) { "El año de publicación del libro debe ser posterior a 1100." }
        require(tematica.isNotEmpty()) { "La temática del libro no puede estar vacía." }
    }

    /**
     * Devuelve el identificador único del libro.
     *
     * @return El identificador del libro.
     */
    fun getId(): Int {
        return id
    }

    /**
     * Establece el identificador único del libro.
     *
     * @param nuevoId El nuevo identificador para el libro.
     */
    fun setId(nuevoId: Int) {
        id = nuevoId
    }

    /**
     * Devuelve el título del libro.
     *
     * @return El título del libro.
     */
    fun getTitulo(): String {
        return titulo
    }

    /**
     * Devuelve el autor del libro.
     *
     * @return El autor del libro.
     */
    fun getAutor(): String {
        return autor
    }

    /**
     * Devuelve el año de publicación del libro.
     *
     * @return El año de publicación del libro.
     */
    fun getAnioPubli(): Int {
        return anioPubli
    }

    /**
     * Devuelve la temática del libro.
     *
     * @return La temática del libro.
     */
    fun getTematica(): String {
        return tematica
    }

    /**
     * Devuelve el estado actual del libro.
     *
     * @return El estado del libro.
     */
    fun getEstado(): Estado {
        return estado
    }

    /**
     * Establece el estado del libro.
     *
     * @param nuevoEstado El nuevo estado para el libro.
     */
    fun setEstado(nuevoEstado: Estado) {
        estado = nuevoEstado
    }
}