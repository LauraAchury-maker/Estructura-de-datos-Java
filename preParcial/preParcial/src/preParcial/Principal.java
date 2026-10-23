package preParcial;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Laura Camila Achury Castro
 * Daniel Galeano
 */
public class Principal {

    public static void main(String[] args) {
        // Crear la lista de carros:
        ArrayList<Carro> listaCarro = new ArrayList<>();
        listaCarro.add(new Carro("Toyota", "Corolla", "ABC123", 85000000, "Sedan", 2022));
        listaCarro.add(new Carro("Mazda", "CX-5", "DEF456", 125000000, "SUV", 2023));
        listaCarro.add(new Carro("Chevrolet", "Onix", "GHI789", 72000000, "Sedan", 2021));
        listaCarro.add(new Carro("Ford", "Ranger", "JKL321", 145000000, "Camioneta", 2024));
        listaCarro.add(new Carro("BMW", "M3", "MNO654", 280000000, "Deportivo", 2023));
        listaCarro.add(new Carro("Renault", "Duster", "PQR987", 98000000, "SUV", 2022));
        listaCarro.add(new Carro("Kia", "Picanto", "STU741", 55000000, "Hatchback", 2020));
        listaCarro.add(new Carro("Volkswagen", "Jetta", "VWX852", 110000000, "Sedan", 2024));
        
        //Creamos el menu
        
        String m = """
                   ================================
                          CONCESIONARIO CARRO
                   ================================
                   
                   
                   1. Mostrar todos los carros
                   
                   2. Buscar carro por placa
                   
                   3. Mostrar carros por tipo
                   
                   4. Mostrar carros dentro de un rango de precio
                   
                   5. Agregar carro
                   
                   6. Eliminar carro
                   
                   7. Modificar precio
                   
                   8. Mostrar carro más costoso
                   9. Salir
                   
                   Seleccione una opción:
                   """;
        
        while(true){
        try {
            int op = Integer.parseInt(JOptionPane.showInputDialog(m));
            if(op == 9){
                JOptionPane.showMessageDialog(null, "Fin del programa, vuelve pronto :D");
                break;
            }
            switch(op){
                case 1 -> JOptionPane.showMessageDialog(null, (getPlaca(listaCarro)));
                case 2 -> buscarPorPlaca(listaCarro);
                case 3 -> mostrarPorTipo(listaCarro);
                //Precio mínimo: 80_000_000
                //Precio máximo: 130_000_000
                case 4 -> mostrarPorRangoPrecio(listaCarro);
                case 5 -> agregarCarro(listaCarro);
                case 6 -> eliminarCarro(listaCarro);
                case 7 -> modificarCarro(listaCarro); 
                case 8 -> mostrarMasCostoso(listaCarro);
                default -> JOptionPane.showMessageDialog(null, "Opcion no valida");
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error: Ingrese un numero del 1 al 9");
        }
    } 
}
    
    public static void agregarCarro(ArrayList<Carro> info){
        String marca = JOptionPane.showInputDialog("Marca del carro: ");
        String modelo = JOptionPane.showInputDialog("Modelo del carro: ");
        String placa = JOptionPane.showInputDialog("Placa del carro a registrar: ");
        String precio = JOptionPane.showInputDialog("Precio del carro: ");
        String tipo = JOptionPane.showInputDialog("Tipo de carro: ");
        String anio = JOptionPane.showInputDialog("Anio del carro: ");
        try{
            info.add(new Carro(marca,
                                modelo,
                                placa,
                                Double.parseDouble(precio),
                                tipo,
                                Integer.parseInt(anio)
                                ));
            JOptionPane.showMessageDialog(null, "Carro creado con exito :o.");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al crear al carrito :(");
        }
    }
    
    public static String getPlaca(ArrayList<Carro> info){
        String txt =  "\tLista de Carros por placa: \n";
        int num = 1;
        for(Carro car : info){
            txt += num + ". " + car.getPlaca() +"\n";
            num++; //Aumentamos de 1 a 1 la lista
        }
        return txt;
    }
    
    public static void eliminarCarro(ArrayList<Carro> info){
        int index = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la placa del carro a eliminar:\n"
                                                + getPlaca(info)));
        try{
            int decision = JOptionPane.showConfirmDialog(null, 
                    "Estas seguro de eliminar a: \n" + info.get(index).toString());
            if(decision == JOptionPane.OK_OPTION){
                info.remove(index);
                JOptionPane.showMessageDialog(null, "Carro eliminado correctamente");
            }else{
                JOptionPane.showMessageDialog(null, "Operacion abortada");
            }
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: No se pudo eliminar al carro.");
        }
    }
    
