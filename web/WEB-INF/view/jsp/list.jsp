<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <!-- import jquery 3.x -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>

  <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

  <!-- Optional theme -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

  <!-- Latest compiled and minified JavaScript -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
  <link type="text/css" rel="stylesheet" href="css/list.css">
</head>
<body>
<div class="table-responsive">
  <div class="table col-md-12">
    <div class="tHead row">
      <div class="col-md-4 text-center">Rank</div>
      <div class="col-md-4 text-center">State</div>
      <div class="col-md-4 text-center">Name</div>
    </div>
    <c:set var="rank" value="1"/>
    <c:forEach var="vo" items="${list }">

      <div class="body row">
        <div class="rankDiv col-md-4 text-center">${rank }</div>
        <div class="stateDiv col-md-4">
          <div class="imgDiv">
            <img src="resource/images/tier_icons/${vo.tier }_${vo.division}.png"/>
          </div>
          <div class="textDiv text-center">
            <div>${vo.tier } ${vo.division }</div>
            <div>${vo.leaguePoints }LP / ${vo.wins }승 ${vo.losses }패</div>
            <div>승률 <fmt:formatNumber value="${rate+(1-(rate%1))%1 }" type="number"/>%</div>
            <div>영선님 사랑해요</div>
          </div>
        </div>
        <div class="nameDiv col-md-4 text-center">${vo.name }</div>
        <c:set var="rank" value="${rank+1 }"/>
      </div>
    </c:forEach>
  </div>
</div>
</body>
</html>