/**
		Translate bsh.Modifiers into ASM modifier bitflags.
	*/
static int getASMModifiers(Modifiers modifiers) {
    int mods = 0;
    if (modifiers == null)
        return mods;
    if (modifiers.hasModifier("public"))
        mods += ACC_PUBLIC;
    if (modifiers.hasModifier("protected"))
        mods += ACC_PROTECTED;
    if (modifiers.hasModifier("static"))
        mods += ACC_STATIC;
    if (modifiers.hasModifier("synchronized"))
        mods += ACC_SYNCHRONIZED;
    if (modifiers.hasModifier("abstract"))
        mods += ACC_ABSTRACT;
    return mods;
}