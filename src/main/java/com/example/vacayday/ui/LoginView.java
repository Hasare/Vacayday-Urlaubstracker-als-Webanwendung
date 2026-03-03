package com.example.vacayday.ui;

import com.example.vacayday.backend.service.AuthService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("login")
@PageTitle("Login")
@CssImport("./styles/login-view.css")
public class LoginView extends Div {

    private final H1 loginTitle;
    private final Div message = messageDiv();
    private String user;
    private String password;

    private Div messageDiv() {
        Div message = new Div();
        add(message);
        message.getStyle().set("whiteSpace", "pre");
        return message;
    }

    public LoginView(AuthService authService) {
        setId("login-view");

        loginTitle = new H1("Vacayday Login");
        loginTitle.setId("loginTitle");

        TextField userfield = new TextField("Anmeldename");
        userfield.setWidth("300px");
        PasswordField passfield = new PasswordField("Passwort");
        passfield.setWidth("300px");

        Button button = new Button("Log in");
        button.setWidth("300px");
        button.addClassName("button1");
        button.addClickListener(event -> {

            user = userfield.getValue();
            password = passfield.getValue();

            if (user.isEmpty() || password.isEmpty()) {
                message.setText("Anmeldename oder Passwort kann nicht leer sein!");
                add(message);
            } else {

                try {
                    authService.authenticate(user, password);
                    UI.getCurrent().navigate("home");
                } catch (Exception ignored) {
                    message.setText("Deine Anmeldename oder Passwort ist falsch!");
                    add(message);
                }
            }
        });
        add(
                loginTitle,
                userfield,
                passfield,
                button
        );
    }
}
