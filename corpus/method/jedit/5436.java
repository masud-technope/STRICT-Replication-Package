public void setList(List<MirrorList.Mirror> mirrors) {
    this.mirrors = mirrors;
    fireContentsChanged(this, 0, mirrors.size() - 1);
}