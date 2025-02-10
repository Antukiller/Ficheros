package antoine.lopez

import antoine.lopez.dto.AlumnoDto
import antoine.lopez.mappers.toModel
import java.io.File

fun main() {
    println("Hola CSV")
    val file = File("data", "alumnos.csv")
    if (file.exists() && file.isFile && file.canRead()) {
        println("El fichero existe")
    } else {
        throw IllegalArgumentException("Fichero no existe o no se puede leer")
    }


    val estudinates = file.readLines().drop(1)
        .map { linea -> linea.split(",") }
        .map { item ->
            println(item)
            AlumnoDto(
                id = item[0].trim().toInt(),
                nombre = item[1],
                createAt = item[2],
                tipo = item[4],
                edad = item[5].toInt()
            ).toModel()
        }



    estudinates.forEach { println(it) }

    // Alumno más mayor
    val maxEdadEstudiante = estudinates.filter { it.edad > 0 }.maxOf { it.edad }
    println("Max Edad: $maxEdadEstudiante")
    // Alumno más joven
    val minEdadEstudiante = estudinates.filter { it.edad > 0 }.minOf { it.edad }
    println("Min Edad: $minEdadEstudiante")
    // Media de edad de alumnos
    val mediaEdadEstudiante = estudinates.filter { it.edad > 0  }.map { it.edad }.average()
    println("Media Edad: $mediaEdadEstudiante")
    // Media de longitud de nombre
    val mediaLongitudNombre = estudinates.map { it.nombre.length }.average()
    println("Media Longitud: $mediaLongitudNombre")
    // Listado de agrupados por edad
    val grupoPorEdad = estudinates.groupBy { it.edad }
    // Agrupados por edad, numero de alumnos
    val estudianteEdadNumero = estudinates.groupingBy { it.edad }.eachCount()
    // Agrupados por edad, obtener la longitud de nombre.
    // Agrupados por edad, obtener el nombre mas largo.





}