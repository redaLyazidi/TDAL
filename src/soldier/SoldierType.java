package soldier;

public enum SoldierType 
{

	Infantryman,
	Horseman,
	Hero,
	Sith,
	SithOnOverBoard;
	
	public static SoldierType reverseOrdinal (int order)
	{
		switch (order) {
			case 0:
				return Infantryman;
			case 1:
				return Horseman;
			case 2:
				return Hero;
			case 3:
				return Sith;
			case 4:
				return SithOnOverBoard;
			default:
				return Infantryman;
		}
	}
	
}
