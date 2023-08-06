<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Technical Assignment</title>
</head>
<body>
	<center>
		<h1>Temlatization Of Org</h1>
		<h2>

			</a> &nbsp;&nbsp;&nbsp; <a href="list">
				<button class="button button2">Download Template</button>
			</a>
		</h2>
	</center>
	<div align="center">

		<form action="upload" method="post">
			<table border="1" cellpadding="5">

				<%-- <c:if test="${user != null}">
					<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
				</c:if> --%>
				<%-- 	<tr>
				<th>User Name:</th>
				<td><input type="text" name="name" size="45"
					value="<c:out value='${user.name}' />" /></td>
			</tr> --%>
				<tr>
				<tr>
					<th>Upload only xml file:</th>
					<td><input type="file" name="file" size="45"
						value="<c:out value='${user.file}' />" /></td>
				</tr>
				<tr>

				</tr>

				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Save" class="button button2"></td>
				</tr>
			</table>
		</form>

	</div>
</body>
</html>
<!-- <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Guru Uploading File</title>
</head>
<body>
File: <br />
<form action="guru_upload" method="post"
                        enctype="multipart/form-data">
<input type="file" name="guru_file" size="50" />
<br />
<input type="submit" value="Upload" />
</form>
</body>
</html>
 -->
<Style>
body {
	font-family: $ font-family;
	font-size: $font-size;
	background-size: 200% 100% !important;
	animation: move 10s ease infinite;
	transform: translate3d(0, 0, 0);
	background: linear-gradient(45deg, #49D49D 10%, #A2C7E5 90%);
	height: 100vh
}

.user {
	width: 90%;
	max-width: 340px;
	margin: 10vh auto;
}

.user__header {
	text-align: center;
	opacity: 0;
	transform: translate3d(0, 500px, 0);
	animation: arrive 500ms ease-in-out 0.7s forwards;
}

.user__title {
	font-size: $font-size;
	margin-bottom: -10px;
	font-weight: 500;
	color: white;
}

.form {
	margin-top: 40px;
	border-radius: 6px;
	overflow: hidden;
	opacity: 0;
	transform: translate3d(0, 500px, 0);
	animation: arrive 500ms ease-in-out 0.9s forwards;
}

.form--no {
	animation: NO 1s ease-in-out;
	opacity: 1;
	transform: translate3d(0, 0, 0);
}

.form__input {
	display: block;
	width: 100%;
	padding: 20px;
	font-family: $ font-family;
	-webkit-appearance: none;
	border: 0;
	outline: 0;
	transition: 0.3s;
	&:
	focus
	{
	background
	:
	darken(
	#fff
	,
	3%
	);
}

}
.button1 {
	box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
		rgba(0, 0, 0, 0.19);
}

.button2:hover {
	box-shadow: 0 12px 16px 0 rgba(0, 0, 0, 0.24), 0 17px 50px 0
		rgba(0, 0, 0, 0.19);
}

.button {
	background-color: #dea23a; /* Green */
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
	-webkit-transition-duration: 0.4s; /* Safari */
	transition-duration: 0.4s;
}

.btn {
	display: block;
	width: 100%;
	padding: 20px;
	font-family: $ font-family;
	-webkit-appearance: none;
	outline: 0;
	border: 0;
	color: white;
	background: $color-primary;
	transition: 0.3s;
	&:
	hover
	{
	background
	:
	darken(
	$
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	color-primary
	,
	5%
	);
}

}
@
keyframes NO {from , to { -webkit-transform:translate3d(0, 0, 0);
	transform: translate3d(0, 0, 0);
}

10




























%
,
30




























%
,
50




























%
,
70




























%
,
90




























%
{
-webkit-transform




























:




























translate3d


























(




























-10px
,
0
,
0




























)


























;
transform




























:




























translate3d


























(




























-10px
,
0
,
0




























)


























;
}
20




























%
,
40




























%
,
60




























%
,
80




























%
{
-webkit-transform




























:




























translate3d


























(




























10px
,
0
,
0




























)


























;
transform




























:




























translate3d


























(




























10px
,
0
,
0




























)


























;
}
}
@
keyframes arrive { 0% {
	opacity: 0;
	transform: translate3d(0, 50px, 0);
}

100




























%
{
opacity




























:




























1


























;
transform




























:




























translate3d


























(




























0
,
0
,
0




























)


























;
}
}
@
keyframes move { 0% {
	background-position: 0 0
}
50




























%
{
background-position




























:




























100


























%
0




























}
100




























%
{
background-position




























:




























0




























0




























}
}
</Style>

