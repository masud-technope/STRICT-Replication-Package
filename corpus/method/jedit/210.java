public void writeFile(File fileName) throws BuildException {
    Writer writer = null;
    try {
        this.document = createDOM();
        buildDOM();
        TransformerFactory transFactory = TransformerFactory.newInstance();
        Transformer trans = transFactory.newTransformer();
        trans.setOutputProperty(OutputKeys.INDENT, "yes");
        trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        trans.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "-//Apple Computer//DTD PLIST 1.0//EN");
        trans.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "http://www.apple.com/DTDs/PropertyList-1.0.dtd");
        writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"));
        trans.transform(new DOMSource(document), new StreamResult(writer));
    } catch (TransformerConfigurationException tce) {
        throw new BuildException(tce);
    } catch (TransformerException te) {
        throw new BuildException(te);
    } catch (ParserConfigurationException pce) {
        throw new BuildException(pce);
    } catch (IOException ex) {
        throw new BuildException("Unable to write  \"" + fileName + "\"");
    } finally {
        fileUtils.close(writer);
    }
}