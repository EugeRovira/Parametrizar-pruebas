package com.tatf.pages;

import com.tatf.core.browser.IBrowser;

public class ReiniciarContraseñaPage {
    private IBrowser browser;
    private String enlaceReinicioSelector = ".card.border-left-danger";
    private String correoSelector = "input[name=inputEmail]";
    private String passwordSelector = "input[name=inputPassword]";
    private String repetirPasswordSelector = "input[name=inputRepeatPassword]";
    private String botonReinicioSelector = "btnReset";


    public ReiniciarContraseñaPage(IBrowser browser) {
        this.browser = browser;
    }

    public void accederReinicioContraseña(){
        browser.find().css(enlaceReinicioSelector).click();
    }

    public void formReinicioContraseña(String Correo, String Password, String repetirPassword) {
        browser.find().css(correoSelector).write(Correo);
        browser.find().css(passwordSelector).write(Password);
        browser.find().css(repetirPasswordSelector).write(repetirPassword);
    }

    public void finalizarReinicio() {
        browser.find().id(botonReinicioSelector).click();
    }
}