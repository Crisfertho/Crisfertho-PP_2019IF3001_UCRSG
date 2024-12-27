package SortBus_SA;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;



public class Menu extends JFrame {
	//Gui
	private JPanel contentPane;
	private JTextArea textArea = new JTextArea();
	
    //Agregaciones
	Producto po = new Producto();
	FacturaVentas pe = new FacturaVentas();
	FacturaCompras pa = new FacturaCompras();
	


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
   //Gui
	public Menu() {
		setTitle("SortBus S.A");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnIngresar = new JButton("Nuevo producto");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				po.setVisible(true);
				
			}
		});
		btnIngresar.setBounds(10, 21, 130, 23);
		contentPane.add(btnIngresar);
		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textArea.setText(po.muestra());
				
			}
		});
		btnMostrar.setBounds(10, 46, 130, 23);
		contentPane.add(btnMostrar);
		
		JButton btnQuick = new JButton("QuickSort");
		btnQuick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				textArea.setText(po.QuickSort(po.desorden, 0, po.desorden.size()-1));
				
			}
		});
		btnQuick.setBounds(10, 73, 130, 23);
		contentPane.add(btnQuick);
		
		//JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(268, 62, 137, 137);
		//contentPane.add(textArea);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(239, 19, 232, 260);
		contentPane.add(scrollPane);
		
		JButton btnFacturaVenta = new JButton("Factura venta");
		btnFacturaVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pe.setVisible(true);
				
			}
		});
		btnFacturaVenta.setBounds(10, 144, 130, 23);
		contentPane.add(btnFacturaVenta);
		
		JButton btnMostrar_1 = new JButton("Mostrar");
		btnMostrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(pe.muestra());
			}
		});
		btnMostrar_1.setBounds(10, 171, 130, 23);
		contentPane.add(btnMostrar_1);
		
		JButton btnInsercion = new JButton("Shell");
		btnInsercion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(pe.Shell(pe.Ventas));
			}
		});
		btnInsercion.setBounds(10, 199, 130, 23);
		contentPane.add(btnInsercion);
		
		JButton btnFacturaCompra = new JButton("Factura compra");
		btnFacturaCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				pa.setVisible(true);
			}
		});
		btnFacturaCompra.setBounds(10, 260, 130, 23);
		contentPane.add(btnFacturaCompra);
		
		JButton btnMostrar_2 = new JButton("Mostrar");
		btnMostrar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textArea.setText(pa.muestra());
			}
		});
		btnMostrar_2.setBounds(10, 286, 130, 23);
		contentPane.add(btnMostrar_2);
		
		JButton btnSeleccin = new JButton("Selecci\u00F3n");
		btnSeleccin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				pa.Insercion(pa.Compras, pa.Compras.size()-1);
			}
		});
		btnSeleccin.setBounds(10, 312, 130, 23);
		contentPane.add(btnSeleccin);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText(null);
			}
		});
		btnLimpiar.setBounds(267, 301, 89, 23);
		contentPane.add(btnLimpiar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(366, 301, 82, 23);
		contentPane.add(btnSalir);
	}
	
	
}
