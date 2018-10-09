//}}}
//{{{ revalidate() method
/**
	 * We block calls to revalidate() from a setBorderPainted(), for
	 * performance reasons.
	 */
public void revalidate() {
    if (!revalidateBlocked)
        super.revalidate();
}