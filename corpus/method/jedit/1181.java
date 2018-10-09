boolean isStatic(SimpleNode node) {
    if (node instanceof BSHTypedVariableDeclaration)
        return ((BSHTypedVariableDeclaration) node).modifiers != null && ((BSHTypedVariableDeclaration) node).modifiers.hasModifier("static");
    if (node instanceof BSHMethodDeclaration)
        return ((BSHMethodDeclaration) node).modifiers != null && ((BSHMethodDeclaration) node).modifiers.hasModifier("static");
    // need to add static block here
    if (node instanceof BSHBlock)
        return false;
    return false;
}