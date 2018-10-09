/**
		Use direct Class.forName() to test for the existence of a class.
		We should not use BshClassManager here because:
			a) the systems using these tests would probably not load the
			classes through it anyway.
			b) bshclassmanager is heavy and touches other class files.  
			this capabilities code must be light enough to be used by any
			system **including the remote applet**.
	*/
public static boolean classExists(String name) {
    Object c = classes.get(name);
    if (c == null) {
        try {
            /*
					Note: do *not* change this to 
					BshClassManager plainClassForName() or equivalent.
					This class must not touch any other bsh classes.
				*/
            c = Class.forName(name);
        } catch (ClassNotFoundException e) {
        }
        if (c != null)
            classes.put(c, "unused");
    }
    return c != null;
}