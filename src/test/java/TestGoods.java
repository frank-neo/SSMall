import com.ssm.lishaoxiong.entities.Goods;
import com.ssm.lishaoxiong.mapper.GoodsDAO;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TestGoods {

    @Test
    public void getGoodsPagerTest() {
        int skip=4;
        int size=2;
        SqlSession session=MyBatisUtil.getSession();
        try {
            GoodsDAO bookdao=session.getMapper(GoodsDAO.class);
            List<Goods> goods=bookdao.getGoodsPager(skip, size);
            Assert.assertEquals(2, goods.size());
        } finally {
            session.close();
        }
    }

    @Test
    public void getGoodsByIdTest() {
        SqlSession session=MyBatisUtil.getSession();
        try {
            GoodsDAO bookdao=session.getMapper(GoodsDAO.class);
            Goods goods=bookdao.getGoodsById(1);
            Assert.assertEquals(1, goods.getId());
        } finally {
            session.close();
        }
    }

    @Test
    public void getGoodsCountTest() {
        SqlSession session=MyBatisUtil.getSession();
        try {
            GoodsDAO bookdao=session.getMapper(GoodsDAO.class);
            Assert.assertEquals(10, bookdao.getGoodsCount());
        } finally {
            session.close();
        }
    }

    @Test
    public void insertTest() {
        SqlSession session=MyBatisUtil.getSession();
        try {
            Goods entity=new Goods();
            entity.setName("正宗无锡阳山水蜜桃新鲜水果水密桃12个6斤装江浙沪皖顺丰包邮");
            entity.setPrice(108);
            entity.setPicture("nopic.jpg");
            GoodsDAO bookdao=session.getMapper(GoodsDAO.class);
            Assert.assertEquals(1, bookdao.insert(entity));
        } finally {
            session.close();
        }
    }

    @Test
    public void deleteTest() {
        SqlSession session=MyBatisUtil.getSession();
        try {
            GoodsDAO bookdao=session.getMapper(GoodsDAO.class);
            Assert.assertEquals(1, bookdao.delete(12));
        } finally {
            session.close();
        }
    }

    @Test
    public void update() {
        SqlSession session=MyBatisUtil.getSession();
        try {
            GoodsDAO bookdao=session.getMapper(GoodsDAO.class);
            Goods entity=bookdao.getGoodsById(12);
            entity.setName("正宗无锡阳山水蜜桃新鲜水果水密桃12个6斤装");
            entity.setPrice(107);
            entity.setPicture("nopicture.jpg");

            Assert.assertEquals(1, bookdao.update(entity));
        } finally {
            session.close();
        }
    }

}
