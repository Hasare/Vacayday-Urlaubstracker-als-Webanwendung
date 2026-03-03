package com.example.vacayday.backend.service;


import com.example.vacayday.backend.entity.Role;
import com.example.vacayday.backend.entity.User;
import com.example.vacayday.ui.HomeView;
import com.example.vacayday.ui.LogoutView;
import com.example.vacayday.ui.MainView;
import com.example.vacayday.ui.RegisterView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.router.RouteConfiguration;
import com.vaadin.flow.server.VaadinSession;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthService {

    public record AuthorizedRoute(String route, String name, Class<? extends Component> view) {
    }

    public class AuthException extends Exception {
    }

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void authenticate(String username, String password) throws AuthException {

        User user = userRepository.getByUsername(username);

        if (user == null || !user.checkPassword(password)) {
            throw new AuthException();
        }

        VaadinSession.getCurrent().setAttribute(User.class, user);
        createRoutes(user.getRole());
    }

    private void createRoutes(Role role) {
        getAuthorizedRoutes(role).stream()
                .forEach(route ->
                        RouteConfiguration.forSessionScope().setRoute(
                                route.route, route.view, MainView.class));
    }

    public List<AuthorizedRoute> getAuthorizedRoutes(Role role) {
        var routes = new ArrayList<AuthorizedRoute>();

        if (role.equals(Role.USER)) {
            routes.add(new AuthorizedRoute("home", "Home", HomeView.class));
            routes.add(new AuthorizedRoute("logout", "Logout", LogoutView.class));
        } else if (role.equals(Role.ADMIN)) {
            routes.add(new AuthorizedRoute("home", "Home", HomeView.class));
            routes.add(new AuthorizedRoute("register", "Register", RegisterView.class));
            routes.add(new AuthorizedRoute("logout", "Logout", LogoutView.class));
        }
        return routes;
    }
}

