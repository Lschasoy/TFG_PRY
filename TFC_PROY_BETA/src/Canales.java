import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;


public class Canales extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	public Canales (){
		setBounds(250, 350, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	 //====================================================================================================

	public JComboBox generarComoboBox(String espacio, final BufferedImage img){
	    System.out.println("GeneradorComboBox: "+ espacio);
		final JComboBox cbCanales = new JComboBox();				
		cbCanales.setBounds(305, 0, 150, 25);
		if (espacio == "RGB")
			cbCanales.setModel(new DefaultComboBoxModel(new String[] {"Canal R", "Canal G", "Canal B"}));
		if (espacio == "HSV")
			cbCanales.setModel(new DefaultComboBoxModel(new String[] {"Canal H", "Canal S", "Canal V"}));
		if (espacio == "CYK")
			cbCanales.setModel(new DefaultComboBoxModel(new String[] {"Canal C", "Canal Y", "Canal K"}));
		

		// =================== Espacio de Colores ====================================		
		cbCanales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    if (cbCanales.getSelectedItem().equals(cbCanales.getItemAt(0) .toString())){
			    	System.out.println("Canal_1");
			        gCanalR(img);
		    	 
			    }   
			    if (cbCanales.getSelectedItem().equals(cbCanales.getItemAt(1) .toString())){
			    	System.out.println("Canal_2");
			    	gCanalG(img);
			    }
			    if (cbCanales.getSelectedItem().equals(cbCanales.getItemAt(2) .toString())){
			    	System.out.println("Canal_3");
			    	gCanalB(img);		
			    	
			    }
			}
		});	
	    return cbCanales;
	}
	
	 public final void gCanalB(BufferedImage image){
		 setTitle("Canal B");
		 BufferedImage salida = new BufferedImage(image.getWidth(), image.getHeight(),image.getType());;
		 
		 for (int x = 0; x < image.getWidth(); x++) {
			    for (int y = 0; y < image.getHeight(); y++) {
			    	Color c = new Color(image.getRGB(x, y));			    	
			    	int b = c.getBlue();
			    	salida.setRGB(x, y, new Color(b, b, b).getRGB());	
			    }	
		 }	    		
							
		mostrar(salida);
	 }
	 //====================================================================================================
	 public final void gCanalG(BufferedImage image){
		 setTitle("Canal G");
		 BufferedImage salida = new BufferedImage(image.getWidth(), image.getHeight(),image.getType());;
		 
		 for (int x = 0; x < image.getWidth(); x++) {
			    for (int y = 0; y < image.getHeight(); y++) {
			    	Color c = new Color(image.getRGB(x, y));			    	
			    	int g = c.getGreen();			    	
			    	salida.setRGB(x, y, new Color(g, g, g).getRGB());
			    }	
		 }	    		
							
		mostrar(salida);
	  }
	//====================================================================================================
	 public final void gCanalR(BufferedImage image) {
		setTitle("Canal R");
		BufferedImage salida = new BufferedImage(image.getWidth(), image.getHeight(),image.getType());;
		
		 for (int x = 0; x < image.getWidth(); x++) {
			    for (int y = 0; y < image.getHeight(); y++) {
			    	Color c = new Color(image.getRGB(x, y));				    		
			    	int r = c.getRed();			    	
			    	salida.setRGB(x, y, new Color(r, r, r).getRGB());	               				    
			    }	
		 }	    						
		mostrar(salida);
	 }		
	 //====================================================================================================	
	 public final void gCanalY(BufferedImage image){		 
			
		  setTitle("Canal Y");
		  BufferedImage salida = new BufferedImage(image.getWidth(), image.getHeight(),image.getType());					   
				
		   for (int x=0; x <  image.getWidth(); x++){
				for (int y=0;y < image.getHeight(); y++){
					//Obtiene el color
					Color color = new Color(image.getRGB(x, y));
					//Calcula la media de tonalidades
					int med=(color.getRed()+color.getGreen()+color.getBlue())/3;
					//Almacena el color en la imagen destino
					salida.setRGB(x, y, new Color(med,med,med).getRGB());
				}
			}
							
		mostrar(salida);
	 }
	
	 /*************************************************/
	 private void mostrar(BufferedImage image){
								
			ImageIcon ico = new ImageIcon(image);				
			JLabel label = new JLabel (ico);													
			contentPanel.add(label);		
						
		    setVisible(true);	
		}

}