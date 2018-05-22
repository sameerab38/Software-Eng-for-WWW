package sbammidi_ServletHW4;
// Sameera Bammidi
// This class has all the fields to get and set mean and standard deviation of the entered numbers data

public class DataBean
{
	private double mean;
	private double standardDeviation;

	public DataBean(){	}
	
	public double getMean()
	{
		return mean;
	}
	public void setMean(double mean)
	{
		this.mean = mean;
	}
	public double getStandardDeviation()
	{
		return standardDeviation;
	}
	public void setStandardDeviation(double standardDeviation)
	{
		this.standardDeviation = standardDeviation;
	}
}
