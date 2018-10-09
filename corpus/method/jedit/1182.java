public boolean isVisible(SimpleNode node) {
    if (context == CLASSES)
        return node instanceof BSHClassDeclaration;
    // Only show class decs in CLASSES
    if (node instanceof BSHClassDeclaration)
        return false;
    if (context == STATIC)
        return isStatic(node);
    if (context == INSTANCE)
        return !isStatic(node);
    // ALL
    return true;
}