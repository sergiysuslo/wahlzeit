package org.wahlzeit.model;

import java.sql.ResultSet;
import java.sql.SQLException;

////////////////////////////////////////////////////////////////////////////////////////
////////////////  MonumentPhoto object instantiation:   ////////////////////////////////
//                                                                                    //
////////////////  MonumentPhotoFactory.createPhoto()  //////////////////////////////////
////////////////  MonumentPhoto.MonumentPhoto()      ///////////////////////////////////
////////////////  Photo.Photo()                     ////////////////////////////////////
////////////////  Photo.readFrom()                 /////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////

public class MonumentPhoto extends Photo {

    
    protected Monument monument;

    public MonumentPhoto(){
        super();
    }

    public MonumentPhoto(PhotoId myId){
        super(myId);
    }

    public MonumentPhoto(ResultSet rset) throws SQLException {
        super(rset);
    }

    @Override
    public void readFrom(ResultSet rset) throws SQLException {
        super.readFrom(rset);
    }

    @Override
    public void writeOn(ResultSet rset) throws SQLException {
        super.writeOn(rset);
    }

    public Monument getMonument(){
        return this.monument;
    }

    public void setMonument(Monument monument){
        this.monument = monument;
    }

}
