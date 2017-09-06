package com.cn.mahjong.entity;

/**
 * 
 * @author DragonBorn2333
 *
 *	玩家类
 *
 */
public class Player {
	
	
	public Player(){}
	
	public Player(Player nextPlayer,MahjongCards cards,boolean isZhuang){
		this.nextPlayer = nextPlayer;
		this.cards = cards;
		this.isZhuang = isZhuang;
	}
	
	//下家
	private Player nextPlayer;
	
	//手牌
	private MahjongCards cards;
	
	//是否是庄家
	private boolean isZhuang;

	
	
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
	
	
}
