//}}}
/* public static void newViewTest()
	{
		long time = System.currentTimeMillis();
		for(int i = 0; i < 30; i++)
		{
			Buffer b = newFile(null);
			b.insert(0,"x");
			new View(b,null,false);
		}
		System.err.println(System.currentTimeMillis() - time);
	} */
//{{{ newView() methods
/**
	 * Creates a new view.
	 * @param view An existing view
	 * @since jEdit 3.2pre2
	 */
public static View newView(View view) {
    return newView(view, null, false);
}