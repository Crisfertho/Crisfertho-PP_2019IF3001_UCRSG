package SortBus_SA;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Producto extends JFrame {

	
   //Atributos
	public String nombre;
	public int codigo;
	public double precio;
	public int cantidadTotal;
	public int cantidadExistente;
	//arraylist para guardar los datos
	public ArrayList<Producto> desorden = new ArrayList<Producto>();
	//Gui
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldCodigo;
	private JTextField textFieldPrecio;
	private JTextField textFieldCantidad;
	private JTextField textField;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Producto frame = new Producto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Gui
	public Producto() {
		setTitle("Producto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Showcard Gothic", Font.PLAIN, 13));
		lblNombre.setBounds(10, 30, 64, 14);
		contentPane.add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setToolTipText("Ingrese el nombre");
		textFieldNombre.setBounds(71, 27, 107, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setFont(new Font("Showcard Gothic", Font.PLAIN, 13));
		lblCodigo.setBounds(10, 70, 64, 14);
		contentPane.add(lblCodigo);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setToolTipText("Ingrese el codigo");
		textFieldCodigo.setBounds(71, 67, 107, 20);
		contentPane.add(textFieldCodigo);
		textFieldCodigo.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Showcard Gothic", Font.PLAIN, 13));
		lblPrecio.setBounds(10, 111, 64, 14);
		contentPane.add(lblPrecio);
		
		textFieldPrecio = new JTextField();
		textFieldPrecio.setToolTipText("Ingrese el precio");
		textFieldPrecio.setBounds(71, 108, 107, 20);
		contentPane.add(textFieldPrecio);
		textFieldPrecio.setColumns(10);
		
		JLabel lblCantidadTotal = new JLabel("Cantidad total");
		lblCantidadTotal.setFont(new Font("Showcard Gothic", Font.PLAIN, 13));
		lblCantidadTotal.setBounds(188, 69, 129, 17);
		contentPane.add(lblCantidadTotal);
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.setToolTipText("Ingrese la cantidad");
		textFieldCantidad.setBounds(360, 67, 48, 20);
		contentPane.add(textFieldCantidad);
		textFieldCantidad.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Evita espacio vacios
				if (textFieldNombre.getText().isEmpty()  || textFieldCodigo.getText().isEmpty()  || 
						textFieldPrecio.getText().isEmpty()  || textFieldCantidad.getText().isEmpty() ) {
					
					JOptionPane.showMessageDialog(null, "Faltan datos..." , "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
				else {
					
					
				
				
				if(textFieldCodigo.getText().length() != 4) {//Codigo de 4 digitos
					JOptionPane.showMessageDialog(null, "Codigo debe ser de 4 digitos");
				}
				else {
				int conf = JOptionPane.showConfirmDialog(null, "Desea guardar los datos." , "Advertencia", JOptionPane.INFORMATION_MESSAGE);
				if(conf == JOptionPane.YES_OPTION) {
					
					Producto a = new Producto();
					a.setCodigo(Integer.parseInt(textFieldCodigo.getText()));
					a.setNombre(textFieldNombre.getText());
					a.setPrecio(Double.parseDouble(textFieldPrecio.getText()));
					a.setCantidadTotal(Integer.parseInt(textFieldCantidad.getText()));
					a.setCantidadExistente(Integer.parseInt(textField.getText()));
					//Guarda los datos
					desorden.add(a);
					
					textFieldCodigo.setText(null);
					textFieldNombre.setText(null);
					textFieldPrecio.setText(null);
					textFieldCantidad.setText(null);
					textField.setText(null);
					dispose();
					
				}
    else if (conf == JOptionPane.NO_OPTION){
					
				}
				}
				}
			}
		});
		btnAceptar.setBounds(171, 210, 89, 23);
		contentPane.add(btnAceptar);
		
		JLabel lblExistente = new JLabel("Cantidad existente");
		lblExistente.setFont(new Font("Showcard Gothic", Font.PLAIN, 13));
		lblExistente.setBounds(188, 30, 142, 14);
		contentPane.add(lblExistente);
		
		textField = new JTextField();
		textField.setBounds(360, 27, 48, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidadTotal() {
		return cantidadTotal;
	}

	public void setCantidadTotal(int cantidadTotal) {
		this.cantidadTotal = cantidadTotal;
	}

	public int getCantidadExistente() {
		return cantidadExistente;
	}

	public void setCantidadExistente(int cantidadExistente) {
		this.cantidadExistente = cantidadExistente;
	}
	
	public String muestra(){//muestra sin ordenar
		   String salida = "";
				
				if( !desorden.isEmpty()) {
				
				
					for (Producto p : desorden) {
					
					salida += ""
							+ p.toString();
				       } 
				}else {
					salida += "Lista vacia";
				}
					return salida;
			}
   //muestra ordenado por quicksort
	public String QuickSort(ArrayList<Producto> arreglo,int primero,int ultimo){
		int i,j,pivote;
		Producto aux;
		int pasadas = 0,intercambios = 0;
		i=primero;
		j=ultimo;
		pivote=arreglo.get((primero+ultimo)/2).getCodigo();
		do{
			while(arreglo.get(i).getCodigo()<pivote){
				i++;
			}
			while(arreglo.get(j).getCodigo()>pivote){
				j--;
			}
			if(i<=j){
				aux = arreglo.get(i);
				arreglo.set(i, arreglo.get(j));
				arreglo.set(j, aux);
				i++;
				j--;
				intercambios++;
			}
			pasadas++;
		}while(i<=j);
		if(primero<j){
			QuickSort(arreglo,primero,j);
		}
		if(i<ultimo){
			QuickSort(arreglo,i,ultimo);
		}
		String salida = "";
		for(int in=0;in<arreglo.size();in++){
			salida+=arreglo.get(in).toString();
		}
		return salida + "\nTotal de intercambios: "+intercambios+
				"\nTotal de Pasadas: "+pasadas+
				"\n";
	}//fin de quicksort
	
	public String toString() {
		return "Producto \n\n*Nombre=" + nombre + "\n*Codigo=" + codigo + "\n*Precio=" + precio + "\n*Cantidad Total="
				+ cantidadTotal + "\n*Cantidad Existente=" + cantidadExistente + "\n\n";
	}

}
