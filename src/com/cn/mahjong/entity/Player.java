package com.cn.mahjong.entity;

/**
 * 
 * @author DragonBorn2333
 *
 *	�����
 *
 */
public class Player {
	
	
	public Player(){}
	
	public Player(Player nextPlayer,MahjongCards cards,boolean isZhuang){
		this.nextPlayer = nextPlayer;
		this.cards = cards;
		this.isZhuang = isZhuang;
	}
	
	//�¼�
	private Player nextPlayer;
	
	//����
	private MahjongCards cards;
	
	//�Ƿ���ׯ��
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
