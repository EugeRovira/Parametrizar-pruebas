package com.tatf.pages;

import com.tatf.core.browser.IBrowser;

public class ReiniciarContraseñaPage {
    private IBrowser browser;


    public ReiniciarContraseñaPage(IBrowser browser) {
        this.browser = browser;
    }

    public void accederReinicioContraseña(){
        browser.find().css(".card.border-left-danger").click();
    }

    public void formReinicioContraseña(String Correo, String Password, String repetirPassword) {
        browser.find().css("input[name=inputEmail]").write(Correo);
        browser.find().css("input[name=inputPassword]").write(Password);
        browser.find().css("input[name=inputRepeatPassword]").write(repetirPassword);
    }

    public void finalizarReinicio() {
        browser.find().id("btnReset").click();
    }
}