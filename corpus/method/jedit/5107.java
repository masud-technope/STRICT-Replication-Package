public static void storeProperties(Properties props, OutputStream out, String comments) throws IOException {
    Properties sorted = new Properties() {

        @Override
        public synchronized Enumeration<Object> keys() {
            return Collections.enumeration(new TreeSet<Object>(props.keySet()));
        }

        @Override
        public synchronized Set<Map.Entry<Object, Object>> entrySet() {
            return (new TreeMap<Object, Object>(props)).entrySet();
        }
    };
    sorted.putAll(props);
    sorted.store(out, comments);
}