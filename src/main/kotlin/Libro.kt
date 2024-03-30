package org.example

data class Libro(var id: Int, val titulo: String, var autor: String, val aniopubli: Int, val tematica: String, var estado: Estado = Estado.DISPONIBLE) {
    init {
        require(id > 0)
        require(titulo.isNotEmpty())
        require(autor.isNotEmpty())
        require(aniopubli > 1100)
        require(tematica.isNotEmpty())
    }
}