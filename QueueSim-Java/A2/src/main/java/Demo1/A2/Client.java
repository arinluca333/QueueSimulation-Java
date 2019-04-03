package Demo1.A2;

public class Client implements Comparable<Client>{
	
	private int arrTime;
	private int leaveTime;
	private int workLoad;
	private int q;
	private int crrWork;
	
	public Client(int arr, int work)
	{
		arrTime = arr;
		workLoad = work;
		leaveTime = 0;
		q = -1;
		setCrrWork(work);
	}
	
	public Client()
	{
		arrTime = 0;
		workLoad = 0;
		leaveTime = 0;
		q = -1;
		setCrrWork(0);
	}
	
	public int getWaitTime() throws ClientInQException
	{
		if(leaveTime != 0)
			return leaveTime - arrTime;
		else throw(new ClientInQException());
	}
	
	public int getArrTime()
	{
		return arrTime;
	}

	public void setArrTime(int arr)
	{
		arrTime = arr;
	}
	
	public int getWorkLoad()
	{
		return workLoad;
	}

	public void setWorkLoad(int work)
	{
		workLoad = work;
		crrWork = work;
	}
	
	public int getLeaveTime()
	{
		return leaveTime;
	}

	public void setLeaveTime(int leave)
	{
		leaveTime = leave;
	}
	
	public int getQ()
	{
		return q;
	}

	public void setQ(int que)
	{
		q = que;
	}
	
	public int compareTo(Client c2) 
	{
		try {
			if(this.getWaitTime() > c2.getWaitTime())
				return 1;
		} catch (ClientInQException e) {

			e.printStackTrace();
		}
		try {
			if(this.getWaitTime() < c2.getWaitTime())
				return -1;
		} catch (ClientInQException e) {

			e.printStackTrace();
		}
		return 0;
	}
	
	public String toString()
	{
		return "[arrive:" + arrTime + " leave:" + leaveTime + " work:" +workLoad + " qNo:" + q + "]";
	}

	public int getCrrWork() {
		return crrWork;
	}

	public void setCrrWork(int crrWork) {
		this.crrWork = crrWork;
	}

}
