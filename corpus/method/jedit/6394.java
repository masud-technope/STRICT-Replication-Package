//{{{ writeXMLDeclaration() method
/**
		 * Write the XML declaration of a specific version.
		 * This should be the first output.
		 */
public void writeXMLDeclaration(String version) throws IOException {
    write("<?xml" + " version=\"" + version + "\"" + " encoding=\"" + encoding + "\"" + " ?>");
    newLine();
//}}}
}