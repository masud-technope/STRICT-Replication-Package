// New in JarBundler 2.2.0; Tobias Bley ----------------------------------------------------
/**
     * @param archs space separated archs, e.g. i386 x64_64 ppc
     */
public void setJVMArchs(String archs) {
    // Use for 1.4 backwards compatability
    String[] tokens = archs.split("\\s+");
    for (int i = 0; i < tokens.length; i++) mJVMArchs.add(tokens[i]);
// 'java.util.Scanner' is available in JDK 1.5
// Scanner s = new Scanner(archs);
// s = s.useDelimiter("\\s+");
// while (s.hasNext())
//     mJVMArchs.add(s.next());
}