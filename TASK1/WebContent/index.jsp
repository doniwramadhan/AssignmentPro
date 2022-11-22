<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  font-family: Arial;
  margin: 0;
}

.header {
  padding: 60px;
  text-align: center;
  background: #1abc9c;
  color: Black;
  font-size: 30px;
}
.nav {
  padding: 10px;
  text-align: center;
  background: olive;
  color: Blue;
  font-size: 10px;
}
.sec{
padding: 100px;
  text-align: center;
  background: white;
  color: Black;
  font-size: 30px;
}
.foot{
padding: 20px;
  text-align: center;
  background: Brown;
  color: White;
  font-size: 10px;
}
.button {
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}
.button1 {background-color: #4CAF50;} /* Green */
.button2 {background-color: #008CBA;} /* Blue */
</style>
</head>
<body>

<div class="header">
	<h1>Header</h1>
	<p>this is header</p>
</div>

<div class="nav">
	<h1>Navigation</h1>
	<p>this is navigation bar</p>
</div>

<div class="sec">
	<h1>Section</h1>
	
	<form method="post" action="./form.jsp"><button class="button button1">Add new record</button></form>
	
	<form method="post" action="list"><button class="button button2">View all record</button></form>
</div>

<div class="foot">
	<h1>Footer</h1>
	<p>this is footer</p>
</div>
<input type="submit" value="Download PDF" name="download" onclick="window.print()"/>

</body>
</html>