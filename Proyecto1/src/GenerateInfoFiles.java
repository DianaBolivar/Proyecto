import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateInfoFiles {
    
    private static final String VENTAS_DIR = "ventas/";
    private static final String ARCHIVO_VENDEDORES = "vendedores.txt";
    private static final String ARCHIVO_PRODUCTOS = "productos.txt";
    
    public static void main(String[] args) {
        new File(VENTAS_DIR).mkdirs(); // Crear carpeta si no existe

        createSalesManInfoFile(5);  // Generar 5 vendedores
        createProductsFile(10);  // Generar 10 productos
        
        for (int i = 1; i <= 5; i++) {
            createSalesMenFile(3, "Vendedor" + i, 1000 + i);
        }

        System.out.println("Archivos generados exitosamente.");
    }

    // Método para generar un archivo de vendedores
    public static void createSalesManInfoFile(int salesmanCount) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_VENDEDORES))) {
            for (int i = 1; i <= salesmanCount; i++) {
                writer.write("CC;1000" + i + ";Vendedor" + i + ";Apellido" + i);
                writer.newLine();
            }
            System.out.println("Archivo de vendedores generado.");
        } catch (IOException e) {
            System.err.println("Error al generar el archivo de vendedores: " + e.getMessage());
        }
    }

    // Método para generar un archivo de productos
    public static void createProductsFile(int productsCount) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_PRODUCTOS))) {
            Random rand = new Random();
            for (int i = 1; i <= productsCount; i++) {
                int precio = rand.nextInt(100) + 10;  // Precio aleatorio entre 10 y 110
                writer.write(i + ";Producto" + i + ";" + precio);
                writer.newLine();
            }
            System.out.println("Archivo de productos generado.");
        } catch (IOException e) {
            System.err.println("Error al generar el archivo de productos: " + e.getMessage());
        }
    }

    // Método para generar archivos de ventas por vendedor
    public static void createSalesMenFile(int randomSalesCount, String name, long id) {
        String filename = VENTAS_DIR + "ventas_" + id + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("CC;" + id);
            writer.newLine();

            Random rand = new Random();
            for (int i = 1; i <= randomSalesCount; i++) {
                int productID = rand.nextInt(10) + 1;  // IDs de productos entre 1 y 10
                int quantity = rand.nextInt(5) + 1;  // Cantidad entre 1 y 5
                writer.write(productID + ";" + quantity + ";");
                writer.newLine();
            }
            System.out.println("Archivo de ventas generado para: " + name);
        } catch (IOException e) {
            System.err.println("Error al generar archivo de ventas: " + e.getMessage());
        }
    }
}