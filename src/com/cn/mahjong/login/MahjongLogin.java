package com.cn.mahjong.login;

import java.util.Collections;
import java.util.List;

import com.cn.mahjong.entity.MahjongCards;

public class MahjongLogin {
	
	
	//����
	static public void putCards(MahjongCards mjCards,int card){
		
		if(null != mjCards){
			List<Integer> cList = mjCards.getCardsDetail().get(card / 100);
			cList.remove(cList.indexOf(card));
		}
	}
	
	//ץ��
	static public void getCards(MahjongCards mjCards,int card){
		if(null != mjCards){
			List<Integer> cList = mjCards.getCardsDetail().get(card / 100);
			cList.add(card);
			Collections.sort(cList);
		}
	}
	
	static public void pengCards(MahjongCards mjCards,int card1){
		
	}
	
	static public void eatCards(){
		
	}
	
	
}
