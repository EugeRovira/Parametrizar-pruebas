package com.tatf.tests;

import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;
import com.tatf.pages.HomeAdminCESPage;
import com.tatf.pages.RegistroAdminPage;
import com.tatf.pages.ReiniciarContraseñaPage;
import com.tatf.pages.SweetAlertComponent;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


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

    @ParameterizedTest
    @CsvFileSource(resources = "/datos_reiniciar_contraseña.csv")
    void ReiniciarContraseña(String nombre, String apellido, String correo, String contraseña,
                             String repetirContraseña, String pais, String contraseñaNueva,
                             String repetirContraseñaNueva) {
        HomeAdminCESPage homePage = new HomeAdminCESPage(browser);
        homePage.accederAdminCES(System.getenv("ADMINCES_PASSWORD"));
        homePage.accederRegistro();
        RegistroAdminPage registroPage = new RegistroAdminPage(browser);
        registroPage.FormularioAdmin(nombre, apellido,
                correo, contraseña, repetirContraseña, pais);
        registroPage.enviarForm();

        SweetAlertComponent sweetAlert = new SweetAlertComponent(browser);
        sweetAlert.obtenerMensaje();
        sweetAlert.confirmar();

        ReiniciarContraseñaPage reinicioPage = new ReiniciarContraseñaPage(browser);
        reinicioPage.accederReinicioContraseña();
        reinicioPage.formReinicioContraseña(correo, contraseñaNueva,
                repetirContraseñaNueva);
        reinicioPage.finalizarReinicio();

        String mensajeObtenido = sweetAlert.obtenerMensaje();
        IVerify verificador = IVerify.create();
        verificador.verify("Contraseña reiniciada.", mensajeObtenido,
                "El mensaje no es el esperado");
    }
}