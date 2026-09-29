package com.tatf.pages;

import com.tatf.core.browser.IBrowser;
import com.tatf.core.driver.factory.DriverType;
import com.tatf.core.driver.instance.DriverManagerSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EliminarTesterPage {
    private IBrowser browser;

    public EliminarTesterPage(IBrowser browser) {
        this.browser = browser;
    }
    public void accederVerUsuarios() {
        browser.find().css("button.swal2-confirm").click();
        WebDriverWait espera = new WebDriverWait(DriverManagerSingleton.getInstance(DriverType.CHROME).getDriver(),
                Duration.ofSeconds(10));
        espera.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".swal2-container")));
        browser.find().css("a.nav-link[href='/adminces/view-users']").click();
    }

    public void seleccionarTester(String Correo) {
        browser.find().id(Correo).click();
    }

    public void confirmarEliminacion () {
        browser.find().css("button.swal2-confirm").click();
    }
}
