<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Registration Form</title>
</head>
<body>

	<!-- when form is LOADED, spring MVC will call getFirstName() and getLastName()-->

	<form:form action="processForm" modelAttribute="student">

		First name: <form:input path="firstName" />

		<br>
		<br>
		
		Last name: <form:input path="lastName" />
		
		<br>
		<br>
		
		Favourite Language: 
		
		Java <form:radiobutton path="favouriteLanguage" value="Java"/>
		Ruby <form:radiobutton path="favouriteLanguage" value="Ruby"/>
		Javascript <form:radiobutton path="favouriteLanguage" value="Javascript"/>
		C# <form:radiobutton path="favouriteLanguage" value="C#"/>

		<br>
		<br>
		
		Country: 
		
		<form:select path="country">
			<form:options items="${countryOptions}"/>
		</form:select>

		<br>
		<br>

		<!-- when form is SUBMITTED, spring MVC will call setFirstName() and setLastName()-->
		<input type="submit" value="Submit">

	</form:form>

</body>
</html>