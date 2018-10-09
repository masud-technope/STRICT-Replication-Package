public static Object getIndex(Object array, int index) throws ReflectError, UtilTargetError {
    if (Interpreter.DEBUG)
        Interpreter.debug("getIndex: " + array + ", index=" + index);
    try {
        Object val = Array.get(array, index);
        return Primitive.wrap(val, array.getClass().getComponentType());
    } catch (ArrayIndexOutOfBoundsException e1) {
        throw new UtilTargetError(e1);
    } catch (Exception e) {
        throw new ReflectError("Array access:" + e);
    }
}