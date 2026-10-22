package Actividad3_POO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La clase CalculadoraEventos modela una calculadora básica utilizando
 * la gestión de eventos con múltiples botones e implementando ActionListener.
 */
public class CalculadoraEventos extends JFrame implements ActionListener {
    
    // Componentes visuales de la ventana
    private JLabel lblTitulo;
    private JLabel lblNum1;
    private JLabel lblNum2;
    private JTextField txtNum1;
    private JTextField txtNum2;
    
    // Botones para las operaciones aritméticas
    private JButton btnSumar;
    private JButton btnRestar;
    private JButton btnMultiplicar;
    private JButton btnDividir;
    
    // Etiqueta para mostrar el resultado
    private JLabel lblResultado;

    /**
     * Constructor para configurar la ventana y registrar los eventos de los botones.
     */
    public CalculadoraEventos() {
        // 1. Configuración básica de la ventana
        setTitle("Ejercicio Propuesto 8.3 - Calculadora con Eventos");
        setSize(400, 330);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); // Diseño absoluto por coordenadas (x, y, ancho, alto)

        // 2. Título principal
        lblTitulo = new JLabel("Calculadora de Operaciones Aritméticas");
        lblTitulo.setBounds(70, 20, 260, 25);
        add(lblTitulo);

        // 3. Primer número
        lblNum1 = new JLabel("Número 1:");
        lblNum1.setBounds(30, 70, 90, 25);
        add(lblNum1);

        txtNum1 = new JTextField();
        txtNum1.setBounds(130, 70, 200, 25);
        add(txtNum1);

        // 4. Segundo número
        lblNum2 = new JLabel("Número 2:");
        lblNum2.setBounds(30, 110, 90, 25);
        add(lblNum2);

        txtNum2 = new JTextField();
        txtNum2.setBounds(130, 110, 200, 25);
        add(txtNum2);

        // 5. Creación de los Botones de Operación
        btnSumar = new JButton("Sumar");
        btnSumar.setBounds(30, 160, 130, 30);
        add(btnSumar);

        btnRestar = new JButton("Restar");
        btnRestar.setBounds(180, 160, 130, 30);
        add(btnRestar);

        btnMultiplicar = new JButton("Multiplicar");
        btnMultiplicar.setBounds(30, 200, 130, 30);
        add(btnMultiplicar);

        btnDividir = new JButton("Dividir");
        btnDividir.setBounds(180, 200, 130, 30);
        add(btnDividir);

        // 6. Etiqueta de resultado
        lblResultado = new JLabel("Resultado: ");
        lblResultado.setBounds(30, 260, 320, 25);
        add(lblResultado);

        // --- REGISTRO DE EVENTOS ---
        // Conectamos cada uno de los 4 botones al oyente (this)
        btnSumar.addActionListener(this);
        btnRestar.addActionListener(this);
        btnMultiplicar.addActionListener(this);
        btnDividir.addActionListener(this);
    }

    /**
     * Este método se ejecuta automáticamente al hacer clic en CUALQUIERA de los botones.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // Convertimos el texto ingresado en los JTextField a números reales (double)
            double n1 = Double.parseDouble(txtNum1.getText());
            double n2 = Double.parseDouble(txtNum2.getText());
            double resultado = 0;

            // Usamos e.getSource() para identificar exactamente qué botón originó el evento
            if (e.getSource() == btnSumar) {
                resultado = n1 + n2;
                lblResultado.setText("Resultado de la Suma: " + resultado);
            } 
            else if (e.getSource() == btnRestar) {
                resultado = n1 - n2;
                lblResultado.setText("Resultado de la Resta: " + resultado);
            } 
            else if (e.getSource() == btnMultiplicar) {
                resultado = n1 * n2;
                lblResultado.setText("Resultado de la Multiplicación: " + resultado);
            } 
            else if (e.getSource() == btnDividir) {
                // Validación para evitar la división por cero
                if (n2 != 0) {
                    resultado = n1 / n2;
                    lblResultado.setText("Resultado de la División: " + resultado);
                } else {
                    lblResultado.setText("Error: No se puede dividir entre cero.");
                }
            }
            
        } catch (NumberFormatException ex) {
            // Controla el error si el usuario deja campos vacíos o escribe letras
            lblResultado.setText("Error: Por favor ingrese números válidos.");
        }
    }

    /**
     * Método principal (main) para ejecutar la aplicación.
     */
    public static void main(String[] args) {
        CalculadoraEventos ventana = new CalculadoraEventos();
        ventana.setVisible(true);
    }
}