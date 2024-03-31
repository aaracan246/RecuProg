package org.example

import org.example.UtilidadesBiblioteca.Companion.generarIdentificadorUnico

class Revista(override var id: Int = generarIdentificadorUnico(),
              override val titulo: String,
              override var estado: Estado = Estado.DISPONIBLE): ElementoBiblioteca(id, titulo, estado), Prestable{



    /**
     * Establece el estado de la revista.
     *
     * @param nuevoEstado El nuevo estado para la revista.
     */
    private fun asignarEstado(nuevoEstado: Estado) {
        estado = nuevoEstado
    }


    override fun prestar() {
        asignarEstado(Estado.PRESTADO)
    }

    /**
     * Marca la revista como devuelto cambiando su estado a [Estado.DISPONIBLE].
     */
    override fun devolver() {
        asignarEstado(Estado.DISPONIBLE)
    }
}
