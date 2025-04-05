package ter.behome.service;

import ter.behome.Repository.CategorieRepository;
import ter.behome.entities.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService {
    @Autowired
    CategorieRepository categorieRepository;
    public List<Categorie> findAllCategories(){
        return categorieRepository.findAll();
    }
    public Categorie findCategorieById(String id) {
        return categorieRepository.findById(id).get();
    }


}
