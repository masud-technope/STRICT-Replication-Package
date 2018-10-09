static String doBsh(String url, String text) {
    OutputStream out;
    InputStream in;
    String host = "";
    String port = "";
    String returnValue = "-1";
    String orgURL = url;
    // Need some format checking here
    try {
        // remove the bsh://
        url = url.substring(6);
        // get the index of the : between the host and the port is located
        int index = url.indexOf(":");
        host = url.substring(0, index);
        port = url.substring(index + 1, url.length());
    } catch (Exception ex) {
        System.err.println("Bad URL: " + orgURL + ": " + ex);
        return returnValue;
    }
    try {
        System.out.println("Connecting to host : " + host + " at port : " + port);
        Socket s = new Socket(host, Integer.parseInt(port) + 1);
        out = s.getOutputStream();
        in = s.getInputStream();
        sendLine(text, out);
        BufferedReader bin = new BufferedReader(new InputStreamReader(in));
        String line;
        while ((line = bin.readLine()) != null) System.out.println(line);
        // Need to scrape a value from the last line?
        returnValue = "1";
        return returnValue;
    } catch (Exception ex) {
        System.err.println("Error communicating with server: " + ex);
        return returnValue;
    }
}