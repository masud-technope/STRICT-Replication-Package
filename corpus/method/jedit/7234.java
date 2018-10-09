//}}}
//{{{ getFocusTraversalKeysEnabled() method
/**
	 * Java 1.4 compatibility fix to make Tab key work.
	 * @since jEdit 3.2pre4
	 */
@Override
public boolean getFocusTraversalKeysEnabled() {
    return false;
}