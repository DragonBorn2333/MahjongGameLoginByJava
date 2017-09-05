package com.cn.mahjong.entity;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author DargonBorn2333
 *		�齫����ʵ����
 *
 */
public class MahjongCards {
	
	//����������ɵ��ַ���
	private String cardStr;
	
	//��������     key :  100 ��  200 ��  300 ��  400 ��   500 ��  600  ��  700 ��
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
