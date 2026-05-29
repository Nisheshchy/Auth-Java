<%-- Created by IntelliJ IDEA. User: Nishesh Date: 4/17/2026 Time: 01:14 PM To change this template use File | Settings
  | File Templates. --%>
  <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      <html>

      <head>
        <title>All Topics</title>
      </head>

      <body>
        <div>
          <a href="add-topic">Add Topic</a>
        </div>
        <div>
          <table border="1">
            <tr>
              <th>Id</th>
              <th>name</th>
              <th>Created At</th>
              <th>Updated At</th>
              <th>Action</th>
            </tr>
            <c:forEach var="topic" items="${topics}">
              <tr>
                <td>${topic.getId()}</td>
                <td>${topic.getName()}</td>
                <td>${topic.getCreatedAt()}</td>
                <td>${topic.getUpdatedAt()}</td>
                <td>
                  <a href="update-topic?id=${topic.getId()}">
                    <button>Updated</button>
                  </a>
                  <button>Delete</button>
                </td>
              </tr>
            </c:forEach>

          </table>
        </div>
      </body>

      </html>