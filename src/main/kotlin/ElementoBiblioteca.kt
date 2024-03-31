package org.example


/**
 * Clase abstracta que representa un elemento de una biblioteca.
 *
 * @property id El identificador único del elemento.
 * @property titulo El título del elemento.
 * @property estado El estado actual del elemento.
 * @constructor Crea un nuevo elemento de biblioteca con los atributos proporcionados.
 */
abstract class ElementoBiblioteca(
    protected open var id: Int,
    protected open val titulo: String,
    protected open var estado: Estado = Estado.DISPONIBLE
): Prestable {

    /**
     * Devuelve el identificador único del libro.
     *
     * @return El identificador del libro.
     */
    fun obtenerId(): Int {
        return id
    }

    /**
     * Establece el identificador único del libro.
     *
     * @param nuevoId El nuevo identificador para el libro.
     */
    fun asignarId(nuevoId: Int) {
        id = nuevoId
    }

    /**
     * Devuelve el título del libro.
     *
     * @return El título del libro.
     */
    fun obtenerTitulo(): String {
        return titulo
    }

    /**
     * Devuelve el estado actual del libro.
     *
     * @return El estado del libro.
     */
    fun obtenerEstado(): Estado {
        return estado
    }
}