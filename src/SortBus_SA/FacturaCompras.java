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


public class FacturaCompras extends JFrame {

	private JPanel contentPane;
    //Atributos
	public int numFactura;
	public String nomProveedor;
	public int cedJuridica;
	public String nomProducto;
	public double precioProd;
	public int cantidadProd;
	public double total;
	//Array list para guardar los datos
	public ArrayList<FacturaCompras> Compras = new ArrayList<FacturaCompras>();
	//GUI
	private JTextField textFieldNumFactura;
	private JTextField textFieldNomProve;
	private JTextField textFieldCedJuri;
	private JLabel lblProducto;
	private JLabel lblNombre;
	private JTextField textFieldNom;
	private JLabel lblCantidad;
	private JTextField textFieldCantidad;
	private JLabel lblPrecio;
	private JTextField textFieldPrecio;
	private JButton btnAceptar;
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FacturaCompras frame = new FacturaCompras();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//GUI
	public FacturaCompras() {
		setTitle("Facturas de compras");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNumFactura = new JLabel("N\u00FAmero de factura");
		lblNumFactura.setFont(new Font("Showcard Gothic", Font.PLAIN, 13));
		lblNumFactura.setBounds(10, 61, 138, 14);
		contentPane.add(lblNumFactura);
		
		textFieldNumFactura = new JTextField();
		textFieldNumFactura.setBounds(158, 58, 86, 20);
		contentPane.add(textFieldNumFactura);
		textFieldNumFactura.setColumns(10);
		
		JLabel lblNomProve = new JLabel("Nombre proveedor");
		lblNomProve.setFont(new Font("Showcard Gothic", Font.PLAIN, 13));
		lblNomProve.setBounds(10, 116, 138, 14);
		contentPane.add(lblNomProve);
		
		textFieldNomProve = new JTextField();
		textFieldNomProve.setBounds(158, 113, 86, 20);
		contentPane.add(textFieldNomProve);
		textFieldNomProve.setColumns(10);
		
		JLabel lblCdulaJurdica = new JLabel("C\u00E9dula jur\u00EDdica");
		lblCdulaJurdica.setFont(new Font("Showcard Gothic", Font.PLAIN, 13));
		lblCdulaJurdica.setBounds(10, 175, 138, 14);
		contentPane.add(lblCdulaJurdica);
		
		textFieldCedJuri = new JTextField();
		textFieldCedJuri.setBounds(158, 172, 86, 20);
		contentPane.add(textFieldCedJuri);
		textFieldCedJuri.setColumns(10);
		
		lblProducto = new JLabel("Producto");
		lblProducto.setFont(new Font("Showcard Gothic", Font.PLAIN, 13));
		lblProducto.setBounds(358, 60, 104, 17);
		contentPane.add(lblProducto);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Showcard Gothic", Font.PLAIN, 12));
		lblNombre.setBounds(299, 99, 64, 14);
		contentPane.add(lblNombre);
		
		textFieldNom = new JTextField();
		textFieldNom.setBounds(395, 96, 86, 20);
		contentPane.add(textFieldNom);
		textFieldNom.setColumns(10);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Showcard Gothic", Font.PLAIN, 12));
		lblCantidad.setBounds(299, 135, 64, 14);
		contentPane.add(lblCantidad);
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.setBounds(395, 132, 86, 20);
		contentPane.add(textFieldCantidad);
		textFieldCantidad.setColumns(10);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Showcard Gothic", Font.PLAIN, 12));
		lblPrecio.setBounds(299, 175, 64, 14);
		contentPane.add(lblPrecio);
		
		textFieldPrecio = new JTextField();
		textFieldPrecio.setBounds(395, 172, 86, 20);
		contentPane.add(textFieldPrecio);
		textFieldPrecio.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Evita campos vac�os.
				if (textFieldNumFactura.getText().isEmpty()  || textFieldNomProve.getText().isEmpty()  || 
						textFieldCedJuri.getText().isEmpty()  || textFieldCantidad.getText().isEmpty() || textFieldNom.getText().isEmpty()  ||
						textFieldPrecio.getText().isEmpty() ) {
					
					JOptionPane.showMessageDialog(null, "Faltan datos..." , "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
				else {
					
					
				
				
				if(textFieldNumFactura.getText().length() != 4 ) { //Codigo de 4 digitos solamente.
					JOptionPane.showMessageDialog(null, "Codigo debe ser de 4 digitos");
				}
				else {
				int conf = JOptionPane.showConfirmDialog(null, "Desea guardar los datos." , "Advertencia", JOptionPane.INFORMATION_MESSAGE);
				if(conf == JOptionPane.YES_OPTION) {
					
					FacturaCompras a = new FacturaCompras();
					a.setNumFactura(Integer.parseInt(textFieldNumFactura.getText()));
					a.setNomProveedor(textFieldNomProve.getText());
					a.setPrecioProd(Double.parseDouble(textFieldPrecio.getText()));
					a.setCantidadProd(Integer.parseInt(textFieldCantidad.getText()));
					a.setCedJuridica(Integer.parseInt(textFieldCedJuri.getText()));
					a.setNomProducto(textFieldNom.getText());
					
					a.setTotal( Integer.parseInt( textFieldCantidad.getText()) * Integer.parseInt( textFieldPrecio.getText()));

					
					//Guarda los datos.
					Compras.add(a);
					
					textFieldNumFactura.setText(null);
					textFieldNomProve.setText(null);
					textFieldPrecio.setText(null);
					textFieldCantidad.setText(null);
					textFieldCedJuri.setText(null);
					textFieldNom.setText(null);
					
				
				
				
				
				dispose();
				}
    else if (conf == JOptionPane.NO_OPTION){
					
				}
				}
				}
			}
		});
		btnAceptar.setBounds(264, 302, 89, 23);
		contentPane.add(btnAceptar);
	}

	public int getNumFactura() {
		return numFactura;
	}

	public void setNumFactura(int numFactura) {
		this.numFactura = numFactura;
	}

	public String getNomProveedor() {
		return nomProveedor;
	}

	public void setNomProveedor(String nomProveedor) {
		this.nomProveedor = nomProveedor;
	}

	public int getCedJuridica() {
		return cedJuridica;
	}

	public void setCedJuridica(int cedJuridica) {
		this.cedJuridica = cedJuridica;
	}

	public String getNomProducto() {
		return nomProducto;
	}

	public void setNomProducto(String nomProducto) {
		this.nomProducto = nomProducto;
	}

	public double getPrecioProd() {
		return precioProd;
	}

	public void setPrecioProd(double precioProd) {
		this.precioProd = precioProd;
	}

	public int getCantidadProd() {
		return cantidadProd;
	}

	public void setCantidadProd(int cantidadProd) {
		this.cantidadProd = cantidadProd;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	public String muestra(){ //mostrar todo sin ordenar.
		   String salida = "";
				
				if( !Compras.isEmpty()) {
				
				
					for (FacturaCompras p : Compras) {
					
					salida += ""
							+ p.toString();
				       } 
				}else {
					salida += "Lista vacia";
				}
					return salida;
			}
	//Muestra los datos ordenados por insercion.
	public String Insercion(ArrayList<FacturaCompras> arreglo,int n){
		int i,j;
		int pasadas = 0,intercambios = 0;
		FacturaCompras aux;
		for(i=1;i<n;i++){
			aux=arreglo.get(i);
			j=i-1;
			while(j>=0&&arreglo.get(j).getNumFactura()>aux.getNumFactura()){
				arreglo.set(j+1, arreglo.get(j));
				j--;
				intercambios++;
			}
			pasadas++;
			arreglo.set(j+1, aux);
		}
		String salida="";
		for(i=0;i<arreglo.size();i++){
			salida+= arreglo.get(i).toString();
		}
		return salida + "\nIntercambios: "+intercambios+"\nPasadas: "+pasadas+"";
	}

	@Override
	public String toString() {
		return "FacturaCompra \n\n*N�mero Factura=" + numFactura + "\n*Nombre Proveedor=" + nomProveedor + "\n*C�dula Juridica="
				+ cedJuridica + "\n*Nombre Producto=" + nomProducto + "\n*PrecioProd=" + precioProd + "\n*Cantidad Productos="
				+ cantidadProd + "\n*Total=" + total + "\n\n";
	}


}
