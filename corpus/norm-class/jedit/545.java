file bean shell beanshell java scripting distribution documentation updates http beanshell org sun license notice contents file subject sun license version license file compliance license copy license http sun original code bean shell beanshell initial developer original code pat niemeyer portions created pat niemeyer copyright rights reserved gnu license notice alternatively contents file terms gnu lesser general license lgpl provisions lgpl applicable version file terms lgpl version file spl decision deleting provisions replace notice provisions required lgpl delete provisions recipient version file spl lgpl patrick niemeyer pat pat net author learning java reilly associates http pat net pat org gjt jedit bsh java lang reflect array java lang reflect invocation target exception invocationtargetexception strong implementation notes strong pre thread safety work methods share internal intermediate evaluation note invoke method invokemethod simply resolve method resolvemethod method invoker methodinvoker bsh method bshmethod java method javamethod easy ast bshmehod invocation bshmehodinvocation doesn type target resolve overloaded methods java overloaded methods resolved compile time necessity dynamic cache signature client reflect java note caller resolution references work caller caller caller works equivalent successive calls work caller caller caller caller caller caller prohibited restriction call caller literal caller reference magic caller reference works current reference real explanation referernces depth call stack hard define purposes provide callstack pre java serializable change evaluation name space namespace namespace string instance variables mutate evaluation reset reset method evaluation remaining text evaluate string eval name evalname evaluated caller resolution string last eval name lastevalname evalname finished string finished base object current eval object eval base object evalbaseobject number times eval hit caller callstack depth callstackdepth mutable instance variables cached result structures optimizations note cache resolution space namespace discard cached names result as class asclass result method call class of static method classofstaticmethod cached result structures reset eval name evalname eval base object evalbaseobject callstack depth callstackdepth friendly name space namespace name space namespace namespace string namespace namespace resolve complex object eval error evalerror failures object primitive type primitive attempting access undefined variable cases my variable myvariable my variable myvariable foo my variable myvariable foo bar java awt grid bag constraints gridbagconstraints stuff my class myclass some field somefield some field somefield interpreter reference resolution interpreter magic field call stack callstack reference resolution caller magic field callstack magic field object to object toobject call stack callstack callstack interpreter interpreter util eval error utilevalerror to object toobject callstack interpreter to object toobject param force class forceclass resolution produce disambiguate cases grammar general path object to object toobject call stack callstack callstack interpreter interpreter force class forceclass util eval error utilevalerror reset object obj eval name evalname obj consume next object field consumenextobjectfield callstack interpreter force class forceclass autoalloc obj interpreter error interpretererror to object toobject obj object complete round completeround string last eval name lastevalname string next eval name nextevalname object return object returnobject return object returnobject interpreter error interpretererror last eval name lastevalname last eval name lastevalname last eval name lastevalname last eval name lastevalname eval name evalname next eval name nextevalname eval base object evalbaseobject return object returnobject return object returnobject object consuming components eval name evalname consumes component classname consume components identifier object consume next object field consumenextobjectfield call stack callstack callstack interpreter interpreter force class forceclass auto allocate this autoallocatethis util eval error utilevalerror simple variable correct java precedence vars imported names simple tests precedence bsh speed bit eval base object evalbaseobject is compound iscompound eval name evalname force class forceclass object obj resolve this field reference resolvethisfieldreference callstack namespace interpreter eval name evalname obj primitive complete round completeround eval name evalname finished obj bsh script variable reference starting eval base object evaluating relative type reference check string var name varname prefix eval name evalname eval base object evalbaseobject eval base object evalbaseobject force class forceclass interpreter debug interpreter debug resolve variable var name varname object obj namespace special visibility eval base object evalbaseobject obj resolve this field reference resolvethisfieldreference callstack namespace interpreter var name varname obj resolve this field reference resolvethisfieldreference callstack eval base object evalbaseobject namespace interpreter var name varname obj primitive resolved variable interpreter debug interpreter debug resolved variable var name varname namespace namespace complete round completeround var name varname suffix eval name evalname obj starting eval fail eval base object evalbaseobject interpreter debug interpreter debug eval name evalname adding parts clas string class name classname count parts countparts eval name evalname class name classname prefix eval name evalname clas namespace get class getclass class name classname clas complete round completeround class name classname suffix eval name evalname count parts countparts eval name evalname class identifier classidentifier clas variable interpreter debug interpreter debug prefix eval name evalname auto allocate this autoallocatethis create child eval base object evalbaseobject eval base object evalbaseobject force class forceclass auto allocate this autoallocatethis name space namespace target name space targetnamespace eval base object evalbaseobject namespace eval base object evalbaseobject namespace object obj name space namespace target name space targetnamespace auto var name varname get this getthis interpreter target name space targetnamespace set variable setvariable var name varname obj complete round completeround var name varname suffix eval name evalname obj didn find variable prefix possibilities simple pass variable reference compound fail point eval base object evalbaseobject is compound iscompound eval name evalname complete round completeround eval name evalname finished primitive util eval error utilevalerror variable eval name evalname previous produced eval base object evalbaseobject primitive util target error utiltargeterror null pointer exception nullpointerexception pointer evaluating previous produced eval base object evalbaseobject primitive util eval error utilevalerror undefined variable evaluating eval base object evalbaseobject primitive util eval error utilevalerror treat primitive object error evaluating resolve relative type field eval base object evalbaseobject class identifier classidentifier clas class identifier classidentifier eval base object evalbaseobject get target class gettargetclass string field prefix eval name evalname my outer class myouterclass field equals find enclosing instance space name space namespace namespace get class instance getclassinstance exception class instance classinstance class instance classinstance get class getclass clas complete round completeround field suffix eval name evalname class instance classinstance get parent getparent util eval error utilevalerror find enclosing instance clas object obj field interpreter debug interpreter debug call get static field value getstaticfieldvalue clas field field obj reflect get static field value getstaticfieldvalue clas field reflect error reflecterror interpreter debug interpreter debug field reflect error obj string iclass clas get name getname field namespace get class getclass iclass obj class identifier classidentifier obj util eval error utilevalerror field field clas complete round completeround field suffix eval name evalname obj fallen longer resolving type force class forceclass util eval error utilevalerror resolve kind field access string field prefix eval name evalname length access array field equals length eval base object evalbaseobject get class getclass is array isarray object obj primitive array get length getlength eval base object evalbaseobject complete round completeround field suffix eval name evalname obj note eliminate throwing exception object obj reflect get object field value getobjectfieldvalue eval base object evalbaseobject field complete round completeround field suffix eval name evalname obj reflect error reflecterror field failed util eval error utilevalerror access field field object eval base object evalbaseobject resolve variable relative reference general variable resolution method accomodating special fields context namespace interpreter comprise context callstack caller construct optionally interpret special magic field names interpreter param callstack legitimate special cases resolution involve caller param namespace namespace reference top stack object resolve this field reference resolvethisfieldreference call stack callstack callstack name space namespace this name space thisnamespace interpreter interpreter string var name varname special fields visible specialfieldsvisible util eval error utilevalerror var name varname equals hack special fields visible operating relative type dissallow references prevent user skipping caller special fields visible specialfieldsvisible util eval error utilevalerror redundant call type get this getthis work block name space blocknamespace method namespace xxx eval ths this name space thisnamespace get this getthis interpreter this name space thisnamespace ths get name space getnamespace object result ths name space namespace class name space classnamespace get class name space getclassnamespace this name space thisnamespace class name space classnamespace is compound iscompound eval name evalname result class name space classnamespace get this getthis interpreter result class name space classnamespace get class instance getclassinstance result duplication notes enclsing instance superclass instance superclass instance var name varname equals special fields visible specialfieldsvisible util eval error utilevalerror redundant call type get super getsuper block name space blocknamespace method ths this name space thisnamespace get super getsuper interpreter this name space thisnamespace ths get name space getnamespace parent this name space thisnamespace get parent getparent this name space thisnamespace get parent getparent is class isclass ths this name space thisnamespace get parent getparent get this getthis interpreter ths object obj var name varname equals global obj this name space thisnamespace get global getglobal interpreter obj special fields visible specialfieldsvisible var name varname equals namespace obj this name space thisnamespace var name varname equals variables obj this name space thisnamespace get variable names getvariablenames var name varname equals methods obj this name space thisnamespace get method names getmethodnames var name varname equals interpreter last eval name lastevalname equals obj interpreter util eval error utilevalerror call interpreter literal obj special fields visible specialfieldsvisible var name varname equals caller last eval name lastevalname equals last eval name lastevalname equals caller previous context notes callstack interpreter error interpretererror callstack obj callstack callstack depth callstackdepth get this getthis interpreter util eval error utilevalerror call caller literal literal caller early obj obj special fields visible specialfieldsvisible var name varname equals callstack last eval name lastevalname equals previous context notes callstack interpreter error interpretererror callstack obj callstack util eval error utilevalerror call callstack literal obj obj this name space thisnamespace get variable getvariable var name varname obj interpreter error interpretererror field var name varname obj enclosing body namespace name space namespace get class name space getclassnamespace name space namespace this name space thisnamespace this name space thisnamespace class instance classinstance this name space thisnamespace is class isclass this name space thisnamespace this name space thisnamespace is method ismethod this name space thisnamespace get parent getparent this name space thisnamespace get parent getparent class instance classinstance this name space thisnamespace get parent getparent is class isclass this name space thisnamespace get parent getparent check cache to object toobject resolve identifier class not found exception classnotfoundexception class path exception classpathexception type eval error evalerror special ambiguous unqualified to class toclass class not found exception classnotfoundexception util eval error utilevalerror as class asclass as class asclass reset untyped eval name evalname equals as class asclass straightforward clas namespace get class getclass eval name evalname clas to object toobject work classes object obj interpreter callstack references resolution require obj to object toobject couldn resolve util eval error utilevalerror couldn resolve obj class identifier classidentifier clas class identifier classidentifier obj get target class gettargetclass clas class not found exception classnotfoundexception namespace as class asclass clas as class asclass lhs to lhs tolhs call stack callstack callstack interpreter interpreter util eval error utilevalerror clean single statement reset lhs lhs simple compound variable assignment is compound iscompound eval name evalname eval name evalname equals util eval error utilevalerror assign interpreter debug simple lhs lhs lhs namespace eval name evalname bubble allowed lhs field foo bar object obj eval name evalname is compound iscompound eval name evalname obj consume next object field consumenextobjectfield callstack interpreter forcclass autoallocthis util eval error utilevalerror util eval error utilevalerror lhs evaluation get message getmessage finished eval eval name evalname obj class identifier classidentifier util eval error utilevalerror assign obj util eval error utilevalerror error lhs some this type somethistype obj dissallow assignment magic fields eval name evalname equals namespace eval name evalname equals variables eval name evalname equals methods eval name evalname equals caller util eval error utilevalerror assign special variable eval name evalname interpreter debug reference evaluating lhs literal reference recursion setting variable normal finding nearest definition starting scope resolution qualified type reference set variable scope some this type somethistype scoping rules didn local var localvar last eval name lastevalname equals lhs obj namespace eval name evalname local var localvar eval name evalname obj class identifier classidentifier clas class identifier classidentifier obj get target class gettargetclass lhs reflect get lhsstatic field getlhsstaticfield clas eval name evalname lhs lhs reflect get lhsobject field getlhsobjectfield obj eval name evalname lhs reflect error reflecterror util eval error utilevalerror field access interpreter error interpretererror internal error lhs invoke method identified performs caching method resolution signature key signaturekey wholely unqualfied messy resolve object prefix method invoke interpreter support interpreter references called code debug pre cases dynamic local my variable myvariable foo my variable myvariable bar blah foo java lang integer get integer getinteger foo pre object invoke method invokemethod interpreter interpreter object args call stack callstack callstack simple node simplenode caller info callerinfo util eval error utilevalerror eval error evalerror reflect error reflecterror invocation target exception invocationtargetexception string method name methodname suffix bsh class manager bshclassmanager bcm interpreter get class manager getclassmanager name space namespace namespace callstack top note factor path clean class of static method classofstaticmethod reflect invoke static method invokestaticmethod bcm class of static method classofstaticmethod method name methodname args is compound iscompound invoke local method invokelocalmethod interpreter args callstack caller info callerinfo note methods declared blocks accessible methodname block handle special resolve this field reference resolvethisfieldreference special handling block name space blocknamespace work direct method name methodname string prefix prefix superclass method invocation foo prefix equals count parts countparts get this getthis work block namespaces ths namespace get this getthis interpreter name space namespace this name space thisnamespace ths get name space getnamespace name space namespace class name space classnamespace get class name space getclassnamespace this name space thisnamespace class name space classnamespace object instance class name space classnamespace get class instance getclassinstance class generator classgenerator get class generator getclassgenerator invoke superclass method invokesuperclassmethod bcm instance method name methodname args find target object identifier target name targetname namespace get name resolver getnameresolver prefix object obj target name targetname to object toobject callstack interpreter obj primitive util eval error utilevalerror attempt resolve method method name methodname undefined variable target name targetname object resolve method obj class identifier classidentifier obj primitive obj primitive util target error utiltargeterror null pointer exception nullpointerexception pointer method invocation hole interpreter debug interpreter debug attempt access method primitive allowing bsh primitive peek debugging object undefined variable reflect invoke object method invokeobjectmethod obj method name methodname args interpreter callstack caller info callerinfo method interpreter debug interpreter debug invoke method invokemethod target name targetname clas class identifier classidentifier obj get target class gettargetclass cache fact method invocation class of static method classofstaticmethod clas clas reflect invoke static method invokestaticmethod bcm clas method name methodname args util eval error utilevalerror invoke method invokemethod unknown target target name targetname invoke locally declared method bsh command method declared namespace load resource imported command path bsh commands note bsh command code scope namespace imported command integrated name space namespace object invoke local method invokelocalmethod interpreter interpreter object args call stack callstack callstack simple node simplenode caller info callerinfo eval error evalerror reflect error reflecterror invocation target exception invocationtargetexception interpreter debug interpreter debug invoke local method invokelocalmethod interpreter interpreter error interpretererror invoke local method invokelocalmethod interpreter string command name commandname arg types argtypes types get types gettypes args check existing method bsh method bshmethod meth meth namespace get method getmethod command name commandname arg types argtypes util eval error utilevalerror to eval error toevalerror local method invocation caller info callerinfo callstack defined invoke meth meth invoke args interpreter callstack caller info callerinfo bsh class manager bshclassmanager bcm interpreter get class manager getclassmanager bean shell beanshell command object command object commandobject command object commandobject namespace get command getcommand command name commandname arg types argtypes interpreter util eval error utilevalerror to eval error toevalerror error loading command caller info callerinfo callstack print usage command object commandobject invoke handler method namespace note code duplicates java call command bsh method bshmethod invoke method invokemethod invoke method invokemethod namespace get method getmethod invoke util eval error utilevalerror to eval error toevalerror local method invocation caller info callerinfo callstack invoke method invokemethod invoke method invokemethod invoke object command name commandname args interpreter callstack caller info callerinfo eval error evalerror command string util stringutil method string methodstring command name commandname arg types argtypes caller info callerinfo callstack command object commandobject bsh method bshmethod bsh method bshmethod command object commandobject invoke args interpreter callstack caller info callerinfo command object commandobject reflect invoke compiled command invokecompiledcommand command object commandobject args interpreter callstack util eval error utilevalerror to eval error toevalerror error invoking compiled command caller info callerinfo callstack interpreter error interpretererror invalid command type string get help gethelp string util eval error utilevalerror check namespace bsh interpreter exception usage string get help gethelp command class commandclass util eval error utilevalerror string reflect invoke static method invokestaticmethod bcm command class commandclass usage exception usage methods operate compound separated names guess move string util stringutil is compound iscompound string index of indexof count parts countparts count parts countparts string count index of indexof count count string prefix string is compound iscompound prefix count parts countparts string prefix string parts parts count index of indexof count parts substring string suffix string is compound iscompound suffix count parts countparts string suffix string parts parts count length last index of lastindexof count parts substring compound routines string to string tostring