package mapmakers;

public class Culture 
{
	private String culture;
	private String cultureGroup;
	
	public Culture( String inputculture, String inputcultureGroup)
	{
		culture = inputculture;
		cultureGroup = inputcultureGroup;
	}
	
	public String getCulture()
	{
		return culture;
	}
	
	public String getCultureGroup()
	{
		return cultureGroup;
	}
}
