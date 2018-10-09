public static void setAccessibility(boolean b) throws Unavailable {
    if (b == false) {
        accessibility = false;
        return;
    }
    if (!classExists("java.lang.reflect.AccessibleObject") || !classExists("org.gjt.sp.jedit.bsh.reflect.ReflectManagerImpl"))
        throw new Unavailable("Accessibility unavailable");
    // test basic access
    try {
        String.class.getDeclaredMethods();
    } catch (SecurityException e) {
        throw new Unavailable("Accessibility unavailable: " + e);
    }
    accessibility = true;
}