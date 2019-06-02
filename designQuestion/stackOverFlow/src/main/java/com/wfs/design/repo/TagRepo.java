package com.wfs.design.repo;

import com.wfs.design.bo.Tag;
import com.wfs.design.constant.TagType;

import java.util.HashMap;
import java.util.Map;

public class TagRepo {

    private Map<TagType , Tag> map =new HashMap<>();



    public boolean createTag(TagType tagType , Tag tag){
        map.put(tagType ,tag);
        return true;
    }

}
