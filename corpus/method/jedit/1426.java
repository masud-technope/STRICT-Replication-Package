static void staticInit() {
    /*
		Apparently in some environments you can't catch the security exception
		at all...  e.g. as an applet in IE  ... will probably have to work
		around
	*/
    try {
        systemLineSeparator = System.getProperty("line.separator");
        debug = System.err;
        DEBUG = Boolean.getBoolean("debug");
        TRACE = Boolean.getBoolean("trace");
        LOCALSCOPING = Boolean.getBoolean("localscoping");
        String outfilename = System.getProperty("outfile");
        if (outfilename != null)
            redirectOutputToFile(outfilename);
    } catch (SecurityException e) {
        System.err.println("Could not init static:" + e);
    } catch (Exception e) {
        System.err.println("Could not init static(2):" + e);
    } catch (Throwable e) {
        System.err.println("Could not init static(3):" + e);
    }
}