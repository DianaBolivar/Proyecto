import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GenerateInfoFiles {

    public static void main(String[] args) {
        String ruta = "./origen/";
        new File(ruta).mkdirs();

        generarProductos(ruta);
        generarVendedores(ruta);
        generarVentas(ruta);

        System.out.println("Archivos generados correctamente en la carpeta 'origen'.");
    }

    private static void generarProductos(String ruta) {
        String[] productos = {
            "PROD001;Zapatos Premium HP;689.08",
            "PROD002;Camiseta Clásica Dell;844.47",
            "PROD003;Teléfono Económico Dell;420.72",
            "PROD004;Teléfono Premium Samsung;620.66",
            "PROD005;Camiseta Económica Nike;793.58",
            "PROD006;Libro Profesional Dell;447.45",
            "PROD007;Mochila Económica Dell;495.72",
            "PROD008;Camiseta Premium Adidas;630.25",
            "PROD009;Portátil Clásico Apple;522.64",
            "PROD010;Zapatos Premium Dell;338.02",
            "PROD011;Teléfono Clásico Adidas;520.41",
            "PROD012;Zapatos Deportivo HP;19.58",
            "PROD013;Mochila Inteligente manzana;701.60",
            "PROD014;Camiseta Premium Nike;716.10",
            "PROD015;Mochila Profesional Adidas;79.93"
        };
        escribirArchivo(ruta + "productos.csv", productos);
    }

    private static void generarVendedores(String ruta) {
        String[] vendedores = {
            "CC;0202896573;Juan Pablo;Vargas Rojas",
            "CC;0742938029;Juan Pablo;Martínez González",
            "CC;0499730297;José Antonio;Rodríguez Pérez",
            "CC;0683803308;Carlos Andrés;Gómez Mendoza",
            "CC;0271331727;Laura Beatriz;Martínez González",
            "CC;0006918515;Sofía Alejandra;García López",
            "CC;0660056026;Luis Fernando;Morales Suárez",
            "CC;0868116935;Juan Pablo;Martínez González",
            "CC;0391382060;Sofía Alejandra;Rodríguez Pérez",
            "CC;0643971799;Carmen Rosa;Martínez González"
        };
        escribirArchivo(ruta + "vendedores.csv", vendedores);
    }

    private static void generarVentas(String ruta) {
        String[] ventas = {
            "ID_VENTA;FECHA;NUM_DOCUMENTO_VENDEDOR;ID_PRODUCTO;CANTIDAD;VALOR_TOTAL",
            "V00001;2025-03-18;0068063262;PROD004;6;922.48",
            "V00002;2025-03-16;0765707913;PROD009;9;7226.84",
            "V00003;2025-03-16;0629201171;PROD011;5;828.51",
            "V00004;2025-03-07;0150346690;PROD004;2;1101.81",
            "V00005;2025-03-08;0674763920;PROD015;1;14.58",
            "V00006;2025-03-03;0179197040;PROD005;6;1684.48",
            "V00007;2025-03-03;0544384906;PROD005;2;1249.18",
            "V00008;2025-03-19;0826606362;PROD014;10;7881.99",
            "V00009;2025-02-24;0839609842;PROD006;9;7046.94",
            "V00010;2025-03-20;0685722708;PROD015;1;178.40",
            "V00011;2025-03-16;0235281014;PROD006;2;103.47",
            "V00012;2025-03-20;0414983304;PROD001;5;2375.01",
            "V00013;2025-03-11;0764878815;PROD015;9;4497.42",
            "V00014;2025-03-04;0462943844;PROD003;1;807.30",
            "V00015;2025-03-03;0893465616;PROD007;1;260.42",
            "V00016;2025-03-08;0470191598;PROD005;8;3829.53",
            "V00017;2025-03-17;0614539937;PROD011;9;3458.00",
            "V00018;2025-03-13;0622806569;PROD001;2;75.36",
            "V00019;2025-03-19;0670876959;PROD015;10;5933.41",
            "V00020;2025-03-08;0566269291;PROD007;10;2270.23"
        };
        escribirArchivo(ruta + "ventas.csv", ventas);
    }

    private static void escribirArchivo(String nombreArchivo, String[] lineas) {
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            for (String linea : lineas) {
                writer.write(linea + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error escribiendo archivo " + nombreArchivo + ": " + e.getMessage());
        }
    }
} 
