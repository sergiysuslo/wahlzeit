package org.wahlzeit.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.wahlzeit.services.DataObject;

////////////////////////////////////////////////////////////////////////////////////////
////////////////  Monument object instantiation:   /////////////////////////////////////
//                                                                                    //
////////////////  MonumentManager.createMonument() /////////////////////////////////////
////////////////  MonumentType.createInstance()    /////////////////////////////////////
////////////////  Monument.Monument()              /////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////

public class Monument extends DataObject {

    protected MonumentType monumentType = null; // STATUE, MEMORIAL, BUILDING ..
    protected int constructionYear;
    protected String name;
    protected Location location;

    public Monument(MonumentType mt, String name) {
        this.monumentType = mt;
        this.name = name;
    }

    public Monument(MonumentType mt, String name, Location location){
        this.monumentType = mt;
        this.name = name;
        this.location = location;
    }

    public String getName(){
        return this.name;
    }

    public MonumentType getType(){
        return this.monumentType;
    }

    @Override
    public String getIdAsString() {
        
        return null;
    }

    @Override
    public void readFrom(ResultSet rset) throws SQLException {
        name = rset.getString("monument_name");
        constructionYear = rset.getInt("construction_year");

    }

    @Override
    public void writeOn(ResultSet rset) throws SQLException {
        rset.updateString("monument_type", this.monumentType.getMonumentTypeName());
        rset.updateInt("construction_year", this.constructionYear);
        rset.updateString("monument_name", this.name);

    }

    @Deprecated
    public void writeId(PreparedStatement stmt, int pos) throws SQLException {}


    
}
