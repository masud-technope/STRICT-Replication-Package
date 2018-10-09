/**
		Return the singleton bsh ReflectManager.
		@throws Unavailable    // weirdness with mode file, leave in the tab preceding this comment
	*/
@SuppressWarnings("unchecked")
public static ReflectManager getReflectManager() throws Unavailable {
    if (rfm == null) {
        Class clas;
        try {
            clas = Class.forName("org.gjt.sp.jedit.bsh.reflect.ReflectManagerImpl");
            rfm = (ReflectManager) clas.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new Unavailable("Reflect Manager unavailable: " + e);
        }
    }
    return rfm;
}