package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CotizacionPage extends BasePage{
    private final String FECHANACinput = "BirthdayStep1";
    private final String PROVINCIAselect = "province";
    private final String CODAREAinput = "txtPhoneCode";
    private final String NUMTELEFONOinput = "txtPhoneNumber";
    public CotizacionPage(WebDriver driver) {
        super(driver);
    }

    public void irAKlimberTest(){
        navigateTo("https://purchase-testing.klimber.com/ar/GroupLife/Index");
    }

    public void ingresoFechadeNacimiento(int DDMMYYYY){
        write(By.id(FECHANACinput), Integer.toString(DDMMYYYY));
    }

    public void ingresoProvincia(String provincia){
        selectFromDropdownByText(By.id(PROVINCIAselect), provincia);
    }

    public void ingresoCelular(int codArea, int numTelefono){
        write(By.id(CODAREAinput), Integer.toString(codArea));
        write(By.id(NUMTELEFONOinput), Integer.toString(numTelefono));
    }

    public void seleccionarSumaAsegurada(int sumaAsegurada){

    }
}
