package com.tatf.pages;

import com.tatf.core.browser.IBrowser;

public class LoginAdminPage {
    private IBrowser browser;
    private String correoSelector = "input[name=inputEmail]";
    private String passwordSelector = "input[name=inputPassword]";
    private String botonLoginSelector = "button.btn-orange-ces.rounded-end-pill";


    public LoginAdminPage(IBrowser browser) {
        this.browser = browser;
    }

    public void iniciarSesion(String Correo, String Password) {
        browser.find().css(correoSelector).write(Correo);
        browser.find().css(passwordSelector).write(Password);
        browser.find().css(botonLoginSelector).click();
    }
}