    public static void modificarCarro(ArrayList<Carro> info) {

    String placaBuscar = JOptionPane.showInputDialog("Ingrese la placa del carro que desea modificar:");

    for (Carro carro : info) {

        if (carro.getPlaca().equalsIgnoreCase(placaBuscar)) {

            String marca = JOptionPane.showInputDialog("Ingrese la nueva marca:");
            String modelo = JOptionPane.showInputDialog("Ingrese el nuevo modelo:");
            String nuevaPlaca = JOptionPane.showInputDialog("Ingrese la nueva placa:");
            String precio = JOptionPane.showInputDialog("Ingrese el nuevo precio:");
            String tipo = JOptionPane.showInputDialog("Ingrese el nuevo tipo:");
            String anio = JOptionPane.showInputDialog("Ingrese el nuevo año:");

            try {

                carro.setMarca(marca);
                carro.setModelo(modelo);
                carro.setPlaca(nuevaPlaca);
                carro.setPrecio(Double.parseDouble(precio));
                carro.setTipo(tipo);
                carro.setAnio(Integer.parseInt(anio));

                JOptionPane.showMessageDialog(null, "Carro modificado con éxito :o");

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, "Error al modificar el carro :(");
            }

            return;
        }
    }

    JOptionPane.showMessageDialog(null, "No se encontró un carro con esa placa :(");
}
    
    public static void buscarPorPlaca(ArrayList<Carro> info) {

    String placa = JOptionPane.showInputDialog("Ingrese la placa que desea buscar:");

    for (Carro carro : info) {

        if (carro.getPlaca().equalsIgnoreCase(placa)) {

            JOptionPane.showMessageDialog(null,
                    "Carro encontrado:\n" + carro.toString());

            return;
        }
    }

    JOptionPane.showMessageDialog(null,
            "No se encontró un carro con esa placa :(");
}
    
    public static void mostrarPorTipo(ArrayList<Carro> info) {

    String tipoBuscar = JOptionPane.showInputDialog(
            "Ingrese el tipo de carro que desea buscar:"
    );

    String txt = "Carros de tipo " + tipoBuscar + ":\n\n";
    boolean encontrado = false;

    for (Carro carro : info) {

        if (carro.getTipo().equalsIgnoreCase(tipoBuscar)) {

            txt += carro.toString() + "\n";
            encontrado = true;
        }
    }

    if (encontrado) {
        JOptionPane.showMessageDialog(null, txt);
    } else {
        JOptionPane.showMessageDialog(null,
                "No se encontraron carros de ese tipo :(");
    }
}
    
    public static void mostrarPorRangoPrecio(ArrayList<Carro> info) {

    try {
        double minimo = Double.parseDouble(
                JOptionPane.showInputDialog("Ingrese el precio mínimo:")
        );
        double maximo = Double.parseDouble(
                JOptionPane.showInputDialog("Ingrese el precio máximo:")
        );
        String txt = "Carros entre $" + minimo + " y $" + maximo + ":\n\n";
        boolean encontrado = false;
        for (Carro carro : info) {
            if (carro.getPrecio() >= minimo &&
                carro.getPrecio() <= maximo) {

                txt += carro.toString() + "\n";
                encontrado = true;
            }
        }
        if (encontrado) {

            JOptionPane.showMessageDialog(null, txt);
        } else {

            JOptionPane.showMessageDialog(null,
                    "No hay carros dentro de ese rango de precio.");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,
                "Error: ingrese precios válidos.");
    }
}
    
    public static void mostrarMasCostoso(ArrayList<Carro> info) {

    if (info.isEmpty()) {

        JOptionPane.showMessageDialog(null,
                "No hay carros registrados.");

        return;
    }

    Carro masCostoso = info.get(0);

    for (Carro carro : info) {

        if (carro.getPrecio() > masCostoso.getPrecio()) {

            masCostoso = carro;
        }
    }

    JOptionPane.showMessageDialog(null,
            "El carro más costoso es:\n\n" + masCostoso.toString());
}
    
}
