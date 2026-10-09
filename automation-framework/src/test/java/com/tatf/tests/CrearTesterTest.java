package com.tatf.tests;

import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;
import com.tatf.pages.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


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

    @ParameterizedTest
    @CsvFileSource(resources = "/datos_tester.csv")
    void CrearTester(String nombre, String apellido, String correo,
                     String pais, String contraseña, String tipoTester) {

        HomeAdminCESPage homePage = new HomeAdminCESPage(browser);
        homePage.accederAdminCES(System.getenv("ADMINCES_PASSWORD"));
        homePage.accederRegistro();
        RegistroAdminPage registroPage = new RegistroAdminPage(browser);
        registroPage.FormularioAdmin("Orianna", "Castro",
                "Orianna@gmail.com", "1234", "1234", "Uruguay");
        registroPage.enviarForm();
        SweetAlertComponent sweetAlert = new SweetAlertComponent(browser);

        sweetAlert.obtenerMensaje();
        sweetAlert.confirmar();


        homePage.accederLogin();
        LoginAdminPage loginPage = new LoginAdminPage(browser);
        loginPage.iniciarSesion("Orianna@gmail.com", "1234");

        sweetAlert.obtenerMensaje();
        sweetAlert.confirmar();

        CrearTesterPage testerPage = new CrearTesterPage(browser);
        testerPage.accederCrearTester();
        testerPage.formularioTester(nombre, apellido, correo, pais, contraseña);
        testerPage.elegirTipoTester(tipoTester);
        testerPage.enviarForm();

        String mensajeObtenido = sweetAlert.obtenerMensaje();
        IVerify verificador = IVerify.create();
        verificador.verify("Usuario creado.", mensajeObtenido, "El mensaje no es el esperado");
        sweetAlert.confirmar();
    }
}
