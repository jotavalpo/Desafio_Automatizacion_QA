package cl.previred.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Imac_PO extends Base_PO {

    // Metodo Constructor
    public Imac_PO() {
        super();
    }

    //Producto iMac
    private @FindBy(xpath = "//img[@title='iMac']")
    WebElement link_imac;

    public void visitarProducto() {
        waitForWebElementAndClick(link_imac);

    }

}