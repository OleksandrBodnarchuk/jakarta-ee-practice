<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Shared text editor</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://cdn.tiny.cloud/1/04kbvknx4r00hwba5qnb1ndt01zv27r9pw2d961gyx0eoarw/tinymce/5/tinymce.min.js"
            referrerpolicy="origin"></script>
    <script>
        tinymce.init({
            selector: '#mytextarea'
        });
    </script>
</head>
<body>
<h1>Shared text editor</h1>
<p>Create your documents together</p>
<form action="" method="post">
    <label for="mytextarea">
    </label>
    <textarea id="mytextarea" name="context">
             <%=request.getAttribute("context")%>
    </textarea>
    <button  style="width: 100%; margin-top: 20px">Submit your part</button>
</form>
</body>
</html>