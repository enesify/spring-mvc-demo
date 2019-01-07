<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Student Confirmation</title>
</head>
<body>
	<!-- calls student.getFirstName() and student.getlastName() -->
	The student is confirmed: ${student.firstName} ${student.lastName}

	<br>
	<br> 
	<!-- calls student.getFavouriteLanguage() -->
	Favourite language: ${student.favouriteLanguage }

	<br>
	<br> 
	<!-- calls student.getCountry() -->
	Country: ${student.country}

</body>
</html>