static int findMostSpecificConstructorIndex(Class[] idealMatch, Constructor[] constructors) {
    Class[][] candidates = new Class[constructors.length][];
    for (int i = 0; i < candidates.length; i++) candidates[i] = constructors[i].getParameterTypes();
    return findMostSpecificSignature(idealMatch, candidates);
}