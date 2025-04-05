package ter.behome.Repository;

import ter.behome.entities.Categorie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource

public interface CategorieRepository extends MongoRepository<Categorie,String> {
}
