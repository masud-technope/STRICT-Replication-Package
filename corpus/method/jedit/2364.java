public void run() {
    try {
        invokeMethod("run", new Object[0]);
    } catch (EvalError e) {
        declaringInterpreter.error("Exception in runnable:" + e);
    }
}