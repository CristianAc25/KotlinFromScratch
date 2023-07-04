package clase2

class Empleado {
    var nombre: String = ""
    var apellido: String = ""
    var rol: String = ""
    var edad: Int = 0
}

fun main() {
    // Inicializar una entidad de forma tradicional
    val michael = Empleado()
    michael.nombre = "Michael"
    michael.apellido = "Scott"
    michael.rol = "Gerente Regional"
    michael.edad = 40

    // Ejemplo funcion apply:
    val emp = Empleado().apply {
        nombre = "Michael"
        apellido = "Scott"
        rol = "Gerente Regional"
        edad = 40
    }

    // Ejemplo funcion let:
    val cadena: String? = "Juan"

    val resultado = cadena?.let {
        val mayusculas = it.uppercase()
        "Hola ${mayusculas.reversed()}" // El resultado se asigna a la variable resultado
    }

    println(resultado)

    // Ejemplo funcion run:
    val service = MultiportService("", 80)

    val result = service.run {
        url = "https://example.kotlinlang.org"
        port = 8080
        query(prepareRequest() + " to port $port")
    }

    // Ejemplo funcion with:
    val numeros = mutableListOf("uno", "dos", "tres")
    with(numeros) {
        println("'with' fue llamado con los argumentos $this")
        println("Contiene $size elementos")
    }

    // Ejemplo funcion also:
        // Operaciones que no afecten al objeto contexto
        val lista = mutableListOf<String>()
            .also { println("Creando lista") }
            .apply {
                add("Elemento 1")
                add("Elemento 2")
            }
            .also { println("Lista creada: $it") }

        // Operaciones de validacion
        class Token {
            fun isValid(): Boolean = true // Logica super complicada para validar tokens
        }
        class TokenFactory {
            fun getToken(): Token = Token() // Logica super complicada para generar tokens
        }

        val factory = TokenFactory()
        val token = factory.getToken().also { key ->
            if (key.isValid()) {
                println("El objeto es válido")
            } else {
                println("El objeto no es válido")
            }
        }

        println(token) // Imprime el Token
}

class MultiportService(var url: String, var port: Int) {
    fun prepareRequest(): String = "Default request"
    fun query(request: String): String = "Result for query '$request'"
}




