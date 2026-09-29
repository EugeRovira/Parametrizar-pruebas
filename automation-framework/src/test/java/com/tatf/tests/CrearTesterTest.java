package com.tatf.tests;

import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;
import com.tatf.pages.CrearTesterPage;
import com.tatf.pages.HomeAdminCESPage;
import com.tatf.pages.LoginAdminPage;
import com.tatf.pages.RegistroAdminPage;
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
        HomeAdminCESPage homePage = new HomeAdminCESPage(browser);
        homePage.accederAdminCES(System.getenv("ADMINCES_PASSWORD"));
        homePage.accederRegistro();
        RegistroAdminPage registroPage = new RegistroAdminPage(browser);
        registroPage.FormularioAdmin("Orianna", "Castro",
                "Orianna@gmail.com", "1234", "1234", "Uruguay");
        registroPage.enviarForm();

        browser.wait("#swal2-html-container").css();
        browser.find().css("button.swal2-confirm").click();
        homePage.accederLogin();
        LoginAdminPage loginPage = new LoginAdminPage(browser);
        loginPage.iniciarSesion("Orianna@gmail.com", "1234");
        browser.wait("#swal2-html-container").css();
        browser.find().css("button.swal2-confirm").click();
        CrearTesterPage testerPage = new CrearTesterPage(browser);
        testerPage.accederCrearTester();
        testerPage.formularioTester("Victor", "Rivero", "Victor@gmail.com", "Uruguay", "1234");
        testerPage.elegirTipoTester("Senior");
        testerPage.enviarForm();

        browser.wait("#swal2-html-container").css();
        String mensajeObtenido = browser.find().css("#swal2-html-container").getText();
        IVerify verificador = IVerify.create();
        verificador.verify("Usuario creado.", mensajeObtenido, "El mensaje no es el esperado");
        browser.find().css("button.swal2-confirm").click();
    }
}