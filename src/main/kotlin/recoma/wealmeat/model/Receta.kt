package recoma.wealmeat.model

import jakarta.persistence.*

@Entity
@Table(name = "Receta")
data class Receta(
    val nombreReceta: String,
    val tipoDieta: String = "",
    val nIngredientes: Number,
    val nRaciones: Number,
    val kcal: Number,
    val categoria: String ="",
    val guia: String
) {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

}