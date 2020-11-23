package org.wahlzeit.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MonumentPhotoFactory extends PhotoFactory {
    
    @Override
    public Photo createPhoto() {
        return new MonumentPhoto();
    }

    @Override
    public Photo createPhoto(PhotoId id){
        return new MonumentPhoto(id);
    }

    @Override
    public Photo createPhoto(ResultSet rs) throws SQLException {
        return new MonumentPhoto(rs);
    }
}
