<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Book</title>
</head>
<body>

    <form method="POST">
        <label for="title">Title</label>
        <input type="text" id="title" name="title">
        <label for="author">Author</label>
        <input type="text" id="author" name="author">
        <label for="pages">Pages</label>
        <input type="number" id="pages" name="pages">
        <input type="submit" value="Add Book">
    </form>

</body>
</html>
