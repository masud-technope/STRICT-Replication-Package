/**
		Implement dir() command.
	*/
public static void invoke(Interpreter env, CallStack callstack) {
    String dir = ".";
    invoke(env, callstack, dir);
}