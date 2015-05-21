<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <script src="static/js/shirt.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Shirts</title>
    </head>
    <body>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
        <a href='s'>servlet</a> | <a href='http://imbi.ld.ttu.ee/tomcat_webapp_logs/t093817_Shirt/log.txt'>log</a> <br>
        Shitrs list: 
        <br>
        <table border=1 cellpadding=2 cellspacing=1>
            <tr bgcolor='#cccccc'>
                <td><STRONG> id&nbsp;</td>
                <td><STRONG>Size&nbsp;</td>
                <td><STRONG>Shirt cost&nbsp;</td>
                <td><STRONG>description&nbsp;</td>
                <td>link</td>
            </tr>
            <tr></tr>
            <c:forEach var="shirt" items="${shirts}" >
                <TR BGCOLOR='#FFFFFF' ><TD  nowrap>
                        &nbsp${shirt.id}&nbsp;</TD>
                    <TD>${shirt.size}&nbsp</TD>
                    <TD>${shirt.cost}&nbsp</TD>
                    <TD>
                        <a href='javascript:showDescription("${shirt.id}")' target='_self'>Description</a>&nbsp
                    </TD>
                    <TD align='top' nowrap>
                        <a HREF='s?id=${shirt.id}' TARGET='_self'><b><u>change</u><b></a>
                    </TD>
                </TR>
            </c:forEach>
        </table>

        <br>
        <br>
        <div ID="ajax_response">
        </div>
        <div ID="description_form" style="visibility:hidden;">
            <form name=description_form>
                <TABLE BGCOLOR='#cccccc'>
                    <TR BGCOLOR='#ffffff'><TD BGCOLOR='#eeeeee' COLSPAN=2>Description</TD></tr>
                    <TR BGCOLOR='#ffffff'><TD BGCOLOR='#cccccc' nowrap>Shirt id</td><td BGCOLOR='#cccccc'><input type=text name=shirt_id size=4 disabled id='id'></TD></tr>
                    <TR BGCOLOR='#ffffff'><TD BGCOLOR='#cccccc' nowrap>Description</td><td BGCOLOR='#cccccc'><textarea name=description cols=25 rows=5 id="desc"></textarea></TD></tr>
                    <TR BGCOLOR='#ffffff'><TD BGCOLOR='#cccccc' nowrap COLSPAN=2><input type="button" value="HIDE" onClick="hide_description_form()"></TD></tr>
                </TABLE>
            </form>
        </div>
    </body>
</html>