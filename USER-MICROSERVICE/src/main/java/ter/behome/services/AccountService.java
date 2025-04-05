package ter.behome.services;

import ter.behome.entities.AppRole;
import ter.behome.entities.AppUser;


public interface AccountService {

    //inscrire un joueur
    public AppUser saveUser(String username, String email, String adress, String password, String confirmedPassword);
    //Ajouter des roles
    public AppRole save(AppRole role);

    public AppUser loadUserByUsername(String username);

    public void addRoleToUser(String username, String roleName);

}
