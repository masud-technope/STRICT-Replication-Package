/**
        @param bcp URLs JARClassLoader seems to require absolute paths
    */
public  BshClassLoader(BshClassManager classManager, BshClassPath bcp) {
    this(classManager, bcp.getPathComponents());
}