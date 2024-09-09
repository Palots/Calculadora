import javax.swing.JOptionPane;

public class Calculadora {
    public static void main(String[] args) {
        // Mostrar mensaje de bienvenida
        JOptionPane.showMessageDialog(null, "Bienvenido a mi calculadora");

        // Pedir el nombre del usuario
        String nombre = JOptionPane.showInputDialog("Ingrese su nombre");

        // Saludar al usuario
        JOptionPane.showMessageDialog(null, "Hola " + nombre + ", estás en la calculadora");

        // Confirmar si el usuario desea continuar
        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea continuar?");

        if (opcion == JOptionPane.YES_OPTION) {
            System.out.println("El usuario sí desea continuar");

            // Pedir el primer número al usuario
            String input1 = JOptionPane.showInputDialog("Ingrese el primer número");
            double num1 = Double.parseDouble(input1);  // Convertir el número ingresado

            // Mostrar menú de operaciones
            String[] opciones = {"Sumar", "Restar", "Multiplicar", "Dividir"};
            int seleccion = JOptionPane.showOptionDialog(null, "Seleccione una operación", 
                                                         "Menú de Operaciones", 
                                                         JOptionPane.DEFAULT_OPTION, 
                                                         JOptionPane.INFORMATION_MESSAGE, 
                                                         null, opciones, opciones[0]);

            // Pedir el segundo número si se selecciona una operación
            if (seleccion >= 0) {
                String input2 = JOptionPane.showInputDialog("Ingrese el segundo número");
                double num2 = Double.parseDouble(input2);
                double resultado = 0;

                switch (seleccion) {
                    case 0: // Sumar
                        resultado = num1 + num2;
                        break;
                    case 1: // Restar
                        resultado = num1 - num2;
                        break;
                    case 2: // Multiplicar
                        resultado = num1 * num2;
                        break;
                    case 3: // Dividir
                        if (num2 != 0) {
                            resultado = num1 / num2;
                        } else {
                            JOptionPane.showMessageDialog(null, "No se puede dividir entre cero");
                            return;
                        }
                        break;
                    default:
                        break;
                }

                // Mostrar el resultado en un JOptionPane
                JOptionPane.showMessageDialog(null, "El resultado es: " + resultado);
            }

        } else if (opcion == JOptionPane.NO_OPTION) {
            System.out.println("El usuario no desea continuar");
        } else if (opcion == JOptionPane.CANCEL_OPTION) {
            System.out.println("El usuario canceló la operación");
        }
    }
}
