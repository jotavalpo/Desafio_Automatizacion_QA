package cl.previred.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CarritoCompras_PO extends Base_PO {

    // Metodo Constructor
    public CarritoCompras_PO() {
        super();
    }

    //Label de producto iMac en carrito
    private @FindBy(xpath = "(//a[contains(.,'iMac')])[2]")
    WebElement label_iMac;

    //Label de producto iMac en carrito
    private @FindBy(xpath = "(//a[contains(.,'iPod Classic')])[2]")
    WebElement label_iPodClassic;

    //Botón eliminar producto iMac de carrito
    private @FindBy(xpath = "(//i[@class='fa fa-times-circle'])[1]")
    WebElement btn_eliminariMac;

    //Botón actualizar producto iMac de carrito
    private @FindBy(xpath = "(//i[@class='fa fa-refresh'])[1]")
    WebElement btn_actualizariMac;

    //Botón eliminar producto iPodClassic de carrito
    private @FindBy(xpath = "(//i[@class='fa fa-times-circle'])[2]")
    WebElement btn_eliminariPodClassic;

    //Botón actualizar producto iPodClassic de carrito
    private @FindBy(xpath = "(//i[@class='fa fa-refresh'])[2]")
    WebElement btn_actualizariPodClassic;

    public void eliminarImac() {
        waitForWebElementAndClick(btn_eliminariMac);

    }

    public void eliminarIpod() {
        waitForWebElementAndClick(btn_eliminariPodClassic);

    }

    public void validarProductosEnCarrito(String iMac, String iPodClassic) {
        waitForElementVisible(label_iMac, 2);
        String msg1 = label_iMac.getText();
        Assert.assertEquals(msg1, iMac);
        waitForElementVisible(label_iPodClassic, 2);
        String msg2 = label_iPodClassic.getText();
        Assert.assertEquals(msg2, iPodClassic);

    }

}

