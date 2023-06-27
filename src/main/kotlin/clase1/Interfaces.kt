package clase1

interface Animal {
    val nombre: String

    fun hacerSonido() {
        println("GGjjjjsdfsjfjsdfa")
    }

    fun comer()
}

class Gato : Animal {
    override val nombre: String = "Napoleon"

    override fun hacerSonido() {
        println("Miau Miau!")
    }

    override fun comer() {
        println("El gato está comiendo.")
    }

    fun ronronear() {
        println("El gato está ronroneando.")
    }
}

abstract class Canino {
    abstract fun perderPelo()
}

class Perro : Canino(), Animal { // Extension + Implementacion de interfaz
    override val nombre: String = "Fideo"

    override fun hacerSonido() {
        println("Guau Guau!")
    }

    override fun comer() {
        println("El perro está comiendo.")
    }

    override fun perderPelo() {
        println("Pierde pelo en el sillon.")
    }
}

fun main() {
    val perro = Perro()
    val gato = Gato()

    perro.hacerSonido() // Salida: Guau Guau!
    perro.comer() // Salida: El perro está comiendo.

    gato.hacerSonido() // Salida: Miau Miau!
    gato.comer() // Salida: El gato está comiendo.

    val animal: Animal = Gato()

    if (animal is Gato) {
        animal.ronronear() // Smart-cast!!!!
    }
}





