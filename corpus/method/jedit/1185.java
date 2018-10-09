boolean classContainsMethod(Class clas, String methodName, String[] paramTypes) {
    while (clas != null) {
        Method[] methods = clas.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            if (methods[i].getName().equals(methodName)) {
                String[] methodParamTypes = getTypeDescriptors(methods[i].getParameterTypes());
                boolean found = true;
                for (int j = 0; j < methodParamTypes.length; j++) {
                    if (!paramTypes[j].equals(methodParamTypes[j])) {
                        found = false;
                        break;
                    }
                }
                if (found)
                    return true;
            }
        }
        clas = clas.getSuperclass();
    }
    return false;
}