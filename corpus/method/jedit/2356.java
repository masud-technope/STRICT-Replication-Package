public  TargetError(String msg, Throwable t, SimpleNode node, CallStack callstack, boolean inNativeCode) {
    super(msg, node, callstack);
    target = t;
    this.inNativeCode = inNativeCode;
}