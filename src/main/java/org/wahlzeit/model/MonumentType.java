package org.wahlzeit.model;

import java.util.*;

public class MonumentType {

    protected String name;
    protected MonumentType superType = null;
    protected Set<MonumentType> subTypes = new HashSet<MonumentType>();

    public MonumentType(String name){
        this.name = name;
    }

    
    public MonumentType getSuperType() {
        return superType;
    }    

    public String getMonumentTypeName(){
        return this.name;
    }

    public void setSuperType(MonumentType mt){
        this.superType = mt;
    }

    public Iterator <MonumentType> getSubTypeIterator(){
        return subTypes.iterator();
    }

    public void addSubType(MonumentType mt){
        assert (mt != null) : "tried to set null sub-type";
        if(subTypes.contains(mt)){
            return;
        }
        subTypes.add(mt);
    }
    public boolean hasInstance(Monument monument) {
        assert (monument != null) : "asked about null object";

        if (monument.getType() == this) {
            return true;
        }

        for (MonumentType type : subTypes) {
            if (type.hasInstance(monument)) {
                return true;
            }
        }
        return false;
    }    

    public Monument createInstance(String name){
        return new Monument(this, name);
    }

    
}
