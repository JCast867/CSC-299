package aa;

import java.util.Optional;

public class UserStats
{
	private Optional<Long> visitCount;

	public UserStats() 
	{
		this.visitCount = Optional.empty();
	}
	
	public UserStats(long visitCount)
	{
		this.visitCount = Optional.of(visitCount);
	}

	public Optional<Long> getVisitCount()
	{
		return visitCount;
	}

	public void setVisitCount(Optional<Long> visitCount)
	{
		this.visitCount = visitCount;
	}	
}