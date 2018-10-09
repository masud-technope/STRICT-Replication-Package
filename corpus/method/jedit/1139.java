BSHVariableDeclarator[] getDeclarators() {
    int n = jjtGetNumChildren();
    int start = 1;
    BSHVariableDeclarator[] bvda = new BSHVariableDeclarator[n - start];
    for (int i = start; i < n; i++) {
        bvda[i - start] = (BSHVariableDeclarator) jjtGetChild(i);
    }
    return bvda;
}