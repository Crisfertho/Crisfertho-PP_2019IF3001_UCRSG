package JPS;

import java.awt.*;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Main extends JFrame {
    private TablaHash tablaHash;

    private JPanel panelPrincipal;

    // Definimos colores para los temas
    private HashMap<String, Color[]> temas;

    public Main() {
        tablaHash = new TablaHash(100); // Inicializamos la tabla hash
        setTitle("Sistema de Premios - Futurista");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Configurar temas
        configurarTemas();

        panelPrincipal = new JPanel(new BorderLayout());
        setContentPane(panelPrincipal);

        // Menú de opciones
        JMenuBar menuBar = new JMenuBar();
        JMenu menuOpciones = new JMenu("Opciones");
        JMenuItem temaClaro = new JMenuItem("Tema Claro");
        JMenuItem temaOscuro = new JMenuItem("Tema Oscuro");
        JMenuItem temaAzul = new JMenuItem("Tema Azul");
      

        temaClaro.addActionListener(e -> cambiarTema("Claro"));
        temaOscuro.addActionListener(e -> cambiarTema("Oscuro"));
        temaAzul.addActionListener(e -> cambiarTema("Azul"));
       

        menuOpciones.add(temaClaro);
        menuOpciones.add(temaOscuro);
        menuOpciones.add(temaAzul);
        
        menuBar.add(menuOpciones);
        setJMenuBar(menuBar);

        // Configurar panel con pestañas
        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Insertar Premio", crearPanelInsertar());
        tabs.addTab("Buscar Premio", crearPanelBuscar());
        tabs.addTab("Mostrar Tabla", crearPanelMostrar());

        panelPrincipal.add(tabs, BorderLayout.CENTER);

        // Aplicar tema por defecto
        cambiarTema("Claro");
    }

    private void configurarTemas() {
        temas = new HashMap<>();
        temas.put("Claro", new Color[]{Color.WHITE, Color.BLACK});
        temas.put("Oscuro", new Color[]{new Color(34, 34, 34), Color.WHITE});
        temas.put("Azul", new Color[]{new Color(173, 216, 230), Color.BLACK});
    }

    private void cambiarTema(String nombreTema) {
        Color[] colores = temas.get(nombreTema);
        if (colores != null) {
            Color fondo = colores[0];
            Color texto = colores[1];
            panelPrincipal.setBackground(fondo);
            actualizarColores(panelPrincipal, fondo, texto);
            SwingUtilities.updateComponentTreeUI(this);
        }
    }

    private void actualizarColores(Container contenedor, Color fondo, Color texto) {
        for (Component componente : contenedor.getComponents()) {
            componente.setBackground(fondo);
            componente.setForeground(texto);

            if (componente instanceof JButton) {
                componente.setBackground(fondo.darker());
                componente.setForeground(texto);
            }

            if (componente instanceof Container) {
                actualizarColores((Container) componente, fondo, texto);
            }
        }
    }

    private JPanel crearPanelInsertar() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 10, 10));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel lblNumero = new JLabel("Número (0-99):");
        JTextField txtNumero = new JTextField();

        JLabel lblSerie = new JLabel("Serie (000-999):");
        JTextField txtSerie = new JTextField();

        JLabel lblProvincia = new JLabel("Provincia:");
        JComboBox<String> comboProvincia = new JComboBox<>(new String[]{
                "San José", "Alajuela", "Cartago", "Heredia", "Guanacaste", "Puntarenas", "Limón"
        });

        JLabel lblAño = new JLabel("Año:");
        JTextField txtAño = new JTextField();

        JButton btnInsertar = new JButton("Insertar");
        btnInsertar.setFocusPainted(false);
        btnInsertar.addActionListener(e -> {
            try {
                int numero = Integer.parseInt(txtNumero.getText());
                int serie = Integer.parseInt(txtSerie.getText());
                String provincia = (String) comboProvincia.getSelectedItem();
                int año = Integer.parseInt(txtAño.getText());

                Premio nuevoPremio = new Premio(numero, serie, provincia, año);
                tablaHash.insertar(nuevoPremio);
                JOptionPane.showMessageDialog(this, "Premio insertado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Datos inválidos. Verifique los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        panel.add(lblNumero);
        panel.add(txtNumero);
        panel.add(lblSerie);
        panel.add(txtSerie);
        panel.add(lblProvincia);
        panel.add(comboProvincia);
        panel.add(lblAño);
        panel.add(txtAño);
        panel.add(new JLabel());
        panel.add(btnInsertar);

        return panel;
    }

    private JPanel crearPanelBuscar() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        JLabel lblNumero = new JLabel("Número:");
        JTextField txtNumero = new JTextField();
        JLabel lblSerie = new JLabel("Serie:");
        JTextField txtSerie = new JTextField();

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setFocusPainted(false);

        JTextArea txtResultado = new JTextArea();
        txtResultado.setEditable(false);
        txtResultado.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        txtResultado.setFont(new Font("Monospaced", Font.PLAIN, 14));

        btnBuscar.addActionListener(e -> {
            try {
                int numero = Integer.parseInt(txtNumero.getText());
                int serie = Integer.parseInt(txtSerie.getText());

                Premio premio = tablaHash.buscar(numero, serie);
                if (premio != null) {
                    txtResultado.setText("Premio encontrado:\n" + premio.toString());
                } else {
                    txtResultado.setText("No se encontró el premio.");
                }
            } catch (NumberFormatException ex) {
                txtResultado.setText("Datos inválidos.");
            }
        });

        inputPanel.add(lblNumero);
        inputPanel.add(txtNumero);
        inputPanel.add(lblSerie);
        inputPanel.add(txtSerie);
        inputPanel.add(new JLabel());
        inputPanel.add(btnBuscar);

        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(new JScrollPane(txtResultado), BorderLayout.CENTER);

        return panel;
    }

    private JPanel crearPanelMostrar() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JButton btnMostrar = new JButton("Mostrar Tabla");
        btnMostrar.setFocusPainted(false);

        JTextArea txtTabla = new JTextArea();
        txtTabla.setEditable(false);
        txtTabla.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        txtTabla.setFont(new Font("Monospaced", Font.PLAIN, 14));

        btnMostrar.addActionListener(e -> txtTabla.setText(tablaHash.mostrarTabla()));

        panel.add(btnMostrar, BorderLayout.NORTH);
        panel.add(new JScrollPane(txtTabla), BorderLayout.CENTER);

        return panel;
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main frame = new Main();
            frame.setVisible(true);
        });
    }
}