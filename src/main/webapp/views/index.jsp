<%@ page language="java" contentType="text/html;charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>



		<!DOCTYPE html>
		<html>

		<head>
			<title>Student Registration Form</title>
		</head>

		<body>
			<font color="green">${msg}</font>
			<h3>Student Registration Form</h3>

			<form:form action="save" modelAttribute="student" method="POST">

				<table>
					<tr>
						<td>Name : </td>
						<td>
							<form:input path="name" />
						</td>


					</tr>
					<tr>
						<td>Email : </td>
						<td>
							<form:input path="email" />
						</td>
					</tr>
					<tr>
						<td>Course : </td>
						<td>
							<form:select path="course">
								<form:option value="">-Select-</form:option>
								<form:options items="${courses}" />
							</form:select>
						</td>
					</tr>

					<td>Timings : </td>
					<td>
						<form:checkboxes items="${timings}" path="timings" />

					</td>
					</tr>
						<tr>
							<td>
								<input type="submit" value="Submit">
							</td>
						</tr>
				</table>


			</form:form>

			<h3> click here to see Student details ...</h3><a href="viewStudents">view Students</a>



		</body>

		</html>