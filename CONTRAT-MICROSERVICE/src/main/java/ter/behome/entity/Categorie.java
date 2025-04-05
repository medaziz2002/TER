package ter.behome.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categorie {

    private String id;
    private String nom_cat;
    private List<Annonce> annonces = new ArrayList<>();
}
