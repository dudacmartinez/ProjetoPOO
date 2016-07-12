package GUI;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class PanelInicial extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public JLabel labelPrincipal;
	public JButton btnCancelar;
	public JButton btnProximo;
	
	public PanelInicial(CardLayout cardLayout,JFrame frame, Container container) {

		this.setLayout(null);
		
		labelPrincipal = new JLabel("Elabora\u00E7\u00E3o de propostas ");
		labelPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		labelPrincipal.setBounds(284, 147, 181, 14);
		add(labelPrincipal);
		
		btnProximo = new JButton("Iniciar >>");
		btnProximo.setBounds(643, 427, 131, 23);
		add(btnProximo);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(10, 427, 89, 23);
		add(btnCancelar);
		
		//----------------------------------------------------------------------------
		//------------------------Ações Painel Inicial--------------------------------
		//----------------------------------------------------------------------------
		
		btnProximo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.next(container);
			}	
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}			
		});
		
	}
	

}
