package com.cn.mahjong.entity;

import java.util.List;

/**
 * 	和牌条件及番数
 * @author Administrator
 *
 */
public class WinCondition {
	
	public WinCondition(){}
	
	public WinCondition(List<Integer> winList, int fanshu){
		
		this.winList = winList;
		this.fanshu = fanshu;
		
	}
	
	private List<Integer> winList; 		//听牌
	
	private int fanshu;					//自身的番数

	public List<Integer> getWinList() {
		return winList;
	}

	public void setWinList(List<Integer> winList) {
		this.winList = winList;
	}

	public int getFanshu() {
		return fanshu;
	}

	public void setFanshu(int fanshu) {
		this.fanshu = fanshu;
	}
	
	
	
}
