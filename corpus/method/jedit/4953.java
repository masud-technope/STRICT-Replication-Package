@Override
protected void setupDefaultVariables(NameSpace namespace, TextArea textArea) throws UtilEvalError {
    if (textArea != null) {
        setVariable(namespace, "buffer", textArea.getBuffer());
        setVariable(namespace, "textArea", textArea);
    }
}