package com.tatf.pages;

import com.tatf.core.browser.IBrowser;

public class EliminarTesterPage {
    private IBrowser browser;
    private String enlaceVerUsuarios = "a.nav-link[href='/adminces/view-users']";

    public EliminarTesterPage(IBrowser browser) {
        this.browser = browser;
    }

    public void accederVerUsuarios() {
        browser.wait(enlaceVerUsuarios).css();
        browser.find().css(enlaceVerUsuarios).click();
    }

    public void seleccionarTester(String Correo) {
        browser.find().id(Correo).click();
    }
}
