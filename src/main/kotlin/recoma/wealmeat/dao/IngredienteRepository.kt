package recoma.wealmeat.dao

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import recoma.wealmeat.model.Ingrediente

@Repository
interface IngredienteRepository: JpaRepository<Ingrediente,Long> {

}