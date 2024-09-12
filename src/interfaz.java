import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class interfaz {

    public static void main(String[] args) {

        JFrame ventana = new JFrame("BIENVENIDO A MI CALCULADORA");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(800, 800);
        ventana.setLayout(null);

        JLabel etiqueta = new JLabel("CALCULADORA UAM.", SwingConstants.CENTER);
        etiqueta.setBounds(270, 0, 200, 100);
        etiqueta.setFont(new Font("Arial", Font.PLAIN, 14));
        ventana.add(etiqueta);

        JLabel etiquetanum1 = new JLabel("INGRESE EL NUMERO 1");
        etiquetanum1.setBounds(100, 80, 200, 100);
        ventana.add(etiquetanum1);

        JTextField camponum1 = new JTextField();
        camponum1.setBounds(99, 150, 132, 21);
        ventana.add(camponum1);

        JLabel etiquetanum2 = new JLabel("INGRESE EL NUMERO 2");
        etiquetanum2.setBounds(510, 80, 200, 100);
        ventana.add(etiquetanum2);

        JTextField camponum2 = new JTextField();
        camponum2.setBounds(510, 150, 132, 21);
        ventana.add(camponum2);

        String[] opcion = {"SELECCIONE UNA OPCION", "sumar", "restar", "dividir", "multiplicar"};
        JComboBox<String> combo1 = new JComboBox<>(opcion);
        combo1.setBounds(270, 200, 180, 50);
        ventana.add(combo1);

        JButton botoncalcular = new JButton("CALCULAR");
        botoncalcular.setBounds(270, 650, 180, 50);
        ventana.add(botoncalcular);

        JLabel resultado = new JLabel("Resultado: ");
        resultado.setBounds(270, 700, 200, 50);
        ventana.add(resultado);

        // Acción del botón calcular
        botoncalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(camponum1.getText());
                    double num2 = Double.parseDouble(camponum2.getText());
                    String operacion = (String) combo1.getSelectedItem();
                    double resultadoOperacion = 0;

                    // Llamar a los métodos de la clase Calculadora según la operación seleccionada
                    switch (operacion) {
                        case "sumar":
                            resultadoOperacion = Calculadora.sumar(num1, num2);
                            break;
                        case "restar":
                            resultadoOperacion = Calculadora.restar(num1, num2);
                            break;
                        case "multiplicar":
                            resultadoOperacion = Calculadora.multiplicar(num1, num2);
                            break;
                        case "dividir":
                            resultadoOperacion = Calculadora.dividir(num1, num2);
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Seleccione una operación válida");
                            return;
                    }

                    // Mostrar el resultado
                    resultado.setText("Resultado: " + resultadoOperacion);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese números válidos");
                } catch (ArithmeticException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        ventana.setVisible(true);
    }
}
