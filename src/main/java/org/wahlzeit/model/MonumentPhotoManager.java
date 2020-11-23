package org.wahlzeit.model;

public class MonumentPhotoManager extends PhotoManager {
    
    public MonumentPhotoManager() {
        photoTagCollector = MonumentPhotoFactory.getInstance().createPhotoTagCollector();
    }
}
