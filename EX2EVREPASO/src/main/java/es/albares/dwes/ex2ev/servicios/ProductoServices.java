package es.albares.dwes.ex2ev.servicios;

import es.albares.dwes.ex2ev.basedatos.GestorEntityManager;
import es.albares.dwes.ex2ev.entidades.Categoria;
import es.albares.dwes.ex2ev.entidades.Producto;
import es.albares.dwes.ex2ev.entidades.ProductoExistencias;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author usuario
 */
@Named("productoServices")
@ApplicationScoped
public class ProductoServices {

    public ProductoServices() {
    }

    /**
     * Devuelve la lista completa de productos de la BD
     *
     * @return la lista de productos
     */
    public Collection<Producto> getProductos() {
        EntityManager entityManager = GestorEntityManager.getEntityManager();
        List<Producto> lstProd = entityManager.createQuery("SELECT distinct p from Producto p join fetch p.categoria", Producto.class).getResultList();
        entityManager.close();

        return lstProd;
    }

    // damos de alta los productos desde su carga "local"
    public void altaProductos() {
        EntityManager entityManager = GestorEntityManager.getEntityManager();
        // damos da alta los productos en BD (si no existen...)
        entityManager.getTransaction().begin();
        for (Producto prod : getStaticProducts()) {
            entityManager.merge(prod);
        }
        entityManager.getTransaction().commit();

        entityManager.close();
    }

    /**
     * Devuelve el Producto que es identificado por el parámetro Id
     *
     * @param id
     * @return
     */
    public Producto getProductoById(String id) {
        if (id != null) {
            EntityManager entityManager = GestorEntityManager.getEntityManager();
            Producto Prod = entityManager.find(Producto.class, id);
            entityManager.close();
            return Prod;
        } else {
            return null;
        }
    }

