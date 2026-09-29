package com.tatf.pages;
import com.tatf.core.browser.IBrowser;

public class RegistroAdminPage {
    private IBrowser browser;


    public RegistroAdminPage(IBrowser browser) {
        this.browser = browser;
    }

    public void FormularioAdmin(String Nombre, String Apellido,
                                String Correo, String Password, String repetirPassword, String Pais) {
        browser.find().css("input[name=inputFirstName]").write(Nombre);
        browser.find().css("input[name=inputLastName]").write(Apellido);
        browser.find().css("input[name=inputEmail]").write(Correo);
        browser.find().css("input[name=inputPassword]").write(Password);
        browser.find().css("input[name=inputRepeatPassword]").write(repetirPassword);
        browser.find().css("input[name=inputCountry]").write(Pais);
    }

    public void enviarForm() {
        browser.find().id("btnRegister").click();
    }
}

