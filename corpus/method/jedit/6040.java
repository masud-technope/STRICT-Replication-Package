//}}}
//{{{ saveUserProps() method
void saveUserProps(OutputStream out) throws IOException {
    MiscUtilities.storeProperties(user, out, "jEdit properties");
}