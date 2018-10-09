static Variable[] getDeclaredVariables(BSHBlock body, CallStack callstack, Interpreter interpreter, String defaultPackage) {
    List vars = new ArrayList();
    for (int child = 0; child < body.jjtGetNumChildren(); child++) {
        SimpleNode node = (SimpleNode) body.jjtGetChild(child);
        if (node instanceof BSHTypedVariableDeclaration) {
            BSHTypedVariableDeclaration tvd = (BSHTypedVariableDeclaration) node;
            Modifiers modifiers = tvd.modifiers;
            String type = tvd.getTypeDescriptor(callstack, interpreter, defaultPackage);
            BSHVariableDeclarator[] vardec = tvd.getDeclarators();
            for (int i = 0; i < vardec.length; i++) {
                String name = vardec[i].name;
                try {
                    Variable var = new Variable(/*value*/
                    name, type, null, modifiers);
                    vars.add(var);
                } catch (UtilEvalError e) {
                }
            }
        }
    }
    return (Variable[]) vars.toArray(new Variable[0]);
}