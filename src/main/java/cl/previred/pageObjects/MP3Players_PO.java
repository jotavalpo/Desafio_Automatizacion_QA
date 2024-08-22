package cl.previred.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MP3Players_PO extends Base_PO {

    // Metodo Constructor
    public MP3Players_PO() {
        super();
    }

    //Producto Ipod Classic
    private @FindBy(xpath = "//img[@title='iPod Classic']")
    WebElement link_ipodClassic;

    //Producto Ipod Nano
    private @FindBy(xpath = "//img[@title='iPod Nano']")
    WebElement link_ipodNano;

    //Producto Ipod Shuffle
    private @FindBy(xpath = "//img[@title='iPod Shuffle']")
    WebElement link_ipodShuffle;

    //Producto Ipod Touch
    private @FindBy(xpath = "//img[@title='iPod Touch']")
    WebElement link_ipodTouch;

    public void visitarProducto() {
        waitForWebElementAndClick(link_ipodClassic);

    }

}
