package com.example.vacayday.ui;


import com.example.vacayday.backend.entity.User;
import com.example.vacayday.backend.service.UserService;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.router.PageTitle;
import org.vaadin.crudui.crud.impl.GridCrud;


@PageTitle("Register")
public class RegisterView extends VerticalLayout {

    public RegisterView(UserService service) {
        setSpacing(false);

        var userCrud = new GridCrud<>(User.class, service);
        userCrud.getCrudFormFactory().setFieldType("password", PasswordField.class);
        userCrud.getGrid().setColumns("vorname", "nachname", "username", "role");
        userCrud.getCrudFormFactory().setVisibleProperties("vorname", "nachname", "username", "password", "role");

        add(
                userCrud
        );
    }


}
