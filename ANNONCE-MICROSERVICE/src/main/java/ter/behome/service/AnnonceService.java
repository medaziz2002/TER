package ter.behome.service;

import ter.behome.Repository.AnnonceRepository;
import ter.behome.entities.Annonce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service


public class AnnonceService {
    private AnnonceRepository annonceRepository;

    @Autowired
    public AnnonceService(AnnonceRepository annonceRepository) {
        this.annonceRepository = annonceRepository;
    }

    public Annonce addAnnonce(Annonce annonce) {

        return annonceRepository.save(annonce);
    }

    public List<Annonce> findAllAnnonce() {
        return annonceRepository.findAll();
    }

    public Annonce updateAnnonce(Annonce annonce) {
        return annonceRepository.save(annonce);
    }


    public Annonce findAnnonceById(BigInteger id) {
        return annonceRepository.findAnnonceById(id);
    }
    public void deleteAnnonce(BigInteger id){
        annonceRepository.deleteAnnonceById(id);
    }

}



