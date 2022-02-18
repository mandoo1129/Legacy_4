<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook List Page</h1>
	<h1>${list}</h1>
	
	<table>
		<tr>
			<th>상품명</th><th>이자율</th><th>판매</th>
		</tr>
		<c:forEach items="${list}" var="book">
		<tr>
			<td>${book.bookName}</td>
			<td>${book.bookRate}</td>
			<td>${book.bookSale}</td>
		</tr>
		</c:forEach>
	</table>
	

</body>
</html>