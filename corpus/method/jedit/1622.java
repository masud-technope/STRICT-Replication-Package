/**
        Set the variable through this namespace.
        This method obeys the LOCALSCOPING property to determine how variables
        are set.
        <p>
        Note: this method is primarily intended for use internally.  If you use
        this method outside of the bsh package and wish to set variables with
        primitive values you will have to wrap them using bsh.Primitive.
        @see org.gjt.sp.jedit.bsh.Primitive
        <p>
        Setting a new variable (which didn't exist before) or removing
        a variable causes a namespace change.

        @param strictJava specifies whether strict java rules are applied.
    */
public void setVariable(String name, Object value, boolean strictJava) throws UtilEvalError {
    // if localscoping switch follow strictJava, else recurse
    boolean recurse = Interpreter.LOCALSCOPING ? strictJava : true;
    setVariable(name, value, strictJava, recurse);
}