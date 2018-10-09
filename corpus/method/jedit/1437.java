private void initRootSystemObject() {
    BshClassManager bcm = getClassManager();
    // bsh
    setu("bsh", new NameSpace(bcm, "Bsh Object").getThis(this));
    // init the static shared sharedObject if it's not there yet
    if (sharedObject == null)
        sharedObject = new NameSpace(bcm, "Bsh Shared System Object").getThis(this);
    // bsh.system
    setu("bsh.system", sharedObject);
    // alias
    setu("bsh.shared", sharedObject);
    // bsh.help
    This helpText = new NameSpace(bcm, "Bsh Command Help Text").getThis(this);
    setu("bsh.help", helpText);
    // bsh.cwd
    try {
        setu("bsh.cwd", System.getProperty("user.dir"));
    } catch (SecurityException e) {
        setu("bsh.cwd", ".");
    }
    // bsh.interactive
    setu("bsh.interactive", new Primitive(interactive));
    // bsh.evalOnly
    setu("bsh.evalOnly", new Primitive(evalOnly));
}