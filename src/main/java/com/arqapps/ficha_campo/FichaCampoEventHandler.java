package com.arqapps.ficha_campo;

import com.arqapps.user.User;
import com.arqapps.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler(FichaCampo.class)
public class FichaCampoEventHandler {
    private final UserRepository users;

    @Autowired
    public FichaCampoEventHandler(UserRepository users) {
        this.users = users;
    }

    @HandleBeforeCreate
    public void addFichaBasedOnLoggedInUser(FichaCampo fichaCampo) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = users.findByUsername(username);
        fichaCampo.setUser(user);
    }
}
