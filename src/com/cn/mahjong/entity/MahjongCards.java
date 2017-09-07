package com.cn.mahjong.entity;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author DargonBorn2333
 *		麻将手牌类
 *
 */
public class MahjongCards {
	
	//所有手牌拼接的字符串
	private String cardStr;
	
	//具体的手牌信息     key :  100 条  200 饼  300 万  400 风   500 碰  600  吃  700 明杠 800 暗杠 
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
