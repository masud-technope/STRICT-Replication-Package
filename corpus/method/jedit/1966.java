void jjtreeOpenNodeScope(Node n) {
    ((SimpleNode) n).firstToken = getToken(1);
}