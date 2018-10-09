/**
        A This object is a thin layer over a namespace, comprising a bsh object
        context.  It handles things like the interface types the bsh object
        supports and aspects of method invocation on it.
        <p>

        The declaringInterpreter is here to support callbacks from Java through
        generated proxies.  The scripted object "remembers" who created it for
        things like printing messages and other per-interpreter phenomenon
        when called externally from Java.
    */
/*
        Note: we need a singleton here so that things like 'this == this' work
        (and probably a good idea for speed).

        Caching a single instance here seems technically incorrect,
        considering the declaringInterpreter could be different under some
        circumstances.  (Case: a child interpreter running a source() / eval()
        command ).  However the effect is just that the main interpreter that
        executes your script should be the one involved in call-backs from Java.

        I do not know if there are corner cases where a child interpreter would
        be the first to use a This reference in a namespace or if that would
        even cause any problems if it did...  We could do some experiments
        to find out... and if necessary we could cache on a per interpreter
        basis if we had weak references...  We might also look at skipping
        over child interpreters and going to the parent for the declaring
        interpreter, so we'd be sure to get the top interpreter.
    */
This getThis(Interpreter declaringInterpreter) {
    if (thisReference == null)
        thisReference = This.getThis(this, declaringInterpreter);
    return thisReference;
}