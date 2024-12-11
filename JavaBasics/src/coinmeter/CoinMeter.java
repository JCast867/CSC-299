package coinmeter;

public class CoinMeter
{
	public static final double WEIGHT_THRESHOLD   = 0.03;
	public static final double DIAMETER_THRESHOLD = 0.01;
	
	private boolean checkThreshold(double weight, double diameter, double baseWeight, double baseDiameter) {
		double weightLowerThreshold = baseWeight - (WEIGHT_THRESHOLD * baseWeight);
		double weightUpperThreshold = baseWeight + (WEIGHT_THRESHOLD * baseWeight);
		double diameterLowerThreshold = baseDiameter - (DIAMETER_THRESHOLD * baseDiameter);
		double diamterUpperThreshold = baseDiameter + (DIAMETER_THRESHOLD * baseDiameter);
		if (weight >= weightLowerThreshold && weight <= weightUpperThreshold) {
			if (diameter >= diameterLowerThreshold && diameter <= diamterUpperThreshold) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isAPenny(double weight, double diameter)
	{
		return checkThreshold(weight, diameter, Coin.PENNY.getWeight(), Coin.PENNY.getDiameter());
	}

	public boolean isANickel(double weight, double diameter)
	{
		return checkThreshold(weight, diameter, Coin.NICKEL.getWeight(), Coin.NICKEL.getDiameter());
	}

	public boolean isADime(double weight, double diameter)
	{
		return checkThreshold(weight, diameter, Coin.DIME.getWeight(), Coin.DIME.getDiameter());
	}

	public boolean isAQuarter(double weight, double diameter)
	{
		return checkThreshold(weight, diameter, Coin.QUARTER.getWeight(), Coin.QUARTER.getDiameter());
	}

	public Coin classifyCoin(double weight, double diameter)
	{
		if (isAPenny(weight, diameter)) {
			return Coin.PENNY;
		}
		if (isANickel(weight, diameter)) {
			return Coin.NICKEL;
		}
		if (isADime(weight, diameter)) {
			return Coin.DIME;
		}
		if (isAQuarter(weight, diameter)) {
			return Coin.QUARTER;
		}
		else {
			return Coin.UNKNOWN;
		}
	}
}
