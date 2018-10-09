private static Vector addCandidates(Method[] methods, String methodName, int numArgs, boolean publicOnly, Vector candidates) {
    for (int i = 0; i < methods.length; i++) {
        Method m = methods[i];
        if (m.getName().equals(methodName) && (m.getParameterTypes().length == numArgs) && (!publicOnly || isPublic(m)))
            candidates.add(m);
    }
    return candidates;
}