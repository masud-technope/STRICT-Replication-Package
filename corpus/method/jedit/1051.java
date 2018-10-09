void insureParsed() {
    if (paramNames != null)
        return;
    this.numArgs = jjtGetNumChildren();
    String[] paramNames = new String[numArgs];
    for (int i = 0; i < numArgs; i++) {
        BSHFormalParameter param = (BSHFormalParameter) jjtGetChild(i);
        paramNames[i] = param.name;
    }
    this.paramNames = paramNames;
}