/**
		@param context is METHOD or FIELD
	*/
public void addModifier(int context, String name) {
    if (modifiers == null)
        modifiers = new Hashtable();
    Object existing = modifiers.put(name, Void.TYPE);
    if (existing != null)
        throw new IllegalStateException("Duplicate modifier: " + name);
    int count = 0;
    if (hasModifier("private"))
        ++count;
    if (hasModifier("protected"))
        ++count;
    if (hasModifier("public"))
        ++count;
    if (count > 1)
        throw new IllegalStateException("public/private/protected cannot be used in combination.");
    switch(context) {
        case CLASS:
            validateForClass();
            break;
        case METHOD:
            validateForMethod();
            break;
        case FIELD:
            validateForField();
            break;
    }
}