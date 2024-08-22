package cl.previred.stepDefinitions.base;

import cl.previred.pageObjects.*;
import cl.previred.utils.Constants_Vars;
import cl.previred.utils.CsvReader;
import cl.previred.utils.ScreenshotUtil;
import com.opencsv.exceptions.CsvException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;

public class RealizarCompraSteps extends Base_PO {

    private Base_PO basePo;
    private Home_PO homePo;
    private MP3Players_PO mp3PlayersPo;
    private Imac_PO imacPo;
    private DetalleProducto_PO detalleProductoPo;
    private CarritoCompras_PO carritoComprasPo;
    private Checkout_PO checkoutPo;
    private MiCuenta_PO miCuentaPo;
    private Login_PO loginPo;

    private List<String[]> credenciales;

    public RealizarCompraSteps(Base_PO basePo, Home_PO homePo, MP3Players_PO mp3PlayersPo, Imac_PO imacPo,
                               DetalleProducto_PO detalleProductoPo, CarritoCompras_PO carritoComprasPo,
                               Checkout_PO checkoutPo, MiCuenta_PO miCuentaPo, Login_PO loginPo) {
        this.basePo = basePo;
        this.homePo = homePo;
        this.mp3PlayersPo = mp3PlayersPo;
        this.imacPo =  imacPo;
        this.detalleProductoPo = detalleProductoPo;
        this.carritoComprasPo = carritoComprasPo;
        this.checkoutPo = checkoutPo;
        this.miCuentaPo = miCuentaPo;
        this.loginPo = loginPo;
    }

    @Given("Estoy en el home")
    public void estoy_en_el_home() {
        homePo.navigateToUrl(Constants_Vars.URL_TEST);
    }
    @When("Busco un Ipod Classic y lo agrego al carrito")
    public void busco_un_ipod_classic_y_lo_agrego_al_carrito() {
        homePo.verProductosCategoriaMp3Players();
        mp3PlayersPo.visitarProducto();
        detalleProductoPo.agregarProductoACarro();
        detalleProductoPo.validarProductoAgregadoACarro();
        ScreenshotUtil.takeScreenshot(basePo.getDriver(), "Ipod Classic agregado a carrito");

    }
    @When("Busco un iMac y lo agrego al carrito")
    public void busco_un_i_mac_y_lo_agrego_al_carrito() {
        homePo.verProductosCategoriaDesktops();
        imacPo.visitarProducto();
        detalleProductoPo.agregarProductoACarro();
        detalleProductoPo.validarProductoAgregadoACarro();
        ScreenshotUtil.takeScreenshot(basePo.getDriver(), "iMac agregado a carrito");

    }

    @When("Voy al carrito de compras y valido que esten agregados {string} y {string}")
    public void voy_al_carrito_de_compras_y_valido_que_esten_agregados_y(String iMac, String iPodClassic) {
        homePo.iralCarrito();
        carritoComprasPo.validarProductosEnCarrito(iMac, iPodClassic);

    }
    @When("Ingreso al checkout")
    public void ingreso_al_checkout() {
        homePo.iralCheckout();
        checkoutPo.validarCheckoutDesplegado();
        ScreenshotUtil.takeScreenshot(basePo.getDriver(), "Vista general de checkout");

    }
    @When("Inicio sesion usando las credenciales del archivo {string}")
    public void inicio_sesion_con_mi_cuenta(String filePath) throws IOException, CsvException {
        credenciales = CsvReader.readCsv(filePath);
        for (String[] cred : credenciales) {
            String email = cred[0];
            String password = cred[1];
            checkoutPo.completarPasoUno(email, password);
        }
        ScreenshotUtil.takeScreenshot(basePo.getDriver(), "Step 1 exitoso");
    }

    @When("Indico la direccion de facturacion")
    public void indico_la_direccion_de_facturacion() {
        checkoutPo.completarPasoDos();
        ScreenshotUtil.takeScreenshot(basePo.getDriver(), "Step 2 exitoso");

    }

    @When("Indico la direccion de entrega")
    public void indico_la_direccion_de_entrega() {
        checkoutPo.completarPasoTres();
        ScreenshotUtil.takeScreenshot(basePo.getDriver(), "Step 3 exitoso");
    }
    @When("Indico el metodo de envio y valido que sea {string}")
    public void indico_el_metodo_de_envio_y_valido_que_sea_de(String shippingRate) {
        checkoutPo.completarPasoCuatro(shippingRate);
        ScreenshotUtil.takeScreenshot(basePo.getDriver(), "Step 4 exitoso");

    }
    @When("Indico el metodo de pago")
    public void indico_el_metodo_de_pago() {
        checkoutPo.completarPasoCinco();
        ScreenshotUtil.takeScreenshot(basePo.getDriver(), "Step 5 exitoso");

    }

    @When("Finalizo el proceso de compra y valido que el monto total sea {string}")
    public void finalizo_el_proceso_de_compra(String total) {
        checkoutPo.completarPasoSeis(total);
        checkoutPo.validarOrdenExitosa();
        ScreenshotUtil.takeScreenshot(basePo.getDriver(), "Orden de compra exitosa");

    }
    @When("Voy al historial de compras")
    public void voy_al_historial_de_compras() {
        checkoutPo.irAHistorialDeOrdenes();

    }
    @Then("Valido que compra quede en estado pendiente")
    public void valido_que_compra_quede_en_estado_pendiente() {
        miCuentaPo.irADetalledePedidoHistorico();
        miCuentaPo.validarEstadoPendientePedido();
        ScreenshotUtil.takeScreenshot(basePo.getDriver(), "Orden de compra en estado correcto");
        loginPo.logout();

    }


}
