/**
     * @param lsArchitecturePriority space separated LSArchitecturePriority, e.g. i386 x64_64 ppc
     */
public void setLSArchitecturePriority(String lsArchitecturePriority) {
    // Use for 1.4 backwards compatability
    String[] tokens = lsArchitecturePriority.split("\\s+");
    for (int i = 0; i < tokens.length; i++) mLSArchitecturePriority.add(tokens[i]);
// 'java.util.Scanner' is available in JDK 1.5
// Scanner s = new Scanner(lsArchitecturePriority);
// s = s.useDelimiter("\\s+");
// while (s.hasNext())
//     mLSArchitecturePriority.add(s.next());
}