package org.jdatepicker;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.jdatepicker.impl.JDatePanelImpl;

public class TestJDatePanelImplSelectDay {

	public static void main(String [] args){
    	// JDatePickerImpl d = new JDatePickerImpl();
    	final JDatePanelImpl d = new JDatePanelImpl();
        d.setPreferredSize(new Dimension(300, 200));
    	JButton button = new JButton("Click me");
    	button.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				System.out.println("Year: " + d.getModel().getYear());
				System.out.println("Month: " + (d.getModel().getMonth() + 1));
				System.out.println("Day: " + d.getModel().getDay());
				System.out.println("isSelected: " + d.getModel().isSelected());
				System.out.println("isSelected Day: " + d.getModel().isSelectedDay());
				System.out.println("isSelected Month: " + d.getModel().isSelectedMonth());
			}
    		
    	});
    	
    	
    	JFrame frame = new JFrame();
    	frame.setLayout(new FlowLayout());
    	frame.setSize(500, 500);
    	frame.add(d);
    	frame.add(button);
    	frame.setVisible(true);
    }

}
