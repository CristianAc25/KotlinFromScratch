package clase1

data class Planta(val nombre: String, val altura: Int) { // Constructor primario
    var especie: String = ""

    constructor(nombre: String, altura: Int, especie: String) : this(nombre, altura) { // Constructor secundario
        this.especie = especie
    }

    fun processResult(result: Result) {
        when (result) {
            is Result.Success -> println(result.data)
            is Result.Loading -> println("Loading ...")
            is Result.Error -> println(result.mensaje)
        }
    }
}

fun main() {
    val planta = Planta("Geranio", 20)
    println("${planta.nombre} tiene ${planta.altura}cm de altura")

    val planta2: Planta? = Planta("Santa Rita", 35, "Trepadora")

    // Uso de null-safety
    val valorString: String = planta2?.nombre ?: "Una alternativa ..." ?: "Una segunda alternativa ..."

    println(planta2) // Planta es una data class, esto imprime: "Planta(nombre=Santa Rita, altura=35)"

    planta2?.processResult(Result.Success("Success"))
    planta2?.processResult(Result.Error("Error"))
    planta2?.processResult(Result.Loading)
}

// Sealed Class
sealed class Result { // Nos impone el uso exhaustivo de sus clases hijas donde sea que lo usemos
    class Success(val data: String) : Result()
    object Loading : Result()
    class Error(val mensaje: String) : Result()
    // class Idle() : Result()
}