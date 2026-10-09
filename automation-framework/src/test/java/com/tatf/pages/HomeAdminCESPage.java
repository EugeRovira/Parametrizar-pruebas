package com.tatf.pages;

import com.tatf.core.browser.IBrowser;

public class HomeAdminCESPage {
    private IBrowser browser;
    private String passwordSelector = "input[type='password']";
    private String botonIngresarSelector = "button[type='submit']";
    private String enlaceRegistroSelector = "Registrarse";
    private String menuDesplegableSelector = "a.dropdown-toggle";
    private String enlaceLoginSelector = ".dropdown-menu a[href='/adminces/login']";
    private String urlAdminCES = "http://cestore.ces.com.uy/adminces/";

    public HomeAdminCESPage(IBrowser browser) {
        this.browser = browser;
    }

        public void accederAdminCES(String Password) {
            browser.interaction().navigateTo(urlAdminCES);
            browser.find().css(passwordSelector).write(Password);
            browser.find().css(botonIngresarSelector).click();

        }
        public void accederRegistro() {
            browser.find().link(enlaceRegistroSelector).click();
        }

        public void accederLogin() {
            browser.find().css(menuDesplegableSelector).click();
            browser.find().css(enlaceLoginSelector).click();
        }
}
