/**
		Get the boot path including the lib/rt.jar if possible.
	*/
public static BshClassPath getBootClassPath() throws ClassPathException {
    if (bootClassPath == null) {
        try {
            //String rtjar = System.getProperty("java.home")+"/lib/rt.jar";
            String rtjar = getRTJarPath();
            URL url = new File(rtjar).toURI().toURL();
            bootClassPath = new BshClassPath("Boot Class Path", new URL[] { url });
        } catch (MalformedURLException e) {
            throw new ClassPathException(" can't find boot jar: " + e);
        }
    }
    return bootClassPath;
}