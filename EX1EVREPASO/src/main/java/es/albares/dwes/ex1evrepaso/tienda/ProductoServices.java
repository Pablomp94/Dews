package es.albares.dwes.ex1evrepaso.tienda;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;

/**
 *
 * @author usuario
 */
@Named("productoServices")
@ApplicationScoped
public class ProductoServices {
    
    private HashMap<String, Producto> mapProductos;
    
    public ProductoServices() {
        synchronized (this) {
            if (mapProductos == null) {
                init();
            }
        }
    }
    
    public Collection<Producto> getProductos() {
        return mapProductos.values();
    }

    /**
     * Inicializa la lita de productos con una colección de ejemplo
     */
    private void init() {
        mapProductos = new HashMap<>();
        
        mapProductos.put("SamsungGS23", 
            new Producto("SamsungGS23", "Samsung", "Galaxy S23", "imagenes/1473-samsung-galaxy-s23-256gb-algodon-libre-cargador-25w.webp", "256GB Algodón Libre + cargador 25W", 
"""                    
            <ul>
            <li><strong>Sistema operativo</strong> Android 13</li>
            <li><strong>Procesador</strong> Qualcomm Snapdragon 8, Gen 2 Octa-Core (3.36GHz, 2.8GHz, 2GHz)</li>
            <li><strong>Pantalla</strong> 6.6", 2340 x 1080 (FHD+) Dynamic AMOLED 2X (120 Hz)</li>
            <li><strong>SIM</strong> Dual SIM (SIM 1 + SIM 2 o eSIM)</li>
            <li><strong>Memoria</strong>
            <ul>
            <li>RAM: 8 GB</li>
            <li>Almacenamiento interno: 512 GB</li>
            </ul>
            </li>
            <li><strong>Cámaras</strong>
            <ul>
            <li>50 MP Principal, OIS</li>
            <li>10 MP Zoom x3, OIS</li>
            <li>12 MP Ultra gran angular</li>
            <li>12 MP Frontal</li>
            </ul>
            </li>
            <li><strong>Conectividad</strong>
            <ul>
            <li>WiFi 6E 802.11 a/b/g/n/ac/ax 2.4G+5GHz+6GHz, HE160, MIMO, 1024-QAM</li>
            <li>Bluetooth v5.3</li>
            <li>NFC</li>
            </ul>
            </li>
            <li><strong>Biometría</strong>
            <ul>
            <li>Sensor de huellas</li>
            <li>Reconocimiento facial</li>
            </ul>
            </li>
            <li><strong>Otros</strong>
            <ul>
            <li>IP68</li>
            <li>One UI 5.1</li>
            <li>UWB</li>
            </ul>
            </li>
            <li><strong>Dimensiones y peso</strong>
            <ul>
            <li>Dimensiones: 157.8 x 76.2 x 7.6 mm</li>
            <li>Peso: 195 g</li>
            </ul>
            </li>
            <li><strong>Batería</strong>
            <ul>
            <li>4700 mAh</li>
            <li>Carga rápida 45 W</li>
            <li>Carga inalámbrica</li>
            </ul>
            </li>
            <li><strong>Contenido del paquete</strong>
            <ul>
            <li>Samsung Galaxy S23+</li>
            <li>Cargador 25W</li>
            <li>Cable</li>
            </ul>
            </li>
            </ul>
            """,
            new GregorianCalendar(2023, 0, 1).getTime(), Float.valueOf("749")));
        
        mapProductos.put("SamsungGA54",
            new Producto("SamsungGA54", "Samsung", "Galaxy A54", "imagenes/1904-samsung-galaxy-a54-5g-8-128gb-negro-libre-protector-pantalla.webp", "5G 8/256GB Negro Libre + Protector Pantalla", 
"""                    
            <ul>
            <li><strong>Sistema operativo</strong> Android 13</li>
            <li><strong>Procesador</strong> Exynos 1380 Octa-Core (2.4GHz, 2GHz)</li>
            <li><strong>Pantalla</strong> 6.4", 1080 x 2340 (FHD+) On-Cell Touch Super AMOLED (120 Hz)</li>
            <li><strong>SIM</strong> Dual Nano-SIM (SIM 1 + Híbrido (SIM o microSD) o eSIM)</li>
            <li><strong>Memoria</strong>
            <ul>
            <li>RAM: 8 GB</li>
            <li>Almacenamiento interno: 256 GB (Ampliable con tarjeta microSD hasta 1 TB)</li>
            </ul>
            </li>
            <li><strong>Cámaras</strong>
            <ul>
            <li>Principal:
            <ul>
            <li>Resolución (Múltiple): 50.0 MP + 12.0 MP + 5.0 MP</li>
            <li>Apertura (Múltiple): F1.8 , F2.2 , F2.4</li>
            <li>Autoenfoque: Sí</li>
            <li>OIS: Sí</li>
            <li>Zoom: Digital hasta 10x</li>
            <li>Flash: Sí</li>
            </ul>
            </li>
            <li>Frontal:
            <ul>
            <li>Resolución: 32.0 MP</li>
            <li>Apertura: F2.2</li>
            <li>Autoenfoque: No</li>
            <li>OIS: No</li>
            <li>Flash: No</li>
            </ul>
            </li>
            <li>Resolución de grabación de vídeo: UHD 4K (3840 x 2160)@30fps</li>
            <li>Slow Motion: 240fps @HD</li>
            </ul>
            </li>
            <li><strong>Audio</strong>
            <ul>
            <li>Dolby Atmos</li>
            <li>Conector de auriculares USB Tipo C</li>
            </ul>
            </li>
            <li><strong>Redes</strong>
            <ul>
            <li>2G GSM: GSM850, GSM900, DCS1800, PCS1900</li>
            <li>3G UMTS: B1(2100), B2(1900), B4(AWS), B5(850), B8(900)</li>
            <li>4G FDD LTE: B1(2100), B2(1900), B3(1800), B4(AWS), B5(850), B7(2600), B8(900), B12(700), B17(700), B20(800), B26(850), B28(700), B32(1500), B66(AWS-3)</li>
            <li>4G TDD LTE: B38(2600), B40(2300), B41(2500)</li>
            <li>5G FDD Sub6: N1(2100), N3(1800), N7(2600), N8(900), N20(800), N28(700)</li>
            <li>5G TDD Sub6: N38(2600), N40(2300), N41(2500), N77(3700), N78(3500)</li>
            </ul>
            </li>
            <li><strong>Conectividad</strong>
            <ul>
            <li>WiFi 802.11 a/b/g/n/ac/ax 2.4G+5GHz, HE80, MIMO, 1024-QAM</li>
            <li>WiFi Direct</li>
            <li>Bluetooth 5.3</li>
            <li>NFC</li>
            <li>USB Tipo C (2.0)</li>
            </ul>
            </li>
            <li><strong>Navegación y posicionamiento</strong>
            <ul>
            <li>GPS</li>
            <li>Glonass</li>
            <li>Beidou</li>
            <li>Galileo</li>
            <li>QZSS</li>
            </ul>
            </li>
            <li><strong>Biometría</strong>
            <ul>
            <li>Lector de huella</li>
            <li>Reconocimiento facial</li>
            </ul>
            </li>
            <li><strong>Sensores</strong>
            <ul>
            <li>Acelerómetro</li>
            <li>Giroscopio</li>
            <li>Geomagnético</li>
            <li>Hall</li>
            <li>Luminosidad</li>
            <li>Sensor de proximidad virtual</li>
            </ul>
            </li>
            <li><strong>Dimensiones y peso</strong>
            <ul>
            <li>Dimensiones: 158.2 x 76.7 x 8.2 mm</li>
            <li>Peso: 202 g</li>
            </ul>
            </li>
            <li><strong>Batería</strong>
            <ul>
            <li>5000 mAh</li>
            <li>Carga rápida de 25W<br><strong>*<span style="text-decoration: underline;">Cargador no incluido</span></strong></li>
            </ul>
            </li>
            </ul>""",
            new GregorianCalendar(2023, 5, 1).getTime(), Float.valueOf("469.01")));
        
        mapProductos.put("OppoFX5",
            new Producto("OppoFX5", "Oppo", "Find X5", "imagenes/1131-oppo-find-x5-5g-8-256gb-blanco-libre-cable-usb-31-type-c.webp", "5G 8/256GB Blanco Libre + Cable USB 3.1 Type-C", 
"""                    
            <ul>
            <li><strong>Procesador</strong> Qualcomm Snapdragon 888 5G, 8 núcleos Kryo 680 a 2,84GHz (1 x Cortex X1 a 2,84GHz, 3 x Cortex A78 a 2,84GHz, 4 x Cortex A55 a 1,8GHz)</li>
            <li><strong>Pantalla </strong>6.5" AMOLED, 10 bits, 120 Hz</li>
            <li><strong>SIM</strong> Dual SIM</li>
            <li><strong>Memoria</strong>
            <ul>
            <li>RAM: 8 GB</li>
            <li>Almacenamiento interno: 256 GB</li>
            </ul>
            </li>
            <li><strong>Cámaras</strong>
            <ul>
            <li>4K Ultra Nocturno</li>
            <li>Principal 50MP
            <ul>
            <li>Sensor: Sony IMX 766</li>
            <li>Tamaño de sensor: 1/1.56"</li>
            <li>Apertura: f/1.7</li>
            <li>Estabilizador SLR-Level 5-ejes</li>
            <li>All-Pixel Omni-Directional PDAF</li>
            </ul>
            </li>
            <li>Ultra gran angular 50MP
            <ul>
            <li>Sensor: Sony IMX 766</li>
            <li>Tamaño de sensor: 1/1.56"</li>
            <li>Apertura: f/2.2</li>
            <li>Nativo 110.3º campo de visión</li>
            <li>All-Pixel Omni-Directional PDAF</li>
            </ul>
            </li>
            <li>Teleobjetivo 13MP
            <ul>
            <li>Apertura: f/2.4</li>
            <li>5x Zoom híbrido óptico</li>
            <li>Zoom 20x digital</li>
            </ul>
            </li>
            <li>Frontal:
            <ul>
            <li>32MP</li>
            </ul>
            </li>
            </ul>
            </li>
            <li><strong>Conectividad</strong>
            <ul>
            <li>Wi-Fi</li>
            <li>Bluetooth</li>
            <li>5G</li>
            </ul>
            </li>
            <li><strong>Batería</strong>
            <ul>
            <li>4800 mAh</li>
            <li>Carga Rápida 80W</li>
            <li>Carga inalámbrica 30W</li>
            </ul>
            </li>
            </ul>""",
            new GregorianCalendar(2023, 10, 1).getTime(), Float.valueOf("954.99")));
        
        mapProductos.put("SamsungGZF5",
            new Producto("SamsungGZF5", "Samsung", "Galaxy Z Fold5", "imagenes/1593-samsung-galaxy-z-fold5-12-512gb-azul-glaciar-cargador-de-pared-25w-foto.webp", "12/512GB Azul Glaciar + Cargador de Pared 25W", 
"""                    
            <ul>
            <li><strong>Pantalla</strong>
            <ul>
            <li>Interior: 7.6” QXGA+ (2176 x 1812) (120Hz) Dynamic AMOLED 2X</li>
            <li>Exterior: 6,2” 2316 x 904 (HD+) (120Hz) Dynamic AMOLED 2X</li>
            </ul>
            </li>
            <li><strong>SO: </strong>Android 13</li>
            <li><strong>Procesador. </strong>Qualcomm Snapdragon 8 Gen 2 for Galaxy (SM8550) Octa-Core (3.36GHz, 2.8GHz, 2GHz)</li>
            <li><strong>Memoria: </strong>12GB + 512 GB</li>
            <li><strong>Batería</strong>
            <ul>
            <li>4400 mAh</li>
            <li>Carga rápida: 25W</li>
            <li>Carga inalámbrica: 15W</li>
            </ul>
            </li>
            <li><strong>Dimensiones: </strong>154.9 x 129.9 x 6.1 mm (Plegado: 154.9 x 67.1 x 13.4 mm) 254g</li>
            <li><strong>Conectividad</strong>
            <ul>
            <li>Dual SIM (SIM 1 + SIM2 ó eSIM)</li>
            <li>Wifi 6e</li>
            <li>BT v5.3</li>
            <li>UWB</li>
            </ul>
            </li>
            <li><strong>Cámara</strong>
            <ul>
            <li>50 MP Principal (F1.8)</li>
            <li>12 MP Gran angular (F2.2)</li>
            <li>10 MP Teleobjetivo (Zoom óptico x3) (F2.4)</li>
            <li>4 MP Interior (F1.8)</li>
            <li>10 MP Frontal (F2,2)</li>
            </ul>
            </li>
            <li><strong>Biometría:</strong> Lector de huella y Reconocimiento facial</li>
            <li><strong>Otros: </strong>One UI 5.1.1, Compatible con S pen</li>
            <li><strong>Caja: </strong>Cable USB C</li>
            </ul>""",
            new GregorianCalendar(2023, 7, 12).getTime(), Float.valueOf("2029.90")));        
    }
    
    /**
     * Devuelve el Producto que es identificado por el parámetro Id
     * @param id
     * @return 
     */
    public Producto getProductoById(String id) {
        return mapProductos.get(id);
    }
    
}
