private Object completeRound(String lastEvalName, String nextEvalName, Object returnObject) {
    if (returnObject == null)
        throw new InterpreterError("lastEvalName = " + lastEvalName);
    this.lastEvalName = lastEvalName;
    this.evalName = nextEvalName;
    this.evalBaseObject = returnObject;
    return returnObject;
}