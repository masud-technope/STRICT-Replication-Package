asm small fast java bytecode manipulation framework copyright inria france telecom copyright france telecom library free software redistribute modify terms gnu lesser general license published free software foundation version license option version library distributed hope warranty implied warranty merchantability fitness purpose gnu lesser general license details received copy gnu lesser general license library write free software foundation temple place suite boston usa contact eric bruneton francetelecom author eric bruneton org gjt jedit bsh org objectweb asm code writer codewriter code visitor codevisitor preconditions checked runtime check code writer link class writer classwriter first method firstmethod first method firstmethod code writer codewriter writer method class writer classwriter constant pool item method item constant pool item descriptor method item desc access flags method access maximum stack size method max stack maxstack maximum number local variables method max locals maxlocals bytecode method byte vector bytevector code byte vector bytevector number entries table method catch count catchcount table method byte vector bytevector catch table catchtable number exceptions thrown method exception count exceptioncount exceptions thrown method precisely array indexes constant pool items internal names exception classes exceptions number entries local variable table localvariabletable attribute local var count localvarcount local variable table localvariabletable attribute byte vector bytevector local var localvar number entries line number table linenumbertable attribute line number count linenumbercount line number table linenumbertable attribute byte vector bytevector line number linenumber jump instructions small resized resize fields control flow graph analysis algorithm compute maximum stack size control flow graph node basic block edge jump basic block node basic block represented label object corresponds instruction basic block node stores list successors graph linked list edge objects maximum stack size number local variables automatically computed compute maxs computemaxs relative stack size visited instruction size relative current basic block stack size visited instruction equal link label begin stack size beginstacksize begin stack size beginstacksize current basic block stack size stacksize stack size stacksize relative maximum stack size visited instruction size relative current basic block maximum stack size visited instruction equal link label begin stack size beginstacksize begin stack size beginstacksize current basic block stack size stacksize max stack size maxstacksize current basic block block basic block instruction visited label current block currentblock basic block stack control flow analysis algorithm stack represented linked list link label label objects linked link label field stack confused jvm stack execute jvm instructions label block stack blockstack stack size variation jvm instruction stack variation equal size values produced instruction size values consumed instruction size fields optimize creation link edge edge objects pool reusable objects shared pool linked list edge objects linked link edge pool next poolnext field time code writer codewriter allocate edge removes edge pool adds list edge objects control flow analysis algorithm edge objects list code writer codewriter pool appending list pool list order constant time head tail list stored code writer codewriter head list link edge edge objects link code writer codewriter code writer codewriter objects linked link edge pool next poolnext field shared pool control flow analysis algorithm edge head tail list link edge edge objects link code writer codewriter code writer codewriter objects linked link edge pool next poolnext field shared pool control flow analysis algorithm edge tail shared pool link edge edge objects pool linked list edge objects linked link edge pool next poolnext field edge pool string effffffffggfffggfffeefgfgfeeeeeeeeeeeeeeeeeeeedededddddcdcdeeeeeeeee eeeeeeeeeeebababbbbdcfffgggedcdcdcdcdcdcdcdcdcdceeeedddddddcdcdcefef ddeeffdedeeebddbbddddddccccccccefedddcdcdeeeeeeeeeefeeeeeeddeeddee length char at charat size code generate string applicable unused opcode variable size opcode nop visit insn visitinsn aconst iconst iconst iconst iconst iconst iconst iconst lconst lconst fconst fconst fconst dconst dconst bipush visit int insn visitintinsn sipush ldc visit ldc insn visitldcinsn ldc ldc iload visit var insn visitvarinsn lload fload dload aload iload iload iload iload lload lload lload lload fload fload fload fload dload dload dload dload aload aload aload aload iaload visit insn visitinsn laload faload daload aaload baload caload saload istore visit var insn visitvarinsn lstore fstore dstore astore istore istore istore istore lstore lstore lstore lstore fstore fstore fstore fstore dstore dstore dstore dstore astore astore astore astore iastore visit insn visitinsn lastore fastore dastore aastore bastore castore sastore pop pop dup dup dup dup dup dup swap iadd ladd fadd dadd isub lsub fsub dsub imul lmul fmul dmul idiv ldiv fdiv ddiv irem lrem frem drem ineg lneg fneg dneg ishl lshl ishr lshr iushr lushr iand land ior lor ixor lxor iinc visit iinc insn visitiincinsn visit insn visitinsn lcmp fcmpl fcmpg dcmpl dcmpg ifeq visit jump insn visitjumpinsn ifne iflt ifge ifgt ifle icmpeq icmpne icmplt icmpge icmpgt icmple acmpeq acmpne jsr ret visit var insn visitvarinsn tableswitch visi table switch insn visitableswitchinsn lookupswitch visit lookup switch visitlookupswitch ireturn visit insn visitinsn lreturn freturn dreturn areturn getstatic visit field insn visitfieldinsn putstatic getfield putfield invokevirtual visit method insn visitmethodinsn invokespecial invokestatic invokeinterface unused visited visit type insn visittypeinsn newarray visit int insn visitintinsn anewarray visit type insn visittypeinsn arraylength visit insn visitinsn athrow checkcast visit type insn visittypeinsn monitorenter visit insn visitinsn monitorexit wide visited multianewarray visit multi anew array insn visitmultianewarrayinsn ifnull visit jump insn visitjumpinsn ifnonnull jsr length system err print system err println code writer codewriter class writer classwriter compute maxs computemaxs first method firstmethod first method firstmethod last method lastmethod last method lastmethod last method lastmethod compute maxs computemaxs compute maxs computemaxs compute maxs computemaxs pushes block stack blocks visited current block currentblock label current block currentblock pushed block stack blockstack current block currentblock initializes code writer codewriter define bytecode method param access method access flags link constants param method param desc method descriptor link type type param exceptions internal names method exceptions init access string string desc string exceptions access access new utf newutf desc new utf newutf desc exceptions exceptions length exception count exceptioncount exceptions length exceptions exception count exceptioncount exception count exceptioncount exceptions new class newclass exceptions compute maxs computemaxs updates max locals maxlocals size get arguments and return sizes getargumentsandreturnsizes desc access constants acc size size max locals maxlocals max locals maxlocals size implementation code visitor codevisitor visit insn visitinsn opcode compute maxs computemaxs updates current max stack sizes size stack size stacksize size opcode size max stack size maxstacksize max stack size maxstacksize size stack size stacksize size opcode athrow x return xreturn ends current block successor opcode constants ireturn opcode constants opcode constants athrow current block currentblock current block currentblock max stack size maxstacksize max stack size maxstacksize current block currentblock adds instruction bytecode method code opcode visit int insn visitintinsn opcode operand compute maxs computemaxs opcode constants newarray updates current max stack sizes opcode newarray stack size variation bipush sipush size stack size stacksize size max stack size maxstacksize max stack size maxstacksize size stack size stacksize size adds instruction bytecode method opcode constants sipush code opcode operand bipush newarray code opcode operand visit var insn visitvarinsn opcode compute maxs computemaxs updates current max stack sizes opcode constants ret stack change current block successor current block currentblock current block currentblock max stack size maxstacksize max stack size maxstacksize current block currentblock x load xload x store xstore size stack size stacksize size opcode size max stack size maxstacksize max stack size maxstacksize size stack size stacksize size updates max locals opcode constants lload opcode constants dload opcode constants lstore opcode constants dstore max locals maxlocals max locals maxlocals adds instruction bytecode method opcode constants ret opt opcode constants istore opt iload opcode constants iload opt istore opcode constants istore code opt code opcode code opcode visit type insn visittypeinsn opcode string desc compute maxs computemaxs opcode constants updates current max stack sizes opcode stack size variation anewarray checkcast size stack size stacksize size max stack size maxstacksize max stack size maxstacksize size stack size stacksize size adds instruction bytecode method code opcode new class newclass desc visit field insn visitfieldinsn opcode string owner string string desc compute maxs computemaxs size computes stack size variation desc char at charat opcode constants getstatic size stack size stacksize constants putstatic size stack size stacksize constants getfield size stack size stacksize constants putfield size stack size stacksize updates current max stack sizes size max stack size maxstacksize max stack size maxstacksize size stack size stacksize size adds instruction bytecode method code opcode new field newfield owner desc visit method insn visitmethodinsn opcode string owner string string desc item opcode constants invokeinterface new itf method newitfmethod owner desc new method newmethod owner desc arg size argsize int val intval compute maxs computemaxs desc arg size argsize sizes computed compute arg size argsize get arguments and return sizes getargumentsandreturnsizes desc save order recompute int val intval arg size argsize size opcode constants invokestatic size stack size stacksize arg size argsize arg size argsize size stack size stacksize arg size argsize arg size argsize updates current max stack sizes size max stack size maxstacksize max stack size maxstacksize size stack size stacksize size adds instruction bytecode method opcode constants invokeinterface compute maxs computemaxs arg size argsize arg size argsize get arguments and return sizes getargumentsandreturnsizes desc int val intval arg size argsize code constants invokeinterface arg size argsize code opcode visit jump insn visitjumpinsn opcode label label check label owner label owner label owner illegal argument exception illegalargumentexception compute maxs computemaxs opcode constants stack change current block successor current block currentblock current block currentblock max stack size maxstacksize max stack size maxstacksize add successor addsuccessor stack size stacksize label current block currentblock opcode constants jsr current block currentblock add successor addsuccessor stack size stacksize label updates current stack size max stack size unchanged stack size variation negative stack size stacksize size opcode current block currentblock add successor addsuccessor stack size stacksize label adds instruction bytecode method label resolved label position code length min instruction opcode constants code opcode constants jsr jsr code code opcode opcode opcode jump offset code code label code code length jump offset jump unknown offset cases store offset bytes increased resize instructions resizeinstructions needed code opcode label code code length visit label visitlabel label label check label owner label owner label owner illegal argument exception illegalargumentexception compute maxs computemaxs current block currentblock ends current block successor current block currentblock max stack size maxstacksize max stack size maxstacksize add successor addsuccessor stack size stacksize label current block resets relative current max stack sizes current block currentblock label stack size stacksize max stack size maxstacksize resolves previous references label resize label resolve code length code data visit ldc insn visitldcinsn object cst item new cst newcst cst compute maxs computemaxs size computes stack size variation type class writer classwriter type class writer classwriter size stack size stacksize size stack size stacksize updates current max stack sizes size max stack size maxstacksize max stack size maxstacksize size stack size stacksize size adds instruction bytecode method type class writer classwriter type class writer classwriter code ldc code ldc code constants ldc visit iinc insn visitiincinsn increment compute maxs computemaxs updates max locals stack change max locals maxlocals max locals maxlocals adds instruction bytecode method increment increment code constants iinc increment code constants iinc increment visit table switch insn visittableswitchinsn min max label dflt label labels compute maxs computemaxs updates current stack size max stack size unchanged stack size stacksize ends current block successors current block currentblock current block currentblock max stack size maxstacksize max stack size maxstacksize add successor addsuccessor stack size stacksize dflt labels length add successor addsuccessor stack size stacksize labels current block currentblock adds instruction bytecode method source code length code constants tableswitch code length code dflt code source code min max labels length labels code source visit lookup switch insn visitlookupswitchinsn label dflt label labels compute maxs computemaxs updates current stack size max stack size unchanged stack size stacksize ends current block successors current block currentblock current block currentblock max stack size maxstacksize max stack size maxstacksize add successor addsuccessor stack size stacksize dflt labels length add successor addsuccessor stack size stacksize labels current block currentblock adds instruction bytecode method source code length code constants lookupswitch code length code dflt code source code labels length labels length code labels code source visit multi anew array insn visitmultianewarrayinsn string desc dims compute maxs computemaxs updates current stack size max stack size unchanged stack size variation negative stack size stacksize dims adds instruction bytecode method item class item classitem new class newclass desc code constants multianewarray class item classitem dims visit try catch block visittrycatchblock label start label label handler string type check start owner owner handler owner illegal argument exception illegalargumentexception start resolved resolved handler resolved illegal argument exception illegalargumentexception compute maxs computemaxs pushes handler block stack blocks visited handler pushed handler begin stack size beginstacksize handler pushed handler block stack blockstack block stack blockstack handler catch count catchcount catch table catchtable catch table catchtable byte vector bytevector catch table catchtable start position catch table catchtable position catch table catchtable handler position catch table catchtable type new class newclass type visit maxs visitmaxs max stack maxstack max locals maxlocals compute maxs computemaxs relative max stack size max control flow analysis algorithm block stack empty pop block stack update max stack size compute relative stack size successors block push successors stack pushed stack note hypothesis link label begin stack size beginstacksize blocks block stack relative stack sizes blocks label stack block stack blockstack stack pops block stack label stack stack stack computes relative max stack size block start begin stack size beginstacksize block max blockmax start max stack size maxstacksize updates global max stack size block max blockmax max max block max blockmax analyses successors block edge successors successor successor pushed stack pushed computes stack size successor block begin stack size beginstacksize start stack size stacksize pushes successor stack pushed stack stack max stack maxstack max releases edge objects code writer codewriter size appends head tail list pool list tail tail pool next poolnext pool pool head max stack maxstack max stack maxstack max locals maxlocals max locals maxlocals visit local variable visitlocalvariable string string desc label start label check start owner start resolved illegal argument exception illegalargumentexception owner resolved illegal argument exception illegalargumentexception local var localvar new utf newutf local variable table localvariabletable local var localvar byte vector bytevector local var count localvarcount local var localvar start position local var localvar position start position local var localvar new utf newutf local var localvar new utf newutf desc local var localvar visit line number visitlinenumber label start check start owner start resolved illegal argument exception illegalargumentexception line number linenumber new utf newutf line number table linenumbertable line number linenumber byte vector bytevector line number count linenumbercount line number linenumber start position line number linenumber utility methods control flow analysis algorithm computes size arguments method param desc descriptor method size arguments method implicit argument arg size argsize size ret size retsize packed single arg size argsize ret size retsize arg size argsize equal ret size retsize get arguments and return sizes getargumentsandreturnsizes string desc car desc char at charat car car desc char at charat car car car car desc char at charat car car desc char at charat car car car car adds successor link current block currentblock current block currentblock block param stack size stacksize current relative stack size current block param successor successor block current block add successor addsuccessor stack size stacksize label successor edge creates edge object reuses shared pool size pool edge pool removes pool pool pool pool next poolnext adds previous edge list edges code writer codewriter tail tail pool next poolnext head head initializes previous edge object stack size stacksize stack size stacksize successor successor adds successor list current block currentblock block current block currentblock successors current block currentblock successors utility methods dump bytecode array returns size bytecode method size bytecode method get size getsize resize replaces temporary jump opcodes introduced label resolve resize instructions resizeinstructions size code length new utf newutf code size code length catch count catchcount local var localvar size local var localvar length line number linenumber size line number linenumber length exception count exceptioncount new utf newutf exceptions size exception count exceptioncount access constants acc synthetic new utf newutf synthetic size access constants acc deprecated new utf newutf deprecated size size puts bytecode method vector param vector bytecode method copied byte vector bytevector access desc attribute count attributecount code length attribute count attributecount exception count exceptioncount attribute count attributecount access constants acc synthetic attribute count attributecount access constants acc deprecated attribute count attributecount attribute count attributecount code length size code length catch count catchcount local var localvar size local var localvar length line number linenumber size line number linenumber length new utf newutf code size max stack maxstack max locals maxlocals code length put byte array putbytearray code data code length catch count catchcount catch count catchcount put byte array putbytearray catch table catchtable data catch table catchtable length attribute count attributecount local var localvar attribute count attributecount line number linenumber attribute count attributecount attribute count attributecount local var localvar new utf newutf local variable table localvariabletable local var localvar length local var count localvarcount put byte array putbytearray local var localvar data local var localvar length line number linenumber new utf newutf line number table linenumbertable line number linenumber length line number count linenumbercount put byte array putbytearray line number linenumber data line number linenumber length exception count exceptioncount new utf newutf exceptions exception count exceptioncount exception count exceptioncount exception count exceptioncount exceptions access constants acc synthetic new utf newutf synthetic access constants acc deprecated new utf newutf deprecated utility methods instruction resizing handle jsr resizes designated instructions keeping jump offsets instruction addresses consistent require resize existing instructions introduce instructions increasing size instruction middle method increases offset ifeq instruction ifeq replaced ifneq turn require increase size jump instruction operations handled automatically method method called method built visited link label label objects construct method longer valid method called param indexes current positions instructions resized instruction designated instruction param sizes number bytes instructions precisely len sizes bytes instruction designated indexes sizes negative sizes bytes instruction removed instruction size negative gaps introduced method filled manually array returned link get code getcode get code getcode method param len number instruction resized smaller equal indexes length sizes length indexes array positions resized instructions designated resize instructions resizeinstructions indexes sizes len bytecode method code data indexes label loop indexes step explained resizing instruction require resize require resize step algorithm consists finding instructions resized modifying code point algorithm parse code find jump instructions offset bytes stored offset computed current offset number bytes inserted removed source target instructions instruction adds entry copy indexes sizes arrays previous iteration entry previous step fact real algorithm complicated fact size tableswitch lookupswitch instructions depends position bytecode padding order ensure convergence algorithm number bytes removed instructions estimated previous loop computed loop finished requires pass parse bytecode method copy indexes all indexes allindexes len copy sizes all sizes allsizes len instructions resized resize offset jump instruction new offset newoffset system arraycopy indexes all indexes allindexes len system arraycopy sizes all sizes allsizes len resize code length loop loop ended pass length opcode current instruction opcode x ff xff bytes instruction insert class writer classwriter type opcode class writer classwriter noarg insn class writer classwriter implvar insn class writer classwriter label insn opcode converts temporary opcodes inclusive ifeq jsr inclusive ifnull ifnonnull opcode opcode opcode opcode label read unsigned short readunsignedshort label read short readshort new offset newoffset get new offset getnewoffset all indexes allindexes all sizes allsizes label new offset newoffset min new offset newoffset max resize opcode constants opcode constants jsr additional bytes required replace jsr instruction jsr insert additional bytes required replace ifxxx instruction ifnotxxx ifnotxxx opcode ifxxx ifne ifeq designates instruction insert resize class writer classwriter labelw insn class writer classwriter tabl insn number bytes removed instruction number padding bytes current number padding estimated variation new offset newoffset new offset newoffset new offset newoffset new offset newoffset get new offset getnewoffset all indexes allindexes all sizes allsizes insert new offset newoffset resize estimation number bytes instruction current number padding bytes insert resize skips instruction read int readint read int readint class writer classwriter insn tabl insn new offset newoffset get new offset getnewoffset all indexes allindexes all sizes allsizes insert new offset newoffset resize tabl insn insert resize skips instruction read int readint class writer classwriter wide insn opcode x ff xff opcode constants iinc class writer classwriter insn class writer classwriter sbyte insn class writer classwriter ldc insn class writer classwriter insn class writer classwriter ldcw insn class writer classwriter fieldormeth insn class writer classwriter type insn class writer classwriter iinc insn class writer classwriter itfmeth insn class writer classwriter mana insn insert adds insert entry all indexes allindexes all sizes allsizes arrays new indexes newindexes all indexes allindexes length new sizes newsizes all sizes allsizes length system arraycopy all indexes allindexes new indexes newindexes all indexes allindexes length system arraycopy all sizes allsizes new sizes newsizes all sizes allsizes length new indexes newindexes all indexes allindexes length new sizes newsizes all sizes allsizes length insert all indexes allindexes new indexes newindexes all sizes allsizes new sizes newsizes insert step copies bytecode method bytevector updates offsets inserts removes bytes requested byte vector bytevector new code newcode byte vector bytevector code length code length all indexes allindexes length all indexes allindexes len sizes new code newcode put byte array putbytearray sizes new code newcode length sizes indexes new code newcode length opcode x ff xff class writer classwriter type opcode class writer classwriter noarg insn class writer classwriter implvar insn new code newcode opcode class writer classwriter label insn opcode temporary opcodes inclusive ifeq jsr inclusive ifnull ifnonnull opcode opcode opcode opcode label read unsigned short readunsignedshort label read short readshort new offset newoffset get new offset getnewoffset all indexes allindexes all sizes allsizes label new offset newoffset min new offset newoffset max instruction opcode constants new code newcode opcode constants jsr jsr new code newcode new code newcode opcode opcode opcode jump offset new code newcode new code newcode new offset newoffset computed start new offset newoffset new code newcode new offset newoffset new code newcode opcode new code newcode new offset newoffset class writer classwriter labelw insn label read int readint new offset newoffset get new offset getnewoffset all indexes allindexes all sizes allsizes label new code newcode opcode new code newcode new offset newoffset class writer classwriter tabl insn skips padding bytes reads copies instruction source new code newcode length new code newcode constants tableswitch new code newcode length new code newcode label read int readint new offset newoffset get new offset getnewoffset all indexes allindexes all sizes allsizes label new code newcode new offset newoffset read int readint new code newcode read int readint new code newcode read int readint label read int readint new offset newoffset get new offset getnewoffset all indexes allindexes all sizes allsizes label new code newcode new offset newoffset class writer classwriter insn skips padding bytes reads copies instruction source new code newcode length new code newcode constants lookupswitch new code newcode length new code newcode label read int readint new offset newoffset get new offset getnewoffset all indexes allindexes all sizes allsizes label new code newcode new offset newoffset read int readint new code newcode new code newcode read int readint label read int readint new offset newoffset get new offset getnewoffset all indexes allindexes all sizes allsizes label new code newcode new offset newoffset class writer classwriter wide insn opcode x ff xff opcode constants iinc new code newcode put byte array putbytearray new code newcode put byte array putbytearray class writer classwriter insn class writer classwriter sbyte insn class writer classwriter ldc insn new code newcode put byte array putbytearray class writer classwriter insn class writer classwriter ldcw insn class writer classwriter fieldormeth insn class writer classwriter type insn class writer classwriter iinc insn new code newcode put byte array putbytearray class writer classwriter itfmeth insn new code newcode put byte array putbytearray mana insn new code newcode put byte array putbytearray local number tables catch table catchtable catch table catchtable data catch table catchtable length write short writeshort get new offset getnewoffset all indexes allindexes all sizes allsizes read unsigned short readunsignedshort write short writeshort get new offset getnewoffset all indexes allindexes all sizes allsizes read unsigned short readunsignedshort write short writeshort get new offset getnewoffset all indexes allindexes all sizes allsizes read unsigned short readunsignedshort local var localvar local var localvar data local var localvar length label read unsigned short readunsignedshort new offset newoffset get new offset getnewoffset all indexes allindexes all sizes allsizes label write short writeshort new offset newoffset label read unsigned short readunsignedshort new offset newoffset get new offset getnewoffset all indexes allindexes all sizes allsizes label new offset newoffset write short writeshort new offset newoffset line number linenumber line number linenumber data line number linenumber length write short writeshort get new offset getnewoffset all indexes allindexes all sizes allsizes read unsigned short readunsignedshort replaces bytecodes code new code newcode returns positions resized instructions indexes reads unsigned array param array param start read read read unsigned short readunsignedshort x ff xff x ff xff reads signed array param array param start read read read short readshort x ff xff x ff xff reads signed array param array param start read read read int readint x ff xff x ff xff x ff xff x ff xff writes array param array param written param written array write short writeshort computes bytecode offset note entries instruction indexes sizes entries size size equivalent single entry size param indexes current positions instructions resized instruction designated instruction param sizes number bytes instructions precisely len sizes bytes instruction designated indexes sizes negative sizes bytes instruction removed instruction size negative param source instruction param target instruction bytecode offset get new offset getnewoffset indexes sizes offset indexes length indexes indexes jump offset sizes indexes indexes jump offset sizes offset returns current size bytecode method size includes size bytecode instructions include size exceptions local variable table localvariabletable line number table linenumbertable synthetic deprecated attributes current size bytecode method get code size getcodesize code length returns current bytecode method bytecode instructions include exceptions local variable table localvariabletable line number table linenumbertable synthetic deprecated attributes current bytecode method bytecode contained inclusive link get code size getcodesize get code size getcodesize exclusive get code getcode code data