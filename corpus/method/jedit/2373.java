/**
        Allow invocations of these method names on This type objects.
        Don't give bsh.This a chance to override their behavior.
        <p>

        If the method is passed here the invocation will actually happen on
        the bsh.This object via the regular reflective method invocation
        mechanism.  If not, then the method is evaluated by bsh.This itself
        as a scripted method call.
    */
static boolean isExposedThisMethod(String name) {
    return name.equals("getClass") || name.equals("invokeMethod") || name.equals("getInterface") || // These are necessary to let us test synchronization from scripts
    name.equals("wait") || name.equals("notify") || name.equals("notifyAll");
}