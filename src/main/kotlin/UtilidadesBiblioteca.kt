package org.example

class UtilidadesBiblioteca {

    companion object{

        val setDeId = mutableSetOf<Int>()

        fun generarIdentificadorUnico(): Int{
            val id = (1..2000).random()
            setDeId.add(id)

            return id
        }
    }


}