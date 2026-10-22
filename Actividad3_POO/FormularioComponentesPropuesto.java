package Actividad3_POO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La clase FormularioComponentesPropuesto amplía el ejercicio 8.2 
 * incorporando nuevos componentes Swing (JComboBox, JCheckBox y botones funcionales).
 */
public class FormularioComponentesPropuesto extends JFrame {
    
    // Declaración de los componentes visuales
    private JLabel lblTitulo;
    private JLabel lblValor;
    private JTextField txtValor;
    private JLabel lblOpcion;
    private JComboBox<String> cmbOpciones;
    private JCheckBox chkActivo;
    private JButton btnProcesar;
    private JButton btnLimpiar;
    private JLabel lblResultado;

    /**
     * Constructor para inicializar la ventana y todos sus componentes.
     */
    public FormularioComponentesPropuesto() {
        // 1. Configuración básica de la ventana
        setTitle("Ejercicios Propuestos - Ejercicio 8.2");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); // Diseño absoluto por coordenadas (x, y, ancho, alto)

        // 2. Etiqueta de Título
        lblTitulo = new JLabel("Calculadora de Opciones Swing");
        lblTitulo.setBounds(110, 20, 250, 25);
        add(lblTitulo);

        // 3. Etiqueta y Campo de texto para ingresar números
        lblValor = new JLabel("Ingrese número:");
        lblValor.setBounds(30, 70, 120, 25);
        add(lblValor);

        txtValor = new JTextField();
        txtValor.setBounds(160, 70, 200, 25);
        add(txtValor);

        // 4. JComboBox (Menú desplegable propuesto)
        lblOpcion = new JLabel("Seleccione operación:");
        lblOpcion.setBounds(30, 110, 130, 25);
        add(lblOpcion);

        String[] operaciones = {"Doble", "Cuadrado", "Cubo"};
        cmbOpciones = new JComboBox<>(operaciones);
        cmbOpciones.setBounds(160, 110, 200, 25);
        add(cmbOpciones);

        // 5. JCheckBox (Casilla de verificación)
        chkActivo = new JCheckBox("Aplicar formato especial");
        chkActivo.setBounds(160, 150, 200, 25);
        add(chkActivo);

        // 6. Botón de Procesar
        btnProcesar = new JButton("Procesar");
        btnProcesar.setBounds(90, 200, 100, 30);
        add(btnProcesar);

        // 7. Botón de Limpiar (para reiniciar los campos)
        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(210, 200, 100, 30);
        add(btnLimpiar);

        // 8. Etiqueta para mostrar el resultado
        lblResultado = new JLabel("Resultado: ");
        lblResultado.setBounds(30, 250, 380, 25);
        add(lblResultado);

        // --- LÓGICA DE LOS BOTONES (EVENTOS BÁSICOS) ---
        
        // Evento para el botón Procesar
        btnProcesar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Convertimos el texto ingresado a número
                    double val = Double.parseDouble(txtValor.getText());
                    String seleccion = (String) cmbOpciones.getSelectedItem();
                    double res = 0;

                    // Evaluamos qué operación eligió el usuario en el JComboBox
                    if (seleccion.equals("Doble")) {
                        res = val * 2;
                    } else if (seleccion.equals("Cuadrado")) {
                        res = val * val;
                    } else if (seleccion.equals("Cubo")) {
                        res = val * val * val;
                    }

                    // Verificamos si el JCheckBox está marcado
                    String extra = chkActivo.isSelected() ? " (Especial activo)" : "";
                    
                    // Mostramos el resultado en la etiqueta
                    lblResultado.setText("Resultado: " + res + extra);
                    
                } catch (NumberFormatException ex) {
                    // Manejo de error por si escriben letras en vez de números
                    lblResultado.setText("Error: Por favor ingrese un número válido.");
                }
            }
        });

        // Evento para el botón Limpiar
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtValor.setText("");
                cmbOpciones.setSelectedIndex(0);
                chkActivo.setSelected(false);
                lblResultado.setText("Resultado: ");
            }
        });
    }

    /**
     * Método principal (main) para ejecutar el programa.
     */
    public static void main(String[] args) {
        FormularioComponentesPropuesto ventana = new FormularioComponentesPropuesto();
        ventana.setVisible(true);
    }
}
