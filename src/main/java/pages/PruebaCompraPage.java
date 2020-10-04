package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PruebaCompraPage extends PageObject {

  @FindBy(xpath = "//a[contains(text(), 'Laptops')]")
  public WebElementFacade lblCategoria;

  @FindBy(xpath = "//a[contains(text(), 'Dell i7 8gb')]")
  public WebElementFacade lblProducto;

  @FindBy(xpath = "//div//a[contains(text(), 'Add to cart')]")
  public WebElementFacade btnAgregarCarroCompras;

  @FindBy(xpath = "//li[@class='nav-item']//a[@id='cartur']")
  public WebElementFacade lnkBuscarCarroCompras;

  @FindBy(xpath = "//button[contains (text(), 'Place Order')]")
  public WebElementFacade btnOrdenarCompra;

  @FindBy(id = "name")
  public WebElementFacade txtNombre;

  @FindBy(id = "country")
  public WebElementFacade txtPais;

  @FindBy(id = "city")
  public WebElementFacade txtCiudad;

  @FindBy(id = "card")
  public WebElementFacade txtNumeroTarjeta;

  @FindBy(id = "month")
  public WebElementFacade txtMesTarjeta;

  @FindBy(id = "year")
  public WebElementFacade txtAnioTarjeta;

  @FindBy(xpath = "//button[contains (text(), 'Purchase')]")
  public WebElementFacade btnConfirmarCompra;

  @FindBy(xpath = "//div//h2[contains (text(), 'Thank you for your purchase!')] ")
  public WebElementFacade lblMensajeExitosoCompra;

  @FindBy(xpath = "//div//button[@class='confirm btn btn-lg btn-primary']")
  public WebElementFacade btnCerrarPopUpCompra;


  public PruebaCompraPage(WebDriver webDriver) {
    super(webDriver);
  }

  public void ingresarUrl() {
    getDriver().get("https://www.demoblaze.com/index.html#");
  }


  public void seleccionarCategoria() {
    lblCategoria.waitUntilVisible().waitUntilClickable().click();
  }

  private void esperarPopUp(int miliSegundos) {
    try {
      Thread.sleep(miliSegundos);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void seleccionarProducto() {
    lblProducto.waitUntilVisible().waitUntilClickable().click();
    btnAgregarCarroCompras.waitUntilVisible().waitUntilClickable().click();
    esperarPopUp(3000);
    Alert alert = getDriver().switchTo().alert();
    alert.accept();
  }


  public void comprarProducto(String nombre, String pais, String ciudad, String numeroTarjeta,
      String mesTarjeta, String anioTarjeta) {
    lnkBuscarCarroCompras.waitUntilVisible().waitUntilClickable().click();
    btnOrdenarCompra.waitUntilVisible().waitUntilClickable().click();
    esperarPopUp(10000);
    txtNombre.waitUntilVisible().waitUntilClickable().sendKeys(nombre);
    txtPais.waitUntilVisible().sendKeys(pais);
    txtCiudad.waitUntilVisible().sendKeys(ciudad);
    txtNumeroTarjeta.waitUntilVisible().sendKeys(numeroTarjeta);
    txtMesTarjeta.waitUntilVisible().sendKeys(mesTarjeta);
    txtAnioTarjeta.waitUntilVisible().sendKeys(anioTarjeta);
    btnConfirmarCompra.waitUntilVisible().waitUntilClickable().click();
  }

  public String obtenerMensajeExitosoCompra(){
    esperarPopUp(5000);
    return lblMensajeExitosoCompra.waitUntilVisible().getText();
  }

  public void cerrarPopUpCompra(){
    btnCerrarPopUpCompra.waitUntilVisible().waitUntilClickable().click();
  }
}
