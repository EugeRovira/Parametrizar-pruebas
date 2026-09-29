package com.tatf.tests;

import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;
import com.tatf.pages.HomeAdminCESPage;
import com.tatf.pages.RegistroAdminPage;
import com.tatf.pages.ReiniciarContraseñaPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class ReiniciarContraseñaTest {
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
    void ReiniciarContraseña() {
        HomeAdminCESPage homePage = new HomeAdminCESPage(browser);
        homePage.accederAdminCES(System.getenv("ADMINCES_PASSWORD"));
        homePage.accederRegistro();
        RegistroAdminPage registroPage = new RegistroAdminPage(browser);
        registroPage.FormularioAdmin("Orianna", "Castro",
                "Orianna@gmail.com", "1234", "1234", "Uruguay");
        registroPage.enviarForm();
        ReiniciarContraseñaPage reinicioPage = new ReiniciarContraseñaPage(browser);
        browser.wait("#swal2-html-container").css();
        browser.find().css("button.swal2-confirm").click();
        reinicioPage.accederReinicioContraseña();
        reinicioPage.formReinicioContraseña("Orianna@gmail.com", "1234567", "1234567");
        reinicioPage.finalizarReinicio();

        browser.wait("#swal2-html-container").css();
        String mensajeObtenido = browser.find().css("#swal2-html-container").getText();
        IVerify verificador = IVerify.create();
        verificador.verify("Contraseña reiniciada.", mensajeObtenido, "El mensaje no es el esperado");
    }
}