package steps;

import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.junit.Assert;
import pages.PruebaCompraPage;

public class PruebaCompraStep {

  @Page PruebaCompraPage pruebaCompraPage;

  @Step
  public void ingresarUrl() {
    pruebaCompraPage.ingresarUrl();
  }

  @Step
  public void seleccionarCategoria() {
    pruebaCompraPage.seleccionarCategoria();
  }

  @Step
  public void seleccionarProducto() {
    pruebaCompraPage.seleccionarProducto();
  }

  @Step
  public void comprarProducto(String nombre, String pais, String ciudad, String numeroTarjeta,
      String mesTarjeta, String anioTarjeta, String mensajeExito) {
    pruebaCompraPage.comprarProducto(nombre, pais, ciudad, numeroTarjeta, mesTarjeta, anioTarjeta);
    Assert.assertEquals(mensajeExito, pruebaCompraPage.obtenerMensajeExitosoCompra());
    pruebaCompraPage.cerrarPopUpCompra();
  }
}
