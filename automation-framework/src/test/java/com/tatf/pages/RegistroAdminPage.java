package com.tatf.pages;
import com.tatf.core.browser.IBrowser;

public class RegistroAdminPage {
    private IBrowser browser;
    private String nombreSelector = "input[name=inputFirstName]";
    private String apellidoSelector = "input[name=inputLastName]";
    private String correoSelector = "input[name=inputEmail]";
    private String passwordSelector = "input[name=inputPassword]";
    private String repetirPasswordSelector = "input[name=inputRepeatPassword]";
    private String paisSelector = "input[name=inputCountry]";
    private String botonRegistroSelector = "btnRegister";


    public RegistroAdminPage(IBrowser browser) {
        this.browser = browser;
    }

    public void FormularioAdmin(String Nombre, String Apellido,
                                String Correo, String Password, String repetirPassword, String Pais) {
        browser.find().css(nombreSelector).write(Nombre);
        browser.find().css(apellidoSelector).write(Apellido);
        browser.find().css(correoSelector).write(Correo);
        browser.find().css(passwordSelector).write(Password);
        browser.find().css(repetirPasswordSelector).write(repetirPassword);
        browser.find().css(paisSelector).write(Pais);
    }

    public void enviarForm() {
        browser.find().id(botonRegistroSelector).click();
    }
}

