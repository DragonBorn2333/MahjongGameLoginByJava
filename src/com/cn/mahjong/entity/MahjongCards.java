package com.cn.mahjong.entity;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author DargonBorn2333
 *		麻将手牌实体类
 *
 */
public class MahjongCards {
	
	//所有手牌组成的字符串
	private String cardStr;
	
	//手牌详情     key :  100 条  200 饼  300 万  400 风   500 碰  600  吃  700 杠
	private Map<Integer, List<Integer>> cardsDetail;

	
	public String getCardStr() {
		return cardStr;
	}

	public void setCardStr(String cardStr) {
		this.cardStr = cardStr;
	}

	public Map<Integer, List<Integer>> getCardsDetail() {
		return cardsDetail;
	}

	public void setCardsDetail(Map<Integer, List<Integer>> cardsDetail) {
		this.cardsDetail = cardsDetail;
	}
	
	
	
}
