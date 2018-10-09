@Override
protected void setupDefaultVariables(NameSpace namespace, View view) throws UtilEvalError {
    if (view != null) {
        EditPane editPane = view.getEditPane();
        setVariable(namespace, "view", view);
        setVariable(namespace, "editPane", editPane);
        setVariable(namespace, "buffer", editPane.getBuffer());
        setVariable(namespace, "textArea", editPane.getTextArea());
        setVariable(namespace, "wm", view.getDockableWindowManager());
    }
}