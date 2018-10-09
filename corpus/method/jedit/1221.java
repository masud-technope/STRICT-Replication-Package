/**
        For use by children
        @param classManager URLs JARClassLoader seems to require absolute paths
    */
protected  BshClassLoader(BshClassManager classManager) {
    this(classManager, new URL[] {});
}