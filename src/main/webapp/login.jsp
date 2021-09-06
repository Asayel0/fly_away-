<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

input[type=text] {
  width: 100%;
  margin-bottom: 20px;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 3px;
}
input[type=password] {
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
	<%-- <%@ include file="toolbar.jsp" %> --%>
	<div align="center" id="booking">
	<h2>Booking detail</h2>
		<label>Departure: ${flight.departure}</label> <br>
		<label>Arrival: ${flight.arrival}</label> <br>
		<label>Departure Time: ${flight.departureDate}</label> <br>
		<label>Airline: ${flight.airline.name}</label> <br>
	<label>Price: ${flight.price}</label> <br>
		<label>Total: ${flight.price * person}</label> <br> 
	</div>
	<div align="center" id="passenger" class="container">
	<h2>Passenger Detail</h2>
	<form action="/passenger">
		<label for="r1" id="fn">First Name :</label>
		<input type="text" name="fname" id="r1" required><br/>
		 
		<label  for="r2" id="ln">Last Name :</label>
		<input type="text" name="lname" id="r2" required><br/>
		
		<label  for="r4" id="pwd">Password :</label>
		<input type="password" name="pass" id="r4" required><br/>
		 
		<label  for="r5" id="em">Email :</label>
		<input type="text" name="email" id="r5" required><br/>
		<input type="text" name="id" value="${flight.id}" hidden="true">
		
		          <div class="col-50">
            <h3>Payment</h3>
            <label for="cname">Name on Card</label>
            <input type="text" id="cname" name="cardname" placeholder="John More Doe" required>
            <label for="ccnum">Credit card number</label>
            <input type="text" id="ccnum" name="cardnumber" placeholder="1111-2222-3333-4444" required> 
            <label for="expmonth">Exp Month</label>
            <input type="text" id="expmonth" name="expmonth" placeholder="September" required>
            <div class="row">
              <div class="col-50">
                <label for="expyear">Exp Year</label>
                <input type="text" id="expyear" name="expyear" placeholder="2018" required>
              </div>
              <div class="col-50">
                <label for="cvv">CVV</label>
                <input type="text" id="cvv" name="cvv" placeholder="352" required>
              </div>
            </div>
          </div>
		
		<button class="btn"type="submit" value="Submit" id="button">Book</button><br/>

		</form>
	</div>
	<div>
	
	
	</div>
</body>
</html>