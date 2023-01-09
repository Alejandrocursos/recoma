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
import recoma.wealmeat.business.IRecetaBusiness
import recoma.wealmeat.exceptions.BusinessException
import recoma.wealmeat.exceptions.NotFoundException
import recoma.wealmeat.model.Receta
import recoma.wealmeat.utils.Constants

@RestController
@RequestMapping(Constants.URL_BASE_RECETAS)
class RecetaRestController {

    @Autowired
    val recetaBusiness: IRecetaBusiness? = null

    @GetMapping()
    fun list(): ResponseEntity<List<Receta>>{
        return try {
            ResponseEntity(recetaBusiness!!.list(), HttpStatus.OK)
        }catch (e:Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/{id}")
    fun load(@PathVariable("id")idReceta:Long):ResponseEntity<Receta>{
        return try {
            ResponseEntity(recetaBusiness!!.load(idReceta), HttpStatus.OK)
        }catch (e:BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }catch (e:NotFoundException){
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping()
    fun insert(@RequestBody receta: Receta): ResponseEntity<Any>{
        return try {
            recetaBusiness!!.save(receta)
            val responseHeader = HttpHeaders()
            responseHeader.set("location", Constants.URL_BASE_RECETAS + "/" + receta.id)
            ResponseEntity(responseHeader,HttpStatus.CREATED)
        }catch (e: BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PutMapping("")
    fun update(@RequestBody receta: Receta):ResponseEntity<Any>{
        return try{
            recetaBusiness!!.save(receta)
            ResponseEntity(HttpStatus.OK)
        }catch (e: BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") idReceta: Long): ResponseEntity<Any>{
        return try{
            recetaBusiness!!.remove(idReceta)
            ResponseEntity(HttpStatus.OK)
        }catch (e: BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
        catch (e: NotFoundException){
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }


}