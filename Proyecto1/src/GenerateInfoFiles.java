import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateInfoFiles {

    private static final String VENTAS_DIR = "ventas/";
    private static final String ARCHIVO_VENDEDORES = VENTAS_DIR + "vendedores.txt";
    private static final String ARCHIVO_PRODUCTOS = VENTAS_DIR + "productos.txt";

    public static void main(String[] args) {
        try {
            // Crear la carpeta de ventas si no existe
            new File(VENTAS_DIR).mkdirs();

            // Generar archivos de prueba dentro de la carpeta ventas
            createSalesManInfoFile(5); // Genera 5 vendedores
            createProductsFile(10);    // Genera 10 productos

            // Generar archivos de ventas para cada vendedor dentro de la carpeta ventas
            for (int i = 1; i <= 5; i++) {
                createSalesMenFile(3, "Vendedor" + i, 1000 + i);
            }

            System.out.println("✅ Archivos generados exitosamente en la carpeta 'ventas/'.");

        } catch (Exception e) {
            System.err.println("❌ Error en la generación de archivos: " + e.getMessage());
        }
    }

    // Método para generar un archivo con información de vendedores dentro de la carpeta ventas
    public static void createSalesManInfoFile(int salesmanCount) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_VENDEDORES))) {
            for (int i = 1; i <= salesmanCount; i++) {
                writer.write("CC;1000" + i + ";Vendedor" + i + ";Apellido" + i);
                writer.newLine();
            }
            System.out.println("✔ Archivo de vendedores generado en 'ventas/'.");
        } catch (IOException e) {
            System.err.println("❌ Error al generar el archivo de vendedores: " + e.getMessage());
        }
    }

    // Método para generar un archivo con información de productos dentro de la carpeta ventas
    public static void createProductsFile(int productsCount) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_PRODUCTOS))) {
            Random rand = new Random();
            for (int i = 1; i <= productsCount; i++) {
                int precio = rand.nextInt(100) + 10; // Precio entre 10 y 110
                writer.write(i + ";Producto" + i + ";" + precio);
                writer.newLine();
            }
            System.out.println("✔ Archivo de productos generado en 'ventas/'.");
        } catch (IOException e) {
            System.err.println("❌ Error al generar el archivo de productos: " + e.getMessage());
        }
    }

    // Método para generar archivos de ventas por vendedor dentro de la carpeta ventas
    public static void createSalesMenFile(int randomSalesCount, String name, long id) {
        String filename = VENTAS_DIR + "ventas_" + id + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("CC;" + id);
            writer.newLine();

            Random rand = new Random();
            for (int i = 1; i <= randomSalesCount; i++) {
                int productID = rand.nextInt(10) + 1; // IDs de productos entre 1 y 10
                int quantity = rand.nextInt(5) + 1;   // Cantidad entre 1 y 5
                writer.write(productID + ";" + quantity + ";");
                writer.newLine();
            }
            System.out.println("✔ Archivo de ventas generado para " + name + " en 'ventas/'.");
        } catch (IOException e) {
            System.err.println("❌ Error al generar archivo de ventas: " + e.getMessage());
        }
    }
}