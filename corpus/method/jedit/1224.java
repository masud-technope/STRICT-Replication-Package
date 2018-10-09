/*
        The superclass does something like this

        c = findLoadedClass(name);
        if null
            try
                if parent not null
                    c = parent.loadClass(name, false);
                else
                    c = findBootstrapClass(name);
            catch ClassNotFoundException
                c = findClass(name);
    */
BshClassManager getClassManager() {
    return classManager;
}