package ter.behome.controller;

import ter.behome.entity.*;
import ter.behome.service.AnnonceService;
import ter.behome.service.ContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/contrat")
@EnableFeignClients
public class ContratController {

    @Autowired
    ContratService cs;
    @Autowired
    AnnonceService as;

    // To Add a property using request body
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/sellArticleee/{id}")
    public ResponseEntity<AnnonceKey> sellArticleee(@RequestBody AnnonceKey annonceKey, @PathVariable String id) {
        Categorie cat = as.getCategorieById(id);
        try {
            int i = cs.getNombreImmobilier() + 1;
            cs.sellImmobilier(
                    annonceKey.getImmobilier().getName(),
                    annonceKey.getImmobilier().getDescription(),
                    annonceKey.getImmobilier().getLocalisation(),
                    annonceKey.getImmobilier().getPrice(),
                    annonceKey.getImmobilier().getSurface()
            );

            Annonce annonce = new Annonce(null, BigInteger.valueOf(i), annonceKey.getImmobilier().getName(), new Date(),
                    annonceKey.getUrl(), annonceKey.getImmobilier().getDescription(),
                    annonceKey.getImmobilier().getPrice().doubleValue(), cat);
            as.addAnnonceC(annonce);
            System.out.println("Article posted " + annonceKey.getImmobilier().getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(annonceKey, HttpStatus.CREATED);
    }

    // Get a property by its ID
    @GetMapping("/getarticleee/{id}")
    public Immobilier getArticleee(@PathVariable long id) {
        return cs.getImmobilier(id);
    }

    @PostMapping("/buyarticle/{id}")
    public ResponseEntity<String> buyArticle(@PathVariable long id, @RequestBody String buyerId) {
        try {
            Immobilier imm = cs.getImmobilier(id);
            cs.buyImmobilier(id);
            cs.transferMoney(buyerId, imm.getOwnerAddress(), imm.getPrice());

            System.out.println("Article bought");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(buyerId, HttpStatus.CREATED);
    }


    // Get the number of properties
    @GetMapping("/getnumarticle")
    public int getNumArticle() {
        try {
            return cs.getNombreImmobilier();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    // Get all properties
    @GetMapping("/getAllImmobilier")
    public ArrayList<Immobilier> getAllImmobilier() {
        return cs.getAllImmobilier();
    }
}
