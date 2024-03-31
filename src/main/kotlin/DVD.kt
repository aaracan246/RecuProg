package org.example

class DVD(override var id: Int,
          override val titulo: String,
          override var estado: Estado = Estado.DISPONIBLE): ElementoBiblioteca(id, titulo, estado), Prestable {



    /**
     * Establece el estado del DVD.
     *
     * @param nuevoEstado El nuevo estado para el DVD.
     */
    private fun asignarEstado(nuevoEstado: Estado) {
        estado = nuevoEstado
    }


    override fun prestar() {
        asignarEstado(Estado.PRESTADO)
    }

    /**
     * Marca el DVD como devuelto cambiando su estado a [Estado.DISPONIBLE].
     */
    override fun devolver() {
        asignarEstado(Estado.DISPONIBLE)
    }
}