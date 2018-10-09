@Override
protected void resetDefaultVariables(NameSpace namespace) throws UtilEvalError {
    namespace.setVariable("buffer", null, false);
    namespace.setVariable("textArea", null, false);
}