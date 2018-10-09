/**
		Split a filename into dirName, baseName
		@return String [] { dirName, baseName }
    public String [] splitFileName( String fileName ) 
	{ 
		String dirName, baseName;
		int i = fileName.lastIndexOf( File.separator );
		if ( i != -1 ) {
			dirName = fileName.substring(0, i);
			baseName = fileName.substring(i+1);
		} else
			baseName = fileName;

		return new String[] { dirName, baseName };
	}

	*/
/**
		Hack - The real method is in Reflect.java which is not public.
	*/
public static String normalizeClassName(Class type) {
    return Reflect.normalizeClassName(type);
}