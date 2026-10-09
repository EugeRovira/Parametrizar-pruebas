package com.tatf.pages;

import com.tatf.core.browser.IBrowser;

public class CrearTesterPage {
    private IBrowser browser;
    private String enlaceCrearTesterSelector = "a#cardLogin[href='/adminces/create-user']";
    private String nombreSelector = "input[name=inputFirstName]";
    private String apellidoSelector = "input[name=inputLastName]";
    private String correoSelector = "input[name=inputEmail]";
    private String paisSelector = "select[name='inputCountry']";
    private String passwordSelector = "input[name=inputPassword]";
    private String juniorSelector = "label[for='testerJunior']";
    private String seniorSelector = "label[for='testerSenior']";
    private String liderSelector = "label[for='testerLead']";
    private String botonRegistroSelector = "btnRegister";


    public CrearTesterPage(IBrowser browser) {
        this.browser = browser;
    }

    public void accederCrearTester() {
        browser.find().css(enlaceCrearTesterSelector).click();
    }

    public void formularioTester(String Nombre, String Apellido,
                                 String Correo, String Pais, String Contraseña) {
        browser.find().css(nombreSelector).write(Nombre);
        browser.find().css(apellidoSelector).write(Apellido);
        browser.find().css(correoSelector).write(Correo);
        browser.find().css(paisSelector).selectValue(Pais);
        browser.find().css(passwordSelector).write(Contraseña);

    }

    public void elegirTipoTester(String tipoTester) {
        switch (tipoTester) {
            case "Junior":
                browser.find().css(juniorSelector).click();
                break;

            case "Senior":
                browser.find().css(seniorSelector).click();
                break;

            case "Líder":
                browser.find().css(liderSelector).click();
                break;
        }
    }

    public void enviarForm() {
        browser.find().id(botonRegistroSelector).click();
    }
}
