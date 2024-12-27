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


public class FacturaVentas extends JFrame {
	
    //Atributos
    public int numFactura;
    public String nomCliente;
    public int codigoVendedor;
    public String nomProducto;
    public int cantidadProducto;
    public double precioProducto;
    public double totalNoImpusto;
    public double totalIVA;
    private double IVA = 0.13;
    //Gui
    private JPanel contentPane;
    private JTextField textFieldnumFactura;
    private JTextField textFieldnomCliente;
    private JTextField textFieldcodVendedor;
    private JTextField textFieldCantidad;
    private JTextField textFieldnomProducto;
    private JTextField textFieldPreProducto;
    
    //Arraylist para guardar datos.
    public ArrayList<FacturaVentas> Ventas = new ArrayList<FacturaVentas>();
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FacturaVentas frame = new FacturaVentas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Gui
	public FacturaVentas() {
		setTitle("Factura de ventas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNmeroDeFactura = new JLabel("N\u00FAmero de factura");
		lblNmeroDeFactura.setFont(new Font("Showcard Gothic", Font.PLAIN, 13));
		lblNmeroDeFactura.setBounds(10, 26, 147, 14);
		contentPane.add(lblNmeroDeFactura);
		
		textFieldnumFactura = new JTextField();
		textFieldnumFactura.setToolTipText("Ingrese el numero de la factura");
		textFieldnumFactura.setBounds(160, 23, 86, 20);
		contentPane.add(textFieldnumFactura);
		textFieldnumFactura.setColumns(10);
		
		JLabel lblnomCliente = new JLabel("Nombre cliente");
		lblnomCliente.setFont(new Font("Showcard Gothic", Font.PLAIN, 13));
		lblnomCliente.setBounds(10, 84, 147, 14);
		contentPane.add(lblnomCliente);
		
		textFieldnomCliente = new JTextField();
		textFieldnomCliente.setToolTipText("Ingrese el nombre del cliente");
		textFieldnomCliente.setBounds(160, 81, 86, 20);
		contentPane.add(textFieldnomCliente);
		textFieldnomCliente.setColumns(10);
		
		JLabel lblcodVendedor = new JLabel("C\u00F3digo vendedor");
		lblcodVendedor.setFont(new Font("Showcard Gothic", Font.PLAIN, 13));
		lblcodVendedor.setToolTipText("Ingrese el c\u00F3digo del vendedor");
		lblcodVendedor.setBounds(10, 147, 147, 14);
		contentPane.add(lblcodVendedor);
		
		textFieldcodVendedor = new JTextField();
		textFieldcodVendedor.setBounds(160, 144, 86, 20);
		contentPane.add(textFieldcodVendedor);
		textFieldcodVendedor.setColumns(10);
		
		JLabel lblProducto = new JLabel("Producto");
		lblProducto.setFont(new Font("Showcard Gothic", Font.PLAIN, 13));
		lblProducto.setBounds(336, 11, 91, 14);
		contentPane.add(lblProducto);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Showcard Gothic", Font.PLAIN, 12));
		lblCantidad.setBounds(285, 84, 77, 14);
		contentPane.add(lblCantidad);
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.setToolTipText("Ingrese la cantidad de productos");
		textFieldCantidad.setBounds(374, 81, 50, 20);
		contentPane.add(textFieldCantidad);
		textFieldCantidad.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Showcard Gothic", Font.PLAIN, 12));
		lblNombre.setBounds(285, 47, 77, 14);
		contentPane.add(lblNombre);
		
		textFieldnomProducto = new JTextField();
		textFieldnomProducto.setToolTipText("Ingrese el nombre del producto");
		textFieldnomProducto.setBounds(371, 44, 103, 20);
		contentPane.add(textFieldnomProducto);
		textFieldnomProducto.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Showcard Gothic", Font.PLAIN, 12));
		lblPrecio.setBounds(285, 124, 58, 14);
		contentPane.add(lblPrecio);
		
		textFieldPreProducto = new JTextField();
		textFieldPreProducto.setToolTipText("Ingrese el precio del producto");
		textFieldPreProducto.setBounds(374, 121, 100, 20);
		contentPane.add(textFieldPreProducto);
		textFieldPreProducto.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Evita espacios vac�os
				if (textFieldnumFactura.getText().isEmpty()  || textFieldnomCliente.getText().isEmpty()  || 
						textFieldcodVendedor.getText().isEmpty()  || textFieldCantidad.getText().isEmpty() || textFieldnomProducto.getText().isEmpty()  ||
						textFieldPreProducto.getText().isEmpty() ) {
					
					JOptionPane.showMessageDialog(null, "Faltan datos..." , "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
				else {
					
					
				
				
				if(textFieldnumFactura.getText().length() != 4 ) {//Numero de factura de 4 digitos
					JOptionPane.showMessageDialog(null, "Numero de factura debe ser de 4 digitos");
				}
				else {
				int conf = JOptionPane.showConfirmDialog(null, "Desea guardar los datos." , "Advertencia", JOptionPane.INFORMATION_MESSAGE);
				if(conf == JOptionPane.YES_OPTION) {
					
					FacturaVentas a = new FacturaVentas();
					a.setNumFactura(Integer.parseInt(textFieldnumFactura.getText()));
					a.setNomCliente(textFieldnomCliente.getText());
					a.setPrecioProducto(Double.parseDouble(textFieldPreProducto.getText()));
					a.setCantidadProducto(Integer.parseInt(textFieldCantidad.getText()));
					a.setCodigoVendedor(Integer.parseInt(textFieldcodVendedor.getText()));
					a.setNomProducto(textFieldnomProducto.getText());
					
					//Calculos sin IVA y con IVA
					a.setTotalNoImpusto( Integer.parseInt( textFieldCantidad.getText()) * Integer.parseInt( textFieldPreProducto.getText()));
					int aux =  Integer.parseInt( textFieldCantidad.getText()) * Integer.parseInt( textFieldPreProducto.getText());
					double aux2 = aux * IVA;
					a.setTotalIVA( aux2 + aux );
					//guarda datos.
					Ventas.add(a);
					
					textFieldnumFactura.setText(null);
					textFieldnomCliente.setText(null);
					textFieldPreProducto.setText(null);
					textFieldCantidad.setText(null);
					textFieldcodVendedor.setText(null);
					textFieldnomProducto.setText(null);
					
				
				
				
				
				dispose();
				}
    else if (conf == JOptionPane.NO_OPTION){
					
				}
				}
				}
				
			}
		});
		btnAceptar.setBounds(197, 251, 89, 23);
		contentPane.add(btnAceptar);
	}

