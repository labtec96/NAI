
public class Punkt
{
	double x;
	double y;

	public Punkt(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString()
	{
		return "x" + x + "y " + y;
	}
}
