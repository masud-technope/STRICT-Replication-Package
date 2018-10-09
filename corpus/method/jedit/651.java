private  MyBeanShellFacade() {
    classManager.setClassLoader(new JARClassLoader());
}