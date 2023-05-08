slip-14
1>
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
public class setBb {

	public static void main(String[] args)
	{
	if(args.length<1)
	{
		System.out.println("Usage:java SimplesearchEngine <search str>");
		return;
	}
	String searchString=args[0];
	File currentFolder=new File("/home/bcs");
	File[]files=currentFolder.listFiles();
	for(File file:files)
	{
		if(file.isFile()&&file.getName().endsWith("demo.txt"))
		{
			SearchThread searchThread=new SearchThread(file,searchString);
			searchThread.start();
		}
	}

	}
	private static class SearchThread extends Thread
	{
		private final File file;
		private final String searchString;
		public SearchThread(File file,String searchString)
		{
			this.file=file;
			this.searchString=searchString;
		}
		public void run()
		{
			try(BufferedReader reader=new BufferedReader(new FileReader(file)))
			{
			String line;
					int lineNumber=1;
					while((line=reader.readLine())!=null)
					{
						if(line.contains(searchString))
						{
							System.out.println(file.getName()+":"+lineNumber);
						}
						lineNumber++;
					}
					
		} catch(Exception e)
		{
			e.printStackTrace();
			}
		}
	}
}

2>
HTML FILE

<!DOCTYPE html>
<html>
<body>
<form method=post action="Slip7.jsp">
Enter Any Number : <Input type=text name=num><br><br>
<input type=submit value=Display>
</form>
</body>
</html>

JSP FILE:

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
<%! int n,rem,r; %>
<% n=Integer.parseInt(request.getParameter("num"));
if(n<10)
{
out.println("Sum of first and last digit is ");
%><font size=18 color=red><%= n %></font>
<%
}
else
{
rem=n%10;
do{
r=n%10;
n=n/10;
}while(n>0);
n=rem+r;
out.println("Sum of first and last digit is ");
%><font size=18 color=red><%= n %></font>
<%
}
%>
</body>
</html>
