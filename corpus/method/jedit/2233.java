public static boolean isWrapperType(Class type) {
    return wrapperMap.get(type) != null && !type.isPrimitive();
}