public static void main(String[] args) throws Exception {
    URL[] urls = new URL[args.length];
    for (int i = 0; i < args.length; i++) urls[i] = new File(args[i]).toURI().toURL();
    BshClassPath bcp = new BshClassPath("Test", urls);
}