package clase1

fun main() {
    // Objetos Singleton ------------------
    println(MiObjetoSingleton.nombre) // Imprime "Singleton"
    MiObjetoSingleton.imprimirMensaje() // Imprime "Hola desde el objeto Singleton"

    // Objetos anonimos
    val miObjetoAnonimo = object : MiInterfaz {
        override fun metodo1() {
            println("Implementación de método 1")
        }

        override fun metodo2() {
            println("Implementación de método 2")
        }
    }

    miObjetoAnonimo.metodo1() // Imprime "Implementación de método 1"
    miObjetoAnonimo.metodo2() // Imprime "Implementación de método 2"

    // Companion Object

    MiClase.companionProp1 = 6
    MiClase.companionFun()

    val clase1 = MiClase()
    val clase2 = MiClase()

    println("Valor de companionProp1: ${clase2.getCompanionObject().companionProp1}") // Imprime: Valor de companionProp1: 6

    clase1.getCompanionObject().companionProp1 = 10

    println("Valor de companionProp1: ${clase2.getCompanionObject().companionProp1}") // Imprime: Valor de companionProp1: 10
}

interface MiInterfaz {
    fun metodo1()
    fun metodo2()
}

object MiObjetoSingleton {
    val nombre: String = "Singleton"

    fun imprimirMensaje() {
        println("Hola desde el objeto $nombre")
    }
}

class MiClase {
    val edad: Int = 24
    val nombre: String = "Algo"
    val direccion: String = "Nowhere"

    fun getCompanionObject() = Companion

    companion object {
        var companionProp1 = 5

        fun companionFun() {
            println("Ejecutando companionFun()")
        }
    }

}




