package cl.previred.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home_PO extends Base_PO {

    // Metodo Constructor
    public Home_PO() {
        super();
    }

    //Categoría Desktops
    private @FindBy(xpath = "(//a[contains(.,'Desktops')])[1]")
    WebElement opt_desktops;

    //Subcategoria Mac
    private @FindBy(xpath = "//a[contains(.,'Mac (1)')]")
    WebElement opt_mac;

    //Categoría Laptops & Notebooks
    private @FindBy(xpath = "(//a[contains(.,'Laptops & Notebooks')])[1]")
    WebElement opt_laptops;

    //Categoría Components
    private @FindBy(xpath = "(//a[contains(.,'Components')])[1]")
    WebElement opt_components;

    //Categoría Tablets
    private @FindBy(xpath = "//a[contains(.,'Tablets')]")
    WebElement opt_tablets;

    //Categoría Software
    private @FindBy(xpath = "//a[contains(.,'Software')]")
    WebElement opt_software;

    //Categoría Phones & PDA's
    private @FindBy(xpath = "//a[contains(.,'Phones & PDAs')]")
    WebElement opt_phones;

    //Categoría Cameras
    private @FindBy(xpath = "(//a[contains(.,'Cameras')])[2]")
    WebElement opt_cameras;

    //Categoría MP3 Players
    private @FindBy(xpath = "(//a[contains(.,'MP3 Players')])[1]")
    WebElement opt_mp3Players;

    //Mostrar todos los dispositivos MP3 Players
    private @FindBy(xpath = "//a[contains(.,'Show All MP3 Players')]")
    WebElement opt_allMp3players;

    //Botón carrito desde Home
    private @FindBy(xpath = "//span[@id='cart-total']")
    WebElement btn_cartItems;

    //Opción View Cart de carrito Home
    private @FindBy(xpath = "//strong[contains(.,'View Cart')]")
    WebElement link_viewCart;

    //Opción Checkout de carrito Home
    private @FindBy(xpath = "//strong[contains(.,'Checkout')]")
    WebElement link_checkout;

    //Input buscador Home
    private @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement input_search;

    //Botón buscar
    private @FindBy(xpath = "//i[@class='fa fa-search']")
    WebElement btn_buscar;

    //Botón Shopping Cart del Home
    private @FindBy(xpath = "(//i[@class='fa fa-shopping-cart'])[1]")
    WebElement btn_shoppingCart;

    public void verProductosCategoriaDesktops() {
        waitForWebElementAndClick(opt_desktops);
        waitForWebElementAndClick(opt_mac);

    }

    public void verProductosCategoriaMp3Players() {
        waitForWebElementAndClick(opt_mp3Players);
        waitForWebElementAndClick(opt_allMp3players);

    }

    public void buscarProducto(String producto) {
        waitForWebElementAndClick(input_search);
        sendKeys(input_search, producto);
        btn_buscar.click();

    }

    public void iralCarrito() {
        waitForWebElementAndClick(btn_cartItems);
        waitForElementVisible(link_viewCart, 5);
        link_viewCart.click();

    }

    public void iralCheckout() {
        waitForWebElementAndClick(btn_cartItems);
        waitForElementVisible(link_checkout, 5);
        waitForWebElementAndClick(link_checkout);

    }

}

