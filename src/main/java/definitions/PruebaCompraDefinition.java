package definitions;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import net.thucydides.core.annotations.Steps;
import steps.PruebaCompraStep;

public class PruebaCompraDefinition {

  @Steps PruebaCompraStep pruebaCompraStep;

  @Dado("^que ingreso a la pagina para realizar la compra de la laptop$")
  public void ingresarUrl() {
    pruebaCompraStep.ingresarUrl();
  }

  @Cuando("^busco la categoria requerida para realizar la compra$")
  public void seleccionarCategoria() {
    pruebaCompraStep.seleccionarCategoria();
  }

  @Entonces("^elijo el producto deseado$")
  public void seleccionarProducto() {
    pruebaCompraStep.seleccionarProducto();
  }

  @Y("^realizo el proceso de compra con los datos del cliente (.*), (.*), (.*), (.*), (.*), (.*) y (.*)$")
  public void comprarProducto(String nombre, String pais, String ciudad, String numeroTarjeta,
      String mesTarjeta, String anioTarjeta, String mensajeExito) {
    pruebaCompraStep.comprarProducto(nombre, pais, ciudad, numeroTarjeta, mesTarjeta, anioTarjeta, mensajeExito);
  }

}
