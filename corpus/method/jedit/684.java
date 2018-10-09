//{{{ BeanShellFacade constructor
protected  BeanShellFacade() {
    classManager = new ClassManagerImpl();
    global = new NameSpace(classManager, "jEdit embedded BeanShell interpreter");
    interpForMethods = createInterpreter(global);
    init();
}