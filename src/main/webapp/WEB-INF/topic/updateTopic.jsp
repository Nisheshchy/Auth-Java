<%-- Created by IntelliJ IDEA. User: Nishesh Date: 4/24/2026 Time: 12:55 PM To change this template use File | Settings
  | File Templates. --%>
  <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>

    <head>
      <title>Update Topic</title>
    </head>

    <body>
      <form action="update-topic" method="post">
        <input name="id" type="hidden" value="${topic.getId()}" />
        <label>Topic Name</label>
        <input name="topic_name" value="${topic.getName()}" />
        <button type="submit">Update Topic</button>
      </form>

    </body>

    </html>