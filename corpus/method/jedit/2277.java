public static void setIndex(Object array, int index, Object val) throws ReflectError, UtilTargetError {
    try {
        val = Primitive.unwrap(val);
        Array.set(array, index, val);
    } catch (ArrayStoreException e2) {
        throw new UtilTargetError(e2);
    } catch (IllegalArgumentException e1) {
        throw new UtilTargetError(new ArrayStoreException(e1.toString()));
    } catch (Exception e) {
        throw new ReflectError("Array access:" + e);
    }
}