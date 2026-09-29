package com.tatf.tests;

import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import com.tatf.pages.HomeAdminCESPage;
import com.tatf.pages.RegistroAdminPage;
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
        HomeAdminCESPage homePage = new HomeAdminCESPage(browser);
        homePage.accederAdminCES(System.getenv("ADMINCES_PASSWORD"));
        homePage.accederRegistro();
        RegistroAdminPage registroPage = new RegistroAdminPage(browser);
        registroPage.FormularioAdmin("Orianna", "Castro",
                "Orianna@gmail.com", "1234", "1234", "Uruguay");
        registroPage.enviarForm();

        browser.wait("#swal2-html-container").css();
        String mensajeObtenido = browser.find().css("#swal2-html-container").getText();
        IVerify verificador = IVerify.create();
        verificador.verify("Usuario creado.", mensajeObtenido, "El mensaje no es el esperado");
    }
}
