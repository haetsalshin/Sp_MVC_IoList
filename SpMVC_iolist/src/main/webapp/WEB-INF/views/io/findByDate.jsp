<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri ="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />    
<!DOCTYPE html>
<html lang="ko">
  <head>
  <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <style>
      * {
        box-sizing: border-box;
        margin: 0;
        padding: 0;
      }
      html,
      body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
      #section-main {
        border: 1px solid crimson;
        margin: 30px auto;
        padding: 20px;
        display: inline-block;
      }
      h3{
          padding: 20px;
          text-align: center;
      }

      #section-date{
          padding: 10px;
          height: 100px;
      }

      #search-btn{
          display: inline-block;
      }
      table#io-table {
        align-items: center;
        padding: 10px;
        margin: 20px auto;
        width: 80%;
        border-top: 1px solid black;
        border-collapse: collapse;
      }
      table#io-table th,
      table#io-table tr td {
        border-bottom: 1px solid black;
        text-align: center;
      }
      table#io-table th {
        padding: 14px;
        background-color: palegoldenrod;
      }
      table#io-table tr td {
        padding: 7px;
      }
      table#io-table tr td:nth-child(1) {
        width: 8px;
      }
      h3 {
        text-align: center;
        margin: 40px auto;
        font-style: italic;
      }

      #save-btn {
        display: flex;
        margin: 10px auto;
        border: none;
      }

    </style>
</head>
<body>
<section id="section-main">
      <form">
        <p id="p-h3"><h3>일자별 검색</h3></p>
            <section id="section-date">
                <input type="date" id="io_firstday" value="io_firstday" />
                <input type="date" id="io_lastday"  value="io_lastday"/>
            </section>
        <button type="submit" id="search-btn">검색하기</button>
      </form>
    </section>
    <section id="list">
        <h3>💥 매입 매출 리스트 💥</h3>
        <table id="io-table">
          <th>SEQ</th>
          <th>일자</th>
          <th>시각</th>
          <th>상품명</th>
          <th>구분</th>
          <th>단가</th>
          <th>수량</th>
          <th>합계</th>
          <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
        </table>
    </section>
</body>
</html>