/**
		Generate a field - static or instance.
	*/
static void generateField(String fieldName, String type, int modifiers, ClassWriter cw) {
    cw.visitField(modifiers, fieldName, type, /*value*/
    null);
}