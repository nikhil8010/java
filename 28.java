slip-28
1>
<%@ page language="java" %>
<html>
<head>
<title>Reverse String</title>
</head>
<body>
<h2>Enter a string to reverse:</h2>
<form method="post" action="reverse.jsp"><input type="text" name="stringToReverse">
<input type="submit" value="Reverse">
</form>
<%
String inputString = request.getParameter("stringToReverse");
if (inputString != null) {
String reversedString = "";
for (int i = inputString.length() - 1; i >= 0; i--) {
reversedString += inputString.charAt(i);
}
out.print("<h2>Reversed string: " + reversedString + "</h2>");
}
%>
</body>
</html>

2>
public class CurrentThreadName {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println("Currently executing thread: " + t.getName());
    }
}