    /**
     * Damos de alta un producto NOTA: merge=update remove=delete persist=insert
     */
    public String insertProducto(Producto prod) {

        EntityManager entityManager = GestorEntityManager.getEntityManager();

        // damos da alta un producto en BD
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(prod);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            if (entityManager.getTransaction() != null
                    && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
                entityManager.close();
            }
            throw ex;
        }
        entityManager.close();
        return prod.getId();
    }

    /**
     * Actualizamos un producto NOTA: merge=update remove=delete persist=insert
     */
    public int updateProducto(Producto prod) {

        EntityManager entityManager = GestorEntityManager.getEntityManager();

        // actualizamos un producto en BD
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(prod);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            if (entityManager.getTransaction() != null
                    && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
                entityManager.close();
            }
            throw ex;
        }
        entityManager.close();
        return 1;
    }

    /**
     * Borramos un producto a partir de su identificador NOTA: merge=update
     * remove=delete persist=insert
     */
    public int deleteProducto(String idProd) {

        EntityManager entityManager = GestorEntityManager.getEntityManager();

        // actualizamos un producto en BD
        try {
            // Primero recupero el producto
            Producto prod = entityManager.find(Producto.class, idProd);
            if (prod != null) {
                entityManager.getTransaction().begin();
                entityManager.remove(prod);
                entityManager.getTransaction().commit();
            } else {
                entityManager.close();
                return 0;
            }
        } catch (Exception ex) {
            if (entityManager.getTransaction() != null
                    && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw ex;
        }
        entityManager.close();
        return 1;
    }

    /**
     * Devuelve la lista completa de productos de la BD a partir de su categoria
     *
     * @return la lista de productos
     */
    public Collection<Producto> getProductosByCategoria(String codCateg) {
        String consulta = "SELECT distinct p from Producto p join fetch p.categoria "
                + "WHERE p.categoria.codigo = :codigo";
        EntityManager entityManager = GestorEntityManager.getEntityManager();
        List<Producto> lstProd = entityManager
                .createQuery(consulta, Producto.class)
                .setParameter("codigo", codCateg)
                .getResultList();
        entityManager.close();

        return lstProd;
    }

    /**
     * Devuelve la lista completa de productos de la BD de los cuales tengan
     * existencias
     *
     * @return la lista de productos
     */
    public Collection<Producto> getProductosEnStock() {
        String consulta = "SELECT distinct p from Producto p join fetch p.existencias "
                + "WHERE p.existencias.cantidad > 0";
        EntityManager entityManager = GestorEntityManager.getEntityManager();
        List<Producto> lstProd = entityManager
                .createQuery(consulta, Producto.class)
                .getResultList();
        entityManager.close();

        return lstProd;
    }

    /**
     * Devuelve la lista completa de productos de la BD de los cuales tengan
     * existencias y de una categoria en concreto
     *
     * @return la lista de productos
     */
    public Collection<Producto> getProductosByCategoriaEnStock(String codigoCategoria) {
        //El distinct es un filtro para que no recoja productos repetidos
        String consulta = "SELECT distinct p from Producto p join fetch p.categoria join fetch p.existencias "
                + "WHERE p.existencias.cantidad > 0 and p.categoria.codigo = :codigo";
        EntityManager entityManager = GestorEntityManager.getEntityManager();
        List<Producto> lstProd = entityManager
                .createQuery(consulta, Producto.class)
                .setParameter("codigo", codigoCategoria)
                .getResultList();
        entityManager.close();

        return lstProd;
    }

    /**
     * Devuelve la cantidad dde existencias del producto "idProd" tras
     * incrementarlo en "cantidad"
     *
     * @param idProd
     * @param cant
     * @return numero de existencias del producto o -1 si no hay productos
     */
    public int incrementa(String idProd, int cant) {

        if (idProd == null) {
            return -1;
        }
        EntityManager entityManager = GestorEntityManager.getEntityManager();
        try {
            
            entityManager.getTransaction().begin(); // Iniciar transacción
            
            Producto prod = entityManager.find(Producto.class, idProd);

            if (prod == null) {
                return -1;
            }

            ProductoExistencias prodExist = prod.getExistencias();

            if (prodExist != null) {
                prodExist.setCantidad(prodExist.getCantidad() + cant);
            } else {

                //Si no existen existencias hay que crearlas y mantener la relación Producto <-> ProductoExistencias
                prodExist = new ProductoExistencias(prod, cant);
                prod.setExistencias(prodExist);
                entityManager.persist(prodExist);
            }
            entityManager.getTransaction().commit();

            entityManager.close();

            //TODO devolver cantidad
            return prod.getExistencias().getCantidad();

            /*
         entityManager = GestorEntityManager.getEntityManager();
         prod = entityManager.find(Producto.class, idProd);
         
         if(prod.getExistencias() == null){
             System.out.println("Es nulo" + prod.getExistencias());
         }else{
             System.out.println("No es nulo" + prod.getExistencias());
         }
             */
        } catch (Exception ex) {
            return -1;
        }

    }

    /**
     * Devuelve la cantidad dde existencias del producto "idProd" tras
     * decrementarlo en "cantidad", no permitir operaciones con resultados
     * negativos
     *
     * @param idProd
     * @param cant
     * @return numero de existencias del producto o -1 si no hay productos
     */
    public int decrementa(String idProd, int cant) {

        if (idProd == null) {
            return -1;
        }
        EntityManager entityManager = GestorEntityManager.getEntityManager();
        try {
            
            entityManager.getTransaction().begin(); // Iniciar transacción
            
            ProductoExistencias prodExist = entityManager.find(ProductoExistencias.class, idProd);

            if (prodExist == null) {
                return -1;
            }

            //Compruebo si la cantidad final es positiva//
            if ((prodExist.getCantidad() - cant) >= 0) {
                prodExist.setCantidad(prodExist.getCantidad() - cant);
                entityManager.persist(prodExist);
                entityManager.getTransaction().commit();
            }

            entityManager.close();

            //TODO devolver cantidad
            return prodExist.getCantidad();
            
        } catch (Exception ex) {
            return -1;
        }

    }

    /**
     * obtiene la lista de productos estáticos de ejemplo
     */
    private List<Producto> getStaticProducts() {
        // comprueba si se encuentra la Categoría movil en BD
        EntityManager entityManager = GestorEntityManager.getEntityManager();
        Categoria catMovil = entityManager.find(Categoria.class, "Movil");
        entityManager.close();

        if (catMovil == null) {
            throw new RuntimeException("no se encuentra la categoría movil en BD");
        }

        List<Producto> lstProductos = new ArrayList<>();

        lstProductos.add(new Producto("SamsungGS23", "Samsung", "Galaxy S23", "imagenes/1473-samsung-galaxy-s23-256gb-algodon-libre-cargador-25w.webp", "256GB Algodón Libre + cargador 25W",
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
                new GregorianCalendar(2023, 0, 1).getTime(), new BigDecimal("749"),
                catMovil));

        lstProductos.add(new Producto("SamsungGA54", "Samsung", "Galaxy A54", "imagenes/1904-samsung-galaxy-a54-5g-8-128gb-negro-libre-protector-pantalla.webp", "5G 8/256GB Negro Libre + Protector Pantalla",
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
                new GregorianCalendar(2023, 5, 1).getTime(), new BigDecimal("469.01"),
                catMovil));

        lstProductos.add(new Producto("OppoFX5", "Oppo", "Find X5", "imagenes/1131-oppo-find-x5-5g-8-256gb-blanco-libre-cable-usb-31-type-c.webp", "5G 8/256GB Blanco Libre + Cable USB 3.1 Type-C",
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
                new GregorianCalendar(2023, 10, 1).getTime(), new BigDecimal("954.99"),
                catMovil));

        lstProductos.add(new Producto("SamsungGZF5", "Samsung", "Galaxy Z Fold5", "imagenes/1593-samsung-galaxy-z-fold5-12-512gb-azul-glaciar-cargador-de-pared-25w-foto.webp", "12/512GB Azul Glaciar + Cargador de Pared 25W",
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
                new GregorianCalendar(2023, 7, 12).getTime(), new BigDecimal("2029.90"),
                catMovil));

        return lstProductos;
    }

}
