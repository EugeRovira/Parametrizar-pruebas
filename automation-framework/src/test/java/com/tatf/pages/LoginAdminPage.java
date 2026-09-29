package com.tatf.pages;

import com.tatf.core.browser.IBrowser;

public class LoginAdminPage {
    private IBrowser browser;


    public LoginAdminPage(IBrowser browser) {
        this.browser = browser;
    }

    public void iniciarSesion(String Correo, String Password) {
        browser.find().css("input[name=inputEmail]").write(Correo);
        browser.find().css("input[name=inputPassword]").write(Password);
        browser.find().css("button.btn-orange-ces.rounded-end-pill").click();
    }
}
