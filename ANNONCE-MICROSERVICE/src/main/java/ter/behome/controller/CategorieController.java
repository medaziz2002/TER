package ter.behome.controller;

import ter.behome.Repository.AnnonceRepository;
import ter.behome.Repository.CategorieRepository;
import ter.behome.entities.Categorie;
import ter.behome.service.AnnonceService;
import ter.behome.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/categories")
public class CategorieController {

    @Autowired
    CategorieRepository categorieRepository;
    @Autowired
    AnnonceRepository annonceRepository;
    @Autowired
    AnnonceService annonceService;
    @Autowired
    CategorieService categorieService;



    @GetMapping ("/all")
    public ResponseEntity<List<Categorie>> getAllCategories () {
        List<Categorie> categories = categorieService.findAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public Categorie getCategorieById(@PathVariable String id){
        return categorieService.findCategorieById(id);
    }


}
