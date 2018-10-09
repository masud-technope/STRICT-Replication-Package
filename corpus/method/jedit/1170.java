@SuppressWarnings("unchecked")
public static ClassGenerator getClassGenerator() throws UtilEvalError {
    if (cg == null) {
        try {
            Class clas = Class.forName("org.gjt.sp.jedit.bsh.ClassGeneratorImpl");
            cg = (ClassGenerator) clas.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new Unavailable("ClassGenerator unavailable: " + e);
        }
    }
    return cg;
}