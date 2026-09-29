package com.tatf.pages;

import com.tatf.core.browser.IBrowser;

public class CrearTesterPage {
    private IBrowser browser;


    public CrearTesterPage(IBrowser browser) {
        this.browser = browser;
    }

    public void accederCrearTester() {
        browser.find().css("a#cardLogin[href='/adminces/create-user']").click();
    }

    public void formularioTester(String Nombre, String Apellido,
                                 String Correo, String Pais, String Contraseña) {
        browser.find().css("input[name=inputFirstName]").write(Nombre);
        browser.find().css("input[name=inputLastName]").write(Apellido);
        browser.find().css("input[name=inputEmail]").write(Correo);
        browser.find().css("select[name='inputCountry']").selectValue(Pais);
        browser.find().css("input[name=inputPassword]").write(Contraseña);

    }

    public void elegirTipoTester(String tipoTester) {
        switch (tipoTester) {
            case "Junior":
                browser.find().css("label[for='testerJunior']").click();
                break;

            case "Senior":
                browser.find().css("label[for='testerSenior']").click();
                break;

            case "Líder":
                browser.find().css("label[for='testerLead']").click();
                break;
        }
    }

    public void enviarForm() {
        browser.find().id("btnRegister").click();
    }
}
