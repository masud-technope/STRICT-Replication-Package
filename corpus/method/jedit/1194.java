static String getMethodDescriptor(String returnType, String[] paramTypes) {
    StringBuilder sb = new StringBuilder("(");
    for (int i = 0; i < paramTypes.length; i++) sb.append(paramTypes[i]);
    sb.append(")" + returnType);
    return sb.toString();
}