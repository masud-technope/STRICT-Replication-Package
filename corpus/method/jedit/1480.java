void clearNodeScope(Node n) {
    while (sp > mk) {
        popNode();
    }
    mk = ((Integer) marks.pop()).intValue();
}