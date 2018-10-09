/**
		If a non-array object type, remove the prefix "L" and suffix ";".
	*/
// Can this be factored out...?  
// Should be be adding the L...; here instead?
private static String descriptorToClassName(String s) {
    if (s.startsWith("[") || !s.startsWith("L"))
        return s;
    return s.substring(1, s.length() - 1);
}