
import org.zeroturnaround.exec.ProcessExecutor;

public class T
{
	
	public static void main(String[] args) throws Exception
	{
		String output = new ProcessExecutor().command("java", "-version")
                .readOutput(true).execute()
                .outputUTF8();   
		
		System.out.println(output);
		
	}

}
