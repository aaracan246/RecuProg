package org.example

class UtilidadesBiblioteca {

    companion object{
        val setDeId = mutableSetOf<Int>()

        /** Función encargada de generar un identificador único.
         *
         * @return id de tipo Int.
         * */
        fun generarIdentificadorUnico(): Int{
            val id = (1..2000).random()
            setDeId.add(id)

            return id
        }
    }


}