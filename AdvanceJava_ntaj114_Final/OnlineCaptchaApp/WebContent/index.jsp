<%@ page import="net.tanesha.recaptcha.*"%>

<form action="process.jsp" method="post">
	<%
		//ReCaptcha c = ReCaptchaFactory.newReCaptcha("your_public_key", "your_private_key", false);
		ReCaptcha captcha = ReCaptchaFactory.newReCaptcha("6Ld7mxgUAAAAAPnxCunrDjIu3DKtnIcMs3T-MPhG",
				"6Ld7mxgUAAAAADBiVAML_y0bH_i2_5BCIqm3kM5y", false);
		out.print(captcha.createRecaptchaHtml(null, null));
	%>
	<input type="submit" value="submit" />
</form>
</body>
</html>
