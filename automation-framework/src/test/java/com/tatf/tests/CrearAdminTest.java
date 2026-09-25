package com.tatf.tests;

import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.tatf.core.verification.IVerify;

public class CrearAdminTest {
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
    void CrearAdmin() {
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
        String mensajeObtenido = browser.find().css("#swal2-html-container").getText();
        IVerify verificador = IVerify.create();
        verificador.verify("Usuario creado.", mensajeObtenido, "El mensaje no es el esperado");
    }
}
