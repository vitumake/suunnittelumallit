package proxy;

class ProxyImage implements Image {
    private final String filename;
    private RealImage image;
    
    /**
     * Constructor
     * @param filename
     */
    public ProxyImage(String filename) {
        this.filename = filename;
    }

    /**
     * Displays the image
     */
    public void displayImage() {
        if (image == null) {
           image = new RealImage(filename);
        }
        image.displayImage();
    }

    /**
     * Displays the image data
     */
    public void showData() {
        System.out.println("Filename: " + filename);
    }

    /**
     * Gets the filename
     * @return
     */
    public String getFilename() {
        return filename;
    }
}

