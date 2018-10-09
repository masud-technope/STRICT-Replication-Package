/*
        This method should parallel findMostSpecificMethod()
		The only reason it can't be combined is that Method and Constructor
		don't have a common interface for their signatures
    */
static Constructor findMostSpecificConstructor(Class[] idealMatch, Constructor[] constructors) {
    int match = findMostSpecificConstructorIndex(idealMatch, constructors);
    return (match == -1) ? null : constructors[match];
}