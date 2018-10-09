public String toString() {
    return "NameSpace: " + (nsName == null ? super.toString() : nsName + " (" + super.toString() + ")") + (isClass ? " (isClass) " : "") + (isMethod ? " (method) " : "") + (classStatic != null ? " (class static) " : "") + (classInstance != null ? " (class instance) " : "");
}