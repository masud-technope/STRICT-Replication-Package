Generate branch alternate constructor includes superclass constructors constructors branch superclass constructor method generates code call Class Generator Util ClassGeneratorUtil get Constructor Args getConstructorArgs method inspects scripted constructor find alternate constructor signature evalute arguments runtime get Constructor Args getConstructorArgs method returns actual arguments constructor call generate Constructor Switch generateConstructorSwitch cons Index consIndex args Var argsVar cons Args Var consArgsVar Code Visitor CodeVisitor Label default Label defaultLabel Label Label end Label endLabel Label cases super Constructors superConstructors length constructors length Label labels Label cases cases labels Label Generate code call Class Generator Util ClassGeneratorUtil args push super Class Name superClassName visit Ldc Insn visitLdcInsn super Class superClass get Name getName push object visit Field Insn visitFieldInsn GETSTATIC fq Class Name fqClassName BSHSTATIC class Name className Lorg gjt jedit bsh push args visit Var Insn visitVarInsn ALOAD args Var argsVar push constructor number stack visit Int Insn visitIntInsn BIPUSH cons Index consIndex invoke Class Generator Util ClassGeneratorUtil get Constructors Args getConstructorsArgs method visit Method Insn visitMethodInsn INVOKESTATIC org gjt jedit bsh Class Generator Util ClassGeneratorUtil get Constructor Args getConstructorArgs Ljava lang String Lorg gjt jedit bsh Ljava lang Object Lorg gjt jedit bsh Class Generator Util ClassGeneratorUtil Constructor Args ConstructorArgs store Constructor Args ConstructorArgs cons Args Var consArgsVar visit Var Insn visitVarInsn ASTORE cons Args Var consArgsVar Constructor Args ConstructorArgs selector field Constructor Args ConstructorArgs push Constructor Args ConstructorArgs visit Var Insn visitVarInsn ALOAD cons Args Var consArgsVar visit Field Insn visitFieldInsn GETFIELD org gjt jedit bsh Class Generator Util ClassGeneratorUtil Constructor Args ConstructorArgs selector start visit Table Switch Insn visitTableSwitchInsn min max cases default Label defaultLabel labels generate body super Constructors superConstructors length do Switch Branch doSwitchBranch super Class Name superClassName get Type Descriptors getTypeDescriptors super Constructors superConstructors get Parameter Types getParameterTypes end Label endLabel labels cons Args Var consArgsVar constructors length do Switch Branch doSwitchBranch fq Class Name fqClassName constructors get Param Type Descriptors getParamTypeDescriptors end Label endLabel labels cons Args Var consArgsVar generate branch visit Label visitLabel default Label defaultLabel branch invokes args push visit Var Insn visitVarInsn ALOAD visit Method Insn visitMethodInsn INVOKESPECIAL super Class Name superClassName init visit Label visitLabel end Label endLabel