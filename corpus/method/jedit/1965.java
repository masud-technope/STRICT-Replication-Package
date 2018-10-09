void jjtreeCloseNodeScope(Node n) {
    ((SimpleNode) n).lastToken = getToken(0);
}