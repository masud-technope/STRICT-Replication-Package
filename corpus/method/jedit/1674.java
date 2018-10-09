/*
    public Object getCommand(
        String name, Class [] argTypes, Interpreter interpreter )
        throws UtilEvalError
    {
        if (Interpreter.DEBUG) Interpreter.debug("getCommand: "+name);
        BshClassManager bcm = interpreter.getClassManager();

        if ( importedCommands != null )
        {
            // loop backwards for precedence
            for(int i=importedCommands.size()-1; i>=0; i--)
            {
                String path = (String)importedCommands.elementAt(i);

                String scriptPath;
                if ( path.equals("/") )
                    scriptPath = path + name +".bsh";
                else
                    scriptPath = path +"/"+ name +".bsh";

                Interpreter.debug("searching for script: "+scriptPath );

                InputStream in = bcm.getResourceAsStream( scriptPath );

                if ( in != null )
                    return loadScriptedCommand(
                        in, name, argTypes, scriptPath, interpreter );

                // Chop leading "/" and change "/" to "."
                String className;
                if ( path.equals("/") )
                    className = name;
                else
                    className = path.substring(1).replace('/','.') +"."+name;

                Interpreter.debug("searching for class: "+className);
                Class clas = bcm.classForName( className );
                if ( clas != null )
                    return clas;
            }
        }

        if ( parent != null )
            return parent.getCommand( name, argTypes, interpreter );
        else
            return null;
    }   */
// }}}
protected BshMethod getImportedMethod(String name, Class[] sig) throws UtilEvalError {
    // Try object imports
    if (importedObjects != null)
        for (int i = 0; i < importedObjects.size(); i++) {
            Object object = importedObjects.elementAt(i);
            Class clas = object.getClass();
            Method method = Reflect.resolveJavaMethod(getClassManager(), clas, name, sig, false);
            if (method != null)
                return new BshMethod(method, object);
        }
    // Try static imports
    if (importedStatic != null)
        for (int i = 0; i < importedStatic.size(); i++) {
            Class clas = (Class) importedStatic.elementAt(i);
            Method method = Reflect.resolveJavaMethod(getClassManager(), clas, name, sig, true);
            if (method != null)
                return new BshMethod(method, null);
        }
    return null;
}