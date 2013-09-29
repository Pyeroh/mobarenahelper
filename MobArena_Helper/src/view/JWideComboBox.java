package view;

import java.awt.Dimension;

import javax.swing.JComboBox;

public class JWideComboBox extends JComboBox<String> {

	private static final long serialVersionUID = 6402589310783400089L;
	private boolean layingOut = false; 

	public void doLayout(){ 
		try{ 
			layingOut = true; 
			super.doLayout(); 
		}finally{ 
			layingOut = false; 
		} 
	} 

	public Dimension getSize(){ 
		Dimension dim = super.getSize(); 
		if(!layingOut) 
			dim.width = Math.max(dim.width, getPreferredSize().width); 
		return dim; 
	} 
}
