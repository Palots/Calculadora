import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class interfaz {

    private static JTextField camponum1;
    private static JTextField camponum2;
    private static JTextField campoActivo;

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

        camponum1 = new JTextField();
        camponum1.setBounds(99, 150, 132, 21);
        ventana.add(camponum1);

        JLabel etiquetanum2 = new JLabel("INGRESE EL NUMERO 2");
        etiquetanum2.setBounds(510, 80, 200, 100);
        ventana.add(etiquetanum2);

        camponum2 = new JTextField();
        camponum2.setBounds(510, 150, 132, 21);
        ventana.add(camponum2);

        // Panel para los botones numéricos
        JPanel panelNumeros = new JPanel();
        panelNumeros.setBounds(270, 250, 200, 250); // Ajusta el tamaño según sea necesario
        panelNumeros.setLayout(new GridLayout(4, 3, 5, 5)); // 4x3 grid con espacio

        // Crear botones del 1 al 9
        for (int i = 1; i <= 9; i++) {
            JButton boton = new JButton(String.valueOf(i));
            boton.addActionListener(new NumberButtonListener());
            panelNumeros.add(boton);
        }

        // Botón 0
        JButton boton0 = new JButton("0");
        boton0.addActionListener(new NumberButtonListener());
        panelNumeros.add(boton0);

        // Botón de borrar
        JButton botonBorrar = new JButton("←"); // Usar un símbolo de flecha hacia la izquierda para borrar
        botonBorrar.addActionListener(new DeleteButtonListener());
        panelNumeros.add(botonBorrar);

        ventana.add(panelNumeros);

        // Mover el JComboBox hacia abajo para evitar que quede muy cerca de los números
        String[] opcion = {"SELECCIONE UNA OPCION", "sumar", "restar", "dividir", "multiplicar"};
        JComboBox<String> combo1 = new JComboBox<>(opcion);
        combo1.setBounds(270, 520, 180, 50); // Ajustar el valor de Y (520) para moverlo hacia abajo
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

        // Establecer el campo activo inicial
        campoActivo = camponum1;

        // Botones para seleccionar el campo activo
        JButton botonCampo1 = new JButton("Número 1");
        botonCampo1.setBounds(99, 180, 132, 30);
        botonCampo1.addActionListener(e -> campoActivo = camponum1);
        ventana.add(botonCampo1);

        JButton botonCampo2 = new JButton("Número 2");
        botonCampo2.setBounds(510, 180, 132, 30);
        botonCampo2.addActionListener(e -> campoActivo = camponum2);
        ventana.add(botonCampo2);

        ventana.setVisible(true);
    }

    private static class NumberButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            String number = source.getText();
            campoActivo.setText(campoActivo.getText() + number);
        }
    }

    private static class DeleteButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String text = campoActivo.getText();
            if (text.length() > 0) {
                campoActivo.setText(text.substring(0, text.length() - 1));
            }
        }
    }
}
