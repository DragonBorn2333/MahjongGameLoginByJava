package com.cn.mahjong.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author DragonBorn2333
 *
 *	玩家类
 *
 */
public class Player {
	
	
	public Player(){
		
		
		
		
	}
	
	public Player(Player nextPlayer,MahjongCards cards,boolean isZhuang){
		this.nextPlayer = nextPlayer;
		this.cards = cards;
		this.isZhuang = isZhuang;
		
		this.cards = new MahjongCards();
		Map<Integer, List<Integer>> card = new HashMap<Integer, List<Integer>>();
		card.put(1, new ArrayList<Integer>());
		card.put(2, new ArrayList<Integer>());
		card.put(3, new ArrayList<Integer>());
		card.put(4, new ArrayList<Integer>());
		card.put(5, new ArrayList<Integer>());
		card.put(6, new ArrayList<Integer>());
		card.put(7, new ArrayList<Integer>());
		card.put(8, new ArrayList<Integer>());
		
	}
	
	//下家
	private Player nextPlayer;
	
	//手牌
	private MahjongCards cards;
	
	//是否是庄家
	private boolean isZhuang;
	
	//听牌
	private WinCondition condition;
	
	//0 不能摇宝  1可以摇宝  2 已经摇宝
	private int baoState; 
	
	
	public Player getNextPlayer() {
		return nextPlayer;
	}

	public void setNextPlayer(Player nextPlayer) {
		this.nextPlayer = nextPlayer;
	}

	public MahjongCards getCards() {
		return cards;
	}

	public void setCards(MahjongCards cards) {
		this.cards = cards;
	}

	public boolean isZhuang() {
		return isZhuang;
	}

	public void setZhuang(boolean isZhuang) {
		this.isZhuang = isZhuang;
	}

	public WinCondition getCondition() {
		return condition;
	}

	public void setCondition(WinCondition condition) {
		this.condition = condition;
	}

	public int getBaoState() {
		return baoState;
	}

	public void setBaoState(int baoState) {
		this.baoState = baoState;
	}
	
	
}
