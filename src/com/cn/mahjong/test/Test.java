package com.cn.mahjong.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cn.mahjong.entity.MahjongCards;
import com.cn.mahjong.entity.Player;

public class Test {

	
	public static void main(String[] args) {
		
		
		Player p = new Player();
		MahjongCards mjCard = new MahjongCards();
		
		Map<Integer, List<Integer>> cards = new HashMap<Integer, List<Integer>>();
		List<Integer> tl = new ArrayList<Integer>();
		List<Integer> bl = new ArrayList<Integer>();
		List<Integer> wl = new ArrayList<Integer>();
		List<Integer> fl = new ArrayList<Integer>();
		List<Integer> cl = new ArrayList<Integer>();
		List<Integer> pl = new ArrayList<Integer>();
		List<Integer> gl = new ArrayList<Integer>();
		cards.put(1, tl);
		
		
		
	}
	
}
