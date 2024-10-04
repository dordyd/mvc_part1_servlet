<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="org.springframework.beans.factory.annotation.Autowired" %>
<%@ page import="hello.servlet.domain.member.MemoryMemberRepository" %>
<%@ page import="org.apache.catalina.core.ApplicationContext" %>
<%@ page import="org.springframework.context.annotation.AnnotationConfigApplicationContext" %>
<%@ page import="hello.servlet.AutoAppConfig" %>
<

<%
    org.springframework.context.ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

    MemberRepository memberRepository = ac.getBean(MemberRepository.class);

    System.out.println("save.jsp");
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));

    Member member = new Member(username, age);
    System.out.println("member = " + member);
    memberRepository.save(member);

%>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <li>id=<%=member.getId()%>
    </li>
    <li>username=<%=member.getUsername()%>
    </li>
    <li>age=<%=member.getAge()%>
    </li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
