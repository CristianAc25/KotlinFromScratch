import kotlinx.coroutines.*

fun log(message: String) {
    println("[${Thread.currentThread().name}] : $message")
}

fun main() {
    log("Start")

    runBlocking {

        log("RunBlocking start")

        var parentScopeIsActive = false

        val parentJob = launch (Dispatchers.Default) {
            log("Parent Job start")
            parentScopeIsActive = true

            val childJob = launch (Job()) { //Comentar esta linea
            //val childJob = launch { //Descomentar esta linea
                log("Child Job start")
                repeat(10) {
                    delay(500)
                    val suf = if(parentScopeIsActive) "Esta bien!, esto deberia permanecer activo." else "Ups!, esto no deberia estar corriendo."
                    log("Child Job: Imaginate que esto es una larga y costosa tarea. $suf")
                }
                log("Child Job end")
            }

            log("Parent Job: esperando a que child Job se complete.")
            childJob.join()
            log("Parent Job: dejar de esperar por child Job.")

            log("Parent Job end")
        }

        launch {
            delay(1500)
            log("Launch: cancelando parent Job")
            parentJob.cancel()
            parentScopeIsActive = false
            log("Launch: Parent Job CANCELADO!!!")
        }

        log("RunBlocking: esperando a que parent Job se complete.")
        parentJob.join()
        log("RunBlocking: dejar de esperar por parent Job.")

        log("RunBlocking: antes del delay de 5 segundos")
        delay(5000)

        log("RunBlocking end")
    }

    log("End")
}