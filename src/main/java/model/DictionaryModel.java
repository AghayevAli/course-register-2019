package model;

import persistence.entity.Dictionary;

public class DictionaryModel {
    private Integer id;

    private String dicVal;

    public static DictionaryModel build(Dictionary type) {
        if (type != null) {
            return new DictionaryModel(type.getId(), type.getDicVal());
        }
        return null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDicVal() {
        return dicVal;
    }

    public void setDicVal(String dicVal) {
        this.dicVal = dicVal;
    }

    public DictionaryModel(Integer id, String dicVal) {
        this.id = id;
        this.dicVal = dicVal;
    }
}
