<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    protected String str = "simple string";
    // Описание ниже, не является объявлением
// и приведет к синтаксической ошибке
// str = "test string";
    private final float a = 1.11F;
    public float addNum(float num)
    {
        return num + 1.5F;
    }
    public class ExampleInnerClass { }
    ExampleInnerClass obj1 = new ExampleInnerClass();
// ExampleClass имеет другую область видимости,
// поэтому объявление ниже является
// синтаксической ошибкой
// ExampleClass obj2 = new ExampleClass();
%>
<%
    class ExampleClass { }
    ExampleClass obj3 = new ExampleClass();
    ExampleInnerClass obj4 = new ExampleInnerClass();
    long b;
    b = 7L;
%>
<%= "To be, or not to be, that is the question" %>
<br/>
<%= addNum(a) %>
