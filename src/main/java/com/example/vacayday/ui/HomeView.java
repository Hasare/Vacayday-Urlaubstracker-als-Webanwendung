package com.example.vacayday.ui;

import com.example.vacayday.backend.entity.Vacation;
import com.example.vacayday.backend.service.VacationService;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import org.vaadin.crudui.crud.impl.GridCrud;


@PageTitle("Home")
public class HomeView extends VerticalLayout {

    public HomeView(VacationService service) {
        setSpacing(false);
        var vacationCrud = new GridCrud<>(Vacation.class, service);
        vacationCrud.getGrid().setColumns("vorname", "nachname", "startdatum", "enddatum");
        vacationCrud.getCrudFormFactory().setVisibleProperties("vorname", "nachname", "startdatum", "enddatum");


        add(
                vacationCrud
        );
    }

}
