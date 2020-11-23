package org.wahlzeit.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MonumentPhoto extends Photo {

    
    private String monumentType;  // STATUE, MEMORIAL, BUILDING ..
    private int constructionYear;

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
        monumentType = rset.getString("monument_type");
        constructionYear = rset.getInt("construction_year");
    }

    @Override
    public void writeOn(ResultSet rset) throws SQLException {
        super.writeOn(rset);
        rset.updateString("type", monumentType);
        rset.updateInt("construction_year", this.constructionYear);
    }

    public String getType(){
        return this.monumentType;
    }

    public void setType(String type){
        this.monumentType = type;
    }

    public int getConstructionYear(){
        return this.constructionYear;
    }

    public void setConstructionYear(int year){
        this.constructionYear = year;
    }
}
