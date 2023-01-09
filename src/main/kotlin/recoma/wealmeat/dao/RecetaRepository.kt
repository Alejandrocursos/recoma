package recoma.wealmeat.dao

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import recoma.wealmeat.model.Receta

@Repository
interface RecetaRepository: JpaRepository<Receta,Long> {

}