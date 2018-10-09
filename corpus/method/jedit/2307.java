private static void logInvokeMethod(String msg, Method method, Object[] args) {
    if (Interpreter.DEBUG) {
        Interpreter.debug(msg + method + " with args:");
        for (int i = 0; i < args.length; i++) Interpreter.debug("args[" + i + "] = " + args[i] + " type = " + args[i].getClass());
    }
}