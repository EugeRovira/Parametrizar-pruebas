package com.tatf.pages;

import com.tatf.core.browser.IBrowser;

public class HomeAdminCESPage {
    private IBrowser browser;

    public HomeAdminCESPage(IBrowser browser) {
        this.browser = browser;
    }

        public void accederAdminCES(String Password) {
            browser.interaction().navigateTo("http://cestore.ces.com.uy/adminces/");
            browser.find().css("input[type='password']").write(Password);
            browser.find().css("button[type='submit']").click();

        }
        public void accederRegistro() {
            browser.find().link("Registrarse").click();
        }

        public void accederLogin() {
            browser.find().css("a.dropdown-toggle").click();
            browser.find().css(".dropdown-menu a[href='/adminces/login']").click();
        }
}
