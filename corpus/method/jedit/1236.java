/**
		call map(url) for each url in the array
	*/
synchronized void map(URL[] urls) {
    for (int i = 0; i < urls.length; i++) try {
        map(urls[i]);
    } catch (IOException e) {
        String s = "Error constructing classpath: " + urls[i] + ": " + e;
        errorWhileMapping(s);
    }
}