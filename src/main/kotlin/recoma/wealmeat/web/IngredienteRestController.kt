package recoma.wealmeat.web

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import recoma.wealmeat.business.IIngredienteBusiness
import recoma.wealmeat.exceptions.BusinessException
import recoma.wealmeat.exceptions.NotFoundException
import recoma.wealmeat.model.Ingrediente
import recoma.wealmeat.utils.Constants

@RestController
@RequestMapping(Constants.URL_BASE_INGREDIENTES)
class IngredienteRestController {

    @Autowired
    val ingredienteBusiness: IIngredienteBusiness? = null

    @GetMapping()
    fun list(): ResponseEntity<List<Ingrediente>>{
        return try {
            ResponseEntity(ingredienteBusiness!!.list(), HttpStatus.OK)
        }catch (e:Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/{id}")
    fun load(@PathVariable("id")idIngrediente:Long):ResponseEntity<Ingrediente>{
        return try {
            ResponseEntity(ingredienteBusiness!!.load(idIngrediente), HttpStatus.OK)
        }catch (e:BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }catch (e:NotFoundException){
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping()
    fun insert(@RequestBody ingrediente: Ingrediente): ResponseEntity<Any>{
        return try {
            ingredienteBusiness!!.save(ingrediente)
            val responseHeader = HttpHeaders()
            responseHeader.set("location", Constants.URL_BASE_INGREDIENTES + "/" + ingrediente.id)
            ResponseEntity(responseHeader,HttpStatus.CREATED)
        }catch (e: BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PutMapping("")
    fun update(@RequestBody ingrediente: Ingrediente):ResponseEntity<Any>{
        return try{
            ingredienteBusiness!!.save(ingrediente)
            ResponseEntity(HttpStatus.OK)
        }catch (e: BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") idIngrediente: Long): ResponseEntity<Any>{
        return try{
            ingredienteBusiness!!.remove(idIngrediente)
            ResponseEntity(HttpStatus.OK)
        }catch (e: BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
        catch (e: NotFoundException){
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }


}