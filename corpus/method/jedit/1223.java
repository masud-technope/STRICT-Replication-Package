/**
        @param bases URLs JARClassLoader seems to require absolute paths
    */
public  BshClassLoader(BshClassManager classManager, URL[] bases) {
    super(bases);
    this.classManager = classManager;
}