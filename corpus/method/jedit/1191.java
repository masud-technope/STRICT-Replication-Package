/**
		Generates the code to reify the arguments of the given method.
		For a method "int m (int i, String s)", this code is the bytecode
		corresponding to the "new Object[] { new bsh.Primitive(i), s }" 
		expression.

	 	@author Eric Bruneton
	 	@author Pat Niemeyer
		@param cv the code visitor to be used to generate the bytecode.
		@param isStatic the enclosing methods is static
	*/
public static void generateParameterReifierCode(String[] paramTypes, boolean isStatic, final CodeVisitor cv) {
    cv.visitIntInsn(SIPUSH, paramTypes.length);
    cv.visitTypeInsn(ANEWARRAY, "java/lang/Object");
    int localVarIndex = isStatic ? 0 : 1;
    for (int i = 0; i < paramTypes.length; ++i) {
        String param = paramTypes[i];
        cv.visitInsn(DUP);
        cv.visitIntInsn(SIPUSH, i);
        if (isPrimitive(param)) {
            int opcode;
            if (param.equals("F")) {
                opcode = FLOAD;
            } else if (param.equals("D")) {
                opcode = DLOAD;
            } else if (param.equals("J")) {
                opcode = LLOAD;
            } else {
                opcode = ILOAD;
            }
            String type = "org/gjt/sp/jedit/bsh/Primitive";
            cv.visitTypeInsn(NEW, type);
            cv.visitInsn(DUP);
            cv.visitVarInsn(opcode, localVarIndex);
            // ok?
            String // ok?
            desc = param;
            cv.visitMethodInsn(INVOKESPECIAL, type, "<init>", "(" + desc + ")V");
        } else {
            // Technically incorrect here - we need to wrap null values
            // as bsh.Primitive.NULL.  However the This.invokeMethod()
            // will do that much for us.
            // We need to generate a conditional here to test for null
            // and return Primitive.NULL
            cv.visitVarInsn(ALOAD, localVarIndex);
        }
        cv.visitInsn(AASTORE);
        localVarIndex += ((param.equals("D") || param.equals("J")) ? 2 : 1);
    }
}