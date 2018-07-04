package com.ssm.lishaoxiong.mapper;

import com.ssm.lishaoxiong.entities.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsDAO {

    /**
     * 获得商品信息并分页
     */
    public List<Goods> getGoodsPager(@Param("skip") int skip, @Param("size") int size);

    /**
     * 获得单个商品通过编号
     */
    public Goods getGoodsById(int id);

    /**
     * 获得商品总数
     */
    public int getGoodsCount();

    /*
     * 新增加商品
     */
    public int insert(Goods entity);

    /**
     * 删除商品
     */
    public int delete(int id);

    /**
     * 修改商品
     */
    public int update(Goods entity);

}

