package Demo1.A2;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Screen {
	
	public Screen()
	{
		
	}
	
	public static JTextArea resText = new JTextArea();
	public static JFrame f = new JFrame();
	public void start(Main m) {
		
		Font ft = new Font("Monospace", 50, 20);
		
		resText.setBounds(270, 20, 1660, 450);
		resText.setFont(ft);
		resText.setEditable(false);
		resText.setAutoscrolls(true);
		resText.setText("Result here");
		resText.setAutoscrolls(true);
		JScrollPane scroll = new JScrollPane(resText);
		scroll.setBounds(270, 20, 1500, 450);
		f.add(scroll);
		
		JLabel l1 = new JLabel();
		l1.setText("Simulation Time:");
		l1.setBounds(10, 30, 200, 20);
		l1.setFont(ft);
		f.add(l1);
		JTextField t1 = new JTextField();
		t1.setBounds(200, 30, 50, 25);
		t1.setFont(ft);
		f.add(t1);
		
		
		JLabel l2 = new JLabel();
		l2.setText("Number of queues: ");
		l2.setBounds(10, 60, 200, 20);
		l2.setFont(ft);
		f.add(l2);
		JTextField t2 = new JTextField();
		t2.setBounds(200, 60, 50, 25);
		t2.setFont(ft);
		f.add(t2);
		
		JLabel l3 = new JLabel();
		l3.setText("Min arrival time: ");
		l3.setBounds(10, 90, 200, 20);
		l3.setFont(ft);
		f.add(l3);
		JTextField t3 = new JTextField();
		t3.setBounds(200, 90, 50, 25);
		t3.setFont(ft);
		f.add(t3);
		
		JLabel l4 = new JLabel();
		l4.setText("Max arrival time: ");
		l4.setBounds(10, 120, 200, 20);
		l4.setFont(ft);
		f.add(l4);
		JTextField t4 = new JTextField();
		t4.setBounds(200, 120, 50, 25);
		t4.setFont(ft);
		f.add(t4);
		
		JLabel l5 = new JLabel();
		l5.setText("Min workload: ");
		l5.setBounds(10, 150, 200, 20);
		l5.setFont(ft);
		f.add(l5);
		JTextField t5 = new JTextField();
		t5.setBounds(200, 150, 50, 25);
		t5.setFont(ft);
		f.add(t5);
		
		JLabel l6 = new JLabel();
		l6.setText("Max workload: ");
		l6.setBounds(10, 180, 200, 20);
		l6.setFont(ft);
		f.add(l6);
		JTextField t6 = new JTextField();
		t6.setBounds(200, 180, 50, 25);
		t6.setFont(ft);
		f.add(t6);
		
		JLabel l7 = new JLabel();
		l7.setText("Simulation speed: ");
		l7.setBounds(10, 210, 200, 20);
		l7.setFont(ft);
		f.add(l7);
		JTextField t7 = new JTextField();
		t7.setBounds(200, 210, 50, 25);
		t7.setFont(ft);
		f.add(t7);
		
		JButton b1 = new JButton("RunSim");
		b1.setBounds(10, 250, 150, 100);
		b1.setFont(ft);
		b1.addActionListener(new ActionListener() 
        { 
			public void actionPerformed(ActionEvent arg0) 
			{	
					resText.setText(" ");
					Main.simTime =  Integer.parseInt(t1.getText());
					Main.noQ =  Integer.parseInt(t2.getText());
					Main.minArr = Integer.parseInt(t3.getText());
					Main.maxArr = Integer.parseInt(t4.getText());
					Main.minWork = Integer.parseInt(t5.getText());
					Main.maxWork = Integer.parseInt(t6.getText());
					Main.simSpeed = Integer.parseInt(t7.getText());
					Main.crrTime = 0;
					Main.allClients.clear();
					Main.q1.clear();
					Main.q2.clear();
					Main.q3.clear();
					m.start();
					
			}      
	    });

		f.add(b1);
			
		f.setSize(2000,1000);
		f.setLayout(null);
		f.setVisible(true);
		
	}
	
}
