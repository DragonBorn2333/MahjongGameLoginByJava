package com.cn.mahjong.login;

import java.util.Collections;
import java.util.List;

import com.cn.mahjong.entity.MahjongCards;


/**
 * 
 * @author DragonBorn2333
 *	
 *	麻将逻辑类
 */
public class MahjongLogin {
	
	
	//出牌
	static public void putCards(MahjongCards mjCards,int card){
		
		if(null != mjCards){
			List<Integer> cList = mjCards.getCardsDetail().get(card / 100);
			cList.remove(cList.indexOf(card));
		}
	}
	
	//抓牌
	static public void getCards(MahjongCards mjCards,int card){
		if(null != mjCards){
			List<Integer> cList = mjCards.getCardsDetail().get(card / 100);
			cList.add(card);
			Collections.sort(cList);
		}
	}
	
	//碰牌
	static public void pengCards(MahjongCards mjCards,int pengCard){
		
		if(null != mjCards){
			List<Integer> cList = mjCards.getCardsDetail().get(pengCard/100);
			//移除碰的2张牌
			cList.remove(cList.indexOf(pengCard));
			cList.remove(cList.indexOf(pengCard));
			
			//添加碰
			mjCards.getCardsDetail().get(5).add(pengCard);
			mjCards.getCardsDetail().get(5).add(pengCard);
			mjCards.getCardsDetail().get(5).add(pengCard);
			Collections.sort(mjCards.getCardsDetail().get(5));
			
		}
	}
	
	static public void eatCards(){
		
	}
	
	
}
