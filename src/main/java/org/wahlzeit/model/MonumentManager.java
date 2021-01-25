package org.wahlzeit.model;

import java.util.*;

public class MonumentManager {

    protected static MonumentManager instance = new MonumentManager();

    protected Map<String, Monument> monumentCache = new HashMap<String, Monument>();
    protected Map<String, MonumentType> monumentTypeCache = new HashMap<String, MonumentType>();

    public static MonumentManager getInstance(){
        return MonumentManager.instance;
    }

    public MonumentType getMonumentType(String name){
        if(monumentTypeCache.containsKey(name)){
            return monumentTypeCache.get(name);
        }

        MonumentType mt = new MonumentType(name);
        monumentTypeCache.put(name, mt);
        return mt;
    }

    public Monument createMonument(String name, String typeName){
        MonumentType mt = getMonumentType(typeName);
        Monument result = mt.createInstance(name);
        monumentCache.put(result.getName(), result);
        return result;
    }

    
}
