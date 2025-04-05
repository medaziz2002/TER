package ter.behome.service;

import lombok.extern.slf4j.Slf4j;
import ter.behome.entity.Immobilier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

@Slf4j
@Service
public class ContratService {


    private ArrayList<Immobilier> immobiliers = new ArrayList<>();


    public void sellImmobilier(String _name, String _description, String _localisation, BigDecimal _priceInUSD, BigInteger _surface) {
        Immobilier newImmobilier = new Immobilier();
        newImmobilier.setName(_name);
        newImmobilier.setDescription(_description);
        newImmobilier.setLocalisation(_localisation);
        newImmobilier.setPrice(_priceInUSD);
        newImmobilier.setSurface(_surface);
        newImmobilier.setOwnerAddress("OWNER_ADDRESS");
        newImmobilier.setBuyerAddress(null);
        newImmobilier.setId(BigInteger.valueOf(immobiliers.size() + 1));
        immobiliers.add(newImmobilier);
        log.info("New immobilier added: " + _name);
    }

    // Get Immobilier by ID
    public Immobilier getImmobilier(long id) {
        for (Immobilier imm : immobiliers) {
            if (imm.getId().equals(id)) {
                return imm;
            }
        }
        return null; // Not found
    }


    public ArrayList<Immobilier> getAllImmobilier() {
        return immobiliers;
    }


    public void buyImmobilier(long id) {
        Immobilier imm = getImmobilier(id);
        if (imm != null) {

            imm.setOwnerAddress("SOLD");  // Mark as sold
            log.info("Immobilier with ID " + id );
        } else {
            log.error("Immobilier with ID " + id + " not found.");
        }
    }


    public void transferMoney(String buyerAddress, String sellerAddress, BigDecimal amountInUSD) {
        log.info("Transferred " + amountInUSD + " USD from " + buyerAddress + " to " + sellerAddress);

    }



// In your service class, ContratService
public int getNombreImmobilier() {
    return immobiliers.size(); // Or if you use a DB, a simple repository query would do
}
}