package com.springbook.view.controller;

import java.util.HashMap;
import java.util.Map;

import com.springbook.view.board.DeleteBoardController;
import com.springbook.view.board.GetBoardController;
import com.springbook.view.board.GetBoardListController;
import com.springbook.view.board.InsertBoardController;
import com.springbook.view.board.UpdateBoardController;
import com.springbook.view.user.LoginController;
import com.springbook.view.user.LogoutController;

public class HandlerMapping {
	private Map<String, Controller> mappings;

	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/login.do", (Controller) new LoginController());
		mappings.put("/getBoardList.do", (Controller) new GetBoardListController());
		mappings.put("/getBoard.do", (Controller) new GetBoardController());
		mappings.put("/insertBoard.do", (Controller) new InsertBoardController());
		mappings.put("/updateBoard.do", (Controller) new UpdateBoardController());		
		mappings.put("/deleteBoard.do", (Controller) new DeleteBoardController());
		mappings.put("/logout.do", (Controller) new LogoutController());		
	}

	public Controller getController(String path) {
		return mappings.get(path);
	}
}

