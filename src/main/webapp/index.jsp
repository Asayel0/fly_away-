<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fly Away</title>

</head>
<style>
label {
	font-size: 16px;
}
body {
  font-family: Arial;
  font-size: 17px;
  padding: 8px;
}

* {
  box-sizing: border-box;
}

.row {
  display: -ms-flexbox; /* IE10 */
  display: flex;
  -ms-flex-wrap: wrap; /* IE10 */
  flex-wrap: wrap;
  margin: 0 -16px;
}

.col-25 {
  -ms-flex: 25%; /* IE10 */
  flex: 25%;
}

.col-50 {
  -ms-flex: 50%; /* IE10 */
  flex: 50%;
}

.col-75 {
  -ms-flex: 75%; /* IE10 */
  flex: 75%;
}

.col-25,
.col-50,
.col-75 {
  padding: 0 16px;
}

.container {
  background-color: #f2f2f2;
  padding: 5px 20px 15px 20px;
  border: 1px solid lightgrey;
  border-radius: 3px;
}

input {
  width: 100%;
  margin-bottom: 20px;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 3px;
}

label {
  margin-bottom: 10px;
  display: block;
}

.icon-container {
  margin-bottom: 20px;
  padding: 7px 0;
  font-size: 24px;
}

.btn {
  background-color: #04AA6D;
  color: white;
  padding: 12px;
  margin: 10px 0;
  border: none;
  width: 100%;
  border-radius: 3px;
  cursor: pointer;
  font-size: 17px;
}

.btn:hover {
  background-color: #45a049;
}

a {
  color: #2196F3;
}

hr {
  border: 1px solid lightgrey;
}

span.price {
  float: right;
  color: grey;
}

/* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other (also change the direction - make the "cart" column go on top) */
@media (max-width: 800px) {
  .row {
    flex-direction: column-reverse;
  }
  .col-25 {
    margin-bottom: 20px;
  }
}
</style>
<body>
<h1 align="center">Fly Away</h1>
<%-- <%@ include file="toolbar.jsp" %> --%>
<div class="container">
	<form action="admin"  class="container pt-5 text-center" method="post">
	<h3>Admin</h3>
	<div>
		<input type="text" placeholder="Username" name="username" required>
	</div>
	<div>
		<input type="password" placeholder="Password" name="password" required>
	</div>
	<div>
		<button class="btn-search" type="submit">Login</button>
	</div>
	</form>
	</div>
	<div class="container">
	<form class="container pt-5 text-center" action="/search">
			<h3>SEARCH</h3>
		<div class="inner-form">
			<div class="input-field first-wrap">
				<div class="icon-wrap"></div>
				<input type="text" placeholder="Departure" name="departure" required>
			</div>
			<div class="input-field second-wrap">
				<div class="icon-wrap"></div>
				<input type="text" placeholder="Arrival" name="arrival" required>
			</div>
			<div class="input-field third-wrap">
				<input type="number" min="1" placeholder="# of persons" name="person" required>
			</div>
			<div class="input-field fouth-wrap">
				<input class="datepicker flatpickr-input" type="date"
					placeholder="date" name="date" required>
			</div>
			<div class="input-field fifth-wrap">
				<button class="btn-search" type="submit">SEARCH</button>
			</div>
		</div>
	</form>
	</div>
	
</body>
</html>