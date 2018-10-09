@Override
public void processingInstruction(String target, String data) {
    if ("illegal-xml-character".equals(target)) {
        char ch;
        try {
            ch = (char) Integer.parseInt(data.trim());
        } catch (Exception e) {
            Log.log(Log.ERROR, this, "Failed to get character from PI" + "\"" + target + "\"" + " with \"" + data + "\"" + ": " + e);
            return;
        }
        characters(new char[] { ch }, 0, 1);
    }
}