public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("PrintPreviewModel[");
    sb.append("view=").append(view);
    sb.append(", buffer=").append(buffer);
    sb.append(", ps=").append(printService);
    sb.append(", page=").append(pageNumber);
    sb.append(", range=").append(pageRanges);
    sb.append(", gfx=").append(gfx);
    sb.append(", zoom=").append(zoom);
    sb.append(", zoomLevel=").append(zoomLevel);
    sb.append(']');
    return sb.toString();
}