package soldier;

public enum SoldierType 
{

	Infantryman,
	Horseman,
	Hero;
	
	public static SoldierType reverseOrdinal (int order)
	{
		switch (order)
		{
			case 0:
				return Infantryman;
			case 1:
				return Horseman;
			case 2:
				return Hero;
			default:
				return Infantryman;
		}
	}
	
}
