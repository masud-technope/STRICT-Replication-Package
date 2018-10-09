/**
        Import standard packages.  Currently:
        <pre>
            importClass("org.gjt.sp.jedit.bsh.EvalError");
            importClass("org.gjt.sp.jedit.bsh.Interpreter");
            importPackage("javax.swing.event");
            importPackage("javax.swing");
            importPackage("java.awt.event");
            importPackage("java.awt");
            importPackage("java.net");
            importPackage("java.util");
            importPackage("java.io");
            importPackage("java.lang");
            addCommandPath("/org/gjt/sp/jedit/bsh/commands",getClass());
        </pre>
    */
public void loadDefaultImports() {
    /**
            Note: the resolver looks through these in reverse order, per
            precedence rules...  so for max efficiency put the most common
            ones later.
        */
    importClass("org.gjt.sp.jedit.bsh.EvalError");
    importClass("org.gjt.sp.jedit.bsh.Interpreter");
    importPackage("javax.swing.event");
    importPackage("javax.swing");
    importPackage("java.awt.event");
    importPackage("java.awt");
    importPackage("java.net");
    importPackage("java.util");
    importPackage("java.io");
    importPackage("java.lang");
    addCommandPath("/org/gjt/sp/jedit/bsh/commands", getClass());
}