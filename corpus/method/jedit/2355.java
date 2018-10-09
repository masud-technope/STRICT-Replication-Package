public Throwable getTarget() {
    // check for easy mistake
    if (target instanceof InvocationTargetException)
        return ((InvocationTargetException) target).getTargetException();
    else
        return target;
}