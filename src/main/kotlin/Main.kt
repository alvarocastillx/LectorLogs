
//cd C:\Users\AlvaroPC\IdeaProjects\SQL\PersistenciaConSQL\FacturaciónSql\LectorLogs\LectorLogs\out\artifacts\LectorLogs_jar
//java -jar LectorLogs.jar

fun main(args: Array<String>) {
    var menu = true
    while (menu) {
        var lector = LectorGestorBDD()
        lector.leerLogBDD()
        lector.analizarLogs()
        println("\nPulse cualquier botón para cargar de nuevo. Pulse 0 para salir.")
        var botonPulsado = readln()
        if (botonPulsado == "0") {
            lector.imprimirEstadisticasFinales()
            menu = false
        }
        }






}
