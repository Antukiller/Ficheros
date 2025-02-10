package antoine.lopez.models

import java.time.LocalDate
import java.time.LocalDateTime

data class Alumno(
    val id: Int,
    val nombre: String,
    val createAt: LocalDate  = LocalDate.now(),
    val tipo: Tipo,
    val edad: Int
) {
    enum class Tipo {
        Excepcional,
        Apoyo,
        Participativo,
        Rebelde,
        Nuevo,
        Distancia,
        Internacional,
    }
}
