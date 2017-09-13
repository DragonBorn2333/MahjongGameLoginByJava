package com.cn.mahjong.login;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.cn.mahjong.entity.MahjongCards;
import com.cn.mahjong.entity.Player;
import com.cn.mahjong.entity.WinCondition;


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
				
				if(isMingGang){
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
				}else{
					List<Integer> cList = mjCards.getCardsDetail().get(gangCard/100);
					//需要移除手牌
					cList.remove(cList.indexOf(gangCard));
					cList.remove(cList.indexOf(gangCard));
					cList.remove(cList.indexOf(gangCard));
					
					mjCards.getCardsDetail().get(8).add(gangCard);
					mjCards.getCardsDetail().get(8).add(gangCard);
					mjCards.getCardsDetail().get(8).add(gangCard);
					mjCards.getCardsDetail().get(8).add(gangCard);
				}
				
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
	 * 检查其他玩家打出的牌 是否可以 碰或杠
	 * return 1 杠   2碰  0 都不是
	 */
	static int checkOtherPlayerPengOrGang(MahjongCards mjCards,int pengCard){
		if(null != mjCards){
			List<Integer> cList = mjCards.getCardsDetail().get(pengCard/100);
			if(cList.contains(pengCard)){
				int pNum = 0;
				for(int p : cList){
					if(p==pengCard){
						pNum++;
					}
				}
				if(pNum==2){
					return 2;
				}else if(pNum==3){
					return 1;
				}
			}
		}
		return 0;
	}
	
	/**
	 * 检查当前玩家抓的牌 是否可以 杠 
	 *@return	1 暗杠  2 明杠  0 都不是
	 */
	static int checkThisPlayerPeng(MahjongCards mjCards,int pengCard){
		if(null != mjCards){
			if(mjCards.getCardsDetail().get(5).contains(pengCard)){
				return 2;
			}
			
			List<Integer> cList = mjCards.getCardsDetail().get(pengCard/100);
			if(cList.contains(pengCard)){
				int pNum = 0;
				for(int p : cList){
					if(p==pengCard){
						pNum++;
					}
				}
				if(pNum==3){
					return 1;
				}
			}
		}
		
		return 0;
	}
	
	/**
	 * 检查是否听牌，并返回听牌
	 * @param mjCards
	 */
	static void checkTing(Player player){
		int fan = 0;
		MahjongCards mjCards = player.getCards();
		int mjArr[] = {101,102,103,104,105,106,107,108,109,
						201,202,203,204,205,206,207,208,209,
						301,302,303,304,305,306,307,308,309,
						401,402,403,404,405,406,407};
		
		if(null != mjCards){
			
			List<Integer> tingList = new ArrayList<Integer>();
			List<Integer> handList = new ArrayList<Integer>();
			handList.addAll(mjCards.getCardsDetail().get(1));
			handList.addAll(mjCards.getCardsDetail().get(2));
			handList.addAll(mjCards.getCardsDetail().get(3));
			handList.addAll(mjCards.getCardsDetail().get(4));
			
			//判断花色 和 1、9
			boolean isCanWin = false;
			boolean isCanBao = true;
			List<Integer> allList = new ArrayList<Integer>();
			allList.addAll(mjCards.getCardsDetail().get(1));
			allList.addAll(mjCards.getCardsDetail().get(2));
			allList.addAll(mjCards.getCardsDetail().get(3));
			allList.addAll(mjCards.getCardsDetail().get(4));
			allList.addAll(mjCards.getCardsDetail().get(5));
			allList.addAll(mjCards.getCardsDetail().get(6));
			allList.addAll(mjCards.getCardsDetail().get(7));
			allList.addAll(mjCards.getCardsDetail().get(8));
			
			String allStr = allList.toArray().toString();
			//花色判断
			if(allStr.contains("10") && allStr.contains("20") && allStr.contains("30")){
				isCanWin = true;
			}else if(allStr.contains("10") && !allStr.contains("20") && !allStr.contains("30") || 
					!allStr.contains("10") && allStr.contains("20") && !allStr.contains("30") ||
					!allStr.contains("10") && !allStr.contains("20") && allStr.contains("30")){
				//清一色
				isCanWin = true;
				fan++;
			}
			
			if(mjCards.getCardsDetail().get(4).size()>0 ||
					allStr.contains("101") || allStr.contains("109")||
					allStr.contains("201") || allStr.contains("209")||
					allStr.contains("301") || allStr.contains("309")){
				//存在1、9
			}else{
				//没有1,9 的情况下只能胡1或9，并且不能摇宝
				isCanBao = false;
				mjArr = new int[]{101,109,201,209,301,309};
			}
			
			if(isCanWin){
				int ak = 0;
				int sz =0;
				//没考虑花色、和必须有暗刻
				for(int i=0;i<mjArr.length-2;i++){
					List<Integer> tempList = new ArrayList<Integer>();
					tempList.addAll(handList);
					tempList.add(mjArr[i]);
					Collections.sort(tempList);
					int anke = 0;
					int shunzi = 0;
					boolean findDui = false;
					for(int x=0;x<tempList.size()-2;){
						//判断是不是暗刻
						if(tempList.get(x)==tempList.get(x+1) && tempList.get(x+1)==tempList.get(x+2)){
							anke++;
							int tempCard = tempList.get(x);
							tempList.remove(tempCard);
							tempList.remove(tempCard);
							tempList.remove(tempCard);
							continue;
						}else if(tempList.get(x)==(tempList.get(x+1)+1) && tempList.get(x+1)==(tempList.get(x+2)+1) && (tempList.get(x)/100)!=4){
							//判断是不是顺子
							shunzi++;
							int tempCard = tempList.get(x);
							tempList.remove(tempCard);
							tempList.remove(tempCard+1);
							tempList.remove(tempCard+2);
							continue;
						}else if(tempList.get(x)==tempList.get(x+1) && !findDui){
							x+=2;
							findDui = true;
							continue;
						}else{
							break;
						}
					}
					
					if(tempList.size()==2 && tempList.get(0)==tempList.get(1)){
						//听
						tingList.add(mjArr[i]);
						ak=anke;
						sz=shunzi;
					}
					
				}
				
				//处理tingList 处理番数
				if(tingList.size()>0){
					//上听
					if(mjCards.getCardsDetail().get(5).size()==0 &&
							mjCards.getCardsDetail().get(6).size()==0 &&
							mjCards.getCardsDetail().get(7).size()==0){
						//站着和
						fan++;
					}
					if(tingList.size()==1){
						//单轧
						fan++;
					}
					if(mjCards.getCardsDetail().get(6).size()==0 
							&& ((handList.size()-2)/3)==ak && sz==0){
						//飘
						fan++;
					}
					
					player.setCondition(new WinCondition(tingList, fan));
					//如果可以摇宝 更改成 可以摇宝的状态
					if(isCanBao){
						player.setBaoState(1);
					}
				}
			}
		}
		
	}
	
}
