package Demo1.A2;

import java.util.*;

import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class Main {

	//All possible 3 queues
	public static Queue q1 = new Queue();
	public static Queue q2 = new Queue();
	public static Queue q3 = new Queue();
	public static ArrayList<Queue> q = new ArrayList<Queue>(3);
	
	//user arguments used to describe a simulation
	public static int minArr = 1;
	public static int maxArr = 3;
	public static int minWork = 1;
	public static int maxWork = 6;
	public static int noQ = 3;
	public static int simTime = 20;
	public static int crrTime = 0;
	public static int simSpeed = 8;

	public static ArrayList<Client> allClients = new ArrayList<Client>(); //list for all served clients used for final stats
	
	public static Screen s = new Screen();
	
	static JProgressBar pg1 = new JProgressBar();
	static JProgressBar pg2 = new JProgressBar();
	static JProgressBar pg3 = new JProgressBar();
	static JLabel l1 = new JLabel();
	static JLabel l2 = new JLabel();
	static JLabel l3 = new JLabel();
	
	
	
	public static void main(String args[])
	{
		Main m = new Main();
		s.start(m);
		
		
		
		
	}
	public Main()
	{
		q.add(q1);
		q.add(q2);
		q.add(q3);
		pg1.setBounds(100,500,700,100);
		l1.setBounds(830, 500, 100, 100);
		pg2.setBounds(100,650,700,100);
		l2.setBounds(830, 650, 100, 100);
		pg3.setBounds(100,800,700,100);
		l3.setBounds(830, 800, 100, 100);
		
		l1.setText("0/10");
		l2.setText("0/10");
		l3.setText("0/10");
		
		Screen.f.add(l1);
		Screen.f.add(l2);
		Screen.f.add(l3);
		Screen.f.add(pg1);
		Screen.f.add(pg2);
		Screen.f.add(pg3);
	}
	public static boolean drawStatus;
	int peakTime = 0;
	int maxClientsNo = -1;
	int crrClientsNo = 0;
	public synchronized void start()
	{
		
		SwingWorker<String, Object> myWorker= new SwingWorker<String, Object>() {

		    protected String doInBackground() throws Exception {
		    	
		    	Thread cm = new Thread(new ClientsManager());//Thread that manages clients arrival
				cm.start();
		    	for(crrTime = 1; crrTime <= simTime; crrTime++) // main time simulator
				{
		    		pg1.setValue(q1.getSize() * 10);
		    		l1.setText(pg1.getValue() / 10 + "/10");
		    		pg2.setValue(q2.getSize() * 10);
		    		l2.setText(pg2.getValue() / 10 + "/10");
		    		pg3.setValue(q3.getSize() * 10);
		    		l3.setText(pg3.getValue() / 10 + "/10");
					try 
					{
						Thread.sleep(1000 / simSpeed);
					} 
					catch (InterruptedException e) 
					{
						e.printStackTrace();
					}
					System.out.println("Time:" + crrTime);
					s.resText.setText(s.resText.getText() + "\n" + "Time:" + crrTime);	
					for(int i = 0; i < noQ; i++)
					{
						crrClientsNo += q.get(i).getSize();
						System.out.println("Current people in q" + i + ": " + q.get(i));
						s.resText.setText(s.resText.getText() + "\n" + "Current people in q" + i + ": " + q.get(i));	
						q.get(i).passTime();
						
					}	
					if(crrClientsNo > maxClientsNo)
					{
						maxClientsNo = crrClientsNo;
						peakTime = crrTime;
					}
					crrClientsNo = 0;
					
				}
		    	System.out.println("Simulation finished");	
				
				System.out.println("All clients served: " + allClients);
				s.resText.setText(s.resText.getText() + "\n" + "All clients: " + allClients);	

				System.out.println("Peak time: " + peakTime + " with " + maxClientsNo + " cliets");
				s.resText.setText(s.resText.getText() + "\n" + "Peak time: " + peakTime + " with " + maxClientsNo + " cliets");	
				showStats();
				return null;
		    	
		    }
		};
		myWorker.execute();
		
		
	}
	
	public static void showStats()
	{
		float idleAv = 0;
		float waitAv = 0;
		float workAv = 0;
		for(int i = 0 ; i < noQ; i++)
		{
			idleAv += q.get(0).getIdleTime();
		}
		System.out.println("Average idle time for queue: " + idleAv/noQ);
		s.resText.setText(s.resText.getText() + "\n" + "Average idle time for queue: " + idleAv/noQ);	
		for(Client c: allClients)
		{
			try {
				waitAv += c.getWaitTime();
			} catch (ClientInQException e) {
				e.printStackTrace();
			}
			workAv += c.getWorkLoad();
		}
		System.out.println("Average waiting time: " + waitAv/allClients.size());
		s.resText.setText(s.resText.getText() + "\n" + "Average waiting time: " + waitAv/allClients.size());	
		System.out.println("Average workLoad: " + workAv/allClients.size());
		s.resText.setText(s.resText.getText() + "\n" + "Average workLoad: " + workAv/allClients.size());	
		
	}
}
