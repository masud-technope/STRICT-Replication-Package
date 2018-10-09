/**
		Generates the code to unreify the result of the given method.  For a
		method "int m (int i, String s)", this code is the bytecode
		corresponding to the "((Integer)...).intValue()" expression.
	   
		@param cv the code visitor to be used to generate the bytecode.
		@author Eric Bruneton
		@author Pat Niemeyer
   */
public static void generateReturnCode(String returnType, CodeVisitor cv) {
    if (returnType.equals("V")) {
        cv.visitInsn(POP);
        cv.visitInsn(RETURN);
    } else if (isPrimitive(returnType)) {
        int opcode = IRETURN;
        String type;
        String meth;
        if (returnType.equals("B")) {
            type = "java/lang/Byte";
            meth = "byteValue";
        } else if (returnType.equals("I")) {
            type = "java/lang/Integer";
            meth = "intValue";
        } else if (returnType.equals("Z")) {
            type = "java/lang/Boolean";
            meth = "booleanValue";
        } else if (returnType.equals("D")) {
            opcode = DRETURN;
            type = "java/lang/Double";
            meth = "doubleValue";
        } else if (returnType.equals("F")) {
            opcode = FRETURN;
            type = "java/lang/Float";
            meth = "floatValue";
        } else if (returnType.equals("J")) {
            opcode = LRETURN;
            type = "java/lang/Long";
            meth = "longValue";
        } else if (returnType.equals("C")) {
            type = "java/lang/Character";
            meth = "charValue";
        } else /*if (returnType.equals("S") )*/
        {
            type = "java/lang/Short";
            meth = "shortValue";
        }
        String desc = returnType;
        // type is correct here
        cv.visitTypeInsn(CHECKCAST, type);
        cv.visitMethodInsn(INVOKEVIRTUAL, type, meth, "()" + desc);
        cv.visitInsn(opcode);
    } else {
        cv.visitTypeInsn(CHECKCAST, descriptorToClassName(returnType));
        cv.visitInsn(ARETURN);
    }
}