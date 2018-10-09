synchronized void map(URL url) throws IOException {
    String name = url.getFile();
    File f = new File(name);
    if (f.isDirectory()) {
        classMapping("Directory " + f.toString());
        map(traverseDirForClasses(f), new DirClassSource(f));
    } else if (isArchiveFileName(name)) {
        classMapping("Archive: " + url);
        map(searchJarForClasses(url), new JarClassSource(url));
    } else /*
		else if ( isClassFileName( name ) )
			map( looseClass( name ), url );
		*/
    {
        String s = "Not a classpath component: " + name;
        errorWhileMapping(s);
    }
}