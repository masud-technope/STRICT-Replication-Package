/**
		Test if a conversion of the rhsType type to the lhsType type is legal via
	 standard Java assignment conversion rules (i.e. without a cast).
	 The rules include Java 5 autoboxing/unboxing.
		<p/>

		For Java primitive TYPE classes this method takes primitive promotion
		into account.  The ordinary Class.isAssignableFrom() does not take
		primitive promotion conversions into account.  Note that Java allows
		additional assignments without a cast in combination with variable
		declarations and array allocations.  Those are handled elsewhere
	 	(maybe should be here with a flag?)
		<p/>
		This class accepts a null rhsType type indicating that the rhsType was the
		value Primitive.NULL and allows it to be assigned to any reference lhsType
		type (non primitive).
		<p/>

		Note that the getAssignableForm() method is the primary bsh method for
		checking assignability.  It adds additional bsh conversions, etc.

		@see #isBshAssignable( Class, Class )
		@param lhsType assigning from rhsType to lhsType
		@param rhsType assigning from rhsType to lhsType
	*/
static boolean isJavaAssignable(Class lhsType, Class rhsType) {
    return isJavaBaseAssignable(lhsType, rhsType) || isJavaBoxTypesAssignable(lhsType, rhsType);
}