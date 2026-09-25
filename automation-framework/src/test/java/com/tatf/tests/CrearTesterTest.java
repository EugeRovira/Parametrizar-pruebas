package com.tatf.tests;

import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CrearTesterTest {
    private static IBrowser browser;

    @BeforeAll
    static void beforeAll() {
        browser = BrowserFactory.getBrowser(true);
    }

    @AfterAll
    static void afterAll() {
             BrowserFactory.quitBrowser();
    }

    @Test
    void CrearTester() {
        browser.interaction().navigateTo("http://cestore.ces.com.uy/adminces/");
        browser.find().css("input[type='password']").write(System.getenv("ADMINCES_PASSWORD"));
        browser.find().css("button[type='submit']").click();
        browser.find().link("Registrarse").click();
        browser.find().css("input[name=inputFirstName]").write("Orianna");
        browser.find().css("input[name=inputLastName]").write("Castro");
        browser.find().css("input[name=inputEmail]").write("Orianna@gmail.com");
        browser.find().css("input[name=inputPassword]").write("1234");
        browser.find().css("input[name=inputRepeatPassword]").write("1234");
        browser.find().css("input[name=inputCountry]").write("Uruguay");
        browser.find().id("btnRegister").click();
        browser.wait("#swal2-html-container").css();
        browser.find().css("button.swal2-confirm").click();
        browser.find().css("a.dropdown-toggle").click();
        browser.find().css(".dropdown-menu a[href='/adminces/login']").click();
        browser.find().css("input[name=inputEmail]").write("Orianna@gmail.com");
        browser.find().css("input[name=inputPassword]").write("1234");
        browser.find().css("button.btn-orange-ces.rounded-end-pill").click();
        browser.find().css("button.swal2-confirm").click();
        browser.find().css("a#cardLogin[href='/adminces/create-user']").click();

        browser.find().css("input[name=inputFirstName]").write("Victor");
        browser.find().css("input[name=inputLastName]").write("Rivero");
        browser.find().css("input[name=inputEmail]").write("Victor@gmail.com");
        browser.find().css("select[name='inputCountry']").selectValue("Uruguay");
        browser.find().css("input[name=inputPassword]").write("1234");
        browser.find().css("label[for='testerSenior']").click();
        browser.find().id("btnRegister").click();
        browser.wait("#swal2-html-container").css();
        String mensajeObtenido = browser.find().css("#swal2-html-container").getText();
        IVerify verificador = IVerify.create();
        verificador.verify("Usuario creado.", mensajeObtenido, "El mensaje no es el esperado");
        browser.find().css("button.swal2-confirm").click();
    }
}