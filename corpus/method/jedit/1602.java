/*
	private String getHelp( String name )
		throws UtilEvalError
	{
		try {
			// should check for null namespace here
			return get( "bsh.help."+name, null/interpreter/ );
		} catch ( Exception e ) {
			return "usage: "+name;
		}
	}

	private String getHelp( Class commandClass )
		throws UtilEvalError
	{
        try {
            return (String)Reflect.invokeStaticMethod(
				null/bcm/, commandClass, "usage", null );
        } catch( Exception e )
			return "usage: "+name;
		}
	}
*/
// Static methods that operate on compound ('.' separated) names
// I guess we could move these to StringUtil someday
public static boolean isCompound(String value) {
    return value.indexOf('.') != -1;
//return countParts(value) > 1;
}