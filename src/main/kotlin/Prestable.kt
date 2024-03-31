package org.example

/**
 * Interfaz que especifica los métodos necesarios para gestionar el préstamo y la devolución de un elemento.
 */
interface Prestable {
    /**
     * Método para realizar el préstamo del elemento.
     */
    fun prestar()

    /**
     * Método para devolver el elemento.
     */
    fun devolver()
}