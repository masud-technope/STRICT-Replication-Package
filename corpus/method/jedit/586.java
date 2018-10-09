//}}}
//{{{ loadAbbrevs() method
private static void loadAbbrevs(Reader _in) throws Exception {
    BufferedReader in = new BufferedReader(_in);
    try {
        Hashtable<String, String> currentAbbrevs = globalAbbrevs;
        String line;
        while ((line = in.readLine()) != null) {
            int index = line.indexOf('|');
            if (line.length() == 0)
                continue;
            else if (line.startsWith("[") && index == -1) {
                if (line.equals("[global]"))
                    currentAbbrevs = globalAbbrevs;
                else {
                    String mode = line.substring(1, line.length() - 1);
                    currentAbbrevs = modes.get(mode);
                    if (currentAbbrevs == null) {
                        currentAbbrevs = new Hashtable<String, String>();
                        modes.put(mode, currentAbbrevs);
                    }
                }
            } else if (index != -1) {
                currentAbbrevs.put(line.substring(0, index), line.substring(index + 1));
            }
        }
    } finally {
        in.close();
    }
}