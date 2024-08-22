package cl.previred.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DetalleProducto_PO extends Base_PO {

    // Metodo Constructor
    public DetalleProducto_PO() {
        super();
    }

    //Botón Add to Cart
    private @FindBy(xpath = "//button[@id='button-cart']")
    WebElement btn_addToCart;

    //Alerta producto agregado a carrito
    private @FindBy(xpath = "//div[contains(@class,'alert alert-success alert-dismissible')]")
    WebElement alert_sucess;

    public void agregarProductoACarro() {
        waitForWebElementAndClick(btn_addToCart);

    }

    public void validarProductoAgregadoACarro() {
        waitForElementVisibleAndContinue(alert_sucess, 10);

    }

}

