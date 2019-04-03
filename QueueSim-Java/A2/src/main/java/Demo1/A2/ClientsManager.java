package Demo1.A2;

public class ClientsManager implements Runnable{
	
	public static boolean runStatus;
	
	public ClientsManager()
	{
		
	}
	
	@Override
	public void run() {
		
		runStatus = true;
		Client c = new Client();
		RPG r =  new RPG(Main.minArr, Main.maxArr, Main.minWork, Main.maxWork);
		c = r.generateClient(Main.crrTime);
		while(runStatus == true)
		{
			if(Main.crrTime == c.getArrTime())
			{
				System.out.println("Client added successfully");
				Screen.resText.setText(Screen.resText.getText() + "\n" + "Client added successfully");	
				Queue bestQ = Main.q.get(getBestQ());
				c.setQ(getBestQ());
				bestQ.enq(c);
				c = r.generateClient(Main.crrTime);
			}
			System.out.print("");
			if(Main.crrTime == Main.simTime)
			{
				runStatus = false;
			}
		}
		
	}

	public static int getBestQ()
	{
		int minSize = Integer.MAX_VALUE;
		int bestQ = -1;
		for(int i = 0; i < Main.noQ; i++)
		{
			if(Main.q.get(i).getSize() < minSize)
			{
				minSize = Main.q.get(i).getSize();
				bestQ = i;
			}
		}
		return bestQ;
	}
}
