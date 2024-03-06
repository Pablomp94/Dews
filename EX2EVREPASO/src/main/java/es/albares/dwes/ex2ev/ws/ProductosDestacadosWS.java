package es.albares.dwes.ex2ev.ws;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebService(serviceName = "ProductosDestacadosWebService")
public class ProductosDestacadosWS {

    @WebMethod(operationName = "destacados")
    public List<String> productosDestacados() {
        return new ArrayList<>(Arrays.asList("SamsungGS24", "OppoFX5", "SonyA7IV"));
    }
}