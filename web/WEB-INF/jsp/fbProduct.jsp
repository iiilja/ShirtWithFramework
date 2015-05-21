<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head prefix=
          "og: http://ogp.me/ns# 
          fb: http://ogp.me/ns/fb# 
          product: http://ogp.me/ns/product#">
        <meta property="og:type" content="og:product" />
        <meta property="og:title"                  content="${product.description}" />
    <c:if test="${product.imageUrl != null}">
        <meta property="og:image"                  content="${product.imageUrl}" />
    </c:if>
        <meta property="og:description"            content="${product.description}" />
        <meta property="og:url"                    content="http://riseofmachines.net/service/facebook/product.html?productId=${product.productId}" />
        <meta property="og:plural_title"           content="${product.description}" />
    <c:forEach var="currency" items="${productCurrencies}" >
        <meta property="product:price:amount"      content="${currency.price}"/>
        <meta property="product:price:currency"    content="${currency.currency}"/>
    </c:forEach>
    </head>
</html>

