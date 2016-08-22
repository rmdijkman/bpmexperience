<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<%@ include file="_header.jsp"%>
<body>
	<%@ include file="_menu.jsp"%>
</body>
<script>
BootstrapDialog.show({
    title: '${title}',
    message: '${message}',
    buttons: [{
        label: 'Ok',
        action: function(dialog) {
        	window.location.replace('${pageContext.request.contextPath}${redirect}');
        }
    }]
    
});
</script>
</html>