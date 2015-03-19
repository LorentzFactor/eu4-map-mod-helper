package mapmakers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MyWriter extends FileWriter
{
	public MyWriter(File file) throws IOException 
	{
		super(file);
	}
	
	@Override
	public void write(String s) throws IOException
	{
		super.write(s + System.getProperty("line.separator"));
	}
	
	public void setEqual(String variable, String value) throws IOException
	{
		write(variable + " = " + value);
	}
}
