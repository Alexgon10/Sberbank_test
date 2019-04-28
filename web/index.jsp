<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" type="text/css" href="/WEB-INF/css/buttonstyle.css.css">     <!--НЕ ПОДКЛЮЧИЛИСЬ ФАЙЛЫ CSS,ПОЭТОМУ ПРОПИСАНЫ В JSP-->
  <title>Persons</title>
</head>
<body>
<form>
  <input type="button" value="Add person"  class="btn" onclick="showModalWin()">
  <style>
    .btn {
      position: relative;
      overflow: hidden;
      z-index: 1;
      padding: 5px 30px;
      margin: 0 20px;
      font-family: 'Montserrat Alternates', sans-serif;
      font-weight: 600;
      line-height: 30px;
      color: white;
      font-size: 10px;
      text-transform: uppercase;
      background: #f5b08f;
      border-width: 0;
      box-shadow: 5px 5px 0 #532831;
      outline: none;
      cursor: pointer;
      transition: 1.5s;
    }
    .btn:before,
    .btn:after {
      content: "";
      position: absolute;
      height: 200px;
      left: -50%;
      margin-top: -100px;
      top: 50%;
      width: 200px;
      border-radius: 50%;
      opacity: 0.3;
      z-index: -1;
      transform: scale(0);
    }
    .btn:before {
      background: #ffeede;
      transition: .8s ease-out;
    }
    .btn:after {
      transition: .4s ease-in .3s;
    }
    .btn:hover {
      color: #532831;
    }
    .btn:hover:before,
    .btn:hover:after{
      opacity: 1;
      transform: scale(4);
    }
  </style>
</form>

<table>
  <tr><th>First Name</th><th>Middle Name</th><th>Last Name</th><th>Age</th><th>Gender</th><th></th></tr>
  <c:forEach var="person" items="${persons}">
    <</><td>${person.firstname}</td>
      <td>${person.middlename}</td>
      <td>${person.lastname}</td>
      <td>${person.age}</td>
      <td>${person.gender}</td>
      <td>
         <a href='<c:url value="/edit?id=${person.id}" />'>Edit</a>|
        <form method="post" action='<c:url value="/delete" />' style="display:inline;">
          <input type="hidden"  name="id" value="${person.id}">
          <input type="submit" class="delete"   value="Delete">
        </form>
      </td></tr>
  </c:forEach>
</table>
<style>
  .delete {
    background: #f57f21;
    color: white;
  }
  </style>


<style>
  table {
    font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
    text-align: left;
    border-collapse: separate;
    border-spacing: 5px;
    background: #ECE9E0;
    color: #656665;
    border: 16px solid #ECE9E0;
    border-radius: 20px;
  }
  th {
    font-size: 18px;
    padding: 10px;
  }
  td {
    background: #F5D7BF;
    padding: 10px;
  }</style>

  <head>
    <style>
      .modalwin {
        height: 350px;
        width: 300px;
        border: 3px outset gray;
        background: #f5a456;
        top: 20%;
        right: 0;
        left: 0;
        font-size: 14px;
        margin: 0 auto;
        z-index:2;
        display: none;
        position: fixed;
        padding: 15px;
        border: 1px solid #383838;
      }
      #shadow {
        position: fixed;
        width:100%;
        height:100%;
        z-index:1;
        background:#000;
        opacity: 0.5;
        left:0;
        top:0;
      }
    </style>
    <script type="text/javascript">
      function showModalWin() {

        var darkLayer = document.createElement('div');
        darkLayer.id = 'shadow';
        document.body.appendChild(darkLayer);

        var modalWin = document.getElementById('popupWin');
        modalWin.style.display = 'block';

        darkLayer.onclick = function () {
          darkLayer.parentNode.removeChild(darkLayer);
          modalWin.style.display = 'none';
          return false;
        };
      }
    </script>
  </head>

  <body>
  <div style="text-align: center" id="popupWin" class="modalwin">
    <h2> Add Person </h2>
    <form method="post" action="/create">
      <label>First name:<br/>
        <input type="text" name="firstname" ><br />
      </label>
      <label>Middle name:<br/>
        <input type="text" name="middlename"><br />
      </label>
      <label>Last name:<br/>
        <input type="text" name="lastname"><br />
      </label>
      <label>Birthday:<br/>
        <label>
          <input type="date" name="age"><br />
        </label>
      </label>
      Gender: <input type="radio" name="gender" value="female" checked />Female
      <input type="radio" name="gender" value="male" />Male
      <br/>
      <button type="submit" class="btn" >Add person</button>
    </form>
  </div>
  </body>
  <body>

</body>
</body>
</html>