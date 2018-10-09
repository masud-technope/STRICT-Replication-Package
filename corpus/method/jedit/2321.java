/*
		TODO: this is not unicode friendly, nor is getFile()
		The output is urlencoded 8859_1 text.
		should probably be urlencoded UTF-8... how does the servlet determine
		the encoded charset?  I guess we're supposed to add a ";charset" clause
		to the content type?
	*/
@SuppressWarnings({ "deprecation" })
static String doHttp(String postURL, String text) {
    String returnValue = null;
    StringBuilder sb = new StringBuilder();
    sb.append("bsh.client=Remote");
    sb.append("&bsh.script=");
    sb.append(URLEncoder.encode(text));
    /*
		// This requires Java 1.3
		try {
			sb.append( URLEncoder.encode( text, "8859_1" ) );
		} catch ( UnsupportedEncodingException e ) {
			e.printStackTrace();
		}
		*/
    String formData = sb.toString();
    try {
        URL url = new URL(postURL);
        HttpURLConnection urlcon = (HttpURLConnection) url.openConnection();
        urlcon.setRequestMethod("POST");
        urlcon.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
        urlcon.setDoOutput(true);
        urlcon.setDoInput(true);
        PrintWriter pout = new PrintWriter(new OutputStreamWriter(urlcon.getOutputStream(), "8859_1"), true);
        pout.print(formData);
        pout.flush();
        // read results...
        int rc = urlcon.getResponseCode();
        if (rc != HttpURLConnection.HTTP_OK)
            System.out.println("Error, HTTP response: " + rc);
        returnValue = urlcon.getHeaderField("Bsh-Return");
        BufferedReader bin = new BufferedReader(new InputStreamReader(urlcon.getInputStream()));
        String line;
        while ((line = bin.readLine()) != null) System.out.println(line);
        System.out.println("Return Value: " + returnValue);
    } catch (MalformedURLException e) {
        System.out.println(e);
    } catch (IOException e2) {
        System.out.println(e2);
    }
    return returnValue;
}