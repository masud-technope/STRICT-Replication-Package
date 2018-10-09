/**
		A BshClassPath initialized to the user path
		from java.class.path
	*/
public static BshClassPath getUserClassPath() throws ClassPathException {
    if (userClassPath == null)
        userClassPath = new BshClassPath("User Class Path", getUserClassPathComponents());
    return userClassPath;
}