/**
		Generate return code for a normal bytecode
	*/
static void generatePlainReturnCode(String returnType, CodeVisitor cv) {
    if (returnType.equals("V"))
        cv.visitInsn(RETURN);
    else if (isPrimitive(returnType)) {
        int opcode = IRETURN;
        if (returnType.equals("D"))
            opcode = DRETURN;
        else if (returnType.equals("F"))
            opcode = FRETURN;
        else if (//long
        returnType.equals(//long
        "J"))
            opcode = LRETURN;
        cv.visitInsn(opcode);
    } else {
        cv.visitTypeInsn(CHECKCAST, descriptorToClassName(returnType));
        cv.visitInsn(ARETURN);
    }
}