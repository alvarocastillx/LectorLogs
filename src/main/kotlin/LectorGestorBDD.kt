import java.io.File
import java.time.LocalDateTime
import kotlin.math.log
var logsseparados = mutableListOf<String>()

class LectorGestorBDD {
    var logs = ""

    //estadisticas//
    var contEmpleadosRecuperados = 0
    var contEmpleadosAgregados = 0
    var contEmpleadosEliminados = 0
    var contEmpleadosModificados = 0


    val archivo =
        File("C:\\Users\\AlvaroPC\\IdeaProjects\\SQL\\PersistenciaConSQL\\FacturaciónSql\\ModeloVistaControlador1tabla\\logs\\gestorlog.txt").readLines()
            .toMutableList()
    fun leerLogBDD() {
        val iterador = archivo.iterator()
        while (iterador.hasNext()) {
            val i = iterador.next()
            logs += "$i\n"
            iterador.remove()
        }
        logsseparados = logs.split("\n").toMutableList()
        logsseparados.removeAt(logsseparados.size - 1)
    }


    fun analizarLogs() {
            for (i in logsseparados) {
                val logactual = i.split("->").toMutableList()
                logactual.removeAt(0)
                catalogarLog(logactual)
            }

    }

    fun catalogarLog(logactual: MutableList<String>) {
        var logseparado = (logactual[0].split(" "))
        if (logseparado[2]=="recuperados"){
            contEmpleadosRecuperados++
            println("Se han recuperado empleados $contEmpleadosRecuperados vez/veces")
        }
        if (logseparado[2]=="agregado:"){
            contEmpleadosAgregados++
            println("Se han agregado empleados $contEmpleadosAgregados vez/veces")
        }
        if (logseparado[2]=="modificado:"){
            contEmpleadosModificados++
            println("Se han modificado empleados $contEmpleadosModificados vez/veces")
        }
        if (logseparado[2]=="eliminado"){
            contEmpleadosEliminados++
            println("Se han eliminado empleados $contEmpleadosEliminados vez/veces")
        }
    }
    fun imprimirEstadisticasFinales() {
        println("Datos recuperados de tablas: $contEmpleadosRecuperados vez/veces")
        println("Empleados agregados: $contEmpleadosAgregados")
        println("Empleados modificados: $contEmpleadosModificados")
        println("Empleados eliminados: $contEmpleadosEliminados")

    }
}