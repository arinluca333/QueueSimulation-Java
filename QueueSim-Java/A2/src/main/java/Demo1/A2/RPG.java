package Demo1.A2;

import java.util.*;

//RANDOM PERSON GENERATOR
public class RPG {

	int minArr;
	int maxArr;
	int minWork;
	int maxWork;
	
	public RPG(int minA, int maxA, int minW, int maxW)
	{
		minArr = minA;
		maxArr = maxA;
		minWork = minW;
		maxWork = maxW;
	}
	
	public Client generateClient(int crrTime)
	{
		Client c = new Client();
		Random rnd = new Random();
		c.setWorkLoad(Math.abs(rnd.nextInt() % (maxWork - minWork + 1)) + minWork);
		c.setArrTime(Math.abs(rnd.nextInt() % (maxArr - minArr + 1)) + minArr + crrTime);
		return c;
	}
	
}
