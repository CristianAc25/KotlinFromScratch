package clase1

data class Empleado(val nombre: String, val edad:Int)

fun main() {

    val emp = Empleado("Michael Scott", 45)
    // Metodo toString() mas legible
    println(emp)

    // Desestructuracion de clase en accion
    val (name, age) = emp

    println("Valor name desestructurado: $name")
    println("Valor age desestructurado: $age")

    // copy() en accion
    val dwight = emp.copy(nombre = "Dwight") // Crea una instancia reflejo de la original reemplazando solo los
    // valores pasados por parametro
    println(dwight)
}