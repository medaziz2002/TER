package ter.behome.service;

import ter.behome.entity.Annonce;
import ter.behome.entity.Categorie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="ANNONCE-SERVICE")
public interface AnnonceService {
    @PostMapping("/annonces/add")
    public Annonce addAnnonceC(@RequestBody Annonce annonce) ;
    @GetMapping("/categories/find/{id}")
    public Categorie getCategorieById (@PathVariable String id) ;

}
