import java.util.Random;

class Service
{
	static Random r = new Random();
	static double w1 = generateBetween(-1, 1);
	static double w2 = generateBetween(-1, 1);
	static double b = generateBetween(-1, 1);
	final static public Punkt[] tabPoints =generatePoints(500);

	
	public static double generateBetween(int min, int max)
	{
		return min + (max - (min)) * r.nextDouble();
	}
	

	
	public static Punkt[] generatePoints(int amount)
	{
		Punkt[] points = new Punkt[amount];
		for (int i = 0; i < points.length; i++)
		{
			double x = generateBetween(-10, 10);
			double y = generateBetween(-10, 10);
			points[i] = new Punkt(x, y);
		}
		return points;
	}
	public static double net(double x,double y)
	{
		return w1 *x  + w2 * y + b;
	}
	public static int progowaUnipolarna(Punkt punkt)
	{
		return net(punkt.x,punkt.y) >= 0 ? 1 : 0;
	}

	public static double sigmoidalnaUnipolarna(Punkt punkt)
	{
		double net = net(punkt.x,punkt.y);
		return 1/(1+(Math.pow(Math.E, (-1 * net))));
	}
}
