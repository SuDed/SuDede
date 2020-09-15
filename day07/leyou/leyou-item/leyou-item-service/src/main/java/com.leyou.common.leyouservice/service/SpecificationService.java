package com.leyou.common.leyouservice.service;

import com.leyou.common.leyouservice.mapper.SpecGroupMapper;
import com.leyou.common.leyouservice.mapper.SpecParamMapper;
import com.leyou.item.pojo.SpecGroup;
import com.leyou.item.pojo.SpecParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecificationService {
    @Autowired
    private SpecGroupMapper groupMapper;
    @Autowired
    private SpecParamMapper paramMapper;

    public List<SpecGroup> queryGroupsByCid(Long cid) {        /**
         * 根据分类id查询分组
         * @param cid
         * @return
         */
        SpecGroup specGroup=new SpecGroup();
        specGroup.setCid(cid);
        return this.groupMapper.select(specGroup);
    }

    public List<SpecParam> queryParams(Long gid,Long cid,Boolean generic,Boolean searching) {
        SpecParam record = new SpecParam();
        record.setGroupId(gid);
        record.setCid(cid);
        record.setGeneric(generic);
        record.setSearching(searching);
        return this.paramMapper.select(record);
    }

    public void add(SpecGroup specGroup) {
        groupMapper.insert(specGroup);
    }

    public void update(SpecGroup specGroup) {
        groupMapper.updateByPrimaryKey(specGroup);
    }

    public void delete(Long gid) {
        groupMapper.deleteByPrimaryKey(gid);
    }

    public void addp(SpecParam specParam) {
        paramMapper.insert(specParam);
    }

    public void updatep(SpecParam specParam) {
        paramMapper.updateByPrimaryKey(specParam);
    }

    public void deletep(Long pid) {
        paramMapper.deleteByPrimaryKey(pid);
    }
}
