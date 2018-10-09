/**
		Create a proper class name from a messy thing.
		Turn / or \ into .,  remove leading class and trailing .class

		Note: this makes lots of strings... could be faster.
	*/
public static String canonicalizeClassName(String name) {
    String classname = name.replace('/', '.');
    classname = classname.replace('\\', '.');
    if (classname.startsWith("class "))
        classname = classname.substring(6);
    if (classname.endsWith(".class"))
        classname = classname.substring(0, classname.length() - 6);
    return classname;
}