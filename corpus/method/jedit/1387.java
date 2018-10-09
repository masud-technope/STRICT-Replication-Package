/*
		Note: the meaning of getDeclaredVariables() is not entirely clear, but
		the name (and current usage in class generation support) suggests that
		untyped variables should not be inclueded.  Therefore we do not
		currently have to add the external names here.
	*/
public Variable[] getDeclaredVariables() {
    return super.getDeclaredVariables();
}