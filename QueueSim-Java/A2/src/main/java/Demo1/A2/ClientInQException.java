package Demo1.A2;

@SuppressWarnings("serial")
public class ClientInQException extends Throwable 
{


	public ClientInQException()
	{
		
	}
	
	public String toString() 
	{
		return "Client still in queue.";
	}

	
}
