@Override
protected void resetDefaultVariables(NameSpace namespace) throws UtilEvalError {
    namespace.setVariable("view", null, false);
    namespace.setVariable("editPane", null, false);
    namespace.setVariable("buffer", null, false);
    namespace.setVariable("textArea", null, false);
    namespace.setVariable("wm", null, false);
}