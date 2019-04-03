package Demo1.A2;

import java.util.*;

public class Queue {
	
	private ArrayList<Client> Q = new ArrayList<>();
	private int idleTime;
	
	public Queue()
	{
		setIdleTime(0);
	}
	
	public void enq(Client c)
	{
		Q.add(Q.size(), c);
		
	}
	
	public Client deque()
	{
		if(Q.size() != 0)
		{
			Q.get(0).setLeaveTime(Main.crrTime);
			Main.allClients.add(Q.get(0));
			System.out.println("Client removed successfully");
			Screen.resText.setText(Screen.resText.getText() + "\n" + "Client removed successfully");	
			return Q.remove(0);
		}
			
		else 
			return null;
	}
	
	public void passTime()
	{
		if(Q.size() == 0)
		{
			idleTime++;
		}
		if(Q.size() > 0)
		{
			
			if(Q.get(0).getCrrWork() == 0)
			{
				deque();
			}
			else
			{
				Q.get(0).setCrrWork(Q.get(0).getCrrWork() - 1);
			}
			
		}
	}

	public int getSize()
	{
		return Q.size();
	}
	
	public int getIdleTime() {
		return idleTime;
	}

	public void setIdleTime(int idleTime) {
		this.idleTime = idleTime;
	}

	public String toString()
	{
		String s = "";
		if(Q.size() != 0)
		{
			for(Client c: Q)
			{
				s += c + " ";
			}
		}
		
		return s;
	}
	
	public void clear()
	{
		Q.clear();
	}
}
