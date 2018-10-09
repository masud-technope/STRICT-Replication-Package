/*
		Note: assumes default character encoding
	*/
static String getFile(String name) throws FileNotFoundException, IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader bin = new BufferedReader(new FileReader(name));
    String line;
    while ((line = bin.readLine()) != null) sb.append(line).append("\n");
    return sb.toString();
}