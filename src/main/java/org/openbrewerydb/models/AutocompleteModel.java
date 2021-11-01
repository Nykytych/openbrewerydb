package org.openbrewerydb.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AutocompleteModel{

    @JsonProperty("name")
    private String name;

    @JsonProperty("id")
    private String id;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }
}