package com.cn.mahjong.login;

import java.util.ArrayList;
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
	
	/**
	 * 杠牌
	 * @param mjCards		手牌
	 * @param pengCard		杠牌
	 * @param isMingGang	是否是明杠  true:是
	 * @param isPengGang	是否是碰的杠  true:是
	 */
	static public void gangCards(MahjongCards mjCards,int gangCard,boolean isMingGang,boolean isPengGang){
		
		if(null != mjCards){
			
			if(isPengGang){
				List<Integer> cList = mjCards.getCardsDetail().get(gangCard/100);
				//需要移除手牌
				cList.remove(cList.indexOf(gangCard));
				cList.remove(cList.indexOf(gangCard));
				cList.remove(cList.indexOf(gangCard));
				if(isMingGang){
					mjCards.getCardsDetail().get(7).add(gangCard);
					mjCards.getCardsDetail().get(7).add(gangCard);
					mjCards.getCardsDetail().get(7).add(gangCard);
					mjCards.getCardsDetail().get(7).add(gangCard);
				}else{
					mjCards.getCardsDetail().get(8).add(gangCard);
					mjCards.getCardsDetail().get(8).add(gangCard);
					mjCards.getCardsDetail().get(8).add(gangCard);
					mjCards.getCardsDetail().get(8).add(gangCard);
				}
			}else{
				//自己抓上来的杠，要在碰牌堆里移除
				List<Integer> cList = mjCards.getCardsDetail().get(5);
				cList.remove(cList.indexOf(gangCard));
				cList.remove(cList.indexOf(gangCard));
				cList.remove(cList.indexOf(gangCard));
				//加入到明杠牌堆
				mjCards.getCardsDetail().get(7).add(gangCard);
				mjCards.getCardsDetail().get(7).add(gangCard);
				mjCards.getCardsDetail().get(7).add(gangCard);
				mjCards.getCardsDetail().get(7).add(gangCard);
			}
			
		}
		
	}
	
	//吃牌
	static public void eatCards(MahjongCards mjCards,int eatExist1,int eatExist2,int eatCard){
		
		if(null != mjCards){
			List<Integer> cList = mjCards.getCardsDetail().get(eatCard/100);
			//移除吃的2张牌
			cList.remove(cList.indexOf(eatExist1));
			cList.remove(cList.indexOf(eatExist2));
			
			//添加吃
			mjCards.getCardsDetail().get(6).add(eatExist1);
			mjCards.getCardsDetail().get(6).add(eatExist2);
			mjCards.getCardsDetail().get(6).add(eatCard);
			
		}
		
	}
	
	/**
	 * 检查是否能吃该牌   返回能吃的组合
	 */
	static public List<List<Integer>> checkEat(MahjongCards mjCards,int eatCard){
		
		if(null != mjCards){
			if( (mjCards.getCardsDetail().get(1).size()
					+mjCards.getCardsDetail().get(2).size()
					+mjCards.getCardsDetail().get(3).size()
					+mjCards.getCardsDetail().get(4).size() ) <= 4){
				//如果实际手牌数 小于等于4张，不能手把一，所以不能吃
				return null;
			}
			
			List<Integer> cList = mjCards.getCardsDetail().get(eatCard/100);
			
			List<List<Integer>> eatList = new ArrayList<List<Integer>>();
			
			if(cList.size()<2){
				//该花色牌，少于两张牌 不能吃
				return null;
			}
			
			//吃牌在头位置
			if(cList.contains(eatCard+1) && cList.contains(eatCard+2)){
				List<Integer> eat = new ArrayList<Integer>();
				eat.add(eatCard);
				eat.add(eatCard+1);
				eat.add(eatCard+2);
				eatList.add(eat);
			}
			
			//吃牌在中间位置
			if(cList.contains(eatCard-1) && cList.contains(eatCard+1)){
				List<Integer> eat = new ArrayList<Integer>();
				eat.add(eatCard);
				eat.add(eatCard+1);
				eat.add(eatCard+2);
				eatList.add(eat);
			}
			
			//吃牌在末尾位置
			if(cList.contains(eatCard-1) && cList.contains(eatCard-2)){
				List<Integer> eat = new ArrayList<Integer>();
				eat.add(eatCard);
				eat.add(eatCard+1);
				eat.add(eatCard+2);
				eatList.add(eat);
			}
			
			return eatList;
		}
		return null;
	}
	
	/**
	 * 检查碰或杠
	 */
	static void checkPengOrGang(){
		
	}
	
}
