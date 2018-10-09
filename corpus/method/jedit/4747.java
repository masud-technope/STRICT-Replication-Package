//}}}
//{{{ findResources() method
/**
	 * @return zero or one resource, as returned by getResource()
	 */
@Override
public Enumeration<URL> getResources(String name) throws IOException {
    class SingleElementEnumeration implements Enumeration<URL> {

        private URL element;

         SingleElementEnumeration(URL element) {
            this.element = element;
        }

        public boolean hasMoreElements() {
            return element != null;
        }

        public URL nextElement() {
            if (element != null) {
                URL retval = element;
                element = null;
                return retval;
            } else
                throw new NoSuchElementException();
        }
    }
    URL resource = getResource(name);
    return new SingleElementEnumeration(resource);
}