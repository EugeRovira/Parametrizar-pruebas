package com.tatf.pages;

import com.tatf.core.browser.IBrowser;

public class SweetAlertComponent {
    private IBrowser browser;
    private String mensaje = "#swal2-html-container";
    private String botonConfirmar = "button.swal2-confirm";

    public SweetAlertComponent(IBrowser browser) {
        this.browser = browser;
    }

    public String obtenerMensaje() {
        browser.wait(mensaje).css();
        return browser.find().css(mensaje).getText();
    }

    public void confirmar() {
        browser.find().css(botonConfirmar).click();
    }
}
