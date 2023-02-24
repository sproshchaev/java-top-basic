<%--@elvariable id="stories"
type="java.util.Set<com.acadamy.Story>"--%>
<!DOCTYPE html>
<html>
<head>
    <title>News</title>
</head>
<body>
<h1>Latest News</h1>
<c:choose>
    <c:when test="${fn:length(stories) == 0}">
        <b>There are no news today.</b>
    </c:when>
    <c:otherwise>
        <c:forEach items="${stories}" var="story">
            <b>
            <c:out value="Title: ${story.title}" />
            <br />
            <c:out value=
                           "Category: ${story.category}" />
            <br />
            <c:out value="Date: ${story.
dateStory}" /><br />
            </b>
            <c:out value="${story.content}" /><br />
            <c:if test="${story.author != null}">
                Author: ${story.author}<br />
            </c:if>
            Date created: ${story.dateCreatedStory}
            <br /><br />
        </c:forEach>
    </c:otherwise>
</c:choose>
</body>
</html>