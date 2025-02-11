package antoine.lopez.mappers

import antoine.lopez.dto.AlumnoDto
import antoine.lopez.models.Alumno
import java.time.LocalDate


fun Alumno.toDto() = AlumnoDto(
    id = id,
    nombre = nombre,
    createAt = createAt.toString(),
    tipo = tipo.name,
    edad = edad
)

fun AlumnoDto.toModel() = Alumno(
    id = id,
    nombre = nombre,
    createAt = LocalDate.parse(createAt),
    tipo = Alumno.Tipo.values().random(),
    edad = edad
)