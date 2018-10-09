public BshClassManager getClassManager() {
    if (classManager != null)
        return classManager;
    if (parent != null && parent != JAVACODE)
        return parent.getClassManager();
    System.out.println("experiment: creating class manager");
    classManager = BshClassManager.createClassManager(null);
    //Interpreter.debug("No class manager namespace:" +this);
    return classManager;
}