package Entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoodsTest {
Goods goods = new Goods(1,100);
    @Test
    void getWeight() {
        assertEquals(goods.getWeight(),100);
    }

    @Test
    void setWeight() {
        goods.setWeight(1200);
        assertEquals(goods.getWeight(),1200);

    }

    @Test
    void getGoodsId() {
        assertEquals(goods.getGoodsId(),1);
    }

    @Test
    void setGoodsId() {
        goods.setGoodsId(10);
        assertEquals(goods.getGoodsId(),10);
    }

}