<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit person</title>
</head>
<body>
<h3>Edit person</h3>
<form method="post">
    <input type="hidden" value="${person.id}" name="id" />
    <label>FirstName</label><br>
    <input name="firstname" value="${person.firstname}" /><br><br>

    <label>MiddleName</label><br>
    <input name="middlename" value="${person.middlename}" /><br><br>

    <label>LastName</label><br>
    <input name="lastname" value="${person.lastname}" /><br><br>

    <label>Age</label><br>
    <input type="date" name="age" value="${person.age}"/> <br><br>

    <label>Gender</label><br>
    <input name="gender" value="${person.gender}" /><br><br>

    <input type="submit" value="Send" />
</form>
</body>
</html>