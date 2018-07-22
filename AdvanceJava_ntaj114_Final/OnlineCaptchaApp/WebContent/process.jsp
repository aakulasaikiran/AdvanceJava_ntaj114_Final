<%@ page import="net.tanesha.recaptcha.*"%>


	<%
	   //get browser machine IP address
        String remoteAddr = request.getRemoteAddr();
        //connect to google store 
        ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
        reCaptcha.setPrivateKey("6Ld7mxgUAAAAADBiVAML_y0bH_i2_5BCIqm3kM5y");
        
         //read captch challege,answer content
        String challenge = request.getParameter("recaptcha_challenge_field");
        String answer = request.getParameter("recaptcha_response_field");
        //verify
        ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteAddr, challenge, answer);

        if (reCaptchaResponse.isValid()) {
          out.print("<h1>Valid response</h1>");
        } else {
          out.print("<h1>invalid response</h1>");
        }
      %>
</body>
</html>