	public int getNumFactura() {
		return numFactura;
	}

	public void setNumFactura(int numFactura) {
		this.numFactura = numFactura;
	}

	public String getNomCliente() {
		return nomCliente;
	}

	public void setNomCliente(String nomCliente) {
		this.nomCliente = nomCliente;
	}

	public int getCodigoVendedor() {
		return codigoVendedor;
	}

	public void setCodigoVendedor(int codigoVendedor) {
		this.codigoVendedor = codigoVendedor;
	}

	public String getNomProducto() {
		return nomProducto;
	}

	public void setNomProducto(String nomProducto) {
		this.nomProducto = nomProducto;
	}

	public int getCantidadProducto() {
		return cantidadProducto;
	}

	public void setCantidadProducto(int cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}

	public double getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(double precioProducto) {
		this.precioProducto = precioProducto;
	}

	public double getTotalNoImpusto() {
		return totalNoImpusto;
	}

	public void setTotalNoImpusto(double totalNoImpusto) {
		this.totalNoImpusto = totalNoImpusto;
	}

	public double getTotalIVA() {
		return totalIVA;
	}

	public void setTotalIVA(double totalIVA) {
		this.totalIVA = totalIVA;
	}

	@Override
	public String toString() {
		return "FacturaVenta \n\n*N�mero Factura=" + numFactura + "\n*Nombre Cliente=" + nomCliente + "\n*C�digo Vendedor="
				+ codigoVendedor + "\n*Nombre Producto=" + nomProducto + "\n*Cantidad Productos=" + cantidadProducto
				+ "\n*Precio Producto=" + precioProducto + "\n*Total sin impuesto=" + totalNoImpusto + "\n*Total con IVA=" + totalIVA
				+ "\n\n";
	}
	//Muestra datos ordenados con shell.
	public String Shell(ArrayList<FacturaVentas> arreglo){
		int salto,i,j,k;
		int pasadas = 0,intercambios = 0;
		FacturaVentas aux;
		salto=arreglo.size()/2;
		while(salto>0){
			for(i=salto;i<arreglo.size();i++){
				j=i-salto;
				while(j>=0){
					k=j+salto;
					if(arreglo.get(j).getNumFactura()<=arreglo.get(k).getNumFactura()){
						j=-1;
					}else{
						aux=arreglo.get(j);
						arreglo.set(j, arreglo.get(k));//[j]=arreglo[k];
						arreglo.set(k, aux);//[k]=aux;
						j=j-salto;//j-=salto;
						intercambios++;
					}
				}
			}
			pasadas++;
			salto=salto/2;
		}
		String salida = "";
		for(i = 0;i<arreglo.size();i++){
		salida+=arreglo.get(i).toString();	
		}
		return salida + "\nIntercambios: "+intercambios+"\nPasadas: "+pasadas+"";
	}//fin del metodo ordenamiento shell
	//muestra desordenado
	public String muestra(){
		   String salida = "";
				
				if( !Ventas.isEmpty()) {
				
				
					for (FacturaVentas p : Ventas) {
					
					salida += ""
							+ p.toString();
				       } 
				}else {
					salida += "Lista vacia";
				}
					return salida;
			}
}
