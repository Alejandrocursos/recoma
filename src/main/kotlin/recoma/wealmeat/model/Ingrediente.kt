package recoma.wealmeat.model

import jakarta.persistence.*

@Entity
@Table(name = "Ingrediente")
data class Ingrediente (val nombre:String = "") {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id:Long= 0

}